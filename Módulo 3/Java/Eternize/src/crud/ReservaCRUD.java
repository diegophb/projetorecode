package crud;

import java.util.Date;
import java.util.Scanner;

import dao.ClienteDAO;
import dao.DestinoDAO;
import dao.PacoteDAO;
import dao.ReservaDAO;
import model.Cliente;
import model.Destino;
import model.Pacote;
import model.Reserva;


public class ReservaCRUD {

	public static void main(String[] args) {
   Scanner s = new Scanner(System.in);
   ReservaDAO reservaDAO = new ReservaDAO();
   ClienteDAO clienteDAO = new ClienteDAO();
   DestinoDAO destinoDAO = new DestinoDAO();
   PacoteDAO pacoteDAO = new PacoteDAO();
		
		int opcao = 0, idCliente=0, idDestino = 0,idPacote = 0, idReserva=0, id=0;
		Date data = new Date();
		String Data = "";
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
			
				
				System.out.println("Digite o id do cliente: ");
				idCliente = s.nextInt();
				System.out.println("Digite o id do destino:");
				idDestino = s.nextInt();
				s.nextLine();
				System.out.println("Digite o id do pacote: ");
				idPacote = s.nextInt();
				s.nextLine();
				System.out.println("Digite a data reserva: ");
				Data = s.nextLine();
				
		         
				Cliente cliente1 = clienteDAO.readById(idCliente);
				Destino destino1 = destinoDAO.readById(idDestino);
				Pacote pacote1 = pacoteDAO.readById(idPacote);
				
				
				Reserva reserva1 = new Reserva(cliente1,destino1,pacote1,Data,valor);
		         
				
				reservaDAO.create(reserva1);
				
				break;
			case 2:
				
				for (Reserva u : reservaDAO.read()) {
					u.relatar();
				}
				
				break;
			case 3:
				System.out.println("Digite o id da reserva: ");
			     idReserva = s.nextInt();
			     s.nextLine();
				System.out.println("Digite o id do cliente: ");
				idCliente = s.nextInt();
				System.out.println("Digite o id do destino:");
				idDestino = s.nextInt();
				s.nextLine();
				System.out.println("Digite o id do pacote: ");
				idPacote = s.nextInt();
				s.nextLine();
				System.out.println("Digite a data reserva: ");
				Data = s.nextLine();
				
				Cliente cliente2 = clienteDAO.readById(idCliente);
				Destino destino2 = destinoDAO.readById(idDestino);
				Pacote pacote2 = pacoteDAO.readById(idPacote);
				
				Reserva reserva2 = new Reserva(idReserva,cliente2,destino2,pacote2,Data,valor);
				
				reservaDAO.update(reserva2);
				
				break;
			case 4:
			System.out.println("Digite o id na qual deseja deletar");
			id = s.nextInt();
				s.nextLine();
				reservaDAO.delete(id);
										
				break;
			case 5:
				
				System.out.println("Digite o id ");
			id = s.nextInt();
			s.nextLine();
				
			Reserva reserva3 = reservaDAO.readById(id);
		//	System.out.println(reserva3.toString());
			reserva3.relatar();
				break;
		default:
			break;
			}
		}while(opcao !=0);
		
		System.out.println("**Até mais***");
  
	}



}


