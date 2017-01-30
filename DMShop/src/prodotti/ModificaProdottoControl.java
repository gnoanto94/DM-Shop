package prodotti;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		logger.info("Dati ricevuti dal form: " + nome + " " + marca + "\n" + descrizione + " " + quantitaDisponibile +
				"\n" + prezzoVendita);
		
		Prodotto p = new Prodotto(marca, nome, descrizione, quantitaDisponibile, prezzoVendita);
		p.setIdProdotto(idProdotto);
		
		boolean modificato = GestioneProdotti.modificaProdotto(p);
		
		if (modificato)
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("elencoProdotti.jsp"); //messaggio di avvenuta modifica
			dispatcher.forward(request, response);
		}
		else
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("elencoProdotti.jsp"); //messaggio di errore
			dispatcher.forward(request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
