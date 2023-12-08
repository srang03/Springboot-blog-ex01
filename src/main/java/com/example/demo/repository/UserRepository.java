package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.User;

// JSP에서 DAO 역학을 수행
public interface UserRepository extends JpaRepository<User, Integer> {
	
}

// 방법 1
// JPA 네이밍 전략
// SELECT * FROM user WHERE email = ? AND password = ?
//	User findByEmailAndPassword(String email, String password);

// 방법 2
//@Query(value="SELECT * FROM user WHERE email = ? AND password = ?", nativeQuery = true)
//User login(String email, String password);
