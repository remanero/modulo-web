package br.com.unifor.pim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.unifor.pim.model.entity.Restricao;
import br.com.unifor.pim.model.service.RestricaoService;

@Controller
public class RestricaoController {
	
	@Autowired
	private RestricaoService restricaoService;

	@RequestMapping("inserirRestricao")
	public ModelAndView formRestricao() {
		return new ModelAndView("restricao/formRestricao", "restricao", new Restricao());
	}
	
	@RequestMapping("salvarRestricao")
	public ModelAndView salvarRestricao(@ModelAttribute Restricao restricao) {
		restricaoService.salvar(restricao);
		return new ModelAndView("redirect:listarRestricao");
	}
	
	@RequestMapping("listarRestricao")
	public ModelAndView listarRestricao() {
		List<Restricao> listaRestricao = restricaoService.listarTodos();
		return new ModelAndView("restricao/listRestricao", "listaRestricao", listaRestricao);
	}
	
	@RequestMapping("removerRestricao")
	public ModelAndView removerRestricao(@RequestParam int id) {
		restricaoService.remover(id);
		return new ModelAndView("redirect:listarRestricao");
	}
	
	@RequestMapping("editarRestricao")
	public ModelAndView editarRestricao(@RequestParam int id) {
		Restricao restricao = restricaoService.buscarPorId(id);
		return new ModelAndView("restricao/formRestricao", "restricao", restricao);
	}	
}
