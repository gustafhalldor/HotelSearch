package trunk;
import java.sql.*;

public class PostgresqlConnection {

	public static Connection getConnection(){
		try {
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/HotelSearch", 
					"postgres", "Gusti123");
			if(conn!=null) System.out.println("alt i orden");
			
			return conn;
		}
		catch(Exception e){
			e.printStackTrace(); 
		}
		return null;
	}
}
