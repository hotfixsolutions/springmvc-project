<%@ page language="java"
	import="com.rp.domainobject.CustomerTransactionDetailsDo, java.util.*"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

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
	                   white-space:                    -pre-wrap;
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

	function checkTransactionDetailsForm() {
		removeDivTag("");
		var isFormOk = true;
		if (trim(document.transactionDetailsForm.transactionDescription.value) == '') {
			document.getElementById('transactionDescription').innerHTML = "Please enter transaction description";
			isFormOk = false;
		} else {
			document.getElementById('transactionDescription').innerHTML = "";
		}

		if (trim(document.transactionDetailsForm.transactionAmount.value) == '') {
			document.getElementById('transactionAmount').innerHTML = "Please enter transaction amount";
			isFormOk = false;
		} else {
			document.getElementById('transactionAmount').innerHTML = "";
		}

		if (trim(document.transactionDetailsForm.transactionDateString.value) == '') {
			document.getElementById('transactionDateString').innerHTML = "Please enter date of transaction";
			isFormOk = false;
		} else {
			document.getElementById('transactionDateString').innerHTML = "";
		}

		return isFormOk;
	}
	
	function submitFormWithAjax() {

		if (!checkTransactionDetailsForm()) {
			return;
		}
		var addTransactionDetailsPostrequest = new GetXmlHttpObject();

		var description = trim(document.transactionDetailsForm.transactionDescription.value);
		var amount = trim(document.transactionDetailsForm.transactionAmount.value);
		var date = trim (document.transactionDetailsForm.transactionDateString.value);
		var quantity = trim (document.transactionDetailsForm.transactionQuantity.value);
		var type = trim (document.transactionDetailsForm.transactionType.value);
		var remarks = trim (document.transactionDetailsForm.transactionRemarks.value);
		var tmp = document.transactionDetailsForm.tmp.value;
		var parameters = "pid=-1&" + "transactionDescription=" + description
				+ "&transactionAmount=" + amount 
				+ "&transactionDateString=" + date 
				+ "&transactionQuantity=" + quantity
				+ "&transactionType=" + type
				+ "&transactionRemarks=" + remarks
				+ "&tmpId=" + tmp;
		var url = "addTransactionDetails.html";
		addTransactionDetailsPostrequest.open("POST", url, true);
		addTransactionDetailsPostrequest.setRequestHeader("Content-type",
				"application/x-www-form-urlencoded");
		addTransactionDetailsPostrequest.send(parameters);
		addTransactionDetailsPostrequest.onreadystatechange = function() {
			if (addTransactionDetailsPostrequest.readyState == 4) {
				if (addTransactionDetailsPostrequest.status == 200) {
					addTransactionRecord('transactionTable', date, type, description, quantity, amount,  remarks, addTransactionDetailsPostrequest.responseText);
					clearTransactionDetailsForm();
					isUpdateMode = false;
					document.getElementById('transactionBtn').innerHTML = 'Add Transaction Details';
					var table = document.getElementById('transactionTable');
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

	function deleteTransactionDetails(pocID) {
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
	
	function updateTransactionDetails(pocID) {
		var table = document.getElementById('transactionTable');
		var rowCount = table.rows.length;
		for (i = 1; i < rowCount; i++) {
			var row = table.rows[i];
			if (pocID == row.id) {
				document.transactionDetailsForm.tmp.value = pocID;
				document.transactionDetailsForm.bookName.value = removeDivTag(row.cells[0].innerHTML);
				document.transactionDetailsForm.orderQuantity.value = removeDivTag(row.cells[1].innerHTML);
				isUpdateMode = true;
				document.getElementById('transactionBtn').innerHTML = 'Save Transaction Details';
			}
		}
	}

	function clearTransactionDetailsForm() {
		document.transactionDetailsForm.transactionDescription.value = "";
		document.transactionDetailsForm.transactionDateString.value = "";
		document.transactionDetailsForm.transactionAmount.value = "";
		document.transactionDetailsForm.transactionQuantity.value = "";
		document.transactionDetailsForm.transactionType.value = "";
		document.transactionDetailsForm.transactionRemarks.value = "";
		document.transactionDetailsForm.tmp.value = "";
	}
</script>

<script type="text/javascript">
    
	function addTransactionRecord(tableID, val1, val2, val3, val4, val5, val6, tmpId){
    
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
        cell3.innerHTML = "<div class=\"break_word\">" + val4 + "</div>";

        var cell4 = row.insertCell(4);
        cell4.innerHTML = "<div class=\"break_word\">" + val5 + "</div>";

        var cell5 = row.insertCell(5);
        cell5.innerHTML = "<div class=\"break_word\">" + val6 + "</div>";

        
        var cell6 = row.insertCell(6);
        cell6.innerHTML = "<a href='javascript:void(0)' onclick='updateTransactionDetails(" + tmpId + ")'>Edit</a>&nbsp;&nbsp;&nbsp;<a href='javascript:void(0);' onclick='deleteTransactionDetails(" + tmpId + ")'>Delete</a>";
	}
	
	function saveTranaction(){
		document.transactionForm.submit();
	}

	selectManageTransaction();
		
	function initTransactionDetailsTable(tid){
    	<%Set<CustomerTransactionDetailsDo> transactionSet1 = (Set<CustomerTransactionDetailsDo>)session.getAttribute("transactionDetailsSet");
   		if(transactionSet1 != null && transactionSet1.size() > 0){
   			for(CustomerTransactionDetailsDo transactionDetail : transactionSet1){%>
                   addPOCRecord(tid,'<%=transactionDetail.getTransactionDate()%>','<%=transactionDetail.getTransactionType()%>','<%=transactionDetail.getTransactionDescription()%>','<%=transactionDetail.getTransactionQuantity()%>', '<%=transactionDetail.getTransactionAmount()%>', '<%=transactionDetail.getTransactionRemarks()%>', '<%=transactionDetail.getCodTmpId()%>
	');
<%}
   		}%>
	}
</script>

<%
	Date date = new java.util.Date();
	pageContext.setAttribute("currentDate", date);
%>

<div class="bodyContent">
	<div class="whiteBg">
		<div class="breadcrumb">
			<a href="../home/index.html">Home</a> &nbsp;| &nbsp; <a
				href="list.html">Manage Transaction</a> &nbsp;| &nbsp;Add Transaction
		</div>
		<div class="tblDiv-1">
			<h2>Add New Transaction</h2>
			<div class="formContent" style="padding-bottom: 0px">
				<div align="right" class="mbottomTop10">
					( <span class="mandatory">*</span> Fields are Required )
				</div>
				<form:form commandName="trasanctionDo" action="addTransaction.html"
					method="post" name="transactionForm">
					<table class="formFields" width="100%" border="0" cellspacing="0"
						cellpadding="0">
						<tr>
							<td width="35%"><h4>
									Customer Name<span class="mandatory">*</span>
								</h4>
								<input maxlength="100" tabindex="1" name="customerName"
								id="customerName" value="${fn:escapeXml(transactionDo.customerName)}" />
								<div class="errormsg marR-60">
									<form:errors path="customerName" />
								</div></td>
							<td>&nbsp;</td>
							<td width="35%">&nbsp;</td>
						</tr>
						<tr>
							<td colspan="3" class="padT20"><div class="formGheading">
									<h3>Customer Details</h3>
								</div></td>
						</tr>
						<tr>
							<td><h4>
									Email<span class="mandatory">*</span>
								</h4> <input class="txtBox" type="text" name="emailAddress"
								value="${transactionDo.emailAddress}" id="emailAddress" />
								<div class="errormsg marR-60">
									<form:errors path="emailAddress" />
								</div></td>
							<td><h4>Address 1</h4> <input class="txtBox" type="text"
								name="customerAddress1" value="${transactionDo.customerAddress1}"
								id="textfield11" /></td>
							<td><h4>City</h4> <input class="txtBox" type="text"
								name="city" value="${transactionDo.city}" id="textfield2" /></td>
						</tr>
						<tr>
							<td><h4>
									Phone 1<span class="mandatory">*</span>
								</h4> <input class="txtBox" type="text" name="customerPhone1"
								value="${transactionDo.customerPhone1}" id="textfield10" />
								<div class="errormsg marR-60">
									<form:errors path="customerPhone1" />
								</div></td>
							<td><h4>Address 2</h4> <input class="txtBox" type="text"
								name="customerAddress2" value="${transactionDo.customerAddress2}"
								id="textfield11" /></td>
							<td><h4>State</h4> <select class="dd260" name="state"
								id="select7">
									<option value="-1">Select</option>
									<c:forEach items="${stateList}" var="states" varStatus="loop">
										<option
											<c:if test="${states.stateCode == transactionDo.state}" >selected</c:if>
											value="<c:out value="${states.stateCode}" />">
											<c:out value="${states.stateName}" />
										</option>
									</c:forEach>
							</select></td>
						</tr>
						<tr>
							<td><h4>Phone 2</h4> <input class="txtBox" type="text"
								name="customerPhone2" value="${transactionDo.customerPhone2}"
								id="textfield10" />
								<div class="errormsg marR-60">
									<form:errors path="customerPhone2" />
								</div></td>
							<td>&nbsp;</td>
							<td><h4>
									Zip<span class="mandatory">*</span>
								</h4> <input class="txtBox" type="text" name="zip"
								value="${transactionDo.zip}" id="textfield3" /></td>
						</tr>						
					</table>
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
				<form:form commandName="transactionDetailsDo" name="transactionDetailsForm"
					id="transactionDetailsForm" method="POST">
					<table class="formFields" width="100%" border="0" cellspacing="0"
						cellpadding="0">
						<tr>
							<td width="35%"><h4>
									Transaction Date<span class="mandatory">*</span>
								</h4> <input type="text" size="18" readOnly name="transactionDateString"
								id="transactionDateString" value="${transactionDetailsDo.transactionDateString}">
								<div class="errormsg marR-60">
									<form:errors path="transactionDateString" />
								</div></td>
							<td width="35%"><h4>
									Transaction Type<span class="mandatory">*</span>
								</h4><select tabindex="24" class="dd260" name="transactionType" id="transactionType">
			                          <option value="-1">(Select)</option>
			                          <option value="1">Purchase</option>
			                          <option value="2">Payment</option>
		                        </select><div class="errormsg marR-60" id="transactionType"></div></td>
							<td><h4>
									Transaction Remarks
								</h4> <input maxlength="100" tabindex="19" class="txtBox" type="text"
								name="transactionRemarks" id="textfield7" />
							</td>
						</tr>
						<tr>
							<td><h4>
									Transaction Description<span class="mandatory">*</span>
								</h4> <input maxlength="100" tabindex="19" class="txtBox" type="text"
								name="transactionDescription" value="${transactionDetailsDo.transactionDescription}" id="textfield7" />
								<div class="errormsg marR-60" id="transactionDescription"></div></td>
							<td width="35%"><h4>
									Transaction Quantity
								</h4> <input type="text" size="4" name="transactionQuantity"
								id="transactionQuantity" value="${transactionDetailsDo.transactionQuantity}">
								</td>
							<td width="35%"><h4>
									Transaction Amount<span class="mandatory">*</span>
								</h4><input type="text" name="transactionAmount"
								id="transactionAmount" value="${transactionDetailsDo.transactionAmount}">
								<div class="errormsg marR-60" id="transactionAmount"></div></td>
						</tr>
					</table>
					<input type="hidden" value="" name="tmp" />
				</form:form>
				<div class="center marT10">
					<a href="javascript:void(0)" onclick="submitFormWithAjax();"
						class="button_link"><span id="pocBtn">Add Transaction Details</span></a>
				</div>
			</div>
			<!--POC FORM End-->

			<div class="tblDiv-2">
				<table class="listFieldsManage" width="100%" border="0"
					cellspacing="0" cellpadding="0" id="transactionTable">
					<tr>
						<th>Date</th>
						<th>Type</th>
						<th>Description</th>
						<th>Quantity</th>
						<th>Amount</th>
						<th>Remarks</th>
						<th>Action</th>
					</tr>
				</table>
			</div>
			<div>
				<div class="center">
					<a href="javascript:saveTransaction();" class="button_link"><span>Submit</span></a>
					<a href="list.html" class="button_link btn_cancel"><span>Cancel</span></a>
				</div>
			</div>
		</div>
	</div>
</div>
<script>
	initTransactionDetailsTable('transactionTable');
	clearTransactionDetailsForm();
</script>
<script>
	$(function() {
		$("#transactionDateString").datepicker({
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
