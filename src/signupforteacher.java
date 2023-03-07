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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class signupforteacher {

	private JFrame frame;
	private JTextField em;
	private JPasswordField cp;
	private JTextField n;
	private JTextField p;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signupforteacher window = new signupforteacher();
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
	public signupforteacher() {
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
		frame.setBounds(100, 100, 962, 583);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSignupForTeacher = new JLabel("Signup for Teacher");
		lblSignupForTeacher.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblSignupForTeacher.setBounds(319, 0, 302, 78);
		frame.getContentPane().add(lblSignupForTeacher);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(204, 204, 255));
		panel.setBounds(57, 74, 827, 440);
		frame.getContentPane().add(panel);
		
		JLabel lblUsername = new JLabel("Email");
		lblUsername.setFont(new Font("Gadugi", Font.BOLD, 30));
		lblUsername.setBounds(153, 136, 143, 40);
		panel.add(lblUsername);
		
		em = new JTextField();
		em.setFont(new Font("Tahoma", Font.PLAIN, 26));
		em.setColumns(10);
		em.setBounds(347, 139, 259, 37);
		panel.add(em);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Gadugi", Font.BOLD, 30));
		lblPassword.setBounds(153, 217, 143, 40);
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
				String name=n.getText();
				String email = em.getText();
				String password = p.getText();
				String conp = cp.getText();
				if(name.isEmpty() || email.isEmpty() || password.isEmpty() || conp.isEmpty())
					JOptionPane.showMessageDialog(null, "Please enter all the details!");
				else if(!password.equals(conp))
				{
					JOptionPane.showMessageDialog(null, "Password and Confirm Password are different!");
					p.setText("");
					cp.setText("");
				}
				else
				{
					boolean result = db.TeacherRegistration(name, email, password);
					if(result==true)
					{
						JOptionPane.showMessageDialog(null, "Registration Successfull!");
						frame.setVisible(false);
						teacherlogin.main(null);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Registration Unsuccessfull!");
						p.setText("");
						cp.setText("");
					}
				}
			}
		});
		btnSignIn.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnSignIn.setBounds(424, 373, 130, 40);
		panel.add(btnSignIn);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Gadugi", Font.BOLD, 30));
		lblConfirmPassword.setBounds(153, 295, 267, 40);
		panel.add(lblConfirmPassword);
		
		cp = new JPasswordField();
		cp.setFont(new Font("Tahoma", Font.PLAIN, 26));
		cp.setBounds(430, 298, 259, 38);
		panel.add(cp);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Gadugi", Font.BOLD, 30));
		lblName.setBounds(153, 65, 143, 40);
		panel.add(lblName);
		
		n = new JTextField();
		n.setFont(new Font("Tahoma", Font.PLAIN, 26));
		n.setColumns(10);
		n.setBounds(347, 68, 259, 37);
		panel.add(n);
		
		JButton btnGoBack = new JButton("return");
		btnGoBack.setBackground(new Color(255, 204, 204));
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				frame.setVisible(false);
				loginApp.main(null);
			}
		});
		btnGoBack.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnGoBack.setBounds(245, 373, 130, 40);
		panel.add(btnGoBack);
		
		p = new JTextField();
		p.setFont(new Font("Tahoma", Font.PLAIN, 26));
		p.setColumns(10);
		p.setBounds(347, 220, 259, 37);
		panel.add(p);
	}
}
