import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Frame;

public class studentScore {

	private JFrame frame;
	private JTable table;
	private JTextField textID;
	private JTextField textDept;
	private JTextField textYear;
	private JTextField textDiv;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					studentScore window = new studentScore();
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
	public String arr[] = new String[3];
	public studentScore() {
		db.connect();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(153, 204, 255));
		frame.setBounds(100, 100, 1051, 692);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblMarksScoredBy = new JLabel("Marks scored by students");
		lblMarksScoredBy.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarksScoredBy.setFont(new Font("Tahoma", Font.BOLD, 32));
		
		JScrollPane scrollPane = new JScrollPane();
		
		table = new JTable();
		table.setBackground(new Color(204, 204, 255));
		scrollPane.setViewportView(table);
		
		JLabel lblEnterExamId = new JLabel("Enter Exam ID -");
		lblEnterExamId.setFont(new Font("Tahoma", Font.BOLD, 22));
		
		textID = new JTextField();
		textID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				String id = textID.getText();
				try {
					String query="select department,year,division from mcqdb where id=? and teacherid=?";
					db.stmt = db.con.prepareStatement(query);
					db.stmt.setString(1, id);
					db.stmt.setString(2, teacherlogin.tid);
					db.rs = db.stmt.executeQuery();
					if(db.rs.next())
					{
						arr[0]=db.rs.getString(1);
						arr[1]=db.rs.getString(2);
						arr[2]=db.rs.getString(3);
						textDept.setText(arr[0]);
						textYear.setText(arr[1]);
						textDiv.setText(arr[2]);
						printMarks(id);
					}
					else
					{
						textID.setText("");
						textDept.setText("");
						textYear.setText("");
						textDiv.setText("");
					}
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}	
			}
		});
		textID.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textID.setColumns(10);
		
		JLabel lblDepartment = new JLabel("Department -");
		lblDepartment.setFont(new Font("Tahoma", Font.BOLD, 22));
		
		textDept = new JTextField();
		textDept.setEditable(false);
		textDept.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textDept.setColumns(10);
		
		JLabel lblYear = new JLabel("Year -");
		lblYear.setFont(new Font("Tahoma", Font.BOLD, 22));
		
		textYear = new JTextField();
		textYear.setEditable(false);
		textYear.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textYear.setColumns(10);
		
		JLabel lblDivision = new JLabel("Division -");
		lblDivision.setFont(new Font("Tahoma", Font.BOLD, 22));
		
		textDiv = new JTextField();
		textDiv.setEditable(false);
		textDiv.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textDiv.setColumns(10);
		
		JButton btnReturn = new JButton("return");
		btnReturn.setBackground(new Color(255, 204, 204));
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				teacherhome.main(null);
			}
		});
		btnReturn.setFont(new Font("Tahoma", Font.BOLD, 20));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(47)
					.addComponent(lblEnterExamId, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
					.addGap(5)
					.addComponent(textID, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(157)
							.addComponent(textDept, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblDepartment, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
							.addGap(170)))
					.addGap(10)
					.addComponent(lblYear, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
					.addGap(5)
					.addComponent(textYear, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(lblDivision, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
					.addGap(2)
					.addComponent(textDiv, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
					.addGap(49))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(284)
					.addComponent(lblMarksScoredBy, GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
					.addGap(283))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(47)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnReturn, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 944, Short.MAX_VALUE)
							.addGap(46))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMarksScoredBy, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEnterExamId, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(textID, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(textDept, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDepartment, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblYear, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(textYear, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDivision, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(textDiv, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnReturn, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addGap(18))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
	public void printMarks(String id)
	{
		try {
			String query = "select enroll as EnrollmentID,roll as RollNo,Subject as Name_Of_Exam,Marks,out_of from attempted where id=? order by roll";
			db.stmt = db.con.prepareStatement(query);
			db.stmt.setString(1, id);
			db.rs = db.stmt.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(db.rs));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
