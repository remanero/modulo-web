package br.com.unifor.pim.model.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "produtos")
public class ListaProduto {
	
	private List<Produto> produtos;
	
	public ListaProduto() {
		super();
	}

	public ListaProduto(List<Produto> produtos) {
		this.produtos = produtos;
	}

	@XmlElementRef
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}	
}
