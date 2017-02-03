package ordini;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Logger;

import database.Database;
import prodotti.GestioneProdotti;
import prodotti.Prodotto;
import utenti.GestioneUtenti;
import utenti.Utente;

public class GestioneOrdini {


	public static ArrayList<Ordine> getOrdini() {
		return ordini;
	}


	@Override
	public String toString() {
		return getClass().getName()+" [ordini=" + ordini + "]";
	}
	
	private static boolean memorizzaDettagliOrdine(Ordine o){
		boolean dettagliInseriti = false;
		int addedDetails = 0;
		
		statement = Database.getPreparedStatement(INSERT_DETTAGLI_QUERY);
		ArrayList<DettagliOrdine> dettagliOrdine = o.getDettagli();
		
		for(DettagliOrdine d: dettagliOrdine){
			try {
				d.setIdDettagliOrdine(++ultimoIdDettagliordine);
				statement.setInt(1, d.getIdDettagliOrdine());
				statement.setInt(2, o.getIdOrdine());
				statement.setInt(3, d.getProdotto().getIdProdotto());
				statement.setInt(4, d.getQuantita());
				statement.setDouble(5, d.getPrezzo());
				
				int result = statement.executeUpdate();
				
				if(result > 0){
					logger.info("Dettaglio inserito correttamente nel database");
					addedDetails++;
				}
				
			} catch (SQLException e) {
				logger.severe("Sollevata Eccezione: " + e.getMessage());
				e.printStackTrace();
			}
			}
		
		if(dettagliOrdine.size() == addedDetails){// verifica che i dettagli inseriti siano tutti
			dettagliInseriti = true;
		}
		
		return dettagliInseriti;
	}
	
	public static boolean aggiungiOrdine(Ordine o) {
		
		boolean inserimento = false;
		boolean ordineInserito = false;
		
		if(o != null){
			if (!ordini.contains(o)) //se l'ordine non è presente nella lista
				ordini.add(o); 		 //allora viene aggiunto
			
			//Aggiunta al database
			statement = Database.getPreparedStatement(INSERT_ORDINE_QUERY);
			try {
				o.setIdOrdine(++ultimoIdOrdine);
				statement.setInt(1, o.getIdOrdine());
				statement.setTimestamp(2, o.getData());
				statement.setInt(3, o.getCliente().getId());
				statement.setDouble(4, o.getImporto());
				statement.setInt(5, o.getStato());
				
				int result = statement.executeUpdate();
				
				if(result > 0){
					logger.info("Ordine inserito correttamente nel database");
					ordineInserito = true;
				}
				
				boolean dettagliInseriti = memorizzaDettagliOrdine(o);
				
				if(ordineInserito && dettagliInseriti){//Se l'ordine e i dettagli sono stati inserito l'inserimento va a buon fine
					inserimento = true;
				}
				
			} catch (SQLException e) {
				logger.severe("Sollevata Eccezione: " + e.getMessage());
				e.printStackTrace();
			}	
		}
		
		return inserimento;
	}
	
	public static boolean rimuoviOrdine(Ordine o) {
		
		boolean dettaglEliminati = false;
		boolean ordineEliminato = false;
		boolean eliminato = false;
		
		if(o != null){
			if (ordini.contains(o)) //se l'ordine è presente nella lista
				ordini.remove(o);	//allora rimuovilo
			
			//rimozione dal database
			
			//bisogna rimuovere prima i dettagli altrimenti si avrebbero delle tuple orfane
			statement = Database.getPreparedStatement(REMOVE_DETTAGLI_QUERY);
			
			try {
				statement.setInt(1, o.getIdOrdine());
				
				int result = statement.executeUpdate();
				
				if(result > 0){
					logger.info("Dettagli dell'ordine rimossi correttamente dal database");
					dettaglEliminati = true;
					
					//se i dettagli vengono rimossi allora si rimuove l'ordine associato
					statement = Database.getPreparedStatement(REMOVE_ORDINE_QUERY);
					
					statement.setInt(1, o.getIdOrdine());
					
					result = statement.executeUpdate();
					
					if(result > 0){
						logger.info("Ordine rimosso correttamente dal database");
						ordineEliminato = true;
					} else { //l'ordine non è stato rimosso
						//l'ordine viene reinserito nella lista
						ordini.add(o);
						if(dettaglEliminati){ //se però i dettagli sono stati eliminati dal db
							//i dettagli devono essere reinseriti nel db
							memorizzaDettagliOrdine(o);
						}
					}
				} 
				
				if(dettaglEliminati && ordineEliminato){
					eliminato = true;
				}
				
			} catch (SQLException e) {
				logger.severe("Sollevata eccezione: " + e.getMessage());
				e.printStackTrace();
			}
		}
		
		return eliminato;
	}
	
	public static ArrayList<Ordine> filtraOrdiniPerUtente(int idUtente)
	{
		ArrayList<Ordine> ordiniUtente = new ArrayList<Ordine>();
		
		for (Ordine o:ordini)
		{
			if (o.getCliente().getId() == idUtente)
			{
				ordiniUtente.add(o);
			}
		}
		
		return ordiniUtente;
	}
	
	public static ArrayList<Ordine> filtraOrdiniPerStato(int stato){
		ArrayList<Ordine> ordiniPerStato = new ArrayList<Ordine>();
		
		for(Ordine o: ordini){
			if(o.getStato() == stato){
				ordiniPerStato.add(o);
			}
		}
		
		return ordiniPerStato;
	}
	
	public static Ordine ricercaOrdine(int idOrdine) {
		Ordine ordine = null;
		
		for(Ordine o: ordini){
			if(o.getIdOrdine() == idOrdine){
				ordine = o;
				break;
			}
		}
		return ordine;
	}
	
	public static boolean modificaStatoOrdine(int idOrdine, int stato){
		boolean statoModificato = false;
		
		Ordine ord = ricercaOrdine(idOrdine);
		
		if(ord != null){
			
			//salvo stato precendente
			int statoPrecedente = ord.getStato();
			
			//modifica stato ordine nella lista
			ord.setStato(stato); 
			
			//modifica stato ordine nel database
			statement = Database.getPreparedStatement(CHANGE_STATE_QUERY);
			
			try {
				statement.setInt(1, stato);
				statement.setInt(2, idOrdine);
				
				int result = statement.executeUpdate();
				
				if(result > 0){
					logger.info("Stato Ordine modificato correttamente");
					statoModificato = true;
				} else { //stato non modificato
					//risetto l'ordine con lo stato precedente
					ord.setStato(statoPrecedente);
					
				}
			} catch (SQLException e) {
				logger.severe("Sollevata eccezione: " + e.getMessage());
				e.printStackTrace();
			}
			
		}
		return statoModificato;
	}
	
	public static void importaOrdini(){
		try {
			ResultSet orders = Database.executeQuery(IMPORT_ORDINI_QUERY);
			ResultSet details;
			statement = Database.getPreparedStatement(IMPORT_DETTAGLI_QUERY);
			
			Ordine ordine = null;
			//Variabili di Ordine
			int idOrdine, idCliente;
			Timestamp data;
			Utente cliente;
			ArrayList<DettagliOrdine> dettagli;
			double importo;
			int stato;
			
			DettagliOrdine dettaglio;
			//Variabili di DettagliOrdine
			int idDettagliOrdine, idProdotto;
			Prodotto prodotto;
			int quantita;
			double prezzo;
			
			
			    orders.last();//se è l'ultimo memorizzati l'ultimo id usato
				ultimoIdOrdine = orders.getInt("idordine");
				details = Database.executeQuery(SHOW_LAST_ID_DETTAGLI_QUERY);
				details.last();
				ultimoIdDettagliordine = details.getInt("iddettagli_ordini");
			    orders.beforeFirst();
			    logger.info("L'ultimo id degli ordini è: " + ultimoIdOrdine);
			    logger.info("L'ultimo id dei dettagli_ordini è " + ultimoIdDettagliordine);
			    
			while(orders.next()){
				idOrdine = orders.getInt("idordine");
				data = orders.getTimestamp("data");
				idCliente = orders.getInt("cliente");
				importo = orders.getDouble("importo");
				stato = orders.getInt("stato");
				
				cliente = GestioneUtenti.ricercaUtentePerId(idCliente); 
				dettagli = new ArrayList<DettagliOrdine>();
				statement.setInt(1, idOrdine);
				
				details = statement.executeQuery();
				
				while(details.next()){
					idDettagliOrdine = details.getInt("iddettagli_ordini");
					idProdotto = details.getInt("prodotto");
					quantita = details.getInt("quantita");
					prezzo = details.getDouble("prezzo");
					
					prodotto = GestioneProdotti.ricercaProdottoPerId(idProdotto);
					
					dettaglio = new DettagliOrdine(prodotto, quantita, prezzo);
					dettaglio.setIdDettagliOrdine(idDettagliOrdine);
					
					dettagli.add(dettaglio);
				}
				
				ordine = new Ordine(data, cliente, dettagli, importo, stato);
				ordine.setIdOrdine(idOrdine);
				
				if(!ordini.contains(ordine)){
					ordini.add(ordine);
				}
			}
			
		} catch (SQLException e) {
			logger.severe("Sollevata eccezione: " + e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	
	
	private static final Logger logger = Logger.getLogger("logger");
	
	private static final String IMPORT_ORDINI_QUERY = "SELECT * FROM ordini";
	private static final String IMPORT_DETTAGLI_QUERY = "SELECT * FROM dettagli_ordini WHERE ordine = ?";
	private static final String INSERT_ORDINE_QUERY = "INSERT INTO ordini (idordine, data, cliente, importo, stato) VALUES (?, ?, ?, ?, ?)";
	private static final String INSERT_DETTAGLI_QUERY = "INSERT INTO dettagli_ordini (iddettagli_ordini, ordine, prodotto, quantita, prezzo) VALUES (?, ?, ?, ?, ?)";
	private static final String SHOW_LAST_ID_DETTAGLI_QUERY = "SELECT iddettagli_ordini FROM dettagli_ordini";
	private static final String CHANGE_STATE_QUERY = "UPDATE ordini SET stato = ? WHERE idordine = ?";
	private static final String REMOVE_ORDINE_QUERY = "DELETE FROM ordini WHERE idordine = ?";
	private static final String REMOVE_DETTAGLI_QUERY = "DELETE FROM dettagli_ordini WHERE ordine = ?";
	
	private static ArrayList<Ordine> ordini;
	private static PreparedStatement statement;
	private static int ultimoIdOrdine;
	private static int ultimoIdDettagliordine;
	
	static{
		ordini=new ArrayList<Ordine>();
		ultimoIdOrdine = 0;
		ultimoIdDettagliordine = 0;
		importaOrdini();
	}

	public static void main(String[] args) {
		int size = GestioneOrdini.getOrdini().size();
		System.out.println("Size:" + size);
	}
}
