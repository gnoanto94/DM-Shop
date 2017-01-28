package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class Database {
	
	public static void openConnection() {
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
	
	public static boolean closeConnection() {
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
	
	public static ResultSet executeQuery(String query) throws SQLException {
		openConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		
		return resultSet;
	}
	
	public static PreparedStatement getPreparedStatement(String statement) {
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
	    
	    public static void main(String[] args) {
			Database.openConnection();
			Database.closeConnection();
		}
}
