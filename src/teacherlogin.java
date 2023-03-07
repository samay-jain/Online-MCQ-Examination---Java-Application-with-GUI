import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class teacherlogin {

	private JFrame frame;
	private JTextField email;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					teacherlogin window = new teacherlogin();
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
	public static String tid,tname;
	String arr[];
	public teacherlogin() {
		db.connect();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(153, 204, 255));
		frame.setBounds(100, 100, 968, 574);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLoginForTeacher = new JLabel("Login for Teacher");
		lblLoginForTeacher.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblLoginForTeacher.setBounds(338, 10, 271, 78);
		frame.getContentPane().add(lblLoginForTeacher);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(204, 204, 255));
		panel.setBounds(107, 98, 741, 385);
		frame.getContentPane().add(panel);
		
		JLabel lblUsername = new JLabel("Email");
		lblUsername.setFont(new Font("Gadugi", Font.BOLD, 28));
		lblUsername.setBounds(148, 110, 143, 40);
		panel.add(lblUsername);
		
		email = new JTextField();
		email.setFont(new Font("Tahoma", Font.PLAIN, 20));
		email.setColumns(10);
		email.setBounds(301, 116, 259, 37);
		panel.add(email);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Gadugi", Font.BOLD, 28));
		lblPassword.setBounds(148, 178, 143, 40);
		panel.add(lblPassword);
		
		JLabel lblEnterTheFollowing = new JLabel("Enter the following details");
		lblEnterTheFollowing.setFont(new Font("Futurist", Font.PLAIN, 28));
		lblEnterTheFollowing.setBounds(183, 23, 377, 40);
		panel.add(lblEnterTheFollowing);
		
		JButton btnlogin = new JButton("login");
		btnlogin.setBackground(new Color(255, 204, 204));
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String em = email.getText();
				String pass = password.getText();
				if(em.isEmpty() || pass.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Please enter your credentials!");
				}
				else
				{
					boolean result = db.checkCredentials(em, pass, 0);
					if(result==true)
					{
						arr = db.getTeacherDetails(em, pass);
						tid=arr[0];
						tname=arr[1];
						frame.setVisible(false);
						teacherhome.main(null);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Invalid Email or Password!");
						email.setText("");
						password.setText("");
					}
				}
			}
		});
		btnlogin.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnlogin.setBounds(389, 283, 115, 48);
		panel.add(btnlogin);
		
		password = new JPasswordField();
		password.setFont(new Font("Tahoma", Font.PLAIN, 20));
		password.setBounds(301, 184, 259, 38);
		panel.add(password);
		
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
		btnGoBack.setBounds(244, 283, 115, 48);
		panel.add(btnGoBack);
	}

}
