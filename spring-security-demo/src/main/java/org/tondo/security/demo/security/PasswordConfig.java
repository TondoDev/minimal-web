package org.tondo.security.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {
		 BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10); // strength
		 
		 return bCryptPasswordEncoder;
	}
}
