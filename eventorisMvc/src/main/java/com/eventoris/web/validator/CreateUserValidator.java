package com.eventoris.web.validator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.eventoris.web.formbeans.AddEventFormData;
import com.eventoris.web.formbeans.AddUserFormData;

public class CreateUserValidator implements Validator{


	    /** Logger for this class and subclasses */
	    protected final Log logger = LogFactory.getLog(getClass());

	    public boolean supports(Class clazz) {
	        return AddUserFormData.class.equals(clazz);
	    }

	    public void validate(Object obj, Errors errors) {
	    	AddUserFormData eventData = (AddUserFormData) obj;
//	        if (eventData == null) {
//	            errors.rejectValue("title", "error.not-specified", null, "Value required.");
//	        }
//	        else {
//	            logger.info("Validating with " + eventData + ": " + eventData.getTitle());
//	            if (eventData.getTitle() == null || eventData.getTitle().trim().length() == 0) {
//	                errors.rejectValue("title", "error.empty-title");
//	            }
//	            if (eventData.getDescription() == null || eventData.getDescription().trim().length() == 0) {
//	                errors.rejectValue("description", "error.empty-description");
//	            }
//	        }
	    }




}
