package com.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;

@Controller
public class StudentController {
	
	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public ModelAndView student(){
		System.out.println("1");
		return new ModelAndView("student", "command", new Student());
	}
	
	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public String addStudent(@ModelAttribute("SpringWeb") Student student, ModelMap model){
		System.out.println("2");
		model.addAttribute("name", student.getName());
		System.out.println(model.get("name"));
		model.addAttribute("age", student.getAge());
		System.out.println("3");
		model.addAttribute("id", student.getId());
		System.out.println("4");
		return "result";
	}
}
