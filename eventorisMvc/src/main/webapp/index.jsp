<%@ page import = "eventoris.dao.EventJDBCTemplate" %>
<%@ page import = "org.springframework.context.ApplicationContext" %>
<%@ page import = "org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@ page import = "eventoris.datatypes.EventInfo;" %>

<html>
<body>
<h2>Hello World!</h2>
<p>
<%
ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

EventJDBCTemplate eventJdbcTemplate = (EventJDBCTemplate)context.getBean("eventJDBCTemplate");
EventInfo event = new EventInfo();

event = eventJdbcTemplate.getEvent(2);

System.out.println(event);
%>
</p>
</body>
</html>
