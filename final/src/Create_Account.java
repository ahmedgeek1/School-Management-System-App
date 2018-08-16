import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
//create account class
public class Create_Account extends JFrame {

	private JPanel contentPane;
	private final JLabel lbluseridprompt = new JLabel("User id");//create label to prompt the user to enter a username
	private final JLabel lblPassword = new JLabel("Password");//create label to prompt the user to enter a password
	private final JLabel lblNameprompt = new JLabel("Name");//create label to prompt the user to enter a name
	private final JLabel lblEmailPrompt = new JLabel("Email");//create label to prompt the user to enter the email
	private final JLabel lblPhoneNumberPrompt = new JLabel("Phonenumber");//create label to prompt the user to enter a phone number
	private final JLabel lblSexPrompt = new JLabel("Sex");//create label to prompt the user to enter the gender
	private final JLabel lblVar1 = new JLabel("Class 1: if student / Job 1: if employee");//create label to prompt the user to enter the class1 name if the user is student or job1 if the user is staff
	private final JLabel lblVar2 = new JLabel("Class 1: if student / Job 1: if employee");//create label to prompt the user to enter the class2 name if the user is student or job2 if the user is staff
	private final JTextField Textfieldcreateuserid = new JTextField(); //texfield for user to enter username for the new account to be created 
	private final JPasswordField textFieldCreatePassword = new JPasswordField();//texfield for user to enter password for the new account to be created 
	private final JTextField textFieldCreateName = new JTextField();//texfield for user to enter the name for the new account to be created 
	private final JTextField textFieldCreateEmail = new JTextField();//texfield for user to enter email for the new account to be created 
	private final JTextField textFieldCreatePhoneNumber = new JTextField();//texfield for user to enter phobe number for the new account to be created 
	private final JTextField textFieldCreateSex = new JTextField();//texfield for user to enter the gender for the new account to be created 
	private final JTextField textFieldCreateVar1 = new JTextField();//texfield for user to enter either class1  or job1 for the new account to be created 
	private final JTextField textFieldCreateVar2 = new JTextField();//texfield for user to enter either class2  or job2 for the new account to be created 
	private final JButton btnCreateAccount = new JButton("Create Account"); //create new account button
	private final JButton btnCancel = new JButton("Cancel"); //if the user wants to cancel and go back to login page
	private final JLabel label = new JLabel("\u00A9 Ahmed Matoussi"); //copyrights label
	private final JLabel lblPleaseFillIn = new JLabel("Please fill in with your details in order to create an account!\r\nAll fields are required");//label to prompt the user to fill in details top create account
	MainAppFrame main = new MainAppFrame(); //instantiate MainAppFrame main

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Create_Account frame = new Create_Account();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Create_Account() {
		//set how the items in the window look like
		textFieldCreatePassword.setFont(new Font("Arial", Font.BOLD, 11));
		textFieldCreatePassword.setColumns(10);
		textFieldCreateVar2.setFont(new Font("Arial", Font.BOLD, 11));
		textFieldCreateVar2.setColumns(10);
		textFieldCreateVar1.setFont(new Font("Arial", Font.BOLD, 11));
		textFieldCreateVar1.setColumns(10);
		textFieldCreateSex.setFont(new Font("Arial", Font.BOLD, 11));
		textFieldCreateSex.setColumns(10);
		textFieldCreatePhoneNumber.setFont(new Font("Arial", Font.BOLD, 11));
		textFieldCreatePhoneNumber.setColumns(10);
		textFieldCreateEmail.setFont(new Font("Arial", Font.BOLD, 11));
		textFieldCreateEmail.setColumns(10);
		textFieldCreateName.setFont(new Font("Arial", Font.BOLD, 11));
		textFieldCreateName.setColumns(10);
		Textfieldcreateuserid.setFont(new Font("Arial", Font.BOLD, 11));
		Textfieldcreateuserid.setColumns(10);
		initGUI();
	}
	private void initGUI() {
		setTitle("Create an Account");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 735, 564);
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
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(lblPassword, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(lblNameprompt, Alignment.LEADING)
											.addComponent(lblVar1, Alignment.LEADING)
											.addComponent(lblVar2, Alignment.LEADING)
											.addComponent(lblSexPrompt, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
										.addComponent(lbluseridprompt)
										.addComponent(lblEmailPrompt, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblPhoneNumberPrompt, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
									.addGap(207)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(Textfieldcreateuserid, 160, 160, 160)
										.addComponent(textFieldCreatePassword, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
										.addComponent(textFieldCreateEmail, 160, 160, 160)
										.addComponent(textFieldCreateName, 160, 160, 160)
										.addComponent(textFieldCreatePhoneNumber, 160, 160, 160)
										.addComponent(textFieldCreateVar2, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
										.addComponent(textFieldCreateVar1, 160, 160, 160)
										.addComponent(textFieldCreateSex, 160, 160, 160)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnCreateAccount, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
									.addGap(40)
									.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(63)
							.addComponent(lblPleaseFillIn)))
					.addContainerGap(218, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(33)
					.addComponent(lblPleaseFillIn)
					.addPreferredGap(ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(Textfieldcreateuserid, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbluseridprompt))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(textFieldCreatePassword, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNameprompt)
						.addComponent(textFieldCreateName, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldCreateEmail, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmailPrompt))
					.addGap(12)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldCreatePhoneNumber, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPhoneNumberPrompt))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSexPrompt)
						.addComponent(textFieldCreateSex, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblVar1)
						.addComponent(textFieldCreateVar1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblVar2)
						.addComponent(textFieldCreateVar2, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCreateAccount, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGap(17)
					.addComponent(label))
		);
		btnCreateAccount.setFont(new Font("Arial", Font.BOLD, 11));
		btnCancel.setBackground(new Color(139, 0, 0));
		btnCancel.setFont(new Font("Arial", Font.BOLD, 11));
		btnCancel.setForeground(Color.WHITE);
		btnCreateAccount.setForeground(Color.WHITE);
		btnCreateAccount.setBackground(new Color(139, 0, 0));
		label.setForeground(Color.BLUE);
		lblPleaseFillIn.setFont(new Font("Arial", Font.BOLD, 15));
		lbluseridprompt.setFont(new Font("Arial", Font.BOLD, 15));
		lblPassword.setFont(new Font("Arial", Font.BOLD, 15));
		lblNameprompt.setFont(new Font("Arial", Font.BOLD, 15));
		lblEmailPrompt.setFont(new Font("Arial", Font.BOLD, 15));
		lblPhoneNumberPrompt.setFont(new Font("Arial", Font.BOLD, 15));
		lblSexPrompt.setFont(new Font("Arial", Font.BOLD, 15));
		lblVar1.setFont(new Font("Arial", Font.BOLD, 15));
		lblVar2.setFont(new Font("Arial", Font.BOLD, 15));
		label.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 11));
		
		btnCancel.addActionListener(new ActionListener() { //cancel account button clicked
			public void actionPerformed(ActionEvent e) {
				dispose(); //close this form 
				main.setVisible(true); //show the main form of the login
			}
		});
		
		btnCreateAccount.addActionListener(new ActionListener() { //if create account has been pressed
			public void actionPerformed(ActionEvent e) {
				
				if(Textfieldcreateuserid.getText().isEmpty() || textFieldCreatePassword.getText().isEmpty()|| textFieldCreateName.getText().isEmpty() || textFieldCreateEmail.getText().isEmpty() || textFieldCreatePhoneNumber.getText().isEmpty() || textFieldCreateSex.getText().isEmpty() || textFieldCreateVar1.getText().isEmpty() || textFieldCreateVar2.getText().isEmpty())
				{ //if one of the textfields are empty then show validation message
				JOptionPane.showMessageDialog(null, "Please enter all the required fields");
				}else { //if all textfields are filled
					if(MainAppFrame.student_or_employee == 1) { //1 if creating student account
					boolean userNameExists;
					userNameExists = Account.verify_user_exists(MainAppFrame.student_or_employee, Textfieldcreateuserid.getText()); //verify if the username entered exists in the listy
					if(!userNameExists) { //if it doesn't exists
					//create a new student account
						insertAccountDetails(MainAppFrame.student_or_employee, Textfieldcreateuserid.getText(), textFieldCreatePassword.getText(), textFieldCreateName.getText(), textFieldCreateEmail.getText(), textFieldCreatePhoneNumber.getText(), textFieldCreateSex.getText(), textFieldCreateVar1.getText(), textFieldCreateVar2.getText());
						//MainAppFrame.ac_students.add(ac_stud); //add this student to the sc_student list
					JOptionPane.showMessageDialog(null, "An Account has been successfully created! Please Login to verify your details!");//show message 
					dispose(); //close this form and go to main login window
					main.setVisible(true);
					}else {
					JOptionPane.showMessageDialog(null, "A username already exists, please enter another username"); //if username already exists
					}
				}else if(MainAppFrame.student_or_employee == 2) {//2 if creating employee account
					boolean userNameExists;
					userNameExists = Account.verify_user_exists(MainAppFrame.student_or_employee, Textfieldcreateuserid.getText());
					if(!userNameExists) {//if it doesn't exists
						//create a new employee account
						insertAccountDetails(MainAppFrame.student_or_employee, Textfieldcreateuserid.getText(), textFieldCreatePassword.getText(), textFieldCreateName.getText(), textFieldCreateEmail.getText(), textFieldCreatePhoneNumber.getText(), textFieldCreateSex.getText(), textFieldCreateVar1.getText(), textFieldCreateVar2.getText());
					//MainAppFrame.ac_employees.add(ac_emp);
					//MainAppFrame main = new MainAppFrame();
					JOptionPane.showMessageDialog(null, "An Account has been successfully created! Please Login to verify your details!");
					dispose();//close this form and go to main login window
					main.setVisible(true);
					}else{
					JOptionPane.showMessageDialog(null, "A username already exists, please enter another username");//if username already exists
				}
					}
				}
			}
		});
		contentPane.setLayout(gl_contentPane);
	}
	
	public static void insertAccountDetails(int a, String userName, String pw, String name, 
			String email, String phnumber, String sex, String var1, String var2) {
		String table, query = null;
		try(Connection conn = CreateConnection.getConnection();
			Statement statement = conn.createStatement()) {
			if(a==2) {
				table = "employee_account";
				query = "insert into employee_account (`emp_user_name`, `emp_password`, emp_name, emp_email, emp_ph_number,"
						+ "emp_sex, emp_job1, emp_job2)"
						+ " values (?, ?, ?, ?, ?, ?, ?, ?)";
			}else if(a==1){
				table = "student_account";
				query = "insert into student_account (`stud_user_name`, `stud_password`, stud_name, stud_email, stud_ph_number,"
						+ "stud_sex, stud_class1, stud_class2)"
						+ " values (?, ?, ?, ?, ?, ?, ?, ?)";
			}
			/*int ret = statement.executeUpdate("INSERT INTO student_account VALUES (" +
					  "'aa', 'aa', 'aa', 'aa', 'asa', 'asa', 'asa', 'asa')");

			System.out.println(ret);*/

		      // create the mysql insert preparedstatement
		      PreparedStatement preparedStmt = conn.prepareStatement(query);
		      preparedStmt.setString (1, userName);
		      preparedStmt.setString (2, pw);
		      preparedStmt.setString (3, name);
		      preparedStmt.setString (4, email);
		      preparedStmt.setString (5, phnumber);
		      preparedStmt.setString (6, sex);
		      preparedStmt.setString (7, var1);
		      preparedStmt.setString (8, var2);

		      // execute the preparedstatement
		      preparedStmt.execute();
		      conn.close();
			//System.out.println(ret);
		}
		catch(SQLException e) {
			System.out.println("insertAccountDetails:       "+e);
		}

	}
}
