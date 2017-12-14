<%@ page language="java"
	import="com.rp.domainobject.PurchaseOrderDetailsDo, java.util.*"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<style>
.errorRow {
	background-color: #ECD672;
}

.noCSS {
	
}

.break_word {
	width: 150px;
	word-wrap: break-word;
	word-break: break-all;
	white-space: pre-wrap; /* css-3 */
	white-space: -moz-pre-wrap /* Mozilla, since 1999 */                 
	                 white-space:                  -pre-wrap;
	/* Opera 4-6 */
	white-space: -o-pre-wrap; /* Opera 7 */
	word-wrap: break-word; /* Internet Explorer 5.5+ */
}
</style>
<script>
	function GetXmlHttpObject() {
		if (window.XMLHttpRequest) {
			// code for IE7+, Firefox, Chrome, Opera, Safari
			return new XMLHttpRequest();
		}
		if (window.ActiveXObject) {
			// code for IE6, IE5
			return new ActiveXObject("Microsoft.XMLHTTP");
		}
		return null;
	}

	var xmlhttp;
	var responseStr = 0;
	var http;

	function stateChanged() {

		if (xmlhttp.readyState == 4) {
			var responseStr = xmlhttp.responseText;
			if (responseStr != null && responseStr.length > 0
					&& responseStr != 'undefined') {
			}
		}
	}

	function checkPODetailsForm() {
		removeDivTag("");
		var isFormOk = true;
		if (trim(document.poDetailsForm.bookName.value) == '') {
			document.getElementById('bookName').innerHTML = "Please enter book Name";
			isFormOk = false;
		} else {
			document.getElementById('bookName').innerHTML = "";
		}

		if (trim(document.poDetailsForm.orderQuantity.value) == '') {
			document.getElementById('orderQuantity').innerHTML = "Please enter quantity to order";
			isFormOk = false;
		} else {
			document.getElementById('orderQuantity').innerHTML = "";
		}

		return isFormOk;
	}
	function submitFormWithAjax() {

		if (!checkPODetailsForm()) {
			return;
		}
		var addPODetailsPostrequest = new GetXmlHttpObject();

		var bookName = trim(document.poDetailsForm.bookName.value);
		var orderQuantity = trim(document.poDetailsForm.orderQuantity.value);
		var author = trim (document.poDetailsForm.author.value);
		var tmp = document.poDetailsForm.tmp.value;
		var parameters = "pid=-1&" + "bookName=" + bookName + "&orderQuantity="
				+ orderQuantity + "&author=" + author + "&tmpPocId="
				+ tmp;
		var url = "addPODetails.html";
		addPODetailsPostrequest.open("POST", url, true);
		addPODetailsPostrequest.setRequestHeader("Content-type",
				"application/x-www-form-urlencoded");
		addPODetailsPostrequest.send(parameters);
		addPODetailsPostrequest.onreadystatechange = function() {
			if (addPODetailsPostrequest.readyState == 4) {
				if (addPODetailsPostrequest.status == 200) {
					addPOCRecord('poDetailsTable', bookName, orderQuantity, author, addPODetailsPostrequest.responseText);
					clearPODetailsForm();
					isUpdateMode = false;
					document.getElementById('pocBtn').innerHTML = 'Add PO Details';
					var table = document.getElementById('poDetailsTable');
					var rowCount = table.rows.length;
					for (i = 1; i < rowCount; i++) {
						var row = table.rows[i];
						if (tmp == row.id) {
							table.deleteRow(i);
						}
					}
				}
			}
		}
	}

	function deletePODetails(pocID) {
		var flag = true;
		if (isUpdateMode) {
			alert("Please save the po you are editing before performing any other operation on po.");
			return;
		}
		flag = confirm('Are you sure you want to delete?');
		if (flag == true) {
			var deletePOPostrequest = new GetXmlHttpObject();
			var parameters = "poid=" + pocID;
			var url = "deletePODetails.html";
			deletePOPostrequest.open("POST", url, true);
			deletePOCPostrequest.setRequestHeader("Content-type",
					"application/x-www-form-urlencoded");
			deletePOCPostrequest.send(parameters);
			deletePOCPostrequest.onreadystatechange = function() {
				if (deletePOCPostrequest.readyState == 4) {
					if (deletePOCPostrequest.status == 200) {
						var table = document.getElementById('poDetailsTable');
						var rowCount = table.rows.length;
						for (i = 1; i < rowCount; i++) {
							var row = table.rows[i];
							if (pocID == row.id) {
								table.deleteRow(i);
							}
						}
					}
				}
			}
		}
	}
	var isUpdateMode = false;

	function removeDivTag(str){
		if(str.length > 0){
			 var startIndex = 24;
			 var divEndTag = '</div>'
			 if(navigator.appName == "Microsoft Internet Explorer"){
				 divEndTag = "</DIV>";
				 startIndex = 22;
			 }
			return str.substring(startIndex,str.indexOf(divEndTag));
		}
	}
	
	function updatePODetails(pocID) {
		var table = document.getElementById('poDetailsTable');
		var rowCount = table.rows.length;
		for (i = 1; i < rowCount; i++) {
			var row = table.rows[i];
			if (pocID == row.id) {
				document.poDetailsForm.tmp.value = pocID;
				document.poDetailsForm.bookName.value = removeDivTag(row.cells[0].innerHTML);
				document.poDetailsForm.orderQuantity.value = removeDivTag(row.cells[1].innerHTML);
				document.poDetailsForm.author.value = removeDivTag(row.cells[2].innerHTML);
				isUpdateMode = true;
				document.getElementById('pocBtn').innerHTML = 'Save PO Details';
			}
		}
	}

	function clearPODetailsForm() {
		document.poDetailsForm.bookName.value = "";
		document.poDetailsForm.orderQuantity.value = "";
		document.poDetailsForm.author.value = "";
		document.poDetailsForm.tmp.value = "";
	}
</script>

<script type="text/javascript">
    
	function addPOCRecord(tableID,val1,val2, val3, tmpId){
    
		var table = document.getElementById(tableID);

        var rowCount = table.rows.length;
        var row = table.insertRow(rowCount);
        
        row.id = tmpId;

        var cell0 = row.insertCell(0);
        cell0.innerHTML = "<div class=\"break_word\">" + val1 + "</div>";

        var cell1 = row.insertCell(1);
        cell1.innerHTML = "<div class=\"break_word\">" + val2 + "</div>";

        var cell2 = row.insertCell(2);
        cell2.innerHTML = "<div class=\"break_word\">" + val3 + "</div>";

        var cell3 = row.insertCell(3);
        cell3.innerHTML = "<a href='javascript:void(0)' onclick='updatePODetails(" + tmpId + ")'>Edit</a>&nbsp;&nbsp;&nbsp;<a href='javascript:void(0);' onclick='deletePODetails(" + tmpId + ")'>Delete</a>";
	}
	
	function savePurchaseOrder(){
		document.poForm.submit();
	}

	function placePurchaseOrder(){
		document.poForm.action = "placePurchaseOrder.html"
		document.poForm.submit();
	}

	selectManagePurchaseOrder();
		
	function initPODetailsTable(tid){
    	<%Set<PurchaseOrderDetailsDo> pocSet1 = (Set<PurchaseOrderDetailsDo>)session.getAttribute("PODetailsSet");
   		if(pocSet1 != null && pocSet1.size() > 0){
   			for(PurchaseOrderDetailsDo poc : pocSet1){%>
                   addPOCRecord(tid,'<%=poc.getBookName()%>','<%=poc.getOrderQuantity()%>','<%=poc.getAuthor()%>','<%=poc.getTmpPoItemId()%>');
<%}
   		}%>
	}
</script>

<div class="bodyContent">
	<div class="whiteBg">
		<div class="breadcrumb">
			<a href="../home/index.html">Home</a> &nbsp;| &nbsp; <a
				href="list.html">Manage Purchase Orders</a> &nbsp;| &nbsp;Add
			Purchase Order
		</div>
		<div class="tblDiv-1">
			<h2>Add New Purchase Order</h2>
			<div class="formContent" style="padding-bottom: 0px">
				<div align="right" class="mbottomTop10">
					( <span class="mandatory">*</span> Fields are Required )
				</div>
				<form:form commandName="poDo" action="editPurchaseOrder.html"
					method="post" name="poForm">
					<table class="formFields" width="100%" border="0" cellspacing="0"
						cellpadding="0">
						<tr>
							<td width="35%"><h4>
									PO Number<span class="mandatory">*</span>
								</h4> <input size="8" readOnly name="poPrefix" id="poPrefix"
								value='${poDo.poPrefix}' />
								<input size="8" maxlength="80" tabindex="1" name="poName"
								id="poName" value="${fn:escapeXml(poDo.poName)}" />
								<div class="errormsg marR-60">
									<form:errors path="poName" />
								</div></td>
							<td><h4>
									PO Date<span class="mandatory">*</span>
								</h4> <input type="text" readOnly size="18" name="poDateString"
								id="poDateString" value="${poDo.poDateString}">
								<div class="errormsg marR-60">
									<form:errors path="poDateString" />
								</div></td>
							<td width="35%"><h4>
									Supplier<span class="mandatory">*</span>
								</h4> <select tabindex="12" class="dd260" name="supplierId"
								id="select2">
									<option value="">Select</option>
									<c:forEach items="${supplierList}" var="suppliers"
										varStatus="loop">
										<option
											<c:if test="${suppliers.supplierId == poDo.supplierId}" >selected</c:if>
											value="<c:out value="${suppliers.supplierId}" />">
											<c:out value="${suppliers.supplierName}" />
										</option>
									</c:forEach>
							</select>
								<div class="errormsg marR-60">
									<form:errors path="supplierId" />
								</div></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td><h4>Status</h4>
								<select tabindex="13" class="dd260" name="poStatus" id="select2">
									<option value="-1">Select</option>
									<option value="0"
										<c:if test="${poDo.poStatus == '0'}" >selected</c:if>>Pending</option>
									<option value="1"
										<c:if test="${poDo.poStatus == '1'}" >selected</c:if>>Confirmed</option>
									<option value="2"
										<c:if test="${poDo.poStatus == '2'}" >selected</c:if>>Fullfilled</option>
									<option value="3"
										<c:if test="${poDo.poStatus == '3'}">selected</c:if>>Cancelled</option>
							</select></td>
						</tr>
					</table>
				<input type="hidden" value="${poDo.poId}" name="poId" />
				<input type="hidden" value="${poDo.dateCreated }" name="dateCreated"/>
				</form:form>
			</div>
		</div>
		<!--PO Details Form Start-->
		<div class="tblDiv-2">
			<h2>PO Details</h2>
			<div class="formContent">
				<div align="right" class="mbottomTop10">
					( <span class="mandatory">*</span> Fields are Required )
				</div>
				<form:form commandName="podDo" name="poDetailsForm"
					id="poDetailsForm" method="POST">
					<table class="formFields" width="100%" border="0" cellspacing="0"
						cellpadding="0">
						<tr>
							<td width="35%"><h4>
									Book Name<span class="mandatory">*</span>
								</h4> <input maxlength="35" tabindex="18" class="txtBox" type="text"
								name="bookName" id="textfield" />
								<div class="errormsg marR-60" id="bookName"></div></td>
							<td><h4>
									Quantity<span class="mandatory">*</span>
								</h4> <input maxlength="3" tabindex="19" class="txtBox" type="text"
								name="orderQuantity" id="textfield7" />
								<div class="errormsg marR-60" id="orderQuantity"></div></td>
							<td><h4>Author</h4> <input maxlength="50" tabindex="20"
								class="txtBox" type="text" name="author" id="textfield7" /></td>
						</tr>
					</table>
					<input type="hidden" value="" name="tmp" />
					</form:form>
				<div class="center marT10">
					<a href="javascript:void(0)" onclick="submitFormWithAjax();"
						class="button_link"><span id="pocBtn">Add PO Details</span></a>
				</div>
			</div>
			<!--POC FORM End-->

			<div class="tblDiv-2">
				<table class="listFieldsManage" width="100%" border="0"
					cellspacing="0" cellpadding="0" id="poDetailsTable">
					<tr>
						<th>Book Name</th>
						<th>Order Quantity</th>
						<th>Author</th>
						<th>Action</th>
					</tr>
				</table>
			</div>
			<div>
				<div class="center">
					<a href="javascript:savePurchaseOrder();" class="button_link"><span>Submit</span></a>
					<c:if test="${poDo.poStatus != '1'}"><a href="javascript:placePurchaseOrder();" class="button_link"><span>Place Order</span></a></c:if>
					<a href="list.html" class="button_link btn_cancel"><span>Cancel</span></a>
				</div>
			</div>
		</div>
	</div>
</div>
<script>
	initPODetailsTable('poDetailsTable');
	clearPODetailsForm();
</script>
<script>
	$(function() {
		$("#poDateString").datepicker({
			showOn : "button",
			buttonImage : "../images/calendar.gif",
			buttonImageOnly : true,
			minDate : -0,
			maxDate : "+240M"
		});
		$("#datepicker2").datepicker({
			showOn : "button",
			buttonImage : "../images/calendar.gif",
			buttonImageOnly : true,
			minDate : -0,
			maxDate : "+240M"
		});
		$("#datepicker3").datepicker({
			showOn : "button",
			buttonImage : "../images/calendar.gif",
			buttonImageOnly : true,
			minDate : -0,
			maxDate : "+240M"
		});
		$("#datepicker4").datepicker({
			showOn : "button",
			buttonImage : "../images/calendar.gif",
			buttonImageOnly : true
		});
	});
</script>
