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

		<div style="color: teal; font-size: 30px">Cadastro de Restrições</div>

		<form:form id="registerForm" modelAttribute="restricao" method="post" action="salvarRestricao">
		
			<form:input cssStyle="display:none" path="id" value="${restricao.id}" />
		
			<table width="400px" height="150px">
				<tr>
					<td><form:label path="descricao">Descrição</form:label></td>
					<td><form:input path="descricao" value="${restricao.descricao}" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Salvar" /></td>
				</tr>
			</table>
		</form:form>

		<a href="/spring/WEB-INF/pages/menu.jsp">Menu</a>
		<a href="listarRestricao">Listar Restrições</a>
	</center>
</body>
</html>
