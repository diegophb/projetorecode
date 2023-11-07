package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.PacoteDAO;
import model.Pacote;


@WebServlet("/alterarpa")
public class AlterarPacoteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idPacote = Integer.parseInt(req.getParameter("id"));
		PacoteDAO cdao = new PacoteDAO();
		Pacote pacoteSelecionado = cdao.readById(idPacote);
		req.setAttribute("pacote", pacoteSelecionado);
			RequestDispatcher rd = req.getRequestDispatcher("./views/pacote/pacoteUpdate.jsp");
        rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Pacote pacoteAlterado = new Pacote();		
		pacoteAlterado.setNome(req.getParameter("nome"));
		pacoteAlterado.setValor(Double.parseDouble(req.getParameter("valor")));
		pacoteAlterado.setId(Integer.parseInt(req.getParameter("id")));
		
		PacoteDAO cd = new PacoteDAO();
		cd.update(pacoteAlterado);	
		resp.sendRedirect("pacote");
	}

}