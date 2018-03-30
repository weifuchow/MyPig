package com.pig.cashFlow.service;

import com.pig.utils.service.BaseService;
import com.pig.cashFlow.model.*;
import com.pig.cashFlow.repository.CashFlowRepository;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
@Transactional
public class CashFlowService extends BaseService<CashFlowRepository,CashFlowQuery>{


}
