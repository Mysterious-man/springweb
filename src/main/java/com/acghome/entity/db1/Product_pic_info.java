package com.acghome.entity.db1;

import java.io.Serializable;
import java.util.Date;

public class Product_pic_info implements Serializable {
    private Integer productPicId;

    private Integer productId;

    private Integer skuId;

    private String picDesc;

    private String picUrl;

    private Integer isMaster;

    private Integer picOrder;

    private Integer picStatus;

    private Date modifiedTime;

    private static final long serialVersionUID = 1L;

    public Integer getProductPicId() {
        return productPicId;
    }

    public void setProductPicId(Integer productPicId) {
        this.productPicId = productPicId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public String getPicDesc() {
        return picDesc;
    }

    public void setPicDesc(String picDesc) {
        this.picDesc = picDesc == null ? null : picDesc.trim();
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }

    public Integer getIsMaster() {
        return isMaster;
    }

    public void setIsMaster(Integer isMaster) {
        this.isMaster = isMaster;
    }

    public Integer getPicOrder() {
        return picOrder;
    }

    public void setPicOrder(Integer picOrder) {
        this.picOrder = picOrder;
    }

    public Integer getPicStatus() {
        return picStatus;
    }

    public void setPicStatus(Integer picStatus) {
        this.picStatus = picStatus;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}