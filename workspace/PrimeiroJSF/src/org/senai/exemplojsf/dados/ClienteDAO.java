package org.senai.exemplojsf.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.senai.exemplojsf.modelo.Cliente;

public class ClienteDAO {
	
	
	public List<Cliente> listaCliente() {
		
		Connection conexao = new ConectarJDBC().getConectar();

		if (conexao != null) {
			String sql = " select * from cliente ";
			try {
				PreparedStatement prepararSQL = conexao.prepareStatement(sql);
				ResultSet dadosDoBanco = prepararSQL.executeQuery();
				
				//objeto de retorno da lista dos cliente 
				// que estão no bando de dados
				List<Cliente> lsClientes = new ArrayList<Cliente>();
				
				while(dadosDoBanco.next()) {
					Cliente objCliente = new Cliente();
					objCliente.setCod(dadosDoBanco.getInt("cod"));
					objCliente.setNome (dadosDoBanco.getString("nome"));
					objCliente.setEmail(dadosDoBanco.getString("email"));
					objCliente.setSenha(dadosDoBanco.getString("senha"));
					
					lsClientes.add(objCliente);
				}
				// para selecionar linhas e colunas 
				// usar  alt+shift+a
				
				
				prepararSQL.close();
				return lsClientes;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}

		}

		
		return null;
	}
	

	public boolean incluir(Cliente objCliente) {
		Connection conexao = new ConectarJDBC().getConectar();

		if (conexao != null) {
			String sql = "insert into cliente(" + "	nome  ," + "	email         ," + "	senha          )"
					+ "values (?," + "		?," + "		?" + "		)";
			try {
				PreparedStatement prepararSQL = conexao.prepareStatement(sql);
				prepararSQL.setString(1, objCliente.getNome());
				prepararSQL.setString(2, objCliente.getEmail());
				prepararSQL.setString(3, objCliente.getSenha());

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


	public boolean atualizar(Cliente objCliente) {

		Connection conexao = new ConectarJDBC().getConectar();

		if (conexao != null) {
			String sql = "update cliente set "
					+ " nome = ?, email = ?, senha = ? where "
					+ " cod = ? ";
			try {
				PreparedStatement prepararSQL = conexao.prepareStatement(sql);
				prepararSQL.setString(1, objCliente.getNome());
				prepararSQL.setString(2, objCliente.getEmail());
				prepararSQL.setString(3, objCliente.getSenha());
				prepararSQL.setInt(4, objCliente.getCod());

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


	public void apagar(Cliente objCliente) {
		Connection conexao = new ConectarJDBC().getConectar();
		if (conexao != null) {
			String sql = "delete from cliente where "
					+ " cod = ? ";
			try {
				PreparedStatement prepararSQL = conexao.prepareStatement(sql);
				prepararSQL.setInt(1, objCliente.getCod());
				prepararSQL.execute();
				prepararSQL.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
