package org.tondo.minimal.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.tondo.minimal.mvc.data.InfoData;
import org.tondo.minimal.mvc.data.WrapperObj;
import org.tondo.minimal.mvc.data.conversion.InfoEditor;
import org.tondo.minimal.mvc.data.conversion.InfoFormatter;

@Controller
public class DataBindingController {
	
	// /binding?info=FirstName
	@GetMapping("/binding")
	public ModelAndView homeQueryParam(@RequestParam(name="info", required = false) InfoData info) {
		ModelAndView mv = new ModelAndView("sampleForm");
		mv.addObject("infoData", info);
		
		WrapperObj wrapper = new WrapperObj(info);
		mv.addObject("tmp", wrapper);
		
		return mv;
	}
	
	@GetMapping("/binding/{info}")
	public ModelAndView homePathVariable(@PathVariable("info") InfoData info) {
		ModelAndView mv = new ModelAndView("sampleForm");
		mv.addObject("infoData", info);
		
		return mv;
	}
	
	// /binding/ma?info=FirstName - will not work, InfoData instance created but all props are null
	// - propertyEditor not applied
	// /binding/ma?surname=Black
	// this will bind queryParameters to the properties of InfoData object instance
	// - each proerpty of infoData object instance is set for which exists property in query parameters
	@GetMapping("/binding/ma")
	public ModelAndView homeModeAttr(@ModelAttribute(value="info", binding = true) InfoData info) {
		ModelAndView mv = new ModelAndView("sampleForm");
		mv.addObject("infoData", info);
		return mv;
	}
	
	
	@PostMapping("/binding")
	public String create() {
		return "redirect:/binding";
	}
	
	@InitBinder
	public void initBindings(WebDataBinder binder) {
		binder.registerCustomEditor(InfoData.class, new InfoEditor());
		// formatter has precedence 
		binder.addCustomFormatter(new InfoFormatter(), InfoData.class);
		// this doesnt work for queryParameter name
		// bind.registerCustomEditor(InfoData.class, "info", new InfoEditor());
	}

}
