import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTables {

	public static void createStudentAndEmployeeTables() {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement statement = null;
		try {
			String url = "jdbc:mysql://den1.mysql6.gear.host/javanwctschool";
			String username = "javanwctschool";
			String password = "Ab6XRxj!24c~";
			
			//Establish database connection
			conn = DriverManager.getConnection(url, username, password);
			
			//Create a statement
			statement = conn.createStatement();
			int resultStudTable = statement.executeUpdate("CREATE TABLE IF NOT EXISTS student_account " +
												" (stud_id INT PRIMARY KEY AUTO_INCREMENT, " +
												" stud_user_name VARCHAR(250), " +
												" stud_password VARCHAR(250), " +
												" stud_name VARCHAR(250), " +
												" stud_email VARCHAR(250),"+
												" stud_ph_number VARCHAR(250),"+
												" stud_sex VARCHAR(250),"+
												" stud_class1 VARCHAR(250),"+ 
												" stud_class2 VARCHAR(250))");
			
			
			int resultEmpTable = statement.executeUpdate("CREATE TABLE IF NOT EXISTS employee_account " +
												" (emp_id INT PRIMARY KEY AUTO_INCREMENT, " +
												" emp_user_name VARCHAR(250), " +
												" emp_password VARCHAR(250), " +
												" emp_name VARCHAR(250), " +
												" emp_email VARCHAR(250),"+
												" emp_ph_number VARCHAR(250),"+
												" emp_sex VARCHAR(250),"+
												" emp_job1 VARCHAR(250),"+ 
												" emp_job2 VARCHAR(250))");

			//Print the result, we expect 1
			System.out.println(resultStudTable);
			System.out.println(resultEmpTable);

		}
		catch(SQLException e) {
			System.out.println(e);
		}
		finally {
			try {
				if (statement != null) statement.close();
				if (conn != null) conn.close();
			}
			catch(SQLException e) {}
		}
		System.out.println(conn);
	}

	}
