<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${!empty tagList}">
	<ul>
	<c:forEach items="${tagList}" var="tag">
		<li><span class="individualTag"><a href="/SimpleBlog/viewTag.html?tag=${tag.id}">${tag.text}</a></span></li>
	</c:forEach>
	</ul>
</c:if>