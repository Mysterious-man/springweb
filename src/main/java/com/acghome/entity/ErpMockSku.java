package com.acghome.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class ErpMockSku implements Serializable {

    private BigDecimal Average= BigDecimal.valueOf(20.5);
    private Integer Stock=30;

    public BigDecimal getAverage() {
        return Average;
    }

    public void setAverage(BigDecimal average) {
        Average = average;
    }

    public Integer getStock() {
        return Stock;
    }

    public void setStock(Integer stock) {
        Stock = stock;
    }
}
