package src;

import java.util.InputMismatchException;

import tools.Menu;

public class Conta {

	private long numeroConta = 0;
	private Double saldo = 0.00;
	private Cliente clienteConta = null;
	private Double limite = 0.00;
	public Conta(long num, Double saldo, Cliente cli) {
		this.numeroConta = num;
		this.saldo = saldo;
		this.clienteConta = cli;

	}
    public  Conta(Cliente cli){	   
        System.out.println("Informe o Número da Conta: ");
    try {
        long nc = Menu.scan.nextLong();
    	Menu.scan.nextLine();
    	System.out.println("Informe o saldo da conta");
    	double s = Menu.scan.nextDouble();
    	Menu.scan.nextLine();
    	this.numeroConta = nc;
    	this.saldo = s;
		}catch (InputMismatchException e) {
		Menu.scan.nextLine();
		System.out.println("Valor invalido(Somente Números)");
		System.out.println("Falha na criação do Cliente\n");
	}
}
	
	public boolean saque(Double valor) {
		if (valor>saldo+limite){
			System.out.println("Saldo insuficiente");
			return false;
		} else {
			System.out.println("Saque efetuado!");
			saldo -= valor;
			return true;
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
	public boolean transfere (Conta destino, Double valor) {
		
		if(this.saque(valor) && destino.deposito(valor)){
			System.out.println("Transferencia ok");
			return true;
		}else {
			System.out.println("Transferencia Mal Sucedida");
			return false;
		}
	}


}
