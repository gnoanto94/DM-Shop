package utenti;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

import database.Database;
import ordini.GestioneOrdini;
import ordini.Ordine;

/**
 * Questa classe rappresenta un manager per gestire gli utenti
 * 
 * @author Antonucci Gaetano
 * @author Pagliarulo Salvatore
 */

public class GestioneUtenti {

	public static ArrayList<Utente> getUtenti() {
		return utenti;
	}

	@Override
	public String toString() {
		return getClass().getName()+" [utenti=" + utenti + "]";
	}

	/**
	 * Questo metodo serve a verificare le credenziali di utente
	 * 
	 * @param email - email di un utente
	 * @param password - password di un utente
	 * @return utente con email e password specificati<br/>
	 * {@code null} se l'utente non con email e password specificati non è presente
	 * 
	 * @author Antonucci Gaetano
	 * @author Pagliarulo Salvatore
	 */
	public static Utente verificaCredenziali(String email, String password){
		Utente utente = null;
		
		logger.info("Controllo su credenziali utente...");
		for(Utente u: utenti){
			if(u.getEmail().equals(email) && u.getPassword().equals(password)){
				utente = u;
				logger.info("Utente trovato");
				break;
			}
		}
		return utente;
	}
	
	/**
	 * Questo metodo serve a cercare un utente in base al suo id
	 * 
	 * @param idCliente - identificativo del cliente da cercare
	 * @return cliente cercato<br/>
	 * {@code null} se il cliente non è presente
	 * 
	 * @author Pagliarulo Salvatore
	 */
	public static Utente ricercaUtentePerId(int idCliente) {
		Utente risultato = null;
		
		for(Utente u: utenti){
			if(u.getId() == idCliente){
				risultato = u;
				break;
			}
		}
		
		return risultato;
	}
	
	/**
	 * Questo metodo serve ad aggiungere un utente
	 * 
	 * @param u - utente da aggiungere
	 * @return {@code true} se l'utente è stato aggiunto correttamente<br/>
	 * {@code false} se l'utente non è stato aggiunto correttamente
	 * 
	 * @author Antonucci Gaetano
	 */
	public static boolean aggiungiUtente(Utente u) {
		
		boolean inserito = false;
		
		if(u != null){
			
			if (!utenti.contains(u)) //se è già presente non viene aggiunto
				utenti.add(u); //Aggiunta utente nella lista
			
			//Aggiunta Utente al database
			statement = Database.getPreparedStatement(INSERT_QUERY);
			try {
				u.setId(++ultimoIdUtente);
				statement.setInt(1, u.getId());
				statement.setString(2, u.getCognome());
				statement.setString(3, u.getNome());
				statement.setString(4, u.getEmail());
				statement.setString(5, u.getPassword());
				statement.setString(6, u.getIndirizzo());
				statement.setString(7, u.getCitta());
				statement.setString(8, u.getProvincia());
				statement.setString(9, u.getTelefono());
				
				int result = statement.executeUpdate();
				
				if(result > 0){
					logger.info("Utente inserito correttamente nel database");
					inserito = true;
					Database.closeConnection(); //chiudi connessione al db
				}
				
			} catch (SQLException e) {
				logger.severe("Sollevata eccezione: " + e.getMessage());
				e.printStackTrace();
			}
		}
			return inserito;
		}
	
	/**
	 * Questo metodo serve a rimuovere un utente
	 * 
	 * @param u - utente da rimuovere
	 * @return {@code true} se l'utente è stato rimosso correttamente<br/>
	 * {@code false} se l'utente non è stato rimosso correttamente
	 * 
	 * @author Antonucci Gaetano
	 */
	public static boolean rimuoviUtente(Utente u) {
		
		boolean eliminato = false;
		
		if(u != null){
			
			//prima di rimuovere l'utente è necessario verificare che non ci siano ordini da lui effettuati
			//se esistono bisogna cancellare prima gli ordini altrimenti il db darà errore
			
			ArrayList<Ordine> ordiniCliente = GestioneOrdini.filtraOrdiniPerUtente(u.getId());
			
			if(ordiniCliente.size() > 0){
				for(Ordine ord: ordiniCliente){
					GestioneOrdini.rimuoviOrdine(ord);
				}
			}
			
			//dopo aver verificato si può rimuovere l'utente
			
			if (utenti.contains(u))
				utenti.remove(u);		
			
			statement = Database.getPreparedStatement(REMOVE_QUERY);
			try {
				statement.setInt(1, u.getId());
				
				int result = statement.executeUpdate();
				
				if(result > 0){
					logger.info("Utente cancellato correttamente nel database");
					eliminato = true;
					Database.closeConnection(); //chiudi connessione al db
				}
			} catch (SQLException e) {
				logger.severe("Sollevata eccezione: " + e.getMessage());
				e.printStackTrace();
			}
		}
		
		
		return eliminato;
	}
	
	/**
	 * Questo metodo serve a verificare la disponibilità dell'email si un utente
	 * 
	 * @param email - email dell'utente
	 * @return {@code true} se l'email è disponibile<br/>
	 * {@code false} se l'email non è disponibile
	 * 
	 * @author Antonucci Gaetano
	 */
	public static boolean verificaDisponibilitaEmail(String email){
		
		boolean verifica = true;
		
		for(Utente u: utenti){
			if(u.getEmail().equals(email)){
				verifica = false;
				break;
			}
		}
		return verifica;
	}
	
	/**
	 * Questo metodo serve ad importare gli utenti dal database
	 * 
	 * @author Antonucci Gaetano
	 */
	public static void importaUtenti(){
		try {
			ResultSet utenti = Database.executeQuery(IMPORT_QUERY);
			Utente user = null;
			int id;
			String cognome, nome, email, password, indirizzo, citta, provincia, telefono;
			
			
			utenti.last();
			ultimoIdUtente = utenti.getInt("id");
			utenti.beforeFirst();
			logger.info("L'ultimo id dell'utente è " + ultimoIdUtente);
			
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
		Database.closeConnection(); //chiudi connessione al db
	}
	
	private static final Logger logger = Logger.getLogger("logger");
	private static final String INSERT_QUERY = "INSERT INTO utenti (id, cognome, nome, email, password, indirizzo, citta, provincia, telefono) VALUES (?, ?,?,?,?,?,?,?,?)";
	private static final String IMPORT_QUERY = "SELECT * FROM utenti";
	private static final String REMOVE_QUERY = "DELETE FROM utenti WHERE id=?";
	
	private static PreparedStatement statement;
	private static ArrayList<Utente> utenti;
	private static int ultimoIdUtente;
	
	static {
		utenti = new ArrayList<Utente>();
		ultimoIdUtente = 0;
		importaUtenti();
		
	}

}
