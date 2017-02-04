package utenti;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Questo classe è un control che permette di eliminare un utente
 * 
 * @author Pagliarulo Salvatore
 */

@WebServlet("/EliminaUtenteControl")
public class EliminaUtenteControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger("logger");

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idUtente = Integer.parseInt(request.getParameter("idUtente"));
		boolean eliminato = false;
		Utente u = null;
		
		if(idUtente != 0){
			u = GestioneUtenti.ricercaUtentePerId(idUtente);
			
			if(u != null){
				eliminato = GestioneUtenti.rimuoviUtente(u);
			}

			if(eliminato){
				logger.info("L'utente è stato eliminato");
				RequestDispatcher dispatcher = request.getRequestDispatcher("VisualizzaElencoUtentiControl");
				dispatcher.forward(request, response);
			} else {
				logger.warning("L'utente non è stato eliminato...reindirizzamento in corso...");
				request.setAttribute("cliente", u);
				RequestDispatcher dispatcher = request.getRequestDispatcher("datiUtente.jsp");
				dispatcher.forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
