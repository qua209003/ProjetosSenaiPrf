public class Cliente extends Pessoa {

	private double renda;
	private String telefone;
	
//	Cliente (){
//		
//	}
	
	Cliente (String nome, double renda){
		setNome(nome);
		setRenda(renda);
	}
	
	public void setRenda(double renda){
		this.renda = renda;
	}
	
	public double getRenda(){
		return renda;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
}
