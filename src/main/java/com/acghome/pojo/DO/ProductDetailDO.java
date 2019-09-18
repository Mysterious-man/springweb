package com.acghome.pojo.DO;

import com.acghome.entity.db1.Product;
import com.acghome.entity.db1.Product_attribute;
import com.acghome.entity.db1.Product_pic_info;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class ProductDetailDO implements Serializable {


    private static final long serialVersionUID = 1L;

    private Product product;

    private Product_attribute product_attribute;

    private List<Product_pic_info> product_pic_infoList;

    public Product_attribute getProduct_attribute() {
        return product_attribute;
    }

    public void setProduct_attribute(Product_attribute product_attribute) {
        this.product_attribute = product_attribute;
    }

    public List<Product_pic_info> getProduct_pic_infoList() {
        return product_pic_infoList;
    }

    public void setProduct_pic_infoList(List<Product_pic_info> product_pic_infoList) {
        this.product_pic_infoList = product_pic_infoList;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}