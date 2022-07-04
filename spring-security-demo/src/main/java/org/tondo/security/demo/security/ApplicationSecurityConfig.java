package org.tondo.security.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	private final PasswordEncoder passwordEncoder;
	
	@Autowired
	public ApplicationSecurityConfig(PasswordEncoder encoder) {
		this.passwordEncoder = encoder;
	}
	
	// super impl.  configures the form based login, which is default
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
			.csrf().disable() // primary client is POSTMAN
			.authorizeRequests()
			// these URL patters will be allowed without authentication
			.antMatchers("/", "index", "/css/*", "/js/*").permitAll()
			// /api/... is available only for users with role 
			.antMatchers("/api/**").hasAnyRole(ApplicationUserRole.STUDENT.name())
			// see @PreAuthorized annotation on StudentManagementController
//			.antMatchers(HttpMethod.DELETE, "/management/api/**").hasAnyAuthority(ApplicationUserPermission.COURSE_WRITE.getPermission())
//			.antMatchers(HttpMethod.POST, "/management/api/**").hasAnyAuthority(ApplicationUserPermission.COURSE_WRITE.getPermission())
//			.antMatchers(HttpMethod.POST, "/management/api/**").hasAnyAuthority(ApplicationUserPermission.COURSE_WRITE.getPermission())
//			.antMatchers(HttpMethod.GET, "/management/api/**").hasAnyRole(ApplicationUserRole.ADMIN.name(), ApplicationUserRole.ADMINTRAINEE.name())
			.anyRequest()
			.authenticated()
			.and()
			.formLogin()
			.loginPage("/prihlasit") // new login page URL
			.permitAll() // allow request to this page, prevents redirect loop
			.defaultSuccessUrl("/courses", true) // page where will be redirected after the successful login
			.and()
			.rememberMe().tokenValiditySeconds(7*24*3600) // set up expiration duration to one week  
				.key("blabla") // key used the has the remember-me cookie
			.and()
			.logout()
				.logoutUrl("/odhlasit") // new logout URL (GET), doesn't need controller
				.logoutSuccessUrl("/prihlasenie") // redirect paget after successful logout
				.clearAuthentication(true)
				.deleteCookies("JSESSIONID", "remember-me"); // remove cookies after logout
		
				
	}
	
	
	// somehow this @Bean must be here, otherwise instances
	// from WebSecurityConfigurerAdapter.userDetailsServicBen() are used
	@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		// authorities() and roles() overwrites each other
		UserDetails annaUser= User.builder()
			.username("anna")
			.password(this.passwordEncoder.encode("annaPwd"))
//			.roles(ApplicationUserRole.STUDENT.name()) // ROLE_STUDENT
			.authorities(ApplicationUserRole.STUDENT.getGrantedAuthorities())
			.build();
		
		UserDetails lindaUser= User.builder()
				.username("linda")
				.password(this.passwordEncoder.encode("lindaPwd"))
				//.roles(ApplicationUserRole.ADMIN.name()) // ROLE_ADMIN
				.authorities(ApplicationUserRole.ADMIN.getGrantedAuthorities())
				.build();
		
		UserDetails tomUser= User.builder()
				.username("tom")
				.password(this.passwordEncoder.encode("tomPwd"))
				//.roles(ApplicationUserRole.ADMINTRAINEE.name()) // ROLE_ADMINTRAINEE
				.authorities(ApplicationUserRole.ADMINTRAINEE.getGrantedAuthorities())
				.build();
		
		
		UserDetailsService uds = new InMemoryUserDetailsManager(annaUser, lindaUser, tomUser);
		return uds;
	}

}
