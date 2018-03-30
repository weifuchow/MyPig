package com.pig.goods.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import com.pig.utils.entity.*;
import com.pig.goods.model.*;
import com.pig.goods.service.GoodsService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/goods/api")
@RestController
@Api(value = "GoodsContrller相关",tags = "Api文档")
public class GoodsController{

    @Autowired
    GoodsService goodsService;

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ApiOperation(value = "查询Goods的信息",notes = "无条件，简单查询所有学生")
    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没填好"),
            @ApiResponse(code = 401,message = "未认证"),
            @ApiResponse(code = 403,message = "请求非法，请求方式错误"),
            @ApiResponse(code = 404,message = "页面不存在")
    })
    public WeifuResult goods(GoodsQuery query) {
        return goodsService.getPage(query);
    }

    @RequestMapping(value = "/add" , method = RequestMethod.POST)
    @ApiOperation(value = "添加Goods的信息",notes = "参数不能为空")
    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没填好"),
            @ApiResponse(code = 401,message = "未认证"),
            @ApiResponse(code = 403,message = "请求非法，请求方式错误"),
            @ApiResponse(code = 404,message = "页面不存在")
    })
    public WeifuResult addGoods(Goods goods) {
    	return WeifuResult.getIsOkResult(
    			goodsService.saveAndFlush(goods));
    }
    
    @RequestMapping(value = "/update" ,method = RequestMethod.POST)
    @ApiOperation(value = "修改Goods的信息",notes = "id不能为空")
    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没填好"),
            @ApiResponse(code = 401,message = "未认证"),
            @ApiResponse(code = 403,message = "请求非法，请求方式错误"),
            @ApiResponse(code = 404,message = "页面不存在")
    })
    public WeifuResult UpdateSysUser(Goods goods) {
    	return WeifuResult.getIsOkResult(
    			goodsService.modify(goods,goods.getId()));
    }
    
    @RequestMapping(value = "/delete" ,method = RequestMethod.GET)
    @ApiOperation(value = "删除Goods的信息",notes = "id不能为空")
    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没填好"),
            @ApiResponse(code = 401,message = "未认证"),
            @ApiResponse(code = 403,message = "请求非法，请求方式错误"),
            @ApiResponse(code = 404,message = "页面不存在")
    })
    public WeifuResult delateSysUser(@RequestParam(value = "id" ,required = true) Integer id) {
    	goodsService.deleteById(id);	
    	return WeifuResult.getIsOkResult(null);
    }
    
}
