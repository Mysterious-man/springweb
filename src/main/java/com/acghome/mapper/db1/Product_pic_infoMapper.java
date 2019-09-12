package com.acghome.mapper.db1;

import com.acghome.entity.db1.Product_pic_info;
import com.acghome.entity.db1.Product_pic_infoExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Product_pic_infoMapper {
    int countByExample(Product_pic_infoExample example);

    int deleteByExample(Product_pic_infoExample example);

    int deleteByPrimaryKey(Integer productPicId);

    int insert(Product_pic_info record);

    int insertSelective(Product_pic_info record);

    List<Product_pic_info> selectByExample(Product_pic_infoExample example);

    Product_pic_info selectByPrimaryKey(Integer productPicId);

    int updateByExampleSelective(@Param("record") Product_pic_info record, @Param("example") Product_pic_infoExample example);

    int updateByExample(@Param("record") Product_pic_info record, @Param("example") Product_pic_infoExample example);

    int updateByPrimaryKeySelective(Product_pic_info record);

    int updateByPrimaryKey(Product_pic_info record);
}