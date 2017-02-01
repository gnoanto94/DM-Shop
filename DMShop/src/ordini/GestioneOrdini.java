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
	
	public static boolean aggiungiOrdine(Ordine o) {
		
		boolean inserimento = false;
		boolean ordineInserito = false;
		boolean dettagliInseriti = false;
		int addedDetails = 0;
		
		if(o != null){
			if (!ordini.contains(o))
				ordini.add(o);
			
			//Aggiunta al database
			statement = Database.getPreparedStatement(INSERT_ORDINE_QUERY);
			try {
				statement.setTimestamp(1, o.getData());
				statement.setInt(2, o.getCliente().getId());
				statement.setDouble(3, o.getImporto());
				statement.setInt(4, o.getStato());
				
				int result = statement.executeUpdate();
				
				if(result > 0){
					logger.info("Ordine inserito correttamente nel database");
					ordineInserito = true;
				}
				
				statement = Database.getPreparedStatement(INSERT_DETTAGLI_QUERY);
				ArrayList<DettagliOrdine> dettagliOrdine = o.getDettagli();
				
				for(DettagliOrdine d: dettagliOrdine){
					statement.setInt(1, o.getIdOrdine());
					statement.setInt(2, d.getProdotto().getIdProdotto());
					statement.setInt(3, d.getQuantita());
					statement.setDouble(4, d.getPrezzo());
					
					result = statement.executeUpdate();
					
					if(result > 0){
						logger.info("Dettaglio inserito correttamente nel database");
						addedDetails++;
					}
				}
				
				if(dettagliOrdine.size() == addedDetails){// verifica che i dettagli inseriti siano tutti
					dettagliInseriti = true;
				}
				
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
	
	public static void rimuoviOrdine(Ordine o) {
		if (ordini.contains(o))
			ordini.remove(o);		
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
	private static final String INSERT_ORDINE_QUERY = "INSERTO INTO ordini (data, cliente, importo, stato) VALUES (?, ?, ?, ?)";
	private static final String INSERT_DETTAGLI_QUERY = "INSERTO INTO dettagli_ordini (ordine, prodotto, quantita, prezzo) VALUES (?, ?, ?, ?)";
	
	private static ArrayList<Ordine> ordini;
	private static PreparedStatement statement;
	
	static{
		ordini=new ArrayList<Ordine>();
		importaOrdini();
	}

}
