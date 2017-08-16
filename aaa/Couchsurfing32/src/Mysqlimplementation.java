/*This class fulfills functions of managing house.
*
* @author Qianyu.liu
* @XJTLUID 1201502
* @version 1.0 2nd March 2015
 */

import java.util.*;
import java.io.UnsupportedEncodingException;
import java.sql.*;

public class Mysqlimplementation {

	// initialise variables
	private Connection connection = null;
	private PreparedStatement stmt = null;
	private ResultSet resultSet = null;
	List<Houseinfor> list;
	Houseinfor information;

	protected static final String CTEATE_TABLE_SQL = "create table houseinformation(housenumber int(9) not null, room_type varchar(20), address varchar(120), telephone int(10), picturenumber int(10))";
	protected static final String INSERT_HOUSE_INFO = "insert into houseinformation(housenumber, room_type, address, telephone, picturenumber) values(?,?,?,?,?)";
	protected static final String SELECT_SQL = "select * from houseinformation";
	protected static final String DELETE_SQL = "delete from houseinformation where picturenumber=?";
	protected static final String SELECT_User = "update houseinformation set room_type=? where telephone=?";

	public Mysqlimplementation() {
		try {
			this.getConnection();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	private Connection getConnection() throws SQLException {

		if (connection == null) {
			synchronized (Mysqlimplementation.class) {
				if (connection == null) {
					connection = Mysqlbuilder.getInstance().getConnection();
				}
			}
		}
		return connection;
	}

	public void createTable() throws SQLException {
		getConnection();
		try {
			// create and execute statement
			stmt = connection.prepareStatement(CTEATE_TABLE_SQL);
			stmt.executeUpdate();
			System.out.println("Table Created Successfully");
		} finally {
			// close connection
			if (stmt != null)
				stmt.close();
			if (connection != null)
				connection.close();
		}

	}

	public void add(Houseinfor houseinfor1) throws SQLException {

		getConnection();
		try {
			// create and execute statement
			stmt = connection.prepareStatement(INSERT_HOUSE_INFO);
			stmt.setInt(1, houseinfor1.getHousenumber());
			stmt.setString(2, houseinfor1.getRoom_type());
			stmt.setString(3, houseinfor1.getAddress());
			stmt.setInt(4, houseinfor1.getTelephone());
			stmt.setInt(5, houseinfor1.getPicturenumber());

			System.out.println(houseinfor1.getHousenumber());
			stmt.executeUpdate();
			System.out.println("Data Added Successfully");
		} finally {

		}
	}

	public void delete(int housenumber) throws SQLException {

		getConnection();
		try {
			// create and execute statement
			stmt = connection.prepareStatement(DELETE_SQL);
			stmt.setInt(1, housenumber);
			stmt.executeUpdate();
			System.out.println("Data deleted Successfully");
		} finally {

		}
	}

	public List<Houseinfor> findallhouseinfor() throws SQLException {

		getConnection();
		try {
			// create as well execute the statement
			stmt = connection.prepareStatement(SELECT_SQL);
			resultSet = stmt.executeQuery();
			list = new ArrayList<Houseinfor>();
			while (resultSet.next()) {
				information = new Houseinfor(resultSet.getInt(1),
						resultSet.getString(2), resultSet.getString(3),
						resultSet.getInt(4), resultSet.getInt(5));
				System.out.println(information.getHousenumber());
				list.add(information);
			}
		} finally {

		}
		return list;
	}

}
