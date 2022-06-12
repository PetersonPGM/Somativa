package br.com.senai.peterson.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.senai.peterson.ejbbean.PageBean;
import br.com.senai.peterson.model.Produto;

@Named
@RequestScoped
public class ListProdutoBean implements Serializable{//Classe responsávelpor listar os produtos 
	@EJB
	private PageBean pageBean;
	
	private List<Produto> produto;
	
	@PostConstruct
	public void init() {//Método responsável por inicializar o processo de listagem e busca
		produto = pageBean.listar();
	}

	public List<Produto> getProduto() {
		return produto;
	}
	
	public String excluir(Integer id) {
		pageBean.excluir(id);
		return "produto?faces-redirect=true";
	}

}
