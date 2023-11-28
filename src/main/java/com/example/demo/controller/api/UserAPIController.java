package com.example.demo.controller.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.ResponseDTO;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
public class UserAPIController {

	@Autowired
	UserService service;

	@Autowired
	 HttpSession session;
	
	@PostMapping("/api/user")
	public ResponseDTO<Integer> save(@RequestBody User user) {
		System.out.println(user.getName());
		service.join(user);
		return new ResponseDTO<Integer>(HttpStatus.OK.value(), 1);
	}
	
	@PostMapping("/api/user/login")
	public ResponseDTO<Integer> login(@RequestBody User user){
		User principal = service.login(user);
		System.out.println("service: " + user.getEmail());
		System.out.println("service: " + user.getPassword());
		if(principal != null) {
			session.setAttribute("principal", principal);
			return new ResponseDTO<Integer>(HttpStatus.OK.value(), 1);
		}else {
			return new ResponseDTO<Integer>(HttpStatus.NOT_FOUND.value(), 1);
		}
			
	}
}
