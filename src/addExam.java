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
	private JTextField textdept;
	private JTextField textyear;
	private JTextField textdivision;
	private JTextField textquestions;
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
		frame.getContentPane().setLayout(null);
		
		JLabel lblAddExamination = new JLabel("Add Examination");
		lblAddExamination.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddExamination.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblAddExamination.setBounds(267, 0, 470, 78);
		frame.getContentPane().add(lblAddExamination);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		panel.setBounds(89, 76, 820, 480);
		frame.getContentPane().add(panel);
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
		
		textdept = new JTextField();
		textdept.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textdept.setColumns(10);
		textdept.setBounds(230, 136, 222, 43);
		panel.add(textdept);
		
		textyear = new JTextField();
		textyear.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textyear.setColumns(10);
		textyear.setBounds(141, 222, 206, 43);
		panel.add(textyear);
		
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
		
		JButton btnReturn = new JButton("return");
		btnReturn.setBackground(new Color(255, 204, 204));
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				teacherhome.main(null);
			}
		});
		btnReturn.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnReturn.setBounds(267, 566, 179, 43);
		frame.getContentPane().add(btnReturn);
		
		JButton btnAddQuestions = new JButton("Add Questions");
		btnAddQuestions.setBackground(new Color(255, 204, 204));
		btnAddQuestions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sub = textsub.getText();
				String year = textyear.getText();
				String dept = textdept.getText();
				String div = textdivision.getText();
				String ques = textquestions.getText();
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
		btnAddQuestions.setBounds(509, 566, 179, 43);
		frame.getContentPane().add(btnAddQuestions);
	}

}
