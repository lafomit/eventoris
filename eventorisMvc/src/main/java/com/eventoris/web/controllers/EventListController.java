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

public class EventListController implements Controller{

	protected final Log logger = LogFactory.getLog(getClass());
	private EventManager eventManager;

	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List<EventInfo> events = this.eventManager.getAllEvents();
		Map<String, Object> myModel = new HashMap<String, Object>();
		logger.info("EventListController; returning eventlist view with " + events);
		myModel.put("products", events);
		myModel.put("noResultsMessage", "Nu este nici un eveniment in sistem");
		return new ModelAndView("events", "model", myModel);
	}

	public void setEventManager(EventManager eventManager) {
		this.eventManager = eventManager;
	}


}
