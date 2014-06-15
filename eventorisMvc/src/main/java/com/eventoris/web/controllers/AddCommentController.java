package com.eventoris.web.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eventoris.service.EventManager;
import com.eventoris.web.auth.UserSessionInfo;

import eventoris.datatypes.CommentInfo;

@Controller
@RequestMapping(value = "/addcomment**")
public class AddCommentController {

	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private EventManager eventManager;

	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(
			@ModelAttribute("commentData") CommentData commentData,
			BindingResult result, Model model) {
		ModelAndView mv = new ModelAndView();
		logger.info("AddCommentController: adding comment for eventId="
				+ commentData.getEventid());
		mv.addObject("commentData", commentData);
		UserSessionInfo activeUser = (UserSessionInfo) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();

		CommentInfo comment = new CommentInfo();
		comment.setComment(commentData.getComments());
		comment.setEventId(commentData.getEventid());
		comment.setPosterId(activeUser.getId());

		logger.info("AddCommentController: eventManager=" + eventManager);
		eventManager.addComment(comment);
		return "redirect:eventdetail.htm?event=" + commentData.getEventid();

	}

	public void setEventManager(EventManager eventManager) {
		this.eventManager = eventManager;
	}
}