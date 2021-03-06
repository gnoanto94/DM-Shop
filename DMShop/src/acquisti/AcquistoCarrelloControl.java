package acquisti;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ordini.GestioneOrdini;
import ordini.Ordine;
import ordini.StatiOrdine;
import utenti.Utente;

/**
 * Questa classe � un control che serve ad acquistare i prodotti nel carrello
 * 
 * @author Antonucci Gaetano
 * @author Pagliarulo Salvatore
 *
 */
@WebServlet("/AcquistoCarrelloControl")
public class AcquistoCarrelloControl extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger("logger");

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if(session != null){
			Carrello carrello = (Carrello) session.getAttribute("carrello"); 
			Utente cliente = (Utente) session.getAttribute("user");
			
			if(carrello != null && cliente != null){
				//creo un nuovo ordine
				Ordine nuovoOrdine = new Ordine(new Timestamp(System.currentTimeMillis()), cliente, carrello.getElementiNelCarrello(), carrello.getImporto(), StatiOrdine.NUOVO.getValue());
				//memorizzo il nuovo ordine
				GestioneOrdini.aggiungiOrdine(nuovoOrdine);
				//cancello il carrello dalla sessione
				session.removeAttribute("carrello");
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("storicoAcquisti.jsp");
				dispatcher.forward(request, response);
			} else if(cliente == null){
				logger.info("Impossibile completare l'acquisto perch� il cliente non � loggato");
				
				request.setAttribute("messaggio", "Attenzione, non si � eseguito il login al sito, se non si possiede un accounte si � pregati di Registrarsi");
				request.setAttribute("urlTornaIndietro", "carrello.jsp");
				RequestDispatcher dispatcher = request.getRequestDispatcher("notifica.jsp");
				dispatcher.forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
