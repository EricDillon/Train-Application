package Train_Ticket;

import java.sql.*;

/*
 * This class accesses the database and returns  info using the 
 * constants provided below.
 */


public class TrainDAO 
{

	private final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver"; 
	private final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USERNAME = "hr";
	private final String PASSWORD = "hr";
	
	
	
	
	/*
	 * Accesses the database
	 * returns an instance of a Train class
	 */
	public Train findTrain(int trainNo) throws Exception
	{
		Class.forName(DRIVER_NAME);
		Connection con = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD); // Database name, username, password
		
		Statement st = con.createStatement();
		
		try
		{
			ResultSet rs = st.executeQuery("select * from trains where train_no = " + trainNo);
			rs.next();
			System.out.println(rs.getString(1) + ", " + rs.getString(2) + ", " + rs.getString(3) + ", " + rs.getString(4)+ ", " + rs.getString(5));
			return new Train(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5));
		}
		catch (Exception e)
		{
			System.out.println("Train with given number does not exist");
			return null;
		}
		
	}
	
}
