package com.example.demo.controller.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.ResponseDTO;
import com.example.demo.model.RoleType;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
public class UserAPIController {

	@Autowired
	UserService service;
	
	
	@PostMapping("/auth/joinProc")
	public ResponseDTO<Integer> save(@RequestBody User user) {

		service.join(user);
		return new ResponseDTO<Integer>(HttpStatus.OK.value(), 1);
	}
	
}
