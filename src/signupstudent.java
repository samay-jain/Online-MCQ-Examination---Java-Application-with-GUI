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
import java.awt.Frame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import javax.swing.JDesktopPane;
import javax.swing.LayoutStyle.ComponentPlacement;

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
		frame.getContentPane().setBackground(new Color(153, 204, 255));
		frame.setBounds(100, 100, 942, 632);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblSignupForStudent = new JLabel("Signup for Student");
		lblSignupForStudent.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignupForStudent.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		
		JLabel lblEnterTheFollowing = new JLabel("Enter the following details");
		lblEnterTheFollowing.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterTheFollowing.setFont(new Font("Futurist", Font.PLAIN, 28));
		
		JLabel lblFullName = new JLabel("Full Name");
		lblFullName.setFont(new Font("Gadugi", Font.BOLD, 20));
		
		fname = new JTextField();
		fname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		fname.setColumns(10);
		
		JLabel lblEnrollmentId = new JLabel("Enrollment ID");
		lblEnrollmentId.setFont(new Font("Gadugi", Font.BOLD, 20));
		
		JLabel lblRollNo = new JLabel("Roll No");
		lblRollNo.setFont(new Font("Gadugi", Font.BOLD, 20));
		
		enroll = new JTextField();
		enroll.setFont(new Font("Tahoma", Font.PLAIN, 20));
		enroll.setColumns(10);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setFont(new Font("Gadugi", Font.BOLD, 20));
		
		JLabel lblDivision = new JLabel("Division");
		lblDivision.setFont(new Font("Gadugi", Font.BOLD, 20));
		
		roll = new JTextField();
		roll.setFont(new Font("Tahoma", Font.PLAIN, 20));
		roll.setColumns(10);
		
		division = new JTextField();
		division.setFont(new Font("Tahoma", Font.PLAIN, 20));
		division.setColumns(10);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setFont(new Font("Gadugi", Font.BOLD, 20));
		
		dept = new JComboBox();
		dept.setFont(new Font("Tahoma", Font.PLAIN, 20));
		dept.setModel(new DefaultComboBoxModel(new String[] {"", "CSE", "IT", "MECHANICAL", "E&TC", "ELECTRONICS", "ECS"}));
		
		year = new JComboBox();
		year.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4"}));
		year.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JDesktopPane desktopPane_3 = new JDesktopPane();
		desktopPane_3.setBackground(new Color(153, 204, 255));
		
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
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSignupForStudent, GroupLayout.DEFAULT_SIZE, 908, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(52)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 827, Short.MAX_VALUE)
					.addGap(49))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(340)
					.addComponent(desktopPane_3, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
					.addGap(334))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblSignupForStudent, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(desktopPane_3, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
		);
		GroupLayout gl_desktopPane_3 = new GroupLayout(desktopPane_3);
		gl_desktopPane_3.setHorizontalGroup(
			gl_desktopPane_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_desktopPane_3.createSequentialGroup()
					.addGap(6)
					.addComponent(btnGoBack, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnSignIn, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
					.addGap(4))
		);
		gl_desktopPane_3.setVerticalGroup(
			gl_desktopPane_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_desktopPane_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_desktopPane_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnGoBack, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSignIn, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		desktopPane_3.setLayout(gl_desktopPane_3);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(153, 204, 255));
		
		JDesktopPane desktopPane_1 = new JDesktopPane();
		desktopPane_1.setBackground(new Color(153, 204, 255));
		
		JDesktopPane desktopPane_2 = new JDesktopPane();
		desktopPane_2.setBackground(new Color(153, 204, 255));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addComponent(lblEnterTheFollowing, GroupLayout.DEFAULT_SIZE, 807, Short.MAX_VALUE)
					.addGap(10))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(13)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblFullName, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(120)
									.addComponent(fname, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(13)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(120)
									.addComponent(dept, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblDepartment, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(13)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(120)
									.addComponent(division, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblDivision, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)))
						.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE))
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(22)
							.addComponent(lblEnrollmentId, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(enroll, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(22)
							.addComponent(lblRollNo, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(roll, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(22)
							.addComponent(lblYear, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(year, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
						.addComponent(desktopPane_1, GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE))
					.addGap(59))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(198)
					.addComponent(desktopPane_2, GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
					.addGap(174))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addComponent(lblEnterTheFollowing, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(5)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblFullName, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(3)
									.addComponent(fname, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)))
							.addGap(19)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(3)
									.addComponent(dept, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblDepartment, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
							.addGap(25)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(3)
									.addComponent(division, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblDivision, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
						.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(5)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblEnrollmentId, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(3)
									.addComponent(enroll, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)))
							.addGap(19)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblRollNo, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(3)
									.addComponent(roll, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)))
							.addGap(25)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblYear, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(7)
									.addComponent(year, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))))
						.addComponent(desktopPane_1, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))
					.addGap(26)
					.addComponent(desktopPane_2, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
					.addGap(20))
		);
		
		uname = new JTextField();
		uname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		uname.setColumns(10);
		
		password = new JTextField();
		password.setFont(new Font("Tahoma", Font.PLAIN, 20));
		password.setColumns(10);
		
		textpassword = new JPasswordField();
		textpassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblUsername = new JLabel("Email");
		lblUsername.setFont(new Font("Gadugi", Font.BOLD, 20));
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Gadugi", Font.BOLD, 20));
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Gadugi", Font.BOLD, 20));
		GroupLayout gl_desktopPane_2 = new GroupLayout(desktopPane_2);
		gl_desktopPane_2.setHorizontalGroup(
			gl_desktopPane_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_desktopPane_2.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_desktopPane_2.createParallelGroup(Alignment.LEADING)
						.addComponent(lblConfirmPassword)
						.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_desktopPane_2.createParallelGroup(Alignment.TRAILING)
						.addComponent(uname, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
						.addComponent(textpassword, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
						.addComponent(password, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_desktopPane_2.setVerticalGroup(
			gl_desktopPane_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_desktopPane_2.createSequentialGroup()
					.addGroup(gl_desktopPane_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(uname, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_desktopPane_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(password, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
					.addGroup(gl_desktopPane_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(textpassword, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblConfirmPassword, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		desktopPane_2.setLayout(gl_desktopPane_2);
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
		//frame.setVisible(true);
	}
}
