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

		<div style="color: teal; font-size: 30px">Cadastro de Produto</div>

		<form:form id="registerForm" modelAttribute="produto" method="post" action="salvarProduto">
		
			<form:input cssStyle="display:none" path="id" value="${produto.id}" />
			<form:input cssStyle="display:none" path="fornecedor.id" value="${fornecedor.id}" />
					
			<table width="400px" height="150px">
				<tr>
					<td><form:label path="descricao">Descrição</form:label></td>
					<td><form:input path="descricao" value="${produto.descricao}" /></td>
				</tr>
				<tr>
					<td><form:label path="codigoBarra">Código de Barras</form:label></td>
					<td><form:input path="codigoBarra" value="${produto.codigoBarra}" /></td>
				</tr>
				<tr>
					<td><form:label path="restricao">Restrição</form:label></td>
					<td>
						<form:select path="restricao.id" items="${listaRestricao}" itemValue="id" itemLabel="descricao" >
						</form:select>
					</td>
				</tr>
				<%-- <tr>
					<td><form:label path="fornecedor">Fornecedor</form:label></td>
					<td>
						<form:select path="fornecedor.id" items="${listaFornecedor}" itemValue="id" itemLabel="nome" >
						</form:select>
					</td>
				</tr> --%>
				<tr>
					<td></td>
					<td><input type="submit" value="Salvar" /></td>
				</tr>
			</table>
		</form:form>

		<!-- <a href="/spring/WEB-INF/pages/menu.jsp">Menu</a> -->
		<a href="listarProduto">Listar Produtos</a>
	</center>
</body>
</html>
