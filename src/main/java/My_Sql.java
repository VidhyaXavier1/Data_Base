import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class My_Sql {

	public static void main(String[] args) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "root");
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM city where ID=1;");
		while(rs.next())
		{
			int id=rs.getInt(1);
			String name=rs.getString(2);
			String country=rs.getString(3);
			String district=rs.getString(4);
			String population=rs.getString(5);
			System.out.println(id + " " + name + " " + country + " " +district + " " +population + " ");
		}
            
	}

}
