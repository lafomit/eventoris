<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/WEB-INF/jsp/include_links.jsp"%>

 <!-- Do not show page if logged in -->
 	   <c:if test="${pageContext.request.userPrincipal.name != null}">
			 <c:redirect url="/myevents.htm"/>
		</c:if>
		
<title>Eventoris | Utilizator creat</title>

<%@ include file="/WEB-INF/jsp/include_menu.jsp"%>
	
	Utilizatorul a fost creat cu success
	
<%@ include file="/WEB-INF/jsp/include_footer.jsp"%>
<%@ include file="/WEB-INF/jsp/include_scripts.jsp"%>
