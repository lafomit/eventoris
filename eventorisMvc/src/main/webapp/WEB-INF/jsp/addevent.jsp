<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="/WEB-INF/jsp/include_links.jsp" %>

<title>Eventoris | Home</title>

<%@ include file="/WEB-INF/jsp/include_menu.jsp" %>

<div>
	<div class = "container clearfix">
		<div class="grid_12">
			<h1><fmt:message key="addevent.heading"/></h1>
			<form:form method="post" commandName="createEvent">
				<form:input path="title"/>
			    <form:errors path="title" cssClass="error"/>
			          
			    <form:input path="description"/>
			    <form:errors path="description" cssClass="error"/>
			        
			    <form:select path="category">
			    	<form:options items="${categories}" />
			    </form:select>			        
			    <form:errors path="category" cssClass="error"/>
			  
			  <br>
			  <input type="submit" value="Execute">
			</form:form>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/jsp/include_footer.jsp" %>
<%@ include file="/WEB-INF/jsp/include_scripts.jsp" %>