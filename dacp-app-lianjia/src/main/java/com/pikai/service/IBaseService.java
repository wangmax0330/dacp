package com.pikai.service;

import java.util.List;

/**
 * 项目名称：dacp
 * 包名： com.pikai.service
 * 类名称：
 * 类描述：
 * 创建人:   沃特
 * 创建时间：2017/05/2017/5/10 16:19
 */
public interface IBaseService<T> {

    //	@RedisEvict(type = Object.class)
    int deleteByPrimaryKey(Object id) throws Exception;

    //	@RedisEvict(type = Object.class)
    int insert(T po) throws Exception;

    //	@RedisEvict(type = Object.class)
    int insertSelective(T po) throws Exception;

    //    @RedisCache(type = Object.class, result = RESULT_TYPE_SINGLE)
    T selectByPrimaryKey(Object id) throws Exception;

    //    @RedisEvict(type = Object.class)
    int updateByPrimaryKeySelective(T po) throws Exception;

    //    @RedisEvict(type = Object.class)
    int updateByPrimaryKey(T po) throws Exception;

    /** 条件查询 */
    List<T> selectByCondition(T condition) throws Exception;

    int updateByIdsSelective(T po, List ids) throws Exception;

}
