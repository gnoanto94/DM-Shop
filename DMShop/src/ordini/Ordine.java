package ordini;

import java.sql.Timestamp;
import java.util.ArrayList;

import utenti.Utente;

/**
 * Questa classe rappresenta l'oggetto Ordine
 * 
 * @author Pagliarulo Salvatore
 *
 */
public class Ordine {
	
	
	/**
	 * Costruttore dell'ordine con relativi getter e setter
	 * 
	 * @param data - data dell'ordine
	 * @param cliente - cliente che ha effettuato un ordine
	 * @param dettagli - dettagli dell'ordine
	 * @param importo - importo dell'ordine
	 * @param stato - stato dell'ordine
	 * 
	 *  @author Pagliarulo Salvatore
	 */
	public Ordine(Timestamp data, Utente cliente, ArrayList<DettagliOrdine> dettagli, double importo,
			int stato) {
		this.data = data;
		this.cliente = cliente;
		this.dettagli = dettagli;
		this.importo = importo;
		this.stato = stato;
	}
	
	
	public int getIdOrdine() {
		return idOrdine;
	}
	public Timestamp getData() {
		return data;
	}
	public Utente getCliente() {
		return cliente;
	}
	public ArrayList<DettagliOrdine> getDettagli() {
		return dettagli;
	}
	public double getImporto() {
		return importo;
	}
	public int getStato() {
		return stato;
	}
	public void setIdOrdine(int idOrdine) {
		this.idOrdine = idOrdine;
	}
	public void setData(Timestamp data) {
		this.data = data;
	}
	public void setCliente(Utente cliente) {
		this.cliente = cliente;
	}
	public void setDettagli(ArrayList<DettagliOrdine> dettagli) {
		this.dettagli = dettagli;
	}
	public void setImporto(double importo) {
		this.importo = importo;
	}
	public void setStato(int stato) {
		this.stato = stato;
	}
	
	@Override
	public String toString() {
		return getClass().getName()+" [idOrdine=" + idOrdine + ", data=" + data + ", cliente=" + cliente + ", dettagli=" + dettagli
				+ ", importo=" + importo + ", stato=" + stato + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ordine other = (Ordine) obj;
		if (this.idOrdine==(other.idOrdine))
			return true;
		else
			return false;
	}

	private int idOrdine;
	private Timestamp data;
	private Utente cliente;
	private ArrayList<DettagliOrdine> dettagli;
	private double importo;
	private int stato;

}
