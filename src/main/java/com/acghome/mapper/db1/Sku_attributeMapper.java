package com.acghome.mapper.db1;

import com.acghome.entity.db1.Sku_attribute;
import com.acghome.entity.db1.Sku_attributeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Sku_attributeMapper {
    int countByExample(Sku_attributeExample example);

    int deleteByExample(Sku_attributeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Sku_attribute record);

    int insertSelective(Sku_attribute record);

    List<Sku_attribute> selectByExample(Sku_attributeExample example);

    Sku_attribute selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Sku_attribute record, @Param("example") Sku_attributeExample example);

    int updateByExample(@Param("record") Sku_attribute record, @Param("example") Sku_attributeExample example);

    int updateByPrimaryKeySelective(Sku_attribute record);

    int updateByPrimaryKey(Sku_attribute record);
}