<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${!empty tagList}">
	<ul>
	<c:forEach items="${tagList}" var="tag">
		<li><a href="/SimpleBlog/blog/tags/${tag.id}/blogs.html" >${tag.text}</a></li>
	</c:forEach>
	</ul>
</c:if>
