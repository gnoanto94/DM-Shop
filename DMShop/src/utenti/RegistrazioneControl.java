package utenti;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RegistrazioneControl")
public class RegistrazioneControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("InputName");
		String cognome = request.getParameter("InputSurname");
		String email = request.getParameter("InputEmail");
		String password = request.getParameter("InputPassword");
		String indirizzo = request.getParameter("InputIndirizzo");
		String citta = request.getParameter("InputCittà");
		String provincia = request.getParameter("InputProvincia");
		String telefono = request.getParameter("InputTelefono");
		
		Utente u = new Utente(nome, cognome, email, password, indirizzo, citta, provincia, telefono);
		
		GestioneUtenti.aggiungiUtente(u);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
