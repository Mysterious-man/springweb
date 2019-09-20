package com.acghome.controller;

import com.acghome.entity.db1.Mall;
import com.acghome.entity.db1.Product;
import com.acghome.pojo.dto.accept.MallAddDTO;
import com.acghome.pojo.dto.export.MallManageListDTO;
import com.acghome.query.MallManageQuery;
import com.acghome.service.IMallService;
import com.acghome.service.IProductService;
import com.acghome.utils.ApiValidator;
import com.acghome.utils.Result;
import com.acghome.utils.ResultGenerator;
import com.acghome.utils.exception.RequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tmh
 * @version 1.0.0
 * @ClassName MallController.java
 * @Description TODO
 * @createTime 2019年09月19日 18:06:00
 */

@Controller
@RequestMapping("/mall")
public class MallController {

    private final static Logger logger = LoggerFactory.getLogger(MallController.class);



    @Autowired
    private IProductService productService;

    @Autowired
    private IMallService mallService;




    @ResponseBody
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Result addMall(@RequestBody @Validated MallAddDTO mallAddDTO, BindingResult bindingResult) {

        ApiValidator.validate_field(bindingResult);

        int product_id = mallAddDTO.getProduct_id();

        //判断该产品id
        Product productById = productService.getProductById(product_id);
        if (productById == null) {
            throw new RequestException("该产品id不存在");
        }

        //判断该产品id是否已有对应的商城
        Mall byProduct = mallService.getMallByProduct(product_id);
        if (byProduct != null) {
            throw new RequestException("该产品id已有对应的商城了");
        }

        Mall mall = mallService.AddMall(mallAddDTO);

        HashMap<String, Object> map = new HashMap<>();

        map.put("mallId",String.valueOf(mall.getMallId()));

        return ResultGenerator.genSuccessResult(map);

    }


    @ResponseBody
    @RequestMapping(value = "/manage_list",method = RequestMethod.GET)
    public Map getManageList(int limit, int offset,  MallManageQuery query,BindingResult bindingResult) {

        ApiValidator.validate_field(bindingResult);

        int total=mallService.countManageList(query);
        List<MallManageListDTO> mallManageList = mallService.getManageList(limit,offset,query);

        HashMap<String, Object> map = new HashMap<>();
        map.put("total",total);
        map.put("rows",mallManageList);

        return map;

    }



}
