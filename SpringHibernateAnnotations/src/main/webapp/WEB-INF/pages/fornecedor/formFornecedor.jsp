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
		<h1>Cadastro Nutrichecker</h1>
	</div>

	<form:form id="registerForm" modelAttribute="fornecedor" method="post"
		action="salvarFornecedor" class="form-horizontal">

		<form:input cssStyle="display:none" path="id" value="${fornecedor.id}" />
		<form:input cssStyle="display:none" path="usuario.id"
			value="${fornecedor.usuario.id}" />

		<div class="form-group">
			<form:label path="cnpj" class="col-sm-2 control-label">CNPJ</form:label>
			<div class="col-xs-5">
				<form:input path="cnpj" value="${fornecedor.cnpj}" class="form-control" />
			</div>
		</div>
		<div class="form-group">
			<form:label path="nome" class="col-sm-2 control-label">Razão Social</form:label>
			<div class="col-xs-5">
				<form:input path="nome" value="${fornecedor.nome}" class="form-control" />
			</div>
		</div>
		<div class="form-group">
			<form:label path="usuario.email" class="col-sm-2 control-label">Email</form:label>
			<div class="col-xs-5">
				<form:input path="usuario.email" value="${fornecedor.usuario.email}" class="form-control" />
			</div>
		</div>

		<div class="form-group">
			<form:label path="usuario.nome" class="col-sm-2 control-label">Usuário</form:label>
			<div class="col-xs-5">
				<form:input path="usuario.nome" value="${fornecedor.usuario.nome}" class="form-control" />
			</div>
		</div>
		<div class="form-group">
			<form:label path="usuario.senha" class="col-sm-2 control-label">Senha</form:label>
			<div class="col-xs-5">
				<form:input path="usuario.senha" value="${fornecedor.usuario.senha}" class="form-control" />
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-xs-5">
				<input type="submit" value="Salvar" /><a href="login">voltar ao
					login</a>
			</div>
		</div>
	</form:form>

	<c:import url="../rodape.jsp" />

</body>
</html>
