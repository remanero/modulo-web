package br.com.unifor.pim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.unifor.pim.model.entity.Produto;
import br.com.unifor.pim.model.service.ProdutoService;

@RestController
@RequestMapping("/service/produto")
public class ProdutoControllerRest {

	@Autowired
	ProdutoService produtoService;

	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	// public ListaProduto listarProduto(){
	public List<Produto> listarProduto() {

		List<Produto> produtos = produtoService.listarTodos();

		// ListaProduto listaProduto = new ListaProduto(produtos);

		return produtos;

	}

	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Produto UsuarioById(@PathVariable int id) {

		Produto produto = produtoService.buscarPorIdRest(id);

		return produto;

	}

}
