<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<c:if test="${!empty blogEntry}">
	<div id="BlogEntries">

		<div class="blogListEntry">
			<a href="/SimpleBlog/blog/${blogEntry.id}.html" class="blogTitle" >${blogEntry.title}</a>
			<br /> 
			<span class="contentLabel"><spring:message code="label.author" />:</span><span class="label"> ${blogEntry.author}</span> |
			<span class="contentLabel"><spring:message code="label.published" />:</span><span class="label">${blogEntry.publish_date}</span>
			<br /> <br />

			<div class="blogText"> ${blogEntry.content}</div>
		</div>
	</div>
</c:if>