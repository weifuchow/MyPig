package com.pig.orders.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import com.pig.utils.entity.*;
import com.pig.cart.model.Cart;
import com.pig.goods.service.GoodsService;
import com.pig.orders.model.*;
import com.pig.orders.service.OrdersService;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/orders/api")
@RestController
@Api(value = "OrdersContrller相关",tags = "Api文档")
public class OrdersController{

    @Autowired
    OrdersService ordersService;
    @Autowired
    GoodsService GoodsService;

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ApiOperation(value = "查询Orders的信息",notes = "无条件，简单查询所有学生")
    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没填好"),
            @ApiResponse(code = 401,message = "未认证"),
            @ApiResponse(code = 403,message = "请求非法，请求方式错误"),
            @ApiResponse(code = 404,message = "页面不存在")
    })
    public WeifuResult orders(OrdersQuery query) {
    	WeifuResult weifuResult =  ordersService.getPage(query);
        PageResult result = (PageResult) weifuResult.getData();
        if (result != null) {
			List<Orders> list = result.getPageList();
			if(list != null && list.size() > 0) {
				for (Orders order : list) {
					order.setGoods(GoodsService.findById(order.getGoodsId()));
				}
			}
		}
        return weifuResult;
    }

    @RequestMapping(value = "/add" , method = RequestMethod.POST)
    @ApiOperation(value = "添加Orders的信息",notes = "参数不能为空")
    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没填好"),
            @ApiResponse(code = 401,message = "未认证"),
            @ApiResponse(code = 403,message = "请求非法，请求方式错误"),
            @ApiResponse(code = 404,message = "页面不存在")
    })
    public WeifuResult addOrders(Orders orders) {
    	return WeifuResult.getIsOkResult(
    			ordersService.saveAndFlush(orders));
    }
    
    @RequestMapping(value = "/update" ,method = RequestMethod.POST)
    @ApiOperation(value = "修改Orders的信息",notes = "id不能为空")
    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没填好"),
            @ApiResponse(code = 401,message = "未认证"),
            @ApiResponse(code = 403,message = "请求非法，请求方式错误"),
            @ApiResponse(code = 404,message = "页面不存在")
    })
    public WeifuResult updateOrders(Orders orders) {
    	return WeifuResult.getIsOkResult(
    			ordersService.modify(orders,orders.getId()));
    }
    
    @RequestMapping(value = "/delete" ,method = RequestMethod.GET)
    @ApiOperation(value = "删除Orders的信息",notes = "id不能为空")
    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没填好"),
            @ApiResponse(code = 401,message = "未认证"),
            @ApiResponse(code = 403,message = "请求非法，请求方式错误"),
            @ApiResponse(code = 404,message = "页面不存在")
    })
    public WeifuResult delateOrders(@RequestParam(value = "id" ,required = true) Integer id) {
    	ordersService.deleteById(id);	
    	return WeifuResult.getIsOkResult(null);
    }
   
    @RequestMapping(value = "/notifyOrder" ,method = RequestMethod.GET)
    @ApiOperation(value = "删除Orders的信息",notes = "id不能为空")
    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没填好"),
            @ApiResponse(code = 401,message = "未认证"),
            @ApiResponse(code = 403,message = "请求非法，请求方式错误"),
            @ApiResponse(code = 404,message = "页面不存在")
    })
    public WeifuResult notifyOrder(@RequestParam(value = "orderId" ,required = true) Integer orderId,
    								@RequestParam(value = "status" ,required = true) Integer status) {
    	return ordersService.setStatus(orderId, status);
    }
}
