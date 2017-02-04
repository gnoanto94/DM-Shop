package utenti;


import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Questa classe � un control che permette la registrazione di un utente
 * 
 * @author Pagliarulo Salvatore
 */

@WebServlet("/RegistrazioneControl")
public class RegistrazioneControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger("logger");

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("InputName");
		String cognome = request.getParameter("InputSurname");
		String email = request.getParameter("InputEmail");
		String password = request.getParameter("InputPassword");
		String indirizzo = request.getParameter("InputIndirizzo");
		String citta = request.getParameter("InputCitt�");
		String provincia = request.getParameter("InputProvincia");
		String telefono = request.getParameter("InputTelefono");
		
		logger.info("Dati ricevuti dal form: " + cognome + " " + nome + "\n" + email + " " + password +
				"\n" + indirizzo + "\n" + citta + " (" + provincia + ") " + "\n" + telefono);
		
		if(GestioneUtenti.verificaDisponibilitaEmail(email)){
			Utente u = new Utente(nome, cognome, email, password, indirizzo, citta, provincia, telefono);
			
			boolean inserito = GestioneUtenti.aggiungiUtente(u);
			
			if (inserito)
			{
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);  
			}
			else
			{
				RequestDispatcher dispatcher = request.getRequestDispatcher("registrazione.jsp");//notificare errore di inserimento
				dispatcher.forward(request, response);
			}
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("registrazione.jsp");//notificare errore di email gi� presente
			dispatcher.forward(request, response);
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
