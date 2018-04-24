package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import tools.Menu;

public class BancoMeu {

	public static List<String> opsMenuPrincipal = Arrays.asList("Clientes", "Contas");
	public static List<String> opsMenuClientes = Arrays.asList("Cadastrar Clientes", "Consultar Clientes");
	public static List<String> opsMenuContas = Arrays.asList("Nova Conta", "Ver Extrato", "Consultar Conta", "Transferencia");
	
	public static ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
	public static ArrayList<Conta> listaContas = new ArrayList<Conta>();
 
	public static void main(String[] args) {
		
		limpaTela();
		System.out.println("Bem vindo ao Banco Meu\n");

		Menu menu = new Menu("Menu Principal", opsMenuPrincipal);
		menu.show();
		int op = menu.getOption();
		do {
			switch (op) {
			case 0:
				limpaTela();
				Menu menuClientes = new Menu("Clientes", opsMenuClientes);
				menuClientes.show();
				
				int opClientes = menuClientes.getOption();
				do {
					switch (opClientes) {
					case 0:
						limpaTela();
						cadastroCliente();
						break;
						
					case 1:
						limpaTela();
						listaClientes();
						break;
						
					default:
						break;
					}
					menuClientes.show();
					opClientes = (opClientes != 99) ? menuClientes.getOption() : 99;
				}while (opClientes != 99);
				
				break;
			case 1:
				limpaTela();
				Menu menuContas = new Menu("Contas", opsMenuContas);
				menuContas.show();
				
				int opContas = menuContas.getOption();
				do {
					switch (opContas) {
					case 0:
						limpaTela();
						cadastraConta(buscaCliente());
						break;
					case 1:
						limpaTela();
						break;
					case 2:
						limpaTela();
						listaContas();
						break;
					case 3:
						limpaTela();
						
						break;
					default:
						break;
					}
					menuContas.show();
					opContas= (opContas != 99) ? menuContas.getOption() : 99;
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
			menu.show();
			op = menu.getOption();
		}while (op != 99);
	}
	
	public static void cadastroCliente() {
		Cliente cliente = new Cliente();
		if (cliente != null) {
			cliente.save();
			System.out.println("\n--------------------------");
			System.out.println("Cliente criado com sucesso!");
			System.out.println("--------------------------\n");
		}
	}
	
	public static void cadastraConta(Cliente cli) {
		if(cli != null) {
			Conta cont = new Conta(cli);
			cont.save();
			System.out.println("\n--------------------------");
			System.out.println("Conta criada com sucesso!");
			System.out.println("--------------------------\n");
		}else {
			System.out.println("Não é possivel criar a conta!\nCliente inválido!");
		}
	}
	
	public static void listaClientes() {
		limpaTela();
		System.out.println("Clientes cadastrados:");
		System.out.println("_______________________________________");
		int i = 1;
		for (Cliente cliente : listaClientes) {
			System.out.println("Número: "+ i);
			i = i+1;
			cliente.mostraCliente();
			System.out.println("_______________________________________\n");
		}
	}
	
	public static void listaContas() {
		limpaTela();
		System.out.println("Contas cadastradas:");
		System.out.println("_______________________________________");
		int i = 1;
		for (Conta conta : listaContas) {
			System.out.println("Número: "+ i);
			i = i+1;
			conta.mostraConta();
			System.out.println("_______________________________________\n");
		}
	}
	
	public static Cliente buscaCliente() {
		System.out.println("Informe CPF do cliente: ");
		long busca = 0;
		try {
			busca = Menu.scan.nextLong();
			Menu.scan.nextLine();
		} catch (Exception e) {
			System.out.println("Erro buscando cliente!\nValor inválido!");
		}
		for (Cliente cli :listaClientes) {
			if(cli.getCpfCliente() == busca) {
				return cli;
			}
		}
		return null;
	}
	
	public static void limpaTela() {
		System.out.println("\033[2J");

	}
}
