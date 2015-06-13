package br.com.unifor.pim.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import br.com.unifor.pim.model.entity.Fornecedor;
import br.com.unifor.pim.model.entity.Produto;
import br.com.unifor.pim.model.entity.Usuario;
import br.com.unifor.pim.model.service.FornecedorService;
import br.com.unifor.pim.model.service.ProdutoService;
import br.com.unifor.pim.model.service.UsuarioService;

@Controller
@SessionAttributes("fornecedor")
public class LoginController {

	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private FornecedorService fornecedorService;
	@Autowired
	private ProdutoService produtoService;

	@ModelAttribute("fornecedor")
	@RequestMapping(value = { "login", "" }, method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		mav.addObject("usuario", new Usuario());
		return mav;
	}

	@SuppressWarnings("deprecation")
	@RequestMapping(value = "listarProdutos", method = RequestMethod.POST)
	public ModelAndView efetuaLogin(@ModelAttribute Usuario usuario,
			HttpServletRequest httpServletRequest) {

		ModelAndView mav = new ModelAndView();
		Usuario usuarioLogado = usuarioService.existeUsuario(usuario);

		if (usuarioLogado != null) {

			Fornecedor fornecedor = fornecedorService
					.buscarPorUsuario(usuarioLogado);

			if (fornecedor != null) {

				List<Produto> listaProduto = produtoService
						.listarPorFornecedor(fornecedor);
				mav.addObject("listaProduto", listaProduto);

				httpServletRequest.getSession().putValue("fornecedorLogado",
						fornecedor);

				mav.setViewName("produto/listProduto");

				mav.addObject("fornecedor", fornecedor);

			}
			else {
				mav.setViewName("menu");
			}

		} else {
			mav.setViewName("login");
		}
		
		return mav;
	}

	@RequestMapping(value = "menu", method = RequestMethod.GET)
	public ModelAndView menu() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("menu");		
		return mav;
	}

}
