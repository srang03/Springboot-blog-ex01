package com.example.demo.controller;

// 인증이 안된 사용자들이 출입할 수 있는 경로를 /auth/** 허용
// / 주소일 경우 index.jsp 허용
// static 이하이 엤는 /js/**, /css/**, /image/** 허용
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	@GetMapping("/auth/joinForm")
	public String joinForm() {
		return "user/joinForm";
	}
	
	@GetMapping("/auth/loginForm")
	public String loginForm() {
		return "user/loginForm";
	}
}
