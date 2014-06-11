package com.eventoris.web.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import com.eventoris.service.CategoryManager;
import com.eventoris.service.EventManager;
import com.eventoris.web.formbeans.AddEventFormData;

import eventoris.datatypes.CategoryInfo;
import eventoris.datatypes.EventInfo;

public class AddEventController extends SimpleFormController {

	  /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    private EventManager eventManager;
    private CategoryManager categoryManager;
    
    public ModelAndView onSubmit(Object command)
            throws ServletException {

    	AddEventFormData newEvent = ((AddEventFormData) command) ;
        logger.info("Creating event " + newEvent);

        EventInfo event = new EventInfo();
        
        event.setTitle(newEvent.getTitle());
        event.setDescription(newEvent.getDescription());
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-d HH:mm:ss");
        Date date = new Date();
        event.setDateCreated(format.format( date));
        logger.info("Creating info" +event );
        eventManager.createNewEventInfo(event);


        return new ModelAndView(new RedirectView(getSuccessView()));
    }

    @Override
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
    
    
 
	
	
    protected Object formBackingObject(HttpServletRequest request) throws ServletException {
    	AddEventFormData eventInfo = new AddEventFormData();
        return eventInfo;
    }
 
    public void setEventManager(EventManager eventManager) {
		this.eventManager = eventManager;
	}
    
    public void setCategoryManager(CategoryManager categoryManager) {
		this.categoryManager = categoryManager;
	}
}
