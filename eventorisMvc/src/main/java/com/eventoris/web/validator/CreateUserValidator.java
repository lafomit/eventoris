package com.eventoris.web.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.eventoris.service.UserManager;
import com.eventoris.web.formbeans.AddUserFormData;

import eventoris.datatypes.UserInfo;

public class CreateUserValidator implements Validator{
		
	    @Autowired
	    private UserManager userManager;
	    /** Logger for this class and subclasses */
	    protected final Log logger = LogFactory.getLog(getClass());

		private static Matcher matcher;
	 
		private static final String EMAIL_PATTERN = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	 
		private static Pattern pattern  = Pattern.compile(EMAIL_PATTERN);
 
			
	    public boolean supports(Class clazz) {
	        return AddUserFormData.class.equals(clazz);
	    }

	    public void validate(Object obj, Errors errors) {
	    	AddUserFormData eventData = (AddUserFormData) obj;
	        if (eventData == null) {
	            errors.rejectValue("title", "error.not-specified", null, "Value required.");
	        }
	        else {
	            if (eventData.getName() == null || eventData.getName().trim().length() == 0) {
	                errors.rejectValue("name", "error.empty-username");
	            }
	            if (eventData.getFamilyName() == null || eventData.getFamilyName().trim().length() == 0) {
	                errors.rejectValue("familyName", "error.empty-familyname");
	            }
	            if (eventData.getEmail() == null || eventData.getEmail().trim().length() == 0) {
	                errors.rejectValue("email", "error.empty-emailul");
	            }else if(eventData.getEmail() != null){
	            	matcher = pattern.matcher(eventData.getEmail());
	        		if(! matcher.matches())
	        			errors.rejectValue("email", "error.email-wrong-format");
	            }
	            if (eventData.getPassword() == null || eventData.getPassword().trim().length() == 0) {
	                errors.rejectValue("password", "error.empty-password");
	            }
	            if (eventData.getPasswordRepeat() == null || eventData.getPasswordRepeat().trim().length() == 0) {
	                errors.rejectValue("passwordRepeat", "error.empty-passwordconfirm");
	            }
	            
	            if (eventData.getPasswordRepeat() != null && eventData.getPassword() != null 
	            		&& !eventData.getPasswordRepeat().trim().equals(eventData.getPassword().trim())) {
	                errors.rejectValue("passwordRepeat", "error.empty-secondpassworddiffers");
	            }
	            
	            UserInfo user = userManager.findUser(eventData.getEmail());
	            if(user != null){
	            	 errors.rejectValue("email", "error.email-exists");
	            }
	        }
	    }




}
