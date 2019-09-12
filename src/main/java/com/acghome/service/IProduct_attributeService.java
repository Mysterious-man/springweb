package com.acghome.service;

import com.acghome.entity.db1.Product_attribute;

public interface IProduct_attributeService {

    Product_attribute getProduct_attributeById(int id);

    int addProduct_attribute(Product_attribute product_attribute);
}
