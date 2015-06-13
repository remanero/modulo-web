package br.com.unifor.pim.model.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "perfis")
public class ListaPerfil {
	
	private List<Perfil> perfis;
	
	public ListaPerfil() {
		super();
	}

	public ListaPerfil(List<Perfil> perfis) {
		this.perfis = perfis;
	}

	@XmlElementRef
	public List<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}	
}
