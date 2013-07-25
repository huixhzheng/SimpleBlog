<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<h3>${title}</h3>
<c:if test="${!empty blogEntries}">
	<c:forEach items="${blogEntries}" var="blogEntry">
		<table style="background-color: DeepPink;" border="1">
			<tr>
				<td><span class="blogTitle">
						<a href="/SimpleBlog/blogView/${blogEntry.id}">${blogEntry.title}</a>
					</span></td>
			</tr>
			<tr>
				<td>Author: ${blogEntry.author}|Published:
					${blogEntry.publish_date}</td>
			</tr>
			<tr>
				<td>${blogEntry.content} &nbsp; <a
					href="/SimpleBlog/blogView/${blogEntry.id}"><span class="continueReading"><spring:message
							code="label.continueReading" /></span></a></td>
			</tr>
		</table>
	</c:forEach>
</c:if>
<c:if test="${empty blogEntries}">
	No Blog Entries
</c:if>