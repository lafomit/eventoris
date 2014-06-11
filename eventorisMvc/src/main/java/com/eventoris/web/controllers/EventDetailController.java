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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.eventoris.service.EventManager;

import eventoris.datatypes.EventInfo;

public class EventDetailController implements Controller{

	protected final Log logger = LogFactory.getLog(getClass());
	private EventManager eventManager;

	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String eventIdAsString = request.getParameter("event");
		
		int eventId = -1;
		try{
		    eventId = Integer.parseInt(eventIdAsString);
		}catch(NumberFormatException ex){
		 
			return new ModelAndView("eventdetail", "eventInfo", null);
		}
		EventInfo resultEventInfo = eventManager.getEventById(eventId);
		
		logger.info("returning eventInfo:" + resultEventInfo);
	 
	 

		return new ModelAndView("eventdetail", "eventInfo", resultEventInfo);
	}

	public void setEventManager(EventManager eventManager) {
		this.eventManager = eventManager;
	}

	
 
	
}
