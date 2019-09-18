package com.acghome.pojo.dto.export;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/*
*
* 后台商品管理列表的分页查询
* */

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductAndSkuDTO implements Serializable {


    private Integer productId;

    private String productName;

    private String brandName;

    private Integer oneCategoryId;

    private Integer twoCategoryId;

    private Integer threeCategoryId;

    private BigDecimal price;

    private BigDecimal originalPrice;

    private Integer status;

    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date indate;

    private Date modifiedTime;

    private String descript;





    @NotNull
    private List<SkuBean> skus;


    public List<SkuBean> getSkus() {
        return skus;
    }

    public void setSkus(List<SkuBean> skus) {
        this.skus = skus;
    }


    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Integer getOneCategoryId() {
        return oneCategoryId;
    }

    public void setOneCategoryId(Integer oneCategoryId) {
        this.oneCategoryId = oneCategoryId;
    }

    public Integer getTwoCategoryId() {
        return twoCategoryId;
    }

    public void setTwoCategoryId(Integer twoCategoryId) {
        this.twoCategoryId = twoCategoryId;
    }

    public Integer getThreeCategoryId() {
        return threeCategoryId;
    }

    public void setThreeCategoryId(Integer threeCategoryId) {
        this.threeCategoryId = threeCategoryId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getIndate() {
        return indate;
    }

    public void setIndate(Date indate) {
        this.indate = indate;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public static class SkuBean {


        private Integer id;


        private BigDecimal price;



        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }



        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }


    }




}
