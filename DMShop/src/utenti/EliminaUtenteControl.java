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
 * Questo classe � un control che permette di eliminare un utente
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
				logger.info("L'utente � stato eliminato");
				request.setAttribute("messaggio", "L'utente � stato eliminato correttamente dal database");
				request.setAttribute("urlTornaIndietro", "VisualizzaElencoUtentiControl");
				RequestDispatcher dispatcher = request.getRequestDispatcher("notifica.jsp");
				dispatcher.forward(request, response);
			} else {
				logger.warning("L'utente non � stato eliminato...reindirizzamento in corso...");
				request.setAttribute("cliente", u);
				request.setAttribute("messaggio", "Attenzione, non � stato possibile eliminare l'utente dal database");
				request.setAttribute("urlTornaIndietro", "datiUtente.jsp");
				RequestDispatcher dispatcher = request.getRequestDispatcher("notifica.jsp");
				dispatcher.forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
