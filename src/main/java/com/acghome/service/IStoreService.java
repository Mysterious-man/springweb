package com.acghome.service;

import com.acghome.entity.db1.Mall;
import com.acghome.entity.db1.Store;
import com.acghome.entity.db1.StoreExample;
import com.acghome.mapper.db1.BaseMapper;
import com.acghome.pojo.dto.accept.MallAddDTO;
import com.acghome.pojo.dto.export.MallManageListDTO;
import com.acghome.query.MallManageQuery;
import com.acghome.query.StoreManageQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author tmh
 * @version 1.0.0
 * @ClassName IMallService.java
 * @Description TODO
 * @createTime 2019年09月19日 18:08:00
 */
public interface IStoreService extends BaseService<Store,StoreManageQuery> {

    int del(Integer id);

    String saveOrUpdate(Store store);





}
