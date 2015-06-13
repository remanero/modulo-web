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
		<h1>Cadastro de Produto</h1>
	</div>

	<form:label path="fornecedor">${fornecedorLogado}</form:label>

	<form:form id="registerForm" modelAttribute="produto" method="post"
		action="salvarProduto" class="form-horizontal">

		<form:input cssStyle="display:none" path="id" value="${produto.id}" />
		<form:input cssStyle="display:none" path="fornecedor.id"
			value="${fornecedor.id}" />

		<div class="form-group">
			<form:label path="descricao" class="col-sm-2 control-label">Descrição</form:label>
			<!-- <div class="col-sm-10">  -->
			<div class="col-xs-5">
				<form:input path="descricao" value="${produto.descricao}"
					class="form-control" />
			</div>
		</div>
		<div class="form-group">
			<form:label path="codigoBarra" class="col-sm-2 control-label">Código de Barras</form:label>
			<!-- <div class="col-sm-10">  -->
			<div class="col-xs-5">
				<form:input path="codigoBarra" value="${produto.codigoBarra}"
					class="form-control" />
			</div>
		</div>
		<div class="form-group">
			<form:label path="restricoes" class="col-sm-2 control-label">Restrição</form:label>
			<!-- <div class="col-sm-10">  -->
			<div class="col-xs-5">
				<form:select path="restricaoString" multiple="multiple"
					class="form-control">
					<c:forEach items="${listaRestricao}" var="restricao">
						<c:forEach items="${produto.restricoesSelecionadas}"
							var="currentRestricao">
							<c:if test="${currentRestricao.id == restricao.id}">
								<c:set var="selected" value="true" />
							</c:if>
						</c:forEach>
						<option value="${restricao.id}"
							<c:if test="${selected}">selected="selected"</c:if>>
							${restricao.descricao}</option>
						<c:remove var="selected" />
					</c:forEach>
				</form:select>
			</div>
		</div>
		<div class="form-group">
			<!-- <div class="col-sm-offset-2 col-sm-10"> -->
			<div class="col-sm-offset-2 col-xs-5">
				<input type="submit" value="Salvar" class="btn btn-default" />
			</div>
		</div>
	</form:form>

	<a href="listarProdutoNovo">Listar Produtos</a>

	<c:import url="../rodape.jsp" />

</body>
</html>
