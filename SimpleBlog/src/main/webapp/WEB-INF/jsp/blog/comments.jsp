<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<table border="1" class="commentOuter">
	<%
		//should never be empty.. but whatever
	%>
	<!--<c:if test="${!empty blogEntry}">-->
		<c:if test="${!empty commentList}">
			<p>comments!</p>
			<tr>
				<td><c:forEach items="${commentList}" var="comment">
						<table border="1"
							class="commentIndividual">
							<tr>
								<td><h4>${comment.commenterName}</h4>
							</tr>
							<tr>
								<td>${comment.comment}</td>
							</tr>
						</table>
					</c:forEach></td>
			</tr>
		</c:if>
		<c:if test="${empty commentList}">
			<tr>
				<td>
					<p>No comments</p>
				</td>
			</tr>
		</c:if>
	<!--</c:if>-->
	<tr>
		<td><span class="commentControls"
			onclick="showElement('comments')">Reply</span></td>
	</tr>
	<tr>
		<td><span class="commentControls"
			onclick="hideElement('comments')">Hide</span></td>
	</tr>
	<%-- --%>
	<tr>
		<td><form:form modelAttribute="comment" method="post" action="/SimpleBlog/blog/${blogEntry.id}.html">
				<table border="1" id="comments">
					<tr>
						<td><form:label path="commenterName">Name</form:label> <form:input
								path="commenterName" /></td>
						<td><form:errors path="commenterName" cssStyle="color: red;" /></td>
					</tr>
					<tr>
						<td><form:label path="commenterEmail">Email</form:label> <form:input
								path="commenterEmail" /></td>
						<td><form:errors path="commenterEmail" cssStyle="color: red;"/></td>
					</tr>
					<tr>
						<td><form:label path="comment">Comment</form:label> <form:textarea
								rows="5" cols="30" path="comment" /></td>
						<td><form:errors path="comment" cssStyle="color: red;" /></td>
					</tr>
					<tr>
						<td><input type="hidden" name="parentBlogId"
							value="${blogEntry.id}" /> <input type="submit" value="Reply" /></td>
					</tr>
				</table>
			</form:form></td>
	</tr>
</table>
