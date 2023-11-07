package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;
import model.Cliente;

@WebServlet("/Inserir")
public class InserirClienteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClienteDAO udao = new ClienteDAO(); 
		Cliente cliente = new Cliente();
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
	
	    cliente.setNome(nome);
	    cliente.setEmail(email);
		cliente.setTelefone(telefone);
	
		
		udao.create(cliente);
		response.sendRedirect("cliente");
		
}
}