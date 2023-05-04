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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Component;

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
		frame.getContentPane().setBackground(new Color(153, 204, 255));
		frame.setBounds(100, 100, 968, 574);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblLoginForTeacher = new JLabel("Login for Teacher");
		lblLoginForTeacher.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginForTeacher.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		
		JLabel lblUsername = new JLabel("Email");
		lblUsername.setFont(new Font("Gadugi", Font.BOLD, 28));
		
		email = new JTextField();
		email.setFont(new Font("Tahoma", Font.PLAIN, 20));
		email.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Gadugi", Font.BOLD, 28));
		
		JLabel lblEnterTheFollowing = new JLabel("Enter the following details");
		lblEnterTheFollowing.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterTheFollowing.setFont(new Font("Futurist", Font.PLAIN, 28));
		
		password = new JPasswordField();
		password.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblLoginForTeacher, GroupLayout.DEFAULT_SIZE, 934, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(107)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
					.addGap(106))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblLoginForTeacher, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
					.addGap(89))
		);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(153, 204, 255));
		
		JPanel panel_2 = new JPanel();
		panel_2.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		panel_2.setBackground(new Color(153, 204, 255));
		
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
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnGoBack, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnlogin, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
					.addGap(7))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnGoBack, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnlogin, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addComponent(lblEnterTheFollowing, GroupLayout.DEFAULT_SIZE, 721, Short.MAX_VALUE)
					.addGap(10))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(118)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(30)
							.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(email, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
								.addComponent(password, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE))
							.addGap(29))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(30)
							.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 317, Short.MAX_VALUE))
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE))
					.addGap(133))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(239)
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
					.addGap(245))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addComponent(lblEnterTheFollowing, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(42)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(24)
							.addComponent(email, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addComponent(password, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addGap(17))
		);
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
	}

}
