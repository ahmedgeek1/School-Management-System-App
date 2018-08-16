import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class EditProfile extends JFrame{
	private JPanel contentPane; //declare the panel to use
	private JTextField textFieldEditUserName;
	private JPasswordField textFieldEditPassword;
	private JTextField textFieldEditName;
	private JTextField textFieldEditEmail;
	private JTextField textFieldEditPhone;
	private JTextField textFieldEditSex;
	private JTextField textFieldEditVar1;
	private JTextField textFieldEditVar2;
	Account_info acinfo;
	public EditProfile() {
		
		JLabel lblUsername = new JLabel("Username: ");
		
		JLabel lblPassword = new JLabel("Password:");
		
		JLabel lblName = new JLabel("Name:");
		
		JLabel lblEmail = new JLabel("Email:");
		
		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		
		JLabel lblSex = new JLabel("Sex:");
		
		textFieldEditUserName = new JTextField();
		textFieldEditUserName.setColumns(10);
		
		textFieldEditPassword = new JPasswordField();
		textFieldEditPassword.setColumns(10);
		
		textFieldEditName = new JTextField();
		textFieldEditName.setColumns(10);
		
		textFieldEditEmail = new JTextField();
		textFieldEditEmail.setColumns(10);
		
		textFieldEditPhone = new JTextField();
		textFieldEditPhone.setColumns(10);
		
		textFieldEditSex = new JTextField();
		textFieldEditSex.setColumns(10);
		
		JLabel lblVar = new JLabel("Var1: ");
		
		textFieldEditVar1 = new JTextField();
		textFieldEditVar1.setColumns(10);
		
		JLabel lblVar_1 = new JLabel("var 2");
		
		textFieldEditVar2 = new JTextField();
		textFieldEditVar2.setColumns(10);
		
		JButton btnCancelEdit = new JButton("Cancel");
		btnCancelEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				acinfo = new Account_info();
				acinfo.setInfo(textFieldEditUserName.getText(), textFieldEditPassword.getText(), MainAppFrame.SignedInAccount);////display the details of the logged in student
				dispose(); //close this form 
				acinfo.setVisible(true); //show the main form of the login
			}
		});
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("fsvdfvdf");
				if(textFieldEditPassword.getText().trim().isEmpty() || textFieldEditName.getText().trim().isEmpty() || textFieldEditEmail.getText().trim().isEmpty() || textFieldEditPhone.getText().trim().isEmpty() || textFieldEditSex.getText().trim().isEmpty() || textFieldEditVar1.getText().trim().isEmpty() || textFieldEditVar2.getText().trim().isEmpty()) {
					//if one of the textfields are empty then show validation message
					JOptionPane.showMessageDialog(null, "Please enter all the required fields");
				}else {
					editAccountInfo(MainAppFrame.SignedInAccount, textFieldEditUserName.getText(), textFieldEditPassword.getText(), textFieldEditName.getText(),
							textFieldEditEmail.getText(), textFieldEditPhone.getText(), textFieldEditSex.getText(),
							textFieldEditVar1.getText(), textFieldEditVar2.getText());
					Account_info acinf = new Account_info();
					acinf.setInfo(textFieldEditUserName.getText(), textFieldEditPassword.getText(), MainAppFrame.SignedInAccount);////display the details of the logged in student
					dispose(); //close this form 
					acinf.setVisible(true); //show the main form of the login	
				}
			}
		});
		
		JLabel lblEditProfile = new JLabel("Edit Profile");
		lblEditProfile.setFont(new Font("Tempus Sans ITC", Font.BOLD, 21));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(83)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblVar_1)
						.addComponent(lblVar)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblUsername)
								.addComponent(lblPassword)
								.addComponent(lblName)
								.addComponent(lblEmail)
								.addComponent(lblPhoneNumber)
								.addComponent(lblSex))
							.addGap(13)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textFieldEditSex)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(textFieldEditVar1, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
										.addComponent(textFieldEditVar2, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(btnCancelEdit)
											.addPreferredGap(ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
											.addComponent(btnEdit, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))))
								.addComponent(textFieldEditPhone, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
								.addComponent(textFieldEditEmail)
								.addComponent(textFieldEditName)
								.addComponent(textFieldEditPassword)
								.addComponent(textFieldEditUserName)
								.addComponent(lblEditProfile, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addContainerGap(189, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblEditProfile)
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsername)
						.addComponent(textFieldEditUserName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(textFieldEditPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(textFieldEditName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail)
						.addComponent(textFieldEditEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPhoneNumber)
						.addComponent(textFieldEditPhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSex)
						.addComponent(textFieldEditSex, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblVar)
						.addComponent(textFieldEditVar1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblVar_1)
						.addComponent(textFieldEditVar2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelEdit)
						.addComponent(btnEdit))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					EditProfile frame = new EditProfile();
					frame.setVisible(true);
				} catch (Exception e) {//catch exceptions
					e.printStackTrace(); 
				}
			}
		});
	}
	public void displayTextBoxFields(int a, String userName) {
		String table, query = null;
	    ResultSet rs = null;

		try(Connection conn = CreateConnection.getConnection()){
			if(a==1) {
				query = "select * from student_account where stud_user_name=?";
			}else if(a==2) {
				query = "select * from employee_account where emp_user_name=?";
			}
		      // create the mysql insert preparedstatement
		      PreparedStatement preparedStmt = conn.prepareStatement(query);
		      preparedStmt.setString (1, userName);

		      // execute the preparedstatement
		      rs = preparedStmt.executeQuery();
		      rs.next();
		      
		      textFieldEditUserName.setText(rs.getString(2));	
		      textFieldEditUserName.setEditable(false);
		      textFieldEditPassword.setText(rs.getString(3));
		      textFieldEditName.setText(rs.getString(4));
		      textFieldEditEmail.setText(rs.getString(5));
		      textFieldEditPhone.setText(rs.getString(6));
		      textFieldEditSex.setText(rs.getString(7));
		      textFieldEditVar1.setText(rs.getString(8));
		      textFieldEditVar2.setText(rs.getString(9));

		      conn.close();

		}catch(SQLException e) {
				System.out.println("displayTextBoxFields: "+e);
			}
	}
	public void editAccountInfo(int a, String userName, String pw, String name, 
			String email, String phnumber, String sex, String var1, String var2) {
		String table, query = null;
		try(Connection conn = CreateConnection.getConnection();
			Statement statement = conn.createStatement()) {
			if(a==2) {
				table = "employee_account";
				query = "update employee_account set `emp_password`= ?, emp_name= ?, emp_email= ?, emp_ph_number= ?,"
						+ "emp_sex= ?, emp_job1= ?, emp_job2= ? where emp_user_name = ?";
			}else if(a==1){
				table = "student_account";
				query = "update student_account set `stud_password`= ?, stud_name= ?, stud_email= ?, stud_ph_number= ?,"
						+ "stud_sex= ?, stud_class1 = ?, stud_class2 = ?  where stud_user_name = ?";
			}

		      // create the mysql insert preparedstatement
		      PreparedStatement preparedStmt = conn.prepareStatement(query);
		      preparedStmt.setString (1, pw);
		      preparedStmt.setString (2, name);
		      preparedStmt.setString (3, email);
		      preparedStmt.setString (4, phnumber);
		      preparedStmt.setString (5, sex);
		      preparedStmt.setString (6, var1);
		      preparedStmt.setString (7, var2);
		      preparedStmt.setString (8, userName);

		      // execute the preparedstatement
		      preparedStmt.executeUpdate();
		      conn.close();
			//System.out.println(ret);
		}
		catch(SQLException e) {
			System.out.println("editAccountInfo: "+e);
		}
	}
	
}
