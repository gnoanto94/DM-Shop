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
				Ordine nuovoOrdine = new Ordine(new Timestamp(System.currentTimeMillis()), cliente, carrello.getElementiNelCarrello(), carrello.getImporto(), StatiOrdine.NUOVO.getValue());
				GestioneOrdini.aggiungiOrdine(nuovoOrdine);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);
			} else {
				logger.info("Impossibile completare l'acquisto");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
