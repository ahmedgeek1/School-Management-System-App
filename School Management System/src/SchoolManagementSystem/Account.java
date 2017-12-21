package SchoolManagementSystem;
//import the arraylist
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
	public boolean SignIn(String userloginentered, String passwordidentered, ArrayList<Account_student> listOfStudentsaccounts, ArrayList<Account_Employee> listOfEmployeesaccounts){
		//declare variables
		String currentuserloginid; 
		String currentuserpasswordid;
		boolean verified = false; //boolean to verify if the user has entered the correct login details then it will return true
		
		if(listOfEmployeesaccounts == null) {
			//if the list of the employee accounts is null means we are going to take care of the student accounts list
			for(int i=0; i<listOfStudentsaccounts.size(); i++){ //a for loop for the student accounts list 
				
				Account account = listOfStudentsaccounts.get(i); //declare account and store the current account in it 
								
				currentuserloginid = account.getUserid(); //store the current account userid  
				currentuserpasswordid = account.getPassword(); //store the current account password
				
				if(currentuserloginid.equals(userloginentered)  && currentuserpasswordid.equals(passwordidentered)){ //if the current account userid and password match the fields entered in texfields 
					//there is a match
					verified = true; //verified gets true
				}
			}

		}else if(listOfStudentsaccounts==null) {
			//else if the list of the student accounts is null means we are going to take care of the employees accounts list
			for(int i=0; i<listOfEmployeesaccounts.size(); i++){//a for loop for the employees accounts list
				
				Account account = listOfEmployeesaccounts.get(i);//declare account and store the current account in it 
								
				currentuserloginid = account.getUserid(); //store the current account userid  
				currentuserpasswordid = account.getPassword(); //store the current account password
				
				if(currentuserloginid.equals(userloginentered)  && currentuserpasswordid.equals(passwordidentered)){//if the current account userid and password match the fields entered in texfields
					//there is a match
					verified = true; //verified gets true
				}
			}

		}
		
		return verified; //return if there is a match then verified will be true else password or username entered are incorrect so verified is false
	}
	
	//method that displays the details of the logged in user
	public void show_details(Account_student stud_account, Account_Employee emp_account) {
		Account_info info = new Account_info(); //create an account info window
		if(stud_account == null){ //if stud_account is null then we will take care of theb employees account
			info.setInfo(null, emp_account); //set the info of the employee account
			info.setVisible(true); //set the window info to visible
		}else if(emp_account == null){//if stud_account is null then we will take care of theb employees account
			info.setInfo(stud_account, null);
			info.setVisible(true);
		}
	}
	
	//method that verifies if the username entered while creating a new account exists
	public static boolean verify_user_exists(String userloginentered,  ArrayList<Account_student> listOfStudentsaccounts, ArrayList<Account_Employee> listOfEmployeesaccounts) {
		String currentuserloginid; //variable that will take the username of accounts already in the list
		boolean usernameexists = false; //method that returns if the user exist then true else false
		
		//run a for loop for both students accounts and employees accounts to check if the username entered exists
		
			for(int i=0; i<listOfStudentsaccounts.size(); i++){ //a for loop for the employees accounts list
				
				Account account = listOfStudentsaccounts.get(i);//declare account and store the current account in it 
								
				currentuserloginid = account.getUserid();//store the current account userid  
				
				if(currentuserloginid.equals(userloginentered)){
					//there is a match
					usernameexists = true; //username already exists
				}
			}
			
			for(int i=0; i<listOfEmployeesaccounts.size(); i++){//a for loop for the students accounts list
				
				Account account = listOfEmployeesaccounts.get(i);//declare account and store the current account in it 
								
				currentuserloginid = account.getUserid();//store the current account userid  
				
				if(currentuserloginid.equals(userloginentered)){
					//there is a match
					usernameexists = true;//username already exists
				}
			}
	return usernameexists; //return true if the username already exists else it will return false
	}
}
