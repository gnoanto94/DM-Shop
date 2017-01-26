package utenti;

import java.util.ArrayList;

public class GestioneUtenti {
	
	private ArrayList<Utente> utenti;

	public GestioneUtenti() {
		this.utenti = new ArrayList<Utente>();
	}

	public ArrayList<Utente> getUtenti() {
		return utenti;
	}

	public void setUtenti(ArrayList<Utente> utenti) {
		this.utenti = utenti;
	}

	@Override
	public String toString() {
		return getClass().getName()+" [utenti=" + utenti + "]";
	}

}
