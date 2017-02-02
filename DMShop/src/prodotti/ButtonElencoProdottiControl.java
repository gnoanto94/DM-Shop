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

@WebServlet("/ButtonElencoProdottiControl")
public class ButtonElencoProdottiControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Prodotto> prodotti = GestioneProdotti.getProdotti();
		HttpSession session = request.getSession();
		if (session != null)
		{
			session.setAttribute("prodotti", prodotti);
			RequestDispatcher dispatcher = request.getRequestDispatcher("elencoProdotti.jsp");
			dispatcher.forward(request, response);
		}
		

		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
