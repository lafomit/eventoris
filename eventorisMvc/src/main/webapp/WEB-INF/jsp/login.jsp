<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import = "java.util.*" %> 
<%@ include file="/WEB-INF/jsp/include_links.jsp" %>
 
 <!-- Do not show page if logged in -->
 	   <c:if test="${pageContext.request.userPrincipal.name != null}">
			 <c:redirect url="/myevents.htm"/>
		</c:if>
		
<title>Eventoris | Logare </title>

<%@ include file="/WEB-INF/jsp/include_menu.jsp" %>

	<div class="container clearfix">
			<div id="content" class="grid_12">
				<div class="form-block">
					
					<i class = "icon-user-outline"></i>
					<h1>Logare</h1><br>
		
					
					<c:if test="${not empty error}">
						<div class="error">${error}</div>
					</c:if>
					<c:if test="${not empty msg}">
						<div class="msg">${msg}</div>
					</c:if>

					<form name='loginForm' action="<c:url value='/j_spring_security_check' />" method='POST'>

						<input type='text' name='username' placeholder="Username"/><br>
						<input type='password' name='password' placeholder = "Password"/><br>
						<button type="submit">Ok</button><br>
			
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />			
					</form>
				</div>
			</div>
	</div>

 <%@ include file="/WEB-INF/jsp/include_footer.jsp" %>
<%@ include file="/WEB-INF/jsp/include_scripts.jsp" %>