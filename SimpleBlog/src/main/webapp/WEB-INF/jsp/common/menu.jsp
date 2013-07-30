<!-- default menu as configured in tiles.xml -->
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%-- <spring:message code="label.menu" /> --%>
<%
	// hooks into the defined content in the appropriate messages property file
%>

<!-- 		<span class="menuItem"><a href="/SimpleBlog/home.html">Home</a>&nbsp;</span> |  -->
<!-- 		<span class="menuItem"><a href="/SimpleBlog/tagsView.html">Tags View</a>&nbsp;</span> -->
<a href="/SimpleBlog/home.html" class="menuItem"">Home</a>
&nbsp;
<a href="/SimpleBlog/tagsView.html" class="menuItem">Tags View</a>
<!-- <table border="1" class="menu.links"> -->
<!-- 	<tr> -->
<!-- 		<td><a href="/SimpleBlog/home.html">Home</a></td> -->
<!-- 		<td><a href="/SimpleBlog/tagsView.html">Tags View</a></td> -->
<!-- 	</tr> -->
<!-- </table> -->