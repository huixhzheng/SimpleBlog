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
<body onload="hideElement('comments');">

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
	
	$(
		function()
		{
			function runEffect(effectTarget)
			{
				//var effect="blind";
				var effect = "bounce";				
				$(effectTarget).toggle(effect);
			
			}
			function changeText(isExpanded,targetElement, expandedText,shrinkedText)
			{
				console.log("isExpanded = "+isExpanded);
				console.log("targetElement = "+targetElement);
				console.log("expandedText = "+expandedText);
				console.log("shrinkedText = "+shrinkedText);

				if(isExpanded===true)
				{
					$(targetElement).text(expandedText);
				}
				else
				{
					$(targetElement).text(shrinkedText);
				}
			}
			
			$("#ShowHideTagList").click(
				function()
				{

					/* for some reason the call to: $('#TagListContainer').is(':visible'); returns the correct answer BEFORE
						the call to runEffect('#TagListContainer'); (and by extension .toggle())
						however AFTER the effect, it is always true. So taking the 
						pre value and using that for the logic later on.
					*/
					var isVisiblePreToggle = $('#TagListContainer').is(':visible');
					
					console.log('inverting visibility....');					
					runEffect('#TagListContainer');
					
					//inverting the condition since the value being evaluated
					// is the pre toggled value
					changeText(!isVisiblePreToggle,"#ShowHideTagList","[-]Tag List","[+]Tag List");
														
					return false;
				}
			);
			
			$("#ShowHideFaveBooks").click(
				function()
				{
					var isVisiblePreToggle = $('#FaveBooksContainer').is(':visible');
					runEffect("#FaveBooksContainer");
					changeText(!isVisiblePreToggle,"#ShowHideFaveBooks","[-]Fave Books","[+]Fave Books");
					return false;
				}
			);
			
			$("#ShowHideArchives").click(
				function()
				{
					var isVisiblePreToggle = $('#ArchiveContainer').is(':visible');
					runEffect("#ArchiveContainer");
					changeText(!isVisiblePreToggle,"#ShowHideArchives","[-]Archives","[+]Archives");
					return false;
				}
			);
		}
	);

		
	</script>
</body>
</html>
