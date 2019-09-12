package com.acghome.mapper.db1;

import com.acghome.entity.db1.Product_sku;
import com.acghome.entity.db1.Product_skuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Product_skuMapper {
    int countByExample(Product_skuExample example);

    int deleteByExample(Product_skuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Product_sku record);

    int insertSelective(Product_sku record);

    List<Product_sku> selectByExample(Product_skuExample example);

    Product_sku selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Product_sku record, @Param("example") Product_skuExample example);

    int updateByExample(@Param("record") Product_sku record, @Param("example") Product_skuExample example);

    int updateByPrimaryKeySelective(Product_sku record);

    int updateByPrimaryKey(Product_sku record);
}