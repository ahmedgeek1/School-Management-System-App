//import the arraylist
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//the account class is the parent class for account_student and account_employee
public class Account {
	//declare the variables
	private String userid; //userid variable 
	private String password; //the password
	private String name; //the name of the user
	private String email; //the email of the user
	private String phonenumber; //the phone number of the user
	private String sex; //the sex gender of the user
	
	//contructor 
	public Account(String userid, String password, String name, String email, String phonenumber, String sex) {
		super();
		this.userid = userid;
		this.password = password;
		this.name = name;
		this.email = email;
		this.phonenumber = phonenumber;
		this.sex = sex;
	}

	//generate getters and setters for the variables/characteristics declared
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	// Method that validates the username and the password to check for a match
	public boolean SignIn(String userloginentered, String passwordidentered){
		//declare variables*
		String query1, query2;
	    ResultSet rs,rs2 = null;
		boolean verified = false; //boolean to verify if the user has entered the correct login details then it will return true
		
			try (Connection conn = CreateConnection.getConnection(); 
				Statement statement = (Statement) conn.createStatement()) {
				query1 = "select *, count(*) as count1 from student_account where stud_user_name= ? and stud_password=?";
				query2	= "select *, count(*) as count2 from employee_account where emp_user_name = ? and emp_password=?";
						
			      PreparedStatement preparedStmt = conn.prepareStatement(query1);
			      preparedStmt.setString(1, userloginentered);
			      preparedStmt.setString(2, passwordidentered);
			      rs = preparedStmt.executeQuery();
			      PreparedStatement preparedStmt2 = conn.prepareStatement(query2);
			      preparedStmt2.setString(1, userloginentered);
			      preparedStmt2.setString(2, passwordidentered);
			      rs2 = preparedStmt2.executeQuery();
			      if(rs.next()){
				      if(rs.getInt("count1")>=1) {
				    	  verified=true;
				    	  MainAppFrame.SignedInAccount = 1;
				      }
			      }
			      if(rs2.next()) {
			    	  if(rs2.getInt("count2")>=1) {
			    		  verified=true;
				    	  MainAppFrame.SignedInAccount = 2;
			    	  }
			      }
			      }
		       //now step through the records returned			
			catch(SQLException e) {
				System.out.println("SignIn : "+e);
			}

		
		
		return verified; //return if there is a match then verified will be true else password or username entered are incorrect so verified is false
	}
	
	//method that displays the details of the logged in user
	/*public void show_details(Account_student stud_account, Account_Employee emp_account) {
		Account_info info = new Account_info(); //create an account info window
		if(stud_account == null){ //if stud_account is null then we will take care of theb employees account
			info.setInfo(null, emp_account); //set the info of the employee account
			info.setVisible(true); //set the window info to visible
		}else if(emp_account == null){//if stud_account is null then we will take care of theb employees account
			info.setInfo(stud_account, null);
			info.setVisible(true);
		}
	}*/
	
	//method that verifies if the username entered while creating a new account exists
	public static boolean verify_user_exists(int a, String userloginentered) {
		String table, username;
		boolean usernameexists=false;

		if(a==1) {
			table = "student_account";
			username = "stud_user_name";
		}else {
			table = "employee_account";
			username = "emp_user_name";
		}
		try (Connection conn = CreateConnection.getConnection(); 
				Statement statement = (Statement) conn.createStatement()) {
				ResultSet rs = statement.executeQuery("SELECT count(*) as numberOfUsers FROM "+ table +
													  " WHERE "+username +" = '"+ userloginentered+"'"); {
				//now step through the records returned
													
			    while(rs.next()) {
			    	if(rs.getInt("numberOfUsers")<=0) {
			    		usernameexists = false;
			    	}else usernameexists = true;
			    }										  
			  }
			}
			catch(SQLException e) {
				System.out.println("verify_user_exists: " + e);
			}
			return usernameexists; //return true if the username already exists else it will return false
	}
}
