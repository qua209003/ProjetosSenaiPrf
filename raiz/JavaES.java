import java.util.Scanner;

public class JavaES {
	public static void main(String[] args) {
		// Exemplo de saída de dados
		System.out.println("Digite seu nome: ");

		Scanner scanner = new Scanner(System.in);
		// Exemplo de entrada de dados e guardando em uma 
		// variavel do tipo texto.
		String pessoa = scanner.nextLine();
		System.out.println("Boa noite " + pessoa);
		System.out.println("Digite sua idade: ");
		int idade = scanner.nextInt();
		
	}

}
