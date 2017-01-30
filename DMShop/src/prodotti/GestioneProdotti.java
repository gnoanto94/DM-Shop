package prodotti;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

import database.Database;

public class GestioneProdotti {

	public static ArrayList<Prodotto> getProdotti() {
		return prodotti;
	}

	@Override
	public String toString() {
		return getClass().getName()+" [prodotti=" + prodotti + "]";
	}
	
	public static boolean verificaEsistenzaProdotto(String nome){
		boolean result = false;
		
		Prodotto prodotto = ricercaProdottoPerNome(nome);
		
		if(prodotto != null){
			result = true;
		}
		
		return result;
	}
	
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
	
	public static boolean aggiungiProdotto(Prodotto p) {
		
		boolean inserito = false;
		
		if(p != null){
			if (!prodotti.contains(p))
				prodotti.add(p);
			
			//Aggiunta prodotto al database
			statement = Database.getPreparedStatement(INSERT_QUERY);
			
			try {
				statement.setString(1, p.getMarca());
				statement.setString(2, p.getNome());
				statement.setString(3, p.getDescrizione());
				statement.setInt(4, p.getQuantitaDisponibile());
				statement.setDouble(5, p.getPrezzoVendita());
				
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
	
	public static boolean modificaProdotto(Prodotto p){
		
		boolean modificato = false;
		Prodotto prodotto = null;
		
		if(p != null){
			//Ricerca prodotto nella Lista
			prodotto = ricercaProdottoPerId(p.getIdProdotto());
			
			//Modifica prodotto nella lista
			prodotto.setMarca(p.getMarca());
			prodotto.setNome(p.getNome());
			prodotto.setDescrizione(p.getDescrizione());
			prodotto.setQuantitaDisponibile(p.getQuantitaDisponibile());
			prodotto.setPrezzoVendita(p.getPrezzoVendita());
			
			//Modifica prodotto nel database
			statement = Database.getPreparedStatement(UPDATE_QUERY);
			
			try {
				statement.setString(1, prodotto.getMarca());
				statement.setString(2, prodotto.getNome());
				statement.setString(3, prodotto.getDescrizione());
				statement.setInt(4, prodotto.getQuantitaDisponibile());
				statement.setDouble(5, prodotto.getPrezzoVendita());
				statement.setInt(6, prodotto.getIdProdotto());
				
				int result = statement.executeUpdate();
				
				if(result > 0){
					logger.info("Prodotto modificato correttamente nel database");
					modificato = true;
				}
				
			} catch (SQLException e) {
				logger.severe("Sollevata Eccezione: " + e.getMessage());
				e.printStackTrace();
			}
			
		}
		
		return modificato;
	}
	public static boolean rimuoviProdotto(Prodotto p) {
		
		boolean eliminato = false;
		
		if(p != null){
			if (prodotti.contains(p))
				prodotti.remove(p);		
			
			//rimozione dal database
			statement = Database.getPreparedStatement(REMOVE_QUERY);
			
			try {
				statement.setInt(1, p.getIdProdotto());
				
				int result = statement.executeUpdate();
				
				if(result > 0){
					logger.info("Prodotto rimosso correttamente dal database");
					eliminato = true;
				}
				
			} catch (SQLException e) {
				logger.severe("Sollevata Eccezione: " + e.getMessage());
				e.printStackTrace();
			}
		}
		
		return eliminato;
	}
	
	public static void importaProdotti(){
		try {
			ResultSet products = Database.executeQuery(IMPORT_QUERY);
			Prodotto product = null;
			
			int idProdotti, quantitaDisponibile;
			String marca, nome, descrizione;
			double prezzoVendita;
			
			while(products.next()){
				idProdotti = products.getInt("idprodotti");
				marca = products.getString("marca");
				nome = products.getString("nome");
				descrizione = products.getString("descrizione");
				quantitaDisponibile = products.getInt("quantita_disponibile");
				prezzoVendita = products.getDouble("prezzo_vendita");
				
				product = new Prodotto(marca, nome, descrizione, quantitaDisponibile, prezzoVendita);
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
	
	private static final String INSERT_QUERY = "INSERT INTO prodotti (marca, nome, descrizione, quantita_disponibile, prezzo_vendita) VALUES (?, ?, ?, ?, ?)";
	private static final String UPDATE_QUERY = "UPDATE prodotti SET marca = ?, nome = ?, descrizione = ?, quantita_disponibile = ?, prezzo_vendita = ? WHERE idprodotti = ?";
	private static final String IMPORT_QUERY = "SELECT * FROM prodotti";
	private static final String REMOVE_QUERY = "DELETE FROM prodotti WHERE idprodotti = ?";
	
	private static ArrayList<Prodotto> prodotti;
	private static PreparedStatement statement;
	
	static{
		prodotti=new ArrayList<Prodotto>();
		importaProdotti();
	}
}
