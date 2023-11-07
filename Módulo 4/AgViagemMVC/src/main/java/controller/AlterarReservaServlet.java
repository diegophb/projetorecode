package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
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

@WebServlet("/alterarre")
public class AlterarReservaServlet extends HttpServlet {
	
	ReservaDAO udao = new ReservaDAO(); 
	Reserva reserva = new Reserva();
	ClienteDAO clienteDAO = new ClienteDAO();
	DestinoDAO destinoDAO = new DestinoDAO();
	PacoteDAO pacoteDAO = new PacoteDAO();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		reserva= udao.readById(id);
		req.setAttribute("reserva", reserva);
		
		 List<Cliente> listaCliente = clienteDAO.read();
		 req.setAttribute("listaClientes",listaCliente);
		 List<Destino> listaDestino = destinoDAO.read();
		 req.setAttribute("listaDestinos",listaDestino);
		 List<Pacote> listaPacote = pacoteDAO.read();
		 req.setAttribute("listaPacotes",listaPacote);
		
		RequestDispatcher rd = req.getRequestDispatcher("./views/reserva/reservaUpdate.jsp");
        rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		reserva.setId(Integer.parseInt(req.getParameter("id")));	
		
		reserva.setCliente(clienteDAO.readById(Integer.parseInt(req.getParameter("cliente"))));
		reserva.setDestino(destinoDAO.readById(Integer.parseInt(req.getParameter("destino"))));
		reserva.setPacote(pacoteDAO.readById(Integer.parseInt(req.getParameter("pacote"))));
		reserva.setData(req.getParameter("data"));
		
		
		udao.update(reserva);
		resp.sendRedirect("reserva");
		
		
	}

}
