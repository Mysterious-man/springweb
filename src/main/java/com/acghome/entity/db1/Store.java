package com.acghome.entity.db1;

import java.io.Serializable;
import java.util.Date;

public class Store implements Serializable {
    private Integer storeId;

    private String storeName;

    private Date storeStartTime;

    private Date storeEndTime;

    private Integer storeType;

    private Date modifiedTime;

    private static final long serialVersionUID = 1L;

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName == null ? null : storeName.trim();
    }

    public Date getStoreStartTime() {
        return storeStartTime;
    }

    public void setStoreStartTime(Date storeStartTime) {
        this.storeStartTime = storeStartTime;
    }

    public Date getStoreEndTime() {
        return storeEndTime;
    }

    public void setStoreEndTime(Date storeEndTime) {
        this.storeEndTime = storeEndTime;
    }

    public Integer getStoreType() {
        return storeType;
    }

    public void setStoreType(Integer storeType) {
        this.storeType = storeType;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}