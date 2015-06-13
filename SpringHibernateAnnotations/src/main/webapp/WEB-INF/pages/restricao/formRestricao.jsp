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
		<h1>Cadastro de Restrições</h1>
	</div>

	<form:form id="registerForm" modelAttribute="restricao" method="post"
		action="salvarRestricao" class="form-horizontal">

		<form:input cssStyle="display:none" path="id" value="${restricao.id}" />

		<div class="form-group">
			<form:label path="descricao" class="col-sm-2 control-label">Descrição</form:label>
			<div class="col-xs-5">
				<form:input path="descricao" value="${restricao.descricao}"
					class="form-control" />
			</div>
		</div>
		<div class="form-group">
			<!-- <div class="col-sm-offset-2 col-sm-10"> -->
			<div class="col-sm-offset-2 col-xs-5">
				<input type="submit" value="Salvar" />
			</div>
		</div>
	</form:form>

	<a href="menu">Menu</a>
	<a href="listarRestricao">Listar Restrições</a>

	<c:import url="../rodape.jsp" />

</body>
</html>
