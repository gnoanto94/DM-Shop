package utenti;

import java.util.ArrayList;

public class GestioneUtenti {

	public static ArrayList<Utente> getUtenti() {
		return utenti;
	}

	@Override
	public String toString() {
		return getClass().getName()+" [utenti=" + utenti + "]";
	}

	public static void aggiungiUtente(Utente u) {
		if (!utenti.contains(u))
			utenti.add(u);		
	}
	
	public static void rimuoviUtente(Utente u) {
		if (!utenti.contains(u))
			utenti.remove(u);		
	}
	
	private static ArrayList<Utente> utenti;
	
	static {
		utenti=new ArrayList<Utente>();
	}

}
