package br.com.unifor.pim.model.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "fornecedores")
public class ListaFornecedor {
	
	private List<Fornecedor> fornecedores;
	
	public ListaFornecedor() {
		super();
	}

	public ListaFornecedor(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	@XmlElementRef
	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setForncedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}
	
}
