package com.example.demo.service;



import java.awt.print.Printable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service // IOC 수행
public class UserService {
	
	@Autowired // DI 수행
	private UserRepository userRepository;
	 
	@Transactional // 트랜잭션 설정
	public void join(User user) {
			userRepository.save(user);
	}
	
	@Transactional(readOnly = true) // 트랜잭션 설정, SELECT할 때 트랜잭션 시작, 서비스 종료시에 트랜잭션 종료
	public User login(User user) {
		User res = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
		System.out.println("service: " + res.getEmail());
		System.out.println("service: " + res.getPassword());
		return res;
	}
}
