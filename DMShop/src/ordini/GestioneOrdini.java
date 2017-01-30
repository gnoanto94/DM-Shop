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
	
	public static void aggiungiUtente(Ordine o) {
		if (!ordini.contains(o))
			ordini.add(o);		
	}
	
	public static void rimuoviUtente(Ordine o) {
		if (ordini.contains(o))
			ordini.remove(o);		
	}
	
	public static void importaOrdini(){
		try {
			ResultSet orders = Database.executeQuery(IMPORT_ORDINI_QUERY);
			ResultSet details;
			statement = Database.getPreparedStatement(IMPORT_DETTAGLI_QUERY);
			Ordine ordine = null;
			
			int idOrdine, idCliente;
			Timestamp data;
			Utente cliente;
			ArrayList<DettagliOrdine> dettagli;
			double importo;
			int stato;
			
			DettagliOrdine dettaglio;
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
			}
			
			if(!ordini.contains(ordine)){
				ordini.add(ordine);
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
	}

}
