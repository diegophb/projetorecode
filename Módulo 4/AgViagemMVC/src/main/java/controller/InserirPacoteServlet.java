package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PacoteDAO;
import model.Pacote;


@WebServlet("/InserirPa")
public class InserirPacoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PacoteDAO pacoteDAO = new PacoteDAO(); 
		Pacote pacote = new Pacote();
		String nome = request.getParameter("nome");
		double valor = Double.parseDouble(request.getParameter("valor"));

	
	    pacote.setNome(nome);
	    pacote.setValor(valor);
		
	     pacoteDAO.create(pacote);
		response.sendRedirect("pacote");
	}

}