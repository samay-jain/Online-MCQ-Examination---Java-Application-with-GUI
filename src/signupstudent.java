import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class signupstudent {

	private JFrame frame;
	private JTextField uname;
	private JPasswordField textpassword;
	private JTextField fname;
	private JTextField enroll;
	private JTextField roll;
	private JTextField division;
	public static JComboBox dept,year;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signupstudent window = new signupstudent();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	DBCONNECT db = new DBCONNECT();
	private JTextField password;
	public signupstudent() {
		db.connect();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	protected void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(153, 204, 255));
		frame.setBounds(100, 100, 942, 632);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSignupForStudent = new JLabel("Signup for Student");
		lblSignupForStudent.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblSignupForStudent.setBounds(317, 0, 302, 78);
		frame.getContentPane().add(lblSignupForStudent);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(204, 204, 255));
		panel.setBounds(52, 76, 827, 483);
		frame.getContentPane().add(panel);
		
		JLabel lblUsername = new JLabel("Email");
		lblUsername.setFont(new Font("Gadugi", Font.BOLD, 20));
		lblUsername.setBounds(153, 257, 143, 40);
		panel.add(lblUsername);
		
		uname = new JTextField();
		uname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		uname.setColumns(10);
		uname.setBounds(333, 260, 259, 37);
		panel.add(uname);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Gadugi", Font.BOLD, 20));
		lblPassword.setBounds(153, 307, 143, 40);
		panel.add(lblPassword);
		
		JLabel lblEnterTheFollowing = new JLabel("Enter the following details");
		lblEnterTheFollowing.setFont(new Font("Futurist", Font.PLAIN, 28));
		lblEnterTheFollowing.setBounds(245, 10, 377, 40);
		panel.add(lblEnterTheFollowing);
		
		JButton btnSignIn = new JButton("Sign up");
		btnSignIn.setBackground(new Color(255, 204, 204));
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int ind=-1;
				String en,name,dep,yea,div,rol,email,pass,cp;
				en = enroll.getText();
				name = fname.getText();
				ind = dept.getSelectedIndex();

				if(ind == 1)
					dep = "CSE";
				else if(ind == 2)
					dep = "IT";
				else if(ind == 3)
					dep = "MECHANICAL";
				else if(ind == 4)
					dep = "E&TC";
				else if(ind == 5)
					dep = "ELECTRONICS";
				else if(ind == 6)
					dep = "ECS";
				else
					dep="";

				rol = roll.getText();
				ind=-1;
				ind = year.getSelectedIndex();

				if(ind == 1)
					yea = "1";
				else if(ind == 2)
					yea = "2";
				else if(ind == 3)
					yea = "3";
				else if(ind == 4)
					yea = "4";
				else
					yea="";

				div = division.getText();
				email = uname.getText();
				pass = password.getText();
				cp = textpassword.getText();
				if(!pass.equals(cp))
				{
					JOptionPane.showMessageDialog(null, "Password and Confirm Password are Different!");
					password.setText("");
					textpassword.setText("");
				}
				else if(en.isEmpty() || name.isEmpty() || dep.isEmpty() || rol.isEmpty() || yea.isEmpty() || div.isEmpty() || email.isEmpty() || cp.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Please enter all the details!");
				}
				else
				{
					boolean b = db.StudentRegistration(en,name,dep,yea,div,rol,email,pass);
					if(b==true)
					{
						JOptionPane.showMessageDialog(null, "Registration Successfull!");
						frame.setVisible(false);
						loginApp.main(null);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Registration unsuccessfull!");
						password.setText("");
						textpassword.setText("");
					}
				}
			}
		});
		btnSignIn.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSignIn.setBounds(422, 422, 117, 40);
		panel.add(btnSignIn);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Gadugi", Font.BOLD, 20));
		lblConfirmPassword.setBounds(153, 357, 170, 40);
		panel.add(lblConfirmPassword);
		
		textpassword = new JPasswordField();
		textpassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textpassword.setBounds(333, 358, 259, 38);
		panel.add(textpassword);
		
		JLabel lblFullName = new JLabel("Full Name");
		lblFullName.setFont(new Font("Gadugi", Font.BOLD, 20));
		lblFullName.setBounds(33, 65, 143, 40);
		panel.add(lblFullName);
		
		fname = new JTextField();
		fname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		fname.setColumns(10);
		fname.setBounds(153, 68, 259, 37);
		panel.add(fname);
		
		JLabel lblEnrollmentId = new JLabel("Enrollment ID");
		lblEnrollmentId.setFont(new Font("Gadugi", Font.BOLD, 20));
		lblEnrollmentId.setBounds(456, 65, 143, 40);
		panel.add(lblEnrollmentId);
		
		JLabel lblRollNo = new JLabel("Roll No");
		lblRollNo.setFont(new Font("Gadugi", Font.BOLD, 20));
		lblRollNo.setBounds(456, 124, 143, 40);
		panel.add(lblRollNo);
		
		enroll = new JTextField();
		enroll.setFont(new Font("Tahoma", Font.PLAIN, 20));
		enroll.setColumns(10);
		enroll.setBounds(610, 68, 132, 37);
		panel.add(enroll);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setFont(new Font("Gadugi", Font.BOLD, 20));
		lblDepartment.setBounds(33, 124, 143, 40);
		panel.add(lblDepartment);
		
		JLabel lblDivision = new JLabel("Division");
		lblDivision.setFont(new Font("Gadugi", Font.BOLD, 20));
		lblDivision.setBounds(33, 189, 143, 40);
		panel.add(lblDivision);
		
		roll = new JTextField();
		roll.setFont(new Font("Tahoma", Font.PLAIN, 20));
		roll.setColumns(10);
		roll.setBounds(610, 127, 132, 37);
		panel.add(roll);
		
		division = new JTextField();
		division.setFont(new Font("Tahoma", Font.PLAIN, 20));
		division.setColumns(10);
		division.setBounds(153, 192, 259, 37);
		panel.add(division);
		
		JButton btnGoBack = new JButton("return");
		btnGoBack.setBackground(new Color(255, 204, 204));
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				frame.setVisible(false);
				loginApp.main(null);
			}
		});
		btnGoBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnGoBack.setBounds(295, 422, 117, 40);
		panel.add(btnGoBack);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setFont(new Font("Gadugi", Font.BOLD, 20));
		lblYear.setBounds(456, 189, 143, 40);
		panel.add(lblYear);
		
		password = new JTextField();
		password.setFont(new Font("Tahoma", Font.PLAIN, 20));
		password.setColumns(10);
		password.setBounds(333, 307, 259, 37);
		panel.add(password);
		
		dept = new JComboBox();
		dept.setFont(new Font("Tahoma", Font.PLAIN, 20));
		dept.setModel(new DefaultComboBoxModel(new String[] {"", "CSE", "IT", "MECHANICAL", "E&TC", "ELECTRONICS", "ECS"}));
		dept.setBounds(153, 127, 259, 33);
		panel.add(dept);
		
		year = new JComboBox();
		year.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4"}));
		year.setFont(new Font("Tahoma", Font.PLAIN, 20));
		year.setBounds(610, 196, 132, 33);
		panel.add(year);
		//frame.setVisible(true);
	}
}
