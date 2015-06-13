package br.com.unifor.pim.model.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "usuarios")
public class ListaUsuario {
	
	private List<Usuario> usuarios;
	
	public ListaUsuario() {
		super();
	}

	public ListaUsuario(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@XmlElementRef
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
}
