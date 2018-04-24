package src;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import tools.Menu;


public class Cliente {
	
	private String nomeCliente = "";
	private long cpfCliente = 0;
	private List<Conta> listaContas = new ArrayList<Conta>();
    private int indice;
    private Scanner Scan = Menu.scan;
	
    public  Cliente(){
    try {	   
        System.out.println("Informe o nome do cliente: ");
    	String n = Scan.nextLine();
    	System.out.println("Informe o CPF do cliente: ");
    	long c = Scan.nextLong();
    	Scan.nextLine();
    	this.nomeCliente = n;
    	this.cpfCliente = c;
	}catch (InputMismatchException e) {
		Menu.scan.nextLine();
		System.out.println("Valor invalido(Somente Números)");
		System.out.println("Falha na criação do Cliente\n");
	}
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
    public boolean save() {
    	BancoMeu.listaCliente.add(this);
    	return true;
    }
    public int getIndice() {
		return indice;
    }
    public void setIndice(int indice) {
		this.indice = indice;
    }
	

}
