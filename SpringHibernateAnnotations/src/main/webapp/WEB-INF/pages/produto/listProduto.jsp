<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

<title>nutrichecker</title>
</head>
<body>

	<c:import url="../cabecalho.jsp" />

	<div>
		<h1>Lista de Produtos</h1>
	</div>

	<form:label path="fornecedor">${fornecedor}</form:label>

	<c:if test="${!empty listaProduto}">
		<div class="table-responsive">
			<table class="table table-hover">
				<tr>
					<td>Código de Barra</td>
					<td>Descrição</td>
					<td>Edit</td>
					<td>Delete</td>
				</tr>
				<c:forEach items="${listaProduto}" var="produto">
					<tr>
						<td><c:out value="${produto.codigoBarra}" /></td>
						<td><c:out value="${produto.descricao}" /></td>
						<td><a href="editarProduto?id=${produto.id}">Edit</a></td>
						<td><a href="removerProduto?id=${produto.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</c:if>
	<br />

	<a href="inserirProduto">Novo produto</a>

	<c:import url="../rodape.jsp" />

</body>
</html>
