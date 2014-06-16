<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/include_links.jsp"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="java.util.*"%>
<title>Eventoris | Cabinetul personal</title>

<%@ include file="/WEB-INF/jsp/include_menu.jsp"%>


<section>
	<div class="container clearfix">
		<div id="content" class="grid_12">
		 	<div class="delete-profile-link">
		 		<a href="#">Şterge profilul</a>
		 	</div>
			<div class="form-block">	
				<i class = "icon-doc-add"></i>
				<h1>Editează profilul</h1><br>
				
				<form:form method="post" commandName="editProfile" action="profile">
						<form:input path="name" placeholder="Prenumele"/>
						<form:hidden path="eventid" />
					    <form:errors path="name" cssClass="error"/>		
					    					
					    <form:input path="familyname" placeholder="Numele"/>
					    <form:errors path="familyname" cssClass="error"/>
			    		
		    		   <form:input path="password" type="text" placeholder="Parola"/> 
		    			<form:errors path="password" cssClass="error"/> 	
		    			
		    			<form:input path="passwordRepeated" type="text" placeholder="Parola repetată"/>
		    			<form:errors path="passwordRepeated" cssClass="error"/>
		    			
		    			<form:input path="file" type="file" placeholder="Fotografie" value=""/>
		    			<form:errors path="file" cssClass="error"/>
	
						<br>
						<form:label path="category">Categorie </form:label>
					  <br>
					  <button type="submit">Editează</button>
				</form:form>
			</div>
		</div>
	</div>
</section>
<%@ include file="/WEB-INF/jsp/include_footer.jsp"%>
<%@ include file="/WEB-INF/jsp/include_scripts.jsp"%>

