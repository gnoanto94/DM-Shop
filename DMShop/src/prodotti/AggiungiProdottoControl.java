package prodotti;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AggiungiProdottoControl")
public class AggiungiProdottoControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	/*
		String marca = request.getParameter("InputMarca");
		String nome = request.getParameter("InputNome");
		String descrizione = request.getParameter("InputDescrizione");
		int quantitaDisponibile = Integer.parseInt(request.getParameter("InputQuantitaDisponiible"));
		double prezzoVendita = Double.parseDouble(request.getParameter("InputPrezzoVendita"));
		
		Prodotto p = new Prodotto(marca, nome, descrizione, quantitaDisponibile, prezzoVendita);
		
		GestioneProdotti.aggiungiProdotto(p);
		
	*/
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
