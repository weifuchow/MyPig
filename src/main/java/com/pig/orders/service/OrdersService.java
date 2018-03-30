package com.pig.orders.service;

import com.pig.utils.service.BaseService;
import com.pig.orders.model.*;
import com.pig.orders.repository.OrdersRepository;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
@Transactional
public class OrdersService extends BaseService<OrdersRepository,OrdersQuery>{


}
