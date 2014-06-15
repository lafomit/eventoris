package com.eventoris.web.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import com.eventoris.service.EventManager;
import com.eventoris.web.formbeans.AddEventFormData;


@Controller
public class AddCommentController extends SimpleFormController {

	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());

	private EventManager eventManager;

	public ModelAndView onSubmit(Object command) throws ServletException {
		logger.info("AddCommentController: adding comment");
		return new ModelAndView(new RedirectView(getSuccessView()));
	}

	@Override
	protected Map referenceData(HttpServletRequest request) throws Exception {

		Map<String, Object> myModel = new HashMap<String, Object>();
		return myModel;
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