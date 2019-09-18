package com.acghome.controller;



import com.acghome.pojo.dto.GetProductEditDTO;
import com.acghome.pojo.dto.ProductAddDTO;
import com.acghome.service.*;
import com.acghome.service.mq.Producer;
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

import static com.acghome.conf.Constant.PRODUCT_KEY_1;


@Controller
@RequestMapping("/product")
public class ProductController {

    private final static Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;


    @Autowired
    private IProductService productService;

    @Autowired
    Producer producer;




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


        //更新产品和sku后，同时通过消息队列更新缓存
        String product_id= String.valueOf(productUpdateDTO.getProduct().getProductId());
        String product_key=PRODUCT_KEY_1+ product_id;
        producer.productChangeSend(product_key,product_id);

        return ResultGenerator.genSuccessResult(result_data);

    }

    @ResponseBody
    @RequestMapping(value = "/get",method = RequestMethod.POST )
    public Result GetProductAndSkuEdit(@RequestBody Map<String,Object> request_data) {

        Integer product_id= (int) request_data.get("product_id");
        String product_key=PRODUCT_KEY_1+product_id.toString();

        Object productAndSkuInfo = redisTemplate.opsForValue().get(product_key);

        //为防止redis击穿， product_id数据库查不到时，redis存生命周期很短的key,值为空字符串
        if (productAndSkuInfo!=null) {

                if (productAndSkuInfo.getClass().isInstance("") && (String)productAndSkuInfo==""){
                    return ResultGenerator.genFailResult("该产品id不存在");
                }

                return ResultGenerator.genSuccessResult(productAndSkuInfo);

        } else {

            logger.info("没有缓存，设置该缓存 product_key"+product_key);
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

