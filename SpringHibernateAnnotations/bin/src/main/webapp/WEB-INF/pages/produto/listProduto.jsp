<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring</title>
</head>
<body>
	<center>

		<div style="color: teal; font-size: 30px">Lista de Produtos</div>
		
		<form:label path="fornecedor">${fornecedor}</form:label>

		<c:if test="${!empty listaProduto}">
			<table border="1" bgcolor="black" width="600px">
				<tr style="background-color: teal; color: white; text-align: center;" height="40px">
					<td>Código de Barra</td>
					<td>Descrição</td>
					<!-- <td>Fornecedor</td> -->
					<td>Edit</td>
					<td>Delete</td>
				</tr>
				<c:forEach items="${listaProduto}" var="produto">
					<tr style="background-color: white; color: black; text-align: center;" height="30px">
						<td><c:out value="${produto.codigoBarra}" /></td>
						<td><c:out value="${produto.descricao}" /></td>
						<%-- <td><c:out value="${produto.fornecedor.nome}" /></td> --%>
						<td><a href="editarProduto?id=${produto.id}">Edit</a></td>
						<td><a href="removerProduto?id=${produto.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>

		<br /><br />
		<!-- <a href="/spring/WEB-INF/pages/menu.jsp">Menu</a> -->
		<a href="inserirProduto">Novo produto</a>
	</center>
</body>
</html>
