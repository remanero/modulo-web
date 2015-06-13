package br.com.unifor.pim.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unifor.pim.model.dao.ProdutoDao;
import br.com.unifor.pim.model.entity.Fornecedor;
import br.com.unifor.pim.model.entity.Produto;
import br.com.unifor.pim.model.entity.Restricao;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoDao produtoDao;

	public Produto salvar(Produto produto) {

		System.out.println("dentro do setRestricoesString : "
				+ produto.getRestricaoString());
		produto.setRestricoes(produto.getListaRestricao());
		
		if (produto.getId() == null) {
			return produtoDao.salvar(produto);
		} else {
			return produtoDao.atualizar(produto);
		}
	}

	public List<Produto> listarTodos() {
		return produtoDao.listarTodos();
	}

	public Produto buscarPorId(int id) {

		Produto produto = produtoDao.buscarPorId(id);
		produto.setRestricaoString(produto.montarRestricaoString());
		produto.setRestricoesSelecionadas(produto.montarRestricoesSelecao());

		return produto;

		// return produtoDao.buscarPorId(id);
	}

	public void remover(int id) {
		produtoDao.remover(id);
	}

	public List<Produto> listarPorFornecedor(Fornecedor fornecedor) {
		return produtoDao.listarPorFornecedor(fornecedor);
	}

	public Produto buscarPorIdRest(int id) {

		Produto produto = produtoDao.buscarPorId(id);
		System.out.println("count restricoes: "+produto.getRestricoes().size());
		
//		for (Restricao restricao : produto.getRestricoes()) {
//			System.out.println("count produtos restricao : "+restricao.getProdutos().size());
//		}
		
		return produto;

	}
}
