<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Spring 3 MVC Series - Contact Manager</title>
</head>
<body>
	<h2>Contact Manager</h2>
	<!--  form is getting submitted to addContact.html. in web.xml it is defined that 
			any *.html page submissions should be intercepted by the 'spring' servlet mapping
			and taken care of by the DispatcherServlet servlet		
	 -->
	<form:form method="post" action="addContact.html">

		<table>
			<tr>
				<!-- The path attribute matches the bean setter/getter name for 
					a contact class -->
				<!-- hooks into the defined content in the appropriate messages property file --> 
				<td><form:label path="firstname"><spring:message code="label.firstname"/></form:label></td>
				<td><form:input path="firstname" /></td>
			</tr>
			<tr>
				<td><form:label path="lastname"><spring:message code="label.lastname"/></form:label></td>
				<td><form:input path="lastname" /></td>
			</tr>
			<tr>
				<td><form:label path="lastname"><spring:message code="label.email"/></form:label></td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td><form:label path="lastname"><spring:message code="label.telephone"/></form:label></td>
				<td><form:input path="telephone" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="<spring:message code="label.addcontact"/>" /></td>
			</tr>
		</table>

	</form:form>
</body>
</html>