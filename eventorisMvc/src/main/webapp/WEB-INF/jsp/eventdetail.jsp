<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ include file="/WEB-INF/jsp/include_links.jsp"%>

<title>Eventoris | event detail</title>

<%@ include file="/WEB-INF/jsp/include_menu.jsp"%>
<<<<<<< HEAD
					
			<div class="container clearfix">
			<div id="content" class="grid_12">
				<div class = "event-detail-wrapper">
					<%
						eventoris.datatypes.EventInfo eventInfo = ((eventoris.datatypes.EventInfo)request.getAttribute("eventInfo"));
						if(eventInfo == null){
					%>	
						Ne cerem scuze dar evenimentul cerut nu a fost gasit
					<% 
						}else{ 
					    	String name =  eventInfo.getTitle();
	 				%>
					<div class = "left-column-eventdetail">
						<div class = "block" id="details">
							<div class = "block-header" >
								<img alt="category" src="resources/img/categories/<%=eventInfo.getCategoryID()%>.png">
							
							<h1><%=name %></h1>
							</div>
							<div class = "details-content">
							<p>
							<em>Categorie:</em> XXXXX<br><br>
							<em>Descriere: </em><%=eventInfo.getDescription()%><br><br>
=======


<div class="container clearfix">
	<div id="content" class="grid_12">
		<div class="event-detail-wrapper">
			<%
				Map<String, Object> map = (Map<String, Object>) request
						.getAttribute("dataMap");

				if (map == null) {
			%>
			Ne cerem scuze dar evenimentul cerut nu a fost gasit
			<%
				} else {
					eventoris.datatypes.EventInfo eventInfo = ((eventoris.datatypes.EventInfo) map
							.get("eventInfo"));
					String name = eventInfo.getTitle();
			%>
			<div class="left-column-eventdetail">
				<div class="block">
					<div class="block-header">
						<img alt="category"
							src="resources/img/categories/<%=eventInfo.getCategoryID()%>.png">

						<h1><%=name%></h1>
					</div>
					<div class="block-content">
						<p>
							<em>Categorie:</em> XXXXX<br>
							<br> <em>Descriere: </em><%=eventInfo.getDescription()%><br>
							<br>
>>>>>>> origin/master
							<%
								String tmp = eventInfo.getDateOfEvent();
									String year = tmp.substring(0, 4);
									String date = tmp.substring(8, 10);
									String month = tmp.substring(5, 7);
							%>
							<em>Data: </em>
							<%=date%>.<%=month%>.<%=year%><br>
							<br>
							<%
								String hour = tmp.substring(11, 13);
									String minutes = tmp.substring(14, 16);
							%>
<<<<<<< HEAD
							<em>Ora: </em> <%=hour%>:<%=minutes %>
							</p>
							</div>
						</div>
						<div class = "block" id="coming">
							<div class = "block-header">
								<img alt="category" src="resources/img/block icons/comming.jpg">
							
							<h1>Cine va veni?</h1>
							</div>
							<div class = "participants-content">
								<div class="participant">
									<img alt="profile picture" src="resources/img/avatars/0.jpg">
									<em>Vasea Mamaliga</em>
								</div>
								<div class="participant">
									<img alt="profile picture" src="resources/img/avatars/2.jpg">
									<em>Uashiva Patlajica</em>
								</div>
								<div class="participant">
									<img alt="profile picture" src="resources/img/avatars/3.jpg">
									<em>Alina Stepanida</em>
								</div>
									<a href="#">Vezi toţi (32)</a><br><br>
									<button>Hai!</button>
							</div>
						</div>
=======
							<em>Ora: </em>
							<%=hour%>:<%=minutes%>
						</p>

>>>>>>> origin/master
					</div>
				</div>

			</div>
		</div>
	</div>
	<%
		}
	%>
</div>
</div>
</div>
<div class="container clearfix">
	<div id="content" class="grid_12">
		<h1>Discuţii</h1>
		<br>
		<textarea rows="4" cols="50" name="comment" form="insert-comment"></textarea>
		<form action="" id="insert-comment">
			<input type="submit">
		</form>
	</div>
	<div id="content" class="grid_12">
		<%
			if (map != null) {
		%>
		<c:forEach items="${dataMap.comments}" var="event">
			<div
				style="background-color: white; height: 200px; width: 500px; border: 1px solid gray;">
				<c:out value="${event.comment}" />
			</div>

		</c:forEach>
		<%
			}
		%>



	</div>
</div>

<%@ include file="/WEB-INF/jsp/include_footer.jsp"%>
<%@ include file="/WEB-INF/jsp/include_scripts.jsp"%>
