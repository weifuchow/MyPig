package com.pig.address.service;

import com.pig.utils.service.BaseService;
import com.pig.address.model.*;
import com.pig.address.repository.AddressRepository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
@Transactional
public class AddressService extends BaseService<AddressRepository,AddressQuery>{

	public Address getAddressByUserId(Integer addressUserId){
		return repository.getAddressByUserId(addressUserId);
	}
	
	public Boolean CheckUserAddress(Integer addressUserId) {
		return getAddressByUserId(addressUserId) == null ? false : true;
	}
}
