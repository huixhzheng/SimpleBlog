<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>




<c:if test="${!empty paging}">
	<div id="Paging">
		<c:if test="${paging.prevPage > 0}">
			<span style="float: left"><a href="/SimpleBlog/blog/home.html?page=${paging.prevPage}"><spring:message code="paging.prev" /> </a> </span>
		</c:if>

		<c:if test="${paging.hasNext}">
			<span style="float: right">
			<a href="/SimpleBlog/blog/home.html?page=${paging.nextPage}"><spring:message code="paging.next" /> </a> </span>
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

				<c:if test="${!empty blogEntry.content2}" >

					<a href="#expandTextLink${blogEntry.id}" id="expandTextLink${blogEntry.id}" 
						class="toggleVisibilityLink" 
						onClick="toggleExtendedContent('#expandedText${blogEntry.id}','#expandTextLink${blogEntry.id}','#collapseTextLink${blogEntry.id}')"> <spring:message code="label.showMore" /></a>
					
					<div id="expandedText${blogEntry.id}">
						${blogEntry.content2}
					</div>

					<a href="#collapseTextLink${blogEntry.id}" 
						id="collapseTextLink${blogEntry.id}" 
						class="toggleVisibilityLink" 
						onClick="toggleExtendedContent('#expandedText${blogEntry.id}','#collapseTextLink${blogEntry.id}','#expandTextLink${blogEntry.id}')" > <spring:message code="label.showLess" /></a>
				</c:if>

			</div>
			<a href="/SimpleBlog/blog/${blogEntry.id}.html">
				<span class="continueReading"><spring:message code="label.continueReading" /></span>
			</a>
			<a href="/SimpleBlog/blog/${blogEntry.id}.html#Comments">
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
