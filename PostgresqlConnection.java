package trunk;
import java.sql.*;

public class PostgresqlConnection {

	public static void main(String[] args){
		try {
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/HotelSearch", 
					"postgres", "gusti123");
		}
		catch(Exception e){
			e.printStackTrace(); 
		}
	}
}
