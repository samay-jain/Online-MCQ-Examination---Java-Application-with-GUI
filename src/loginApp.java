import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import java.awt.Frame;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDesktopPane;
import java.awt.Component;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpringLayout;

public class loginApp {

	private JFrame frame;
	private JTextField enrollid;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try 
				{
					loginApp window = new loginApp();
					window.frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public static String enroll="";
	ResultSet rset;
	DBCONNECT db = new DBCONNECT();
	public loginApp() {
		db.connect();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		frame.setType(Type.POPUP);
		frame.getContentPane().setBackground(new Color(153, 204, 255));
		frame.setBounds(100, 100, 959, 613);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		
		JLabel lblNewLabel = new JLabel("Login for Student");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(153, 204, 255));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(328)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
					.addGap(321))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(163)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
						.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(150))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 360, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(22, Short.MAX_VALUE))
		);
		
		JButton btnTeachersLogin = new JButton("Teacher's login");
		btnTeachersLogin.setBackground(new Color(255, 204, 204));
		btnTeachersLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				frame.setVisible(false);
				teacherlogin.main(null);
			}
		});
		btnTeachersLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton btnSignUp = new JButton("sign up (student)");
		btnSignUp.setBackground(new Color(255, 204, 204));
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				frame.setVisible(false);
				signupstudent.main(null);
			}
		});
		btnSignUp.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton btnSignUpteacher = new JButton("sign up (Teacher)");
		btnSignUpteacher.setBackground(new Color(255, 204, 204));
		btnSignUpteacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				frame.setVisible(false);
				signupforteacher.main(null);
			}
		});
		btnSignUpteacher.setFont(new Font("Tahoma", Font.BOLD, 16));
		SpringLayout sl_panel_1 = new SpringLayout();
		sl_panel_1.putConstraint(SpringLayout.WEST, btnSignUpteacher, 232, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, btnTeachersLogin, 451, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, btnSignUpteacher, 421, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.NORTH, btnTeachersLogin, 11, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, btnTeachersLogin, 54, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, btnTeachersLogin, 612, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.NORTH, btnSignUpteacher, 10, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, btnSignUpteacher, 54, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.NORTH, btnSignUp, 11, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, btnSignUp, 22, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, btnSignUp, 54, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, btnSignUp, 198, SpringLayout.WEST, panel_1);
		panel_1.setLayout(sl_panel_1);
		panel_1.add(btnSignUp);
		panel_1.add(btnSignUpteacher);
		panel_1.add(btnTeachersLogin);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(204, 204, 255));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(22)
					.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
					.addGap(24))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(21)
					.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
					.addGap(23))
		);
		
		JLabel lblEnterTheFollowing = new JLabel("Enter the following details");
		lblEnterTheFollowing.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterTheFollowing.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblEnterTheFollowing.setFont(new Font("Futurist", Font.PLAIN, 28));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(204, 204, 255));
		GroupLayout gl_desktopPane = new GroupLayout(desktopPane);
		gl_desktopPane.setHorizontalGroup(
			gl_desktopPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_desktopPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_desktopPane.createSequentialGroup()
							.addComponent(lblEnterTheFollowing, GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_desktopPane.createSequentialGroup()
							.addGap(21)
							.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(28))))
		);
		gl_desktopPane.setVerticalGroup(
			gl_desktopPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_desktopPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblEnterTheFollowing, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(9)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(18, Short.MAX_VALUE))
		);
		
		enrollid = new JTextField();
		enrollid.setAlignmentX(Component.LEFT_ALIGNMENT);
		enrollid.setFont(new Font("Tahoma", Font.PLAIN, 20));
		enrollid.setColumns(10);
		
		JLabel lblUsername = new JLabel("Enrollment ID");
		lblUsername.setFont(new Font("Gadugi", Font.BOLD, 28));
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setAlignmentY(Component.TOP_ALIGNMENT);
		lblPassword.setFont(new Font("Gadugi", Font.BOLD, 28));
		
		password = new JPasswordField();
		password.setAlignmentY(Component.TOP_ALIGNMENT);
		password.setAlignmentX(Component.LEFT_ALIGNMENT);
		password.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnlogin = new JButton("login");
		btnlogin.setBackground(new Color(255, 204, 204));
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				enroll = enrollid.getText();
				String pass = password.getText();
				if(enroll.isEmpty() || pass.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Please enter your credentials!");
				}
				else
				{
					boolean result = db.checkCredentials(enroll, pass, 1);
					if(result==true)
					{
						frame.setVisible(false);
						studenthome.main(null);
					}
					else
					{
						enrollid.setText("");
						password.setText("");
						JOptionPane.showMessageDialog(null, "Invalid Enrollment ID or Password!");
					}
				}
			}
		});
		btnlogin.setFont(new Font("Tahoma", Font.BOLD, 18));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(btnlogin, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
								.addComponent(password, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
								.addComponent(enrollid, GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE))
							.addGap(56))))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(enrollid, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(password, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
					.addComponent(btnlogin, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_2.setLayout(gl_panel_2);
		desktopPane.setLayout(gl_desktopPane);
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
	}
	public static String getEnroll()
	{
		return enroll;
	}
}
