package org.senai.exemplojsf.managedbean;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.senai.exemplojsf.dados.ClienteDAO;
import org.senai.exemplojsf.modelo.Cliente;

@ManagedBean
public class ClienteMB {
	
	
	// vamos fazer um novo método
	// nesse método será iniciado automaticamente 
	
	@PostConstruct
	protected void init() {
		
		Map<String,Object> sessao =
		FacesContext.getCurrentInstance()
		.getExternalContext()
		.getSessionMap();
		
		if(
			sessao.containsKey("editar")) {
			System.out.println("Tem coisa pra editar");
			
			cliente = (Cliente) sessao.get("editar");
			
		}else {
			System.out.println("Não tem nada pra editar");
			cliente = new Cliente();
		}
	}

	private Cliente cliente;

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
	
	public String apagar() {
		ClienteDAO dao = new ClienteDAO();
		dao.apagar(cliente);
		return "listaCliente.xhtml";
	}

	public String editar(Cliente obj) {

		//System.out.println(obj.getNome());
//		FacesContext.getCurrentInstance()
//		.getExternalContext()
//		.getSessionMap()
//		.put("editar", obj);
		
		cliente = obj;
		
		return "formulario.xhtml";
		// esse comandos fazem com que
		// o objeto cliente selecionado para
		// ser editado fique na sessão
	}

	public void gravar() {
		ClienteDAO dao = new ClienteDAO();
		String msg = "";

		boolean sucesso = false;
		
		if(cliente.getCod() == 0) {
			// gravar novo
			sucesso = dao.incluir(cliente);			
		}else {
			// atualizar
			sucesso = dao.atualizar(cliente);
		}
		
		if (sucesso) {
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
