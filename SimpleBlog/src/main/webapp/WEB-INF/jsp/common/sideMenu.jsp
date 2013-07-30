<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<div class="sideMenuContents">
		<tiles:insertAttribute name="tagsList" />
		<br />
		<tiles:insertAttribute name="faveBooks" />
		<br />
		<tiles:insertAttribute name="archives" />
</div>