package utenti;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

import database.Database;

public class GestioneUtenti {

	public static ArrayList<Utente> getUtenti() {
		return utenti;
	}

	@Override
	public String toString() {
		return getClass().getName()+" [utenti=" + utenti + "]";
	}

	public static Utente verificaCredenziali(String email, String password){
		Utente utente = null;
		
		for(Utente u: utenti){
			if(u.getEmail().equals(email) && u.getPassword().equals(password)){
				utente = u;
				break;
			}
		}
		return utente;
	}
	public static boolean aggiungiUtente(Utente u) {
		
		boolean inserito = false;
		
		if(u != null){
			
			if (!utenti.contains(u)) //Aggiunta utente nella lista
				utenti.add(u);}
			
			//Aggiunta Utente al database
			statement = Database.getPreparedStatement(INSERT_QUERY);
			try {
				statement.setString(1, u.getCognome());
				statement.setString(2, u.getNome());
				statement.setString(3, u.getEmail());
				statement.setString(4, u.getPassword());
				statement.setString(5, u.getIndirizzo());
				statement.setString(6, u.getCitta());
				statement.setString(7, u.getProvincia());
				statement.setString(8, u.getTelefono());
				
				int result = statement.executeUpdate();
				
				if(result > 0){
					logger.info("Utente inserito correttamente nel database");
					inserito = true;
				}
				
			} catch (SQLException e) {
				logger.severe("Sollevata eccezione: " + e.getMessage());
				e.printStackTrace();
			}
			
			return inserito;
		}
	
	public static boolean rimuoviUtente(Utente u) {
		
		boolean eliminato = false;
		
		if (utenti.contains(u))
			utenti.remove(u);		
		
		statement = Database.getPreparedStatement(REMOVE_QUERY);
		try {
			statement.setInt(1, u.getId());
			
			int result = statement.executeUpdate();
			
			if(result > 0){
				logger.info("Utente cancellato correttamente nel database");
				eliminato = true;
			}
		} catch (SQLException e) {
			logger.severe("Sollevata eccezione: " + e.getMessage());
			e.printStackTrace();
		}
		
		return eliminato;
	}
	
	public static void importaUtenti(){
		try {
			ResultSet utenti = Database.executeQuery(IMPORT_QUERY);
			Utente user = null;
			int id;
			String cognome, nome, email, password, indirizzo, citta, provincia, telefono;
			
			while(utenti.next()){
				id = utenti.getInt("id");
				cognome = utenti.getString("cognome");
				nome = utenti.getString("nome");
				email = utenti.getString("email");
				password = utenti.getString("password");
				indirizzo = utenti.getString("indirizzo");
				citta = utenti.getString("citta");
				provincia = utenti.getString("provincia");
				telefono = utenti.getString("telefono");
				
				user = new Utente(nome, cognome, email, password, indirizzo, citta, provincia, telefono);
				user.setId(id);
				
				if(!GestioneUtenti.utenti.contains(user)){
					GestioneUtenti.utenti.add(user);
				}
			}
		} catch (SQLException e) {
			logger.severe("Sollevata eccezione: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	private static final Logger logger = Logger.getLogger("logger");
	private static final String INSERT_QUERY = "INSERT INTO utenti (cognome, nome, email, password, indirizzo, citta, provincia, telefono) VALUES (?,?,?,?,?,?,?,?)";
	private static final String IMPORT_QUERY = "SELECT * FROM utenti";
	private static final String REMOVE_QUERY = "DELETE FROM utenti WHERE id=?";
	
	private static PreparedStatement statement;
	private static ArrayList<Utente> utenti;
	
	static {
		utenti = new ArrayList<Utente>();
		importaUtenti();
		
	}
	   
    public static void main(String[] args) {
		Utente u = new Utente("Mario", "Rossi", "email@email.com", "P@ssw0rd", "Via III, 123", "Salerno", "SA", "089-772233");
		GestioneUtenti.aggiungiUtente(u);
	}
}
