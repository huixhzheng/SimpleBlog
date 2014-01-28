function showElement(obj) {
    var el = document.getElementById(obj);
        el.style.display = 'table-row-group';

}
function hideElement(obj) {
    var el = document.getElementById(obj);
        el.style.display = 'none';

}



function toggleExtendedContent(targetToExpand,targetToHide,targetToShow)
{
	console.log("Toggling text expansion");
	runEffect(targetToExpand);
	$(targetToHide).hide();
	$(targetToShow).show();
	return false;
}


function toggleSideList(targetToExpandContract,toggleControl)
{
	var isVisiblePreToggle = $(targetToExpandContract).is(':visible');
				
	runEffect(targetToExpandContract);						
	//inverting the condition since the value being evaluated
	// is the pre toggled value
	changeText(!isVisiblePreToggle,toggleControl,$(toggleControl).text());
										
	return false;
}

function runEffect(effectTarget)
{
	$(effectTarget).slideToggle(1000);
}


function changeText(isExpanded,targetElement,currentText)
{
	console.log("isExpanded = "+isExpanded);
	console.log("targetElement = "+targetElement);
	console.log("currentText = "+currentText);

	var splicedText= currentText.substring(3);
	var preText;
	if(isExpanded===true)
	{
		preText="[-]";
	}
	else
	{
		preText="[+]";
	}
	$(targetElement).text(preText+splicedText);
}


/*
	Collapses all of the expanded blog items.
	Hides the 'collapse' links.
	Shows the 'expand' links.
*/
function setDefaultViewableState()
{
	$("div[id*='expandedText']").each(function()
		{
			$(this).hide();
		}
	);
	$("a[id*='collapseTextLink']").each(function()
		{
			$(this).hide();
		}
	);
	$("a[id*='expandTextLink']").each(function()
		{
			$(this).show();
		}
	);
}