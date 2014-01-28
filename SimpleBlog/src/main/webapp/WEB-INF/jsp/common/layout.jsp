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
<link rel="stylesheet" href="/SimpleBlog/themes/common.css" type="text/css" />
<link rel="stylesheet" href="/SimpleBlog/<spring:theme code='css'/>" type="text/css" />
<script src="/SimpleBlog/js/MyJs.js" type="text/javascript" /></script>
<script src="/SimpleBlog/js/jquery-1.10.2.min.js" type="text/javascript" /></script>

<title><tiles:insertAttribute name="title" ignore="true" /></title>

<style>
	.mainNavHover{
		color:#66CCFF;
	}
	.individualTagHover{
		font-weight:bold
	}
</style>
</head>
<body >

	<div class="allContent">
		
		<div class="topContent">
			<div style="float: none; width: 900px;" class="header">
				<tiles:insertAttribute name="header" />
			</div>
			<div style="float: none; width: 900px;">
				<tiles:insertAttribute name="menu" />
			</div>
		</div>
		
		<div style="float: right; width: 230px;">
			<tiles:insertAttribute name="sideMenu" />
		</div>
		
		<div style="float: none; width: 670px; padding-left: 0px;" class="mainContent">
			<tiles:insertAttribute name="body" />
		</div>

		<br />
		<div style="float: none; width: 900px;" class="footer">
			<tiles:insertAttribute name="footer" />
		</div>
	</div>
	<script>
		
		//Execute right away
		$(			
			function()
			{
				setDefaultViewableState();
			}
		);
	</script>
</body>
</html>
