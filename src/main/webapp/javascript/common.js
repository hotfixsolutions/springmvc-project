// JavaScript Document
function showTab(obj,divID)
{
	$('#'+divID).parent().children().hide();
	$(obj).parent().children().removeClass();
	$('#'+divID).slideDown();
	$(obj).addClass('selected');	
}

function slideDown(divID)
{
	jQuery('div#'+divID).slideDown();
}
function slideUp(divID)
{
	jQuery('div#'+divID).slideUp();
}
function fadeIn(divID)
{
	jQuery('div#'+divID).fadeIn('fast');
}
function fadeOut(divID)
{
	jQuery('div#'+divID).fadeOut('fast');
}
function toggleDiv(divID)
{
	if(document.getElementById(divID).style.display=='none')
	jQuery('div#'+divID).slideDown();
	else
	jQuery('div#'+divID).slideUp();
}
function toggleDivLink(sender,divID)
{
	if(document.getElementById(divID).style.display=='none')
	{
		jQuery('div#'+divID).slideDown();
		sender.getElementsByTagName('img')[0].src='images/TabL.png';
	}
	else
	{
		jQuery('div#'+divID).slideUp();
		sender.getElementsByTagName('img')[0].src='images/TabR.png';
	}
}
function onlyShow(divId)
{
	document.getElementById(divId).style.display="";
}
function onlyHide(divId)
{
	document.getElementById(divId).style.display="none";
}



function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}
function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}
function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}

function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}


//Add Div SCript

function addElement() {

  var ni = document.getElementById('myDiv');

  var numi = document.getElementById('theValue');

  var num = (document.getElementById('theValue').value -1)+ 2;

  numi.value = num;

  var newdiv = document.createElement('div');

  var divIdName = 'my'+num+'Div';

  newdiv.setAttribute('id',divIdName);

  newdiv.innerHTML = '<table class="formFields" width="100%" border="0" cellspacing="0" cellpadding="0"><tr><td width="20%"><input class="doNotHighlight" type="text" name="textfield" id="textfield" placeholder="Start Volume" /></td><td width="20%"><input class="doNotHighlight" type="text" name="textfield" id="textfield" placeholder="End Volume" /></td><td width="20%"><input class="doNotHighlight" type="text" name="textfield" id="textfield" placeholder="Start Date" /></td><td width="20%"><input class="doNotHighlight" type="text" name="textfield" id="textfield" placeholder="End Date" /></td><td width="20%"><input class="doNotHighlight" type="text" name="textfield" id="textfield" placeholder="Rate" /></td></tr></table></a>';

  ni.appendChild(newdiv);

}

//Table row Select Script

var arrayOfRolloverClasses = new Array();
	var arrayOfClickClasses = new Array();
	var activeRow = false;
	var activeRowClickArray = new Array();
	
	function highlightTableRow()
	{
		var tableObj = this.parentNode;
		if(tableObj.tagName!='TABLE')tableObj = tableObj.parentNode;

		if(this!=activeRow){
			this.setAttribute('origCl',this.className);
			this.origCl = this.className;
		}
		this.className = arrayOfRolloverClasses[tableObj.id];
		
		activeRow = this;
		
	}
	
	function clickOnTableRow()
	{
		var tableObj = this.parentNode;
		if(tableObj.tagName!='TABLE')tableObj = tableObj.parentNode;		
		
		if(activeRowClickArray[tableObj.id] && this!=activeRowClickArray[tableObj.id]){
			activeRowClickArray[tableObj.id].className='';
		}
		this.className = arrayOfClickClasses[tableObj.id];
		
		activeRowClickArray[tableObj.id] = this;
				
	}
	
	function resetRowStyle()
	{
		var tableObj = this.parentNode;
		if(tableObj.tagName!='TABLE')tableObj = tableObj.parentNode;

		if(activeRowClickArray[tableObj.id] && this==activeRowClickArray[tableObj.id]){
			this.className = arrayOfClickClasses[tableObj.id];
			return;	
		}
		
		var origCl = this.getAttribute('origCl');
		if(!origCl)origCl = this.origCl;
		this.className=origCl;
		
	}
		
	function addTableRolloverEffect(tableId,whichClass,whichClassOnClick)
	{
		arrayOfRolloverClasses[tableId] = whichClass;
		arrayOfClickClasses[tableId] = whichClassOnClick;
		
		var tableObj = document.getElementById(tableId);
		var tBody = tableObj.getElementsByTagName('TBODY');
		if(tBody){
			var rows = tBody[0].getElementsByTagName('TR');
		}else{
			var rows = tableObj.getElementsByTagName('TR');
		}
		for(var no=0;no<rows.length;no++){
			rows[no].onmouseover = highlightTableRow;
			rows[no].onmouseout = resetRowStyle;
			
			if(whichClassOnClick){
				rows[no].onclick = clickOnTableRow;	
			}
		}
		
	}
	
	
	
	
	
	
	function Showpopup(url, dTitle, dWidth, dHeight, icon) {
	var iconPath="../images/";
	switch (icon)
	{
		case "error":
			iconPath=iconPath + "errorIcon.png";
			break;
		case "email":
			iconPath=iconPath + "emailIcon.png";
			break;
		case "video":
			iconPath=iconPath + "videoIcon.png";
			break;
	}	
	
	
	var $loading = $('<img src="../images/progress_bar.gif" alt="loading" class="loading">');
    $dialog = $('<div></div>');
    $dialog.append($loading.clone());
    $dialog.load(url + '#Content');
    $dialog.dialog({
        title: "&nbsp;" + dTitle,
        width: dWidth,
        height: dHeight,
       	zIndex: 9999,
        resizable: false,
        modal: true,
        overlay: { backgroundColor: "#000", opacity: 0.7 },        
        close: function (ev, ui) { $(this).remove();}
    });

    return false;
}




function ShowHtmlMessageDialog(divId, dTitle, icon, dHeight, dWidth) {

    var iconPath = "../images/";
    
    
    switch (icon) {
        case "error":
            iconPath = iconPath + "errorIcon.png";
            break;
        case "email":
            iconPath = iconPath + "emailIcon.png";
            break;
        case "video":
            iconPath = iconPath + "videoIcon.png";
            break;
        default:
        	iconPath = iconPath + "transparentIcon2X24.png";
    }
    $dialog = $("#" + divId);
    $dialog.dialog({
        title: "<img class='absMiddle1' src ='" + iconPath + "'/> " + dTitle,
        zIndex: 9999,
        resizable: false,
        height: (dHeight)?dHeight:150,
        width: (dWidth)?dWidth:400,
        modal: true,
        overlay: { backgroundColor: "#000", opacity: 0.7}
        //close: function (ev, ui) { $(this).remove(); }
    });
    return false;
}

// My Methods

function selectManageRequests()
{
	document.getElementById("manageRequest").className += " selected";
	document.getElementById("manageSupplier").className += " noselected";
	document.getElementById("manageParameter").className += " noselected";
	document.getElementById("manageGiveaway").className += " noselected";
}
function selectManageSupplier()
{
	document.getElementById("manageRequest").className += " noselected";
	document.getElementById("manageSupplier").className += " selected";
	document.getElementById("manageParameter").className += " noselected";
	document.getElementById("manageGiveaway").className += " noselected";
}
function selectManageParameter()
{
	document.getElementById("manageCustomer").className += " noselected";
	document.getElementById("manageTRUser").className += " noselected";
	document.getElementById("manageParameter").className += " selected";
	document.getElementById("manageGiveaway").className += " noselected";
}
function selectManageGiveaway()
{
	document.getElementById("manageCustomer").className += " noselected";
	document.getElementById("manageTRUser").className += " noselected";
	document.getElementById("manageParameter").className += " noselected";
	document.getElementById("manageGiveaway").className += " selected";
}



/********* Utility Methods **********/

function isNumberKey(evt){
   var charCode = (evt.which) ? evt.which : event.keyCode
   if (charCode > 31 && (charCode < 48 || charCode > 57))
      return false;

   return true;
}

// Removes leading whitespaces
function LTrim( value ) {
	
	var re = /\s*((\S+\s*)*)/;
	return value.replace(re, "$1");
	
}

// Removes ending whitespaces
function RTrim( value ) {
	
	var re = /((\s*\S+)*)\s*/;
	return value.replace(re, "$1");
	
}

// Removes leading and ending whitespaces
function trim( value ) {
	
	return LTrim(RTrim(value));
	
}