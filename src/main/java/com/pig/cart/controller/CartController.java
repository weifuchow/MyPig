package com.pig.cart.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import com.pig.utils.entity.*;
import com.pig.cart.model.*;
import com.pig.cart.service.CartService;
import com.pig.goods.service.GoodsService;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/cart/api")
@RestController
@Api(value = "CartContrller相关",tags = "Api文档")
public class CartController{

    @Autowired
    CartService cartService;
    @Autowired
    GoodsService GoodsService;

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ApiOperation(value = "查询Cart的信息",notes = "无条件，简单查询所有学生")
    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没填好"),
            @ApiResponse(code = 401,message = "未认证"),
            @ApiResponse(code = 403,message = "请求非法，请求方式错误"),
            @ApiResponse(code = 404,message = "页面不存在")
    })
    public WeifuResult cart(CartQuery query) {
        WeifuResult weifuResult =  cartService.getPage(query);
        PageResult result = (PageResult) weifuResult.getData();
        if (result != null) {
			List<Cart> list = result.getPageList();
			if(list != null && list.size() > 0) {
				for (Cart cart : list) {
					cart.setGoods(GoodsService.findById(cart.getGoodsId()));
				}
			}
		}
        return weifuResult;
    }

    @RequestMapping(value = "/add" , method = RequestMethod.POST)
    @ApiOperation(value = "添加Cart的信息",notes = "参数不能为空")
    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没填好"),
            @ApiResponse(code = 401,message = "未认证"),
            @ApiResponse(code = 403,message = "请求非法，请求方式错误"),
            @ApiResponse(code = 404,message = "页面不存在")
    })
    public WeifuResult addCart(@RequestBody(required = true)Cart cart) {
    	return WeifuResult.getIsOkResult(
    			cartService.saveAndFlush(cart));
    }
    
    @RequestMapping(value = "/update" ,method = RequestMethod.POST)
    @ApiOperation(value = "修改Cart的信息",notes = "id不能为空")
    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没填好"),
            @ApiResponse(code = 401,message = "未认证"),
            @ApiResponse(code = 403,message = "请求非法，请求方式错误"),
            @ApiResponse(code = 404,message = "页面不存在")
    })
    public WeifuResult updateCart(@RequestBody(required = true)Cart cart) {
    	return WeifuResult.getIsOkResult(
    			cartService.modify(cart,cart.getId()));
    }
    
    @RequestMapping(value = "/delete" ,method = RequestMethod.GET)
    @ApiOperation(value = "删除Cart的信息",notes = "id不能为空")
    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没填好"),
            @ApiResponse(code = 401,message = "未认证"),
            @ApiResponse(code = 403,message = "请求非法，请求方式错误"),
            @ApiResponse(code = 404,message = "页面不存在")
    })
    public WeifuResult delateCart(@RequestParam(value = "id" ,required = true) Integer id) {
    	cartService.deleteById(id);	
    	return WeifuResult.getIsOkResult(null);
    }
    
    @RequestMapping(value = "/buyGoods4Cart" ,method = RequestMethod.GET)
    @ApiOperation(value = "从购物车购买",notes = "id不能为空")
    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没填好"),
            @ApiResponse(code = 401,message = "未认证"),
            @ApiResponse(code = 403,message = "请求非法，请求方式错误"),
            @ApiResponse(code = 404,message = "页面不存在")
    })
    public WeifuResult buyGoods4Cart(@RequestParam(value = "cartId" ,required = true)Integer cartId,
    		@RequestParam(value = "num" ,required = true)Integer num,
    		@RequestParam(value = "addressId" ,required = true)Integer addressId) {
    	return cartService.buyGoods4Cart(cartId, num, addressId);
    }
    
     
}
