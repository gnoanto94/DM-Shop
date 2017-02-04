package acquisti;

import java.util.ArrayList;
import java.util.logging.Logger;

import ordini.DettagliOrdine;
import prodotti.Prodotto;
import prodotti.GestioneProdotti;

/**
 * Questa classe rappresenta l'oggetto Carrello
 * 
 * @author Antonucci Gaetano
 * @author Pagliarulo Salvatore 
 */
public class Carrello {
	
	/**
	 * Costruttore con relativi getter e setter
	 * 
	 * @author Antonucci Gaetano
	 * @author Pagliarulo Salvatore
	 */
	public Carrello() {
		elementiNelCarrello = new ArrayList<>();
		importo = 0;
	}
	
	
	public ArrayList<DettagliOrdine> getElementiNelCarrello() {
		return elementiNelCarrello;
	}

	public void setElementiNelCarrello(ArrayList<DettagliOrdine> elementiNelCarrello) {
		this.elementiNelCarrello = elementiNelCarrello;
	}
	
	/**
	 * Questo metodo serve ad aggiungere un prodotto nel carrello
	 * 
	 * @param idProdotto - identificativo del prodotto
	 * @param quantita - quantita desiderata di un prodotto
	 * 
	 * @author Antonucci Gaetano
	 * @author Pagliarulo Salvatore
	 */
	public void aggiungiProdottoNelCarrello(int idProdotto, int quantita){
		
		if (idProdotto != 0)
		{
			Prodotto p = GestioneProdotti.ricercaProdottoPerId(idProdotto);
			DettagliOrdine elemento = new DettagliOrdine(p, quantita, p.getPrezzoVendita());
			DettagliOrdine item = verificaElementoPresente(elemento);
			if (item != null)
			{
				if(p.getQuantitaDisponibile() > 0){ //se la quantita' è maggiore di 0 e il prodotto è già presente nel carrello allora aumento la quantita' acquistata
					item.setQuantita(item.getQuantita() + quantita);
					p.setQuantitaDisponibile(p.getQuantitaDisponibile() - quantita);  //decremento quantità nel magazzino
					logger.info("Quantita del prodotto: " + p.getNome() +" dopo averlo messo nel carrello: " + p.getQuantitaDisponibile());
				}
				
			}
			else
			{
				if(p.getQuantitaDisponibile() > 0){ //se la quantita' è maggiore di 0 allora inserisco il prodotto nel carrello
					elementiNelCarrello.add(elemento);
					p.setQuantitaDisponibile(p.getQuantitaDisponibile() - quantita);  //decremento quantità nel magazzino
					logger.info("Quantita del prodotto: " + p.getNome() +" dopo averlo messo nel carrello: " + p.getQuantitaDisponibile());
				}
			}
		}	
	}

/**
 * Questo metodo serve a rimuovere un prodotto dal carrello
 *  
 * @param idProdotto - identificativo del prodotto
 * 
 * @author Antonucci Gaetano
 * @author Pagliarulo Salvatore
 */
public void rimuoviProdottoDalCarrello(int idProdotto){
		
		if (idProdotto != 0)
		{
			Prodotto p = GestioneProdotti.ricercaProdottoPerId(idProdotto);
			DettagliOrdine elemento = ricercaElemento(p);
			
			if (elemento != null)
			{
				elementiNelCarrello.remove(elemento);
				p.setQuantitaDisponibile(p.getQuantitaDisponibile() + elemento.getQuantita());  //Incremento quantita nel magazzino
			}
		}
		
	}

	
/**
 * Questo metodo verifica se un elemento è presente nel carrello
 * 
 * @param elemento - oggetto che rappresenta i dettagli di un ordine
 * 
 * @return elementoPresente - oggetto che rappresenta i dettagli dell'ordine cercato<br/>
 * {@code null} se l'oggetto non è presente
 * 
 * @author Antonucci Gaetano
 * @author Pagliarulo Salvatore
 */
public DettagliOrdine verificaElementoPresente(DettagliOrdine elemento){
				
		DettagliOrdine elementoPresente = null;
		
		if (elemento != null)
		{
			for (DettagliOrdine d:elementiNelCarrello)
			{
				if (elemento.getProdotto().equals(d.getProdotto()))
				{
					elementoPresente = d;
					break;
				}
			}
		}
		
		return elementoPresente;
	}
	
/**
 * Questo metodo effettua la ricerca di un prodotto nel carrello
 * 
 * @param prodotto - oggetto prodotto da cercare
 * 
 * @return elementoTrovato - oggetto prodotto cercato<br/>
 * {@code null} se l'oggetto non è stato trovato
 * 
 * @author Antonucci Gaetano
 * @author Pagliarulo Salvatore
 */
public DettagliOrdine ricercaElemento(Prodotto prodotto)
	{
		DettagliOrdine elementoTrovato = null;
		
		if (prodotto != null)
		{
			for (DettagliOrdine d:elementiNelCarrello)
			{
				if (d.getProdotto().equals(prodotto))
				{
					elementoTrovato = d;
					break;
				}
			}
		}
		
		return elementoTrovato;
	}


/**
 * Questo metodo calcola l'importo totale degli elementi nel carrello	
 * 
 * @return importo - valore dell'importo calcolato
 * 
 * @author Antonucci Gaetano
 * @author Pagliarulo Salvatore
 */
public double getImporto(){
		importo = 0;
		
		for(DettagliOrdine d: elementiNelCarrello){
			importo += (d.getQuantita() * d.getPrezzo());
		}
		return importo;
	}

	private static final Logger logger = Logger.getLogger("logger");
	
	private double importo;
	private ArrayList<DettagliOrdine> elementiNelCarrello;

}
