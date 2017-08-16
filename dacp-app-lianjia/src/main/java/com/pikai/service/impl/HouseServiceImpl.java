package com.pikai.service.impl;

import com.pikai.domain.HouseDomain;
import com.pikai.mapper.HouseMapper;
import com.pikai.mapper.IBaseMapper;
import com.pikai.service.HouseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 项目名称：dacp
 * 包名： com.pikai.service.impl
 * 类名称：
 * 类描述：
 * 创建人:   沃特
 * 创建时间：2017/05/2017/5/10 15:56
 */
@Service
public class HouseServiceImpl extends IBaseServiceImpl<HouseDomain>  implements HouseService {

    private static Logger logger = LoggerFactory.getLogger(HouseServiceImpl.class);

    @Resource
    private HouseMapper houseMapper;

    @Override
    public IBaseMapper<HouseDomain> getBaseMapper() {
        return houseMapper;
    }

}
