package com.pig.goods.service;

import com.pig.utils.entity.WeifuResult;
import com.pig.utils.service.BaseService;
import com.pig.address.model.Address;
import com.pig.address.service.AddressService;
import com.pig.cashFlow.model.CashFlow;
import com.pig.cashFlow.service.CashFlowService;
import com.pig.goods.model.*;
import com.pig.goods.repository.GoodsRepository;
import com.pig.orders.model.Orders;
import com.pig.orders.service.OrdersService;
import com.pig.users.model.Users;
import com.pig.users.service.UsersService;

import java.io.Serializable;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class GoodsService extends BaseService<GoodsRepository,GoodsQuery>{

	@Autowired
	private UsersService usersService;
	
	@Autowired
	private CashFlowService cashFlowService;
	
	@Autowired
	private OrdersService ordersService;
	
	@Autowired
	private AddressService addressService;
	
	private static String NOT_SUFFICIENT_FUNDS = "余额不足，请充值后在购买";
	private static String SET_ADDRESS = "请先设置地址";
	private static String GOODS_NOT_FOUND = "商品找不到";
	private static String USER_NOT_FOUND = "用户找不到";

	public WeifuResult buyGoods(Integer userId,Integer goodsId,Integer addressId,int num) {
		//获取数据
		Users user = usersService.findById(userId);
		Goods goods = findById(goodsId);
		Address address = addressService.findById(addressId);
		//
		WeifuResult isNotBuyResult = checkisNotBuyOption(user,goods,address);
		if(isNotBuyResult != null)
			return isNotBuyResult;
		else {
			//2.增加订单表信息
			Orders order = ordersService.addOrder(user, goods,address,num);
			//3.增加用户流水表
			Integer accountType = Integer.valueOf(goods.getGoodsType()); // accountType =0 为充值
			accountType = accountType == 0 ? 1 : 0;
			CashFlow cashFlow = cashFlowService.addCashFlow(user, order, goods, accountType);
			//4. 减去用户余额
			user.setBalance(cashFlow.getAfterBalance());
			Map<String, Serializable> map = user.convertToMap();
			map.put("password", "*****");
			return WeifuResult.getIsOkResult(map);
		}
	}
	
	/**
	 * 检查用户余额是否充足
	 * @param userId
	 * @param goodsId
	 * @return
	 */
	public Boolean checkBalance(Integer userId,Integer goodsId) {
		Users user = usersService.findById(userId);
		Goods goods = findById(goodsId);
		return checkBalance(user, goods);
	}
	
	public Boolean checkBalance(Users user,Goods goods) {
		return user.getBalance() >= goods.getGoodsPrice() + goods.getGoodsCarriage();
	}
	
	// 检查具有不能购买条件。如果是返回 weifuResult
	// 否则 为 null
	public WeifuResult checkisNotBuyOption(Users user,Goods goods,Address address) {
		if(user == null)
			return WeifuResult.getIsErrorResult(203, USER_NOT_FOUND, "USER_NOT_FOUND");
		if(goods == null)
			return WeifuResult.getIsErrorResult(203, GOODS_NOT_FOUND, "GOODS_NOT_FOUND");
		if(!goods.getGoodsType().equals("0")) {
		   if(address == null )
			  return WeifuResult.getIsErrorResult(204, SET_ADDRESS, "SET_ADDRESS");
		   if(!checkBalance(user,goods)) {
			  return WeifuResult.getIsErrorResult(205,NOT_SUFFICIENT_FUNDS,"NOT_SUFFICIENT_FUNDS");	
		   }
		}
		return null;
	}
}
