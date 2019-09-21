package com.acghome.mapper.db1.join;

import com.acghome.entity.db1.Store;
import com.acghome.mapper.db1.BaseMapper;
import com.acghome.pojo.DO.MallManageDO;
import com.acghome.query.MallManageQuery;
import com.acghome.query.StoreManageQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author tmh
 * @version 1.0.0
 * @ClassName MallManageMapper.java
 * @Description TODO
 * @createTime 2019年09月19日 20:57:00
 */
public interface StoreManageMapper extends BaseMapper<Store,StoreManageQuery> {


}
