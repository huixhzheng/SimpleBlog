<!-- default menu as configured in tiles.xml -->
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%-- <spring:message code="label.menu" /> --%>
<%
	// hooks into the defined content in the appropriate messages property file
%>
<ul id="nav">
	<li><a href="/SimpleBlog/blog/home.html" class="mainNav">Home</a></li>
	<li><a href="/SimpleBlog/about.html" class="mainNav">About</a></li>
</ul>

<!--<a href="/SimpleBlog/blog/home.html" class="menuItem">Home</a>
&nbsp;
<a href="/SimpleBlog/about.html" class="menuItem">About</a>

-->
