package com.example.demo.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.ResponseDTO;
import com.example.demo.model.User;

@RestController
public class UserAPIController{
	
	@PostMapping("/api/user")
	public ResponseDTO<Integer> save(@RequestBody User user) {
		return new ResponseDTO<Integer>(HttpStatus.OK, 1);
	}
}
