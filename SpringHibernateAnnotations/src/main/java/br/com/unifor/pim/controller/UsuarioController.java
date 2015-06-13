package br.com.unifor.pim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.unifor.pim.model.entity.Usuario;
import br.com.unifor.pim.model.service.PerfilService;
import br.com.unifor.pim.model.service.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private PerfilService perfilService;

	@RequestMapping("inserirUsuario")
	public ModelAndView formUsuario() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("usuario/formUsuario");
		mav.addObject("usuario", new Usuario());
		mav.addObject("listaPerfil",perfilService.listarTodos());
		return mav;
	}

	@RequestMapping("salvarUsuario")
	public ModelAndView salvarUsuario(@ModelAttribute Usuario usuario) {
		usuarioService.salvar(usuario);
		return new ModelAndView("redirect:listarUsuario");
	}

	@RequestMapping("listarUsuario")
	public ModelAndView listarUsuario() {
		List<Usuario> listaUsuario = usuarioService.listarTodos();
		return new ModelAndView("usuario/listUsuario", "listaUsuario", listaUsuario);
	}

	@RequestMapping("removerUsuario")
	public ModelAndView removerUsuario(@RequestParam int id) {
		usuarioService.remover(id);
		return new ModelAndView("redirect:listarUsuario");
	}

	@RequestMapping("editarUsuario")
	public ModelAndView editarUsuario(@RequestParam int id) {		
		Usuario usuario = usuarioService.buscarPorId(id);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("usuario/formUsuario");
		mav.addObject("usuario", usuario);
		mav.addObject("listaPerfil",perfilService.listarTodos());
		return mav;
	}
}
