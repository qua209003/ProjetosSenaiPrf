public class Conta {

	public int numero;
//	public String nome;
	private Cliente cliente; 
	private double saldo;
	private String extrato = "";
	
	Conta (int numero, double saldo, Cliente cliente){
		this.numero = numero;
		this.saldo = saldo;
		this.cliente = cliente;
	}
	
	Conta (Cliente cliente){
		this.cliente = cliente;
	}
	
	public Cliente getCliente(){
		return cliente;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public String getExtrato(){
		return extrato;
	}

	public boolean depositar(double valor) {
		extrato += "\nC + " + valor;
		saldo += valor;
		return true;
	}

	public boolean sacar(double valor) {

		if (valor > saldo) {
			return false;
		}
		extrato += "\nD - " + valor;
		saldo -= valor;
		return true;
	}

	@Override
	public String toString() {
		return numero + ";" + saldo + ";"+ extrato.replace("\n", "<br>") + ";";
	}
	
	
	
}
