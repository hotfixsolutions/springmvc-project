<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="/WEB-INF/classes/displaytag-el-12.tld" prefix="display"%>
<%
	String pageSize = "10";
%>


<script type="text/javascript">
	selectManageSupplier();
</script>
<style>
.break_word{
	width : 150px;
	word-wrap: break-word; 
	word-break: break-all;
	white-space: pre-wrap;       /* css-3 */
	white-space: -moz-pre-wrap   /* Mozilla, since 1999 */
	white-space: -pre-wrap;      /* Opera 4-6 */
	white-space: -o-pre-wrap;    /* Opera 7 */
	word-wrap: break-word;       /* Internet Explorer 5.5+ */
}
</style>

<div class="bodyContent">
	<div class="whiteBg">
		<div class="breadcrumb">
			<a href="../home/index.html">Home</a> &nbsp;| &nbsp;Manage Suppliers
		</div>
		<div class="tblDiv-2">
			<div class="marT10" align="left">
				<label><a href="supplierForm.html"
					class="left button_link"><span>Add New Supplier</span></a> <a
					href="../home.html" class="right button_link btn_back"><span>Back</span></a></label>
			</div>
			<div class="clear">&nbsp;</div>

			<div class="listContent">

				<display:table class="listFieldsManage" name="supplierList"
					id="supplier" pagesize="<%=pageSize%>" style="width:100%"
					cellspacing="1" cellpadding="0" requestURI="">
					<display:column sortable="true" sortProperty="supplierName"
						title="SupplierName">
						<div class="break_word"><c:out value='${supplier.supplierName}' /></div>
					</display:column>
					<display:column sortable="false" title="Contact Person">
						<div class="break_word"><c:out value='${supplier.supplierContact}' /></div>
					</display:column>
					<display:column sortable="false" title="Primary Phone">
						<div class="break_word"><c:out value='${supplier.supplierPhone1}' /></div>
					</display:column>
					<display:column sortable="false" title="Email">
						<div class="break_word"><c:out value='${supplier.emailAddress}' /></div>
					</display:column>

					<display:column sortable="false" title="Action" style="width:60px">
						<a
							href="viewDetails.html?supplierId=<c:out value="${supplier.supplierId}"/>"><img  
							alt="" src="../images/Document.png" class="absMiddle"></a>
						<a
							href="editSupplierForm.html?formType=edit&supplierId=<c:out value="${supplier.supplierId}"/>"><img
							alt="" src="../images/Write.png" class="absMiddle"></a>
					</display:column>
				</display:table>
			</div>
			<a href="../home.html" class="right button_link btn_back"><span>Back</span></a>
			<div class="clear"></div>
		</div>
	</div>
</div>