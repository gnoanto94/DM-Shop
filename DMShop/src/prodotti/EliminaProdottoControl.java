package prodotti;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Questa classe è un control che permette di rimuovere un prodotto nel carrello
 * 
 * @author Pagliarulo Salvatore
 */

@WebServlet("/EliminaProdottoControl")
public class EliminaProdottoControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		int id = Integer.parseInt(request.getParameter("idEliminazione"));
		
		boolean eliminato = GestioneProdotti.rimuoviProdotto(GestioneProdotti.ricercaProdottoPerId(id));
		
		if (eliminato)
		{
			request.setAttribute("messaggio", "Il prodotto è stato eliminato correttamente dal database");
			request.setAttribute("urlTornaIndietro", "ButtonElencoProdottiControl");
			RequestDispatcher dispatcher = request.getRequestDispatcher("notifica.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			request.setAttribute("messaggio", "Attenzione, non è stato possibile eliminare il prodotto dal database");
			request.setAttribute("urlTornaIndietro", "ButtonElencoProdottiControl");
			RequestDispatcher dispatcher = request.getRequestDispatcher("notifica.jsp");
			dispatcher.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
