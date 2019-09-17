package com.acghome.service;

import com.acghome.pojo.dto.GetProductEditDTO;
import com.acghome.pojo.dto.ProductAddDTO;
import com.acghome.pojo.dto.ProductUpdateDTO;
import com.acghome.entity.db1.Product;

import java.util.Map;

public interface IProductService {

    Product getProductById(int id);

    int addProduct(Product product);


    int update(Product product);


    public GetProductEditDTO getProductAndSku(int product_id);


    public Map<String, Object> addProductAndSku(ProductAddDTO productAddbean);


    public Map<String, Object> updateProductAndSku(ProductUpdateDTO productUpdateDTO);




}
