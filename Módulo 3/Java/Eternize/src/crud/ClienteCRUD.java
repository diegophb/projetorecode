package crud;

import java.util.Scanner;
import dao.ClienteDAO;
import model.Cliente;

public class ClienteCRUD {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		ClienteDAO clienteDAO = new ClienteDAO();
		int opcao = 0, id = 0;
		String nome = "", email = "", telefone = "";
		do {
			System.out.println("\n*********** CLIENTES **************\n");
			System.out.println(" ***** 1 ----- CRIAR **************");
			System.out.println(" ***** 2 --- CONSULTAR ************");
			System.out.println(" ***** 3 --- ATUALIZAR ************");
			System.out.println(" ***** 4 ---- DELETAR *************");
			System.out.println(" ***** 5 - CONSULTAR POR ID *******");
			opcao = s.nextInt();
			s.nextLine();
			
			switch (opcao) {
			case 1:
				System.out.println("Digite o nome: ");
				nome = s.nextLine();
				System.out.println("Digite o telefone: ");
				telefone = s.nextLine();
				System.out.println("Digite o e-mail: ");
				email = s.nextLine();
		
				Cliente cliente1 = new Cliente(nome, telefone , email);
				clienteDAO.create(cliente1);
				break;
			case 2:
				
				for (Cliente u : clienteDAO.read()) {
					System.out.println(u.toString());
				}
				
				break;
			case 3:
				System.out.println("Digite o id: ");
				id = s.nextInt();
				s.nextLine();
				System.out.println("Digite o nome: ");
				nome = s.nextLine();
				System.out.println("Digite o telefone: ");
				telefone = s.nextLine();
				System.out.println("Digite o e-mail: ");
				email = s.nextLine();
		
				
				Cliente cliente2 = new Cliente(id,nome, telefone , email);
				
				clienteDAO.update(cliente2);
				
				break;
			case 4:
				System.out.println("Digite o id na qual deseja deletar");
				id = s.nextInt();
				s.nextLine();
				clienteDAO.delete(id);
										
				break;
			case 5:
				
				System.out.println("Digite o id ");
				id = s.nextInt();
				s.nextLine();
				
				Cliente cliente3 = clienteDAO.readById(id);
				System.out.println(cliente3.toString());
				
				break;
		default:
			break;
			}
		}while(opcao !=0);
		
		System.out.println("**Até mais***");
  
	}

}
