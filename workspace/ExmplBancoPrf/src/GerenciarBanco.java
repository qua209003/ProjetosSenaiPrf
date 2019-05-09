import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.JOptionPane;

public class GerenciarBanco {
	
	
	private final static String localArquivo = new File("").getAbsolutePath();
	
	public static void main(String[] args) {

		GerenciarContaJO gerenciar = new GerenciarContaJO();
		Object escolha = "";
		List<Conta> lsConta = buscarContas(); 
		
		do {
			Object[] opcBanco = { "Nova Conta", 
					"Gerenciar Contas", 
					"Concluir" };
			escolha = JOptionPane.showInputDialog(
					null, 
					"Escolha uma opção",
					"Opções", 
					JOptionPane.DEFAULT_OPTION, 
					null, 
					opcBanco,
					opcBanco[0]);
			if (escolha.equals("Nova Conta")) {
				lsConta.add(gerenciar.cadastrarConta());
			}
			if (escolha.equals("Gerenciar Contas")){
				String numero = JOptionPane.showInputDialog(""
						+ "Digite o número da conta.");
				Conta usar = gerenciar.buscarConta(lsConta, numero);
				if(usar == null){
					JOptionPane.showMessageDialog(null, 
							"Número invalido de conta");
				}else{
					gerenciar.usarConta(usar);
				}
			}
		} while (!escolha.equals("Concluir"));

		gravarArquivo(lsConta);
		// gerenciar.usarConta(cliente);

	}
	
	private static void gravarArquivo(List<Conta> lsConta){
		try {
			FileWriter arquivo = new FileWriter(localArquivo+"\\src\\lsConta.txt");
			PrintWriter escrever = new PrintWriter(arquivo);
			
			for (Conta conta : lsConta) {
				escrever.println(
						conta.toString()+
						conta.getCliente().toString()
						);
			}
			escrever.close();
		} catch (IOException e) {
			System.out.println("Arquivo não Encontrado");
		}
	}
	
	private static List<Conta> buscarContas(){
		List<Conta> lsConta = new ArrayList<Conta>();
		
		try {
			FileReader arquivo = new FileReader(localArquivo+"\\src\\lsConta.txt");
			BufferedReader ler = new BufferedReader(arquivo);
			
			String linhas = ler.readLine();
			
			while(linhas != null){
				System.out.println(linhas);
				
				// alimentar objetos
				String[] coluna = linhas.split(";"); 
				Cliente objCliente = new Cliente(coluna[6], Double.parseDouble(coluna[3]));
				objCliente.setTelefone(coluna[4]);
				objCliente.setCpf(coluna[7]);
				objCliente.setSexo(coluna[8].charAt(0));
				SimpleDateFormat sdf = new SimpleDateFormat(
						"EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
				objCliente.setDtNascimento(sdf.parse(coluna[5]));
				// criar o objeto Conta
				Conta objConta = new Conta(Integer.parseInt(coluna[0]),
						Double.parseDouble(coluna[1]),
						objCliente);
				lsConta.add(objConta);
				linhas = ler.readLine();
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lsConta;
	}

}
