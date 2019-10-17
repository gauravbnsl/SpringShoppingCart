<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<html>
	<head>
		<title>
			Smart Watches
		</title>

		<link type="text/css"
			rel="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/style.css"/>
	</head>
	<body>
		<div id="wrapper">
			<div id = "header">
				<h2>Smart Watches for Sale</h2>
			</div>
		</div>
		<hr>
		<div id="container">
			<table>
				<tr>
					<th>Name</th>
					<th>Price</th>
					<th>Quantity</th>
					<th>Purchase</th>
				</tr>
				<c:forEach var = "tempProduct" items = "${products}">
					
					<c:url var="updateLink" value = "/products/showFormUpdate">
						<c:param name="productId" value = "${tempProduct.id}"/>
					</c:url>
					
					<tr>
						<td>${tempProduct.prodname}</td>
						<td>${tempProduct.price}</td>
						<td>
							<c:if test="${tempProduct.quantity == 0}">
 								<c:out value="Out Of Stock"/>
							</c:if>
							<c:if test="${tempProduct.quantity > 0}">
 								<c:out value="${tempProduct.quantity}"/>
 							</c:if>
 						</td>
						<td>
							<a href="${updateLink}">Buy Now</a>
						</td>
						
						
					</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</html>
