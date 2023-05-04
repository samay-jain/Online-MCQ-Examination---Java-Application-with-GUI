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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;

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
		frame.getContentPane().setBackground(new Color(153, 204, 255));
		frame.setBounds(100, 100, 962, 583);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblSignupForTeacher = new JLabel("Signup for Teacher");
		lblSignupForTeacher.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignupForTeacher.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		
		JLabel lblEnterTheFollowing = new JLabel("Enter the following details");
		lblEnterTheFollowing.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterTheFollowing.setFont(new Font("Futurist", Font.PLAIN, 28));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(153, 204, 255));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSignupForTeacher, GroupLayout.DEFAULT_SIZE, 928, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(372)
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(341))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(57)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(64))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblSignupForTeacher, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
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
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(5)
					.addComponent(btnGoBack, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
					.addGap(5)
					.addComponent(btnSignIn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(5))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(btnGoBack)
						.addComponent(btnSignIn)))
		);
		panel_2.setLayout(gl_panel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(153, 204, 255));
		panel_1.setLayout(null);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setBounds(39, 268, 267, 40);
		panel_1.add(lblConfirmPassword);
		lblConfirmPassword.setFont(new Font("Gadugi", Font.BOLD, 30));
		
		cp = new JPasswordField();
		cp.setBounds(316, 272, 259, 38);
		panel_1.add(cp);
		cp.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(39, 186, 143, 40);
		panel_1.add(lblPassword);
		lblPassword.setFont(new Font("Gadugi", Font.BOLD, 30));
		
		p = new JTextField();
		p.setBounds(233, 190, 259, 37);
		panel_1.add(p);
		p.setFont(new Font("Tahoma", Font.PLAIN, 26));
		p.setColumns(10);
		
		JLabel lblUsername = new JLabel("Email");
		lblUsername.setBounds(39, 106, 143, 40);
		panel_1.add(lblUsername);
		lblUsername.setFont(new Font("Gadugi", Font.BOLD, 30));
		
		em = new JTextField();
		em.setBounds(233, 110, 259, 37);
		panel_1.add(em);
		em.setFont(new Font("Tahoma", Font.PLAIN, 26));
		em.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(39, 31, 143, 40);
		panel_1.add(lblName);
		lblName.setFont(new Font("Gadugi", Font.BOLD, 30));
		
		n = new JTextField();
		n.setBounds(233, 35, 259, 37);
		panel_1.add(n);
		n.setFont(new Font("Tahoma", Font.PLAIN, 26));
		n.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblEnterTheFollowing, GroupLayout.DEFAULT_SIZE, 807, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addGap(115)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
					.addGap(112))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblEnterTheFollowing)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
					.addGap(29))
		);
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
	}
}
