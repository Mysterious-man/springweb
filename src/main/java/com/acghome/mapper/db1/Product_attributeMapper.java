package com.acghome.mapper.db1;

import com.acghome.entity.db1.Product_attribute;
import com.acghome.entity.db1.Product_attributeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Product_attributeMapper {
    int countByExample(Product_attributeExample example);

    int deleteByExample(Product_attributeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Product_attribute record);

    int insertSelective(Product_attribute record);

    List<Product_attribute> selectByExample(Product_attributeExample example);

    Product_attribute selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Product_attribute record, @Param("example") Product_attributeExample example);

    int updateByExample(@Param("record") Product_attribute record, @Param("example") Product_attributeExample example);

    int updateByPrimaryKeySelective(Product_attribute record);

    int updateByPrimaryKey(Product_attribute record);
}