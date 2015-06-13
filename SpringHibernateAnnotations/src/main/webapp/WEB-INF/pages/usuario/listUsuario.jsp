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

	<div>Lista de Usuários</div>

	<c:if test="${!empty listaUsuario}">
		<div class="table-responsive">
			<table class="table table-hover">
				<tr>
					<td>Nome</td>
					<td>Email</td>
					<td>Senha</td>
					<td>Perfil</td>
					<td>Edit</td>
					<td>Delete</td>
				</tr>
				<c:forEach items="${listaUsuario}" var="usuario">
					<tr>
						<td><c:out value="${usuario.nome}" /></td>
						<td><c:out value="${usuario.email}" /></td>
						<td><c:out value="${usuario.senha}" /></td>
						<td><c:out value="${usuario.perfil.descricao}" /></td>

						<td><a href="editarUsuario?id=${usuario.id}">Edit</a></td>
						<td><a href="removerUsuario?id=${usuario.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</c:if>

	<br />
	<br />
	<!-- 		<a href="/spring/WEB-INF/pages/menu.jsp">Menu</a> -->
	<!-- 		<a href="inserirUsuario">Novo usuário</a> -->
	<a href="menu">Menu</a>

	<c:import url="../rodape.jsp" />

</body>
</html>
