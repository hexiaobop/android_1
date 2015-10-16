<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">  
    <title>1130花店</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head> 
  <body>
  <c:forEach items="${list}" var="item">  
<div>
<img src="${item['imageurl']}" width="170" height="142" align="center" />
<span>${item["name"] }</span>
<span>￥${item["price"] }元</span>
<span>商品号：${item["goods_id"] }</span>
<span>类别：${item["style_id"] }</span>
<hr>
</div>   
</c:forEach> 
共有商品${page['goodsnumber']}件   当前第<a href="#">${page['nowpage'] }</a>页
<a href="${page['firsturl']}">首页</a> <a href="${page['lasturl']}">末页</a><a href="?page1=${page['nowpage']-1}">上一页</a>
    <c:forEach var="x" begin="1" end="${page['pagetotal']}" step="1">  
   <a href="?page1=${x}"><c:out value="${x}"/>       
   </c:forEach> 

<a href="?page1=${page['nowpage']+1}">下一页</a>

</body>
</html>
