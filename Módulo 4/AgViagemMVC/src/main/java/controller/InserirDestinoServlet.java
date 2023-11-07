package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DestinoDAO;
import model.Destino;


@WebServlet("/InserirDestino")
public class InserirDestinoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DestinoDAO destinoDAO = new DestinoDAO(); 
		Destino destino = new Destino();
		String nome = request.getParameter("nome");
		double valor = Double.parseDouble(request.getParameter("valor"));

	
	    destino.setNome(nome);
	    destino.setValor(valor);
		
	     destinoDAO.create(destino);
		response.sendRedirect("destino");
	}

}
