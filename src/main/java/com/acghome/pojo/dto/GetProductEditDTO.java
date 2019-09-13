package com.acghome.pojo.dto;

import com.acghome.entity.db1.Product;
import com.acghome.entity.db1.Product_attribute;
import com.acghome.entity.db1.Product_pic_info;
import com.acghome.pojo.DO.ProductDetail;
import com.acghome.pojo.DO.SkuDetail;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class GetProductEditDTO implements Serializable {


    @NotNull
    private ProductDetail product;

    @NotNull
    private List<SkuDetail> skus;


    public ProductDetail getProduct() {
        return product;
    }

    public void setProduct(ProductDetail product) {
        this.product = product;
    }

    public List<SkuDetail> getSkus() {
        return skus;
    }

    public void setSkus(List<SkuDetail> skus) {
        this.skus = skus;
    }
}

