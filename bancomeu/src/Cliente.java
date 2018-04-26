package src;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import tools.Menu;

public class Cliente {
	
	private String nomeCliente = "";
	private long cpfCliente = 0;
	private ArrayList<Conta> listaContas = new ArrayList<Conta>();
	private Scanner scan = Menu.scan;
	
	public Cliente (String n, long cpf) {
		this.nomeCliente = n;
		this.cpfCliente = cpf;
	}


	public String getNomeCliente() {
		return nomeCliente;
	}


	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}


	public long getCpfCliente() {
		return cpfCliente;
	}


	public void setCpfCliente(long cpfCliente) {
		this.cpfCliente = cpfCliente;
	}


	public List<Conta> getListaContas() {
		return listaContas;
	}


	public void setListaContas(ArrayList<Conta> listaContas) {
		this.listaContas = listaContas;
	}
	
	public Cliente(){
		System.out.println("Nome: ");
    	String nomeCliente = scan.nextLine();
    	this.nomeCliente = nomeCliente;
    	try{
    		System.out.println("CPF: ");
        	this.cpfCliente = scan.nextLong();
    		scan.nextLine();
    	} catch(InputMismatchException e){
    		System.out.println("Erro de valor! Somente números!");
			scan.nextLine(); 
    	}
	}
	
	public boolean save(){
		BancoMeu.listaClientes.add(this);
		return true;
	}
	
	public void mostraDados(){
		System.out.println("Nome: " + this.nomeCliente);
		System.out.println("CPF: " + this.cpfCliente);
	}
}