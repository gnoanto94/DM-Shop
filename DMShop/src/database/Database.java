package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

/**
 * Questa classe gestisce tutte le interazioni con il Database
 *  
 * @author Gaetano Antonucci
 */
public class Database {
	
	/**
	 * Questo metodo consente di aprire una connessione verso il database
	 * 
	 * @author Gaetano Antonucci
	 */
	public synchronized static void openConnection() {
		if (!isConnectionOpen()) {
			try {
				Class.forName(DRIVER_CLASS); 
				connection = DriverManager.getConnection(URL, USER, PASSWORD);
				logger.info("Connessione instanziata: " + connection);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				logger.severe("Classe " + DRIVER_CLASS + " non trovata");
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Questo metodo verifica se la connessione verso il database è aperta
	 * @return {@code true} se la connessione è aperta <br />
	 *         {@code false} se la connessione è chiusa
	 * 
	 * @author Gaetano Antonucci
	 */
	public static boolean isConnectionOpen() {
		boolean isOpen = false;
		try {
			if (connection != null && !connection.isClosed()) {
				isOpen = true;
				logger.info("La connessione e' aperta");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return isOpen;
	}
	
	/**
	 * Questo metodo chiude la connessione verso il database
	 * 
	 * @return {@code true} se la connessione è chiusa <br />
	 * 		   {@code false} altrimenti
	 * 
	 * @author Gaetano Antonucci
	 */
	public synchronized static boolean closeConnection() {
		boolean isClosed = false;

		if (isConnectionOpen()) {
			try {
				connection.close();
				isClosed = connection.isClosed();
				logger.info("La connessione e' stata chiusa");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return isClosed;
	}
	
	/**
	 * Questo metodo esegue una query sul database
	 * @param query - la query da eseguire
	 * @return un {@link ResultSet} contente il risultato dell'esecuzione della query 
	 * @throws SQLException se l'esecuzione della query non va a buon fine
	 * 
	 * @author Gaetano Antonucci
	 */
	public synchronized static ResultSet executeQuery(String query) throws SQLException {
		openConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		
		return resultSet;
	}
	
	/**
	 * Questo metodo costruisce un {@link PreparedStatement} da poter utilizzare sul database
	 *  
	 * @param statement - {@link String} che rappresenta il PreparedStatement
	 * @return il {@link PreparedStatement} costruito
	 * 
	 * @author Gaetano Antonucci
	 */
	public synchronized static PreparedStatement getPreparedStatement(String statement) {
		openConnection();
		PreparedStatement preparedStatement = null;
		
		if (statement != null && !statement.equals("")) {
			try {
				preparedStatement = connection.prepareStatement(statement);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return preparedStatement;
	}
		private static final Logger logger = Logger.getLogger("logger");
		
	    public static final String URL = "jdbc:mysql://db4free.net:3306/dmshopdb";
	    public static final String USER = "gestore_dmshop";
	    public static final String PASSWORD = "is2017";
	    public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	    
	    private static Connection connection;

}
