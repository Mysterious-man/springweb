package com.acghome.service;

import com.acghome.entity.db1.Product_pic_info;

import java.util.List;

public interface IProduct_pic_infoService {

    List<Product_pic_info> getProduct_picBypid(int productid);
    int addProduct_pic(Product_pic_info product_pic_info);

}
