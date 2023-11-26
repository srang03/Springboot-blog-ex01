package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.User;

// JSP에서 DAO 역학을 수행
public interface UserRepository extends JpaRepository<User, Integer>{
	 

}
