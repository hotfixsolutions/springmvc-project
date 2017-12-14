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
			<a href="../home/index.html">Home</a> &nbsp;| &nbsp;Manage Purchase
			Order
		</div>
		<div class="tblDiv-2">
			<div class="marT10" align="left">
				<label><a href="addPOForm.html" class="left button_link"><span>Add
							New Purchase Order</span></a> <a href="../home.html"
					class="right button_link btn_back"><span>Back</span></a></label>
			</div>
			<div class="clear">&nbsp;</div>

			<div class="listContent">

				<display:table class="listFieldsManage" name="poList" id="po"
					pagesize="<%=pageSize%>" style="width:100%" cellspacing="1"
					cellpadding="0" requestURI="">
					<display:column sortable="true" sortProperty="poName" title="Name">
						<div class="break_word"><c:out value='${po.poPrefix}' /><c:out value='${po.poName}' /></div>
					</display:column>
					<display:column sortable="true" sortProperty="poDate"
						title="PO Date">
						<div class="break_word"><c:out value='${po.poDateString}' /></div>
					</display:column>
					<display:column sortable="true" sortProperty="supplierId"
						title="Supplier">
						<div class="break_word"><c:forEach items="${supplierList}" var="suppliers" varStatus="loop"><c:if test="${suppliers.supplierId == po.supplierId}"><c:out value="${suppliers.supplierName}" /></c:if></c:forEach></div>
					</display:column>
					<display:column title="Status">
						<div class="break_word"><c:choose><c:when test="${po.poStatus == '0'}">Pending</c:when><c:when test="${po.poStatus == '1'}">Confirmed</c:when><c:when test="${po.poStatus == '2'}">Fullfilled</c:when><c:otherwise>Cancelled</c:otherwise></c:choose></div>
					</display:column>

					<display:column sortable="false" title="Action" style="width:60px">
						<a href="viewDetails.html?poId=<c:out value="${po.poId}"/>"><img
							alt="" src="../images/Document.png" class="absMiddle"></a>
						<a
							href="editPOForm.html?formType=edit&poId=<c:out value="${po.poId}"/>"><img
							alt="" src="../images/Write.png" class="absMiddle"></a>
					</display:column>
				</display:table>
			</div>
			<a href="../home.html" class="right button_link btn_back"><span>Back</span></a>
			<div class="clear"></div>
		</div>
	</div>
</div>