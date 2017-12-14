<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<script type="text/javascript">
	selectManageSupplier();
</script>

<div>&nbsp;</div>
<div class="clear"></div>
<div class="bodyContent">
	<div class="whiteBg">
		<div class="bradcrumb">
			<a href="../home/index.html">Home</a> &nbsp;| &nbsp; <a
				href="list.html">Manage Supplier</a> &nbsp;| &nbsp;View Supplier
			Details
		</div>
		<div class="tblDiv-1">
			<a href="list.html" class="right button_link btn_back"><span>Back</span></a>
			<div class="clear"></div>
			<h2>View Supplier Details</h2>
			<div class="formContent">
				<table class="listFields" width="100%" border="0" cellspacing="0"
					cellpadding="0">
					<tr>
						<td width="17%" class="td_bdrRnone"><h4 class="txtlight">Customer
								name</h4></td>
						<td width="32%"><c:out value="${supplierData.supplierName}" /></td>
						<td width="24%" class="td_bdrRnone"><h4 class="txtlight">Email</h4></td>
						<td width="27%"><c:out value="${supplierData.emailAddress}" /></td>
					</tr>
					<tr>
						<td class="td_bdrRnone"><h4 class="txtlight">Address1</h4></td>
						<td><c:out value="${supplierData.supplierAddress1}" /></td>
						<td class="td_bdrRnone"><h4 class="txtlight">POC</h4></td>
						<td><c:out value="${supplierData.supplierContact}" /></td>
					</tr>
					<tr>
						<td class="td_bdrRnone"><h4 class="txtlight">Primary
								Phone</h4></td>
						<td><c:out value="${supplierData.supplierPhone1}" /></td>
						<td class="td_bdrRnone"><h4 class="txtlight">Phone</h4></td>
						<td><c:out value="${supplierData.supplierPhone2}" /></td>
					</tr>
					<tr>
						<td class="td_bdrRnone"><h4 class="txtlight">City</h4></td>
						<td><c:out value="${supplierData.city}" /></td>
						<td class="td_bdrRnone"><h4 class="txtlight">State</h4></td>
						<td><c:out value="${bookRequest.state != '-1'?bookRequest.state:''}" /></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</div>
