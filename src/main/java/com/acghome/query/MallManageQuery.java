package com.acghome.query;

import java.io.Serializable;
import java.util.Date;

/**
 * @author tmh
 * @version 1.0.0
 * @ClassName MallManageQuery.java
 * @Description TODO
 * @createTime 2019年09月19日 19:25:00
 */
public class MallManageQuery  implements Serializable {

    private Integer mallId;

    private Integer productId;

    private Integer storeId;

    private String productName;

    private Integer publishStatus;

    private Integer auditStatus;

    private Date createTime;

    public Integer getMallId() {
        return mallId;
    }

    public void setMallId(Integer mallId) {
        this.mallId = mallId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getPublishStatus() {
        return publishStatus;
    }

    public void setPublishStatus(Integer publishStatus) {
        this.publishStatus = publishStatus;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
