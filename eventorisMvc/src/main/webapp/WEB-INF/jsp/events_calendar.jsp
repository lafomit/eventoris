<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/jsp/include_links.jsp" %>
<%@ page import = "java.util.*" %> 
<title>Eventoris | MyCalendar</title>

<%@ include file="/WEB-INF/jsp/include_menu.jsp" %>

	<div id="stick-menu">
		<div class="container clearfix">
			<div class="grid_12 margin-padding-clear">
			<nav id="add-event-nav">
				<ul>
					<li><a href="<c:url value="addevent.htm"/>">Adaugă Eveniment</a></li>
					<a href="myevents.htm">Evnimentele mele</a>
					<a href="mycalendar.htm">Calendarul meu</a>
				</ul>
				</nav>
			</div>

		</div>
	</div>
<!-- 
	<div>
		<div class = "container clearfix">
			<div class="grid_12">
				<c:forEach items="${model.products}" var="event">
      				Title: <c:out value="${event.title}"/> -- Created:<c:out value="${event.dateCreated}"/><br><br>
    			</c:forEach>
			</div>
		</div>
	</div>		 -->    
	
	GOING
	<div class="container clearfix">
			<div id="content" class="grid_12">
				<div class = "events">
					<c:forEach items="${model.productsGoing}" var="event">
						<%
							Calendar cal = Calendar.getInstance();
						    String tmp = ((eventoris.datatypes.EventInfo)pageContext.findAttribute("event")).getDateOfEvent();
						    String year = tmp.substring(0, 4);
						    String date = tmp.substring(8,10);
						    int month = Integer.parseInt(tmp.substring(5,7));
						%>
						<div class = "event-body">
							<div class="left-event-half">
								<div class="event-title">
									<h2><c:out value="${event.title}"/></h2>
								</div>
								<div class = "event-description">							
									<img alt="category" src="resources/img/categories/<c:out value="${event.categoryID}"/>.png">
									<p>
										<em>Descrierea: </em><c:out value="${event.description}"/>
									</p>
									<a href="eventdetail.htm?event=<c:out value="${event.eventID}"/>">Vezi tot</a>
								</div>
							</div>
							<div class="right-event-half">
								<div class="event-date-title">
									<h2>Data</h2>
								</div>
								<div class = "date-circle" id="day">
									<h1><%=date%></h1>
								</div>
								<div class = "date-circle" id="month">
									<h3><%=com.eventoris.web.LangUtil.getRoMonthName(month) %></h3>
								</div>
								<div class = "date-circle" id="year">
									<h1><%=year %></h1>
								</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
		MaybeGoing
		
		<div class="container clearfix">
			<div id="content" class="grid_12">
				<div class = "events">
					<c:forEach items="${model.productsMaybe}" var="event">
						<%
							Calendar cal = Calendar.getInstance();
						    String tmp = ((eventoris.datatypes.EventInfo)pageContext.findAttribute("event")).getDateOfEvent();
						    String year = tmp.substring(0, 4);
						    String date = tmp.substring(8,10);
						    int month = Integer.parseInt(tmp.substring(5,7));
						%>
						<div class = "event-body">
							<div class="left-event-half">
								<div class="event-title">
									<h2><c:out value="${event.title}"/></h2>
								</div>
								<div class = "event-description">							
									<img alt="category" src="resources/img/categories/<c:out value="${event.categoryID}"/>.png">
									<p>
										<em>Descrierea: </em><c:out value="${event.description}"/>
									</p>
									<a href="eventdetail.htm?event=<c:out value="${event.eventID}"/>">Vezi tot</a>
								</div>
							</div>
							<div class="right-event-half">
								<div class="event-date-title">
									<h2>Data</h2>
								</div>
								<div class = "date-circle" id="day">
									<h1><%=date%></h1>
								</div>
								<div class = "date-circle" id="month">
									<h3><%=com.eventoris.web.LangUtil.getRoMonthName(month) %></h3>
								</div>
								<div class = "date-circle" id="year">
									<h1><%=year %></h1>
								</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>	
			
<%@ include file="/WEB-INF/jsp/include_footer.jsp" %>
<%@ include file="/WEB-INF/jsp/include_scripts.jsp" %>