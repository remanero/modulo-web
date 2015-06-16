package br.com.unifor.pim.model.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.unifor.pim.model.entity.Usuario;

@Component
public class UsuarioDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public Usuario salvar(Usuario usuario) {
		Session session = sessionFactory.openSession();
		session.save(usuario);
		session.close();
		return usuario;
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> listarTodos() {
		Session session = sessionFactory.openSession();
		List<Usuario> usuarioList = session.createQuery("FROM Usuario").list();
		session.close();
		return usuarioList;
	}

	public Usuario buscarPorId(int id) {
		Session session = sessionFactory.openSession();
		Usuario usuario = (Usuario) session
				.createQuery("FROM Usuario WHERE id = :id")
				.setParameter("id", id).uniqueResult();
		session.close();
		return usuario;
	}

	public Usuario atualizar(Usuario usuario) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(usuario);
		tx.commit();
		session.close();
		return usuario;
	}

	@Transactional
	public void remover(int id) {
		Session session = sessionFactory.openSession();
		session.createQuery("DELETE FROM Usuario WHERE id = :id")
				.setParameter("id", id).executeUpdate();
		session.close();
	}

	public Usuario existeUsuario(Usuario usuario) {
		Session session = sessionFactory.openSession();
		Usuario user = (Usuario) session
				.createQuery("FROM Usuario WHERE nome = :nome AND senha = :senha")
				.setParameter("nome", usuario.getNome())
				.setParameter("senha", usuario.getSenha())
				.uniqueResult();
		session.close();
		
		return user;
	}

	public Boolean buscarLogin(String username, String password) {
		Session session = sessionFactory.openSession();
		Usuario user = (Usuario) session
				.createQuery("FROM Usuario WHERE nome = :nome AND senha = :senha")
				.setParameter("nome", username)
				.setParameter("senha", password)
				.uniqueResult();
		session.close();
		
		if(user != null)
			return true;
		else
			return false;
	}

	public Boolean buscarLoginPorEmail(String email, String password) {
		Session session = sessionFactory.openSession();
		Usuario user = (Usuario) session
				.createQuery("FROM Usuario WHERE email = :email AND senha = :senha")
				.setParameter("email", email)
				.setParameter("senha", password)
				.uniqueResult();
		session.close();
		
		if(user != null) {
			
			System.out.println("nome login : " + user.getNome());
			
			return true;
		}
		else
			return false;
	}

	public Usuario buscarUsuarioLogin(String username, String password) {
		Session session = sessionFactory.openSession();
		Usuario user = (Usuario) session
				.createQuery("FROM Usuario WHERE nome = :nome AND senha = :senha")
				.setParameter("nome", username)
				.setParameter("senha", password)
				.uniqueResult();
		session.close();
		
		return user;
	}
}
