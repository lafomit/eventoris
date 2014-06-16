<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/include_links.jsp"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="java.util.*"%>
<title>Eventoris | Calendarul meu</title>

<%@ include file="/WEB-INF/jsp/include_menu.jsp"%>

<div id="stick-menu">
	<div class="container clearfix">
		<div class="grid_12 margin-padding-clear">
			<nav id="add-event-nav">
				<ul>
					<li><a href="<c:url value="addevent.htm"/>">Adaugă
							Eveniment</a></li>
					<li><a href="myevents.htm">Evenimentele mele</a></li>
					<li><a href="mycalendar.htm">Calendarul meu</a></li>
				</ul>
			</nav>
		</div>

	</div>
</div>
<section>
<div class="container clearfix">
	<div id="content" class="grid_6">
		<div class="events">
			<c:choose>
				<c:when test="${empty model.productsGoing} ">
					<div class="error-page">
						<div class="smile">
							<i class="icon-emo-unhappy"></i>
						</div>
						<div class="message">
							<h2>Nu participi la nici un eveniment. Alătură-te acum!</h2>
						</div>
					</div>
			    </c:when>
				<c:otherwise>
					<h2>Participi</h2>
					<c:forEach items="${model.productsGoing}" var="event">
						<%
							Calendar cal = Calendar.getInstance();
										String tmp = ((eventoris.datatypes.EventInfo) pageContext
												.findAttribute("event")).getDateOfEvent();
										String year = tmp.substring(0, 4);
										String date = tmp.substring(8, 10);
										int month = Integer.parseInt(tmp.substring(5, 7));
						%>
						<div class="event-body">
							<div class="left-event-half">
								<div class="event-title">
									<h2>
										<c:out value="${event.title}" /> 
									</h2>
								</div>
								<div class="event-description">
									<img alt="category"
										src="resources/img/categories/<c:out value="${event.categoryID}"/>.png"/>
									<p>
										<em>Descrierea: </em>
										<c:out value="${event.description}" />
									</p>
									<a
										href="eventdetail.htm?event=<c:out value="${event.eventID}"/>">Vezi
										tot</a>
								</div>
							</div>
						</div>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</div>
	</div>

	<div id="content" class="grid_6">
		<div class="events">
			<c:choose>
				<c:when test="${empty model.productsMaybe} ">
						<div class="error-page">
						<div class="smile">
							<i class="icon-emo-unhappy"></i>
						</div>
						<div class="message">
							<h2>Încă nu urmăreşti nici un eveniment</h2>
						</div>
					</div>
			    </c:when>
				<c:otherwise>
				<h2>Posibil să participi</h2>
					<c:forEach items="${model.productsMaybe}" var="event">
						<%
							Calendar cal = Calendar.getInstance();
										String tmp = ((eventoris.datatypes.EventInfo) pageContext
												.findAttribute("event")).getDateOfEvent();
										String year = tmp.substring(0, 4);
										String date = tmp.substring(8, 10);
										int month = Integer.parseInt(tmp.substring(5, 7));
						%>
						<div class="event-body">
							<div class="left-event-half">
								<div class="event-title">
									<h2>
										<c:out value="${event.title}" />
									</h2>
								</div>
								<div class="event-description">
									<img alt="category"
										src="resources/img/categories/<c:out value="${event.categoryID}"/>.png">
									<p>
										<em>Descrierea: </em>
										<c:out value="${event.description}" />
									</p>
									<a
										href="eventdetail.htm?event=<c:out value="${event.eventID}"/>">Vezi
										tot</a>
								</div>
							</div>
						</div>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</div>
</section>
<%@ include file="/WEB-INF/jsp/include_footer.jsp"%>
<%@ include file="/WEB-INF/jsp/include_scripts.jsp"%>

