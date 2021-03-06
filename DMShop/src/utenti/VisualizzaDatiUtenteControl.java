package utenti;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Questa classe � un control che permette di visualizzare i dati di un utente
 * 
 * @author Pagliarulo Salvatore
 */

@WebServlet("/VisualizzaDatiUtenteControl")
public class VisualizzaDatiUtenteControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger("logger");

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idUtente = Integer.parseInt(request.getParameter("idUtente"));
		HttpSession session = request.getSession();
		
		if(idUtente != 0){
			Utente u = GestioneUtenti.ricercaUtentePerId(idUtente);
			logger.info("Utente trovato: " + u);
			
			if(u != null){
				session.setAttribute("cliente", u);
				RequestDispatcher dispatcher = request.getRequestDispatcher("datiUtente.jsp");
				dispatcher.forward(request, response);
			} else {
				request.setAttribute("messaggio", "Attenzione, si � verificato un errore di caricamento");
				request.setAttribute("urlTornaIndietro", "VisualizzaElencoUtentiControl");
				RequestDispatcher dispatcher = request.getRequestDispatcher("notifica.jsp");
				dispatcher.forward(request, response);
			}
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("VisualizzaElencoUtentiControl");
			dispatcher.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
