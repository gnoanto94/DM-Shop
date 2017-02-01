package prodotti;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/VisualizzaProdottoControl")
public class VisualizzaProdottoControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger("logger");
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int idVisualizza = Integer.parseInt(request.getParameter("idVisualizza"));
		logger.info("Valore di idVisualizza= "+idVisualizza);
		Prodotto p = GestioneProdotti.ricercaProdottoPerId(idVisualizza);
		
		if ( p != null)
		{
			request.setAttribute("prodotto", p);
			RequestDispatcher dispatcher = request.getRequestDispatcher("prodotto.jsp");
			dispatcher.forward(request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}