<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<script type="text/javascript">
	selectManageCustomer();
</script>

<div>&nbsp;</div>
<div class="clear"></div>
<div class="bodyContent">
	<div class="whiteBg">
		<div class="breadcrumb">
			<a href="../home/index.html">Home</a> &nbsp;| &nbsp; <a href="list.html">Manage
				Request</a> &nbsp;| &nbsp;View Request Details
		</div>
		<div class="tblDiv-1">
			<a href="list.html" class="right button_link btn_back"><span>Back</span></a>
			<div class="clear"></div>
			<h2>View Request Details</h2>
			<div class="formContent">
				<table class="listFields" width="100%" border="0" cellspacing="0"
					cellpadding="0">
					<tr>
						<td width="17%" class="td_bdrRnone"><h4 class="txtlight">Book
								name</h4></td>
						<td width="32%"><c:out value="${requestData.bookName}" /></td>
						<td width="24%" class="td_bdrRnone"><h4 class="txtlight">Supplier</h4></td>
						<td width="27%">
							<c:forEach items="${supplierList}" var="supplier" varStatus="loop">
								<c:if test="${requestData.supplierId == supplier.supplierId}" >
									<c:out value="${supplier.supplierName}" />
								</c:if>
							</c:forEach>
						</td>
					</tr>
					<tr>
						<td class="td_bdrRnone"><h4 class="txtlight">Requestor</h4></td>
						<td><c:out value="${requestData.requestorName}" /></td>
						<td class="td_bdrRnone"><h4 class="txtlight">Contact Number</h4></td>
						<td><c:out value="${requestData.requestorPhone}" /></td>
					</tr>
					<tr>
						<td class="td_bdrRnone"><h4 class="txtlight">Email</h4></td>
						<td><c:out value="${requestData.email}" /></td>
						<td class="td_bdrRnone"><h4 class="txtlight">Status</h4></td>
						<td><c:out value="${(requestData.delivered == '1')?'Delivered':'Pending'}" /></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</div>