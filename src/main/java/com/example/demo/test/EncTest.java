package com.example.demo.test;



import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncTest {

	@Test
	public void encryptionTest() {
		String encPasswordString = new BCryptPasswordEncoder().encode("Test");
		System.out.println(encPasswordString);
	}
	
}
