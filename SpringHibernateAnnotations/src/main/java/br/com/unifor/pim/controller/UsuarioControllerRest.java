package br.com.unifor.pim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.unifor.pim.model.entity.Perfil;
import br.com.unifor.pim.model.entity.Usuario;
import br.com.unifor.pim.model.service.PerfilService;
import br.com.unifor.pim.model.service.UsuarioService;

@RestController
@RequestMapping("/service/usuario")
public class UsuarioControllerRest {

	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	PerfilService perfilService;

	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	// public @ResponseBody ListaUsuario listarUsuario(){
	public @ResponseBody
	List<Usuario> listarUsuario() {

		List<Usuario> usuarios = usuarioService.listarTodos();
		// ListaUsuario listaUsuario = new ListaUsuario(usuarios);
		// return listaUsuario;
		return (List<Usuario>) usuarios;
	}

	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Usuario UsuarioById(@PathVariable int id) {
		Usuario usuario = usuarioService.buscarPorId(id);
		return usuario;
	}

	@RequestMapping(value = "/doLoginOld", method = RequestMethod.POST, headers={"Content-type=application/json"})
	public @ResponseBody Boolean doLoginOld(@RequestParam String username,
			@RequestParam String password) {
		return usuarioService.buscarLogin(username, password);
	}
	
	@RequestMapping(value = "/doLogin", method = RequestMethod.POST, headers={"Content-type=application/json"})
	public @ResponseBody
	Usuario doLogin(@RequestParam String username,
			@RequestParam String password) {
		return usuarioService.buscarUsuarioLogin(username, password);
	}
	
	@RequestMapping(value = "/doLoginEmail", method = RequestMethod.POST, headers={"Content-type=application/json"})
	public @ResponseBody Usuario doLoginEmail(@RequestBody Usuario usuario) {
		//return usuarioService.buscarLoginPorEmail(usuario.getNome(), usuario.getSenha());
		
		return usuarioService.buscarUsuarioLogin(usuario.getNome(), usuario.getSenha());
	}
	
	
	@RequestMapping(value = "/registerLogin", method = RequestMethod.POST, headers={"Content-type=application/json"})
	public @ResponseBody Boolean registerLogin(@RequestBody Usuario usuario) {

		System.out.println(usuario.getNome());
		System.out.println(usuario.getEmail());
		
		Perfil perfil = new Perfil();
		perfil = perfilService.buscarPorId(3);
		usuario.setPerfil(perfil);
		
		if( usuarioService.criarUsuarioConsumidor(usuario) != null) {
			return true;
		} else {
			return false;
		}

	}
}
