package com.nsg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nsg.model.User;
import com.nsg.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userrepo;
	//public User 
}
