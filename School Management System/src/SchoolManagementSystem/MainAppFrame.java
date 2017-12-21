/**
 * 
 * Name : Ahmed Matoussi
 * email : ahmedgeek1@gmail.com
 * Date : 12/09/2017
 * Title : School Management Application
 * Overview : An application that will allow user to login, either a student or employee in a school and review his details
 * for student: they can calculate the percentage of their classes based on their grades entries
 * for employees: they can calculate their earnings based on their 2 jobs by entering the number of hours worked and the rate per hour
 * Both students and employees can create accounts
 * the application is not using a real database, although it is using arraylist that will act as a database once the application is launched and it will be initialized if it is launched again
 * 
 * **/

package SchoolManagementSystem;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

//main class
public class MainAppFrame extends JFrame {

	/**
	 * building elements in the application window
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane; //declare the Panel
	private final JButton btnLogin = new JButton("Login"); //create the login button 
	private final JLabel lblLoginPrompt = new JLabel("User Login"); //create the login label to prompt the user
	private final JLabel lblPasswordPrompt = new JLabel("Password"); //create the password label to prompt the user
	private final JTextField txtFieldLogin = new JTextField(); //create the textfield for the username 
	private final JPasswordField  txtFieldPassword = new JPasswordField(); //create the jpassword field to enter the password
	private final JButton btnCreateStudent = new JButton("Create a student account"); //create a button for students to create a new account
	private final JButton btnCreateAnEmployee = new JButton("Create an employee account"); //create a button for students to create a new account
    public static int student_or_employee; //declare a variable to identify either the user wants to create a student or staff account
	public static ArrayList<Account_student> ac_students= new ArrayList<Account_student>(); //create an arraylist of students accounts and make it public outside the main to be accessible from outisde the class
	public static ArrayList<Account_Employee> ac_employees= new ArrayList<Account_Employee>();//create an arraylist of staff accounts and make it public outside the main to be accessible from outisde the class
	private final JLabel lblCopyrightsAhmedMatoussi = new JLabel("\u00A9 Ahmed Matoussi"); //create the copyright label
	private final JLabel lblSchoolManagementApplication = new JLabel("School Management Application"); //craete the label for the name of the application

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainAppFrame frame = new MainAppFrame();
					frame.start(); // Start the frame up, i.e. make it visible and operational.
				} catch (Exception e) {
					e.printStackTrace(); //catch the exception
				}
			}
		});
	}

	protected void start() {
		// TODO Auto-generated method stub
		   setVisible(true); //set the frame to visible and display it
	}

	/**
	 * Create the frame.
	 */
	public MainAppFrame() {

		
		//create 2 student accounts
		Account_student ac_stud1 = new Account_student("student1", "1111", "Ahmed Matoussi", "Ahmedgeek1@gmail.com", "+1 9204896334", "Male", 2, "Maths", "French");
		Account_student ac_stud2 = new Account_student("student2", "2222", "Marine Macron", "Froncois@yahoo.fr", "+33 215871258", "Female", 2, "Java", "SQL Advanced");

		//create 2 employee accounts
		Account_Employee ac_emp1 = new Account_Employee("employee1", "3333", "Alfonce bridget", "Alfonce@gmail.com", "+36 123456789", "Male", "Instructor", "Librarian");
		Account_Employee ac_emp2 = new Account_Employee("employee2", "4444", "Kari Dunlop", "Kari@gmail.com", "+1 123456789", "Male", "Teacher Assistant", "Technician");

		//add the student accounts created to the student list
		ac_students.add(ac_stud1);
		ac_students.add(ac_stud2);
		//add the employee accounts created to the employee list
		ac_employees.add(ac_emp1);
		ac_employees.add(ac_emp2);
		

		//when clicked on Login button
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//declare 2 null student and employeee accounts
				Account_student Actual_Student_account = null;
				Account_Employee Actual_Employee_Account = null;
					//verify if the login entered are correct for students (exists in students list)
					if(ac_stud1.SignIn(txtFieldLogin.getText(), txtFieldPassword.getText() , ac_students, null)) {
						//if login and password match and exist in the list
						//keep record of the actual account of the logged in student
						Actual_Student_account = Account_student.Current_Student(txtFieldLogin.getText(), txtFieldPassword.getText(), ac_students);
						dispose();//close the login window
						ac_stud1.show_details(Actual_Student_account, null);////display the details of the logged in student
					}//verify if the login entered are correct for employees (exists in employees list)
					else if (ac_emp1.SignIn(txtFieldLogin.getText(), txtFieldPassword.getText() ,null, ac_employees)) {
						//if login and password match and exist in the list
						//keep record of the actual account of the logged in employee
						Actual_Employee_Account = Account_Employee.Current_Employee(txtFieldLogin.getText(), txtFieldPassword.getText(), ac_employees);
						dispose();//close the login window
						ac_emp1.show_details(null, Actual_Employee_Account);
					}
					else { //if the login details dom't exist, then display error message
						JOptionPane.showMessageDialog(null, "Login or Password incorrect \n Please try again!");
						txtFieldLogin.setText(""); //empty the username textfield for the new entry
						txtFieldPassword.setText(""); //empty the password textfield for the new entry
					}
			}
		});
		
		lblSchoolManagementApplication.setFont(new Font("Segoe Script", Font.BOLD, 21)); //set the font of the application name label
		btnLogin.setForeground(Color.WHITE); //set the color of the text in the button
		btnLogin.setBackground(new Color(0, 100, 0)); //set the background of the button
		btnLogin.setFont(new Font("Arial", Font.BOLD, 15)); //set the font style and size of the login button
		txtFieldPassword.setColumns(10);//set the width of the username textfield 
		txtFieldLogin.setColumns(10);//set the width of the password textfield 
		initGUI(); //call the unitGUI() method
	}
	private void initGUI() {
		//set how the window look like
		setTitle("School Management Application");
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 370);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(31)
							.addComponent(btnCreateStudent)
							.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
							.addComponent(btnCreateAnEmployee))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap(383, Short.MAX_VALUE)
							.addComponent(lblCopyrightsAhmedMatoussi))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(75)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblPasswordPrompt)
										.addComponent(lblLoginPrompt))
									.addGap(53)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(txtFieldLogin)
										.addComponent(txtFieldPassword, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)))
								.addComponent(lblSchoolManagementApplication)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(220)
							.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblSchoolManagementApplication)
					.addGap(39)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLoginPrompt)
						.addComponent(txtFieldLogin, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPasswordPrompt)
						.addComponent(txtFieldPassword, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCreateAnEmployee, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCreateStudent, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblCopyrightsAhmedMatoussi)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		btnCreateStudent.setForeground(Color.WHITE);
		btnCreateStudent.setBackground(new Color(139, 0, 0));
		btnCreateAnEmployee.setForeground(Color.WHITE);
		btnCreateAnEmployee.setBackground(new Color(139, 0, 0));
		lblCopyrightsAhmedMatoussi.setForeground(new Color(0, 0, 255));
		btnCreateStudent.setFont(new Font("Arial", Font.BOLD, 15));
		btnCreateAnEmployee.setFont(new Font("Arial", Font.BOLD, 15));
		lblLoginPrompt.setFont(new Font("Arial", Font.BOLD, 15));
		lblPasswordPrompt.setFont(new Font("Arial", Font.BOLD, 15));
		lblCopyrightsAhmedMatoussi.setFont(new Font("Arial", Font.BOLD, 15));
		//on click on the button create a student account
		btnCreateStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				student_or_employee = 1;
				Create_Account creat_ac = new Create_Account();
				dispose();
				creat_ac.setVisible(true);
			}
		});
		
		//on click on button create enployee account
		btnCreateAnEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				student_or_employee = 2;
				Create_Account creat_ac = new Create_Account();
				dispose();
				creat_ac.setVisible(true);
			}
		});
		contentPane.setLayout(gl_contentPane);
	}
}
