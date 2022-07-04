package org.tondo.minimal.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.tondo.minimal.mvc.data.DataObject;

@Controller
public class ModelExperimetnsController {
	
	private static final String VIEW_NAME = "modelandview";

	@RequestMapping("/mret")
	public ModelAndView retunModelAndView() {
		ModelAndView mav = new ModelAndView(VIEW_NAME);
		mav.addObject("mavParamFromCtrl", "model returned");
		return mav;
	}
	
	
	@RequestMapping("/mparam")
	public String paramterModel(Model model) {
		model.addAttribute("mavParamFromParam", "model from parameter");
		
		return VIEW_NAME;
	}
	
	@RequestMapping("/mcombi")
	public ModelAndView combinedModel (Model model) {
		ModelAndView mav = new ModelAndView(VIEW_NAME);
		
		mav.addObject("mavParamFromCtrl", "model returned");
		model.addAttribute("mavParamFromParam", "model from parameter");
		
		return mav;
	}
	
	@RequestMapping("/mempty")
	public String noMode() {
		
		return VIEW_NAME;
	}
	
	// call /mattr?year=2000
	@RequestMapping("/mattr")
	public String modelAttribParam(
			@ModelAttribute("year") Integer year, 
			@RequestParam(name="year", required = false) Integer yearInt, 
			Model model) {
		
		// when attribute year is missing, modelAtrttribute contains Empty string,
		// because of no-parameter string constructor, whilst request parameter is null.
		// Model is populated with model attribute only, not with request param.
		
		return VIEW_NAME;
	}
	
	@RequestMapping("/mobjattr")
	public String modelObjectParam(
			@ModelAttribute(value = "data" /*, binding = false*/) DataObject obj,
			@RequestParam(name="year", required = false) Integer yearInt,
			Model model) {
		//  binding = false - will disable setting values to attributes of DataObject obj instance
		// Useful when object originates from longer liver scope (session) 
		// request param need PropertyEditor for object parameters
		return VIEW_NAME;
	}
}
