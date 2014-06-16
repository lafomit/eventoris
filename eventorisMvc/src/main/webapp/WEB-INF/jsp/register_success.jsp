<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/WEB-INF/jsp/include_links.jsp"%>

 <!-- Do not show page if logged in -->
 	   <c:if test="${pageContext.request.userPrincipal.name != null}">
			 <c:redirect url="/myevents.htm"/>
		</c:if>
		
<title>Eventoris | Utilizator creat</title>

<%@ include file="/WEB-INF/jsp/include_menu.jsp"%>
	<section>
		<div class="form-block">
			<form:form method="post" commandName="createUser">
			
				<i class = "icon-user-add-outline"></i>
				<h1>Cum te numeşti?</h1><br>
			
				<form:input path="familyName" placeholder="Nume"/>
				<form:errors path="familyName" cssClass="error" />
			
				<form:input path="name" placeholder="Prenume"/>
				<form:errors path="name" cssClass="error" />
			
				<form:hidden path="userid" value=""/>
		 	
				<br>
				<button type="submit">Ok</button><br>
			</form:form>
		</div>
	</section>
	
<%@ include file="/WEB-INF/jsp/include_footer.jsp"%>
<%@ include file="/WEB-INF/jsp/include_scripts.jsp"%>
