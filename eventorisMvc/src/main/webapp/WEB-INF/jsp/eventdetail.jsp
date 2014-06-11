<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/WEB-INF/jsp/include_links.jsp"%>

<title>Eventoris | event detail</title>

<%@ include file="/WEB-INF/jsp/include_menu.jsp"%>
					
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
						<div class = "block">
							<div class = "block-header">
								<img alt="category" src="resources/img/categories/<%=eventInfo.getCategoryID()%>.png">
							
							<h1><%=name %></h1>
							</div>
							<div class = "block-content">
							<p>
							<em>Categorie:</em> XXXXX<br><br>
							<em>Descriere: </em><%=eventInfo.getDescription()%><br><br>
							<em>Data: </em>
							<em>Ora: </em>
							</p>
							</div>
						</div>
					</div>
					<%} %>
				</div>
			</div>
		</div>
		<div class="container clearfix">
			<div id="content" class="grid_12">
				<h1>Discuţii</h1><br>
				<textarea rows="4" cols="50" name="comment" form="insert-comment"></textarea>
				<form action="" id="insert-comment">
  						<input type="submit">
				</form>
			</div>
			<div id="content" class="grid_12">
				<div style="background-color:white; height:200px; width:500px; border: 1px solid gray;">
				   Jora's comment
				</div>
				<div style="background-color:white; height:200px; width:500px; border: 1px solid gray;">
				   Ira's comment
				</div>
				<div style="background-color:white; height:200px; width:500px; border: 1px solid gray;">
				   Vasea's comment
				</div>
			</div>
		</div>
	
<%@ include file="/WEB-INF/jsp/include_footer.jsp"%>
<%@ include file="/WEB-INF/jsp/include_scripts.jsp"%>
