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

import eventoris.datatypes.ParticipantInfo;

@Controller

public class ParticipateController {

	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private EventManager eventManager;
	private final int GOING = 1;
	private  final int MAYBE_GOING = 2;

	@RequestMapping(value = "/comeforsure**", method = RequestMethod.POST)
	public String submitComming(
			@ModelAttribute("comeForSure") ParticipantData participantData,	BindingResult result, Model model) {
		ModelAndView mv = new ModelAndView();
		logger.info("AddParticipant: with status=going; for eventId=" + participantData.getEventid());
		mv.addObject("comeForSure", participantData);
		UserSessionInfo activeUser = (UserSessionInfo) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();

		ParticipantInfo participant = new ParticipantInfo();
		participant.setIdEvent(participantData.getEventid());
		participant.setIdUser(activeUser.getId());
		participant.setIdStatus(GOING);

		logger.info("AddParticipant: eventManager=" + eventManager);
		eventManager.participate(participant);
		return "redirect:eventdetail.htm?event=" + participantData.getEventid();

	}
	
	@RequestMapping(value = "/maybe**", method = RequestMethod.POST)
	public String submitMaybeComming(
			@ModelAttribute("maybeComming") ParticipantData participantData,	BindingResult result, Model model) {
		ModelAndView mv = new ModelAndView();
		logger.info("AddParticipant: with status=maybe going; for eventId=" + participantData.getEventid());
		mv.addObject("maybeComming", participantData);
		UserSessionInfo activeUser = (UserSessionInfo) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();

		ParticipantInfo participant = new ParticipantInfo();
		participant.setIdEvent(participantData.getEventid());
		participant.setIdUser(activeUser.getId());
		participant.setIdStatus(MAYBE_GOING);

		logger.info("AddParticipant: status=" + participant.getIdStatus());
		eventManager.participate(participant);
		return "redirect:eventdetail.htm?event=" + participantData.getEventid();

	}

	public void setEventManager(EventManager eventManager) {
		this.eventManager = eventManager;
	}
}