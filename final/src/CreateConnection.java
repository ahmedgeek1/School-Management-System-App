import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateConnection {
	static Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://den1.mysql6.gear.host/javanwctschool";
		java.util.Properties prop = new java.util.Properties();
		prop.put("user", "javanwctschool");
		prop.put("password", "Ab6XRxj!24c~");
		return DriverManager.getConnection(url, prop);
	}
}
