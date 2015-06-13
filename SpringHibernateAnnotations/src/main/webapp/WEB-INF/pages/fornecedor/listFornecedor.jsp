<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

	<div>Lista de Fornecedores</div>

	<c:if test="${!empty listaFornecedor}">
		<div class="table-responsive">
			<table class="table table-hover">
				<tr>
					<td>CNPJ</td>
					<td>Nome</td>

					<td>Produtos</td>
					<td>Edit</td>
					<td>Delete</td>
				</tr>
				<c:forEach items="${listaFornecedor}" var="fornecedor">
					<tr>
						<td><c:out value="${fornecedor.cnpj}" /></td>
						<td><c:out value="${fornecedor.nome}" /></td>

						<td><a href="consultarPorFornecedor?id=${fornecedor.id}">produtos</a></td>
						<td><a href="editarFornecedor?id=${fornecedor.id}">edit</a></td>
						<td><a href="removerFornecedor?id=${fornecedor.id}">delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</c:if>

	<br />
	<br />
	<a href="menu">Menu</a>

	<c:import url="../rodape.jsp" />

</body>
</html>
