<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%-- <h3>${title}</h3> --%>

<c:if test="${!empty paging}">
	<c:if test="${paging.prevPage > 0}">
		<span style="float: left"><a
			href="/SimpleBlog/blog/home.html?page=${paging.prevPage}">back</a> </span>
	</c:if>

	<c:if test="${paging.hasNext}">
		<span style="float: right"><a
			href="/SimpleBlog/blog/home.html?page=${paging.nextPage}">forward</a> </span>
	</c:if>

	<br />
</c:if>
<c:if test="${!empty blogEntries}">
	<c:forEach items="${blogEntries}" var="blogEntry">
		<div class="blogListEntry">
<%-- 			<a href="SimpleBlog/blogView/${blogEntry.id}" class="blogTitle" >${blogEntry.title}</a> --%>
			<a href="/SimpleBlog/blog/${blogEntry.id}.html" class="blogTitle" >${blogEntry.title}</a>
			<br /> 
			<span class="blogAuthor">Author: ${blogEntry.author}</span> |
			<span class="blogDate">Published:${blogEntry.publish_date}</span>
			<br />
<%-- 			<span class="blogText"> ${blogEntry.content} &nbsp; <a href="/SimpleBlog/blogView/${blogEntry.id}"> --%>
			<span class="blogText"> ${blogEntry.content} &nbsp; <a href="/SimpleBlog/blog/${blogEntry.id}/blogPage">
				<span class="continueReading"><spring:message code="label.continueReading" /></span></a>
			</span>
		</div>
		<br />
	</c:forEach>
</c:if>
<c:if test="${empty blogEntries}">
	No Blog Entries
</c:if>