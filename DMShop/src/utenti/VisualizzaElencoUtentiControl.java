package utenti;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Questa classe è un control che permette di visualizzare l'elenco degli utenti
 * 
 * @author Pagliarulo Salvatore
 */

@WebServlet("/VisualizzaElencoUtentiControl")
public class VisualizzaElencoUtentiControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		ArrayList<Utente> elencoClienti = GestioneUtenti.getUtenti();
		
		if (elencoClienti != null)
		{
			session.setAttribute("clienti", elencoClienti);
			RequestDispatcher dispatcher = request.getRequestDispatcher("elencoClienti.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
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
