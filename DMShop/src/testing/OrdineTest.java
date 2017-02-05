package testing;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ordini.DettagliOrdine;
import ordini.Ordine;
import utenti.Utente;

public class OrdineTest {

	private Ordine ordine;
	private Utente cliente;
	private Timestamp data;
	private ArrayList<DettagliOrdine> dettagli;
	private String email = "email@dmshop.it";

	
	@Before
	public void setUp() throws Exception 
	{
		ordine = new Ordine();
		cliente = new Utente(email);
		ordine.setCliente(cliente);
		data = new Timestamp(System.currentTimeMillis());
		ordine.setData(data);
		dettagli = new ArrayList<DettagliOrdine>();
		ordine.setDettagli(dettagli);
		ordine.setIdOrdine(1);
		ordine.setStato(0);
		ordine.setImporto(500);
		assertNotNull(ordine);
	}

	@After
	public void tearDown() throws Exception 
	{
		ordine = null;
	}

	@Test
	public void testGetIdOrdine() {
		int id = ordine.getIdOrdine();
		assertEquals(1, id);
	}

	@Test
	public void testGetData() {
		Timestamp data = ordine.getData();
		assertEquals(new Timestamp(System.currentTimeMillis()), data);
	}

	@Test
	public void testGetCliente() {
		Utente cliente = ordine.getCliente();
		assertEquals(new Utente(email), cliente);
	}

	@Test
	public void testGetDettagli() {
		ArrayList<DettagliOrdine> dettagli = ordine.getDettagli();
		assertEquals(new ArrayList<DettagliOrdine>(), dettagli);
	}

	@Test
	public void testGetImporto() {
		double importo = ordine.getImporto();
		assertEquals(500, importo, 500-importo);
	}

	@Test
	public void testGetStato() {
		int stato = ordine.getStato();
		assertEquals(0, stato);
	}

	@Test
	public void testSetIdOrdine() {
		int id = 2;
		ordine.setIdOrdine(id);
		assertEquals(2, ordine.getIdOrdine());
	}

	@Test
	public void testSetData() {
		Timestamp data = new Timestamp(System.currentTimeMillis());
		ordine.setData(data);
		assertEquals(data, ordine.getData());
	}

	@Test
	public void testSetCliente() {
		Utente cliente = new Utente(email);
		ordine.setCliente(cliente);
		assertEquals(new Utente(email), ordine.getCliente());
	}

	@Test
	public void testSetDettagli() {
		ArrayList<DettagliOrdine> dettagli = new ArrayList<DettagliOrdine>();
		ordine.setDettagli(dettagli);
		assertEquals(new ArrayList<DettagliOrdine>(), ordine.getDettagli());
	}

	@Test
	public void testSetImporto() {
		double importo = 1000;
		ordine.setImporto(importo);
		assertEquals(1000, importo , 1000-importo);
	}

	@Test
	public void testSetStato() {
		int stato = 1;
		ordine.setStato(stato);
		assertEquals(1, ordine.getStato());
	}

}
