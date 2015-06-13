package br.com.unifor.pim.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
//@XmlRootElement
public class Usuario {

	@Id
	@GeneratedValue
	private Integer id;
	private String nome;
	private String email;
	private String senha;
	
	@ManyToOne
	@JoinTable(
	   name = "usuario_perfil",
	   joinColumns = @JoinColumn(name = "usuario_id"),
	   inverseJoinColumns = @JoinColumn(name = "perfil_id")			
	)
	
	private Perfil perfil;
	
	@XmlAttribute
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

}
