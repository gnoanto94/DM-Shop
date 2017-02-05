package testing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import utenti.GestioneUtenti;
import utenti.Utente;

public class GestioneUtentiTest {
	
	Utente utente;
	ArrayList<Utente> utenti;

	@Before
	public void setUp() throws Exception {
		utente = new Utente("nomeProva", "cognomeProva", "email@prova.it", "P@ssw0rdProva", "indirizzoProva", "cittaProva", "Pr", "111111111");
		utenti = new ArrayList<>();
	}

	@After
	public void tearDown() throws Exception {
		utente = null;
		utenti = null;
	}

	@Test
	public void testAll(){ //per questa classe è necessario testare i metodi in ordine
		testGetUtenti();
		testVerificaDisponibilitaEmail();
		testAggiungiUtente();
		testVerificaCredenziali();
		testRicercaUtentePerId();
		testRimuoviUtente();
	}
	
	public void testGetUtenti() {
		utenti = GestioneUtenti.getUtenti();
		assertNotNull(utenti);
	}
	
	public void testVerificaDisponibilitaEmail() {
		boolean disponibile = GestioneUtenti.verificaDisponibilitaEmail(utente.getEmail());
		assertTrue(disponibile);
	}

	public void testAggiungiUtente() {
		boolean inserito = GestioneUtenti.aggiungiUtente(utente);
		assertTrue(inserito);
	}
	
	public void testVerificaCredenziali() {
		Utente u = GestioneUtenti.verificaCredenziali("email@prova.it", "P@ssw0rdProva");
		assertNotNull(u);
	}

	public void testRicercaUtentePerId() {
		Utente u = GestioneUtenti.verificaCredenziali("email@prova.it", "P@ssw0rdProva");
		Utente trovato = GestioneUtenti.ricercaUtentePerId(u.getId());
		assertEquals(utente, trovato);
	}

	public void testRimuoviUtente() {
		boolean rimosso = GestioneUtenti.rimuoviUtente(utente);
		assertTrue(rimosso);
	}

}
