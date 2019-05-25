package org.senai.projetoWeb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "olaServlet", 
		urlPatterns = { "/olaServlet" })
public class OlaServlet extends HttpServlet{
	// request = pedido	//response = resposta
	// servirão como entrada e saída de dados

	protected void service(
			HttpServletRequest request,
			HttpServletResponse response
			)throws ServletException, IOException 
	
	{
		// aqui iremos fazer uma página com tags html
		PrintWriter saida = response.getWriter();
		saida.println("<html>");
		saida.println("<head>");
		saida.println("<title>");
		saida.println("Meu servlet ");
		saida.println("</title>");
		saida.println("</head>");
		saida.println("<body>");
		saida.println("O servlet ta funcionando mas "
				+ "programar assim é muito complicado!");
		saida.println("</body>");
		saida.println("</html>");
		
	}
	
}
