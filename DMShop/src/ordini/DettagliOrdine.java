package ordini;

import prodotti.Prodotto;

public class DettagliOrdine {
	
	
	
	public DettagliOrdine(Prodotto prodotto, int quantita, double prezzo) {
		this.prodotto = prodotto;
		this.quantita = quantita;
		this.prezzo = prezzo;
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


	private int idDettagliOrdine;
	private Prodotto prodotto;
	private int quantita;
	private double prezzo;
	
	

}
