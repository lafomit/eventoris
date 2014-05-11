<%@ include file="/WEB-INF/jsp/include.jsp" %>

<html>
  <head><title>Hello :: eventList</title></head>
  <body>
    <h1>Hello: event list</h1>
    <p>Greetings, it is now <c:out value="${model.now}"/></p>
    
    <c:forEach items="${model.products}" var="event">
      Title: <c:out value="${event.title}"/> -- Created:<c:out value="${event.dateCreated}"/><br><br>
    </c:forEach>
    
     <a href="<c:url value="addevent.htm"/>">Add event</a>
  </body>
</html>