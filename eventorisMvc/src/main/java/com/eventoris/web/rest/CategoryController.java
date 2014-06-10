package com.eventoris.web.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eventoris.service.CategoryManager;


@Controller
@RequestMapping("/categories")
public class CategoryController {
	
    private CategoryManager categoryManager;
    
    public CategoryController(CategoryManager manager){
    	this.categoryManager = manager;
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public String getCategory(@PathVariable long id, Model model){
    	return "cat_list";
    }
	
}
