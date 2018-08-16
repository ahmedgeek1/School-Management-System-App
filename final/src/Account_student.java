import java.lang.reflect.Array;
import java.util.ArrayList;

//acount_student class is a child of Account class
public class Account_student extends Account{

	private int numberofclasses; //number of classes for student (currently not used because of some changes in the code, but it doesn't bother
	private String class1; // class 1
	private String class2; //class 2
	
	//constructor	
	public Account_student(String userid, String password, String name, String email, String phonenumber, String sex,
			int numberofclasses, String class1, String class2) {
		super(userid, password, name, email, phonenumber, sex);
		this.numberofclasses = numberofclasses;
		this.class1 = class1;
		this.class2 = class2;
	}
	
	//generate getters and setters
	public int getNumberofclasses() {
		return numberofclasses;
	}

	public void setNumberofclasses(int numberofclasses) {
		this.numberofclasses = numberofclasses;
	}

	public String getClass1() {
		return class1;
	}

	public void setClass1(String calss1) {
		this.class1 = class1;
	}

	public String getClass2() {
		return class2;
	}

	public void setClass2(String class2) {
		this.class2 = class2;
	}
	
	
	
	//method that calculates the percentage of the grade of the student in a class
	 public static double CalculatePercentage(double currentgrade, double total) {
		double percentage;
		percentage = (currentgrade * 100) / total;
		return percentage;
	}
	 
		// Method that returns the current logged in account 
	 static Account_student Current_Student(String userloginentered, String passwordidentered, ArrayList<Account_student> listOfaccounts){
			String currentuserloginid;
			String currentuserpasswordid;
			Account_student Actual_account = null; // declare a null account which wil be returned later on
			
			for(int i=0; i<listOfaccounts.size(); i++){//a for loop for the students accounts list
				
				Account_student account = listOfaccounts.get(i);//declare account and store the current account in it 
								
				currentuserloginid = account.getUserid();//store the current account userid
				
				currentuserpasswordid = account.getPassword();//store the current account password

				if(currentuserloginid.equals(userloginentered)  && currentuserpasswordid.equals(passwordidentered)){
					//there is a match
					Actual_account = account; //the empty declared account gets the current account
				}
			}
			return Actual_account; //return the current account of the user logged in
		}

	

}
