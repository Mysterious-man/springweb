package com.acghome.mapper.db1.join;

import com.acghome.pojo.DO.ProductDetail;
import com.acghome.pojo.DO.SkuDetail;


import java.util.List;

public interface GetProductDetailMapper {


    //查询product表和product_attribute表和product_pic_info表
    public ProductDetail selectProductDetail(Integer productId);


    //查询product_sku表和sku_attribute表和sku_id对应的product_pic_infos表内容
    public List<SkuDetail> selectSkusDetail(Integer productId);


}