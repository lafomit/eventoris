package com.eventoris.web.controllers;

import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.eventoris.service.CategoryManager;
import com.eventoris.service.EventManager;
import com.eventoris.web.auth.UserSessionInfo;

import eventoris.datatypes.CategoryInfo;
import eventoris.datatypes.CommentInfo;
import eventoris.datatypes.EventInfo;
import eventoris.datatypes.UserInfo;

public class EventDetailController implements Controller {

	protected final Log logger = LogFactory.getLog(getClass());
	private EventManager eventManager;
	private CategoryManager categoryManager;

	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Map<String, Object> myModel = new HashMap<String, Object>();

		String eventIdAsString = request.getParameter("event");
		UserSessionInfo activeUser = null ;
	    Principal principal = request.getUserPrincipal();
	    if (principal != null) {
	        activeUser = (UserSessionInfo)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    }

		
		int eventId = -1;
		try {
			eventId = Integer.parseInt(eventIdAsString);
		} catch (NumberFormatException ex) {

			return new ModelAndView("eventdetail", "dataMap", null);
		}
		EventInfo resultEventInfo = eventManager.getEventById(eventId);
		if (resultEventInfo == null)
			return new ModelAndView("eventdetail", "dataMap", null);

		logger.info("EventDetailController: returning eventInfo:" + resultEventInfo);

		UserInfo owner = eventManager.getOnwerOfTheEvent(eventId);
		logger.info("EventDetailController: returning ownerInfo:" + owner);
		
		int totalParticipantNumber = eventManager.getNumberOfTotalParticipants(eventId);
		int comingParticipantNumber = eventManager.getNumberOfComingParticipants(eventId);
		int maybeParticipantNumber = eventManager.getNumberOfMaybeGoingParticipants(eventId);
		logger.info("EventDetailController: searching for categoryId:" + resultEventInfo.getCategoryID());
		CategoryInfo category = categoryManager.getCategoryById(resultEventInfo
				.getCategoryID());
		logger.info("EventDetailController: returning categoryInfo:" + category);
		
		List<CommentInfo> comments = eventManager.getCommentsForEvent(eventId);
		
		logger.info("EventDetailController: found "+comments.size()+" comments for eventId=" + eventId);
		
		if(activeUser!= null && activeUser.getId() == owner.getId()){
			myModel.put("isLoggedInOwner", true);
		}else{
			myModel.put("isLoggedInOwner", false);
		}
		myModel.put("eventInfo", resultEventInfo);
		myModel.put("comments", comments);
		myModel.put("ownerInfo", owner);
		myModel.put("categoryInfo", category);
		myModel.put("totalPartNumb", totalParticipantNumber);
		myModel.put("comingPartNumb", comingParticipantNumber);
		myModel.put("maybePartNumb", maybeParticipantNumber);
		ModelAndView mv = new ModelAndView("eventdetail", "dataMap", myModel);
		
		mv.addObject("commentData",new CommentData());
		mv.addObject("comeForSure",new ParticipantData());
		mv.addObject("maybeComming",new ParticipantData());
		return mv;
	}

	public void setEventManager(EventManager eventManager) {
		this.eventManager = eventManager;
	}

	public void setCategoryManager(CategoryManager categoryManager) {
		this.categoryManager = categoryManager;
	}

}
