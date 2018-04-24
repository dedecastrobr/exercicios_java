package src;

import java.util.Scanner;

import tools.Menu;

public class Conta {

	private long numeroConta = 0;
	private Double saldo = 0.00;
	private Cliente clienteConta = null;
	private Double limite = 0.00;
	private Scanner scan = Menu.scan;

	public Conta(Cliente c) {
		try {
			System.out.println("Número da Conta: ");
			numeroConta = scan.nextLong();
			scan.nextLine();
			System.out.println("Saldo da Conta: ");
			saldo = scan.nextDouble();
			clienteConta = c;
			BancoMeu.limpaTela();
			mostraConta();
		} catch (Exception e) {
			System.out.println("Valor inválido!");
		}
		
	}
	
	public Conta(long num, Double saldo, Cliente cli) {
		numeroConta = num;
		this.saldo = saldo;
		clienteConta = cli;

	}
	
	public boolean saque(Double valor) {
		if(valor > saldo + limite) {
			System.out.println("Saldo insuficiente!");
			return false;
		}else {
			saldo -= valor;
			System.out.println("Saque efetuado!");
			return true;
		}
	}
	
	public boolean deposito(Double valor) {
		try {
			saldo += valor;
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
	
	public boolean transfere(Conta destino, Double valor) {
		if(saque(valor) && destino.deposito(valor)) {
			System.out.println("Tranferencia efetuada!");
			return true;
		}else {
			System.out.println("Deu ruim");
			return false;
		}
	}
	
	public boolean save() {
		BancoMeu.listaContas.add(this);
		return true;
	}
	
	public void mostraConta() {
		System.out.println("Número: "+ numeroConta +"\nSaldo: "+ saldo +"\nDono da Conta: "+ clienteConta.getNomeCliente());
	}

}
