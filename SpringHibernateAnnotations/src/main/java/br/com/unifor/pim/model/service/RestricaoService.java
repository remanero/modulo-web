package br.com.unifor.pim.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unifor.pim.model.dao.RestricaoDao;
import br.com.unifor.pim.model.entity.Restricao;

@Service
public class RestricaoService {
	
	@Autowired
	private RestricaoDao restricaoDao;

	public Restricao salvar(Restricao restricao) {
		if(restricao.getId() == null){
			return restricaoDao.salvar(restricao);
		}else{
			return restricaoDao.atualizar(restricao);
		}
	}

	public List<Restricao> listarTodos() {
		return restricaoDao.listarTodos();
	}

	public Restricao buscarPorId(int id) {
		return restricaoDao.buscarPorId(id);
	}

	public void remover(int id) {
		restricaoDao.remover(id);
	}
}