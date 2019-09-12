package com.acghome.service;

import com.acghome.entity.db1.Sku_attribute;
import com.acghome.entity.db1.Sku_attributeExample;
import com.acghome.mapper.db1.Sku_attributeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service(value = "sku_attributeService")
public class Sku_attributeServicelmpl implements ISku_attributeService{

    @Autowired
    private Sku_attributeMapper sku_attributeMapper;


    @Override
    public List<Sku_attribute> getSku_attribute(int sku_id) {

        Sku_attributeExample example=new Sku_attributeExample();
        example.or().andSkuIdEqualTo(sku_id);

        return sku_attributeMapper.selectByExample(example);
    }

    @Override
    public int addSku_attribute(Sku_attribute sku_attribute) {
        return sku_attributeMapper.insertSelective(sku_attribute);
    }


}
