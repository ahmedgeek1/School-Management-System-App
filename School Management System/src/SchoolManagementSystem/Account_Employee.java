package SchoolManagementSystem;
import java.util.ArrayList;

//class Account_employee is child class for the parent class Account
public class Account_Employee extends Account{
	//attributes for the class Account_Employee
	String job1;
	String job2;
	
	//generate constructor based on the parent class and the new child class attributes
	public Account_Employee(String userid, String password, String name, String email, String phonenumber, String sex,
			String job1, String job2) {
		super(userid, password, name, email, phonenumber, sex);
		this.job1 = job1;
		this.job2 = job2;
	}

	//generate getters and setters
	public String getJob1() {
		return job1;
	}
	public void setJob1(String job1) {
		this.job1 = job1;
	}
	public String getJob2() {
		return job2;
	}
	public void setJob2(String job2) {
		this.job2 = job2;
	}
						
	// Method that returns the current logged in employee account
	static Account_Employee Current_Employee(String userloginentered, String passwordidentered, ArrayList<Account_Employee> listOfaccounts){
		String currentuserloginid;
		String currentuserpasswordid;
		Account_Employee Actual_account = null;
		for(int i=0; i<listOfaccounts.size(); i++){
			
			Account_Employee account = listOfaccounts.get(i);
			
			//Account account = cust.listOfaccounts;
			
			currentuserloginid = account.getUserid();
			
			currentuserpasswordid = account.getPassword();

			if(currentuserloginid.equals(userloginentered)  && currentuserpasswordid.equals(passwordidentered)){
				Actual_account = account;
			}
		}
		return Actual_account;
	}
	
	//method that will calculate the earning of the employee for each jobn based on number of hours worked and the rate per hour
	 public static double CalculateEarnings(double numofhours, double rate) {
		double total;
		total = numofhours * rate;
		return total;
	}
			
			
}
