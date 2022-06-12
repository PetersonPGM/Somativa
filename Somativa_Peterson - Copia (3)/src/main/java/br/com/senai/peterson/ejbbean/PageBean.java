package br.com.senai.peterson.ejbbean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.senai.peterson.model.Despesa;
import br.com.senai.peterson.model.Produto;;

@Stateless//Anotação que faz com que a classe realize operações independentes
public class PageBean implements Serializable{/*Classe responsável pelo gerenciamento de informações no banco de dados, 
o método serializable serve para habilitar que a classe possa ter seu estado persistido pela api padrão do java*/

	@PersistenceContext//Anotação que serve de armazenamento dos objetos gerenciados pela entidade gerenciadora
	private EntityManager em;//Instanciação da entidade gerenciadora que atuará controlando as ações no banco de dados
	
	public List<Produto> listar() {//Método responsável pela listagem dos dados salvo no banco de dados
		return em.createQuery("SELECT produto FROM testedb.produto", Produto.class).getResultList();
	}
	
	public void inserir(Integer[] produtosIds) throws Exception{//Método responsável pela inserção de dados no banco de dados
		Produto produto = em.find(Produto.class, produtosIds);
		
		em.persist(produto);
	}
	
	public void atualizar(Despesa despesa) {//Método responsável pela atualização do banco de dados e exibição da versão mais recente
		em.merge(despesa);
	}
	
	public void excluir(Integer id) {//Método responsável pela exclusão de dados presentes no banco de dados
		Produto produto = em.find(Produto.class, id);
		em.remove(produto);
	}
}