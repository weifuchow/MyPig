package com.pig.users.controller;

import com.pig.utils.entity.WeifuResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import com.pig.users.model.*;
import com.pig.users.service.UsersService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/users/api")
@RestController
@Api(value = "学生",tags = "学生增删改查")
public class UsersController{

    @Autowired
    UsersService usersService;
    
    @ApiOperation(value = "获取所有学生信息",notes = "无条件，简单查询所有学生")
    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没填好"),
            @ApiResponse(code = 401,message = "未认证"),
            @ApiResponse(code = 403,message = "请求非法，请求方式错误"),
            @ApiResponse(code = 404,message = "页面不存在")
    })
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public WeifuResult users(UsersQuery query) {
        return usersService.getPage(query);
    }

    @RequestMapping(value = "/add" , method = RequestMethod.POST)
    public WeifuResult addUsers(Users users) {
    	return WeifuResult.getIsOkResult(
    			usersService.saveAndFlush(users));
    }
    
    @RequestMapping(value = "/update" ,method = RequestMethod.POST)
    public WeifuResult UpdateSysUser(Users users) {
    	return WeifuResult.getIsOkResult(
    			usersService.modify(users,users.getId()));
    }
    
    @RequestMapping(value = "/delete" ,method = RequestMethod.GET)
    public WeifuResult UpdateSysUser(@RequestParam(value = "id" ,required = true) Long id) {
    	usersService.deleteById(id);	
    	return WeifuResult.getIsOkResult(null);
    }
    
}
