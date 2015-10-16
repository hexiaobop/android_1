<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <script type="text/javascript" src="http://code.jquery.com/jquery-1.4.1.min.js"></script>
  
    <base href="<%=basePath%>">    
    <title>My JSP 'adminindex.jsp' starting page</title>   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style>
*{padding:0;
margin:0}
li{
background:silver; 
height: 35;
float: left;
margin-left: 1;
width:33.2%;
display:inline;
 height:35px;line-height:35px
}
button{height:35;
width:670px;

margin-top: 5;}

li:HOVER{
	background-color: red;
}
</style>
  </head> 
  <body>


<div style="background-color: #00e1ff; ;height: 35">
<span style="height: 35;float:left;font-size: 30; background-color:#dd46f8;letter-spacing:18px">1130花店后台管理</span>
<span style="float: right;font-size: 30">当前管理员：admin</span>
</div>
<hr>
<div>

<ul style="list-style: none;color:; text-align:center; ">
<li id="goods"><a>商品管理</a></li>
<li id="user">用户管理</li>
<li id ="list">订单管理</li>
</ul>
<br>
<hr>

</div>



<br>
<div id="detail_goods">
<button>添加商品</button><button style="margin-right: 0px">搜索商品</button> 
  <c:forEach items="${list}" var="item">  
<div >
<img src="${item['imageurl']}" width="170" height="142" align="center" />
<span>${item["name"] }</span>
<span>￥${item["price"] }元</span>
<span>商品号：${item["goods_id"] }</span>
<span>类别：${item["style_id"] }</span>
<button  style="width:100px;margin-left: 600px">删除</button>
<button style="width:100px">修改</button>
<hr>
</div>   
</c:forEach> 
共有商品${page['goodsnumber']}件   当前第<a href="#">${page['nowpage'] }</a>页
<a href="${page['firsturl']}">首页</a> <a href="${page['lasturl']}">末页</a><a href="?page1=${page['nowpage']-1}">上一页</a>
    <c:forEach var="x" begin="1" end="${page['pagetotal']}" step="1">  
   <a href="?page1=${x}"><c:out value="${x}"/>       
   </c:forEach> 
<a href="?page1=${page['nowpage']+1}">下一页</a>
</div>
 <script type="text/javascript" >
        $("#goods").bind("click", function(event) { $("#detailgoods").show(); $("#tt2").hide(); });
        $("#user").bind("click", function(event) { $("#tt1").hide(); $("#tt2").hide(); });
        $("#list").bind("click", function(event) { $("#tt1").show(); $("#tt2").hide(); });
       
    </script>
  </body>
</html>
