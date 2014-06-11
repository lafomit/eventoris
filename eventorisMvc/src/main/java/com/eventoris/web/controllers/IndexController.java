package com.eventoris.web.controllers;

import java.io.IOException;
import java.util.HashMap;
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

import eventoris.datatypes.EventInfo;

public class IndexController implements Controller{
	protected final Log logger = LogFactory.getLog(getClass());
	private EventManager eventManager;
	final int EVENTS_COUNT = 3;
	
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		

			String now = (new java.util.Date()).toString();
			logger.info(now+" | getting last events");
			
			System.out.println("I'm here in IndexController!");	
			
			List<EventInfo> lastEvents = this.eventManager.getLastEventsByDate(EVENTS_COUNT);
			List<EventInfo> topEvents = this.eventManager.getTopEvents(EVENTS_COUNT);
			
			Map<Object, Object> myModel = new HashMap<Object, Object>();
			myModel.put("topEvents", topEvents);
			myModel.put("lastEvents", lastEvents);
	
			return new ModelAndView("index", "model", myModel);
		
	}
	
	public void setEventManager(EventManager eventManager) {
		this.eventManager = eventManager;
	}
}
