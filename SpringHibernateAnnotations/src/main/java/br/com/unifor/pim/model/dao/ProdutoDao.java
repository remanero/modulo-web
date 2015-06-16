package br.com.unifor.pim.model.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.unifor.pim.model.entity.Fornecedor;
import br.com.unifor.pim.model.entity.Produto;
import br.com.unifor.pim.model.entity.Restricao;

@Component
public class ProdutoDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Produto> listarTodos() {
		Session session = sessionFactory.openSession();
		List<Produto> produtoList = session.createQuery("FROM Produto").list();
		session.close();
		return produtoList;
	}

	public Produto buscarPorId(int id) {
		Session session = sessionFactory.openSession();
		Produto produto = (Produto) session
				.createQuery("FROM Produto WHERE id = :id")
				.setParameter("id", id).uniqueResult();

		// pq preciso fazer esta linha pra inicializar
		System.out.println("......qtd restricoes : "
				+ produto.getRestricoes().size());
		// for (Restricao restricao : produto.getRestricoes()) {
		// System.out.println("count produto por restricao : "+
		// restricao.getProdutos().size());
		// }

		session.close();
		return produto;
	}

	@Transactional
	public Produto salvar(Produto produto) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(produto);
		tx.commit();
		session.close();
		return produto;
	}

	public Produto atualizar(Produto produto) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(produto);
		tx.commit();
		session.close();
		return produto;
	}

	@Transactional
	public void remover(int id) {
		Session session = sessionFactory.openSession();
		session.createQuery("DELETE FROM Produto WHERE id = :id")
				.setParameter("id", id).executeUpdate();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Produto> listarPorFornecedor(Fornecedor fornecedor) {
		Session session = sessionFactory.openSession();
		List<Produto> produtoList = session
				.createQuery(
						"FROM Produto WHERE fornecedor_id = :fornecedor_id")
				.setParameter("fornecedor_id", fornecedor.getId()).list();
		session.close();

		return produtoList;
	}

	public Produto buscarPorCodigoBarra(Produto produto) {
		Session session = sessionFactory.openSession();
		Produto prod = (Produto) session
				.createQuery("FROM Produto WHERE codigoBarra = :codigoBarra")
				.setParameter("codigoBarra", produto.getCodigoBarra())
				.uniqueResult();

		// pq preciso fazer esta linha pra inicializar
				System.out.println("......qtd restricoes : "
						+ prod.getRestricoes().size());
		
		System.out.println("descricao do produto consultado: "
				+ prod.getDescricao());

		session.close();
		return prod;

	}

}
