<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
Archives!
<c:if test="${!empty archiveList}">
	<ul>
	<c:forEach items="${archiveList}" var="blog">
		<li><span class="individualTag">${blog.title}</span></li>
	</c:forEach>
	</ul>
</c:if>