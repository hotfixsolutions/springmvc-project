<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script type="text/javascript">
	$(document).ready(function() {

		$('#example').dataTable({
			"bProcessing" : true,
			"bJQueryUI" : true,
			"sDom": '<"H"Tfr>t<"F"ip>',
			"sPaginationType": "full_numbers",
			"sAjaxSource" : "dtSupplierView.html",
			"aoColumnDefs": [
			{
			"mRender":function (data, type, row) {
				return '<a href="viewDetails.html?supplierId=' + data + '">View</a>&nbsp;<a href="editSupplierForm.html?formType=edit&supplierId=' + data + '">Edit</a>'
			},
			"aTargets":[4]
			},
			{ "sClass": "center", "aTargets": [ 4 ] }
                       ] 
		});
	});
</script>

<div class="bodyContent">
	<div class="whiteBg">
		<div class="breadcrumb">
			<a href="../home/index.html">Home</a> &nbsp;| &nbsp; <a
				href="list.html">Manage Suppliers</a> &nbsp;| &nbsp;View Suppliers
		</div>
		<div class="tblDiv-1">
			<a href="list.html" class="right button_link btn_back"><span>Back</span></a>
			<div class="clear"></div>
			<h2>View Request Details</h2>
			<div class="formContent">
				<table cellpadding="0" cellspacing="0" border="0" class="display"
					id="example" width="100%">
					<thead>
						<tr>
							<th>Supplier Name</th>
							<th>Contact Person</th>
							<th>Email</th>
							<th>Phone Number</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
					<tfoot>
						<tr>
							<th>Supplier Name</th>
							<th>Contact Person</th>
							<th>Email</th>
							<th>Phone Number</th>
							<th>Action</th>
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
	</div>
</div>