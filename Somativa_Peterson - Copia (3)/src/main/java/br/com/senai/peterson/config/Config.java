package br.com.senai.peterson.config;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.annotation.FacesConfig.Version;

@FacesConfig(version = Version.JSF_2_3)//Anotação que instancia qual versão do JSF o projeto deverá rodar
@ApplicationScoped//Anotação que faz com que essa classe seja executada sempre que o servidor rode
public class Config { //Força o projeto a executar na versão 2.3 do JSF

}
