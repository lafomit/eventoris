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

import com.eventoris.service.UserManager;
import com.eventoris.web.formbeans.AddUserFormData;

import eventoris.datatypes.UserInfoWithCredentials;

public class AddUserController extends SimpleFormController {

	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());
	private UserManager userManager;

	public ModelAndView onSubmit(Object command) throws ServletException {

		AddUserFormData userFormData = ((AddUserFormData) command);
		logger.info("Creating user " + userFormData);

		UserInfoWithCredentials userInfo = new UserInfoWithCredentials();
		userInfo.setEmail(userFormData.getEmail().trim());
		userInfo.setFamilyName(userFormData.getFamilyName().trim());
		userInfo.setName(userFormData.getName().trim());
		userInfo.setPassword(userFormData.getPassword().trim());
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

	protected Object formBackingObject(HttpServletRequest request)
			throws ServletException {
		AddUserFormData eventInfo = new AddUserFormData();
		return eventInfo;
	}

}
