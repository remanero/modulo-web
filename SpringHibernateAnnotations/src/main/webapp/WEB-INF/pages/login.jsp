<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>nutrichecker</title>

<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

<style>
/* body {
	padding-top: 40px;
	padding-bottom: 40px;
	background-color: #eee;
} */

.form-signin {
	max-width: 330px;
	padding: 15px;
	margin: 0 auto;
}

.form-signin .form-signin-heading,.form-signin .checkbox {
	margin-bottom: 10px;
}

.form-signin .checkbox {
	font-weight: normal;
}

.form-signin .form-control {
	position: relative;
	height: auto;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
	padding: 10px;
	font-size: 16px;
}

.form-signin .form-control:focus {
	z-index: 2;
}

.form-signin input[type="email"] {
	margin-bottom: -1px;
	border-bottom-right-radius: 0;
	border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
	margin-bottom: 10px;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}
</style>


</head>
<body>

<c:import url="cabecalho.jsp" />

	<div class="container">

		<form:form id="registerForm" modelAttribute="usuario" method="post"
			action="listarProdutos" cssClass="form-signin">

			<!-- <h2 class="form-signin-heading">Nutrichecker</h2> -->

			<h3 class="form-signin-heading">Faça o login</h3>

			<form:input cssStyle="display:none" path="id" value="${usuario.id}" />

			<table>
				<tr>
					<td><form:label path="nome" cssClass="sr-only" title="Usuário" /></td>
					<td><form:input path="nome" value="${usuario.nome}"
							cssClass="form-control" placeholder="Usuário" autofocus="true" /></td>
				</tr>
				<tr>
					<td><form:label path="senha" cssClass="sr-only" title="Senha" /></td>
					<td><form:input type="password" path="senha"
							value="${usuario.senha}" cssClass="form-control"
							placeholder="Senha" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Acessar"
						class="btn btn-lg btn-primary btn-block" /></td>
				</tr>
				<tr>
					<td colspan="2"><a href="inserirFornecedor">Criar conta no
							Nutrichecker</a></td>
				</tr>
			</table>
		</form:form>
	</div>
	
	<c:import url="rodape.jsp" />
	
</body>
</html>
