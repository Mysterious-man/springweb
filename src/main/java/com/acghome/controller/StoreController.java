package com.acghome.controller;

import com.acghome.entity.db1.Store;
import com.acghome.mapper.db1.StoreMapper;
import com.acghome.query.StoreManageQuery;
import com.acghome.service.IStoreService;
import com.acghome.utils.Result;
import com.acghome.utils.ResultGenerator;
import com.acghome.utils.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @CREATE :PotatoThomas
 * @DATE：2019/9/21 -  14:05
 */
@Controller
@RequestMapping("/store")
public class StoreController extends BaseContorller {

    @Autowired
    private IStoreService storeService;


    //专场管理
    @RequestMapping("/Store_Manage")
    public String specialManage(Model model) {
        model.addAttribute("user", UserContext.getUser());
        return "system/Store_Manage";
    }
    //专场列表
    @ResponseBody
    @RequestMapping(value = "/getDataList")
    public Map getDataList(int limit, int offset, StoreManageQuery query) {
        int total=storeService.loadCountByQuery(query);
        List<Store> storeList = storeService.getDataList(offset,limit,query);
        HashMap<String, Object> map = new HashMap<>();
        map.put("total",total);
        map.put("rows",storeList);
        return map;

    }

    //添加或修改
    @ResponseBody
    @RequestMapping(value = "/saveOrUpdate")
    public Result saveOrUpdate(Store store) {
        String msg = storeService.saveOrUpdate(store);
        return ResultGenerator.trueResult(msg);
    }
    //删除
    @ResponseBody
    @RequestMapping(value = "/del")
    public Result del(Integer id) {
        storeService.del(id);
        return ResultGenerator.genFailResult("删除成功");

    }

}
