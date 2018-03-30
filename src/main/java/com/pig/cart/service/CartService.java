package com.pig.cart.service;

import com.pig.utils.service.BaseService;
import com.pig.cart.model.*;
import com.pig.cart.repository.CartRepository;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
@Transactional
public class CartService extends BaseService<CartRepository,CartQuery>{


}
