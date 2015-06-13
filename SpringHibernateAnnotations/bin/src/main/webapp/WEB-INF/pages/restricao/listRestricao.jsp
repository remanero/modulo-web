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

		<div style="color: teal; font-size: 30px">Lista de Restrições</div>

		<c:if test="${!empty listaRestricao}">
			<table border="1" bgcolor="black" width="600px">
				<tr style="background-color: teal; color: white; text-align: center;" height="40px">
					<td>Descrição</td>
					<td>Edit</td>
					<td>Delete</td>
				</tr>
				<c:forEach items="${listaRestricao}" var="restricao">
					<tr style="background-color: white; color: black; text-align: center;" height="30px">
						<td><c:out value="${restricao.descricao}" /></td>
						<td><a href="editarProduto?id=${restricao.id}">Edit</a></td>
						<td><a href="removerProduto?id=${restricao.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>

		<br /><br />
		<a href="/spring/WEB-INF/pages/menu.jsp">Menu</a>
		<a href="inserirRestricao">Nova restrição</a>
	</center>
</body>
</html>
