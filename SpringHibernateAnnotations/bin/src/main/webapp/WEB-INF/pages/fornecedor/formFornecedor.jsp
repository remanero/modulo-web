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

		<div style="color: teal; font-size: 30px">Cadastro Nutrichecker</div>

		<form:form id="registerForm" modelAttribute="fornecedor" method="post" action="salvarFornecedor">
		
			<form:input cssStyle="display:none" path="id" value="${fornecedor.id}" />
			<form:input cssStyle="display:none" path="usuario.id" value="${fornecedor.usuario.id}" />
		
			<table width="400px" height="150px">
				<tr>
					<td><form:label path="cnpj">CNPJ</form:label></td>
					<td><form:input path="cnpj" value="${fornecedor.cnpj}" /></td>
				</tr>
				<tr>
					<td><form:label path="nome">Razão Social</form:label></td>
					<td><form:input path="nome" value="${fornecedor.nome}" /></td>
				</tr>
				<tr>
					<td><form:label path="usuario.email">Email</form:label></td>
					<td><form:input path="usuario.email" value="${fornecedor.usuario.email}"/></td>
				</tr>
				<tr>
					<td><form:label path="usuario.nome">Usuário</form:label></td>
					<td><form:input path="usuario.nome" value="${fornecedor.usuario.nome}" /></td>
				</tr>
				<tr>
					<td><form:label path="usuario.senha">Senha</form:label></td>
					<td><form:input path="usuario.senha" value="${fornecedor.usuario.senha}"/></td>
				</tr>				
				<tr>
					<td></td>
					<td><input type="submit" value="Salvar" /><a href="login">voltar ao login</a></td>
				</tr>
			</table>
		</form:form>
	</center>
</body>
</html>
