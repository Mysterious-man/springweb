package com.acghome.service;

import com.acghome.entity.db1.Product_sku;
import com.acghome.mapper.db1.Product_skuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "product_skuService")
public class Product_skuServicelmpl implements  IProduct_skuService{


    @Autowired
    private Product_skuMapper product_skuMapper;



    @Override
    public Product_sku getSkuByid(int id) {
        return product_skuMapper.selectByPrimaryKey(id);
    }

    @Override
    public int addSku(Product_sku sku) {
        return product_skuMapper.insertSelective(sku);
    }
}
