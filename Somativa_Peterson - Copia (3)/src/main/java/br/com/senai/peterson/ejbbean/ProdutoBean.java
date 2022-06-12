package br.com.senai.peterson.ejbbean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.senai.peterson.model.Produto;

@Stateless
public class ProdutoBean implements Serializable{
	
	@PersistenceContext
	private EntityManager em;
	
	public List<Produto> listar() {
		return em.createQuery("SELECT produto FROM testedb.produto", Produto.class).getResultList();
	}

}
