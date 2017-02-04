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
 * Questa classe è un control che permette di modificare un prodotto
 * 
 * @author Pagliarulo Salvatore
 */

@WebServlet("/ModificaProdottoControl")
public class ModificaProdottoControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger("logger");
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int idProdotto = Integer.parseInt(request.getParameter("idProdotto"));
		String marca = request.getParameter("marca");
		String nome = request.getParameter("nome");
		String descrizione = request.getParameter("descrizione");
		int quantitaDisponibile = Integer.parseInt(request.getParameter("quantitaDisponibile"));
		double prezzoVendita = Double.parseDouble(request.getParameter("prezzo"));
		String urlImmagine = request.getParameter("url_immagine");
		
		logger.info("Dati ricevuti dal form: " + nome + " " + marca + "\n" + descrizione + " " + quantitaDisponibile +
				"\n" + prezzoVendita + " " + urlImmagine);
		
		Prodotto p = new Prodotto(marca, nome, descrizione, quantitaDisponibile, prezzoVendita, urlImmagine);
		p.setIdProdotto(idProdotto);
		
		boolean modificato = GestioneProdotti.modificaProdotto(p);
		
		if (modificato)
		{
			request.setAttribute("messaggio", "Il prodotto è stato modificato correttamente nel database");
			request.setAttribute("urlTornaIndietro", "ButtonElencoProdottiControl");
			RequestDispatcher dispatcher = request.getRequestDispatcher("notifica.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			request.setAttribute("messaggio", "Attenzione, non è stato possibile modificare il prodotto nel database");
			request.setAttribute("urlTornaIndietro", "ButtonElencoProdottiControl");
			RequestDispatcher dispatcher = request.getRequestDispatcher("notifica.jsp");
			dispatcher.forward(request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
