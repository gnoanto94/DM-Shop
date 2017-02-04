package prodotti;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Questa classe è un control che serve per modificare un prodotto
 * 
 * @author Antonucci Gaetano
 * @author Pagliarulo Salvatore
 */

@WebServlet("/ButtonModificaProdottoControl")
public class ButtonModificaProdottoControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger("logger");

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int idProdotto = Integer.parseInt(request.getParameter("idModifica"));
		logger.info("Valore di idModifica ricevuto: " + idProdotto);
		Prodotto p = GestioneProdotti.ricercaProdottoPerId(idProdotto);
		
		if(p != null){
			request.setAttribute("prodotto", p);
			RequestDispatcher dispatcher = request.getRequestDispatcher("modificaProdotto.jsp");
			dispatcher.forward(request, response);
		} else {
			request.setAttribute("messaggio", "Attenzione, si è verificato un errore di caricamento");
			request.setAttribute("urlTornaIndietro", "ButtonElencoProdottiControl");
			RequestDispatcher dispatcher = request.getRequestDispatcher("notifica.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
