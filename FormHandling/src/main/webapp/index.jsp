<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring MVC Form Handling</title>
</head>
<body>

	<h2>Student Information</h2>
	<form method="POST" action = "/FormHandling/addStudent">
		<table>
			<tr>
				<td><label for="name">Name</label></td>
				<td><input type="text" id="name" name="name"/></td>
			</tr>
			<tr>
		        <td><label for="age">Age</label></td>
		        <td><input type="text" id="age" name="age" /></td>
		    </tr>
		    <tr>
		        <td><label for="id">id</label></td>
		        <td><input type="text" id="id" name="id"/></td>
		    </tr>
		    <tr>
		        <td colspan="2">
		            <input type="submit" value="Submit"/>
		        </td>
		    </tr>
		</table>
	</form>
</body>
</html>