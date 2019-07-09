package org.senai.exemplojsf.managedbean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.senai.exemplojsf.dados.ClienteDAO;
import org.senai.exemplojsf.modelo.Cliente;
@ManagedBean
public class ClienteMB {
	private Cliente cliente = new Cliente();

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void gravar() {
		ClienteDAO dao = new ClienteDAO();
		String msg = "";
		
		if(dao.incluir(cliente)) {
			msg = "Sucesso ao gravar";
		}else {
			msg = "Erro ao gravar";
		}
		
		// Exercício 
		// se houver sucesso ao gravar 
		// mostre mensagem positiva
		// senão mensagem negativa
		
		
		FacesContext.getCurrentInstance().addMessage(
				null, new FacesMessage(msg));
	}
}
