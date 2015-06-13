<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>nutrichecker</title>

<style>
.error {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}

.msg {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
}

#login-box {
	width: 300px;
	padding: 20px;
	margin: 100px auto;
	background: #fff;
	-webkit-border-radius: 2px;
	-moz-border-radius: 2px;
	border: 1px solid #000;
}
</style>


</head>
<body>


	<div id="login-box">

		<div style="color: teal; font-size: 30px">Nutrichecker</div>

		<form:form id="registerForm" modelAttribute="usuario" method="post"
			action="listarProdutos">

			<form:input cssStyle="display:none" path="id" value="${usuario.id}" />

			<table>
				<tr>
					<td><form:label path="nome">Usuário</form:label></td>
					<td><form:input path="nome" value="${usuario.nome}" /></td>
				</tr>
				<tr>
					<td><form:label path="senha">Senha</form:label></td>
					<td><form:input type="password" path="senha"
							value="${usuario.senha}" /></td>
				</tr>
				<tr>					
					<td colspan="2"><input type="submit" value="Acessar" /></td>
				</tr>
			</table>
		</form:form>
		<br/><a href="inserirFornecedor">Criar conta no Nutrichecker</a>
	</div>
</body>
</html>
