package com.example.demo.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlTestController {

	// 파일 리턴 기본 경로 : src/main/resources/static
	@GetMapping("/http/home")
	public String tempHome() {
		return "/home.html";
	}
	
	@GetMapping("/http/jsptest")
	public String jspHome() {
		return "home";
	}
}
