package org.senai.exemplojsf.managedbean;

import java.util.List;

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

	public List<Cliente> lsCliente() {
		ClienteDAO dao = new ClienteDAO();
		return dao.listaCliente();
	}

	public void editar(Cliente obj) {

		System.out.println(obj.getNome());

		FacesContext.getCurrentInstance()
		.getExternalContext()
		.getSessionMap()
		.put("editar", obj);
		// esse comandos fazem com que
		// o objeto cliente selecionado para
		// ser editado fique na sessão
	}

	public void gravar() {
		ClienteDAO dao = new ClienteDAO();
		String msg = "";

		if (dao.incluir(cliente)) {
			msg = "Sucesso ao gravar";
		} else {
			msg = "Erro ao gravar";
		}

		// Exercício
		// se houver sucesso ao gravar
		// mostre mensagem positiva
		// senão mensagem negativa

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg));
	}

}
