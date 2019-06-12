package org.senai.cntrCirurgico.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Painel {

	private int cod;
	private String nomeCompleto;
	private String status;
	private String local;
	private String iniPrevisto;
	private String iniCirurgia;
	private String fimCirurgia;
	private String saidaPrevista;
	
	
	public Painel(){
		setNomeCompleto("");
		setStatus("");
		setLocal("");
		setIniPrevisto("");
		setIniCirurgia("");
		setFimCirurgia("");
		setSaidaPrevista("");
	}

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

	
	public boolean apagar() {

		Connection conexao = new ConectarJDBC().getConectar();
		
		if(conexao != null) {
			String sql = "delete from painel where cod = ? ";
			try {
				PreparedStatement prepararSQL =
						conexao.prepareStatement(sql);				
				prepararSQL.setInt(1, cod);				
				prepararSQL.execute();
				prepararSQL.close();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			
		}
		return false;
	}
	
	// copiamos o código inserir pra reaproveitar o codigo e
	// fazer o método atualizar
	public boolean atualizar() {

		Connection conexao = new ConectarJDBC().getConectar();
		
		if(conexao != null) {
			String sql = "update painel set " + 
					"	nome_completo = ? ," + 
					"	status        = ? ," + 
					"	local         = ? ," + 
					"	ini_previsto  = ? ," + 
					"	ini_cirurgia  = ? ," + 
					"	fim_cirurgia  = ? ," + 
					"	saida_prevista = ? " + 
					" where cod = ? ";
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
				prepararSQL.setInt(8, cod);
				
				prepararSQL.execute();
				prepararSQL.close();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			
		}
		return false;
	}

	public boolean inserir() {

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
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			
		}
		return false;
	}
	
	public List<Painel> getLista(){		
		try {
			Connection conexao = new ConectarJDBC().getConectar();
			PreparedStatement ps = 					
					conexao.prepareStatement("select * from painel");
			ResultSet rs = ps.executeQuery();
			
			List<Painel> lsPainel = new ArrayList<Painel>();
			
			while (rs.next()) {
				Painel p = new Painel();
				// o que esta entre aspas "nome_da_coluna_no_banco"
				p.setCod(rs.getInt("cod"));
				p.setNomeCompleto(rs.getString("nome_completo"));
				p.setStatus(rs.getString("status"));
				p.setLocal(rs.getString("local"));
				p.setIniPrevisto(rs.getString("ini_previsto"));
				p.setIniCirurgia(rs.getString("ini_cirurgia"));
				p.setFimCirurgia(rs.getString("fim_cirurgia"));
				p.setSaidaPrevista(rs.getString("saida_prevista"));
				lsPainel.add(p);
			}
			ps.close();
			conexao.close();
			return lsPainel;
		} catch (Exception e) {

		}		
		return null;
	}
	
	
	public Painel getPainel(int cod){		
		try {
			Connection conexao = new ConectarJDBC().getConectar();
			PreparedStatement ps = 					
					conexao.prepareStatement(
							"select * from painel where cod = ? ");
			ps.setInt(1, cod);
			ResultSet rs = ps.executeQuery();
			
			Painel p = new Painel();
			while (rs.next()) {
				// o que esta entre aspas "nome_da_coluna_no_banco"
				p.setCod(rs.getInt("cod"));
				p.setNomeCompleto(rs.getString("nome_completo"));
				p.setStatus(rs.getString("status"));
				p.setLocal(rs.getString("local"));
				p.setIniPrevisto(rs.getString("ini_previsto"));
				p.setIniCirurgia(rs.getString("ini_cirurgia"));
				p.setFimCirurgia(rs.getString("fim_cirurgia"));
				p.setSaidaPrevista(rs.getString("saida_prevista"));
			}
			ps.close();
			conexao.close();
			return p;
		} catch (Exception e) {

		}		
		return null;
	}
	
	public String getCorStatus() {
			
		if(status.equals("Pré-Operatório")) {
			return "table-warning";
		}

		if(status.equals("Em sala cirúrgica")) {
			return "table-danger";
		}		
		
		if(status.equals("Em recuperação")) {
			return "table-success";
		}

		if(status.equals("Transferido")) {
			return "table-primary";
		}
		
		return "";
	}

	
	
	
	
}
