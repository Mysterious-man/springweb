package com.acghome.service;

import com.acghome.pojo.dto.export.GetProductEditDTO;
import com.acghome.pojo.dto.accept.ProductAddDTO;
import com.acghome.pojo.dto.accept.ProductUpdateDTO;
import com.acghome.entity.db1.Product;
import com.acghome.pojo.dto.export.ProductAndSkuDTO;

import java.util.List;
import java.util.Map;

public interface IProductService {

    Product getProductById(int id);

    int addProduct(Product product);


    int update(Product product);


    public GetProductEditDTO getProductAndSku(int product_id);


    public Map<String, Object> addProductAndSku(ProductAddDTO productAddbean);


    public Map<String, Object> updateProductAndSku(ProductUpdateDTO productUpdateDTO);

    public List<ProductAndSkuDTO> getProductAndSkulist(int offset, int limit);


}
