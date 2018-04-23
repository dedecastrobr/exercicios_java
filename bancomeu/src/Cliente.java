package src;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Cliente {
	
	private String nomeCliente = "";
	private long cpfCliente = 0;
	private List<Conta> listaContas = new ArrayList<Conta>();
	private int indice;
	
	
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
	
	public int getIndice(){
		return indice;
	}
	
	public void setIndice(int indice){
		this.indice = indice;
	}
	
	public Cliente(){
		System.out.println("Nome: ");
    	String nomeCliente = tools.Menu.scan.nextLine();
    	this.nomeCliente = nomeCliente;
    	try{
    		System.out.println("CPF: ");
        	this.cpfCliente = tools.Menu.scan.nextLong();
    		tools.Menu.scan.nextLine();
    	} catch(InputMismatchException e){
    		System.out.println("Erro de valor! Somente números!");
			tools.Menu.scan.nextLine(); 
    	}
	}
	
	public boolean save(){
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
	}
	
	public void mostraDados(){
		System.out.println("Nome: " + this.nomeCliente);
		System.out.println("CPF: " + this.cpfCliente);
	}

}
