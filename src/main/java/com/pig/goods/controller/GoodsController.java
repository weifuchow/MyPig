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
    public WeifuResult updateGoods(Goods goods) {
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
    public WeifuResult delateGoods(@RequestParam(value = "id" ,required = true) Integer id) {
    	goodsService.deleteById(id);	
    	return WeifuResult.getIsOkResult(null);
    }
    
    @RequestMapping(value = "/findById" ,method = RequestMethod.GET)
    public WeifuResult findById(@RequestParam(value = "id" ,required = true) Integer id) {
    	return WeifuResult.getIsOkResult
    			(goodsService.findById(id));
    }
    
    
    @RequestMapping(value = "/buy" ,method = RequestMethod.GET)
    @ApiOperation(value = "购买商品",notes = "用户id,商品id不能为空")
    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没填好"),
            @ApiResponse(code = 401,message = "未认证"),
            @ApiResponse(code = 403,message = "请求非法，请求方式错误"),
            @ApiResponse(code = 404,message = "页面不存在")
    }) 
    public WeifuResult buyGoods(@RequestParam(value = "userId" ,required = true) Integer userId,
    		@RequestParam(value = "goodsId"   ,required = true) Integer goodsId,
    		@RequestParam(value = "addressId" ,required = true)Integer addressId) {
    	return goodsService.buyGoods(userId, goodsId,addressId,1);
    }
    
    @RequestMapping(value = "/recharge" ,method = RequestMethod.GET)
    @ApiOperation(value = "充值余额",notes = "用户id,充值额不能为空")
    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没填好"),
            @ApiResponse(code = 401,message = "未认证"),
            @ApiResponse(code = 403,message = "请求非法，请求方式错误"),
            @ApiResponse(code = 404,message = "页面不存在")
    }) 
    public WeifuResult recharge(@RequestParam(value = "userId" ,required = true) Integer userId,
    		@RequestParam(value = "balance"   ,required = true) Integer balance) {
    	return goodsService.buyGoods(userId,balance,0,1);
    }
    
    @RequestMapping(value = "/withDraw" ,method = RequestMethod.POST)
    @ApiOperation(value = "充值余额",notes = "用户id,提现金额不能为空")
    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没填好"),
            @ApiResponse(code = 401,message = "未认证"),
            @ApiResponse(code = 403,message = "请求非法，请求方式错误"),
            @ApiResponse(code = 404,message = "页面不存在")
    }) 
    public WeifuResult withDraw(@RequestBody(required = true) WithDrawFrom withDrawForm) throws Exception {
    	return goodsService.withdrawMoney(withDrawForm.getMoney(), withDrawForm.getUserId());
    }
    
}
