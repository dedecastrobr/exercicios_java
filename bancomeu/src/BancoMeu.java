package src;
import java.util.Scanner;



import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import tools.Menu;

public class BancoMeu {

	public static List<String> opsMenuPrincipal = Arrays.asList("Clientes", "Contas");
	public static List<String> opsMenuClientes = Arrays.asList("Cadastrar Clientes", "Consultar Clientes");
	public static List<String> opsMenuContas = Arrays.asList("Nova Conta", "Ver Extrato", "Consultar Conta");

	public static ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();
	public static ArrayList<Conta> listaConta = new ArrayList<Conta>();

	public static void main(String[] args) {
		
		System.out.println("Bem vindo ao Banco Meu");

		Menu menu = new Menu("Menu Principal", opsMenuPrincipal);
		menu.show();
		int op = menu.getOption();
		do {
			switch (op) {
			case 1:
				Menu menuClientes = new Menu("Clientes", opsMenuClientes);
				menuClientes.show();
				
				int opClientes = menuClientes.getOption();
				do {
					switch (opClientes) {
					case 1:
						cadCliente();
						break;
					case 2:
						consultaCliente();
					default:
						break;
					}
				opClientes = (opClientes != 99) ? menuClientes.getOption() : 99;
				}while (opClientes != 99);
				
				break;
			case 2:
				Menu menuContas = new Menu("Contas", opsMenuContas);
				menuContas.show();
				int opContas = menuContas.getOption();
				do {
					switch(opContas) {
					case 1: 
						cadConta(Cliente);
						break;
					case 2:
						break;
				}while (opContas != 99);
				break;
			case 99:
				System.out.println("Tchau!");
				System.exit(0);
				break;

			default:
				System.out.println("Opção inválida!");
				break;
			}
			op = menu.getOption();
		} while (op != 99);

	}
	private static void cadCliente() {
		Cliente cl = new Cliente();
		if (cl != null ) {
			cl.save();
			System.out.println("Cliente criado com sucesso!");
		}
	}
	public static Cliente consultaCliente() {
		System.out.println("CPF Do cliente: ");
		long cons = 0;
		try {
		cons = Menu.scan.nextInt();
    	Menu.scan.nextLine();
        }catch(Exception e) {
        	System.out.println("Erro ao encontrar cliente");
        	System.out.println("Valor Inválido(Somente Números)");
        }
		System.out.println("Cliente encontrado!");
    	for (Cliente cli : listaCliente) {
    		if (cli.getCpfCliente() == cons) {
    			cli.setIndice(listaCliente.indexOf(cli));
    			return cli;
    		}
    	}
    	return null;    	
	}
	public static void cadConta(Cliente cli) {
		if(cli != null) {
			Conta cont = new Conta(cli);
		}else {
			System.out.println("Não foi encontrado cliente");
			System.out.println("Cliente nulo");
		}
	}
}
