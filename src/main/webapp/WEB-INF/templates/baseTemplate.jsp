<%@ page language="java"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional //EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title><tiles:getAsString name="title" ignore="true" /></title>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%
	response.setHeader(
			"Cache-Control",
			"no-cache, no-store, must-revalidate, max-age=0, proxy-revalidate, no-transform, pre-check=0, post-check=0, private");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
%>
<link href="<%=request.getContextPath()%>/css/style.css"
	rel="stylesheet" type="text/css" />
<link
	href="<%=request.getContextPath()%>/css/jquery-ui-1.8.14.custom.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/model_dialog.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/accordian.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/demo_tables.css"
	rel="stylesheet" type="text/css" />

<script language="javascript" type="text/javascript"
	src="<%=request.getContextPath()%>/javascript/common.js"></script>
<script language="javascript" type="text/javascript"
	src="<%=request.getContextPath()%>/javascript/jquery.ui.core.js"></script>
<script language="javascript" type="text/javascript"
	src="<%=request.getContextPath()%>/javascript/jquery.ui.datepicker.js"></script>
<script language="javascript" type="text/javascript"
	src="<%=request.getContextPath()%>/javascript/jquery-1.8.2.js"></script>
<script language="javascript" type="text/javascript"
	src="<%=request.getContextPath()%>/javascript/jquery-ui-1.8.16.min.js"></script>
<script language="javascript" type="text/javascript"
	src="<%=request.getContextPath()%>/javascript/SpryCollapsiblePanel.js"></script>
<script language="javascript" type="text/javascript"
	src="<%=request.getContextPath()%>/javascript/jquery.dataTables.min.js"></script>
<script language="javascript" type="text/javascript"
	src="<%=request.getContextPath()%>/javascript/test.js"></script>	
</head>
<body>

	<div id="Wrapper">
		<!-- start of header -->
		<tiles:insertAttribute name="header" />
		<!-- End of header -->
		<!-- start of content -->
		<tiles:insertAttribute name="content" />
		<!-- End of content -->
	</div>
	<!-- start of footer -->
	<tiles:insertAttribute name="footer" />
	<!-- end of footer -->
</body>
</html>
