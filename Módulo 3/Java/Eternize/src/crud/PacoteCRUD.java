package crud;

import java.util.Scanner;
import dao.PacoteDAO;
import model.Pacote;

public class PacoteCRUD {

	public static void main(String[] args) {
			Scanner s = new Scanner(System.in);
			
			PacoteDAO pacoteDAO = new PacoteDAO();
			int opcao = 0, id = 0;
			String nome = "";
			double valor = 0;
			do {
				System.out.println("\n*********** 	PACOTES **************\n");
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
			         
					Pacote pacote1 = new Pacote(nome,valor);
					pacoteDAO.create(pacote1);
					
					break;
				case 2:
					
					for (Pacote u : pacoteDAO.read()) {
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
					
			
					
					Pacote pacote2 = new Pacote(id,nome,valor);
					
					pacoteDAO.update(pacote2);
					
					break;
				case 4:
					System.out.println("Digite o id na qual deseja deletar");
					id = s.nextInt();
					s.nextLine();
					pacoteDAO.delete(id);
											
					break;
				case 5:
					
					System.out.println("Digite o id ");
					id = s.nextInt();
					s.nextLine();
					
					Pacote pacote3 = pacoteDAO.readById(id);
					System.out.println(pacote3.toString());
					
					break;
			default:
				break;
				}
			}while(opcao !=0);
			
			System.out.println("**Até mais***");
	  
		}



	}