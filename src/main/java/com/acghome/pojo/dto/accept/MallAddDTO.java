package com.acghome.pojo.dto.accept;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotNull;

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
    private int product_id;

    private String product_name;

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
}
