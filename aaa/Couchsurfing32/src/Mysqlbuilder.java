import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This class aims at creating a connection to MySQL Database
 * 
 * @author Qianyu.liu
 * @XJTLUID 1201502
 * @version 1.0 2nd March 2015
 */

public class Mysqlbuilder {
	
	private static Mysqlbuilder connecting  = null;
	private static final String driverClassName = "com.mysql.jdbc.Driver";
	private static final String Database = "qukai";
	private static final String User = "root";
	private static final String Password = "123456";
	private static final String Url = "jdbc:mysql://localhost:3306/" 
			+ Database;

	// generate a private constructor
	private Mysqlbuilder() {
		try {
			Class.forName(driverClassName).newInstance();
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	public Connection getConnection() {
		Connection connection = null;// Create connection object
		try {
			// connecting to database
			connection = DriverManager.getConnection(Url, User, Password);
		} catch (SQLException e) {
			System.out.println("Fail to connect to the database");
		}
		return connection;
	}

	public static Mysqlbuilder getInstance() {
		if (connecting  == null) {
			connecting  = new Mysqlbuilder();
		}
		return connecting ;
	}

}
