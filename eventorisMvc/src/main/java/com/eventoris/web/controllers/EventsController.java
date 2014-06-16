package com.eventoris.web.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.eventoris.service.EventManager;

import eventoris.datatypes.EventInfo;

@Controller
public class EventsController {
	@Autowired
	private EventManager eventManager;
	protected final Log logger = LogFactory.getLog(getClass());

	@RequestMapping(value = "/allevents**", method = RequestMethod.GET)
	public ModelAndView getAllEvent() {

		List<EventInfo> events = this.eventManager.getAllEvents();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("products", events);

		return new ModelAndView("events", "model", myModel);

	}

	@RequestMapping(value = "/eventbycateg", method = RequestMethod.GET)
	public ModelAndView getEventsByCategory(@RequestParam("id") int categoryId,
			HttpServletResponse response) {
		logger.info("EventsController.getEventsByCategory: " + categoryId);
		List<EventInfo> events = this.eventManager
				.getEventsByCategory(categoryId);
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("products", events);

		return new ModelAndView("events", "model", myModel);

	}

	@RequestMapping(value = "/searching", method = RequestMethod.POST)
	public ModelAndView searchEvents(
			@RequestParam(value = "search_text", required = false) String searchText) {

		logger.info("Searching for:" + searchText);

		List<EventInfo> events = eventManager.getEventByTitle(searchText);
		logger.info("Found event:" + events.size());
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("products", events);

		return new ModelAndView("events", "model", myModel);
	}

	public void setEventManager(EventManager eventManager) {
		this.eventManager = eventManager;
	}
}
