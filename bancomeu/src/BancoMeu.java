package src;

import java.util.Arrays;
import java.util.List;

import tools.Menu;

public class BancoMeu {

	public static List<String> opsMenuPrincipal = Arrays.asList("Clientes", "Contas");
	public static List<String> opsMenuClientes = Arrays.asList("Cadastrar Clientes", "Consultar Clientes");
	public static List<String> opsMenuContas = Arrays.asList("Nova Conta", "Ver Extrato", "Consultar Conta");

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
					case 1:
						
						break;

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
}
