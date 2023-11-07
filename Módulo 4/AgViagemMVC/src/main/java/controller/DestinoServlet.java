package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DestinoDAO;
import model.Destino;


@WebServlet(urlPatterns ={"/destino","/destino-delete"})
public class DestinoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       DestinoDAO destinoDAO = new DestinoDAO();
       Destino destino = new Destino();
   
    public DestinoServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String action = request.getServletPath();
		  switch(action) {
		  case "/destino":
			  read(request,response);
			  break;
		
		  case "/destino-delete":
			  delete(request,response);
			  break;
		
	     default:
		 //response.sendRedirect("index.html");
		 break;
		  }
	}
		  protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			    List<Destino> lista = destinoDAO.read();
			    
			   request.setAttribute("listaDestinos",lista);
			   
			   RequestDispatcher rd =request.getRequestDispatcher("./views/destino/destino.jsp");
				rd.forward(request, response);
				}
		  
		 
		  
			protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			    int id = Integer.parseInt(request.getParameter("id"));
			    destinoDAO.delete(id);
			    response.sendRedirect("destino");
				
			
			
				}
			
			
		
		
	}


