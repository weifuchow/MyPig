package com.pig.users.service;

import com.pig.utils.service.BaseService;
import com.pig.users.model.*;
import com.pig.users.repository.UsersRepository;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsersService extends BaseService<UsersRepository,UsersQuery>{

	public Users login(String phone,String password) {
		return repository.login(phone, password);
	}

}
