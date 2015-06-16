package br.com.unifor.pim.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAttribute;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
//@XmlRootElement
public class Produto {

	@Id
	@GeneratedValue
	private Integer id;

	private String descricao;
	private String codigoBarra;

	@Transient
	@JsonIgnore
	private String restricaoString;

	@Transient
	@JsonIgnore
	private List<Restricao> restricoesSelecionadas;

	//@ManyToOne
	@ManyToMany
	@JoinTable(name = "produto_restricao", joinColumns = @JoinColumn(name = "produto_id"), inverseJoinColumns = @JoinColumn(name = "restricao_id"))
	// private Restricao restricao;
	private List<Restricao> restricoes;

	@ManyToOne
	private Fornecedor fornecedor;
	
	@Transient
	private Boolean liberado;

	@XmlAttribute
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCodigoBarra() {
		return codigoBarra;
	}

	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<Restricao> getRestricoes() {
		return restricoes;
	}

	public void setRestricoes(List<Restricao> restricoes) {
		this.restricoes = restricoes;
	}

	public String getRestricaoString() {
		return restricaoString;
		// return montarRestricaoString();
	}

	public void setRestricaoString(String restricaoString) {
		this.restricaoString = restricaoString;
	}

	@JsonIgnore
	public List<Restricao> getListaRestricao() {
		List<Restricao> restricaoLista = new ArrayList<Restricao>();

		String[] split = this.restricaoString.split(",");

		for (String string : split) {
			Restricao restricao = new Restricao();
			restricao.setId(Integer.parseInt(string));
			restricaoLista.add(restricao);
		}

		return restricaoLista;
	}

	public String montarRestricaoString() {
		String strMontada = "";
		for (Restricao restricao : this.getRestricoes()) {
			if (strMontada.equals(""))
				strMontada = restricao.getId().toString();
			else
				strMontada += "," + restricao.getId().toString();
		}

		return strMontada;

		// String str = "";
		// for (Restricao restricao : lista) {
		// if (str.equals(""))
		// str = restricao.getId().toString();
		// else
		// str += "," + restricao.getId().toString();
		// }
		//
		// return str;
	}

	public List<Restricao> getRestricoesSelecionadas() {
		return restricoesSelecionadas;
	}

	public void setRestricoesSelecionadas(List<Restricao> restricoesSelecionadas) {
		this.restricoesSelecionadas = restricoesSelecionadas;
	}

	public List<Restricao> montarRestricoesSelecao() {
		List<Restricao> restricaoLista = new ArrayList<Restricao>();

		String[] split = this.restricaoString.split(",");

		for (String string : split) {
			Restricao restricao = new Restricao();
			restricao.setId(Integer.parseInt(string));
			restricaoLista.add(restricao);
		}

		return restricaoLista;
	}

	public Boolean getLiberado() {
		return liberado;
	}

	public void setLiberado(Boolean liberado) {
		this.liberado = liberado;
	}

	// public Restricao getRestricao() {
	// return restricao;
	// }
	//
	// public void setRestricao(Restricao restricao) {
	// this.restricao = restricao;
	// }

}
