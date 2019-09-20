package com.acghome.mapper.db1.join;

import com.acghome.pojo.DO.MallManageDO;
import com.acghome.query.MallManageQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author tmh
 * @version 1.0.0
 * @ClassName MallManageMapper.java
 * @Description TODO
 * @createTime 2019年09月19日 20:57:00
 */
public interface MallManageMapper {

    public int countManageList(@Param("query") MallManageQuery query);

    public List<MallManageDO> getManageList(@Param("limit") int limit, @Param("offset") int offset, @Param("query") MallManageQuery query);

}
