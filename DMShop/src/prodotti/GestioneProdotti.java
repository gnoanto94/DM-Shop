package prodotti;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

import database.Database;
import ordini.DettagliOrdine;

/**
 * Questa classe rappresenta un manager per la gestione dei prodotti
 * 
 * @author Antonucci Gaetano
 * @author Pagliarulo Salvatore
 */
public class GestioneProdotti {

	public static ArrayList<Prodotto> getProdotti() {
		return prodotti;
	}

	@Override
	public String toString() {
		return getClass().getName()+" [prodotti=" + prodotti + "]";
	}
	
	/**
	 * Questo metodo serve a verificare l'esistenza di un prodotto
	 * 
	 * @param nome - nome del prodotto
	 * @return {@code true} se il prodotto esiste<br/>
	 * {@code false} se il prodotto non esiste
	 * 
	 * @author Pagliarulo Salvatore
	 */
	public static boolean verificaEsistenzaProdotto(String nome){
		boolean result = false;
		
		Prodotto prodotto = ricercaProdottoPerNome(nome);
		
		if(prodotto != null){
			result = true;
		}
		
		return result;
	}
	
	/**
	 * Questo metodo serve a cercare un prodotto in base al suo id
	 * 
	 * @param id - identificativo del prodotto da cercare
	 * @return prodotto cercato<br/>
	 * {@code null} se il prodotto non � stato trovato
	 * 
	 * @author Pagliarulo Salvatore
	 */
	public static Prodotto ricercaProdottoPerId(int id){
		
		Prodotto result = null;
		
		for(Prodotto p: prodotti){
			if(p.getIdProdotto() == id){
				result = p;
				break;
			}
		}
		
		return result;
	}
	
	/**
	 * Questo metodo serve a cercare un prodotto in base al nome
	 * 
	 * @param nome - nome del prodotto da cercare
	 * @return prodotto cercato<br/>
	 * {@code null} se il prodotto non � presente
	 * 
	 * @author Pagliarulo Salvatore
	 */
	public static Prodotto ricercaProdottoPerNome(String nome){
		
		Prodotto result = null;
		
		for(Prodotto p: prodotti){
			if(p.getNome().equalsIgnoreCase(nome)){
				result = p;
				break;
			}
		}
		
		return result;
		
	}
	
	/**
	 * Questo metodo serve ad aggiungere un prodotto
	 * 
	 * @param p - prodotto da aggiungere
	 * @return {@code true} se il prodotto � stato inserito correttamente<br/>
	 * {@code false} se il prodotto non � stato inserito correttamente
	 * 
	 * @author Antonucci Gaetano
	 */
	public static boolean aggiungiProdotto(Prodotto p) {
		
		boolean inserito = false;
		
		if(p != null){
			if (!prodotti.contains(p)) //se � gi� presente non viene aggiunto
				prodotti.add(p); //aggiunta del prodotto nella lista
			
			//Aggiunta prodotto al database
			statement = Database.getPreparedStatement(INSERT_QUERY);
			
			try {
				p.setIdProdotto(++ultimoIdProdotto);
				statement.setInt(1, p.getIdProdotto());
				statement.setString(2, p.getMarca());
				statement.setString(3, p.getNome());
				statement.setString(4, p.getDescrizione());
				statement.setInt(5, p.getQuantitaDisponibile());
				statement.setDouble(6, p.getPrezzoVendita());
				statement.setString(7, p.getUrlImmagine());
				
				int result = statement.executeUpdate();
				
				if(result > 0){
					logger.info("Prodotto inserito correttamente nel database");
					inserito = true;
				}
				
			} catch (SQLException e) {
				logger.severe("Sollevata Eccezione: " + e.getMessage());
				e.printStackTrace();
			}
			
			
		}
		
		return inserito;
	}
	
	/**
	 * Questo metodo serve a modificare un prodotto
	 * 
	 * @param p - prodotto da modificare
	 * @return {@code true} se il prodotto � stato modificato correttamente<br/>
	 * {@code false} se il prodotto non � stato modificato correttamente
	 * 
	 * @author Antonucci Gaetano
	 */
	public static boolean modificaProdotto(Prodotto p){
		
		boolean modificato = false;
		Prodotto prodotto = null;
		
		//Valori prodotto prima della modifica
		String marca, nome, descrizione, urlImmagine;
		int quantitaDisponibile;
		double prezzoVendita;
		
		if(p != null){
			//Ricerca prodotto nella Lista
			prodotto = ricercaProdottoPerId(p.getIdProdotto());
			
			//Salva valori precedenti prima della modifica
			// l'idProdotto non viene modificato quindi non viene salvato
			marca = prodotto.getMarca();
			nome = prodotto.getNome();
			descrizione = prodotto.getDescrizione();
			quantitaDisponibile = prodotto.getQuantitaDisponibile();
			prezzoVendita = prodotto.getPrezzoVendita();
			urlImmagine = prodotto.getUrlImmagine();
			
			//Modifica prodotto nella lista
			prodotto.setMarca(p.getMarca());
			prodotto.setNome(p.getNome());
			prodotto.setDescrizione(p.getDescrizione());
			prodotto.setQuantitaDisponibile(p.getQuantitaDisponibile());
			prodotto.setPrezzoVendita(p.getPrezzoVendita());
			prodotto.setUrlImmagine(p.getUrlImmagine());
			
			//Modifica prodotto nel database
			statement = Database.getPreparedStatement(UPDATE_QUERY);
			
			try {
				statement.setString(1, prodotto.getMarca());
				statement.setString(2, prodotto.getNome());
				statement.setString(3, prodotto.getDescrizione());
				statement.setInt(4, prodotto.getQuantitaDisponibile());
				statement.setDouble(5, prodotto.getPrezzoVendita());
				statement.setString(6, prodotto.getUrlImmagine());
				statement.setInt(7, prodotto.getIdProdotto());
				
				int result = statement.executeUpdate();
				
				if(result > 0){
					logger.info("Prodotto modificato correttamente nel database");
					modificato = true;
					
				} else { //l'update sul db non va a buon fine
					
					//riporta il prodotto nella lista allo stato originario
					prodotto.setMarca(marca);
					prodotto.setNome(nome);
					prodotto.setDescrizione(descrizione);
					prodotto.setQuantitaDisponibile(quantitaDisponibile);
					prodotto.setPrezzoVendita(prezzoVendita);
					prodotto.setUrlImmagine(urlImmagine);
				}
				
			} catch (SQLException e) {
				logger.severe("Sollevata Eccezione: " + e.getMessage());
				e.printStackTrace();
			}
			
		}
		
		return modificato;
	}
	
	/**
	 * Questo metodo serve a rimuovere un prodotto
	 * 
	 * @param p - prodotto da rimuovere
	 * @return {@code true} se il prodotto � stato rimosso correttamente<br/>
	 * {@code false} se il prodotto non � stato rimosso correttamente
	 * 
	 * @author Antonucci Gaetano
	 */
	public static boolean rimuoviProdotto(Prodotto p) {
		
		boolean eliminato = false;
		
		if(p != null){
			if (prodotti.contains(p)) //se il prodotto � contenuto nella lista
				prodotti.remove(p);	  //allora rimuovilo	
			
			//rimozione dal database
			statement = Database.getPreparedStatement(REMOVE_QUERY);
			
			try {
				statement.setInt(1, p.getIdProdotto());
				
				int result = statement.executeUpdate();
				
				if(result > 0){
					logger.info("Prodotto rimosso correttamente dal database");
					eliminato = true;
				} else { //prodotto non eliminato dal db
					//reinserimento del prodotto nella lista
					prodotti.add(p);
				}
				
			} catch (SQLException e) {
				logger.severe("Sollevata Eccezione: " + e.getMessage());
				e.printStackTrace();
			}
		}
		
		return eliminato;
	}
	
	/**
	 * Questo metodo serve ad aggiornare la quantit� dei prodotti
	 * 
	 * @param itemDaAggiornare - elenco dei prodotti la cui quantit� deve essere aggiornata
	 * @return {@code true} se la quantit� � stata aggiornata correttamente<br/>
	 * {@code false} se la quantit� non � stata aggiornata correttamente
	 * 
	 * @author Antonucci Gaetano
	 */
	public static boolean aggiornaQuantita(ArrayList<DettagliOrdine> itemDaAggiornare){
		
		boolean aggiornataQuantita = false;
		
		statement = Database.getPreparedStatement(UPDATE_QTY_QUERY);
		
		int result;
		int nroItemDaAggiornare = itemDaAggiornare.size();
		int aggiornati = 0;
		
		for(DettagliOrdine det: itemDaAggiornare){
			try {
				statement.setInt(1, det.getProdotto().getQuantitaDisponibile());
				statement.setInt(2, det.getProdotto().getIdProdotto());
				
				result = statement.executeUpdate();
				
				if(result > 0){
					logger.info("Quantita' aggiornata correttamente nel database");
					aggiornati++;
				}
				
			} catch (SQLException e) {
				logger.severe("Sollevata Eccezione: " + e.getMessage());
				e.printStackTrace();
			}
			
		}
		
		if(nroItemDaAggiornare == aggiornati){
			aggiornataQuantita = true;
		}
		
		
		return aggiornataQuantita;
	}
	
	/**
	 * Questo metodo serve ad importare i prodotti dal database
	 * 
	 * @author Antonucci Gaetano
	 */
	public static void importaProdotti(){
		try {
			ResultSet products = Database.executeQuery(IMPORT_QUERY);
			Prodotto product = null;
			
			int idProdotti, quantitaDisponibile;
			String marca, nome, descrizione, urlImmagine;
			double prezzoVendita;
			
			products.last();
			ultimoIdProdotto = products.getInt("idprodotti");
			logger.info("L'id dell'ultimo prodotto inserito �: " + ultimoIdProdotto);
			products.beforeFirst();
			
			while(products.next()){
				idProdotti = products.getInt("idprodotti");
				marca = products.getString("marca");
				nome = products.getString("nome");
				descrizione = products.getString("descrizione");
				quantitaDisponibile = products.getInt("quantita_disponibile");
				prezzoVendita = products.getDouble("prezzo_vendita");
				urlImmagine = products.getString("url_immagine");
				
				product = new Prodotto(marca, nome, descrizione, quantitaDisponibile, prezzoVendita, urlImmagine);
				product.setIdProdotto(idProdotti);
				
				if(!prodotti.contains(product)){
					prodotti.add(product);
				}
			}
			
		} catch (SQLException e) {
			logger.severe("Sollevata Eccezione: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	private static final Logger logger = Logger.getLogger("logger");
	
	private static final String INSERT_QUERY = "INSERT INTO prodotti (idprodotti, marca, nome, descrizione, quantita_disponibile, prezzo_vendita, url_immagine) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE_QUERY = "UPDATE prodotti SET marca = ?, nome = ?, descrizione = ?, quantita_disponibile = ?, prezzo_vendita = ?, url_immagine = ? WHERE idprodotti = ?";
	private static final String UPDATE_QTY_QUERY = "UPDATE prodotti SET quantita_disponibile = ? WHERE idprodotti = ?";
	private static final String IMPORT_QUERY = "SELECT * FROM prodotti";
	private static final String REMOVE_QUERY = "DELETE FROM prodotti WHERE idprodotti = ?";
	
	private static ArrayList<Prodotto> prodotti;
	private static PreparedStatement statement;
	private static int ultimoIdProdotto;
	
	static{
		prodotti=new ArrayList<Prodotto>();
		ultimoIdProdotto = 0;
		importaProdotti();
	}
}
