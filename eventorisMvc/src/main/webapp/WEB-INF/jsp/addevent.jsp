<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="/WEB-INF/jsp/include_links.jsp" %>
 <link rel="stylesheet" href="resources/css/datepicker.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<script>
	$(function() {
		$('#datepicker').datepicker({  
            inline: true,  
            showOtherMonths: true,  
            dayNamesMin: ['Lu', 'Ma', 'Mi', 'Jo', 'Vi', 'Si', 'Du'],  
            monthNames:['Ianuarie','Februarie','Martie','Aprilie','Mai','Iunie','Iulie','August','Septembrie','Octombrie','Noiembrie','Decembrie'],
        }); 
});
</script>

<title>Eventoris | Adaugă eveniment</title>


<jsp:include page="/WEB-INF/jsp/include_menu.jsp">
	<jsp:param name = "active" value ="event"/>
</jsp:include>
<div id="stick-menu">
	<div class="container clearfix">
		<div class="grid_12 margin-padding-clear">
			<nav id="add-event-nav">
				<ul>
					<li><a href="<c:url value="addevent.htm"/>">Adaugă Eveniment</a></li>
					<li><a href="myevents.htm">Evenimentele mele</a></li>
					<li><a href="mycalendar.htm">Calendarul meu</a></li>
				</ul>
			</nav>
		</div>

	</div>
</div>
<section>
	<div class = "container clearfix">
		<div class="grid_12">
		<div class="form-block">
					
			<i class = "icon-pencil"></i>
			<h1>Gestiune eveniment</h1><br>
			
			<form:form method="post" commandName="createEvent" action="/eventorisMvc/addevent.htm">
					<form:input path="title" placeholder="Titlu"/>
					<form:hidden path="eventid" />
				    <form:errors path="title" cssClass="error" id="add-event"/>
				    
					<form:textarea path="description" rows="4" cols="50" placeholder="Descriere"/>				
				    
				    <form:errors path="description" cssClass="error"/>  
				
				    <form:input path="address" placeholder="Adresa"/>
				    <form:errors path="address" cssClass="error"/>
		    		
	    		   <form:input path="eventdate" type="text" id="datepicker" placeholder="Data"/> 
	    			<form:errors path="eventdate" cssClass="error"/> 	
	    			
	    			<form:input path="hour" type="text" placeholder="Ora"/>
	    			<form:errors path="hour" cssClass="error"/>
	    			
	    			<form:input path="minutes" type="text" placeholder="Minute"/>
	    			<form:errors path="minutes" cssClass="error"/>

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
</section>
<%@ include file="/WEB-INF/jsp/include_footer.jsp" %>
<%@ include file="/WEB-INF/jsp/include_scripts.jsp" %>