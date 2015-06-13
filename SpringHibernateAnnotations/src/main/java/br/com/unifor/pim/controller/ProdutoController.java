package br.com.unifor.pim.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.unifor.pim.model.entity.Fornecedor;
import br.com.unifor.pim.model.entity.Produto;
import br.com.unifor.pim.model.service.FornecedorService;
import br.com.unifor.pim.model.service.ProdutoService;
import br.com.unifor.pim.model.service.RestricaoService;

@Controller
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private RestricaoService restricaoService;
	@Autowired
	private FornecedorService fornecedorService;

	@RequestMapping("inserirProduto")
	@ModelAttribute("fornecedor")
	public ModelAndView formProduto(Fornecedor fornecedor, HttpServletRequest httpServletRequest) {

		ModelAndView mav = new ModelAndView();
		
		Fornecedor fornecedor2 = (Fornecedor) httpServletRequest.getSession().getAttribute("fornecedorLogado");		
		Produto produto = new Produto();
		produto.setFornecedor(fornecedor2);

		mav.setViewName("produto/formProduto");
		mav.addObject("produto", produto);
		mav.addObject("listaRestricao", restricaoService.listarTodos());

		return mav;
	}

	@RequestMapping("salvarProduto")
	public ModelAndView salvarProduto(@ModelAttribute Produto produto,
			HttpServletRequest httpServletRequest) {

		Fornecedor fornecedor = (Fornecedor) httpServletRequest.getSession().getAttribute("fornecedorLogado");

		produto.setFornecedor(fornecedor);
		produtoService.salvar(produto);

		return new ModelAndView("redirect:listarProdutoNovo");
		
	}

	@RequestMapping("listarProduto")
	public ModelAndView listarProduto() {
		List<Produto> listaProduto = produtoService.listarTodos();
		return new ModelAndView("produto/listProduto", "listaProduto", listaProduto);
	}

	@RequestMapping("listarProdutoNovo")
	public ModelAndView listarProdutoNovo(HttpServletRequest httpServletRequest) {

		Fornecedor fornecedor = (Fornecedor) httpServletRequest.getSession().getAttribute("fornecedorLogado");
		List<Produto> listaProduto = produtoService.listarPorFornecedor(fornecedor);
		ModelAndView mav = new ModelAndView();
		mav.addObject("fornecedor", fornecedor);
		mav.setViewName("produto/listProduto");
		mav.addObject("listaProduto", listaProduto);

		return mav;
	}

	@RequestMapping("listarProdutoGeral")
	public ModelAndView listarProdutoGeral() {
		List<Produto> listaProduto = produtoService.listarTodos();
		return new ModelAndView("produto/listProdutoGeral", "listaProduto", listaProduto);
	}
	
	@RequestMapping("removerProduto")
	public ModelAndView removerProduto(@RequestParam int id) {
		
		produtoService.remover(id);
		return new ModelAndView("redirect:listarProdutoNovo");
		
	}

	@RequestMapping("editarProduto")
	public ModelAndView editarProduto(@RequestParam int id) {
		
		Produto produto = produtoService.buscarPorId(id);
		Fornecedor fornecedor = produto.getFornecedor();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("produto/formProduto");
		mav.addObject("listaRestricao", restricaoService.listarTodos());
		mav.addObject("produto", produto);		
		mav.addObject("fornecedor", fornecedor);

		return mav;
	}
	
	@RequestMapping("consultarPorFornecedor")
	public ModelAndView consultarPorFornecedor(@RequestParam int id, HttpServletRequest httpServletRequest) {		
		Fornecedor fornecedor = fornecedorService.buscarPorId(id);
		
		httpServletRequest.getSession().putValue("fornecedorLogado", fornecedor);
		
		List<Produto> listaProduto = produtoService.listarPorFornecedor(fornecedor);
		ModelAndView mav = new ModelAndView();
		mav.addObject("fornecedor", fornecedor);
		mav.setViewName("produto/listProduto");
		mav.addObject("listaProduto", listaProduto);
		
		return mav;
	}

}
