package com.pikai.service.impl;

import com.pikai.mapper.IBaseMapper;
import com.pikai.service.IBaseService;

import java.util.List;

/**
 * 项目名称：dacp
 * 包名： com.pikai.service.impl
 * 类名称：
 * 类描述：
 * 创建人:   沃特
 * 创建时间：2017/05/2017/5/10 16:21
 */
public  abstract class IBaseServiceImpl<T> implements IBaseService<T> {

    public abstract IBaseMapper<T> getBaseMapper();

    @Override
    public int deleteByPrimaryKey(Object id) throws Exception {
        return getBaseMapper().deleteByPrimaryKey(id);
    }

    @Override
    public int insert(T po) throws Exception {
        return getBaseMapper().insert(po);
    }

    @Override
    public int insertSelective(T po) throws Exception {
        return getBaseMapper().insertSelective(po);
    }

    @Override
    public T selectByPrimaryKey(Object id) throws Exception {
        return getBaseMapper().selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(T po) throws Exception {
        return getBaseMapper().updateByPrimaryKeySelective(po);
    }

    @Override
    public int updateByPrimaryKey(T po) throws Exception {
        return getBaseMapper().updateByPrimaryKey(po);
    }

    @Override
    public List<T> selectByCondition(T condition) throws Exception {
        return getBaseMapper().selectByCondition(condition);
    }

    @Override
    public int updateByIdsSelective(T po, List ids) throws Exception {
        return getBaseMapper().updateByIdsSelective(po, ids);
    }

}

