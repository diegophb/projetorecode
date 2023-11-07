package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;
import dao.DestinoDAO;
import dao.PacoteDAO;
import dao.ReservaDAO;
import model.Cliente;
import model.Destino;
import model.Pacote;
import model.Reserva;

@WebServlet("/inserirre")
public class InserirReservaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ReservaDAO udao = new ReservaDAO(); 
		Reserva reserva = new Reserva();
		ClienteDAO clienteDAO = new ClienteDAO();
		DestinoDAO destinoDAO = new DestinoDAO();
		PacoteDAO pacoteDAO = new PacoteDAO();
		
		
		Cliente cliente = clienteDAO.readById(Integer.parseInt(request.getParameter("cliente")));
		Destino destino = destinoDAO.readById(Integer.parseInt(request.getParameter("destino")));
		Pacote pacote = pacoteDAO.readById(Integer.parseInt(request.getParameter("pacote")));
		
		String data = request.getParameter("data");
		reserva = new Reserva(cliente,destino,pacote,data);
		
	    udao.create(reserva);
	    response.sendRedirect("reserva");
		
	
	
		}
}
