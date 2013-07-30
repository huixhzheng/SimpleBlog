<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
Books!
<c:if test="${!empty bookList}">
	<ul>
	<c:forEach items="${bookList}" var="book">
		<li><span class="individualTag">${book.title}</span></li>
	</c:forEach>
	</ul>
</c:if>