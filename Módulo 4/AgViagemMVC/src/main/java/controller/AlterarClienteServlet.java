package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;
import dao.DestinoDAO;
import model.Cliente;
import model.Destino;


@WebServlet("/alterar")
public class AlterarClienteServlet extends HttpServlet {
	
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idCliente = Integer.parseInt(request.getParameter("id"));
		ClienteDAO cdao = new ClienteDAO();
		Cliente clienteSelecionado = cdao.readById(idCliente);
		request.setAttribute("cliente", clienteSelecionado);
			RequestDispatcher rd = request.getRequestDispatcher("./views/cliente/clienteUpdate.jsp");
        rd.forward(request, response);
		
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Cliente clienteAlterado = new Cliente();		
    	clienteAlterado.setNome(request.getParameter("nome"));
    	clienteAlterado.setEmail(request.getParameter("email"));
    	clienteAlterado.setTelefone(request.getParameter("telefone"));
    	clienteAlterado.setId(Integer.parseInt(request.getParameter("id")));
		
		ClienteDAO cd = new ClienteDAO();
		cd.update(clienteAlterado);	
		response.sendRedirect("cliente");
	}

}
