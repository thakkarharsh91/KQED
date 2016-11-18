package com.paymentgateway.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paymentgateway.dao.TestDAO;
import com.paymentgateway.model.User;
import com.paymentgateway.service.TestService;

@Service("testService")
@Transactional
public class TestServiceImpl implements TestService{

	@Autowired
	TestDAO testDAO;
	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		testDAO.addUser(user);
		
	}

}
