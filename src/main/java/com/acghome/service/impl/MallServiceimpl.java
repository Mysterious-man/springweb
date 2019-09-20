package com.acghome.service.impl;

import com.acghome.entity.db1.Mall;
import com.acghome.entity.db1.MallExample;
import com.acghome.mapper.db1.MallMapper;
import com.acghome.mapper.db1.join.MallManageMapper;
import com.acghome.pojo.DO.MallManageDO;
import com.acghome.pojo.dto.accept.MallAddDTO;
import com.acghome.pojo.dto.export.MallManageListDTO;
import com.acghome.query.MallManageQuery;
import com.acghome.service.IMallService;
import com.acghome.utils.Result;
import com.acghome.utils.ResultGenerator;
import com.acghome.utils.exception.ApiException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author tmh
 * @version 1.0.0
 * @ClassName MallServiceimpl.java
 * @Description TODO
 * @createTime 2019年09月19日 18:10:00
 */


@Service(value = "mallService")
public class MallServiceimpl implements IMallService {


    @Autowired
    MallMapper mallMapper;

    @Autowired
    MallManageMapper mallManageMapper;


    @Override
    public Mall getMallById(int mall_id) {
        return mallMapper.selectByPrimaryKey(mall_id);
    }


    @Override
    public Mall getMallByProduct(int product_id) {

        MallExample mallExample = new MallExample();

        mallExample.or().andProductIdEqualTo(product_id);

        List<Mall> malls = mallMapper.selectByExample(mallExample);


        if (malls.isEmpty()) {
            return null;
        } else {
            return malls.get(0);
        }
    }


    @Override
    public Mall AddMall(MallAddDTO mallAddDTO) {

        Mall mall = new Mall();
        mall.setProductId(mallAddDTO.getProduct_id());
        mall.setProductName(mallAddDTO.getProduct_name());

        //暂时默认商品是已审核，且上架状态
        mall.setAuditStatus(1);
        mall.setPublishStatus(1);

        mallMapper.insertSelective(mall);

        Integer mallId=mall.getMallId();
        if (mallId==null) {
                throw new ApiException("创建商城失败");
        } else {

                return mall;
        }
    }


    @Override
    public List<MallManageListDTO> getManageList(int limit, int offset, MallManageQuery query) {

        List<MallManageListDTO> mallManageListDTOS = new ArrayList<MallManageListDTO>();

        List<MallManageDO> manageList = mallManageMapper.getManageList(limit, offset, query);

        for (MallManageDO manageDO:manageList){
            MallManageListDTO dto = new MallManageListDTO();
            BeanUtils.copyProperties(manageDO.getMall(),dto);
            BeanUtils.copyProperties(manageDO.getProduct(),dto);

            mallManageListDTOS.add(dto);
        }

        return mallManageListDTOS;
    }

    @Override
    public int countManageList(MallManageQuery query) {

        int count = mallManageMapper.countManageList(query);

        return count;
    }

}
