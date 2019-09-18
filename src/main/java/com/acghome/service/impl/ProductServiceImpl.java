package com.acghome.service.impl;

import com.acghome.mapper.db1.*;
import com.acghome.mapper.db1.join.GetProductDetailMapper;
import com.acghome.pojo.DO.ProductAndSkuDO;
import com.acghome.pojo.DO.ProductDetailDO;
import com.acghome.pojo.DO.SkuDetailDO;
import com.acghome.pojo.dto.export.GetProductEditDTO;
import com.acghome.pojo.dto.accept.ProductAddDTO;
import com.acghome.entity.db1.*;
import com.acghome.pojo.dto.accept.ProductUpdateDTO;
import com.acghome.entity.ErpMockSku;
import com.acghome.pojo.dto.export.ProductAndSkuDTO;
import com.acghome.query.BaseQuery;
import com.acghome.service.IProductService;
import com.acghome.utils.exception.RequestException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Service(value = "productService")
public class ProductServiceImpl implements IProductService {


    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private Product_attributeMapper product_attributeMapper;

    @Autowired
    private Product_pic_infoMapper product_pic_infoMapper;

    @Autowired
    private Product_skuMapper skuMapper;

    @Autowired
    private Sku_attributeMapper sku_attributeMapper;

    @Autowired
    private GetProductDetailMapper getProductDetailMapper;




    @Override
    public int update(Product product) {
        return productMapper.updateByPrimaryKeySelective(product);
    }

    @Override
    public Product getProductById(int id) {
        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    public int addProduct(Product product) {
        return productMapper.insert(product);
    }


    @Override
    public Map<String, Object> addProductAndSku(ProductAddDTO productAddbean){

        Map<String, Object> result_data = new HashMap<>();
        List<Integer> sku_list = new ArrayList<>();


        Product product=new Product();
        Product_attribute product_attribute=new Product_attribute();

        //存入产品信息主表
        BeanUtils.copyProperties(productAddbean.getProduct(),product);
        this.addProduct(product);

        //使用刚存入product表的主键 ProductId,存入产品属性表
        product_attribute.setProductId(product.getProductId());
        product_attribute.setValue(productAddbean.getProduct_attribute().getValue());
        product_attributeMapper.insertSelective(product_attribute);

        //存入产品图片
        for(ProductAddDTO.ProductPicInfoBean productPicInfoBean : productAddbean.getProduct_pic_infos()){

            Product_pic_info product_pic_info=new Product_pic_info();

            BeanUtils.copyProperties(productPicInfoBean,product_pic_info);
            product_pic_info.setProductId(product.getProductId());

            product_pic_infoMapper.insertSelective(product_pic_info);
        }

        //存入产品下的sku、sku属性、sku的图片
        for(ProductAddDTO.SkuBean skuBean : productAddbean.getSkus()){


            Product_sku sku=new Product_sku();
            Sku_attribute sku_attribute=new Sku_attribute();



            BeanUtils.copyProperties(skuBean,sku);

            sku.setProductId(product.getProductId());

            //mork调用erp系统获取库存信息
            ErpMockSku erpMockSku = new ErpMockSku();


            sku.setStock(erpMockSku.getStock());
            sku.setAverage(erpMockSku.getAverage());
            skuMapper.insertSelective(sku);


            sku_attribute.setSkuId(sku.getId());
            sku_attribute.setValue(skuBean.getSku_attribute().getValue());
            sku_attributeMapper.insertSelective(sku_attribute);

            if (skuBean.getSku_pic_info().getPicUrl() != null) {

                Product_pic_info pic_info=new Product_pic_info();

                BeanUtils.copyProperties(skuBean.getSku_pic_info(),pic_info);
                pic_info.setProductId(product.getProductId());
                pic_info.setSkuId(sku.getId());

                product_pic_infoMapper.insertSelective(pic_info);

            }


            sku_list.add(sku.getId());
        }

        result_data.put("product_id",product.getProductId());
        result_data.put("sku_id",sku_list);

        return result_data;


    }

    @Override
    public Map<String, Object> updateProductAndSku(ProductUpdateDTO productUpdateDTO) {

        Map<String, Object> result_data = new HashMap<>();
        List<Integer> sku_list = new ArrayList<>();

        Product product=new Product();
        Product_attribute product_attribute=new Product_attribute();


        ProductUpdateDTO.ProductBean productDTO = productUpdateDTO.getProduct();

        //更新产品信息主表
        try {
            Integer product_id=productDTO.getProductId();
            this.getProductById(product_id).getProductId();
        } catch (Exception e) {
            throw new RequestException("产品id不存在");
        }

        BeanUtils.copyProperties(productDTO,product);
        this.update(product);

        //更新产品属性表
        product_attribute.setProductId(product.getProductId());
        product_attribute.setValue(productUpdateDTO.getProduct_attribute().getValue());

        Product_attributeExample example = new Product_attributeExample();
        example.or().andProductIdEqualTo(product.getProductId());

        product_attributeMapper.updateByExampleSelective(product_attribute,example);


        //更新产品图片
        List<ProductUpdateDTO.ProductPicInfoBean> product_pic_infos = productUpdateDTO.getProduct_pic_infos();
        if (!product_pic_infos.isEmpty()) {
            for( ProductUpdateDTO.ProductPicInfoBean productPicInfoBean : product_pic_infos){

                Product_pic_info product_pic_info=new Product_pic_info();

                BeanUtils.copyProperties(productPicInfoBean,product_pic_info);
                product_pic_info.setProductId(product.getProductId());

                Product_pic_infoExample product_pic_infoExample = new Product_pic_infoExample();

                product_pic_infoExample.or().andProductIdEqualTo(product.getProductId());

                product_pic_infoMapper.updateByExampleSelective(product_pic_info,product_pic_infoExample);
            }
        }


        //更新产品下的sku、sku属性、sku的图片
        if (!productUpdateDTO.getSkus().isEmpty()) {
            for(ProductUpdateDTO.SkuBean skuBean : productUpdateDTO.getSkus()){

                Product_sku sku=new Product_sku();

                Sku_attribute sku_attribute=new Sku_attribute();
                BeanUtils.copyProperties(skuBean,sku);
                skuMapper.updateByPrimaryKeySelective(sku);

                sku_attribute.setValue(skuBean.getSku_attribute().getValue());
                Sku_attributeExample example1 = new Sku_attributeExample();
                example1.or().andSkuIdEqualTo(sku.getId());
                sku_attributeMapper.updateByExampleSelective(sku_attribute,example1);


                if (skuBean.getSku_pic_info().getPicUrl() != null) {

                    Product_pic_info pic_info=new Product_pic_info();

                    BeanUtils.copyProperties(skuBean.getSku_pic_info(),pic_info);

                    Product_pic_infoExample pic_infoExample2 = new Product_pic_infoExample();
                    pic_infoExample2.or().andSkuIdEqualTo(sku.getId());
                    product_pic_infoMapper.updateByExampleSelective(pic_info,pic_infoExample2);

                }

                sku_list.add(sku.getId());
            }
        }

        result_data.put("product_id",product.getProductId());
        result_data.put("sku_id",sku_list);

        return result_data;
    }


    @Override
    public GetProductEditDTO getProductAndSku(int product_id) {

        ProductDetailDO productDetailDO =  getProductDetailMapper.selectProductDetail(product_id);

        List<SkuDetailDO> skuDetails = getProductDetailMapper.selectSkusDetail(product_id);

        GetProductEditDTO productEditDTO = new GetProductEditDTO();

        productEditDTO.setProduct(productDetailDO);

        productEditDTO.setSkus(skuDetails);

        return productEditDTO;
    }


    @Override
    public List<ProductAndSkuDTO> getProductAndSkulist(int offset, int limit) {

        List<ProductAndSkuDTO> DTO_list = new ArrayList<>();

        List<ProductAndSkuDO> productAndSkuDO_list = getProductDetailMapper.selectProductAndSku(offset,limit);

        for (ProductAndSkuDO productAndSkuDO : productAndSkuDO_list){

            Product product = productAndSkuDO.getProduct();
            List<Product_sku> sku_list = productAndSkuDO.getProduct_sku_List();
            ProductAndSkuDTO dto = new ProductAndSkuDTO();


            ProductAndSkuDTO.ProductBean productBean = dto.getProduct();
            BeanUtils.copyProperties(product,productBean);
            dto.setProduct(productBean);


            List<ProductAndSkuDTO.SkuBean> skus = dto.getSkus();
            for(Product_sku sku: sku_list){
                ProductAndSkuDTO.SkuBean skuBean = new ProductAndSkuDTO.SkuBean();
                skuBean.setId(sku.getId());
                skuBean.setPrice(sku.getPrice());
                skus.add(skuBean);
            }

            dto.setSkus(skus);


            DTO_list.add(dto);
        }

        return DTO_list;

    }
}
