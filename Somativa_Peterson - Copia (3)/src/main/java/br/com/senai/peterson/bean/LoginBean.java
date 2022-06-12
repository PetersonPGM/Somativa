package br.com.senai.peterson.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class LoginBean implements Serializable{//Método responavel pelo processo de login no site 
	private String nome; //Referenciação das variáveis utilizadas no login
	private String senha;

	public String doLogin() {//Método responsável pela esecução do login, caso as informações digitadas batam com o especificado, retorna outras partes
		if("abc".equals(nome) && "123".equals(senha)) {
			return "form";
		}
		return null;
	}
	
	public String getNome() { //Getters e setters das variáveis instanciadas
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
