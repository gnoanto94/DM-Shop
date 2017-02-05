package testing;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ordini.DettagliOrdine;
import ordini.GestioneOrdini;
import ordini.Ordine;
import utenti.GestioneUtenti;

public class GestioneOrdiniTest {
	
	private ArrayList<Ordine> ordini;
	private Ordine ordine;

	@Before
	public void setUp() throws Exception {
		ordini = new ArrayList<>();
		//si inserisce un ordine al gestore per prova
		ordine = new Ordine(new Timestamp(System.currentTimeMillis()), GestioneUtenti.ricercaUtentePerId(1), new ArrayList<DettagliOrdine>(), 0.00	, 1);
	}

	@After
	public void tearDown() throws Exception {
		ordini = null;
		ordine = null;
	}

	@Test
	public void testGetOrdini() {
		ordini = GestioneOrdini.getOrdini();
		assertNotNull(ordini);
	}

	@Test
	public void testAggiungiOrdine() {
		boolean inserito = GestioneOrdini.aggiungiOrdine(ordine);
		assertTrue(inserito);
	}

	@Test
	public void testFiltraOrdiniPerUtente() {
		//si verificano gli ordini del gestore per prova
		ArrayList<Ordine> ordiniUtente = GestioneOrdini.filtraOrdiniPerUtente(1);
		assertNotNull(ordiniUtente);
	}

	@Test
	public void testFiltraOrdiniPerStato() {
		ArrayList<Ordine> ordiniNuovi = GestioneOrdini.filtraOrdiniPerStato(1); //ordini nuovi
		assertNotNull(ordiniNuovi);
	}


}
