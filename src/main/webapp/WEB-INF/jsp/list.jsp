<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="/WEB-INF/jsp/common.jsp" %>
	<title>员工列表</title>
</head>
<body>
<script type="text/javascript">
	window.onload=function test(){
		$.ajax({
			type:"get", //请求方式
			url:"/ssm", //请求路径
			dataType : "json",//返回的数据类型
			success:function(data){

				var htm = "";
				htm += "<table><thead><tr><th>ID</th><th>用户名</th><th>密码</th></tr></thead><tbody>";
				for(var i=0;i<data.length;i++){

					//console.log(item[i].name);

					htm += '<tr><td>' + data[i].id + '</td><td>'
							+ data[i].username + '</td><td>'
							+ data[i].password + '</td><td>'
				}
				htm += '</tbody></table>';
				$("#apitesttry").append(htm);
			},
			error:function(){
				alert("error");
			}
		});
	}
</script>
<span class="label label-default">Default</span>
<span class="label label-primary">Primary</span>
<span class="label label-success">Success</span>
<span class="label label-info">Info</span>
<span class="label label-warning">Warning</span>
<span class="label label-danger">Danger</span>
	<form action="" method="post" id="apitesttry" >		
	</form>

</body>

</html>