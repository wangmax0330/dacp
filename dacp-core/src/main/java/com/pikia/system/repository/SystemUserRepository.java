package com.pikia.system.repository;

import java.util.Date;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import com.pikia.component.repository.ModelRepository;
import com.pikia.system.domain.SystemUserDomain;

public interface SystemUserRepository extends ModelRepository {
	@Select("SELECT * FROM SYS_USER WHERE ID=#{uid} and DELFLAG=0")
	@Results(value = {
			@Result(property = "userName", column = "USER_NAME", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "password", column = "PASSWORD", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "createTime", column = "CREATE_TIME", javaType = Date.class, jdbcType = JdbcType.TIMESTAMP),
			@Result(property = "email", column = "EMAIL", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "mobile", column = "MOBILE", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "photo", column = "PHOTO", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "role", column = "ROLE", javaType = Integer.class, jdbcType = JdbcType.INTEGER) })
	public SystemUserDomain get(@Param("uid") Long id);

	@Insert("INSERT INTO SYS_USER(DELFLAG,MOBILE,PASSWORD,ROLE,CREATE_TIME,EMAIL,USER_NAME,PHOTO,)  values(#{delflag},#{mobile},#{password},#{role},#{createTime},#{email},#{userName},#{photo})")
	@Options(keyProperty = "id", useGeneratedKeys = true)
	public Object save(@Param("user") SystemUserDomain user);

	@Update("UPDATE SYS_USER SET DELFLAG=#{delflag},MOBILE=#{mobile},PASSWORD=#{password},ROLE=${role},CREATE_TIME=#{createTime},EMAIL=#{email},USER_NAME=#{userName},PHOTO=#{photo}, where ID=#{id}")
	public Object update(@Param("user") SystemUserDomain user);

	@Select("SELECT ID FROM SYS_USER WHERE DELFLAG=0 and  ( EMAIL=#{uid} or MOBILE=#{uid}) and PASSWORD=#{pwd}  LIMIT 1")
	public Long authUser(@Param("uid") String uid, @Param("pwd") String pwd);
}
