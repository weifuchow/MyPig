package com.pig.goods.service;

import com.pig.utils.service.BaseService;
import com.pig.goods.model.*;
import com.pig.goods.repository.GoodsRepository;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
@Transactional
public class GoodsService extends BaseService<GoodsRepository,GoodsQuery>{


}
