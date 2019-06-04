package org.senai.cntrCirurgico.modelo;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Painel {

	private int cod;
	private String nomeCompleto;
	private String status;
	private String local;
	private String iniPrevisto;
	private String iniCirurgia;
	private String fimCirurgia;
	private String saidaPrevista;

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getIniPrevisto() {
		return iniPrevisto;
	}

	public void setIniPrevisto(String iniPrevisto) {
		this.iniPrevisto = iniPrevisto;
	}

	public String getIniCirurgia() {
		return iniCirurgia;
	}

	public void setIniCirurgia(String iniCirurgia) {
		this.iniCirurgia = iniCirurgia;
	}

	public String getFimCirurgia() {
		return fimCirurgia;
	}

	public void setFimCirurgia(String fimCirurgia) {
		this.fimCirurgia = fimCirurgia;
	}

	public String getSaidaPrevista() {
		return saidaPrevista;
	}

	public void setSaidaPrevista(String saidaPrevista) {
		this.saidaPrevista = saidaPrevista;
	}

	public void inserir() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			DriverManager.getConnection(
		"jdbc:mysql://localhost/centro_cirurgico", "root", "");
			System.out.println("ok ao conectar");
		} catch (Exception e) {
			System.out.println("erro de conex�o");
		}

	}

}
