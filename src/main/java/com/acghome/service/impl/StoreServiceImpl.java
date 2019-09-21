package com.acghome.service.impl;



import com.acghome.entity.db1.Store;
import com.acghome.mapper.db1.StoreMapper;
import com.acghome.mapper.db1.join.StoreManageMapper;
import com.acghome.query.StoreManageQuery;

import com.acghome.service.IStoreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;


/**
 * @author tmh
 * @version 1.0.0
 * @ClassName MallServiceimpl.java
 * @Description TODO
 * @createTime 2019年09月19日 18:10:00
 */


@Service(value = "storeService")
public class StoreServiceImpl extends BaseServiceImpl<Store,StoreManageQuery> implements IStoreService {

    @Autowired
    private StoreMapper storeMapper;


    @Override
    public int del(Integer id) {
        return storeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public String saveOrUpdate(Store store) {
        if (StringUtils.isEmpty(store.getStoreId())){
            storeMapper.insertSelective(store);
            return "添加成功";
        }else{
            storeMapper.updateByPrimaryKeySelective(store);
            return "修改成功";
        }

    }

}
