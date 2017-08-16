package com.pikai.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 项目名称：dacp
 * 包名： com.pikai.mapper
 * 类名称：
 * 类描述：
 * 创建人:   沃特
 * 创建时间：2017/05/2017/5/10 15:59
 */
public interface IBaseMapper<T> {
    int deleteByPrimaryKey(Object id);

    int insert(T po);

    int insertSelective(T po);

    T selectByPrimaryKey(Object id);

    int updateByPrimaryKeySelective(T po);

    int updateByPrimaryKey(T po);

    int selectId(String name);

    List<T> selectByCondition(T condition);

    int updateByIdsSelective(@Param("po")T po, @Param("ids")List<String> ids);

}
