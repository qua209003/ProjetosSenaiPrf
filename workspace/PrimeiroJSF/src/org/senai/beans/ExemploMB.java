package org.senai.beans;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class ExemploMB {

	private String mensagem = "Texto que será visto no index";
	private String texto = "";
	
	public void botao(){
		System.out.println(texto);
	}
	
	public String getMensagem() {
		return mensagem;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
}
