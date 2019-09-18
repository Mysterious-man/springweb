package com.acghome.pojo.dto.export;

import com.acghome.pojo.DO.ProductDetailDO;
import com.acghome.pojo.DO.SkuDetailDO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;



/*
* 后台商品编辑时信息获取
*
* */

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetProductEditDTO implements Serializable {


    @NotNull
    private ProductDetailDO product;

    @NotNull
    private List<SkuDetailDO> skus;


    public ProductDetailDO getProduct() {
        return product;
    }

    public void setProduct(ProductDetailDO product) {
        this.product = product;
    }

    public List<SkuDetailDO> getSkus() {
        return skus;
    }

    public void setSkus(List<SkuDetailDO> skus) {
        this.skus = skus;
    }

    @Override
    public String toString() {
        return "GetProductEditDTO{" +
                "product=" + product +
                ", skus=" + skus +
                '}';
    }
}

