<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<table border="2" cellpadding="2" cellspacing="2" align="center">
	<tr>
		<td height="250"><tiles:insertAttribute name="blog.content.entry" /></td>
	</tr>
	<tr>
		<td width="350"><tiles:insertAttribute
				name="blog.content.meta.tags" /></td>
	</tr>
	<tr>
		<td height="30" colspan="2"><tiles:insertAttribute
				name="blog.content.comments" /></td>
	</tr>
</table>