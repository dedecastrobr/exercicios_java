package src;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Cliente {
	
	private String nomeCliente = "";
	private long cpfCliente = 0;
	private List<Conta> listaContas = new ArrayList<Conta>();
	
	
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


	public void setListaContas(List<Conta> listaContas) {
		this.listaContas = listaContas;
	}
	
	public Cliente(String nomeCliente, long cpfCliente){
		this.nomeCliente = nomeCliente;
		this.cpfCliente = cpfCliente;
	}
	
	public Cliente(){
		System.out.println("Nome: ");
    	String nomeCliente = Menu.scan.nextLine();
    	this.nomeCliente = nomeCliente;
    	try{
    		System.out.println("CPF: ");
        	this.cpfCliente = Menu.scan.nextInt();
    		Menu.scan.nextLine();
    	} catch(InputMismatchException e){
    		System.out.println("Erro de valor! Somente números!");
			Menu.scan.nextLine(); 
    	}
	}
	
	public void mostraDados(){
		System.out.println("Nome: " + this.nomeCliente);
		System.out.println("CPF: " + this.cpfCliente);
	}

}
