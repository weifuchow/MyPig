package com.pig.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pig.dao.GoodsDao;
import com.pig.model.Goods;
import com.pig.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsDao goodsDao;
	
	@Override
	public List<Goods> findAll() {
		// TODO Auto-generated method stub
		return goodsDao.findAll();
	}

}
