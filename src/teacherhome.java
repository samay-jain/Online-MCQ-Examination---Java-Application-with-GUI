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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Frame;
import javax.swing.LayoutStyle.ComponentPlacement;

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
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.getContentPane().setBackground(new Color(153, 204, 255));
		frame.setBounds(100, 100, 1014, 664);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblTeacherHomePage = new JLabel("Teacher's Home Page");
		lblTeacherHomePage.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeacherHomePage.setFont(new Font("Tahoma", Font.BOLD, 32));
		
		JLabel Tname = new JLabel("Name - "+teacherlogin.tname);
		Tname.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel Tid = new JLabel("Teacher ID - "+teacherlogin.tid);
		Tid.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		
		JButton btnNewButton = new JButton("Add Exam");
		btnNewButton.setBackground(new Color(255, 204, 204));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				addExam.main(null);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JScrollPane scrollPane = new JScrollPane();
		
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
		
		JButton btnSeeMarks = new JButton("Student Score");
		btnSeeMarks.setBackground(new Color(255, 204, 204));
		btnSeeMarks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				studentScore.main(null);
			}
		});
		btnSeeMarks.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JButton btnLogOut = new JButton("log out");
		btnLogOut.setBackground(new Color(255, 204, 204));
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				teacherlogin.main(null);
			}
		});
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 20));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(273)
							.addComponent(lblTeacherHomePage, GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE))
						.addComponent(Tname, GroupLayout.PREFERRED_SIZE, 431, GroupLayout.PREFERRED_SIZE)
						.addComponent(Tid, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE))
					.addGap(165)
					.addComponent(btnLogOut, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(98)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 813, Short.MAX_VALUE)
					.addGap(89))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(Tname, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(28)
							.addComponent(Tid, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnLogOut)
								.addComponent(lblTeacherHomePage, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))))
					.addGap(10)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
					.addGap(59))
		);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(46)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE)
							.addGap(2))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
							.addGap(28)
							.addComponent(btnDeleteExamination, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
							.addGap(24)
							.addComponent(btnSeeMarks, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)))
					.addGap(43))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(29)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
					.addGap(73)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDeleteExamination, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSeeMarks, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
					.addGap(21))
		);
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
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
