import javax.swing.JOptionPane;

public class GerenciarPedido {

	public static void main(String[] args) {
		
		String nome = JOptionPane.showInputDialog(
				"Digite o nome de usuario");
		// pra fazer comparação de String
		// temos que usar o metodo equals
		if(nome.equals("java")){
		
		// lista de opções
		Object[] lista = { "100 - Cachorro Quente", "101 - Bauru Simples",
				"102 - Bauru com Ovo", "103 - Hamburguer",
				"104 - Chees Burguer", "105 - Refrigerante" };

		int addProduto = 1;
		double valorFinal = 0;
		String dsPedido = "";
		while (addProduto == 1) {

			Object itemEscolhido = JOptionPane.showInputDialog(null,
					"Escolha um item", "Menu", JOptionPane.QUESTION_MESSAGE,
					null, lista, lista[1]);

			if (itemEscolhido != null) {
				try {

					System.out.println(itemEscolhido);
					String cod = itemEscolhido.toString().substring(0, 3);
					String txQt = JOptionPane
							.showInputDialog("Digite a Quantidade");
					int qt = Integer.parseInt(txQt);
					double preco = 0;
					switch (cod) {
					case "100":
						preco = 1.2;
						break;
					case "101":
						preco = 1.3;
						break;
					case "102":
						preco = 1.5;
						break;
					case "103":
						preco = 1.2;
						break;
					case "104":
						preco = 1.3;
						break;
					case "105":
						preco = 1;
						break;
					default:
						break;
					}
					double total = preco * qt;
					valorFinal += total;
					dsPedido += "\n " + itemEscolhido.toString()
							+" X "+ qt + " = "+ String.format("%,.2f", total);
					JOptionPane.showMessageDialog(null, "Valor Total R$: "
							+ String.format("%,.2f", total));
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null,
							"Número não identificado.", // mensagem
							"Erro", // titulo
							JOptionPane.ERROR_MESSAGE // icone
							);
				}
			}

			Object[] lsOpcao = {"Não","Sim"};
			addProduto = JOptionPane.showOptionDialog(null, 
					"Deseja registrar outro produto", 
					"Continuar", 
					JOptionPane.DEFAULT_OPTION, 
					JOptionPane.QUESTION_MESSAGE, 
					null, 
					lsOpcao, 
					lsOpcao[1]);
		}
		JOptionPane.showMessageDialog(null, 
				"Valor total a ser pago "+
		String.format("%,.2f", valorFinal)+
		dsPedido);

		}else{
			JOptionPane.showMessageDialog(null, 
					"Usuário incorreto");
		}
		
	}

}
