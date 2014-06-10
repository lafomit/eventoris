<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="/WEB-INF/jsp/include_links.jsp" %>

<title>Eventoris | Home</title>

<%@ include file="/WEB-INF/jsp/include_menu.jsp" %>

	<div id="stick-menu">
		<div class="container clearfix">
			<div class="grid_12 margin-padding-clear">
			<div class="class="navigation">
					<a href="login">Intra</a>
					<a href="register_new.htm">Inregistreaza-te</a>
			</div>	
			</div>

		</div>
	</div>

	



	<div class="slide" id="slide1" data-slide="2" data-stellar-background-ratio="0.2">
		<div class="container clearfix">
			<div id="content" class="grid_12">
				<div class="slide-title">
					<h1>Ultimele Evenimente</h1>
				</div>
			</div>
		</div>
		<div class="container clearfix">
			<div class="grid_12">
				<div class = "last-events">
					<p>
						<c:forEach items="${model.lastEvents}" var="event">
					    	Title: <c:out value="${event.title}"/> -- Created:<c:out value="${event.dateCreated}"/><br><br>
					    </c:forEach>
					</p>
				</div>
			</div>
		</div>
	</div>

<!-- 

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
				<div class = "top-events">
					<p>
						<c:forEach items="${model.topEvents}" var="event">
					    	Title: <c:out value="${event.title}"/> -- Created:<c:out value="${event.dateCreated}"/><br><br>
					    </c:forEach>
					</p>
				</div>
			</div>
		</div>
	</div>
 -->
	
<%@ include file="/WEB-INF/jsp/include_footer.jsp" %>
<%@ include file="/WEB-INF/jsp/include_scripts.jsp" %>