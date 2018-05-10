package com.pig.cart.service;

import com.pig.utils.entity.WeifuResult;
import com.pig.utils.service.BaseService;
import com.pig.cart.model.*;
import com.pig.cart.repository.CartRepository;
import com.pig.goods.service.GoodsService;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CartService extends BaseService<CartRepository,CartQuery>{

	
	@Autowired
	private GoodsService goodsService;
	
	public WeifuResult buyGoods4Cart(Integer cartId,Integer num,Integer addressId) {
		Cart cart = findById(cartId);		
		//1.修改cart状态及数量
		if(cart.getGoodsNum() - num == 0)
			cart.setStatus(1);
		cart.setGoodsNum(cart.getGoodsNum() - num);
		// 2 购买	
		return goodsService.buyGoods(cart.getUserId(),cart.getGoodsId(),addressId,num);

	}

}
