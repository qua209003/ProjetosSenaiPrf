package org.senai.cntrCirurgico.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.senai.cntrCirurgico.modelo.Painel;

//mapear a classe servlet
@WebServlet(name = "servletPainel", urlPatterns = "/servletPainel")
public class ServletPainel extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServerException, IOException {
		// tenho que pegar as informações do formulário
		String nome = request.getParameter("nome");
		String status = request.getParameter("status");
		System.out.println("Nome digitado " + nome + " Status " + status);

		Painel obj = new Painel();
		obj.setNomeCompleto(nome);
		obj.setStatus(status);
		obj.setLocal(request.getParameter("local"));
		obj.setIniPrevisto(request.getParameter("iniPrev"));
		obj.setIniCirurgia(request.getParameter("iniCirrg"));
		obj.setSaidaPrevista(request.getParameter("saiPrev"));		
		obj.setFimCirurgia(request.getParameter("fimCirrg"));
		
		PrintWriter saida = response.getWriter();
		
		int cod = Integer.parseInt(
				request.getParameter("cod"));
		
		boolean sucesso = false;
		if(cod > 0) {
			obj.setCod(cod);
			if(request.getParameter("apagar")==null) {
				sucesso = obj.atualizar();
			}else {
				sucesso = obj.apagar();
			}
			
		}else {
			sucesso = obj.inserir();
		}
		
		if(sucesso) {
			saida.print("Gravado com sucesso");
		}else {
			saida.print("Erro ao gravar");
		}

	}

}
