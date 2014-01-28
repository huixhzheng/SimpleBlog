<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div>
	<tiles:insertAttribute name="blog.content.entry" />
	<div id="blogTags">
		<tiles:insertAttribute name="blog.content.meta.tags" />
	</div>
	<div id="Comments">
		<!-- <tiles:insertAttribute name="blog.content.comments" /> -->
	</div>
	<script>
		$(function()
		{
			$.get("/SimpleBlog/blog/11/comments.html",function(data)
					{
						console.log(data);
						$("#Comments").html(data);
						console.log("Loaded comments.html via get");
					}
					
			
			);
			/*
				$("#Comments").load("/SimpleBlog/blog/11/comments.html",function()
					{
						console.log("loaded comments.html");
					}
				);
			*/
		});
	</script>
</div>