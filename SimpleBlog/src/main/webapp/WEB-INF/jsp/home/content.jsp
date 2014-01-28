<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>




<c:if test="${!empty paging}">
	<div id="Paging">
		<c:if test="${paging.prevPage > 0}">
			<span style="float: left"><a href="/SimpleBlog/blog/home.html?page=${paging.prevPage}"> &lt; <spring:message code="paging.prev" /> </a> </span>
		</c:if>

		<c:if test="${paging.hasNext}">
			<span style="float: right">
			<a href="/SimpleBlog/blog/home.html?page=${paging.nextPage}"><spring:message code="paging.next" /> &gt; </a> </span>
		</c:if>

		<br />
		<br /><br /><br />
		<br />
	</div>
</c:if>

<c:if test="${!empty blogEntries}">
	<div id="BlogEntries">
	<c:forEach items="${blogEntries}" var="blogEntry">
		<div class="blogListEntry">
			<a href="/SimpleBlog/blog/${blogEntry.id}.html" class="blogTitle" >${blogEntry.title}</a>
			<br /> 
			<span class="contentLabel"><spring:message code="label.author" />:</span><span class="label"> ${blogEntry.author}</span> |
			<span class="contentLabel"><spring:message code="label.published" />:</span><span class="label">${blogEntry.publish_date}</span>
			<br /> <br />


			<div class="blogText"> ${blogEntry.content} 

			</div>
			<a href="/SimpleBlog/blog/${blogEntry.id}/blogPage">
				<span class="continueReading"><spring:message code="label.continueReading" /></span>
			</a>
			<a href="/SimpleBlog/blog/${blogEntry.id}/blogPage">
				<span class="continueReading"><spring:message code="label.leaveComment" /></span>
			</a>
		</div>
		<br />
	</c:forEach>
	</div>
</c:if>
<c:if test="${empty blogEntries}">
	No Blog Entries
</c:if>
