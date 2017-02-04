package acquisti;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Questa classe è un control che serve a rimuovere un prodotto nel carrello
 * 
 * @author Pagliarulo Salvatore
 *
 */

@WebServlet("/RimuoviProdottoCarrelloControl")
public class RimuoviProdottoCarrelloControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		int idProdotto = Integer.parseInt(request.getParameter("idProdotto"));
		
		Carrello carrello = (Carrello) session.getAttribute("carrello");
		if (carrello != null)
		{
			carrello.rimuoviProdottoDalCarrello(idProdotto);
			RequestDispatcher dispatcher = request.getRequestDispatcher("carrello.jsp");
			dispatcher.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
