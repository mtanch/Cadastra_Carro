package br.com.mildevs.carro;

import java.util.Scanner;

import br.com.mildevs.carro.dao.CarroDao;
import br.com.mildevs.carro.entity.Carro;

//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.Persistence;

//(inserir, listar, deletar e consultar um carro)
public class Programa {
	public static void main(String[] args) {
		
		//	criando uma tabela no banco de dados
//		EntityManagerFactory entity = Persistence.createEntityManagerFactory("public");	//	o parametro é o schema que vai usar
//		entity.close();
		
		Scanner entrada = new Scanner(System.in);
		menu(entrada);
//		entrada.close();
	}

	private static void menu(Scanner entrada) {
		System.out.println("Menu:");
		System.out.print("\nEscolha uma opção:"
						+  "\n[1] - Inserir carro"
						+  "\n[2] - Consultar carro"
						+  "\n[3] - Listar carros"
						+  "\n[4] - Remover carro"
						+  "\n[5] - Finalizar programa"
						+  "\n	=> ");
		
		int escolha = entrada.nextInt();
		
		switch (escolha) {
		case 1:
			insereCarro(entrada);
			break;
		case 2:
			consultaCarroPorPlaca(entrada);
			break;
		case 3:
			listaTodosOsCarros();
			break;
		case 4:
			removeCarro(entrada);
			break;
		case 5:
			System.out.println("\nPrograma Finalizado.");
			System.exit(0);
			break;
		default:
			break;
		}
	}

	private static void removeCarro(Scanner entrada) {
		System.out.println("Remover carro: ");
		System.out.print("Informe a placa do carro:"
				+ "\n	=> ");
		entrada.nextLine();
		String placa = entrada.nextLine();
		
		CarroDao carroDao = new CarroDao();
		carroDao.removeCarro(placa);
//		List <Carro> carros = carroDao.listaCarros("abc123");
		
		menu(entrada);
	}

	private static void listaTodosOsCarros() {
		System.out.println("Listando todos os carros: ");
		CarroDao carroDao = new CarroDao();
		System.out.println(carroDao.listarTodosOsCarros());
	}

	private static void consultaCarroPorPlaca(Scanner entrada) {
		System.out.println("Consultar carro por: ");
		
		System.out.println("[1] - Placa");
		System.out.println("[2] - Fabricante");
		
		int escolha = entrada.nextInt();
		
		CarroDao carroDao = new CarroDao();
		
		switch (escolha) {
		case 1:
			
			System.out.print("Informe a placa do carro:"
					+ "\n	=> ");
			entrada.nextLine();
			String placa = entrada.nextLine();
			
			System.out.println(carroDao.consultaCarroPorPlaca(placa));
			
			menu(entrada);
			
			break;
		case 2: 
			System.out.print("Informe a marca do carro:"
					+ "\n	=> ");
			entrada.nextLine();
			String marca = entrada.nextLine();
			
			System.out.println(carroDao.consultarCarroPorMarca(marca));
			
			menu(entrada);
			
			break;
		default:
			break;
		}
		
	}

	private static void insereCarro(Scanner entrada) {
		System.out.println("\nInforme os seguintes dados:");
		System.out.print("\n- Modelo: "
				+ "\n	=>");
		entrada.nextLine();
		String modelo = entrada.nextLine();
		System.out.print("- Marca: "
				+ "\n	=>");
		String marca = entrada.nextLine();
		System.out.print("- Placa: "
				+ "\n	=>");
		String placa = entrada.nextLine();
		System.out.print("- Cor: "
				+ "\n	=>");
		String cor = entrada.nextLine();
		System.out.print("- Velocidade máxima: "
				+ "\n	=>");
		double velMax = entrada.nextDouble();
		
		Carro carro = new Carro(placa, cor, marca, modelo, velMax);
		CarroDao carroDao = new CarroDao();
		carroDao.insereCarro(carro);
		
		menu(entrada);
	}
}
