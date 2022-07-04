package org.tondo.minimal.mvc.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
// @RestController - all methods will contain @ResponseBody return
public class MyBasicController {

	@RequestMapping(value = "/map")
	public @ResponseBody Map<String, Object> sendMeSomething() {
		Map<String, Object> rv = new HashMap<String, Object>();
		rv.put("amount", 5);
		rv.put("name", "Anton");
		rv.put("date", LocalDate.now());
		return rv;
	}
	
	@RequestMapping(value = "/sample")
	public String returnSampleView(@RequestParam( value = "attr", required = false) String attr, Model model) {
		System.out.println("Attr: " + attr);
		model.addAttribute("modelParam", "Some important value");
		return "samplePage";
	}
	

	@RequestMapping(value = "/textak")
	public String returnView() {
		return "halo.txt";
	}
}
