package crud;

import java.util.Scanner;
import dao.DestinoDAO;
import model.Destino;

public class DestinoCRUD {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		DestinoDAO destinoDAO = new DestinoDAO();
		int opcao = 0, id = 0;
		String nome = "";
		double valor = 0;
		do {
			System.out.println("\n*********** 	DESTINOS **************\n");
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
				System.out.println("Digite o valor: ");
				valor = s.nextDouble();
		         s.nextLine();
		         
				Destino destino1 = new Destino(nome,valor);
				destinoDAO.create(destino1);
				
				break;
			case 2:
				
				for (Destino u : destinoDAO.read()) {
					System.out.println(u.toString());
				}
				
				break;
			case 3:
				System.out.println("Digite o id: ");
				id = s.nextInt();
				s.nextLine();
				System.out.println("Digite o nome: ");
				nome = s.nextLine();
				System.out.println("Digite o valor: ");
				valor = s.nextDouble();
				
		
				
				Destino destino2 = new Destino(id,nome,valor);
				
				destinoDAO.update(destino2);
				
				break;
			case 4:
				System.out.println("Digite o id na qual deseja deletar");
				id = s.nextInt();
				s.nextLine();
				destinoDAO.delete(id);
										
				break;
			case 5:
				
				System.out.println("Digite o id ");
				id = s.nextInt();
				s.nextLine();
				
				Destino destino3 = destinoDAO.readById(id);
				System.out.println(destino3.toString());
				
				break;
		default:
			break;
			}
		}while(opcao !=0);
		
		System.out.println("**Até mais***");
  
	}



}


