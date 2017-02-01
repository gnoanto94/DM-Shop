package prodotti;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AggiungiProdottoControl")
public class AggiungiProdottoControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger("logger");

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String marca = request.getParameter("marca");
		String nome = request.getParameter("nome");
		String descrizione = request.getParameter("descrizione");
		int quantitaDisponibile = Integer.parseInt(request.getParameter("quantitaDisponibile"));
		double prezzoVendita = Double.parseDouble(request.getParameter("prezzo"));
		
		logger.info("Dati ricevuti dal form: " + nome + " " + marca + "\n" + descrizione + " " + quantitaDisponibile +
				"\n" + prezzoVendita);
		
		if(!GestioneProdotti.verificaEsistenzaProdotto(nome)){
			Prodotto p = new Prodotto(marca, nome, descrizione, quantitaDisponibile, prezzoVendita);

		
		boolean inserito = GestioneProdotti.aggiungiProdotto(p);
		
		if (inserito)
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("elencoProdotti.jsp");
			dispatcher.forward(request, response);  
		}
		else
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("inserimento_modificaProdotto.jsp");//notificare l'errore di inserimento/modifica
			dispatcher.forward(request, response);
		}
		
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
