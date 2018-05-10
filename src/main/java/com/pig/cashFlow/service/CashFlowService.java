package com.pig.cashFlow.service;

import com.pig.utils.service.BaseService;
import com.pig.cashFlow.model.*;
import com.pig.cashFlow.repository.CashFlowRepository;
import com.pig.goods.model.Goods;
import com.pig.orders.model.Orders;
import com.pig.users.model.Users;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CashFlowService extends BaseService<CashFlowRepository,CashFlowQuery>{


	
	public CashFlow addCashFlow(Users user,Orders order,Goods goods,Integer accountType) {
		// TODO Auto-generated method stub
		CashFlow cashFlow = new CashFlow();
		cashFlow.setUserId(user.getId());
		cashFlow.setOrderId(order.getId());
		cashFlow.setAccountType(accountType);
		cashFlow.setGoodsName(goods.getGoodsName());
		cashFlow.setGoodsNum(1);
		cashFlow.setGoodsMonetary(order.getOrderPrice());
		cashFlow.setActualMonetary(order.getOrderPrice());
		cashFlow.setBeforeBalance(user.getBalance());
		if(accountType == 0)
			cashFlow.setAfterBalance(user.getBalance() - order.getOrderPrice());
		else
			cashFlow.setAfterBalance(user.getBalance() + order.getOrderPrice());
		return save(cashFlow);
	}

}
 