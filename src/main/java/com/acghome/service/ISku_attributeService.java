package com.acghome.service;

import com.acghome.entity.db1.Sku_attribute;

import java.util.List;

public interface ISku_attributeService {
    List<Sku_attribute> getSku_attribute(int sku_id);
    int addSku_attribute(Sku_attribute sku_attribute);
}
