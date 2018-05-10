package com.pig.orders.service;

import com.pig.utils.entity.WeifuResult;
import com.pig.utils.service.BaseService;
import com.pig.address.model.Address;
import com.pig.address.service.AddressService;
import com.pig.goods.model.Goods;
import com.pig.goods.service.GoodsService;
import com.pig.orders.model.*;
import com.pig.orders.repository.OrdersRepository;
import com.pig.users.model.Users;
import com.pig.users.service.UsersService;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class OrdersService extends BaseService<OrdersRepository,OrdersQuery>{

	@Autowired
	private AddressService addressService;
	@Autowired 
	private UsersService usersService;
	@Autowired
	private GoodsService goodsService;
	
	public WeifuResult setStatus(Integer orderId,Integer status) {
		return WeifuResult.getIsOkResult(repository.setStatus(status, orderId));
	}
	
	public Orders addOrder(Integer userId,Integer goodsId,int num) {
		// TODO Auto-generated method stub
		Users user  = usersService.findById(userId);
		Goods goods = goodsService.findById(goodsId);
		return addOrder(user, goods,num);
		
	}
	
	public Orders addOrder(Users user,Goods good,Address address,int num) {
		//构造orders
		if(address == null)
			return addOrder(user,good,num);
		//
		Orders orders = new Orders();
		orders.setAddressId(address.getId());
		orders.setGoodsId(good.getId());
		orders.setUserId(user.getId());
		orders.setGoodsNums(num);
		orders.setOrderPrice(good.getGoodsPrice()*num);
		//
		return save(orders);
	}
	
	public Orders addOrder(Users user,Goods good,int num) {
		//构造orders
		Orders orders = new Orders();
		orders.setGoodsId(good.getId());
		orders.setUserId(user.getId());
		orders.setGoodsNums(num);
		orders.setOrderPrice(good.getGoodsPrice()*1);
		//
		return save(orders);
	}
}
