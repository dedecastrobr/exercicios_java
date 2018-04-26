package src;

import java.util.InputMismatchException;
import java.util.Scanner;

import tools.Menu;

public class Conta {

	private long numeroConta = 0;
	private Double saldo = 0.00;
	private Cliente clienteConta = null;
	private Double limite = 0.00;
	private Scanner scan = Menu.scan;

	public Conta(long num, Double saldo, Cliente cli) {
		this.numeroConta = num;
		this.saldo = saldo;
		this.clienteConta = cli;

	}
	
	public boolean saque(Double valor) {
		if(valor > saldo + limite){
			System.out.println("Saldo insuficiente!");
			this.saldo -= valor;
			return true;
		}else{
			System.out.println("Saque efetuado!");
			saldo -= valor;
			return false;
		}
	}
	
	public boolean deposito(Double valor) {
		try {
			this.saldo += valor;
			return true;
		} catch (Exception e) {
			System.out.println("Erro ao efetuar dep�sito!");
			return false;
		}
	}
	
	public boolean trasfere(Conta destino, Double valor){
		if((this.saque(valor)) && (destino.deposito(valor))){
			System.out.println("Transfer�ncia OK!");
			return true;
		}else{
			System.out.println("Deu ruim!");
			return false;
		}
	}
	
	public boolean isEspecial(){
		return (limite > 0.00);
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
	
	public Conta(Cliente cli){
		System.out.println("N�mero da Conta: ");
		try{
	    	long numeroConta = scan.nextLong();
	    	scan.nextLine();
	    	double saldo = scan.nextDouble();
	    	this.numeroConta = numeroConta;
	    	this.saldo = saldo;
	    	this.numeroConta = numeroConta;
    	} catch(InputMismatchException e){
    		System.out.println("Erro de valor! Somente n�meros!");
			scan.nextLine(); 
    	}
	}
	
	public boolean save(){
		BancoMeu.listaContas.add(this);
		return true;
	}
	
	public void mostraDados(){
		System.out.println("Conta: " + this.numeroConta);
	}
}
