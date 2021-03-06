package acquisti;

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

import ordini.GestioneOrdini;
import ordini.Ordine;
import utenti.Utente;


/**
 * Questa classe � un control che serve a visualizzare l'elenco degli acquisti di un cliente selezionato o di un utente loggato
 * 
 * @author Antonucci Gaetano
 * @author Pagliarulo Salvatore
 * 
 */

@WebServlet("/StoricoAcquistiUtenteControl")
public class StoricoAcquistiUtenteControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger("logger");

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if (session != null)
		{
			Utente u = (Utente) session.getAttribute("user");
			
			if(u.getId() == 1){ //se � il gestore, visualizza l'elenco del cliente selezionato
				
				u = (Utente) session.getAttribute("cliente");
				logger.info("Sono il gestore, vedo gli acquisti di: " + u);
				ArrayList<Ordine> acquisti = GestioneOrdini.filtraOrdiniPerUtente(u.getId());
				session.setAttribute("acquisti", acquisti);
				RequestDispatcher dispatcher = request.getRequestDispatcher("storicoAcquisti.jsp");
				dispatcher.forward(request, response);
				
			} else { //altrimenti visualizza gli acquisti dell'utente loggato
				
				ArrayList<Ordine> acquisti = GestioneOrdini.filtraOrdiniPerUtente(u.getId());
				session.setAttribute("acquisti", acquisti);
				RequestDispatcher dispatcher = request.getRequestDispatcher("storicoAcquisti.jsp");
				dispatcher.forward(request, response);
			}	
		} else {
			request.setAttribute("messaggio", "Attenzione, la sessione utente � scaduta");
			request.setAttribute("urlTornaIndietro", "index.jsp");
			RequestDispatcher dispatcher = request.getRequestDispatcher("notifica.jsp");
			dispatcher.forward(request, response);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
