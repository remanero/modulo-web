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

		<div style="color: teal; font-size: 30px">Cadastro de Usuário</div>

		<form:form id="registerForm" modelAttribute="usuario" method="post" action="salvarUsuario">
		
			<form:input cssStyle="display:none" path="id" value="${usuario.id}" />
		
			<table width="400px" height="150px">
				<tr>
					<td><form:label path="nome">Nome</form:label></td>
					<td><form:input path="nome" value="${usuario.nome}" /></td>
				</tr>
				<tr>
					<td><form:label path="email">Email</form:label></td>
					<td><form:input path="email" value="${usuario.email}"/></td>
				</tr>
				<tr>
					<td><form:label path="perfil">Perfil</form:label></td>
					<td>
						<form:select path="perfil.id" items="${listaPerfil}" itemValue="id" itemLabel="descricao" >
						</form:select>
					
						<%-- <form:select path="perfil.id">
            				<form:option  value="perfil" label="--Por favor selecione"/>
            				<form:options path="perfil.id"  items="${listaPerfil}" itemValue="id" itemLabel="descricao"/>
        				</form:select> --%>
        				

<%--         				<form:select path="perfil.id">
        					<c:forEach items="${listaPerfil}" var="item">
        						<c:choose>
        							<c:when test="${item.id eq usuario.perfil.id}">
        								<option value="${item.id}" selected >${usuario.perfil.id} 1- ${item.id} - ${item.descricao}</option>
        							</c:when>
        							<c:otherwise>
        								<option value="${item.id}">${usuario.perfil.id} 2- ${item.id} - ${item.descricao}</option>
        							</c:otherwise>
        						</c:choose>
        					</c:forEach>
        				</form:select>
 --%>						
					</td>
				</tr>
				<tr>
					<td><form:label path="senha">Senha</form:label></td>
					<td><form:input path="senha" value="${usuario.senha}"/></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Salvar" /></td>
				</tr>
			</table>
		</form:form>

		<a href="/spring/WEB-INF/pages/menu.jsp">Menu</a>
		<a href="listarUsuario">Listar Usuário</a>
	</center>
</body>
</html>
