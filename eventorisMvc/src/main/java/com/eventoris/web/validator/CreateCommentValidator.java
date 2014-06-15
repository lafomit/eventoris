package com.eventoris.web.validator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.eventoris.web.formbeans.AddCommentFormData;
import com.eventoris.web.formbeans.AddEventFormData;

public class CreateCommentValidator implements Validator {

	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());

	public boolean supports(Class clazz) {
		return AddCommentFormData.class.equals(clazz);
	}

	public void validate(Object obj, Errors errors) {
		AddCommentFormData eventData = (AddCommentFormData) obj;
	}

}