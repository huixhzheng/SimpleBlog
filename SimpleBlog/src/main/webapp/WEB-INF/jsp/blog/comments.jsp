<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<table border="1" class="commentOuter">
	
	<p>Comments!</p>
	<div id="CommentList">
	
	</div>
	
	
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
	
		<td><form:form modelAttribute="comment" method="post" action="/SimpleBlog/blog/${blogId}.html">
	
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
						<td>
						<input type="hidden" name="parentBlogId" value="${blogId}" /> 
						<input type="submit" value="Reply" />
						</td>
					</tr>
				</table>
			</form:form></td>
	</tr>
</table>
	<script>
		$(function()
		{
			$.get("/SimpleBlog/blog/${blogId}/comments",function(data)
					{
						console.log(data);
						var commentList = data.commentList;
						for(var i=0;i<commentList.length;i++)
						{
							console.log("appending item " + i);
							$("#CommentList").append("<table border='1' class='commentIndividual'>")
									.append("<tr><td><h4>"
											.concat(commentList[i].commenterName)
											.concat("</h4></tr>"))
									.append("<tr><td>"
											.concat(commentList[i].comment)
											.concat("</td></tr></table>")
									);
							
						}
						console.log("Loaded comments.html via get");
					}			
			);
		});
	</script>
