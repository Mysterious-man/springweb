package com.acghome.pojo.DO;

import com.acghome.entity.db1.Mall;
import com.acghome.entity.db1.Product;
import com.acghome.entity.db1.Product_sku;

import java.io.Serializable;
import java.util.List;

/**
 * @author tmh
 * @version 1.0.0
 * @ClassName ProductAndSkuDO.java
 * @Description TODO
 * @createTime 2019年09月18日 17:25:00
 */
public class MallManageDO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Product product;


    private Mall mall;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Mall getMall() {
        return mall;
    }

    public void setMall(Mall mall) {
        this.mall = mall;
    }
}
