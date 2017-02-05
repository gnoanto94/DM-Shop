package ordini;

import prodotti.Prodotto;

/**
 * Questa classe rappresenta l'oggetto relativo ai dettagli di un ordine
 * 
 * @author Pagliarulo Salvatore
 *
 */

public class DettagliOrdine {
	
	/**
	 * Costruttore dei dettagli dell'ordine con metodi getter e setter
	 * 
	 * @param prodotto - prodotto che il cliente desidera
	 * @param quantita - quantità del prodotto desiderato
	 * @param prezzo - prezzo del prodotto
	 * 
	 * @author Pagliarulo Salvatore
	 */
	public DettagliOrdine(Prodotto prodotto, int quantita, double prezzo) {
		this.prodotto = prodotto;
		this.quantita = quantita;
		this.prezzo = prezzo;
	}
	
	
	public DettagliOrdine() {
	}


	public int getIdDettagliOrdine() {
		return idDettagliOrdine;
	}
	public Prodotto getProdotto() {
		return prodotto;
	}
	public int getQuantita() {
		return quantita;
	}
	public double getPrezzo() {
		return prezzo;
	}
	
	public double getImporto() {
		importo = quantita * prezzo;
		return importo;
	}

	public void setIdDettagliOrdine(int idDettagliOrdine) {
		this.idDettagliOrdine = idDettagliOrdine;
	}
	public void setProdotto(Prodotto prodotto) {
		this.prodotto = prodotto;
	}
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public void setImporto(double importo) {
		this.importo = importo;
	}


	private int idDettagliOrdine;
	private Prodotto prodotto;
	private int quantita;
	private double prezzo;
	private double importo;
	
	

}
