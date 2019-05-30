package org.senai.cntrCirurgico.servlet;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//mapear a classe servlet
@WebServlet(name = "servletPainel", 
			urlPatterns = "/servletPainel")
public class ServletPainel extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServerException, IOException {
		// tenho que pegar as informações do formulário
		String teste = request.getParameter("teste");
		System.out.println(teste);

	}

}
