package src;

public class Conta {

	private long numeroConta = 0;
	private Double saldo = 0.00;
	private Cliente clienteConta = null;

	public Conta(long num, Double saldo, Cliente cli) {
		this.numeroConta = num;
		this.saldo = saldo;
		this.clienteConta = cli;

	}
	
	public boolean saque(Double valor) {
		try {
			this.saldo -= valor;
			return true;
		} catch (Exception e) {
			System.out.println("Erro ao efetuar saque!");
			return false;
		}
	}
	
	public boolean deposito(Double valor) {
		try {
			this.saldo += valor;
			return true;
		} catch (Exception e) {
			System.out.println("Erro ao efetuar deposito!");
			return false;
		}
	}

	public long getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(long numeroConta) {
		this.numeroConta = numeroConta;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Cliente getClienteConta() {
		return clienteConta;
	}

	public void setClienteConta(Cliente clienteConta) {
		this.clienteConta = clienteConta;
	}

}
