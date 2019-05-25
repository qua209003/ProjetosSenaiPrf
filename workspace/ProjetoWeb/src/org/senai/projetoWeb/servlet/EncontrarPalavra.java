package org.senai.projetoWeb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		name = "encontrarPalavra",
		urlPatterns = {"/encontrarPalavra","/palavra"}
		)

public class EncontrarPalavra  extends HttpServlet{

	protected void service(
			HttpServletRequest request,
			HttpServletResponse response
			)throws ServletException, IOException {
		
		int qt = 20;
		
		Random random = new Random(); 
		int[][] mtz = new int[qt][qt];

		String palavra = "java".toUpperCase();
		PrintWriter saida = response.getWriter();
		// indice da linha  
		int il = random.nextInt(qt);
		// indice da coluna 
		int ic = random.nextInt(qt-palavra.length());
		
		for (int i = 0; i < palavra.length(); i++) {
			mtz[il][ic+i] = (int) palavra.charAt(i);
		}
		
		char ch = 0;
		for (int l = 0; l < qt; l++) {
			for (int c = 0; c < qt; c++) {
				if(mtz[l][c]==0){
					mtz[l][c] = 65+random.nextInt(23);
				}
				saida.print((char)mtz[l][c]+" ");
			}
			saida.println();
		}
	}

}