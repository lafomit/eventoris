<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/jsp/include_links.jsp" %>

<title>Eventoris | Events</title>

<%@ include file="/WEB-INF/jsp/include_menu.jsp" %>

	<div id="stick-menu">
		<div class="container clearfix">
			<div class="grid_12 margin-padding-clear">
			<nav>
				<ul>
					<li><a href="<c:url value="addevent.htm"/>">Adaugă Eveniment</a></li>
					<li>Evenimentele Mele</li>
					<li>Calendarul meu</li>
				</ul>
				</nav>
			</div>

		</div>
	</div>

	<div>
		<div class = "container clearfix">
			<div class="grid_12">
				<c:forEach items="${model.products}" var="event">
      				Title: <c:out value="${event.title}"/> -- Created:<c:out value="${event.dateCreated}"/><br><br>
    			</c:forEach>
			</div>
		</div>
	</div>		     
	
<%@ include file="/WEB-INF/jsp/include_footer.jsp" %>
<%@ include file="/WEB-INF/jsp/include_scripts.jsp" %>