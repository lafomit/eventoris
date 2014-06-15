package com.eventoris.web.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.eventoris.service.EventManager;

import com.eventoris.service.CategoryManager;
import eventoris.datatypes.CategoryInfo;
import eventoris.datatypes.EventInfo;

public class EventListController implements Controller{

	protected final Log logger = LogFactory.getLog(getClass());
	private EventManager eventManager;
	private CategoryManager categoryManager;

	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List<EventInfo> events = this.eventManager.getAllEvents();
		List<CategoryInfo> categories = this.categoryManager.getAllCategories();
		Map<String, Object> myModel = new HashMap<String, Object>();
		logger.info("EventListController; returning eventlist view with " + events);
		
		
		myModel.put("products", events);
		myModel.put("noResultsMessage", "Nu este nici un eveniment in sistem");
		myModel.put("categories", categories);
		return new ModelAndView("events", "model", myModel);
	}
	
/*
    protected Map referenceData(HttpServletRequest request) throws Exception {
    	List<CategoryInfo> categories = this.categoryManager.getAllCategories();
    	Map<Integer,String> countryMap = new LinkedHashMap<Integer,String>();
    	for(CategoryInfo category:categories){
    		countryMap.put(category.getIdCategory(), category.getCategoryName());
    	}
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("categories", countryMap);
    	return myModel;
    }
*/
	public void setEventManager(EventManager eventManager) {
		this.eventManager = eventManager;
	}

	public void setCategoryManager(CategoryManager categoryManager){
		this.categoryManager = categoryManager;
	}
}
