<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import = "java.util.*" %> 
<%@ include file="/WEB-INF/jsp/include_links.jsp" %>
 
<title>Eventoris | Login </title>

<style>
.error {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}

.msg {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
}

#login-box {
	width: 300px;
	padding: 20px;
	margin: 100px auto;
	background: #fff;
	-webkit-border-radius: 2px;
	-moz-border-radius: 2px;
	border: 1px solid #000;
}
</style>

<%@ include file="/WEB-INF/jsp/include_menu.jsp" %>

	<div id="stick-menu">
		<div class="container clearfix">
			<div class="grid_12 margin-padding-clear">
			<nav id="index-nav">
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


	<div id="login-box">

		<h3>Login with Username and Password</h3>

		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>

		<form name='loginForm'
			action="<c:url value='/j_spring_security_check' />" method='POST'>

			<table>
				<tr>
					<td>User:</td>
					<td><input type='text' name='username'></td>
				</tr>
				<tr>
					<td>Parola:</td>
					<td><input type='password' name='password' /></td>
				</tr>
				<tr>
					<td colspan='2'><input name="submit" type="submit"
						value="submit" /></td>
				</tr>
			</table>

			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />

		</form>
	</div>

 <%@ include file="/WEB-INF/jsp/include_footer.jsp" %>
<%@ include file="/WEB-INF/jsp/include_scripts.jsp" %>