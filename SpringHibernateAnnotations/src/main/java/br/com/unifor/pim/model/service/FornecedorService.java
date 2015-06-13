package br.com.unifor.pim.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unifor.pim.model.dao.FornecedorDao;
import br.com.unifor.pim.model.dao.PerfilDao;
import br.com.unifor.pim.model.entity.Fornecedor;
import br.com.unifor.pim.model.entity.Perfil;
import br.com.unifor.pim.model.entity.Usuario;

@Service
public class FornecedorService {
	
	@Autowired
	private FornecedorDao fornecedorDao;
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private PerfilDao perfilDao;
	
	public Fornecedor salvar(Fornecedor fornecedor) {
		
		System.out.println("id do usuario :::: " + fornecedor.getUsuario().getId());
		//criar perfil fornecedor
		Perfil perfil = new Perfil();
		perfil = perfilDao.buscarPorId(2);
		fornecedor.getUsuario().setPerfil(perfil);
		System.out.println("id do usuario :::: " + fornecedor.getUsuario().getId());
		usuarioService.salvar(fornecedor.getUsuario());
		
		if(fornecedor.getId() == null){
			return fornecedorDao.salvar(fornecedor);
		}else{
			return fornecedorDao.atualizar(fornecedor);
		}
	}

	public List<Fornecedor> listarTodos() {
		return fornecedorDao.listarTodos();
	}
		
	public Fornecedor buscarPorId(int id) {
		return fornecedorDao.buscarPorId(id);
	}

	public void remover(int id) {
		fornecedorDao.remover(id);
	}
	
	public Fornecedor buscarPorUsuario(Usuario usuario) {
		return fornecedorDao.buscarPorUsuario(usuario);
	}

}
