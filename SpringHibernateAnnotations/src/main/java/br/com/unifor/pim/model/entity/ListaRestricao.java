package br.com.unifor.pim.model.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "restricoes")
public class ListaRestricao {
	
	private List<Restricao> restricoes;
	
	public ListaRestricao() {
		super();
	}

	public ListaRestricao(List<Restricao> restricoes) {
		this.restricoes = restricoes;
	}

	@XmlElementRef
	public List<Restricao> getRestricoes() {
		return restricoes;
	}

	public void setRestricoes(List<Restricao> restricoes) {
		this.restricoes = restricoes;
	}	
}
