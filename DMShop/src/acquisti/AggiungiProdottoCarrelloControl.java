package acquisti;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/AggiungiProdottoCarrelloControl")
public class AggiungiProdottoCarrelloControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger("logger");
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession(true);
		int idProdotto = Integer.parseInt(request.getParameter("idProdotto"));
		int quantita = Integer.parseInt(request.getParameter("quantita"));
		
		Carrello carrello = null;
		
		if(session != null){
			carrello = (Carrello) session.getAttribute("carrello");
		} else {
			logger.info("La sessione è nulla");
		}
		
		if (carrello != null)
		{
			carrello.aggiungiProdottoNelCarrello(idProdotto, quantita);
			RequestDispatcher dispatcher = request.getRequestDispatcher("carrello.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			logger.info("il carrello non esiste...ora viene creato");
			carrello = new Carrello();
			carrello.aggiungiProdottoNelCarrello(idProdotto, quantita);
			session.setAttribute("carrello", carrello);
			RequestDispatcher dispatcher = request.getRequestDispatcher("carrello.jsp");
			dispatcher.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
