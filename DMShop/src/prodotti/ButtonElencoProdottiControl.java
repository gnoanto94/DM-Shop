package prodotti;

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
 * Questa classe è un control che permette di visualizzare l'elenco dei prodotti
 * 
 * @author Antonucci Gaetano
 * @author Pagliarulo Salvatore
 */
@WebServlet("/ButtonElencoProdottiControl")
public class ButtonElencoProdottiControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Prodotto> prodotti = null;
		HttpSession session = request.getSession();
		if (session != null)
		{
			prodotti = (ArrayList<Prodotto>) session.getAttribute("prodotti");
			
			if(prodotti != null){
				RequestDispatcher dispatcher = request.getRequestDispatcher("elencoProdotti.jsp");
				dispatcher.forward(request, response);
			} else {
				prodotti = GestioneProdotti.getProdotti();
				session.setAttribute("prodotti", prodotti);
				RequestDispatcher dispatcher = request.getRequestDispatcher("elencoProdotti.jsp");
				dispatcher.forward(request, response);
			}
		} else {
			request.setAttribute("messaggio", "Attenzione, la sessione utente è scaduta");
			request.setAttribute("urlTornaIndietro", "amministrazione.jsp");
			RequestDispatcher dispatcher = request.getRequestDispatcher("notifica.jsp");
			dispatcher.forward(request, response);
		}
		

		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
