<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page session="true"%>
<%@ page import="java.util.*"%>
<%@ include file="/WEB-INF/jsp/include_links.jsp"%>
<%@ page import="eventoris.datatypes.EventInfo"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Eventoris | Home</title>

<%@ include file="/WEB-INF/jsp/include_menu.jsp"%>

<div id="stick-menu">
	<div class="container clearfix">
		<div class="grid_12 margin-padding-clear">
			<nav id="index-nav">
				<ul class="navigation">
<c:if test="${pageContext.request.userPrincipal.name == null}">
					<li data-slide="1">Home</li>
</c:if>
					<li data-slide="2">Ultimele Evenimente</li>
					<li data-slide="3">Top Evenimente</li>
					<!-- 					<li data-slide="4">Ultimele Noutăţi</li> -->
				</ul>
			</nav>
		</div>
	</div>
</div>
<section>
<!-- Do not show section if logged in -->
<c:if test="${pageContext.request.userPrincipal.name == null}">


	<div class="slide" id="slide1" data-slide="1"
		data-stellar-background-ratio="0.2">
		<div class="container clearfix">
			<div id="content" class="grid_6">
				<div class="intro-text">
					<h1>Hai cu noi</h1>
					<ul>
						<li>să ne distrăm</li>
						<li>să fim mai buni</li>
						<li>să fim prieteni</li>
					</ul>

					<button onclick="window.location.href='login'">Logare</button>
				</div>
			</div>
			<div class="grid_6 omega">
				<div class="registration">
					<div class="form-block">
						<i class="icon-thumbs-up"></i>
						<h1>Înregistrează-te acum!</h1>
						<br>
						<h2>Creează evenimente noi!</h2>
						<br>
						<h2>Participă activ la evenimente!</h2>
						<br>
						<h2>Urmăreşte propriul calendar!</h2>
						<br>
						<button onclick="window.location.href='register_new.htm'">Înregistrare</button>
					</div>
				</div>

			</div>

		</div>
	</div>
</c:if>


<div class="slide" id="slide2" data-slide="2"
	data-stellar-background-ratio="0.2">
	<div class="container clearfix">
		<div id="content" class="grid_12">
			<div class="slide-title">
				<h1>Ultimele Evenimente</h1>
			</div>
		</div>
	</div>
	<div class="container clearfix">
		<div class="grid_12">
			<div class="events">
				<c:forEach items="${model.lastEvents}" var="event">
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
						<div class="right-event-half">
							<div class="event-date-title">
								<h2>Data</h2>
							</div>
							<div class="date-circle" id="day">
								<h1>
									<c:out value="<%=date%>" />
								</h1>
							</div>
							<div class="date-circle" id="month">
								<h3><%=com.eventoris.web.LangUtil.getRoMonthName(month)%></h3>
							</div>
							<div class="date-circle" id="year">
								<h1><%=year%></h1>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</div>
<div class="slide" id="slide3" data-slide="3"
	data-stellar-background-ratio="0.5">
	<div class="container clearfix">
		<div id="content" class="grid_12">
			<div class="slide-title">
				<h1>Top Evenimente</h1>
			</div>
		</div>
	</div>
	<div class="container clearfix">
		<div id="content" class="grid_12">
			<div class="events">
				<c:forEach items="${model.topEvents}" var="event">
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
						<div class="right-event-half">
							<div class="event-date-title">
								<h2>Data</h2>
							</div>
							<div class="date-circle" id="day">
								<h1><%=date%></h1>
							</div>
							<div class="date-circle" id="month">
								<h3><%=com.eventoris.web.LangUtil.getRoMonthName(month)%></h3>
							</div>
							<div class="date-circle" id="year">
								<h1><%=year%></h1>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</div>

</section>
<%@ include file="/WEB-INF/jsp/include_footer.jsp"%>
<%@ include file="/WEB-INF/jsp/include_scripts.jsp"%>
