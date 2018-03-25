package com.pig.goods.controller;

import com.pig.utils.entity.WeifuResult;
import com.pig.goods.model.*;
import com.pig.goods.service.GoodsService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/goods/api")
@RestController
public class GoodsController{

    @Autowired
    GoodsService goodsService;

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public WeifuResult goods(GoodsQuery query) {
        return goodsService.getPage(query);
    }

    @RequestMapping(value = "/add" , method = RequestMethod.POST)
    public WeifuResult addGoods(Goods goods) {
    	return WeifuResult.getIsOkResult(
    			goodsService.saveAndFlush(goods));
    }
    
    @RequestMapping(value = "/update" ,method = RequestMethod.POST)
    public WeifuResult UpdateSysUser(Goods goods) {
    	return WeifuResult.getIsOkResult(
    			goodsService.modify(goods,goods.getId()));
    }
    
    @RequestMapping(value = "/delete" ,method = RequestMethod.GET)
    public WeifuResult UpdateSysUser(@RequestParam(value = "id" ,required = true) Long id) {
    	goodsService.deleteById(id);	
    	return WeifuResult.getIsOkResult(null);
    }
    
}
