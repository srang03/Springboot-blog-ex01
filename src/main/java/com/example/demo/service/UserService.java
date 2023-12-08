package com.example.demo.service;



import java.awt.print.Printable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.RoleType;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service // IOC 수행
public class UserService {
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	@Autowired // DI 수행
	private UserRepository userRepository;
	 
	@Transactional // 트랜잭션 설정
	public void join(User user) {
		String rawPasswordString = encoder.encode(user.getPassword());
		user.setRole(RoleType.USER);
		user.setPassword(rawPasswordString);
			userRepository.save(user);
	}
	

}
