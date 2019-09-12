package com.acghome.service;

import com.acghome.entity.db1.Product_sku;

public interface IProduct_skuService {

    Product_sku getSkuByid(int id);
    int addSku(Product_sku sku);

}
