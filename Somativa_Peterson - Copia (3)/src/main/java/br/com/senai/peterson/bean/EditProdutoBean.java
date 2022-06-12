package br.com.senai.peterson.bean; //Referenciação do pacote casa dessa classe

import java.io.Serializable; //Área de importação de classes e bibliotecas
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.senai.peterson.ejbbean.PageBean;
import br.com.senai.peterson.ejbbean.ProdutoBean;
import br.com.senai.peterson.model.Produto;

@Named //Essa anotação ajuda a especificar o tipo de conteúdo
@RequestScoped //Essa anotação cria uma nova instanciação a cada solicitação do html
public class EditProdutoBean implements Serializable{/*Classe responsável por cadastrar e mostrar as informações na tela,
essas informações são encontradas em um schema de banco de dados, possui a implementação serializable que faz com que converta um fluxo de dados e os grave*/
	@EJB//Anotação que referencia a classe do tipo EJB
	private PageBean pageBean;//Instanciação de uma classe EJB
	
	@EJB
	private ProdutoBean produtoBean;

	private List<Produto> produtos;//Instanciação de uma lista com os produtos 
	
	private Integer[] selectedProdutosIds;//Instanciação de um array para a seleção de produtos
	
	@PostConstruct//Anotação que faz com que um método execute após a inserção ou busca de informações
	public void init() {
		produtos = produtoBean.listar();
	}
	
	public String cadastrarProduto() throws Exception {//Classe responsável por inserir as informações selecionadas pelo usuário e as retornando 
		pageBean.inserir(selectedProdutosIds);	
		return "produto?faces-redirect=true";
	}
	
	public List<Produto> getProduto() {
		return produtos;
	}

	public Integer[] getSelectedProdutoIds() {
		return selectedProdutosIds;
	}

	public void setSelectedProdutosIds(Integer[] selectedProdutosIds) {
		this.selectedProdutosIds = selectedProdutosIds;
	}
}
