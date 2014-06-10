package com.eventoris.web.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import com.eventoris.service.EventManager;
import com.eventoris.service.UserManager;
import com.eventoris.web.formbeans.AddUserFormData;

import eventoris.datatypes.UserInfo;

public class AddUserController extends SimpleFormController {

	  /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
    private UserManager userManager;
    
    
    public ModelAndView onSubmit(Object command)
            throws ServletException {

    	AddUserFormData userFormData = ((AddUserFormData) command) ;
        logger.info("Creating user " + userFormData);

//        EventInfo event = new EventInfo();
//        
//        event.setTitle(newEvent.getTitle());
//        event.setDescription(newEvent.getDescription());
//        SimpleDateFormat format = new SimpleDateFormat("YY-MM-DD HH-mm-ss");
//        Date date = new Date();
//        event.setDateCreated(format.format( date));
// 

        UserInfo userInfo = new UserInfo();
        userInfo.setEmail(userFormData.getEmail());
        userInfo.setFamilyName(userFormData.getFamilyName());
        userInfo.setName(userFormData.getName());
        userInfo.setId(99);
        userManager.createNewUser(userInfo);

        return new ModelAndView(new RedirectView(getSuccessView()));
    }

    @Override
    protected Map referenceData(HttpServletRequest request) throws Exception {
 
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("temp", "temp");
    	return myModel;
    }
    
    
 
    public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	
    protected Object formBackingObject(HttpServletRequest request) throws ServletException {
    	AddUserFormData eventInfo = new AddUserFormData();
        return eventInfo;
    }
 
}
