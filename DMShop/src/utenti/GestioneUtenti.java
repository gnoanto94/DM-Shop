package utenti;

import java.sql.PreparedStatement;
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

	public static void aggiungiUtente(Utente u) {
		
		boolean inserito = false;
		
		if(u != null){
			
			if (!utenti.contains(u)) //Aggiunta utente nella lista
				utenti.add(u);}
			/*
			//Aggiunta Utente al database
			PreparedStatement statement = Database.getPreparedStatement(INSERT_QUERY);
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
				logger.warning("Sollevata eccezione: " + e.getMessage());
				e.printStackTrace();
			}
		}
		
		//return inserito;
		*/
	}
	
	public static void rimuoviUtente(Utente u) {
		if (utenti.contains(u))
			utenti.remove(u);		
	}
	
	private static final Logger logger = Logger.getLogger("logger");
	private static final String INSERT_QUERY = "INSERT INTO utenti (cognome, nome, email, password, indirizzo, citta, provincia, telefono) VALUES (?,?,?,?,?,?,?,?)";
	private static ArrayList<Utente> utenti;
	
	static {
		utenti=new ArrayList<Utente>();
	}

}
