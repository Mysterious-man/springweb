package com.acghome.pojo.dto.accept;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductAddDTO implements Serializable {

    @Override
    public String toString() {
        return "ProductAddDTO{" +
                "product=" + product +
                ", product_attribute=" + product_attribute +
                ", product_pic_infos=" + product_pic_infos +
                ", skus=" + skus +
                '}';
    }
    @NotNull
    @Valid
    private ProductBean product;
    @NotNull
    private ProductAttributeBean product_attribute;

    @NotNull
    @Valid
    public List<ProductPicInfoBean> product_pic_infos;

    @NotNull
    @NotEmpty
    @Valid
    public List<SkuBean> skus;

    public ProductBean getProduct() {
        return product;
    }

    public void setProduct(ProductBean product) {
        this.product = product;
    }

    public ProductAttributeBean getProduct_attribute() {
        return product_attribute;
    }

    public void setProduct_attribute(ProductAttributeBean product_attribute) {
        this.product_attribute = product_attribute;
    }

    public List<ProductPicInfoBean> getProduct_pic_infos() {
        return product_pic_infos;
    }

    public void setProduct_pic_infos(List<ProductPicInfoBean> product_pic_infos) {
        this.product_pic_infos = product_pic_infos;
    }

    public List<SkuBean> getSkus() {
        return skus;
    }

    public void setSkus(List<SkuBean> skus) {
        this.skus = skus;
    }

    public static class SkuBean {

        @NotNull
        private String skuCode;

        private BigDecimal price;

        private Integer lowStock;

        private String sp1;

        private String sp2;

        private String sp3;

        private Integer lockStock;


        private ProductPicInfoBean sku_pic_info;

        @NotNull
        private SkuAttribute sku_attribute;

        public SkuAttribute getSku_attribute() {
            return sku_attribute;
        }

        public void setSku_attribute(SkuAttribute sku_attribute) {
            this.sku_attribute = sku_attribute;
        }

        public String getSkuCode() {
            return skuCode;
        }

        public void setSkuCode(String skuCode) {
            this.skuCode = skuCode;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }

        public Integer getLowStock() {
            return lowStock;
        }

        public void setLowStock(Integer lowStock) {
            this.lowStock = lowStock;
        }

        public String getSp1() {
            return sp1;
        }

        public void setSp1(String sp1) {
            this.sp1 = sp1;
        }

        public String getSp2() {
            return sp2;
        }

        public void setSp2(String sp2) {
            this.sp2 = sp2;
        }

        public String getSp3() {
            return sp3;
        }

        public void setSp3(String sp3) {
            this.sp3 = sp3;
        }

        public Integer getLockStock() {
            return lockStock;
        }

        public void setLockStock(Integer lockStock) {
            this.lockStock = lockStock;
        }

        public ProductPicInfoBean getSku_pic_info() {
            return sku_pic_info;
        }

        public void setSku_pic_info(ProductPicInfoBean sku_pic_info) {
            this.sku_pic_info = sku_pic_info;
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public class SkuAttribute {
            private String value;

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }
        }

        @Override
        public String toString() {
            return "SkuBean{" +
                    "skuCode='" + skuCode + '\'' +
                    ", price=" + price +
                    ", lowStock=" + lowStock +
                    ", sp1='" + sp1 + '\'' +
                    ", sp2='" + sp2 + '\'' +
                    ", sp3='" + sp3 + '\'' +
                    ", lockStock=" + lockStock +
                    ", sku_pic_info=" + sku_pic_info +
                    ", sku_attribute=" + sku_attribute +
                    '}';
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ProductPicInfoBean {
        /**
         * picUrl : 图片URL
         * isMaster: 是否主图：0.非主图1.主图
         * picDesc: 图片描述
         * picOrder: 图片排序
         */

        private String picDesc;

        @NotNull
        @NotBlank
        private String picUrl;

        private Integer isMaster;

        private Integer picOrder;

        private Integer picStatus=1;

        public String getPicDesc() {
            return picDesc;
        }

        public void setPicDesc(String picDesc) {
            this.picDesc = picDesc;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
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
    }



    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ProductBean {
        /**
         * product_core : x222333444
         * product_name : 我是商品名称
         * bar_code : tmp
         * brand_name : 我是品牌名
         * one_category_id : 233
         * two_category_id : 0
         * three_category_id : 0
         * price : 200.2
         * original_price : 120.2
         * status : 0
         * production_date : 2019-06-10
         * shelf_life : 12
         * descript : ok de
         * indate : 2019-09-10 15:46:30
         */
        private Integer productId;

        private String productCore;

        @NotNull
        private String productName;

        private String barCode;

        private String brandName;

        private Integer oneCategoryId;

        private Integer twoCategoryId;

        private Integer threeCategoryId;

        @NotNull
        private BigDecimal price;

        private BigDecimal originalPrice;

        private Integer status;

        private Date productionDate;

        private Integer shelfLife;

        @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
        private Date indate;

        private Date modifiedTime;

        private String descript;

        private static final long serialVersionUID = 1L;

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

        @Override
        public String toString() {
            return "Product{" +
                    "productId=" + productId +
                    ", productCore='" + productCore + '\'' +
                    ", productName='" + productName + '\'' +
                    ", barCode='" + barCode + '\'' +
                    ", brandName='" + brandName + '\'' +
                    ", oneCategoryId=" + oneCategoryId +
                    ", twoCategoryId=" + twoCategoryId +
                    ", threeCategoryId=" + threeCategoryId +
                    ", price=" + price +
                    ", originalPrice=" + originalPrice +
                    ", status=" + status +
                    ", productionDate=" + productionDate +
                    ", shelfLife=" + shelfLife +
                    ", indate=" + indate +
                    ", modifiedTime=" + modifiedTime +
                    ", descript='" + descript + '\'' +
                    '}';
        }
    }


    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ProductAttributeBean {
        /**
         * value : {}
         */

        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
