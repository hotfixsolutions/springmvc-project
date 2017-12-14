
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
	   white-space:    -pre-wrap; /* Opera 4-6 */
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

	function saveSupplier() {
		document.supplierForm.submit();
	}

	selectManageSupplier();
</script>

<div class="bodyContent">
	<div class="whiteBg">
		<div class="breadcrumb">
			<a href="../home/index.html">Home</a> &nbsp;| &nbsp; <a href="list.html">Manage
				Supplier</a> &nbsp;| &nbsp;Add Supplier
		</div>
		<div class="tblDiv-1">
			<h2>Edit Supplier</h2>
			<div class="formContent" style="padding-bottom: 0px">
				<div align="right" class="mbottomTop10">
					( <span class="mandatory">*</span> fields are Required )
				</div>
				<form:form commandName="supplierDO" action="editSupplier.html"
					method="post" name="supplierForm">
					<input type="hidden" name="supplierId" id="supplierId"
						value="${supplierDO.supplierId}" />

					<table class="formFields" width="100%" border="0" cellspacing="0"
						cellpadding="0">
						<tr>
							<td width="35%"><h4>
									Supplier Name<span class="mandatory">*</span>
								</h4> <input tabindex="" class="txtBox" name="supplierName"
								id="supplierName" value="${supplierDO.supplierName}" />
								<div class="errormsg marR-60">
									<form:errors path="supplierName" />
								</div></td>
							<td>&nbsp;</td>
							<td width="35%"><h4>Contact Person</h4> <input tabindex=""
								class="txtBox" name="supplierContact" id="supplierContact"
								value="${supplierDO.supplierContact}" /></td>
						</tr>
						<tr>
							<td colspan="3" class="padT20"><div class="formGheading">
									<h3>Address</h3>
								</div></td>
						</tr>
						<tr>
							<td><h4>
									Email<span class="mandatory">*</span>
								</h4> <input class="txtBox" type="text" name="emailAddress"
								value="${supplierDO.emailAddress}" id="emailAddress" />
								<div class="errormsg marR-60">
									<form:errors path="emailAddress" />
								</div></td>
							<td><h4>Address 1</h4> <input class="txtBox" type="text"
								name="supplierAddress1" value="${supplierDO.supplierAddress1}"
								id="textfield11" /></td>
							<td><h4>City</h4> <input class="txtBox" type="text"
								name="city" value="${supplierDO.city}" id="textfield2" /></td>
						</tr>
						<tr>
							<td><h4>
									Phone 1<span class="mandatory">*</span>
								</h4> <input class="txtBox" type="text" name="supplierPhone1"
								value="${supplierDO.supplierPhone1}" id="textfield10" />
								<div class="errormsg marR-60">
									<form:errors path="supplierPhone1" />
								</div></td>
							<td><h4>Address 2</h4> <input class="txtBox" type="text"
								name="supplierAddress2" value="${supplierDO.supplierAddress2}"
								id="textfield11" /></td>
							<td><h4>State</h4> <select class="dd260" name="state"
								id="select7">
									<option value="-1">Select</option>
									<c:forEach items="${stateList}" var="states" varStatus="loop">
										<option
											<c:if test="${states.stateCode == supplierDO.state}" >selected</c:if>
											value="<c:out value="${states.stateCode}" />">
											<c:out value="${states.stateName}" />
										</option>
									</c:forEach>
							</select></td>

						</tr>

						<tr>
							<td><h4>Phone 2</h4> <input class="txtBox" type="text"
								name="supplierPhone2" value="${supplierDO.supplierPhone2}"
								id="textfield10" />
								<div class="errormsg marR-60">
									<form:errors path="supplierPhone2" />
								</div></td>
							<td><h4>Address 3</h4> <input class="txtBox" type="text"
								name="supplierAddress3" value="${supplierDO.supplierAddress3}"
								id="textfield10" /></td>
							<td><h4>
									Zip<span class="mandatory">*</span>
								</h4> <input class="txtBox" type="text" name="zip"
								value="${supplierDO.zip}" id="textfield3" /></td>
						</tr>
						<tr>
							<td><h4>
									Status<span class="mandatory">*</span>
								</h4> <select class="dd260" name="status" id="select3">
									<option value="-1">(Select)</option>
									<option value="1"
										<c:if test="${supplierDO.status == '1'}" >selected</c:if>>Active</option>
									<option value="0"
										<c:if test="${supplierDO.status == '0'}" >selected</c:if>>Inactive</option>
							</select>
								<div class="errormsg marR-60">
									<form:errors path="status" />
								</div></td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
					</table>
				</form:form>
			</div>
		</div>

		<div>
			<div class="center">
				<a href="javascript:saveSupplier();" class="button_link"><span>Submit</span></a>
				<a href="list.html" class="button_link btn_cancel"><span>Cancel</span></a>
			</div>
		</div>
	</div>
</div>

