<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import = "java.util.*" %> 
<%@ include file="/WEB-INF/jsp/include_links.jsp" %>
<%@ page import ="eventoris.datatypes.EventInfo" %>
<title>Eventoris | Home</title>

<%@ include file="/WEB-INF/jsp/include_menu.jsp" %>

	<div id="stick-menu">
		<div class="container clearfix">
			<div class="grid_12 margin-padding-clear">
			<nav>
				<ul class="navigation">
					<li data-slide="1">Home</li>
					<li data-slide="2">Ultimele Evenimente</li>
					<li data-slide="3">Top Evenimente</li>
<!-- 					<li data-slide="4">Ultimele Noutăţi</li> -->
				</ul>
				</nav>
			</div>	
		</div>
	</div>

<div class="slide" id="slide1" data-slide="1" data-stellar-background-ratio="0.2">
		<div class="container clearfix">
			<div id="content" class="grid_6">
				<div class="intro-text">
					<h1>Hai cu noi</h1>
					<ul>
						<li>să ne distrăm</li>
						<li>să fim mai buni</li>
						<li>să fim prieteni</li>
					</ul>
					
					<button>Logare</button>
				</div>
			</div>
			<div class="grid_6 omega">
				
			</div>

		</div>
	</div>



	<div class="slide" id="slide2" data-slide="2" data-stellar-background-ratio="0.2">
		<div class="container clearfix">
			<div id="content" class="grid_12">
				<div class="slide-title">
					<h1>Ultimele Evenimente</h1>
				</div>
			</div>
		</div>
		<div class="container clearfix">
			<div class="grid_12">
				<div class = "events">
				<c:forEach items="${model.lastEvents}" var="event">
					<%
					Calendar cal = Calendar.getInstance();
				    String tmp = ((eventoris.datatypes.EventInfo)pageContext.findAttribute("event")).getDateOfEvent();
				    String year = tmp.substring(0, 4);
				    String date = tmp.substring(8,10);
					String month = tmp.substring(5,7);
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
								<a href="#">Vezi tot</a>
							</div>
						</div>
						<div class="right-event-half">
								<div class="event-date-title">
									<h2>Data</h2>
								</div>
								<div class = "date-circle" id="day">
									<h1><c:out value="<%=date%>"/></h1>
								</div>
								<div class = "date-circle" id="month">
									<h3><%=month %></h3>
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
	</div>



	<div class="slide" id="slide3" data-slide="3" data-stellar-background-ratio="0.5">
		<div class="container clearfix">
			<div id="content" class="grid_12">
				<div class="slide-title">
					<h1>Top Evenimente</h1>
				</div>
			</div>
		</div>
		<div class="container clearfix">
			<div id="content" class="grid_12">
				<div class = "events">
					<c:forEach items="${model.topEvents}" var="event">
						<div class = "event-body">
							<div class="event-title">
								<h2><c:out value="${event.title}"/></h2>
							</div>
							<div class = "event-description">							
								<img alt="category" src="resources/img/categories/<c:out value="${event.categoryID}"/>.png">
								<p>
									<em>Descrierea: </em><c:out value="${event.description}"/>
								</p>
								<a href="#">Vezi tot</a>
							</div>
						</div>
						<div class="">
						
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>


<!-- 
	<div class="slide" id="slide4" data-slide="4" data-stellar-background-ratio="0.2">
		<div class="container clearfix">
			<div id="content" class="grid_12">
				<div class="slide-title">
					<h1>Ultimele Noutăţi</h1>
				</div>
			</div>
		</div>
	</div>
	 -->
	
<%@ include file="/WEB-INF/jsp/include_footer.jsp" %>
<%@ include file="/WEB-INF/jsp/include_scripts.jsp" %>