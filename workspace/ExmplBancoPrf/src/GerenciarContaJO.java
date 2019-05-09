import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class GerenciarContaJO {
	
	public Conta buscarConta(List<Conta> lsConta,String numero){
		int num = Integer.parseInt(numero);
		for (Conta conta : lsConta) {
			if(conta.numero == num){
				return conta;
			}
		}
		
		return null;
	}
	
	public Conta cadastrarConta(){
		GerenciarPessoa futuroCliente = new GerenciarPessoa();
		// vamos incluir na conta o cliente
		Conta conta01 = null;
		try {
			conta01 = new Conta(futuroCliente.cadastrarCliente());
			Random rand = new Random();
			conta01.numero = rand.nextInt(90000)+10000;
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return conta01;
	}
	
	public void usarConta(Conta conta01) {
		UIManager.put(
				"Button.defaultButtonFollowsFocus", Boolean.TRUE);

		
		JOptionPane.showMessageDialog(null, 
				"Bem vindo sr. "+
						conta01.getCliente().getNome());
		
		Object[] opcoes = { "Depositar", "Sacar", "Saldo", "Extrato", "Dados" };

		// colocar um laço de repetição
		int opcao = 0;
		while (opcao != -1) {

			opcao = JOptionPane.showOptionDialog(null, "Escolha uma opção",
					"Oparações Bancarias", JOptionPane.DEFAULT_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[2]);
			try {
				if (opcao == 0) {
					conta01.depositar(Double.parseDouble(JOptionPane
							.showInputDialog("Digite o valor")
							.replace(",", ".")));
				}

				if (opcao == 1) {
					String txValor = JOptionPane.showInputDialog(
							"Digite o valor").replace(",", ".");
					double valor = Double.parseDouble(txValor);
					boolean sucesso = conta01.sacar(valor);
					if (sucesso) {
						JOptionPane.showMessageDialog(null,
								"Saque realizado com sucesso");
					} else {
						JOptionPane.showMessageDialog(null,
								"Saldo insuficiente!");
					}
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Caractere inválido");
			}

			if (opcao == 2) {
				JOptionPane.showMessageDialog(null,
						"Saldo: " + conta01.getSaldo());
			}

			if (opcao == 3) {
				JOptionPane.showMessageDialog(null,
						"Extrato: " + conta01.getExtrato());
			}
			
			if (opcao == 4) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				JOptionPane.showMessageDialog(null,
						"Dados do Cliente" + 
				"\nNome: "+conta01.getCliente().getNome()+
				"\nData Nascimento: "+
					sdf.format(conta01.getCliente().getDtNascimento())+
				"\nSexo: "+conta01.getCliente().getSexo()+
				"\nFone: "+conta01.getCliente().getTelefone()
				);
			}			

		}

	}

}
