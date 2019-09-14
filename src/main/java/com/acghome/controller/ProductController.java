package com.acghome.controller;



import com.acghome.pojo.dto.ProductAddDTO;
import com.acghome.service.*;
import com.acghome.utils.ApiValidator;
import com.acghome.pojo.dto.ProductUpdateDTO;
import com.acghome.utils.Result;
import com.acghome.utils.ResultGenerator;
import com.acghome.utils.UserContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Controller
@RequestMapping("/product")
public class ProductController {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);


    @Autowired
    private IProductService productService;

    @Autowired
    private IProduct_attributeService product_attributeService;

    @Autowired
    private IProduct_pic_infoService product_pic_infoService;

    @Autowired
    private IProduct_skuService product_skuService;

    @Autowired
    private ISku_attributeService sku_attributeService;


    //商品页
    @RequestMapping("/add_product")
    public String goProductPage(Model model) {
        model.addAttribute("user", UserContext.getUser());

        return "system/add_product";
    }





    @ResponseBody
    @RequestMapping(value = "/add",method = RequestMethod.POST )
    public Result addProductAndSku(@RequestBody @Validated ProductAddDTO productAddbean, BindingResult bindingResult) {

        ApiValidator.validate_field(bindingResult);

        Object result_data=productService.addProductAndSku(productAddbean);

        return ResultGenerator.genSuccessResult(result_data);

    }



    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST )
    public Result updateProductAndSku(@RequestBody @Validated ProductUpdateDTO productUpdateDTO, BindingResult bindingResult) {

        ApiValidator.validate_field(bindingResult);

        logger.info("update");

        Object result_data=productService.updateProductAndSku(productUpdateDTO);

        return ResultGenerator.genSuccessResult(result_data);

    }

    @ResponseBody
    @RequestMapping(value = "/get",method = RequestMethod.POST )
    public Result GetProductAndSkuEdit(@RequestBody Map<String,Object> request_data) {

        int product_id= (int) request_data.get("product_id");

        Object result_data = productService.getProductAndSku(product_id);


        return ResultGenerator.genSuccessResult(result_data);

    }





}

