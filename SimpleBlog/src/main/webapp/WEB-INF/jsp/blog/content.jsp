<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${!empty blogEntry}">
	<table border="1" >
		<tr>
			<td><h2>${blogEntry.title}</h2>
		</tr>
		<tr>
			<td>Author: ${blogEntry.author}|Published:
				${blogEntry.publish_date}</td>
		</tr>
		<tr>
			<td>${blogEntry.content}</td>
		</tr>
	</table>
</c:if>