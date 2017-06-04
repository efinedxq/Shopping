<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="/struts-tags" prefix="s" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'goodslist.jsp' starting page</title>
    
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
    <c:if test="${pageNo!=1}">
  	<a href="getAllGoods.action?pageNo=1">
  </c:if>
  		第一页
  <c:if test="${pageNo!=1}">
  	</a>
  </c:if>
  
  <s:if test="#request.pageNo!=1">
  	<a href="getAllGoods.action?pageNo=${pageNo-1}">
  </s:if>
                     上一页
  <s:if test="#request.pageNo!=1">
  	</a>
  </s:if>
  
  
  <c:if test="${pageNo!=pageCount}">
  	<a href="getAllGoods.action?pageNo=${pageNo+1}">
  </c:if>
  		下一页
  <c:if test="${pageNo!=pageCount}">
  	</a>
  </c:if>
  
  <c:if test="${pageNo!=pageCount}">
  	<a href="getAllGoods.action?pageNo=${pageCount}">
  </c:if>
  		最后一页
  <c:if test="${pageNo!=pageCount}">
  	</a>
  </c:if>
  <a href="showAddGoods">添加新商品</a>
  <a href="order/queryOrder">查看订单</a>
  <table border="1">
		<tr>
			<td>商品编号</td>
			<td>商品名称</td>
			<td>商品价格</td>
			<td>商品销量</td>
			<td></td>
		</tr>
				
		<s:iterator value="#request.goodslist" var="goods">
		<tr>
			<td><s:property value="goodsid"/></td>
			<td><s:property value="goodsname"/></td>
			<td><s:property value="price"/></td>
			<td><s:property value="cnt"/></td>
			<td>
			<a href="<s:url value="showModifyGoods?goodsId=%{goodsid}" />"
			>修改商品</a>
			<a href="<s:url value="deleteGoodsById?goodsId=%{goodsid}" />"
			>删除商品</a>
			<a href="<s:url value="addToCart.action?goodsId=%{goodsid}" />"
			>将商品添加到购物车中</a></td>
		</tr>
		</s:iterator>
	
	</table> 
  </body>
</html>
