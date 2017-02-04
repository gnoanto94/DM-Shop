package utenti;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Questa classe è un control che permette di visualizzare i dati di un utente
 * 
 * @author Pagliarulo Salvatore
 */

@WebServlet("/VisualizzaDatiUtenteControl")
public class VisualizzaDatiUtenteControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idUtente = Integer.parseInt(request.getParameter("idUtente"));
		
		if(idUtente != 0){
			Utente u = GestioneUtenti.ricercaUtentePerId(idUtente);
			
			if(u != null){
				request.setAttribute("cliente", u);
				RequestDispatcher dispatcher = request.getRequestDispatcher("datiUtente.jsp");
				dispatcher.forward(request, response);
			} else {
				request.setAttribute("messaggio", "Attenzione, si è verificato un errore di caricamento");
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
