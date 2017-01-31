package acquisti;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/AggiungiProdottoCarrelloControl")
public class AggiungiProdottoCarrelloControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession(true);
		int idProdotto = Integer.parseInt(request.getParameter("idProdotto"));
		int quantita = Integer.parseInt(request.getParameter("quantita"));
		
		Carrello carrello = (Carrello) session.getAttribute("carrello");
		if (carrello != null)
		{
			carrello.aggiungiProdottoNelCarrello(idProdotto, quantita);
		}
		else
		{
			carrello = new Carrello();
			carrello.aggiungiProdottoNelCarrello(idProdotto, quantita);
			session.setAttribute("carrello", carrello);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
