package br.com.unifor.pim.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unifor.pim.model.dao.UsuarioDao;
import br.com.unifor.pim.model.entity.Usuario;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioDao usuarioDao;

	public Usuario salvar(Usuario usuario) {
		if(usuario.getId() == null){
			System.out.println("salvando usuario....");
			return usuarioDao.salvar(usuario);
		}else{
			System.out.println("ATUALIAZANDO usuario....");
			return usuarioDao.atualizar(usuario);
		}
	}

	public List<Usuario> listarTodos() {
		return usuarioDao.listarTodos();
	}

	public Usuario buscarPorId(int id) {
		return usuarioDao.buscarPorId(id);
	}

	public void remover(int id) {
		usuarioDao.remover(id);
	}
	
	public Usuario existeUsuario(Usuario usuario) {
		return usuarioDao.existeUsuario(usuario);
	}

	public Boolean buscarLogin(String username, String password) {
		return usuarioDao.buscarLogin(username,password);
	}

	public Usuario criarUsuarioConsumidor(Usuario usuario) {
		return usuarioDao.salvar(usuario);
	}

}
