package com.pig.address.service;

import com.pig.utils.service.BaseService;
import com.pig.address.model.*;
import com.pig.address.repository.AddressRepository;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
@Transactional
public class AddressService extends BaseService<AddressRepository,AddressQuery>{


}
