package com.pig.address.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import com.pig.utils.entity.*;
import com.pig.address.model.*;
import com.pig.address.service.AddressService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/address/api")
@RestController
@Api(value = "AddressContrller相关",tags = "Api文档")
public class AddressController{

    @Autowired
    AddressService addressService;

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ApiOperation(value = "查询Address的信息",notes = "无条件，简单查询所有学生")
    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没填好"),
            @ApiResponse(code = 401,message = "未认证"),
            @ApiResponse(code = 403,message = "请求非法，请求方式错误"),
            @ApiResponse(code = 404,message = "页面不存在")
    })
    public WeifuResult address(AddressQuery query) {
        return addressService.getPage(query);
    }

    @RequestMapping(value = "/add" , method = RequestMethod.POST)
    @ApiOperation(value = "添加Address的信息",notes = "参数不能为空")
    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没填好"),
            @ApiResponse(code = 401,message = "未认证"),
            @ApiResponse(code = 403,message = "请求非法，请求方式错误"),
            @ApiResponse(code = 404,message = "页面不存在")
    })
    public WeifuResult addAddress(Address address) {
    	return WeifuResult.getIsOkResult(
    			addressService.saveAndFlush(address));
    }
    
    @RequestMapping(value = "/update" ,method = RequestMethod.POST)
    @ApiOperation(value = "修改Address的信息",notes = "id不能为空")
    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没填好"),
            @ApiResponse(code = 401,message = "未认证"),
            @ApiResponse(code = 403,message = "请求非法，请求方式错误"),
            @ApiResponse(code = 404,message = "页面不存在")
    })
    public WeifuResult UpdateSysUser(Address address) {
    	return WeifuResult.getIsOkResult(
    			addressService.modify(address,address.getId()));
    }
    
    @RequestMapping(value = "/delete" ,method = RequestMethod.GET)
    @ApiOperation(value = "删除Address的信息",notes = "id不能为空")
    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没填好"),
            @ApiResponse(code = 401,message = "未认证"),
            @ApiResponse(code = 403,message = "请求非法，请求方式错误"),
            @ApiResponse(code = 404,message = "页面不存在")
    })
    public WeifuResult delateSysUser(@RequestParam(value = "id" ,required = true) Integer id) {
    	addressService.deleteById(id);	
    	return WeifuResult.getIsOkResult(null);
    }
    
}
