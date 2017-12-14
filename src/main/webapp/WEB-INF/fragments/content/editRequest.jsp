<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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

	function saveBookRequest() {
		document.bookRequestForm.submit();
	}
	
	function saveMailBookRequest() {
		document.bookRequestForm.action = "mailRequest.html";
		document.bookRequestForm.submit();
	}
	
</script>
<script type="text/javascript">
	selectManageRequests();
</script>
<div class="bodyContent">
	<div class="whiteBg">
		<div class="breadcrumb">
			<a href="../home/index.html">Home</a> &nbsp;| &nbsp; <a href="list.html">Manage
				Book Request</a> &nbsp;| &nbsp;Edit Request
		</div>
		<div class="tblDiv-1">
			<h2>Edit Request</h2>
		</div>
		<div class="formContent" style="padding-bottom: 0px">
			<div align="right" class="mbottomTop10">
				( <span class="menditary">*</span> fields are Required )
			</div>
			<form:form modelAttribute="requestDO" action="editRequest.html"
				method="post" name="bookRequestForm">
				<input type="hidden" name="requestId" id="requestId"
					value="${requestDO.requestId}" />
				<input type="hidden" name="bookName" id="bookName"
					value="${requestDO.bookName}" />
				<input type="hidden" name="advanceAmount" id="advanceAmount"
					value="${requestDO.advanceAmount}" />

				<table class="formFields" width="100%" border="0">
					<tr>
						<td width="35%"><h4>Book Name</h4> <b><c:out
									value="${requestDO.bookName}" /></b></td>
						<td>&nbsp;</td>

						<td width="35%"><h4>Supplier</h4> <select class="dd260"
							name="supplierId" id="select7">
								<option value="">Select</option>
								<c:forEach items="${supplierList}" var="suppliers"
									varStatus="loop">
									<option
										<c:if test="${suppliers.supplierId == requestDO.supplierId}" >selected</c:if>
										value="<c:out value="${suppliers.supplierId}" />">
										<c:out value="${suppliers.supplierName}" />
									</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td><h4>Publisher</h4> <input tabindex="" class="txtBox"
							name="publisher" id="publisher"
							value="${requestDO.publisher}" />
						<td width="35%"><h4>Author</h4> <input tabindex=""
							class="txtBox" name="author" id="author"
							value="${requestDO.author}" />
							<div class="errormsg marR-60">
								<form:errors path="author" />
							</div></td>
						<td>
							<h4>ISBN Code</h4> <input tabindex="" class="txtBox"
							name="isbnCode" id="isbnCode" value="${requestDO.isbnCode}" />
						</td>
					</tr>
					<tr>
						<td colspan="3" class="padT20"><div class="formGheading">
								<h3>Requestor Details</h3>
							</div>
						</td>
					</tr>
					<tr>
						<td><h4>
								Name<span class="mandatory">*</span>
							</h4> <input class="txtBox" type="text" name="requestorName"
							value="${requestDO.requestorName}" id="textfield8" />
							<div class="errormsg marR-60">
								<form:errors path="requestorName" />
							</div>
						</td>
						<td><h4>
								Phone Number<span class="mandatory">*</span>
							</h4> <input class="txtBox" type="text" name="requestorPhone"
							value="${requestDO.requestorPhone}" id="textfield11" />
							<div class="errormsg marR-60">
								<form:errors path="requestorPhone" />
							</div>
						</td>
						<td><h4>
								Email<span class="mandatory">*</span>
							</h4> <input class="txtBox" type="text" name="email"
							value="${requestDO.email}" id="textfield2" />
						</td>
					</tr>
					<tr>
						<td><h4>Address 1</h4> <input class="txtBox" type="text"
							name="requestorAddress1"
							value="${requestDO.requestorAddress1}" id="textfield8" />
						</td>
						<td><h4>Address 2</h4> <input class="txtBox" type="text"
							name="requestorAddress2"
							value="${requestDO.requestorAddress2}" id="textfield11" />
						</td>
						<td><h4>City</h4> <input class="txtBox" type="text"
							name="city" value="${requestDO.city}" id="textfield2" />
						</td>
					</tr>
					<tr>
						<td><h4>State</h4> <select class="dd260" name="state"
							id="select7">
								<option value="-1">Select</option>
								<c:forEach items="${stateList}" var="states" varStatus="loop">
									<option
										<c:if test="${states.stateCode == requestDO.state}" >selected</c:if>
										value="<c:out value="${states.stateCode}" />">
										<c:out value="${states.stateName}" />
									</option>
								</c:forEach>
						</select></td>
						<td><h4>Zip</h4> <input class="txtBox" type="text" name="zip"
							value="${requestDO.zip}" id="textfield11" />
						</td>
						<td><h4>Advance Payment</h4> <b></b><c:out
								value="${requestDO.advanceAmount}" /></b></td>
					</tr>
					<tr>
						<td><h4>Notified?</h4> <select class="dd260"
							name="notified" id="select7">
								<option value="-1">(Select)</option>
								<option value="1"
									<c:if test="${requestDO.notified == '1'}" >selected</c:if>>Notified</option>
								<option value="0"
									<c:if test="${requestDO.notified == '0'}" >selected</c:if>>Pending</option>
						</select></td>
						<td><h4>Delivered?</h4> <select class="dd260"
							name="delivered" id="select3">
								<option value="-1">(Select)</option>
								<option value="1"
									<c:if test="${requestDO.delivered == '1'}" >selected</c:if>>Delivered</option>
								<option value="0"
									<c:if test="${requestDO.delivered == '0'}" >selected</c:if>>Pending</option>
						</select></td>
					</tr>

				</table>
			</form:form>
			<div class="center">
				<a href="javascript:saveBookRequest();" class="button_link"><span>Submit</span></a>
				<a href="javascript:saveMailBookRequest();" class="button_link"><span>Submit and Mail</span></a>
				<a href="list.html" class="button_link btn_cancel"><span>Cancel</span></a>
			</div>

		</div>
	</div>
</div>
