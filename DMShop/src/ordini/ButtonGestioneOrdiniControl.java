package ordini;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Questa classe è un control che si attiva al momento del click sul button per gestire gli ordini e permette di visualizzare l'elenco degli ordini
 * 
 * @author Antonucci Gaetano
 * @author Pagliarulo Salvatore
 */
@WebServlet("/ButtonGestioneOrdiniControl")
public class ButtonGestioneOrdiniControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger("logger");

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		ArrayList<Ordine> ordiniNuovi = GestioneOrdini.filtraOrdiniPerStato(StatiOrdine.NUOVO.getValue());
		ArrayList<Ordine> ordiniInLavorazione = GestioneOrdini.filtraOrdiniPerStato(StatiOrdine.IN_LAVORAZIONE.getValue());
		logger.info("Size ordiniNuovi: " + ordiniNuovi.size() + "\nSize ordiniInLav: " + ordiniInLavorazione.size());
		
		if(session != null && ordiniNuovi != null && ordiniInLavorazione != null){
			session.setAttribute("ordiniNuovi", ordiniNuovi);
			session.setAttribute("ordiniInLavorazione", ordiniInLavorazione);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("ordini.jsp");
			dispatcher.forward(request, response);
		} else {
			request.setAttribute("messaggio", "Attenzione, si è verificato un errore di caricamento");
			request.setAttribute("urlTornaIndietro", "amministrazione.jsp");
			RequestDispatcher dispatcher = request.getRequestDispatcher("notifica.jsp");
			dispatcher.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
