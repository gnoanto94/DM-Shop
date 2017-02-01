package ordini;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ButtonEvadiOrdineControl")
public class ButtonEvadiOrdineControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idOrdine = Integer.parseInt(request.getParameter("idOrdine"));
		
		Ordine order = GestioneOrdini.ricercaOrdine(idOrdine);
		
		if(order.getStato() == StatiOrdine.NUOVO.getValue()){
			order.setStato(StatiOrdine.IN_LAVORAZIONE.getValue());
			
		} else {
			order.setStato(StatiOrdine.EVASO.getValue());
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
