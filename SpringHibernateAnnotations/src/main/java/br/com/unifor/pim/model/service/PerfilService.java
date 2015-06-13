package br.com.unifor.pim.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unifor.pim.model.dao.PerfilDao;
import br.com.unifor.pim.model.entity.Perfil;

@Service
public class PerfilService {
	
	@Autowired
	private PerfilDao perfilDao;

	public Perfil salvar(Perfil perfil) {
		if(perfil.getId() == null){
			return perfilDao.salvar(perfil);
		}else{
			return perfilDao.atualizar(perfil);
		}
	}

	public List<Perfil> listarTodos() {
		return perfilDao.listarTodos();
	}

	public Perfil buscarPorId(int id) {
		return perfilDao.buscarPorId(id);
	}

	public void remover(int id) {
		perfilDao.remover(id);
	}
}
