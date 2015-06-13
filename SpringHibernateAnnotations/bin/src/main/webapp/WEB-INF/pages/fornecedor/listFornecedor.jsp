<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring</title>
</head>
<body>
	<center>

		<div style="color: teal; font-size: 30px">Lista de Fornecedores</div>

		<c:if test="${!empty listaFornecedor}">
			<table border="1" bgcolor="black" width="600px">
				<tr style="background-color: teal; color: white; text-align: center;" height="40px">
					<td>CNPJ</td>
					<td>Nome</td>					

					<td>Edit</td>
					<td>Delete</td>
				</tr>
				<c:forEach items="${listaFornecedor}" var="fornecedor">
					<tr style="background-color: white; color: black; text-align: center;" height="30px">
						<td><c:out value="${fornecedor.cnpj}" /></td>
						<td><c:out value="${fornecedor.nome}" /></td>
											
						<td><a href="editarFornecedor?id=${fornecedor.id}">Edit</a></td>
						<td><a href="removerFornecedor?id=${fornecedor.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>

		<br /><br />
		<!-- <a href="/spring/WEB-INF/pages/menu.jsp">Menu</a>
		<a href="inserirFornecedor">Novo fornecedor</a> -->
	</center>
</body>
</html>
