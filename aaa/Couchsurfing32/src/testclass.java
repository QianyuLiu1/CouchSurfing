/*This class tests the function of house managing.
*
* @author Qianyu.liu
* @XJTLUID 1201502
* @version 1.0 2nd March 2015
 */

import java.sql.SQLException;

public class testclass {
	public static void main(String[] args) {

		Mysqlimplementation dao = new Mysqlimplementation();
		Houseinfor house = new Houseinfor(001, "singleroom",
				"SixthRevenue,number111", 001234567, 0010);

		try {
			// dao.createTabl();
			dao.add(house);
			// dao.delete(0010);
			dao.findallhouseinfor();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
