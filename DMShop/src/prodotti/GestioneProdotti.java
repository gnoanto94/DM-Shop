package prodotti;

import java.util.ArrayList;

import utenti.Utente;

public class GestioneProdotti {

	public static ArrayList<Prodotto> getProdotti() {
		return prodotti;
	}

	@Override
	public String toString() {
		return getClass().getName()+" [prodotti=" + prodotti + "]";
	}
	
	public static void aggiungiProdotto(Prodotto p) {
		if (!prodotti.contains(p))
			prodotti.add(p);		
	}
	
	public static void rimuoviProdotto(Prodotto p) {
		if (!prodotti.contains(p))
			prodotti.remove(p);		
	}
	
	private static ArrayList<Prodotto> prodotti;
	
	static{
		prodotti=new ArrayList<Prodotto>();
	}
}
