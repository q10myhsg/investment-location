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
<link href="./css/index.css" rel="stylesheet" type="text/css" />
</head>
<script type="text/javascript">
	var ip = document.location.host;
	var procject = getProjectName();

	//var data = "{\"passport\":{\"passport_id\":\"2771\",\"passport_first_name\":\"第\",\"passport_last_name\":\"三方\",\"passport_name\":\"第三方\",\"passport_sex\":\"0\",\"passport_utime\":\"2015-10-22 10:54:05\",\"passport_ctime\":\"2015-10-22 10:54:05\",\"passport_vtime\":\"0000-00-00 00:00:00\",\"passport_email\":\"disanfang@1049.com\",\"passport_mobile\":\"13426031069\",\"passport_password\":\"9ca28a77294f8f5d402fac6c6a47697c5f83cf1536c912ec646aa5d2c4744ed0\",\"passport_type\":\"4\",\"passport_picture\":\"\",\"passport_job_title\":\"职位名称\",\"passport_job_area\":\"\",\"area_id\":\"86016125\",\"passport_business_card\":\"\",\"passport_idcard\":\"\",\"passport_idcard_photo\":\"\",\"passport_weixin\":\"\",\"passport_weixin_open_id\":\"\",\"passport_weixin_push\":\"1\",\"passport_ip\":\"192.168.1.183\",\"passport_id_recommend\":null,\"passport_flag\":\"1\",\"passport_status_desc\":\"\",\"passport_company\":\"公司名称\",\"category_ids_other\":\"\",\"category_ids\":[\"\"],\"passport_in_blacklist\":\"0\",\"passport_status\":\"1\",\"passport_status_before\":null,\"passport_send_sms\":\"0\",\"passport_edit_option\":\"\",\"passport_private_mode\":\"0\"},\"demand\":{\"demand_ctime\":\"2015-10-22 10:55:38\",\"demand_utime\":\"2015-10-22 10:55:38\",\"passport_id\":2771,\"mall_id\":664,\"mall_name\":\"ACT汽车小镇\",\"area_id\":[86016140],\"demand_desc\":\"t特色搜索诉讼费\",\"demand_show_mobile\":1,\"demand_level\":1,\"demand_status\":1,\"category_ids\":[40200,40300],\"category_ids_other\":\"\",\"demand_shop_type\":[1,2],\"demand_type\":2,\"passport_type\":4,\"passport_company\":\"公司名称\",\"allow_moible\":1,\"tag\":{\"group_126\":{\"lower\":11200,\"upper\":11300}},\"_id\":\"5628502a9638445b568b456d\"},\"type\":\"add\"}";
	//xz
	var data = "{\"passport\":{\"passport_id\":\"2771\",\"passport_first_name\":\"第\",\"passport_last_name\":\"三方\",\"passport_name\":\"第三方\",\"passport_sex\":\"0\",\"passport_utime\":\"2015-10-22 10:54:05\",\"passport_ctime\":\"2015-10-22 10:54:05\",\"passport_vtime\":\"0000-00-00 00:00:00\",\"passport_email\":\"disanfang@1049.com\",\"passport_mobile\":\"13426031069\",\"passport_password\":\"9ca28a77294f8f5d402fac6c6a47697c5f83cf1536c912ec646aa5d2c4744ed0\",\"passport_type\":\"4\",\"passport_picture\":\"\",\"passport_job_title\":\"职位名称\",\"passport_job_area\":\"\",\"area_id\":\"86016125\",\"passport_business_card\":\"\",\"passport_idcard\":\"\",\"passport_idcard_photo\":\"\",\"passport_weixin\":\"\",\"passport_weixin_open_id\":\"\",\"passport_weixin_push\":\"1\",\"passport_ip\":\"192.168.1.183\",\"passport_id_recommend\":null,\"passport_flag\":\"1\",\"passport_status_desc\":\"\",\"passport_company\":\"公司名称\",\"category_ids_other\":\"\",\"category_ids\":[\"\"],\"passport_in_blacklist\":\"0\",\"passport_status\":\"1\",\"passport_status_before\":null,\"passport_send_sms\":\"0\",\"passport_edit_option\":\"\",\"passport_private_mode\":\"0\"},\"demand\":{\"_id\":\"55a360b9de833c6e778b4567\",\"demand_ctime\": \"2015-07-13 14:54:49\",\"demand_utime\": \"2015-09-05 15:24:37\",\"demand_expiry_at\": \"2018-09-13\",\"passport_id\": 2864,\"brand_id\": 10922,\"brand_name\": \"避风塘\",\"category_ids\": [10102],\"category_ids_other\": \"\",\"area_id\": [86999030],\"demand_desc\": \"大力开店中、联系电话萧13811261600\",\"demand_show_mobile\": 1,\"demand_level\": 1,\"demand_status\": 1,\"demand_type\": 1,\"passport_type\": 1,\"passport_company\": \"北京避风塘餐饮管理有限公司\",\"tag\": {\"group_36\": [118, 120, 119],\"group_41\": {\"lower\": 26000,\"upper\": 50000},\"group_116\": [256],\"group_46\": [137, 138, 139, 140, 142, 143, 144, 145, 146, 147, 149, 150, 151, 152, 249, 250, 251],\"group_40\": [500],\"group_42\": {\"lower\": 0,\"upper\": 0}},\"weixin_push\": 1},\"type\":\"add\"}";
	//zs
	//data ="{\"passport\":{\"passport_id\":\"2771\",\"passport_first_name\":\"第\",\"passport_last_name\":\"三方\",\"passport_name\":\"第三方\",\"passport_sex\":\"0\",\"passport_utime\":\"2015-10-22 10:54:05\",\"passport_ctime\":\"2015-10-22 10:54:05\",\"passport_vtime\":\"0000-00-00 00:00:00\",\"passport_email\":\"disanfang@1049.com\",\"passport_mobile\":\"13426031069\",\"passport_password\":\"9ca28a77294f8f5d402fac6c6a47697c5f83cf1536c912ec646aa5d2c4744ed0\",\"passport_type\":\"4\",\"passport_picture\":\"\",\"passport_job_title\":\"职位名称\",\"passport_job_area\":\"\",\"area_id\":\"86016125\",\"passport_business_card\":\"\",\"passport_idcard\":\"\",\"passport_idcard_photo\":\"\",\"passport_weixin\":\"\",\"passport_weixin_open_id\":\"\",\"passport_weixin_push\":\"1\",\"passport_ip\":\"192.168.1.183\",\"passport_id_recommend\":null,\"passport_flag\":\"1\",\"passport_status_desc\":\"\",\"passport_company\":\"公司名称\",\"category_ids_other\":\"\",\"category_ids\":[\"\"],\"passport_in_blacklist\":\"0\",\"passport_status\":\"1\",\"passport_status_before\":null,\"passport_send_sms\":\"0\",\"passport_edit_option\":\"\",\"passport_private_mode\":\"0\"},\"demand\":{\"_id\" : \"55a38006de833c75738b456a\",\"demand_ctime\" : \"2015-07-13 17:08:22\",\"demand_utime\" : \"2015-09-05 15:24:37\",\"demand_expiry_at\" : \"2015-08-26\",\"passport_id\" : 1879,\"mall_id\" : 724,\"mall_name\" : \"南锣鼓巷左右时代\",\"area_id\" : [86999030],\"demand_desc\" : \"面积35至200至500平米不等；\\n左右时代位于北京南锣鼓巷，紧邻地铁6、8号线出口。\",\"demand_show_mobile\" : 1,\"demand_level\" : 1,\"demand_status\" : 2,\"category_ids\" : [10101, 10117, 10200, 10300, 10400, 10600, 11000, 20103, 20400, 20700, 20800, 50902, 60100, 70200, 90202],\"category_ids_other\" : \"\",\"demand_shop_type\" : [2, 3],\"demand_type\" : 2,\"passport_type\" : 3,\"passport_company\" : \"北京南锣文化发展有限公司\",\"tag\" : {\"group_126\" : {\"lower\" : 5000,\"upper\" : 0}},\"weixin_push\" : 1},\"type\":\"add\"}";
	function getProjectName() {
		var curWwwPath = window.document.location.href;
		var pathName = window.document.location.pathname;
		var pos = curWwwPath.indexOf(pathName);
		var localhostPaht = curWwwPath.substring(0, pos);
		var projectName = pathName.substring(1,
				pathName.substr(1).indexOf('/') + 1);
		return (projectName);
	}

	$(document).ready(function() {
		$("#doc").val(data);
		$("#doc2").val(data);
		$("#doc3").val(data);
	});

	function init() {
		var data = $.ajax({
			url : encodeURI("http://" + ip + "/" + procject
					+ "/rest/demand/init"),
			type : 'GET',
			timeout : 600000,
			contentType : 'application/json',
			async : false,
			success : function(result) {
				$("#responseDataInit").val(JSON.stringify(result));
			},
			error : function(jqXHR, textStatus, errorThrown) {
				alert("error:" + textStatus);
			}
		});
	}
	
	function restAddNewOne(){
		var id=$("#id_new").val();
		var url = "http://" + ip + "/" + procject + "/rest/demand/addNew/"+id
		$.ajax({
			url : encodeURI(url),
			data : postData,
			type : 'GET',
			timeout : 60000,
			contentType : 'application/json',
			async : false,
			success : function(result) {
				$("#responseData_new").val(JSON.stringify(result));
			},
			error : function(jqXHR, textStatus, errorThrown) {
				alert("error:" + textStatus);
			}
		});
	}

	//新增获取修改需求匹配信息
	function restAdd() {
		var postData = $("#doc").val();
		var url = "http://" + ip + "/" + procject + "/rest/demand/add"
		$("#postData").val(encodeURI(url) + " -XPOST -D " + postData);
		$.ajax({
			url : encodeURI(url),
			data : postData,
			type : 'POST',
			timeout : 60000,
			contentType : 'application/json',
			async : false,
			success : function(result) {
				$("#responseData").val(JSON.stringify(result));
			},
			error : function(jqXHR, textStatus, errorThrown) {
				alert("error:" + textStatus);
			}
		});
	}
	//获取推荐内容获取相似内容信息
	function rest() {
		var postData = $("#doc2").val();
		var url = "http://" + ip + "/" + procject + "/rest/demand/";
		var method=$("#method2").val();
		if(method==1){
			url =url + "re";
		}else{
			url = url + "sim";
		}
		$("#postData2").val(encodeURI(url) + " -XGET -D " + postData);
		var data = $.ajax({
			url : encodeURI(url),
			data : postData,
			type : 'POST',
			timeout : 60000,
			contentType : 'application/json',
			async : false,
			success : function(result) {
				$("#responseData2").val(JSON.stringify(result));
				//fill(result,"scan2");
			},
			error : function(jqXHR, textStatus, errorThrown) {
				alert("error:" + textStatus);
			}
		});
	}
	//填充显示
	function fill(result, name) {
		//var obj = eval("(" + result + ")");
		var obj = result;
		var html = "";
		//scan
		for ( var v in obj) {
			//alerT(obj[v]);
			//组合html
			var str = "<div class=\"block\"></div><div class=\"demand\"><div class=\"obj\"><em class=\"leftObj\">id:</em><div class=\"rightObj\">"
					+ obj[v].demandId + "</div></div>";
			str = str
					+ "<div class=\"obj\"><em class=\"leftObj\">商业体id:</em><div class=\"rightObj\">"
					+ obj[v].bid + "</div></div>";
			str = str
					+ "<div class=\"obj\"><em class=\"leftObj\">商业体名:</em><div class=\"colorRed rightObj\">"
					+ obj[v].bid_name + "</div></div>";
			str = str
					+ "<div class=\"obj\"><em class=\"leftObj\">得分:</em><div class=\"colorRed rightObj\">"
					+ obj[v].score + "</div></div>";
			str = str
					+ "<div class=\"obj\"><em class=\"leftObj\">地区:</em><div class=\"colorRed\">"
					+ obj[v].area_id + "</div></div>";
			str = str
					+ "<div class=\"obj\"><em class=\"leftObj\">是否显示手机:</em><div class=\"colorRed\">"
					+ obj[v].demand_show_mobile + "</div></div>";
			str = str
					+ "<div class=\"obj\"><em class=\"leftObj\">需求级别:</em><div class=\"colorRed\">"
					+ obj[v].demand_level + "</div></div>";
			str = str
					+ "<div class=\"obj\"><em class=\"leftObj\">所述业态:</em><div class=\"colorRed\">"
					+ obj[v].category_ids + "</div></div>";
			str = str
					+ "<div class=\"obj\"><em class=\"leftObj\">需求属性:</em><div class=\"colorRed\">"
					+ obj[v].tag_dot_preferredProperty + "</div></div>";
			str = str
					+ "<div class=\"obj\"><em class=\"leftObj\">商铺条件:</em><div class=\"colorRed\">"
					+ obj[v].tag_dot_shopSpecifications + "</div></div>";
			str = str
					+ "<div class=\"obj\"><em class=\"leftObj\">商铺类型:</em><div class=\"colorRed\">"
					+ obj[v].tag_dot_shopType + "</div></div>";
			str = str
					+ "<div class=\"obj\"><em class=\"leftObj\">termCooperation:</em><div class=\"colorRed\">"
					+ obj[v].tag_dot_termCooperation + "</div></div>";
			str = str
					+ "<div class=\"obj\"><em class=\"leftObj\">商业体面积限制L:</em><div class=\"colorRed\">"
					+ obj[v].tag_dot_areaDeman_dot_lower + "</div></div>";
			str = str
					+ "<div class=\"obj\"><em class=\"leftObj\">商业体面积限制U:</em><div class=\"colorRed\">"
					+ obj[v].tag_dot_areaDeman_dot_upper + "</div></div>";
			str = str
					+ "<div class=\"obj\"><em class=\"leftObj\">租金限制L:</em><div class=\"colorRed\">"
					+ obj[v].tag_dot_budgetRent_dot_lower + "</div></div>";
			str = str
					+ "<div class=\"obj\"><em class=\"leftObj\">租金限制U:</em><div class=\"colorRed\">"
					+ obj[v].tag_dot_budgetRent_dot_upper + "</div></div>";
			str = str
					+ "<div class=\"obj\"><em class=\"leftObj\">店铺面积限制L:</em><div class=\"colorRed\">"
					+ obj[v].tag_dot_shopArea_dot_lower + "</div></div>";
			str = str
					+ "<div class=\"obj\"><em class=\"leftObj\">店铺面积限制U:</em><div class=\"colorRed\">"
					+ obj[v].tag_dot_shopArea_dot_upper + "</div></div>";
			str = str + "</div>"
			html = html + str;
		}
		$("#" + name).html(html);
	}

	function restHard() {
		var postData = $("#doc3").val();
		$("#postData2").val(
				encodeURI(url) + " -XGET -D " + JSON.stringify(postData));
		var data = $.ajax({
			url : encodeURI(url),
			data : JSON.stringify(postData),
			type : 'POST',
			timeout : 60000,
			contentType : 'application/json',
			async : false,
			success : function(result) {
				$("#responseData2").val(JSON.stringify(result));
				fill(result);
			},
			error : function(jqXHR, textStatus, errorThrown) {
				alert("error:" + textStatus);
			}
		});
	}
</script>
<body>
	<h1>初始化程序</h1>
	<h3>数据会全部删除</h3>
	</br>

	<em>执行初始化程序:</em>
	<input type="button" onclick="init()" value="初始化"></input>
	<p></p>
	返回内容
	<em>:</em>
	<textarea id="responseDataInit" cols="50" rows="10"></textarea>
	</br>
	</br>
	<h1>新增一个文档方法</h1>
	<em>docId:</em><input id="id_new" value=""></input>
	<input type="button" onclick="restAddNewOne()" value="新增"></input>
	</br> 返回内容
	<em>:</em>
	<textarea id="responseData_new" cols="50" rows="10"></textarea>
	</br>

	<h1>文档操作方法</h1>
	<textarea id="doc" cols="150" rows="20"></textarea>
	</br>
	</br>
	<em>获取内容:</em>
	<input type="button" onclick="restAdd()" value="点击"></input>
	<p></p>
	发送内容
	<em>:</em>
	<textarea id="postData" cols="50" rows="5"></textarea>
	</br> 返回内容
	<em>:</em>
	<textarea id="responseData" cols="50" rows="10"></textarea>
	</br>
	</br>
	<h1>获取匹配相似方法</h1>
	<div>
		</select></br> <a>方法类型</a><em>:</em> <select id="method2">
					<option value="1">匹配</option>
					<option selected="selected" value="2">相似</option>
				</select></br>
		<div style="width: 100%; height: 300px; float: left">
			<textarea id="doc2" cols="150" rows="20"></textarea>
		</div>
		<em>获取内容:</em> <input type="button" onclick="rest()" value="点击"></input>
		<p></p>
		<div style="width: 100%; float: left">
			<p></p>
			发送内容<em>:</em>
			<textarea id="postData2" cols="50" rows="5"></textarea>
			</br> 返回内容<em>:</em>
			<textarea id="responseData2" cols="150" rows="10"></textarea>
			</br>
		</div>
	</div>
	<div id="scan2" class="divcss1"></div>


	<h1>获取匹配相似硬性方法</h1>
	<div>
		<div style="width: 100%; height: 200px; float: left">
			<textarea id="doc3" cols="150" rows="20"></textarea>
		</div>
		<div style="width: 100%; float: left">
			<p></p>
			发送内容<em>:</em>
			<textarea id="postData3" cols="50" rows="5"></textarea>
			</br> 返回内容<em>:</em>
			<textarea id="responseData3" cols="150" rows="10"></textarea>
			</br>
		</div>
	</div>
	<div id="scan3" class="divcss1"></div>
</body>
</html>