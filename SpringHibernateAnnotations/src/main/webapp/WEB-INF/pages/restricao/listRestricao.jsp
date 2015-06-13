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

	<div>Lista de Restrições</div>

	<c:if test="${!empty listaRestricao}">
		<div class="table-responsive">
			<table class="table table-hover">
				<tr>
					<td>Descrição</td>
					<td>Edit</td>
					<td>Delete</td>
				</tr>
				<c:forEach items="${listaRestricao}" var="restricao">
					<tr>
						<td><c:out value="${restricao.descricao}" /></td>
						<td><a href="editarProduto?id=${restricao.id}">Edit</a></td>
						<td><a href="removerProduto?id=${restricao.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</c:if>

	<br />
	<br />
	<a href="menu">Menu</a>
	<a href="inserirRestricao">Nova restrição</a>

	<c:import url="../rodape.jsp" />

</body>
</html>
