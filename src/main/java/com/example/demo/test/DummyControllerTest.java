package com.example.demo.test;

import java.util.List;
import java.util.function.Supplier;

import javax.transaction.Transactional;

import org.hibernate.internal.util.beans.BeanInfoHelper.ReturningBeanInfoDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.*;

import com.example.demo.model.RoleType;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

import net.bytebuddy.asm.Advice.Return;


@RestController
public class DummyControllerTest {
	
	@Autowired // 의존성 주입 (DI)
	UserRepository userRepository;
//	@PostMapping("/dummy/join")
//	public String join(String name, String password, String email) {
//		System.out.println("name: "+ name + "password: "+ password + "email: "+ email);
//		return "회원가입이 완료되었습니다.";
//	}
	
	@PostMapping("/dummy/join")
	public String join(User user) {
		user.setRole(RoleType.USER);
		userRepository.save(user);
		return "Object 회원가입이 완료되었습니다.";
	}
	
	
	@GetMapping("/dummy/user/{id}")
	public User detail(@PathVariable int id) {
		User user = userRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("해당 사용자가 없습니다.");
		});
		return user; 
	}
	
	@GetMapping("/dummy/user")
	public List<User> list(){
		return userRepository.findAll();
	}
	
	@GetMapping("/dummy/userPage")
	public List<User> pageList(@PageableDefault (size=10, sort="id", direction=Sort.Direction.DESC) Pageable pageable){
		Page<User> listUser = userRepository.findAll(pageable);
		return listUser.getContent();
	}
	
	@Transactional
	@PutMapping("/dummy/user/{id}")
	public User update(@PathVariable int id, @RequestBody User req) {
		
		User user = userRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("수정할 사용자가 없습니다.");
		});
		user.setName(req.getName());
		user.setEmail(req.getEmail());
		return user;
	}
	
	@DeleteMapping("/dummy/user/{id}")
	public String delete(@PathVariable int id) {
		try{
			userRepository.deleteById(id);
			return "정상적으로 삭제되었습니다: " + id;
		}
		catch (EmptyResultDataAccessException e) {
			return "삭제에 실패하였습니다: " + id;
		}
	}
}
