package ordini;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ButtonGestioneOrdiniControl")
public class ButtonGestioneOrdiniControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ArrayList<Ordine> ordiniNuovi = GestioneOrdini.filtraOrdiniPerStato(StatiOrdine.NUOVO.getValue());
		ArrayList<Ordine> ordiniInLavorazione = GestioneOrdini.filtraOrdiniPerStato(StatiOrdine.IN_LAVORAZIONE.getValue());
		
		if(ordiniNuovi != null && ordiniInLavorazione != null){
			session.setAttribute("ordiniNuovi", ordiniNuovi);
			session.setAttribute("ordiniInLavorazione", ordiniInLavorazione);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("ordini.jsp");
			dispatcher.forward(request, response);
		} else {
			//errore
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
