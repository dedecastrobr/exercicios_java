package src;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

import tools.Menu;

public class BancoMeu {

	public static List<String> opsMenuPrincipal = Arrays.asList("Clientes", "Contas");
	public static List<String> opsMenuClientes = Arrays.asList("Cadastrar Clientes", "Consultar Clientes", "Listar Clientes");
	public static List<String> opsMenuContas = Arrays.asList("Nova Conta", "Ver Extrato", "Consultar Conta");
	public static ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
	public static ArrayList<Conta> listaContas = new ArrayList<Conta>();
	public static Scanner scan = new Scanner(System.in);
	
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
						cadastroClientes();
						break;
					case 1:	
						consultaClientes();
						break;
					case 2:
						listaClientes();
						break;
					default:
						break;
					}
					opClientes = menuClientes.getOption();
				}while (opClientes != 99);				
				break;
			case 1:
				Menu menuContas = new Menu("Contas", opsMenuContas);
				menuContas.show();
				
				int opContas = menuContas.getOption();
				do{
					switch(opContas){
					case 0:
						cadastroContas(consultaClientes());
						break;
					case 1:
						//extrato();
						break;
					case 2:
						consultaContas();
						break;
					default:
						break;
					}
					opContas = menuContas.getOption();
				}while(opContas != 99);				
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
		} while (op != 99);
	}
	
		public static void cadastroClientes(){
			Cliente cliente = new Cliente();
			if(cliente != null && cliente.getCpfCliente() != 0){
				cliente.save();
				System.out.println("---------------------------------");
				System.out.println("Cliente cadastrado com sucesso!");
				System.out.println("---------------------------------");
				cliente.mostraDados();
				System.out.println("---------------------------------");
			}else{
				System.out.println("---------------------------------");
				System.out.println("Falha no cadastro do cliente!");
				System.out.println("---------------------------------");
			}
		}
		
		public static Cliente consultaClientes(){
			long busca = 0;
			System.out.println("CPF do cliente: ");
			try{
				busca = Menu.scan.nextLong();
				Menu.scan.nextLine();
				System.out.println("---------------------------------");
				System.out.println("Cliente encontrado!");
				System.out.println("---------------------------------");
			}catch(InputMismatchException e){
				System.out.println("---------------------------------");
				System.out.println("Erro na busca do cliente! Digite apenas números!");
				System.out.println("---------------------------------");
				Menu.scan.nextLine();
			}
			for(Cliente cli: listaClientes){
				if(cli.getCpfCliente() == busca){
					return cli;
				}
			}
			return null;
		}
		
		public static void listaClientes(){
			System.out.println("Dados dos Clientes:");
			System.out.println("---------------------------------");
			int pos = 0;
			for (Cliente cliente : listaClientes){
				pos += 1;
				System.out.println("Número: "+ pos);
				cliente.mostraDados();
				System.out.println("---------------------------------");		
			}
		}
		
		public static void cadastroContas(Cliente cli){
			if(cli != null){
				Conta conta = new Conta(cli);
				conta.save();
				System.out.println("---------------------------------");
				System.out.println("Êxito na criação da conta!");
				System.out.println("---------------------------------");
				conta.mostraDados();
				System.out.println("---------------------------------");
			}else{
				System.out.println("Não foi possível criar a conta!");
				System.out.println("Cliente nulo!");
			}
		}
		
		public static void consultaContas() {
			long busca = 0;
			int pos = 0;
			System.out.println("Número da Conta do Cliente: ");
			try{
				busca = Menu.scan.nextLong();
				Menu.scan.nextLine();
				System.out.println("---------------------------------");
				System.out.println("Conta encontrada!");
				System.out.println("---------------------------------");
			}catch(InputMismatchException e){
				System.out.println("---------------------------------");
				System.out.println("Erro na busca da conta! Digite apenas números");
				System.out.println("---------------------------------");
				Menu.scan.nextLine();
			}
			for(Conta conta: listaContas){
				if(conta.getNumeroConta() == busca){
					pos += 1;
					System.out.println("Número: " + pos);
					conta.mostraDados();
				}
			}
		}
}