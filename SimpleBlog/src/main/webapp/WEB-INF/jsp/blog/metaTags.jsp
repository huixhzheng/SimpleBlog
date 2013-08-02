<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${!empty blogEntry}">
	<c:if test="${!empty blogEntry.tags}">
		<c:forEach items="${blogEntry.tags}" var="tag">
<%-- 			<span class="individualTag">|<a href="/SimpleBlog/viewTag.html?tag=${tag.id}">${tag.text}</a>|</span> --%>
				<span class="individualTag">|<a href="/SimpleBlog/blog/tags/${tag.id}/blogs">${tag.text}</a>|</span>
		</c:forEach>
	</c:if>
	<c:if test="${empty blogEntry.tags}">
	<span class="individualTag">No Tags</span>
</c:if>
</c:if>