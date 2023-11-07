package controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DestinoDAO;
import model.Destino;



@WebServlet("/editar")
public class AlterarDestinoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idDestino = Integer.parseInt(req.getParameter("id"));
		DestinoDAO cdao = new DestinoDAO();
		Destino destinoSelecionado = cdao.readById(idDestino);
		req.setAttribute("destino", destinoSelecionado);
			RequestDispatcher rd = req.getRequestDispatcher("./views/destino/destinoUpdate.jsp");
        rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Destino destinoAlterado = new Destino();		
		destinoAlterado.setNome(req.getParameter("nome"));
		destinoAlterado.setValor(Double.parseDouble(req.getParameter("valor")));
		destinoAlterado.setId(Integer.parseInt(req.getParameter("id")));
		
		DestinoDAO cd = new DestinoDAO();
		cd.update(destinoAlterado);	
		resp.sendRedirect("destino");
	}

}
