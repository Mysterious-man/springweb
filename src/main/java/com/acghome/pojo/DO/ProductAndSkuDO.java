package com.acghome.pojo.DO;

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
public class ProductAndSkuDO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Product product;

    private List<Product_sku> product_sku_List;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Product_sku> getProduct_sku_List() {
        return product_sku_List;
    }

    public void setProduct_sku_List(List<Product_sku> product_sku_List) {
        this.product_sku_List = product_sku_List;
    }
}
