<!-- Default header as configured in tiles.xml -->
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%-- hooks into the defined content in the appropriate messages property file --%>
<br />
<span class="siteTitle"> <spring:message code="label.title" />
</span>
<span style="float: right; padding-right:10px;"> 
	<a href="?lang=en">en</a> | 
	<a href="?lang=de">de</a>
</span>
<br />
<span style="float: right; padding-right:10px;"> 
	<a href="?theme=default">def</a> | 
	<a href="?theme=black">blk</a> | 
	<a href="?theme=blue">blu</a>
</span>

<br />

<img src="/SimpleBlog/<spring:theme code='image'/>" />
