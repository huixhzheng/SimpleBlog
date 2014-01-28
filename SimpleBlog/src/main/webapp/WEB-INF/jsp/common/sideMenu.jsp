<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<div id="SideNav" class="sideMenuContents">
	
	<a href="#ShowHideTagList" id="ShowHideTagList" class="listHeader" onClick="toggleSideList('#TagListContainer','#ShowHideTagList')">[-]Tag List</a>
	<div id="TagListContainer" style="display: block;">
		<tiles:insertAttribute name="tagsList" />
	</div>
	<br />
	
	<a href="#ShowHideFaveBooks" id="ShowHideFaveBooks" class="listHeader" onClick="toggleSideList('#FaveBooksContainer','#ShowHideFaveBooks')">[-]Fave Books</a>
	<div id="FaveBooksContainer" >
		<tiles:insertAttribute name="faveBooks" />
	</div>
	<br />
	
	<a href="#ShowHideArchives" id="ShowHideArchives" class="listHeader" onClick="toggleSideList('#ArchiveContainer','#ShowHideArchives')">[-]Archives</a>
	<div id="ArchiveContainer" >
		<tiles:insertAttribute name="archives" />
	</div>
</div>
