<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'orderList.jsp' starting page</title>
    
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
    <a href="getAllGoods?pageNo=1">继续购物</a>
    <c:forEach items="${orderList}" var="order">
    <table border="1">
        <tr>
            <td>订单编号</td>
            <td>${order.id}</td>
            <td>创建时间</td>
            <td>${order.createT }</td>
            <td><a href="order/deleteOrder?orderid=${order.id}">删除订单</a></td>
        </tr>
    </table>
    <table border="1">
        <tr>
            <td>物品编号</td>
            <td>物品名称</td>
            <td>物品价格</td>
            <td>数量</td>
        </tr>
        <c:forEach items="${order.items}" var="item">
            <tr>
                <form>
                <td>${item.goods.goodsid}</td>
                <td>${item.goods.goodsname }</td>
                <td>${item.goods.price }</td>
                <td>${item.quantity}</td>
                </form>
            </tr>
        </c:forEach>
    </table>
    </c:forEach>
  </body>
</html>
