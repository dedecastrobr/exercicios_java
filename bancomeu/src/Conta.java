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
			System.out.println("Erro ao efetuar depósito!");
			return false;
		}
	}
	
	public boolean trasfere(Conta destino, Double valor){
		if((this.saque(valor)) && (destino.deposito(valor))){
			System.out.println("Transferência OK!");
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
	
	public Conta(){
		System.out.println("Número da Conta: ");
		try{
	    	long numeroConta = scan.nextLong();
	    	scan.nextLine();
	    	double saldo = scan.nextDouble();
	    	this.numeroConta = numeroConta;
	    	this.saldo = saldo;
	    	this.numeroConta = numeroConta;
    	} catch(InputMismatchException e){
    		System.out.println("Erro de valor! Somente números!");
			scan.nextLine(); 
    	}
	}
	
	/*public boolean save(){
		BancoMeu.listaClientes.add(this);
		return true;
	}
	
	public void updateCliente(){
		String nomeCliente = "";
		System.out.println("Novo nome: ");
		nomeCliente = BancoMeu.scan.nextLine();
		if(!nomeCliente.isEmpty()){
			this.nomeCliente = nomeCliente;
		}
		long cpfCliente = 0;
		System.out.println("Novo CPF: ");
		cpfCliente = BancoMeu.scan.nextLong();
		BancoMeu.scan.nextLine();
		if(cpfCliente != 0){
			this.cpfCliente = cpfCliente;
		}		
		System.out.println("---------------------------------");
		System.out.println("Cliente cadastrado com sucesso!");
		System.out.println("---------------------------------");
	}
	
	public boolean update(){
		BancoMeu.listaClientes.set(this.getIndice(), this);
		return true;
	}*/
	
	public void mostraDados(){
		System.out.println("Conta: " + this.numeroConta);
	}
}
