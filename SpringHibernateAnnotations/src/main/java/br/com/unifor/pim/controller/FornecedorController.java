package br.com.unifor.pim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.unifor.pim.model.entity.Fornecedor;
import br.com.unifor.pim.model.service.FornecedorService;
import br.com.unifor.pim.model.service.ProdutoService;

@Controller
public class FornecedorController {

	@Autowired
	private FornecedorService fornecedorService;
	@Autowired
	private ProdutoService produtoService;

	@RequestMapping("inserirFornecedor")
	public ModelAndView formUsuario() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("fornecedor/formFornecedor");
		mav.addObject("fornecedor", new Fornecedor());
		//mav.addObject("listaProduto",produtoService.listarTodos());
		return mav;
	}

	@RequestMapping("salvarFornecedor")
	public ModelAndView salvarFornecedor(@ModelAttribute Fornecedor fornecedor) {
		fornecedorService.salvar(fornecedor);
		return new ModelAndView("redirect:login");
	}

	@RequestMapping("listarFornecedor")
	public ModelAndView listarFornecedor() {
		List<Fornecedor> listaFornecedor = fornecedorService.listarTodos();
		return new ModelAndView("fornecedor/listFornecedor", "listaFornecedor", listaFornecedor);
	}

	@RequestMapping("removerFornecedor")
	public ModelAndView removerFornecedor(@RequestParam int id) {
		fornecedorService.remover(id);
		return new ModelAndView("redirect:listarFornecedor");
	}

	@RequestMapping("editarFornecedor")
	public ModelAndView editarFornecedor(@RequestParam int id) {		
		Fornecedor fornecedor = fornecedorService.buscarPorId(id);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("fornecedor/formFornecedor");
		mav.addObject("fornecedor", fornecedor);
		mav.addObject("listaProduto",produtoService.listarTodos());
		return mav;
	}

}
