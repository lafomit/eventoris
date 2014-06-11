<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/WEB-INF/jsp/include_links.jsp"%>

<title>Eventoris | event detail</title>

<%@ include file="/WEB-INF/jsp/include_menu.jsp"%>

<h1>
	<fmt:message key="addevent.heading" />
</h1>
<%
					eventoris.datatypes.EventInfo eventInfo = ((eventoris.datatypes.EventInfo)request.getAttribute("eventInfo"));
					if(eventInfo == null){
					%>	Ne cerem scuze dar evenimentul cerut nu a fost gasit<% 
					}else{ 
				    String name =  eventInfo.getTitle();
 					%>
					
								Nume:<%=name %>

					<%} %>
<%@ include file="/WEB-INF/jsp/include_footer.jsp"%>
<%@ include file="/WEB-INF/jsp/include_scripts.jsp"%>
