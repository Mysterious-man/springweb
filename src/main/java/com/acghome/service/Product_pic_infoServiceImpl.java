package com.acghome.service;

import com.acghome.mapper.db1.Product_pic_infoMapper;
import com.acghome.entity.db1.Product_pic_info;
import com.acghome.entity.db1.Product_pic_infoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "product_pic_infoService")
public class Product_pic_infoServiceImpl implements IProduct_pic_infoService{

    @Autowired
    private Product_pic_infoMapper product_pic_infoMapper;



    @Override
    public List<Product_pic_info> getProduct_picBypid(int productid) {

        Product_pic_infoExample example=new Product_pic_infoExample();
        example.or().andProductIdEqualTo(productid);

        return product_pic_infoMapper.selectByExample(example);
    }


    @Override
    public int addProduct_pic(Product_pic_info product_pic_info) {

        product_pic_infoMapper.insertSelective(product_pic_info);

        return 0;
    }
}
