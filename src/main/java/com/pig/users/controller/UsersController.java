package com.pig.users.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import com.pig.utils.entity.*;
import com.pig.users.model.*;
import com.pig.users.service.UsersService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/users/api")
@RestController
@Api(value = "UsersContrller相关",tags = "Api文档")
public class UsersController{

    @Autowired
    UsersService usersService;

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ApiOperation(value = "查询Users的信息",notes = "无条件，简单查询所有学生")
    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没填好"),
            @ApiResponse(code = 401,message = "未认证"),
            @ApiResponse(code = 403,message = "请求非法，请求方式错误"),
            @ApiResponse(code = 404,message = "页面不存在")
    })
    public WeifuResult users(UsersQuery query) {
        return usersService.getPage(query);
    }

    @RequestMapping(value = "/add" , method = RequestMethod.POST)
    @ApiOperation(value = "添加Users的信息",notes = "参数不能为空")
    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没填好"),
            @ApiResponse(code = 401,message = "未认证"),
            @ApiResponse(code = 403,message = "请求非法，请求方式错误"),
            @ApiResponse(code = 404,message = "页面不存在")
    })
    public WeifuResult addUsers(Users users) {
    	return WeifuResult.getIsOkResult(
    			usersService.saveAndFlush(users));
    }
    
    @RequestMapping(value = "/update" ,method = RequestMethod.POST)
    @ApiOperation(value = "修改Users的信息",notes = "id不能为空")
    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没填好"),
            @ApiResponse(code = 401,message = "未认证"),
            @ApiResponse(code = 403,message = "请求非法，请求方式错误"),
            @ApiResponse(code = 404,message = "页面不存在")
    })
    public WeifuResult UpdateSysUser(Users users) {
    	return WeifuResult.getIsOkResult(
    			usersService.modify(users,users.getId()));
    }
    
    @RequestMapping(value = "/delete" ,method = RequestMethod.GET)
    @ApiOperation(value = "删除Users的信息",notes = "id不能为空")
    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没填好"),
            @ApiResponse(code = 401,message = "未认证"),
            @ApiResponse(code = 403,message = "请求非法，请求方式错误"),
            @ApiResponse(code = 404,message = "页面不存在")
    })
    public WeifuResult delateSysUser(@RequestParam(value = "id" ,required = true) Integer id) {
    	usersService.deleteById(id);	
    	return WeifuResult.getIsOkResult(null);
    }
    
}
