import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class GerenciarContaJO {

	public void usarConta(Cliente cliente) {
		UIManager.put(
				"Button.defaultButtonFollowsFocus", Boolean.TRUE);
		// vamos incluir na conta o cliente
		Conta conta01 = new Conta(cliente);
		conta01.numero = 301;
		
		JOptionPane.showMessageDialog(null, 
				"Bem vindo sr. "+
						cliente.getNome());
		
		Object[] opcoes = { "Depositar", "Sacar", "Saldo", "Extrato", "Dados" };

		// colocar um la�o de repeti��o
		int opcao = 0;
		while (opcao != -1) {

			opcao = JOptionPane.showOptionDialog(null, "Escolha uma op��o",
					"Opara��es Bancarias", JOptionPane.DEFAULT_OPTION,
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
				JOptionPane.showMessageDialog(null, "Caractere inv�lido");
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
					sdf.format(cliente.getDtNascimento())+
				"\nSexo: "+conta01.getCliente().getSexo()+
				"\nFone: "+conta01.getCliente().getTelefone()
				);
			}			

		}

	}

}
