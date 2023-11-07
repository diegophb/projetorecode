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
import model.Cliente;



@WebServlet(urlPatterns ={"/cliente","/cliente-delete"})
public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	ClienteDAO udao = new ClienteDAO(); 
	Cliente cliente = new Cliente();
	
    public ClienteServlet() {
        super();
       }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	  String action = request.getServletPath();
	  switch(action) {
	  case "/cliente":
		  read(request,response);
		  break;
	  case "/cliente-delete":
		  delete(request,response);
		  break;
	
     default:
	// response.sendRedirect("index.html");
	 break;
	  }
	
	}
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    List<Cliente> lista = udao.read();
    
   request.setAttribute("listaClientes",lista);
   
   RequestDispatcher rd =request.getRequestDispatcher("./views/cliente/index.jsp");
	rd.forward(request, response);
	}
	
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    int id = Integer.parseInt(request.getParameter("id"));
	    udao.delete(id);
	    response.sendRedirect("cliente");
		
	
	
		}
	
	
	
	
}
