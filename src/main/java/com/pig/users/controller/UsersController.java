package com.pig.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pig.users.model.Users;
import com.pig.users.model.UsersQuery;
import com.pig.users.service.UsersService;
import com.pig.utils.AppMD5Util;
import com.pig.utils.entity.WeifuResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


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
    public WeifuResult addUsers(@RequestBody(required = true)Users users) throws Exception {  	
    	users.setPassword(AppMD5Util.MD5(users.getPassword()));
    	users.setUserName(users.getPhone()+"手机用户");
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
    public WeifuResult updateUsers(@RequestBody(required = true)Users users) {
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
    public WeifuResult delateUsers(@RequestParam(value = "id" ,required = true) Integer id) {
    	usersService.deleteById(id);	
    	return WeifuResult.getIsOkResult(null);
    }
    
    @RequestMapping(value = "/login" ,method = RequestMethod.POST)
    @ApiOperation(value = "用户登录访问",notes = "参数不能为空")
    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没填好"),
            @ApiResponse(code = 401,message = "未认证"),
            @ApiResponse(code = 403,message = "请求非法，请求方式错误"),
            @ApiResponse(code = 404,message = "页面不存在")
    })
    public WeifuResult loginSysUser(@RequestBody(required = true) Users user) {
    	String phone = user.getPhone();
    	String password = user.getPassword();
    	password = AppMD5Util.MD5(password);
    	Users users = usersService.login(phone, password);
    	if(users == null) {
    		return WeifuResult.getIsErrorResult(400, "用户名或密码错误", null);
    	}
    	else {
    		users.setPassword("");
    		return WeifuResult.getIsOkResult(users);
    	}
    }
}
