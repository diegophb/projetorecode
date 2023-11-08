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

@WebServlet(urlPatterns ={"/reserva","/compra-edit","/compra-update","/reserva-delete"})
public class ReservaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	ReservaDAO udao = new ReservaDAO(); 
	Reserva reserva = new Reserva();
	ClienteDAO clienteDAO = new ClienteDAO();
	DestinoDAO destinoDAO = new DestinoDAO();
	PacoteDAO pacoteDAO = new PacoteDAO();
	
	String inputString = "DEFAULT";
    public ReservaServlet() {
        super();
       }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	  String action = request.getServletPath();
	  switch(action) {
	  case "/reserva":
		  read(request,response);
		  break;  
		case "/compra-edit":
			edit(request, response);
			break;
		case "/compra-update":
			update(request, response);
			break;
	//  case "/reserva-getcreate":
		 // getCreate(request,response);
		//  break;
	//  case "/reserva-edit":
		//  edit(request,response);
		//  break;
	//  case "/reserva-update":
		//  update(request,response);
		//  break;
	       
	  case "/reserva-delete":
		  delete(request,response);
		  break;
	
     default:
	 response.sendRedirect("index.html");
	 break;
	  }
	
	}

	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    List<Reserva> lista = udao.read();
    
   request.setAttribute("listaReservas",lista);
   
     List<Cliente> listaCliente = clienteDAO.read();
	 request.setAttribute("listaClientes",listaCliente);
	 List<Destino> listaDestino = destinoDAO.read();
	 request.setAttribute("listaDestinos",listaDestino);
	 List<Pacote> listaPacote = pacoteDAO.read();
	 request.setAttribute("listaPacotes",listaPacote);
   
   RequestDispatcher rd =request.getRequestDispatcher("./views/reserva/reserva.jsp");
	rd.forward(request, response);
	}
	
	
	
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
        int id = Integer.parseInt(request.getParameter("id"));
		
		reserva= udao.readById(id);
		request.setAttribute("reserva", reserva);
		
		 List<Cliente> listaCliente = clienteDAO.read();
		 request.setAttribute("listaClientes",listaCliente);
		 List<Destino> listaDestino = destinoDAO.read();
		 request.setAttribute("listaDestinos",listaDestino);
		 List<Pacote> listaPacote = pacoteDAO.read();
		 request.setAttribute("listaPacotes",listaPacote);
		
		RequestDispatcher rd = request.getRequestDispatcher("./views/reserva/update.jsp");
        rd.forward(request, response);
	}
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
      reserva.setId(Integer.parseInt(request.getParameter("id")));	
		
		reserva.setCliente(clienteDAO.readById(Integer.parseInt(request.getParameter("cliente"))));
		reserva.setDestino(destinoDAO.readById(Integer.parseInt(request.getParameter("destino"))));
		reserva.setPacote(pacoteDAO.readById(Integer.parseInt(request.getParameter("pacote"))));
		reserva.setData(request.getParameter("data"));
		
		
		
		
		udao.update(reserva);
		response.sendRedirect("reserva");
	}

	
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    int id = Integer.parseInt(request.getParameter("id"));
	    udao.delete(id);
	    response.sendRedirect("reserva");
		
	
	
		}
	
	
	
	
}
