package org.senai.cntrCirurgico.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

		Connection conexao = new ConectarJDBC().getConectar();
		
		if(conexao != null) {
			String sql = "insert into painel(" + 
					"	nome_completo  ," + 
					"	status         ," + 
					"	local          ," + 
					"	ini_previsto   ," + 
					"	ini_cirurgia   ," + 
					"	fim_cirurgia   ," + 
					"	saida_prevista )" + 
					"values (?," + 
					"		?," + 
					"		?," + 
					"		?," + 
					"		?," + 
					"		?," + 
					"		?" + 
					"		)";
			try {
				PreparedStatement prepararSQL =
						conexao.prepareStatement(sql);
				prepararSQL.setString(1, nomeCompleto);
				prepararSQL.setString(2, status);
				prepararSQL.setString(3, local);
				prepararSQL.setString(4, iniPrevisto);
				prepararSQL.setString(5, iniCirurgia);
				prepararSQL.setString(6, fimCirurgia);
				prepararSQL.setString(7, saidaPrevista);
				
				prepararSQL.execute();
				prepararSQL.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}

}
