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
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(153, 204, 255));
		frame.setBounds(100, 100, 1051, 692);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblMarksScoredBy = new JLabel("Marks scored by students");
		lblMarksScoredBy.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarksScoredBy.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblMarksScoredBy.setBounds(284, 10, 470, 78);
		frame.getContentPane().add(lblMarksScoredBy);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(47, 144, 944, 436);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(204, 204, 255));
		scrollPane.setViewportView(table);
		
		JLabel lblEnterExamId = new JLabel("Enter Exam ID -");
		lblEnterExamId.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblEnterExamId.setBounds(47, 90, 180, 39);
		frame.getContentPane().add(lblEnterExamId);
		
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
		textID.setBounds(232, 90, 92, 39);
		frame.getContentPane().add(textID);
		textID.setColumns(10);
		
		JLabel lblDepartment = new JLabel("Department -");
		lblDepartment.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblDepartment.setBounds(334, 90, 158, 39);
		frame.getContentPane().add(lblDepartment);
		
		textDept = new JTextField();
		textDept.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textDept.setColumns(10);
		textDept.setBounds(491, 90, 171, 39);
		frame.getContentPane().add(textDept);
		
		JLabel lblYear = new JLabel("Year -");
		lblYear.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblYear.setBounds(672, 90, 68, 39);
		frame.getContentPane().add(lblYear);
		
		textYear = new JTextField();
		textYear.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textYear.setColumns(10);
		textYear.setBounds(745, 90, 51, 39);
		frame.getContentPane().add(textYear);
		
		JLabel lblDivision = new JLabel("Division -");
		lblDivision.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblDivision.setBounds(806, 90, 112, 39);
		frame.getContentPane().add(lblDivision);
		
		textDiv = new JTextField();
		textDiv.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textDiv.setColumns(10);
		textDiv.setBounds(920, 90, 68, 39);
		frame.getContentPane().add(textDiv);
		
		JButton btnReturn = new JButton("return");
		btnReturn.setBackground(new Color(255, 204, 204));
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				teacherhome.main(null);
			}
		});
		btnReturn.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnReturn.setBounds(432, 595, 171, 39);
		frame.getContentPane().add(btnReturn);
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
