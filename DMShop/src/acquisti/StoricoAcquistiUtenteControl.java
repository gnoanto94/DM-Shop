package acquisti;

import java.io.IOException;
import java.util.ArrayList;

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

@WebServlet("/StoricoAcquistiUtenteControl")
public class StoricoAcquistiUtenteControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if (session != null)
		{
			Utente u = (Utente) session.getAttribute("user");
			
			if(u.getId() == 1){ //se è il gestore, visualizza l'elenco del cliente selezionato
				
				u = (Utente) session.getAttribute("cliente");
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
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
