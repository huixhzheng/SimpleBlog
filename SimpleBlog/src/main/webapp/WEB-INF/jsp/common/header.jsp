<!-- Default header as configured in tiles.xml -->
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!-- hooks into the defined content in the appropriate messages property file -->
<h3>
	<spring:message code="label.title" />
</h3>

<span style="float: right"> <a href="?lang=en">en</a> | <a
	href="?lang=de">de</a>
</span>

<span style="float: left"> <a href="?theme=default">def</a> | <a
	href="?theme=black">blk</a> | <a href="?theme=blue">blu</a>
</span>
<br />
