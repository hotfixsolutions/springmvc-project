<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="/WEB-INF/classes/displaytag-el-12.tld" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%
	String pageSize = "10";
%>


<script type="text/javascript">
	function submitForm() {
		document.filterForm.submit();
	}

	function clearFilter() {
		document.filterForm.bookName.value = "";
		document.filterForm.requestorName.value = "";
	}
</script>
<script>
	selectManageRequests();
</script>

<style>
.break_word {
	width: 150px;
	word-wrap: break-word;
	word-break: break-all;
	white-space: pre-wrap; /* css-3 */
	white-space: -moz-pre-wrap /* Mozilla, since 1999 */     
	 white-space:      -pre-wrap; /* Opera 4-6 */
	white-space: -o-pre-wrap; /* Opera 7 */
	word-wrap: break-word; /* Internet Explorer 5.5+ */
}
</style>

<div class="bodyContent">
	<div class="whiteBg">
		<div class="breadcrumb">
			<a href="../home/index.html">Home</a> &nbsp;| &nbsp;Manage Book
			Request
		</div>

		<div class="tblDiv-1">
			<div class="clear"></div>
			<div class="formContent">
				<form:form commandName="requestDO" action="filterRequest.html"
					method="post" name="filterForm">
					<table class="formFields">
						<tr>
							<td width="35%">Book Name: <input class="txtBox" type="text"
								name="bookName" id="textfield4"
								value="${requestDO.bookName}" /></td>
							<td>Requestor Name: <input class="txtBox" type="text"
								name="requestorName" id="textfield4"
								value="${requestDO.requestorName}" /></td>
						</tr>
					</table>
				</form:form>
				<div class="center">
					<a href="javascript:submitForm();" class="button_link"><span>Filter</span></a>
					<a href="javascript:clearFilter();" class="button_link btn_cancel"><span>Clear
							Filter</span></a>
				</div>
			</div>
		</div>

		<div class="tblDiv-2">
			<div class="marT10" align="left">
				<label><a href="addRequestForm.html"
					class="left button_link"><span>Add New Book Request</span></a> <a
					href="../home/index.html" class="right button_link btn_back"><span>Back</span></a></label>
			</div>
			<div class="clear">&nbsp;</div>
			<div class="listContent">
				<display:table class="listFieldsManage" name="requestList"
					id="bookRequest" pagesize="<%=pageSize%>" style="width:100%"
					cellspacing="1" cellpadding="0" requestURI="">
					<display:column sortable="true" sortProperty="bookName"
						title="Book Name">
						<div class="break_word"><c:out value='${bookRequest.bookName}' /></div>
					</display:column>
					<display:column sortable="true" sortProperty="requestorName"
						title="Requested By">
						<div class="break_word"><c:out value='${bookRequest.requestorName}' /></div>
					</display:column>
					<display:column sortable="false" title="Phone">
						<div class="break_word"><c:out value='${bookRequest.requestorPhone}' /></div>
					</display:column>
					<display:column sortable="true" sortProperty="dateRequested" title="Request Date">
						<div class="break_word"><fmt:formatDate pattern="dd-MMM-yyyy" value="${bookRequest.dateRequested}" /></div>
					</display:column>
					<display:column sortable="false" title="Advance Payment Amount">
						<div class="break_word"><c:out value="${(bookRequest.advanceAmount > 0)?bookRequest.advanceAmount:'--'}" /></div>
					</display:column>

					<display:column sortable="false" title="Action" style="width:60px">
						<a
							href="viewRequestDetail.html?requestid=<c:out value="${bookRequest.requestId}"/>"><img
							alt="" src="../images/Document.png" class="absMiddle"></a>
						<a
							href="editRequestForm.html?formType=edit&requestid=<c:out value="${bookRequest.requestId}"/>"><img
							alt="" src="../images/Write.png" class="absMiddle"></a>
					</display:column>
				</display:table>
			</div>
			<a href="../home/index.html" class="right button_link btn_back"><span>Back</span></a>
			<div class="clear"></div>
		</div>
	</div>
</div>