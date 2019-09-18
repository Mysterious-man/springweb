package com.acghome.pojo.DO;

import com.acghome.entity.db1.Product_pic_info;
import com.acghome.entity.db1.Product_sku;
import com.acghome.entity.db1.Sku_attribute;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SkuDetailDO implements Serializable {



    //sku_attribute表的value
    private Sku_attribute sku_attribute;

    //product_pic_infos表

    private Product_pic_info product_pic_info;


    private Product_sku product_sku;

    private static final long serialVersionUID = 1L;


    public Sku_attribute getSku_attribute() {
        return sku_attribute;
    }

    public void setSku_attribute(Sku_attribute sku_attribute) {
        this.sku_attribute = sku_attribute;
    }

    public Product_pic_info getProduct_pic_info() {
        return product_pic_info;
    }

    public void setProduct_pic_info(Product_pic_info product_pic_info) {
        this.product_pic_info = product_pic_info;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Product_sku getProduct_sku() {
        return product_sku;
    }

    public void setProduct_sku(Product_sku product_sku) {
        this.product_sku = product_sku;
    }
}