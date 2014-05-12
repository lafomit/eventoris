<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/jsp/include_links.jsp" %>

<title>Eventoris | All Events</title>

<%@ include file="/WEB-INF/jsp/include_menu.jsp" %>


    <h1>Hello: event list</h1>
    <p>Greetings, it is now <c:out value="${model.now}"/></p>
    
    <c:forEach items="${model.products}" var="event">
      Title: <c:out value="${event.title}"/> -- Created:<c:out value="${event.dateCreated}"/><br><br>
    </c:forEach>
    
     <a href="<c:url value="addevent.htm"/>">Add event</a>
  </body>
</html>