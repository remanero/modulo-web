package br.com.unifor.pim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.unifor.pim.model.entity.Produto;
import br.com.unifor.pim.model.entity.Restricao;
import br.com.unifor.pim.model.entity.Usuario;
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
		produto.setLiberado(true);

		return produto;

	}
	
	@RequestMapping(value = "/consultaProduto", method = RequestMethod.POST, headers={"Content-type=application/json"})
	public @ResponseBody Produto consultaProduto(@RequestBody Produto produto) {
		
		//por enquanto estatico verificar a restricao id = 1 lactose
		int restricaoId = 1;
		boolean liberado = true;
		
		Produto returnedProduto = produtoService.buscarPorCodigoBarra(produto);
		
		for (Restricao r : returnedProduto.getRestricoes()) {
			if(r.getId().equals(1))
				liberado = false;
		}
		
		returnedProduto.setLiberado(liberado);
		
		return returnedProduto;
		//return produtoService.buscarPorCodigoBarra(produto);

	}

}
