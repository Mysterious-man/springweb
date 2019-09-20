package com.acghome.service;

import com.acghome.entity.db1.Mall;
import com.acghome.entity.db2.Money;
import com.acghome.pojo.dto.accept.MallAddDTO;
import com.acghome.pojo.dto.export.MallManageListDTO;
import com.acghome.query.MallManageQuery;
import com.acghome.utils.Result;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * @author tmh
 * @version 1.0.0
 * @ClassName IMallService.java
 * @Description TODO
 * @createTime 2019年09月19日 18:08:00
 */
public interface IMallService  {

    Mall getMallById(int mall_id);

    Mall getMallByProduct(int product_id);

    Mall AddMall(MallAddDTO mallAddDTO);

    List<MallManageListDTO> getManageList(int limit, int offset, MallManageQuery query);

    int countManageList( MallManageQuery query);


}
