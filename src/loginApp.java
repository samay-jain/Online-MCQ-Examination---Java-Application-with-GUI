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
		frame.setResizable(false);
		frame.setType(Type.POPUP);
		frame.getContentPane().setBackground(new Color(153, 204, 255));
		frame.setBounds(100, 100, 959, 613);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		panel.setBounds(163, 111, 632, 360);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblUsername = new JLabel("Enrollment ID");
		lblUsername.setBounds(48, 108, 198, 40);
		lblUsername.setFont(new Font("Gadugi", Font.BOLD, 28));
		panel.add(lblUsername);
		
		enrollid = new JTextField();
		enrollid.setFont(new Font("Tahoma", Font.PLAIN, 20));
		enrollid.setBounds(256, 114, 259, 37);
		panel.add(enrollid);
		enrollid.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Gadugi", Font.BOLD, 28));
		lblPassword.setBounds(48, 191, 168, 40);
		panel.add(lblPassword);
		
		JLabel lblEnterTheFollowing = new JLabel("Enter the following details");
		lblEnterTheFollowing.setFont(new Font("Futurist", Font.PLAIN, 28));
		lblEnterTheFollowing.setBounds(127, 21, 377, 40);
		panel.add(lblEnterTheFollowing);
		
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
		btnlogin.setBounds(273, 287, 85, 40);
		panel.add(btnlogin);
		
		password = new JPasswordField();
		password.setFont(new Font("Tahoma", Font.PLAIN, 20));
		password.setBounds(256, 197, 259, 38);
		panel.add(password);
		
		JLabel lblNewLabel = new JLabel("Login for Student");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNewLabel.setBounds(328, 23, 296, 78);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnSignUp = new JButton("sign up (student)");
		btnSignUp.setBackground(new Color(255, 204, 204));
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				frame.setVisible(false);
				signupstudent.main(null);
			}
		});
		btnSignUp.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSignUp.setBounds(225, 500, 148, 40);
		frame.getContentPane().add(btnSignUp);
		
		JButton btnTeachersLogin = new JButton("Teacher's login");
		btnTeachersLogin.setBackground(new Color(255, 204, 204));
		btnTeachersLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				frame.setVisible(false);
				teacherlogin.main(null);
			}
		});
		btnTeachersLogin.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnTeachersLogin.setBounds(417, 500, 148, 40);
		frame.getContentPane().add(btnTeachersLogin);
		
		JButton btnSignUpteacher = new JButton("sign up (Teacher)");
		btnSignUpteacher.setBackground(new Color(255, 204, 204));
		btnSignUpteacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				frame.setVisible(false);
				signupforteacher.main(null);
			}
		});
		btnSignUpteacher.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSignUpteacher.setBounds(604, 500, 148, 40);
		frame.getContentPane().add(btnSignUpteacher);
	}
	public static String getEnroll()
	{
		return enroll;
	}
}
