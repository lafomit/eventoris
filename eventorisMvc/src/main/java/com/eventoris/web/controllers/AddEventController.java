package com.eventoris.web.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import com.eventoris.service.EventManager;
import com.eventoris.web.formbeans.AddEventFormData;

import eventoris.datatypes.EventInfo;

public class AddEventController extends SimpleFormController {

	  /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    private EventManager eventManager;
    
    public ModelAndView onSubmit(Object command)
            throws ServletException {

    	AddEventFormData newEvent = ((AddEventFormData) command) ;
        logger.info("Creating event " + newEvent);

        EventInfo event = new EventInfo();
        
        event.setTitle(newEvent.getTitle());
        event.setDescription(newEvent.getDescription());
        SimpleDateFormat format = new SimpleDateFormat("YY-MM-DD HH-mm-ss");
        Date date = new Date();
        event.setDateCreated(format.format( date));
        eventManager.createNewEventInfo(event);


        return new ModelAndView(new RedirectView(getSuccessView()));
    }

    protected Object formBackingObject(HttpServletRequest request) throws ServletException {
    	AddEventFormData eventInfo = new AddEventFormData();
        return eventInfo;
    }
 
    public void setEventManager(EventManager eventManager) {
		this.eventManager = eventManager;
	}
}
