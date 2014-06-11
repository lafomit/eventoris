<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/WEB-INF/jsp/include_links.jsp"%>

<title>Eventoris | Creare cont</title>

<%@ include file="/WEB-INF/jsp/include_menu.jsp"%>

<form:form method="post" commandName="createUser">
	<table width="95%" bgcolor="f8f8ff" border="0" cellspacing="0"
		cellpadding="5">

		<tr>
			<td align="right" width="20%">Nume:</td>
			<td width="20%"><form:input path="name" /></td>
			<td width="60%"><form:errors path="name" cssClass="error" /></td>
		</tr>
		<tr>
			<td align="right" width="20%">Family:</td>
			<td width="20%"><form:input path="familyName" /></td>
			<td width="60%"><form:errors path="familyName" cssClass="error" />
			</td>
		</tr>

		<tr>
			<td align="right" width="20%">Email:</td>
			<td width="20%"><form:input path="email" /></td>
			<td width="60%"><form:errors path="email" cssClass="error" /></td>
		</tr>
	</table>

	<br>
	<input type="submit" align="center" value="Creaza Acum">
</form:form>
<%@ include file="/WEB-INF/jsp/include_footer.jsp"%>
<%@ include file="/WEB-INF/jsp/include_scripts.jsp"%>
