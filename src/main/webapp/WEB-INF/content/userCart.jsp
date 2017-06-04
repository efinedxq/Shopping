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
    
    <title>My JSP 'cart.jsp' starting page</title>
    
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
  <a href="clearCart">清空购物车</a>
  
  
  <c:if test="${! empty sessionScope.cart}">
  	
	<table border="1">
		<tr>
			<td>物品编号</td>
			<td>物品名称</td>
			<td>物品价格</td>
			<td>物品数量</td>
			<td>操作</td>
		</tr>
		
		<c:forEach items="${sessionScope.cart}" var="item">
		<tr>
			<form >
				<td>${item.goods.goodsid} </td>
				<td>${item.goods.goodsname}</td>
				<td>${item.goods.price}</td>
				<td><input type="text" name="quantity" value="${item.quantity}" /></td>
				<td>
						<input type="hidden" name="goodsId" value="${item.goods.goodsid}"/>
						<input type="button" value="修改" onclick="modifyGoods(this.form)"/>
						<input type="button" value="删除" onclick="deleteGoods(this.form)"/>
				</td>
			</form>
		</tr>
		</c:forEach>
  		<a href="order/addOrder">提交订单</a>
  	</table> 
  </c:if>

   <c:if test="${empty cart}">
   	购物车为空，请直接购物！
	</c:if>
	
<script type="text/javascript">
	function modifyGoods(form){
		//alert(form.goodsId.value);
		form.action="modifyGoods";
		form.submit();
	}
	function deleteGoods(form){
		//alert("deleteGoods");
		form.action="deleteGoods";
		form.submit();
	}
</script>
  </body>
</html>
