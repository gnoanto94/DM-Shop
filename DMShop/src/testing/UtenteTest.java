package testing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import utenti.Utente;

public class UtenteTest {

	private Utente utente;
	
	@Before
	public void setUp() throws Exception 
	{
		utente = new Utente();
		utente.setId(1);
		utente.setNome("Salvatore");
		utente.setCognome("Pagliarulo");
		utente.setEmail("salvatore.95_@live.it");
		utente.setCitta("Montecorvino Rovella");
		utente.setProvincia("SA");
		utente.setIndirizzo("Via Patriello 95");
		utente.setPassword("P@ssw0rd");
		utente.setTelefono("3331122444");
		assertNotNull(utente);
	}

	@After
	public void tearDown() throws Exception 
	{
		utente = null;
	}

	@Test
	public void testGetId() {
		int id = utente.getId();
		assertEquals(1, id);
	}

	@Test
	public void testGetNome() {
		String nome = utente.getNome();
		assertEquals("Salvatore", nome);
	}

	@Test
	public void testGetCognome() {
		String cognome = utente.getCognome();
		assertEquals("Pagliarulo", cognome);
	}

	@Test
	public void testGetEmail() {
		String email = utente.getEmail();
		assertEquals("salvatore.95_@live.it", email);
	}

	@Test
	public void testGetPassword() {
		String password = utente.getPassword();
		assertEquals("P@ssw0rd", password);
	}

	@Test
	public void testGetIndirizzo() {
		String indirizzo = utente.getIndirizzo();
		assertEquals("Via Patriello 95", indirizzo);
	}

	@Test
	public void testGetCitta() {
		String citta = utente.getCitta();
		assertEquals("Montecorvino Rovella", citta);
	}

	@Test
	public void testGetProvincia() {
		String provincia = utente.getProvincia();
		assertEquals("SA", provincia);
	}

	@Test
	public void testGetTelefono() {
		String telefono = utente.getTelefono();
		assertEquals("3331122444", telefono);
	}

	@Test
	public void testSetId() {
		int id = 2;
		utente.setId(id);
		assertEquals(2, utente.getId());
	}

	@Test
	public void testSetNome() {
		String nome = "Gaetano";
		utente.setNome(nome);
		assertEquals("Gaetano", utente.getNome());
	}

	@Test
	public void testSetCognome() {
		String cognome = "Antonucci";
		utente.setCognome(cognome);
		assertEquals("Antonucci", utente.getCognome());
	}

	@Test
	public void testSetEmail() {
		String email = "gnoanto94@gmail.com";
		utente.setEmail(email);
		assertEquals("gnoanto94@gmail.com", utente.getEmail());
	}

	@Test
	public void testSetPassword() {
		String password = "password";
		utente.setPassword(password);
		assertEquals("password", utente.getPassword());
	}

	@Test
	public void testSetIndirizzo() {
		String indirizzo = "Via Cenere 6C";
		utente.setIndirizzo(indirizzo);
		assertEquals("Via Cenere 6C", utente.getIndirizzo());
	}

	@Test
	public void testSetCitta() {
		String citta = "Giffoni Valle Piana";
		utente.setCitta(citta);
		assertEquals("Giffoni Valle Piana", utente.getCitta());
	}

	@Test
	public void testSetProvincia() {
		String provincia = "SB";
		utente.setProvincia(provincia);
		assertEquals("SB", utente.getProvincia());
	}

	@Test
	public void testSetTelefono() {
		String telefono = "3333333333";
		utente.setTelefono(telefono);
		assertEquals("3333333333", utente.getTelefono());
	}

}
