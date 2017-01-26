package prodotti;

import java.util.ArrayList;

public class GestioneProdotti {
	
	private ArrayList<Prodotto> prodotti;

	public GestioneProdotti() {
		this.prodotti = new ArrayList<Prodotto>();
	}

	public ArrayList<Prodotto> getProdotti() {
		return prodotti;
	}

	public void setProdotti(ArrayList<Prodotto> prodotti) {
		this.prodotti = prodotti;
	}

	@Override
	public String toString() {
		return getClass().getName()+" [prodotti=" + prodotti + "]";
	}
	
}
