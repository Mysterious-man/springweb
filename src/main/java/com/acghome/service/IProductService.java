package com.acghome.service;

import com.acghome.dto.ProductAddDTO;
import com.acghome.dto.ProductUpdateDTO;
import com.acghome.entity.db1.Product;

import java.util.Map;

public interface IProductService {

    Product getProductById(int id);

    int addProduct(Product product);


    int update(Product product);

    /**
     创建商品信息的接口，
     返回
    "data": {
        "product_id": 58,
        "sku_id": [144,145]
    }
     **/
    public Map<String, Object> addProductAndSku(ProductAddDTO productAddbean);


    public Map<String, Object> updateProductAndSku(ProductUpdateDTO productUpdateDTO);


}
