package SchoolManagementSystem;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

//class account_info that will; show the info details opf the account logged in
public class Account_info extends JFrame {

	/**
	 * building and settin up the elements in the account_info window
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane; //declare the panel to use
	private final JLabel lblName = new JLabel("Name: "); //create label to display the user name
	private final JLabel lblEmail = new JLabel("Email");//create label to display the user email
	private final JLabel lblPhonenumber = new JLabel("phonenumber");//create label to display the user phone number
	private final JLabel lblSex = new JLabel("sex");//create label to display the user gender
	private final JLabel lblUserid = new JLabel("userid");//create label to display the user username
	private final JLabel lblClass_1 = new JLabel("class1"); //create label to display the user calss 1
	private final JLabel lblClass_2 = new JLabel("class2"); //create label to display the user class 2
	private final JTextField textFieldGardeClass1 = new JTextField(); //create textfield to enter first variable which will be used as grade for student/number of hours worked for employees
	private final JTextField textFieldGradeClass2 = new JTextField(); //create textfield to enter second variable which will be used as grade for student/number of hours worked for employees
	private final JButton btnCalculatePercentageClass1 = new JButton("Calculate Percentage"); //create a button to calculate percentage of class 1
	private final JButton btnCalculatePercentageClass2 = new JButton("Calculate Percentage");//create a button to calculate percentage of class 2
	private final JButton btnLogout = new JButton("Logout"); //create logout button
	private final JTextField textFieldTotalClass1 = new JTextField(); //create textfield to enter third variable which will be used as total grade for student/rate per hours worked for employees
	private final JTextField textFieldTotalClass2 = new JTextField();//create textfield to enter fourth variable which will be used as total grade for student/rate per hours worked for employees
	private final JLabel lblCurrentgradeclass1Prompt = new JLabel("Your Current Grade"); //label to prompt the user to enter the first variable
	private final JLabel lblCurrentGradeClass2Prompt = new JLabel("Your Current Grade");//label to prompt the user to enter the second variable
	private final JLabel lblTotalClass1Prompt = new JLabel("Total");//label to prompt the user to enter the 3rd variable
	private final JLabel lblTotalClass2Prompt = new JLabel("Total");//label to prompt the user to enter the 4th variable
	private final JButton btnCalculateSum2 = new JButton("Calculate SUM of earning"); //button to calculate the sum of earning for job 1
	private final JButton btnCalculateSum1 = new JButton("Calculate SUM of earning"); //button to calculate the sum of earning for job 2
	private final JLabel label = new JLabel("\u00A9 Ahmed Matoussi"); //copirights label
	private final JLabel lblAccountDetails = new JLabel("My account"); //label on the top to show that we are in my account window

	/**
	 * Launch the application.
	 */
	//method that will set the infos for each label in the window
	public void setInfo(Account_student stud_account, Account_Employee empl_account) {
		if(empl_account == null) {//if empl_account is null then we will take care of the stud_account
		lblUserid.setText("User id: " + stud_account.getUserid()); //set the label to the username of the logged in user
		lblName.setText("Student Name: "+stud_account.getName());//set the label to the student name of the logged in user
		lblEmail.setText("Student Email: "+stud_account.getEmail());//set the label to the student email of the logged in user
		lblPhonenumber.setText("Student Phone Number: "+stud_account.getPhonenumber());//set the label to the phone number of the logged in user
		lblSex.setText("Student Sex: "+stud_account.getSex());//set the label to the gender of the logged in user
		lblClass_1.setText("Class 1: " + stud_account.getClass1());//set the label to the 1st class of the logged in user
		lblClass_2.setText("Class 2: "+stud_account.getClass2());//set the label to the 2nd class of the logged in user
		btnCalculateSum1.setVisible(false); //hide the calculate sum button which are for the employees
		btnCalculateSum2.setVisible(false); //hide the calculate sum button which are for the employees
		}else if(stud_account == null) {//if stud_account is null then we will take care of the empl_account
			lblUserid.setText("User id: " +empl_account.getUserid());//set the label to the username of the logged in user
			lblName.setText("Employee Name: " + empl_account.getName());//set the label to the employee name of the logged in user
			lblEmail.setText("Employee Email: "+empl_account.getEmail());//set the label to the employee email of the logged in user
			lblPhonenumber.setText("Employee Phone Number: " +empl_account.getPhonenumber());//set the label to the phone number of the logged in user
			lblSex.setText("Employee Sex: " + empl_account.getSex());//set the label to the gender of the logged in user			
			btnCalculatePercentageClass1.setVisible(false);//hide the calculate percentage button which is for the student
			btnCalculatePercentageClass2.setVisible(false);//hide the calculate percentage button which is for the student
			lblCurrentgradeclass1Prompt.setText("Number of hours: "); //if the employee is logged in then the label is set to number of hours for job1
			lblCurrentGradeClass2Prompt.setText("Number of hours: ");//if the employee is logged in then the label is set to number of hours for job2
			lblTotalClass1Prompt.setText("Rate per hour in usd: ");//if the employee is logged in then the label is set to the rate per hour for job1
			lblTotalClass2Prompt.setText("Rate per hour in usd: ");//if the employee is logged in then the label is set to the rate per hour for job1
			lblClass_1.setText("Job 1: " + empl_account.getJob1());//if the employee is logged in then the label is set to the name of the job1
			lblClass_2.setText("Job 2: " + empl_account.getJob2());//if the employee is logged in then the label is set to the name of the job2
		}
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Account_info frame = new Account_info();
					frame.setVisible(true);
				} catch (Exception e) {//catch exceptions
					e.printStackTrace(); 
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Account_info() {
		//set how the element will look like in the window
		lblAccountDetails.setFont(new Font("Script MT Bold", Font.BOLD, 35));
		textFieldTotalClass2.setFont(new Font("Arial", Font.PLAIN, 14));
		textFieldTotalClass2.setColumns(10);
		textFieldTotalClass1.setFont(new Font("Arial", Font.PLAIN, 14));
		textFieldTotalClass1.setColumns(10);
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setBackground(new Color(0, 100, 0));
		btnLogout.setFont(new Font("Arial", Font.BOLD, 15));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainAppFrame MainApp = new MainAppFrame();
				MainApp.setVisible(true);
				dispose();
				}
		});
		textFieldGradeClass2.setFont(new Font("Arial", Font.PLAIN, 14));
		textFieldGradeClass2.setColumns(10);
		textFieldGardeClass1.setFont(new Font("Arial", Font.PLAIN, 14));
		textFieldGardeClass1.setColumns(10);
		initGUI();
	}
	
	//method that will display the class percentage
	public void show_class_percentage(String className, String textFieldGrade, String textFieldTotal) {
			try {
			double CurrentGradeClass = Double.parseDouble(textFieldGrade);
			double TotalClass1 = Double.parseDouble(textFieldTotal);
			double percentage;
			percentage = Account_student.CalculatePercentage(CurrentGradeClass, TotalClass1);
			if(percentage == -1){
				JOptionPane.showMessageDialog(null, "Current grade cannot be greater than total grade!");	
			}
			else if(percentage>=70) {
				JOptionPane.showMessageDialog(null, "Your percentage in " + className + " is: " + percentage + " %\n Minimum needed is 70% \n Congrats you pass the class!");			
			}else {
				JOptionPane.showMessageDialog(null, "Your percentage in " + className + " is: " + percentage + " %\n Minimum needed is 70% \n Unfortunately you fail the class!");			
			}
		}catch (Exception ex) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Please enter a valid numeric Grade/Total in the text fields");
			textFieldGardeClass1.setText("");
			textFieldTotalClass1.setText("");
		}

	}
	
	//method that will display the job earning 
	public void show_job_earnings(String numberofhours, String rateperhour, String jobname) {
		try {
		double NumOfHours = Double.parseDouble(numberofhours);
		double RatePerHour = Double.parseDouble(rateperhour);
		double total;
		total = Account_Employee.CalculateEarnings(NumOfHours, RatePerHour);
		JOptionPane.showMessageDialog(null, "Your total earning for working as " + jobname + " is: $" + total + "");
	}catch (Exception ex) {
		// TODO: handle exception
		JOptionPane.showMessageDialog(null, "Please enter a valid numeric entry in the text fields");
		textFieldGardeClass1.setText("");
		textFieldTotalClass1.setText("");
	}

}
	private void initGUI() {
		setTitle("Account details");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1515, 520);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(22)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPhonenumber)
								.addComponent(lblEmail)
								.addComponent(lblName)
								.addComponent(lblUserid)
								.addComponent(lblSex))
							.addGap(326)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblCurrentgradeclass1Prompt)
											.addGap(18)
											.addComponent(textFieldGardeClass1, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblCurrentGradeClass2Prompt, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addGap(18)
											.addComponent(textFieldGradeClass2, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)))
									.addGap(68)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblTotalClass1Prompt)
											.addGap(18)
											.addComponent(textFieldTotalClass1, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblTotalClass2Prompt)
											.addGap(18)
											.addComponent(textFieldTotalClass2, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(btnCalculateSum2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnCalculateSum1, GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)))
								.addComponent(lblAccountDetails, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(241)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(btnCalculatePercentageClass2)
										.addComponent(lblClass_1)
										.addComponent(lblClass_2)
										.addComponent(btnCalculatePercentageClass1))))
							.addPreferredGap(ComponentPlacement.RELATED, 180, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap(971, Short.MAX_VALUE)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(1229, Short.MAX_VALUE)
					.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addGap(18))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblAccountDetails)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(50)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblUserid)
									.addGap(38))
								.addComponent(lblName))
							.addGap(24)
							.addComponent(lblEmail)
							.addGap(18)
							.addComponent(lblPhonenumber))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(42)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(45)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblTotalClass1Prompt)
										.addComponent(textFieldGardeClass1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblCurrentgradeclass1Prompt)
										.addComponent(textFieldTotalClass1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnCalculateSum1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)))
								.addComponent(lblClass_1))
							.addGap(18)
							.addComponent(btnCalculatePercentageClass1)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblClass_2)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFieldTotalClass2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldGradeClass2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCurrentGradeClass2Prompt)
								.addComponent(lblTotalClass2Prompt)
								.addComponent(btnCalculateSum2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
							.addGap(27)
							.addComponent(btnCalculatePercentageClass2)
							.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
							.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(label))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblSex)
							.addContainerGap())))
		);
		btnCalculatePercentageClass2.setForeground(Color.WHITE);
		btnCalculatePercentageClass2.setBackground(new Color(139, 0, 0));
		btnCalculateSum2.setForeground(Color.WHITE);
		btnCalculateSum2.setBackground(new Color(139, 0, 0));
		btnCalculateSum1.setForeground(Color.WHITE);
		btnCalculateSum1.setBackground(new Color(139, 0, 0));
		btnCalculatePercentageClass1.setForeground(Color.WHITE);
		btnCalculatePercentageClass1.setBackground(new Color(139, 0, 0));
		label.setForeground(Color.BLUE);
		lblSex.setFont(new Font("Arial", Font.BOLD, 15));
		lblPhonenumber.setFont(new Font("Arial", Font.BOLD, 15));
		lblEmail.setFont(new Font("Arial", Font.BOLD, 15));
		lblName.setFont(new Font("Arial", Font.BOLD, 15));
		lblUserid.setFont(new Font("Arial", Font.BOLD, 15));
		lblTotalClass2Prompt.setFont(new Font("Arial", Font.BOLD, 15));
		lblClass_2.setFont(new Font("Arial", Font.BOLD, 15));
		lblCurrentGradeClass2Prompt.setFont(new Font("Arial", Font.BOLD, 15));
		lblCurrentgradeclass1Prompt.setFont(new Font("Arial", Font.BOLD, 15));
		lblClass_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblTotalClass1Prompt.setFont(new Font("Arial", Font.BOLD, 15));
		label.setFont(new Font("Arial", Font.BOLD, 15));
		btnCalculatePercentageClass2.setFont(new Font("Arial", Font.BOLD, 15));
		btnCalculatePercentageClass1.setFont(new Font("Arial", Font.BOLD, 15));
		btnCalculateSum1.setFont(new Font("Arial", Font.BOLD, 15));
		btnCalculateSum2.setFont(new Font("Arial", Font.BOLD, 15));
		
		btnCalculateSum1.addActionListener(new ActionListener() { //on click on the calculate sum 1
			public void actionPerformed(ActionEvent arg0) {
				show_job_earnings(textFieldGardeClass1.getText(), textFieldTotalClass1.getText(), lblClass_1.getText()); //call the show earning method
			}
		});
		btnCalculateSum2.addActionListener(new ActionListener() {//on click on the calculate sum 2
			public void actionPerformed(ActionEvent arg0) {
				show_job_earnings(textFieldGradeClass2.getText(), textFieldTotalClass2.getText(), lblClass_2.getText());//call the show earning method
			}
		});
		
		btnCalculatePercentageClass2.addActionListener(new ActionListener() {//on click on the calculate class 1 percentage
			public void actionPerformed(ActionEvent e) {
				show_class_percentage(lblClass_2.getText(), textFieldGradeClass2.getText(), textFieldTotalClass2.getText());//call the show class percentage method
				
			}
		});
		btnCalculatePercentageClass1.addActionListener(new ActionListener() {//on click on the calculate class 1 percentage
			public void actionPerformed(ActionEvent e) {
				show_class_percentage(lblClass_1.getText(), textFieldGardeClass1.getText(), textFieldTotalClass1.getText());//call the show class percentage method
			}
		});
		contentPane.setLayout(gl_contentPane);
	}
}
