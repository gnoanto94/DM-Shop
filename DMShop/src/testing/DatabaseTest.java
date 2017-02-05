package testing;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import database.Database;

public class DatabaseTest {
	Connection connection;

	@Before
	public void setUp() throws Exception {
		connection = Database.getConnection();
	}

	@After
	public void tearDown() throws Exception {
		connection = null;
	}

	@Test
	public void testOpenConnection() {
		Database.openConnection();
		connection = Database.getConnection();
		assertNotNull(connection);
	}

	@Test
	public void testIsConnectionOpen() {
		Database.openConnection();
		assertTrue(Database.isConnectionOpen());
	}

	@Test
	public void testCloseConnection() {
		Database.openConnection();
		Database.closeConnection();
		connection = Database.getConnection();
		assertNull(connection);
	}

	@Test
	public void testExecuteQuery() {
		try {
			ResultSet result = Database.executeQuery("SELECT * FROM utenti");
			assertNotNull(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetPreparedStatement() {
		PreparedStatement statement = Database.getPreparedStatement("SELECT * FROM utenti WHERE id = ?");
		assertNotNull(statement);
	}

}
