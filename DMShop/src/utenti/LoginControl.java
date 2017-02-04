package utenti;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Questa classe è un control che permette il login ad un utente
 * 
 * @author Pagliarulo Salvatore
 */

@WebServlet("/LoginControl")
public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger("logger");

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		String email = request.getParameter("loginEmail");
		String password = request.getParameter("loginPassword");
		
		Utente user = GestioneUtenti.verificaCredenziali(email, password);
		
		if(user != null){
			session.setAttribute("hello", user.getNome());
			session.setAttribute("id", user.getId());
			session.setAttribute("user", user);
			logger.info("Login eseguito");
			RequestDispatcher dispatcher = request.getRequestDispatcher("accountUtente.jsp");
			dispatcher.forward(request, response);
		} else {
			logger.severe("Errore: impossibile eseguire login");
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
