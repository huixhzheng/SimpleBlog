<!-- default menu as configured in tiles.xml -->
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:message code="label.menu" />
<% // hooks into the defined content in the appropriate messages property file %>
<table border="1" style="background-color: DodgerBlue;" class="menu.links">
	<tr>
		<td><a href="/SimpleBlog/home.html">Home</a></td>
	</tr>
	<tr>
		<td><a href="/SimpleBlog/tagsView.html">Tags View</a></td>
	</tr>
</table>