package com.acghome.controller;



import com.acghome.pojo.dto.GetProductEditDTO;
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
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.TimeUnit;


@Controller
@RequestMapping("/product")
public class ProductController {

    private final static Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;


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


    //分类管理页
    @RequestMapping("/Products")
    public String products(Model model) {
        model.addAttribute("user",UserContext.getUser());
        return "system/Products";
    }

    //商品管理
    @RequestMapping("/Brand_Manage")
    public String Brand_Manage(Model model) {
        model.addAttribute("user",UserContext.getUser());
        return "system/Brand_Manage";
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

        Integer product_id= (int) request_data.get("product_id");
        String product_key="GetProductAndSkuEdit_product_id_"+product_id.toString();

        Object productAndSkuInfo = redisTemplate.opsForValue().get(product_key);


        if (productAndSkuInfo!=null) {

                if (productAndSkuInfo.getClass().isInstance("") && (String)productAndSkuInfo==""){
                    return ResultGenerator.genFailResult("该产品id不存在");
                }

                return ResultGenerator.genSuccessResult(productAndSkuInfo);

        } else {

            GetProductEditDTO result_data = productService.getProductAndSku(product_id);

            if (result_data.getProduct() == null) {

                redisTemplate.opsForValue().set(product_key,"",15, TimeUnit.SECONDS);
                return ResultGenerator.genFailResult("该产品id不存在");
            }


            redisTemplate.opsForValue().set(product_key,result_data);

            return ResultGenerator.genSuccessResult(result_data);

        }



    }





}

