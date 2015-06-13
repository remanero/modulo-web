package br.com.unifor.pim.model.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.unifor.pim.model.entity.Fornecedor;
import br.com.unifor.pim.model.entity.Usuario;

@Component
public class FornecedorDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public Fornecedor salvar(Fornecedor fornecedor) {
		Session session = sessionFactory.openSession();
		session.save(fornecedor);
		session.close();
		return fornecedor;
	}

	@SuppressWarnings("unchecked")
	public List<Fornecedor> listarTodos() {
		Session session = sessionFactory.openSession();
		List<Fornecedor> fornecedorList = session.createQuery("FROM Fornecedor ORDER BY nome").list();
		session.close();
		return fornecedorList;
	}

	public Fornecedor buscarPorId(int id) {
		Session session = sessionFactory.openSession();
	
		Fornecedor fornecedor = (Fornecedor)session.createQuery("FROM Fornecedor WHERE id = :id")
				.setParameter("id", id)
				.uniqueResult();
		
		session.close();		
		return fornecedor;
	}

	public Fornecedor atualizar(Fornecedor fornecedor) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(fornecedor);
		tx.commit();
		session.close();
		return fornecedor;
	}

	@Transactional
	public void remover(int id) {
		Session session = sessionFactory.openSession();
		session.createQuery("DELETE FROM Fornecedor WHERE id = :id")
			   .setParameter("id", id)
			   .executeUpdate();
		session.close();
	}

	public Fornecedor buscarPorUsuario(Usuario usuario) {
		Session session = sessionFactory.openSession();
	
		Fornecedor fornecedor = (Fornecedor)session.createQuery("FROM Fornecedor WHERE usuario.id = :usuario_id")
				.setParameter("usuario_id", usuario.getId())
				.uniqueResult();
		
		session.close();		
		return fornecedor;
	}

}
