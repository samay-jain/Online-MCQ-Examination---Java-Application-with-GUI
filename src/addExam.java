import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class addExam {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addExam window = new addExam();
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
	public static String exID;
	public static int nq;
	DBCONNECT db = new DBCONNECT();
	private JTextField textsub;
	private JTextField textdivision;
	private JTextField textquestions;
	public static JComboBox textdept,textyear;
	public addExam() {
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
		frame.setBounds(100, 100, 1009, 656);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblAddExamination = new JLabel("Add Examination");
		lblAddExamination.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddExamination.setFont(new Font("Tahoma", Font.BOLD, 32));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		panel.setLayout(null);
		
		JLabel lblExamTitleSubject = new JLabel("Exam Title/Subject -");
		lblExamTitleSubject.setBounds(56, 51, 256, 43);
		lblExamTitleSubject.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel.add(lblExamTitleSubject);
		
		textsub = new JTextField();
		textsub.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textsub.setColumns(10);
		textsub.setBounds(333, 51, 342, 43);
		panel.add(textsub);
		
		JLabel lblDepartment = new JLabel("Department -");
		lblDepartment.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblDepartment.setBounds(56, 136, 168, 43);
		panel.add(lblDepartment);
		
		JLabel lblYear = new JLabel("Year -");
		lblYear.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblYear.setBounds(56, 222, 83, 43);
		panel.add(lblYear);
		
		JLabel lblDivision = new JLabel("Division -");
		lblDivision.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblDivision.setBounds(56, 304, 125, 43);
		panel.add(lblDivision);
		
		JLabel lblQuestions = new JLabel("Number of Questions -");
		lblQuestions.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblQuestions.setBounds(56, 382, 286, 43);
		panel.add(lblQuestions);
		
		textdivision = new JTextField();
		textdivision.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textdivision.setColumns(10);
		textdivision.setBounds(184, 304, 229, 43);
		panel.add(textdivision);
		
		textquestions = new JTextField();
		textquestions.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textquestions.setColumns(10);
		textquestions.setBounds(333, 382, 113, 43);
		panel.add(textquestions);
		
		textdept = new JComboBox();
		textdept.setModel(new DefaultComboBoxModel(new String[] {"", "CSE", "IT", "MECHANICAL", "E&TC", "ELECTRONICS", "ECS"}));
		textdept.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textdept.setBounds(234, 136, 222, 43);
		panel.add(textdept);
		
		textyear = new JComboBox();
		textyear.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4"}));
		textyear.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textyear.setBounds(149, 222, 206, 43);
		panel.add(textyear);
		
		JButton btnReturn = new JButton("return");
		btnReturn.setBackground(new Color(255, 204, 204));
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				teacherhome.main(null);
			}
		});
		btnReturn.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JButton btnAddQuestions = new JButton("Add Questions");
		btnAddQuestions.setBackground(new Color(255, 204, 204));
		btnAddQuestions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ind=-1;
				String sub,year,dept,div,ques;
				sub = textsub.getText();
				ind = textyear.getSelectedIndex();
				if(ind == 1)
					year = "1";
				else if(ind == 2)
					year = "2";
				else if(ind == 3)
					year = "3";
				else if(ind == 4)
					year = "4";
				else
					year="";
				ind=-1;
				ind = textdept.getSelectedIndex();
				if(ind == 1)
					dept = "CSE";
				else if(ind == 2)
					dept = "IT";
				else if(ind == 3)
					dept = "MECHANICAL";
				else if(ind == 4)
					dept = "E&TC";
				else if(ind == 5)
					dept = "ELECTRONICS";
				else if(ind == 6)
					dept = "ECS";
				else
					dept="";
				div = textdivision.getText();
				ques = textquestions.getText();
				if(sub.isEmpty() || year.isEmpty() || dept.isEmpty() || div.isEmpty() || ques.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Please enter all required details!");
				}
				else
				{
					
					exID = db.createExam(sub,dept,year,div,ques);
					if(!exID.equals("fail"))
					{
						nq=Integer.parseInt(ques);
						frame.setVisible(false);
						addQuestions.main(null);
					}
					else
						JOptionPane.showMessageDialog(null, "Unable to create the Examination!");
				}
			}
		});
		btnAddQuestions.setFont(new Font("Tahoma", Font.BOLD, 20));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(89)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(178)
							.addComponent(lblAddExamination, GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
							.addGap(172)))
					.addGap(86))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(267)
					.addComponent(btnReturn, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
					.addGap(63)
					.addComponent(btnAddQuestions, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(76)
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE))
						.addComponent(lblAddExamination, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnReturn, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAddQuestions, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
					.addGap(10))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

}
