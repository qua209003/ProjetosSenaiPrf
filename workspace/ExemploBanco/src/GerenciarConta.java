
public class GerenciarConta {

	public static void main(String[] args) {

		Conta conta01 = new Conta(new Cliente("Luiz",0));
		conta01.numero = 301;
		conta01.depositar(2000);
//		conta01.nome = "Luiz Felipe";
		// realizem um saque de 300.0
		conta01.sacar(300);
		// realizem um deposito de 20.0
		conta01.depositar(20);
		if(conta01.sacar(1800)){
			System.out.println("Saque realizado com sucesso");
		}else{
			System.out.println("Saldo insuficiente!");
		}
		System.out.println(
//				"Nome: "+ conta01.nome+
				"\nSaldo: "+ conta01.getSaldo()+
				"\nExtrato: "+ conta01.getExtrato()	
				);

	}

}
