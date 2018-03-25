package com.pig.users.controller;

import com.pig.utils.entity.WeifuResult;
import com.pig.users.model.*;
import com.pig.users.service.UsersService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/users/api")
@RestController
public class UsersController{

    @Autowired
    UsersService usersService;

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
