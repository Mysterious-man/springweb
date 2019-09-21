package com.acghome.pojo.dto.accept;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author tmh
 * @version 1.0.0
 * @ClassName MallAddDTO.java
 * @Description TODO
 * @createTime 2019年09月19日 18:15:00
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MallAddDTO {


    /**
     * product_id : 20
     * product_name : 商城产品名称
     */
    @NotNull
    private Integer product_id;

    private String product_name;

    private Integer publish_status;

    private Integer audit_status;

    private BigDecimal original_price;

    private Integer type;

    private Date expire_time;

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getPublish_status() {
        return publish_status;
    }

    public void setPublish_status(Integer publish_status) {
        this.publish_status = publish_status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getAudit_status() {
        return audit_status;
    }

    public void setAudit_status(Integer audit_status) {
        this.audit_status = audit_status;
    }

    public BigDecimal getOriginal_price() {
        return original_price;
    }

    public void setOriginal_price(BigDecimal original_price) {
        this.original_price = original_price;
    }

    public Date getExpire_time() {
        return expire_time;
    }

    public void setExpire_time(Date expire_time) {
        this.expire_time = expire_time;
    }
}
