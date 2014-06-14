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
import com.eventoris.web.formbeans.AddEventFormData;

import eventoris.datatypes.EventInfo;

public class SearchEventByTextController implements Controller {

	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());

	private EventManager eventManager;


	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String searchText = request.getParameter("search_text");
		logger.info("SearchEventByTextController: searching for text:" + searchText);

		List<EventInfo> events = eventManager.getEventByTitle(searchText);

		logger.info("SearchEventByTextController: found events:" + events.size());
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("products", events);

		return new ModelAndView("events", "model", myModel);
	}

	protected Object formBackingObject(HttpServletRequest request)
			throws ServletException {
		AddEventFormData eventInfo = new AddEventFormData();
		return eventInfo;
	}

	public void setEventManager(EventManager eventManager) {
		this.eventManager = eventManager;
	}

}
