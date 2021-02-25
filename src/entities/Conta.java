package entities;

public class Conta {

	private final Double TAXA_SAQUE = 5.00;
	
	private Integer numero;
	private String nome;
	private Long senha;
	private double saldo;
	
	public Conta() {
	}
	
	public Conta(Integer numero, String nome, Long senha , double depositoInicial) {
		this.numero = numero;
		this.nome = nome;
		this.senha = senha;
		deposito(depositoInicial);
	}
	
	public Conta(Integer numero, String nome, Long senha) {
		this.numero = numero;
		this.nome = nome;
		this.senha = senha;
	}

	public Integer getNumero() {
		return numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Long getSenha() {
		return senha;
	}

	public Double getSaldo() {
		return saldo;
	}
	
	public void deposito(double deposito) {
		saldo += deposito;
	}
	
	public void saque(double saque) {
		saldo -= saque + TAXA_SAQUE;
	}
	
	public String toString() {
		return numero
				+ ", Titular: "
				+ nome
				+ ", Saldo: R$ "
				+ String.format("%.2f",saldo);
	}
}
