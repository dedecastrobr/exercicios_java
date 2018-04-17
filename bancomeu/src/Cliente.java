package src;

import java.util.ArrayList;
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
	
	
	
	

}
