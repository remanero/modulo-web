package br.com.unifor.pim.model.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.unifor.pim.model.entity.Restricao;

@Component
public class RestricaoDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public Restricao salvar(Restricao restricao) {
		Session session = sessionFactory.openSession();
		session.save(restricao);
		session.close();
		return restricao;
	}

	@SuppressWarnings("unchecked")
	public List<Restricao> listarTodos() {
		Session session = sessionFactory.openSession();
		List<Restricao> restricaoList = session.createQuery("FROM Restricao").list();
		session.close();
		return restricaoList;
	}

	public Restricao buscarPorId(int id) {
		Session session = sessionFactory.openSession();
		Restricao restricao = (Restricao) session.createQuery("SELECT id as id, descricao as descricao FROM Restricao WHERE id = :id")
										   .setParameter("id", id)
										   .setResultTransformer(Transformers.aliasToBean(Restricao.class))
										   .uniqueResult();
		session.close();
		return restricao;
	}

	public Restricao atualizar(Restricao restricao) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(restricao);
		tx.commit();
		session.close();
		return restricao;
	}

	@Transactional
	public void remover(int id) {
		Session session = sessionFactory.openSession();
		session.createQuery("DELETE FROM Restricao WHERE id = :id")
			   .setParameter("id", id)
			   .executeUpdate();
		session.close();
	}

}
