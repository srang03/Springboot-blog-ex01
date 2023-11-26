package com.example.demo.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpControllerTest {
	private static final String TAG = "[HttpControllerTest] ";
	// http://localhost:8080/http/get
	@GetMapping("/http/get")
	public String getTest(Member member) {
		return TAG+"Get 요청: " + member.getName() + " " + member.getPassword();
	}
	// http://localhost:8080/http/post
	@PostMapping("/http/post")
	public String postTest(@RequestBody Member member){
		return TAG+"Post 요청: " + member.getName() + ", " + member.getPassword() + ", " + member.getEmail();
	}
	// http://localhost:8080/http/post
	@PutMapping("/http/put")
	public String putTest(@RequestBody Member member) {
		member.setName("super");
		return TAG+"Put 요청: " + member.getName() + ", " + member.getPassword() + ", " + member.getEmail();
	}
	// http://localhost:8080/http/post
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return TAG+"Delete 요청";
	}
	
	@GetMapping("/http/lombok")
	public String LombokTest() {
		Member member = Member.builder().name("ian").password("1234").build();
		return TAG+"Get 요청: " + member.getName() + ", " + member.getPassword();  
	}
}
