package ordini;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import utenti.Utente;

public class Ordine {
	
	public Ordine(GregorianCalendar data, Utente cliente, ArrayList<DettagliOrdine> dettagli, double importo,
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
	public GregorianCalendar getData() {
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
	public void setData(GregorianCalendar data) {
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


	private int idOrdine;
	private GregorianCalendar data;
	private Utente cliente;
	private ArrayList<DettagliOrdine> dettagli;
	private double importo;
	private int stato;

}
