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

		String now = (new java.util.Date()).toString();
		logger.info("returning eventlist view with " + now);
		List<EventInfo> events = this.eventManager.getAllEventsForUser();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("now", now);
		myModel.put("products", events);

		return new ModelAndView("eventlist", "model", myModel);
	}

	public void setEventManager(EventManager eventManager) {
		this.eventManager = eventManager;
	}

}
