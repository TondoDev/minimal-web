package org.tondo.security.demo.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginController {

	
	/**
	 * Controller provides view for custom login page 
	 */
	@GetMapping("prihlasit")
	public String getLoginPage() {
		return "prihlasenie";
	}
	
	
	/**
	 * Controller used to redirect to after successful login
	 */
	@GetMapping("courses")
	public String getCoursesPage() {
		return "courses";
	}
}
