package br.com.senai.peterson.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity/*Anotação utilizada para informar que uma classe também é uma entidade.
Assim estabelecendo a ligação entre a entidade e uma tabela de mesmo nome no banco de dados.*/
public class Despesa implements Serializable {

	@Id//Anotação utilizada para informar ao JPA qual campo/atributo de uma entidade estará relacionado à chave primária da respectiva tabela no banco de dados.
	@GeneratedValue//Anotação utilizada para informar que a geração do valor do identificador único da entidade será gerenciada pelo provedor de persistência. 
	private Integer idDesp;
	private String data;
	private String descricao;
	private Double valorTotal;
	private Boolean edit;
	private Produto Produto;
	
	public Integer getIdDesp() {
		return idDesp;
	}
	public void setIdDesp(Integer idDesp) {
		this.idDesp = idDesp;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Boolean getEdit() {
		return edit;
	}
	public void setEdit(Boolean edit) {
		this.edit = edit;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public Produto getProduto() {
		return Produto;
	}
	public void setProduto(Produto produto) {
		Produto = produto;
	}
	
}