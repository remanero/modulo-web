package br.com.unifor.pim.model.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.unifor.pim.model.entity.Perfil;

@Component
public class PerfilDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public Perfil salvar(Perfil perfil) {
		Session session = sessionFactory.openSession();
		session.save(perfil);
		session.close();
		return perfil;
	}

	@SuppressWarnings("unchecked")
	public List<Perfil> listarTodos() {
		Session session = sessionFactory.openSession();
		List<Perfil> perfilList = session.createQuery("FROM Perfil").list();
		session.close();
		return perfilList;
	}

	public Perfil buscarPorId(int id) {
		Session session = sessionFactory.openSession();
		Perfil perfil = (Perfil) session.createQuery("SELECT id as id, descricao as descricao FROM Perfil WHERE id = :id")
										   .setParameter("id", id)
										   .setResultTransformer(Transformers.aliasToBean(Perfil.class))
										   .uniqueResult();
		session.close();
		return perfil;
	}

	public Perfil atualizar(Perfil perfil) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(perfil);
		tx.commit();
		session.close();
		return perfil;
	}

	@Transactional
	public void remover(int id) {
		Session session = sessionFactory.openSession();
		session.createQuery("DELETE FROM Perfil WHERE id = :id")
			   .setParameter("id", id)
			   .executeUpdate();
		session.close();
	}

}
