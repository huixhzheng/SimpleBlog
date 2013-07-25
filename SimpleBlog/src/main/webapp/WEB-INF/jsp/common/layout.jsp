<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%
	// This is used as the default layout in the tiles.xml config
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
	//  Adding stylesheet reference
%>
<link rel="stylesheet" href="/SimpleBlog/themes/common.css"
	type="text/css" />
<link rel="stylesheet" href="/SimpleBlog/<spring:theme code='css'/>"
	type="text/css" />
<script src="/SimpleBlog/js/MyJs.js" type="text/javascript" /></script>
<title><tiles:insertAttribute name="title" ignore="true" /></title>

</head>
<body onload="hideElement('comments');">

<!-- 	<div style="float: none; width:900px; background-color: lightblue;"> -->
<%-- 		<tiles:insertAttribute name="header" /> --%>
<!-- 	</div> -->
<!-- 	<div style="float: left ;width: 100 px;  background-color: yellow;"> -->
<%-- 		<tiles:insertAttribute name="menu" /> --%>
<!-- 	</div> -->
<!-- 	<div style="float: right; background-color: Green;"> -->
<%-- 		<tiles:insertAttribute name="tagMenu" /> --%>
<!-- 	</div> -->
<!-- 	<div style="float: none; width: 350px; background-color: DarkPink;"> -->
<%-- 		<tiles:insertAttribute name="body" /> --%>
<!-- 	</div> -->
	
<!-- 	<br /> -->
<!-- 	<div style="float: none; width:900px; background-color: Cyan;"> -->
<%-- 		<tiles:insertAttribute name="footer" /> --%>
<!-- 	</div> -->





		<table style="background-color: yellow;" border="2" cellpadding="2"
			cellspacing="2" align="center">
			<tr>
				<td height="30" colspan="3"><tiles:insertAttribute name="header" /></td>
			</tr>
			<tr>
				<td height="250"><tiles:insertAttribute name="menu" /></td>
				<td width="350"><tiles:insertAttribute name="body" /></td>
				<td width="250"><tiles:insertAttribute name="tagMenu" /></td>
			</tr>
			<tr>
				<td height="30" colspan="3"><tiles:insertAttribute name="footer" />
				</td>
			</tr>
		</table>

</body>
</html>