<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/WEB-INF/jsp/include_links.jsp"%>

 <!-- Do not show page if logged in -->
 	   <c:if test="${pageContext.request.userPrincipal.name != null}">
			 <c:redirect url="/myevents.htm"/>
		</c:if>
		
<title>Eventoris | Utilizator creat</title>

<jsp:include page="/WEB-INF/jsp/include_menu.jsp">
	<jsp:param name = "active" value ="none"/>
</jsp:include>
	<section class="error-page">
	<div class="container clearfix">
		<div id="content" class="grid_12">
			<h1>Eşti înregistrat</h1>
			<div class="smile">
				<i class="icon-emo-thumbsup"></i>
			</div>
			<div class="message">
				<h2>Bine ai venit în familia noastră!</h2>
			</div>
		</div>
	</div>
</section>
	
<%@ include file="/WEB-INF/jsp/include_footer.jsp"%>
<%@ include file="/WEB-INF/jsp/include_scripts.jsp"%>
