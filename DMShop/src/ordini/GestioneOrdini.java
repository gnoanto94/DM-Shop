package ordini;

import java.util.ArrayList;

public class GestioneOrdini {
	
	private ArrayList<Ordine> ordini;

	public GestioneOrdini() {
		this.ordini = new ArrayList<Ordine>();
	}

	public ArrayList<Ordine> getOrdini() {
		return ordini;
	}

	public void setOrdini(ArrayList<Ordine> ordini) {
		this.ordini = ordini;
	}

	@Override
	public String toString() {
		return getClass().getName()+" [ordini=" + ordini + "]";
	}

}
