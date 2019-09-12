package com.acghome.controller;



import com.acghome.dto.ProductAddDTO;
import com.acghome.service.*;
import com.acghome.utils.ApiValidator;
import com.acghome.dto.ProductUpdateDTO;
import com.acghome.utils.Result;
import com.acghome.utils.ResultGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
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




    @RequestMapping(value = "/add",method = RequestMethod.POST )
    public Result addProductAndSku(@RequestBody @Validated ProductAddDTO productAddbean, BindingResult bindingResult) {

        ApiValidator.validate_field(bindingResult);

        Object result_data=productService.addProductAndSku(productAddbean);

        return ResultGenerator.genSuccessResult(result_data);

    }


    @RequestMapping(value = "/update",method = RequestMethod.POST )
    public Result updateProductAndSku(@RequestBody @Validated ProductUpdateDTO productUpdateDTO, BindingResult bindingResult) {

        ApiValidator.validate_field(bindingResult);

        Object result_data=productService.updateProductAndSku(productUpdateDTO);

        return ResultGenerator.genSuccessResult(result_data);

    }

}

