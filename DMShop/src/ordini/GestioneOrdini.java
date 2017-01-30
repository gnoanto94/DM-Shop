package ordini;

import java.util.ArrayList;

public class GestioneOrdini {


	public static ArrayList<Ordine> getOrdini() {
		return ordini;
	}


	@Override
	public String toString() {
		return getClass().getName()+" [ordini=" + ordini + "]";
	}
	
	public static void aggiungiUtente(Ordine o) {
		if (!ordini.contains(o))
			ordini.add(o);		
	}
	
	public static void rimuoviUtente(Ordine o) {
		if (ordini.contains(o))
			ordini.remove(o);		
	}
	
	private static ArrayList<Ordine> ordini;
	
	static{
		ordini=new ArrayList<Ordine>();
	}

}
