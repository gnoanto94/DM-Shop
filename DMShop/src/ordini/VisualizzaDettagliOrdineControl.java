package ordini;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ordini.GestioneOrdini;
import ordini.Ordine;

/**
 * Questa classe � un control che permette di visualizzare i dettagli di un ordine specifico
 * 
 * @author Pagliarulo Salvatore
 */
@WebServlet("/VisualizzaDettagliOrdineControl")
public class VisualizzaDettagliOrdineControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger("logger");

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int idVisualizzaOrdine = Integer.parseInt(request.getParameter("idVisualizzaOrdine"));
		logger.info("Valore di idVisualizzaOrdine= "+idVisualizzaOrdine);
		Ordine o = GestioneOrdini.ricercaOrdine(idVisualizzaOrdine);
		
		if (o != null)
		{
			request.setAttribute("ordine", o);
			RequestDispatcher dispatcher = request.getRequestDispatcher("ordine.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			request.setAttribute("messaggio", "Attenzione, si � verificato un errore di caricamento");
			request.setAttribute("urlTornaIndietro", "amministrazione.jsp");
			RequestDispatcher dispatcher = request.getRequestDispatcher("notifica.jsp");
			dispatcher.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
