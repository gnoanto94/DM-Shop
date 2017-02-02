package prodotti;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EliminaProdottoControl")
public class EliminaProdottoControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		int id = Integer.parseInt(request.getParameter("idEliminazione"));
		
		boolean eliminato = GestioneProdotti.rimuoviProdotto(GestioneProdotti.ricercaProdottoPerId(id));
		
		if (eliminato)
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("ButtonElencoProdottiControl?eliminazione=success"); //messaggio di avvenuta eliminazione
			dispatcher.forward(request, response);
		}
		else
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("ButtonElencoProdottiControl?eliminazione=fail"); //messaggio di errore
			dispatcher.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
