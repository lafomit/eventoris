package com.eventoris.web.controllers;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.eventoris.service.EventManager;
import com.eventoris.web.auth.UserSessionInfo;

import eventoris.datatypes.EventInfo;

@Controller
@RequestMapping(value ="/delete", params="eventid")
public class DeleteEventController {

	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private EventManager eventManager;

	@RequestMapping(method = RequestMethod.GET)
	public String deleteMessage(@RequestParam(value = "eventid") int eventid, ModelMap model){
		
		eventManager.deleteEvent(eventid);

		return "redirect:/myevents.htm";
	}
}