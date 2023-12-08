package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

// bin 등록 > Spring Container 에서 객체를 관리할수 있도록 하는 것 (IOC 관리)
@Configuration

// 시큐리티 필터 추가 = 스프링 시큐리티가 활성화가 되어 있는데, 어떤 설정을 여기 클래스에서 진행하겠다. (시큐리티 필터가 등록된다.)
@EnableWebSecurity

@EnableGlobalMethodSecurity(prePostEnabled = true) // 특정 주소 접근시 권한 및 인증을 미리 체크하겠다.
public class SecurityConfig{

	 @Bean // 리턴하는 BCryptPasswordEncoder를 IOC 등록
	 BCryptPasswordEncoder encodePWD() {
	  return new BCryptPasswordEncoder();
	 }
	 
	 @Bean
	 SecurityFilterChain configure(HttpSecurity http) throws Exception {
	  http
	  .csrf().disable()
	    .authorizeRequests()
	    .antMatchers("/auth/**", "/js/**", "/image/**", "/css/**", "/")
	    .permitAll()
	    .anyRequest()
	    .authenticated()
	    .and()
	    .formLogin()
	    .loginPage("/auth/loginForm");
	  return http.build();
	 }
}
