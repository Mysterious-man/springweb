package com.acghome.service;

import com.acghome.mapper.db1.Product_attributeMapper;
import com.acghome.entity.db1.Product_attribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "product_attributeService")
public class Product_attributeServiceImpl implements IProduct_attributeService{


    @Autowired
    private Product_attributeMapper product_attributeMapper;

    @Override
    public Product_attribute getProduct_attributeById(int id) {
        return product_attributeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int addProduct_attribute(Product_attribute product_attribute) {

        return product_attributeMapper.insert(product_attribute);
    }
}
