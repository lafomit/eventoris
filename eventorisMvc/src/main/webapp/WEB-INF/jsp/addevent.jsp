<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="/WEB-INF/jsp/include_links.jsp" %>

<title>Eventoris | Home</title>

<%@ include file="/WEB-INF/jsp/include_menu.jsp" %>

<div>
	<div class = "container clearfix">
		<div class="grid_12">
		<div class="form-block">
					
			<i class = "icon-doc-add"></i>
			<h1>Adaugă eveniment</h1><br>
			
			<form:form method="post" commandName="createEvent">
					<form:input path="title" placeholder="Titlu"/>
				    <form:errors path="title" cssClass="error" id="add-event"/>
				    
					<form:textarea path="description" rows="4" cols="50" placeholder="Descriere"/>				
				    
				    <form:errors path="description" cssClass="error"/>  
				
				    <form:input path="address" placeholder="Adresa"/>
				    <form:errors path="address" cssClass="error"/>
		    
				    <form:input path="eventdate" placeholder="Data evenimentului"/>
				    <form:errors path="eventdate" cssClass="error"/>
					<br>
					<form:label path="category">Categorie </form:label>
				    <form:select path="category">
				    	<form:option value=""/>
				    	<form:options items="${categories}" />
				    </form:select><br>			        
				    <form:errors path="category" cssClass="error"/>
				  <br>
				  <button type="submit">Adaugă</button>
			</form:form>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/jsp/include_footer.jsp" %>
<%@ include file="/WEB-INF/jsp/include_scripts.jsp" %>