<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="/WEB-INF/classes/displaytag-el-12.tld" prefix="display"%>
<%
	String pageSize = "10";
%>


<script type="text/javascript">
	selectManagePO();
</script>
<style>
.break_word {
	width: 150px;
	word-wrap: break-word;
	word-break: break-all;
	white-space: pre-wrap; /* css-3 */
	white-space: -moz-pre-wrap /* Mozilla, since 1999 */ 
	 white-space:  -pre-wrap; /* Opera 4-6 */
	white-space: -o-pre-wrap; /* Opera 7 */
	word-wrap: break-word; /* Internet Explorer 5.5+ */
}
</style>

<div class="bodyContent">
	<div class="whiteBg">
		<div class="breadcrumb">
			<a href="../home/index.html">Home</a> &nbsp;| &nbsp;Manage Transaction
		</div>
		<div class="tblDiv-2">
			<div class="marT10" align="left">
				<label><a href="addTransaction.html" class="left button_link"><span>Add Transaction</span></a> <a href="../home.html"
					class="right button_link btn_back"><span>Back</span></a></label>
			</div>
			<div class="clear">&nbsp;</div>

			<div class="listContent">

				<display:table class="listFieldsManage" name="transactionList" id="transaction"
					pagesize="<%=pageSize%>" style="width:100%" cellspacing="1"
					cellpadding="0" requestURI="">
					<display:column sortable="true" sortProperty="customerName" title="Customer Name">
						<div class="break_word"><c:out value='${transaction.customerName}' /></div>
					</display:column>
					<display:column title="Purchases">
						<div class="break_word"><c:out value='${transaction.customerOutstanding.totalPurchase}' /></div>
					</display:column>
					<display:column title="Payments">
						<div class="break_word"><c:out value='${transaction.customerOutstanding.totalPayment}' /></div>
					</display:column>
					<display:column sortable="true" title="Outstanding">
						<c:set var="outstanding" value='${transaction.customerOutstanding.totalPurchase - transaction.customerOutstanding.totalPayment}'/>
						<div class="break_word"><c:out value='${transaction.customerOutstanding.totalPurchase - transaction.customerOutstanding.totalPayment}' /></div>
					</display:column>

					<display:column sortable="false" title="Action" style="width:60px">
						<a href="viewDetails.html?coId=<c:out value="${transaction.coId}"/>"><img
							alt="" src="../images/Document.png" class="absMiddle"></a>
						<a
							href="editPOForm.html?formType=edit&coId=<c:out value="${transaction.coId}"/>"><img
							alt="" src="../images/Write.png" class="absMiddle"></a>
					</display:column>
				</display:table>
			</div>
			<a href="../home.html" class="right button_link btn_back"><span>Back</span></a>
			<div class="clear"></div>
		</div>
	</div>
</div>