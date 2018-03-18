package com.pig.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pig.service.GoodsService;

@RestController
@RequestMapping("/api")
public class GoodsController {

	@Autowired
	private GoodsService goodsService;
	
	@RequestMapping("/zhuzhu")
	public Object test(){
		return goodsService.findAll();
	}
	
}
