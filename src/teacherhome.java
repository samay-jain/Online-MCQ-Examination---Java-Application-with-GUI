import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class teacherhome {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					teacherhome window = new teacherhome();
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
	public teacherhome() {
		db.connect();
		initialize();
		printExams();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(153, 204, 255));
		frame.setBounds(100, 100, 1014, 664);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTeacherHomePage = new JLabel("Teacher's Home Page");
		lblTeacherHomePage.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeacherHomePage.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblTeacherHomePage.setBounds(283, 10, 431, 78);
		frame.getContentPane().add(lblTeacherHomePage);
		
		JLabel Tname = new JLabel("Name - "+teacherlogin.tname);
		Tname.setFont(new Font("Tahoma", Font.BOLD, 18));
		Tname.setBounds(10, 0, 431, 38);
		frame.getContentPane().add(Tname);
		
		JLabel Tid = new JLabel("Teacher ID - "+teacherlogin.tid);
		Tid.setFont(new Font("Tahoma", Font.BOLD, 18));
		Tid.setBounds(10, 28, 281, 38);
		frame.getContentPane().add(Tid);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		panel.setBounds(98, 98, 813, 473);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Add Exam");
		btnNewButton.setBackground(new Color(255, 204, 204));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				addExam.main(null);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(46, 399, 224, 53);
		panel.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 29, 722, 297);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 204));
		scrollPane.setViewportView(table);
		
		JButton btnDeleteExamination = new JButton("Delete Exam");
		btnDeleteExamination.setBackground(new Color(255, 204, 204));
		btnDeleteExamination.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				deleteExam.main(null);
			}
		});
		btnDeleteExamination.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDeleteExamination.setBounds(298, 399, 224, 53);
		panel.add(btnDeleteExamination);
		
		JButton btnSeeMarks = new JButton("Student Score");
		btnSeeMarks.setBackground(new Color(255, 204, 204));
		btnSeeMarks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				studentScore.main(null);
			}
		});
		btnSeeMarks.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSeeMarks.setBounds(546, 399, 224, 53);
		panel.add(btnSeeMarks);
		
		JButton btnLogOut = new JButton("log out");
		btnLogOut.setBackground(new Color(255, 204, 204));
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				teacherlogin.main(null);
			}
		});
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnLogOut.setBounds(397, 579, 224, 38);
		frame.getContentPane().add(btnLogOut);
	}
	public void printExams()
	{
		try {
			String query="Select id as Exam_ID,SUBJECT,DEPARTMENT,YEAR,DIVISION from mcqdb where teacherid=?";
			db.stmt = db.con.prepareStatement(query);
			db.stmt.setString(1, teacherlogin.tid);
			db.rs = db.stmt.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(db.rs));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
