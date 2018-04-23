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

	public static Scanner scan = new Scanner(System.in);
	public static ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();
	public static ArrayList<Conta> listaConta = new ArrayList<Conta>();

	public static void main(String[] args) {
		
		System.out.println("Bem vindo ao Banco Meu");

		Menu menu = new Menu("Menu Principal", opsMenuPrincipal);
		menu.show();
		int op = menu.getOption();
		do {
			switch (op) {
			case 0:
				Menu menuClientes = new Menu("Clientes", opsMenuClientes);
				menuClientes.show();
				
				int opClientes = menuClientes.getOption();
				do {
					switch (opClientes) {
					case 0:
						cadCliente();
						break;
					case 1:
						consultaCliente();
					default:
						break;
					}
					
				}while (opClientes != 99);
				
				break;
			case 1:
				Menu menuContas = new Menu("Contas", opsMenuContas);
				menuContas.show();
				
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
	public static void cadCliente() {
		Cliente cl = new Cliente();
		if (cl != null ) {
			cl.save();
			System.out.println("Cliente criado com sucesso!");
		}
	}
	public static Cliente consultaCliente() {
		String consulta = "";
		System.out.println("CPF Do cliente: ");
        int cons = scan.nextInt();
    	System.out.println("Cliente encontrado!");
    	for (Cliente client : listaCliente) {
    		if (consulta.equals(client.getCpfCliente())) {
    			client.setIndice(listaCliente.indexOf(client));
    			return client;
    		}
    	}
    	return null;    	
	}
}
