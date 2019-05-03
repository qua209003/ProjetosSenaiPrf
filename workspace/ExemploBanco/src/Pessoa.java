import java.util.Date;


public class Pessoa {

	private String nome;
	private Date dtNascimento;
	private String cpf;
	private char sexo;
	
	// set - get
	//mudar - ver
	
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getNome(){
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		// iremos validar o CPf antes de colocar no
		// atributo cpf
		if(GerarValidarCpf.validarCpf(cpf))
		this.cpf = cpf;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	
}
