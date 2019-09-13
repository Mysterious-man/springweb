package com.acghome.pojo.DO;

import com.acghome.entity.db1.Product_attribute;
import com.acghome.entity.db1.Product_pic_info;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class ProductDetail implements Serializable {
    private Integer productId;

    private String productCore;

    private String productName;

    private String barCode;

    private String brandName;

    private Integer oneCategoryId;

    private Integer twoCategoryId;

    private Integer threeCategoryId;

    private BigDecimal price;

    private BigDecimal originalPrice;

    private Integer status;

    private Date productionDate;

    private Integer shelfLife;

    private Date indate;

    private Date modifiedTime;

    private String descript;

    private static final long serialVersionUID = 1L;

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

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductCore() {
        return productCore;
    }

    public void setProductCore(String productCore) {
        this.productCore = productCore == null ? null : productCore.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode == null ? null : barCode.trim();
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName == null ? null : brandName.trim();
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

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public Integer getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(Integer shelfLife) {
        this.shelfLife = shelfLife;
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
        this.descript = descript == null ? null : descript.trim();
    }
}