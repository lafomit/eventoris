package com.eventoris.web.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eventoris.service.EventManager;

import eventoris.datatypes.EventInfo;


@Controller
@RequestMapping("/events")
public class EventsController {

	
    private EventManager eventManager;
    
    public EventsController(EventManager manager){
    	this.eventManager = manager;
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public @ResponseBody EventInfo getEvent(@PathVariable long id, Model model){
    	//model.addAttribute(eventManager.getEventById((int)id));
    	return eventManager.getEventById((int)id);
    }
    
    @RequestMapping(value = "", method = RequestMethod.GET)
	public String getDefaultMovie(ModelMap model) {
 
		model.addAttribute("movie", "this is default movie");
		return "list";
 
	}
	
}
