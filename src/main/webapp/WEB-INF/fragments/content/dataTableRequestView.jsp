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
			"sAjaxSource" : "dataTableView.html",
			"aoColumnDefs": [
			{
			"mRender":function (data, type, row) {
				return '<a href="viewRequestDetail.html?requestid=' + data + '">Edit</a>'
			},
			"aTargets":[3]
			},
			{ "sClass": "center", "aTargets": [ 3 ] }
                       ] 
		});
	});
</script>

<div class="bodyContent">
	<div class="whiteBg">
		<div class="breadcrumb">
			<a href="../home/index.html">Home</a> &nbsp;| &nbsp; <a
				href="list.html">Manage Request</a> &nbsp;| &nbsp;View Request
			Details
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
							<th>Book Name</th>
							<th>Requestor</th>
							<th>Phone Number</th>
							<th>Edit</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
					<tfoot>
						<tr>
							<th>Book Name</th>
							<th>Requestor</th>
							<th>Phone Number</th>
							<th>Edit</th>
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
	</div>
</div>