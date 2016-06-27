<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>招商选址需求匹配</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="./js/jquery/jquery.min.js"></script>
<script type="text/javascript" src="./js/jquery/jquery.json-2.4.js"></script>

</head>
<body>
	<div>
		<div style="width:100%;height:100px;float:left">
			<div style="width: 30%; float: left">
				<div style="border: 1">first</div>
				<div style="border: 1">second</div>
				<div style="border: 1">third</div>
			</div>
			<div style="width: 40%; float: left">
				<div>firth</div>
			</div>
		</div>
		<div style="width:100%;height:30px;float:left">
			<div style="width:100%">
			<div>five</div>
		</div>
	</div>
</body>
</html>