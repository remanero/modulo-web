<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<body>

<c:import url="cabecalho.jsp" />


<h2>Menu</h2>

<!-- <a href="inserirUsuario">Novo usuário</a><br/>
<a href="listarUsuario">Lista de Usuários</a><br/>
<a href="inserirProduto">Novo produto</a><br/>
<a href="listarProduto">Lista de Produtos</a><br/>
<a href="inserirRestricao">Nova restrição</a><br/>
<a href="listarRestricao">Lista de Restrições</a><br/>
<a href="inserirFornecedor">Novo fornecedor</a><br/>
<a href="listarFornecedor">Lista de Fornecedores</a><br/> -->

<a href="listarUsuario">Usuários</a><br/>
<a href="listarProdutoGeral">Produtos</a><br/>
<a href="listarRestricao">Restrições</a><br/>
<a href="listarFornecedor">Fornecedores</a><br/>
<a href="#">Configurações</a><br/>


<c:import url="rodape.jsp" />


</body>
</html>
