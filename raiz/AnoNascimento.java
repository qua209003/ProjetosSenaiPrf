import java.util.Scanner;

public class AnoNascimento {
	public static void main(String[] args) {

		try {
			// Exemplo de sa�da de dados
			System.out.println("Digite seu nome: ");
			Scanner scanner = new Scanner(System.in);
			// Exemplo de entrada de dados e guardando em uma
			// variavel do tipo texto.
			String pessoa = scanner.nextLine();
			System.out.println("Boa noite " + pessoa);
			System.out.println("Digite sua idade: ");
			int idade = scanner.nextInt();
			// manuten��o evolutiva
			// inverter a resposta Sim 0 -> 1, N�o 1 -> 0
			System.out.println("J� fez anivers�rio ? Sim 1, N�o 0");
			int aniversario = scanner.nextInt();
			// vamos colocar uma outra condi��o
			// verificar se os digitos do ano � 0 ou 1
			if (aniversario == 0 || aniversario == 1) {
				int ano = 0;
				if (aniversario == 0) {
					ano = 2019 - idade - 1;
				} else {
					ano = 2019 - idade;
				}

				System.out.println("Eu sei que voc� nasceu em " + ano);
				if (1994 < ano) {
					System.out.println("O Brasil j� era Tetra.");
				} else {
					if (1994 == ano) {
						System.out.println("Voc� deu sorte pro Brasil.");
					} else {
						System.out.println("O Brasil ainda n�o era Tetra.");
					}
				}
			} else {
				System.out.println("N�o possivel computar com valor informado");
			}
		} catch (Exception e) {
			System.out.println("Erro de entrada de dados.");
		}

	}

}
