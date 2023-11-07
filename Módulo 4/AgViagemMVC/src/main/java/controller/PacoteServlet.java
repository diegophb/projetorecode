package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PacoteDAO;
import model.Destino;
import model.Pacote;


@WebServlet(urlPatterns ={"/pacote","/pacote-delete"})
public class PacoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       PacoteDAO pacoteDAO = new PacoteDAO();
       Destino destino = new Destino();
   
    public PacoteServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String action = request.getServletPath();
		  switch(action) {
		  case "/pacote":
			  read(request,response);
			  break;
		  case "/pacote-delete":
			  delete(request,response);
			  break;
		
	     default:
		// response.sendRedirect("index.html");
		 break;
		  }
	}
		  protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			    List<Pacote> lista = pacoteDAO.read();
			    
			   request.setAttribute("listaPacotes",lista);
			   
			   RequestDispatcher rd =request.getRequestDispatcher("./views/pacote/pacote.jsp");
				rd.forward(request, response);
				}
		  
			protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			    int id = Integer.parseInt(request.getParameter("id"));
			    pacoteDAO.delete(id);
			    response.sendRedirect("pacote");
				
			
			
				}
		
		
	}
