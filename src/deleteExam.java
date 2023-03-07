import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class deleteExam {

	private JFrame frame;
	private JTable table;
	private JTextField textid;
	private JTextField textdept;
	private JTextField textyear;
	private JTextField textdiv;
	private JTextField texttid;
	private JTextField textsub;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deleteExam window = new deleteExam();
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
	public deleteExam() {
		db.connect();
		initialize();
		printmcqdb();
	}
	public void printmcqdb()
	{
		try {
			String query="select id as ExamID,subject as Examination,Department,Year,Division,Questions from mcqdb where teacherid=?";
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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(153, 204, 255));
		frame.setBounds(100, 100, 998, 676);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDeleteExamination = new JLabel("Delete Examination");
		lblDeleteExamination.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeleteExamination.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblDeleteExamination.setBounds(263, 0, 470, 78);
		frame.getContentPane().add(lblDeleteExamination);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(106, 76, 778, 351);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(204, 204, 255));
		scrollPane.setViewportView(table);
		
		JLabel lblEnterExamId = new JLabel("Enter Exam ID -");
		lblEnterExamId.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblEnterExamId.setBounds(106, 448, 180, 39);
		frame.getContentPane().add(lblEnterExamId);
		
		textid = new JTextField();
		textid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String exid = textid.getText();
				if(!exid.isEmpty())
				{
				try {
					String query="select teacherid,subject,department,year,division from mcqdb where id=? and teacherid=?";
					db.stmt = db.con.prepareStatement(query);
					db.stmt.setString(1, exid);
					db.stmt.setString(2, teacherlogin.tid);
					db.rs = db.stmt.executeQuery();
					if(db.rs.next())
					{
						texttid.setText(db.rs.getString(1));
						textsub.setText(db.rs.getString(2));
						textdept.setText(db.rs.getString(3));
						textyear.setText(db.rs.getString(4));
						textdiv.setText(db.rs.getString(5));
					}
					else
					{
						clear();
					}
				}
				catch(Exception e2)
				{
					e2.printStackTrace();
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Please enter ExamID to proceed!");
			}
			}
		});
		textid.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textid.setColumns(10);
		textid.setBounds(296, 448, 92, 39);
		frame.getContentPane().add(textid);
		
		JLabel lblDepartment = new JLabel("Department -");
		lblDepartment.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblDepartment.setBounds(430, 448, 158, 39);
		frame.getContentPane().add(lblDepartment);
		
		textdept = new JTextField();
		textdept.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textdept.setColumns(10);
		textdept.setBounds(588, 448, 171, 39);
		frame.getContentPane().add(textdept);
		
		JLabel lblYear = new JLabel("Year -");
		lblYear.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblYear.setBounds(106, 508, 68, 39);
		frame.getContentPane().add(lblYear);
		
		textyear = new JTextField();
		textyear.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textyear.setColumns(10);
		textyear.setBounds(184, 508, 51, 39);
		frame.getContentPane().add(textyear);
		
		JLabel lblDivision = new JLabel("Division -");
		lblDivision.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblDivision.setBounds(263, 508, 112, 39);
		frame.getContentPane().add(lblDivision);
		
		textdiv = new JTextField();
		textdiv.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textdiv.setColumns(10);
		textdiv.setBounds(375, 508, 68, 39);
		frame.getContentPane().add(textdiv);
		
		JLabel lblTeacherid = new JLabel("Teacher ID -");
		lblTeacherid.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblTeacherid.setBounds(453, 508, 157, 39);
		frame.getContentPane().add(lblTeacherid);
		
		texttid = new JTextField();
		texttid.setFont(new Font("Tahoma", Font.PLAIN, 22));
		texttid.setColumns(10);
		texttid.setBounds(601, 508, 58, 39);
		frame.getContentPane().add(texttid);
		
		JLabel lblExam = new JLabel("Exam -");
		lblExam.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblExam.setBounds(669, 508, 90, 39);
		frame.getContentPane().add(lblExam);
		
		textsub = new JTextField();
		textsub.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textsub.setColumns(10);
		textsub.setBounds(754, 508, 171, 39);
		frame.getContentPane().add(textsub);
		
		JButton btnReturn = new JButton("return");
		btnReturn.setBackground(new Color(255, 204, 204));
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				teacherhome.main(null);
			}
		});
		btnReturn.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnReturn.setBounds(296, 590, 171, 39);
		frame.getContentPane().add(btnReturn);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(new Color(255, 204, 204));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String exid = textid.getText();
				boolean result=db.deleteMcqdb(exid);
				if(result)
				{
					JOptionPane.showMessageDialog(null, "Examination is deleted successfully!");
					printmcqdb();
					clear();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Examination can't be deleted due to technical issue!");
					clear();
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDelete.setBounds(506, 590, 171, 39);
		frame.getContentPane().add(btnDelete);
	}
	public void clear()
	{
		textid.setText("");
		textdept.setText("");
		texttid.setText("");
		textsub.setText("");
		textyear.setText("");
		textdiv.setText("");
	}
}
