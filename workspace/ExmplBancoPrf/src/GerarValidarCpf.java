
import java.util.Random;

import javax.swing.JOptionPane;

public class GerarValidarCpf {

	public static int buscaDig(int dig, int[] cpf) {

		int aux = 10 + dig;
		int soma = 0;
		for (int i = 0; i <= 8 + dig; i++) {
			// multiplica o valor crescente do cpf
			// e descrescente de 10 .. 2
			int mult = cpf[i] * aux;
			// vai somando os valores multiplicados
			soma = soma + mult;
			System.out.println("pos " + i + " val " + cpf[i] + " mult " + aux
					+ " = " + mult + " vlr soma " + soma);
			aux--;
		}
		// resto da divisão por 11
		int rest = soma % 11;
		System.out.println(rest);

		if (rest < 2) {
			return 0;
		} else {
			return 11 - rest;
		}

	}

	public static void gerarCpf(){

		int[] cpf = new int[11];
		// gerar aleatoriamente 9 números
		Random aleatorio = new Random();
		for (int i = 0; i < 9; i++) {
			cpf[i] = aleatorio.nextInt(10); 
		}

		cpf[9] = buscaDig(0, cpf);
		System.out.println(cpf[9]);
		cpf[10] = buscaDig(1, cpf);
		System.out.println(cpf[10]);

		String txCpf = "";
		// mostrar o cpf completo
		for (int i = 0; i < cpf.length; i++) {
			System.out.print(cpf[i]);
			txCpf += cpf[i];// forma antiga txCpf = txCpf + cpf[i];
			// desafio colocar a mascara do CPF
			// 012 345 678 9
			// 000.000.000-00
			if (i == 2 || i == 5) {
				System.out.print(".");
				txCpf += ".";
			}

			if (i == 8) {
				System.out.print("-");
				txCpf += "-";
			}
		}
		// saída de texto por janela
		JOptionPane.showMessageDialog(null, txCpf);
	}
	
	//36902501485
	//01234567891
	public static boolean validarCpf(String txCpf){
		try{
		// remove . ou - da mascara do CPF
		txCpf = txCpf.replace(".", "").replace("-", "");
		
		//tratamento de todos os digitos iguais
		int qtIguais = 0;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 11; j++) {
				if(i == Integer.parseInt(txCpf.substring(j, j+1))){
					qtIguais++;
				}
			}
			if (qtIguais == 11) {
				return false;
			}else{
				qtIguais = 0;
			}
		}
		
		
		int cpf[] = new int[11];
		for (int i = 0; i < 11; i++) {
			cpf[i] = Integer.parseInt(txCpf.substring(i, i+1));
		}
		int dig0 = buscaDig(0, cpf);
		int dig1 = buscaDig(1, cpf);
		
		if (dig0==cpf[9] && dig1 == cpf[10]) {
			return true;
		}
		return false;
		
		// catch
		}catch(Exception e){
			System.out.println("erro na validação");
			return false;
		}
	}
	
	public static void main(String[] args) {
		
		Object[] opcoes = {"Gerar","Validar"};
		int opcao = JOptionPane.showOptionDialog(
				null, 
				"O que você deseja?", 
				"Opções", 
				JOptionPane.DEFAULT_OPTION, 
				JOptionPane.QUESTION_MESSAGE, 
				null, 
				opcoes, 
				opcoes[0]);
		switch (opcao) {
		case 0:
			gerarCpf();
			break;
		case 1:
			String texto = "";
			if(validarCpf(
					JOptionPane.showInputDialog(
							"Digite o Cpf"))){
				texto = "Cpf Válido";
			}else{
				texto = "Cpf Invalido";
			}
			JOptionPane.showMessageDialog(null, texto);
			break;			
		default:
			break;
		}
		
		
	}

}
