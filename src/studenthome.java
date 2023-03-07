import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPanel;

public class studenthome {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					studenthome window = new studenthome();
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
	public static String dept,year,div,ques;
	public static ArrayList<JButton>list = new ArrayList<JButton>();
	public ArrayList<String>examidsAll = new ArrayList<String>();
	public ArrayList<String>examidsNotAttempted = new ArrayList<String>();
	public static JButton one,two,three,four,five,six,seven,eight,nine,ten;
	DBCONNECT db = new DBCONNECT();
	public studenthome() {
		db.connect();
		initialize();
		printExams();
		printButtons();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(153, 204, 255));
		frame.setBounds(100, 100, 1006, 675);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		six = new JButton("");
		six.setBackground(new Color(255, 204, 204));
		six.setFont(new Font("Tahoma", Font.BOLD, 18));
		six.setBounds(49, 563, 156, 48);
		frame.getContentPane().add(six);
		
		seven = new JButton("");
		seven.setBackground(new Color(255, 204, 204));
		seven.setFont(new Font("Tahoma", Font.BOLD, 18));
		seven.setBounds(231, 563, 158, 48);
		frame.getContentPane().add(seven);
		
		eight = new JButton("");
		eight.setBackground(new Color(255, 204, 204));
		eight.setFont(new Font("Tahoma", Font.BOLD, 18));
		eight.setBounds(412, 563, 159, 48);
		frame.getContentPane().add(eight);
		
		nine = new JButton("");
		nine.setBackground(new Color(255, 204, 204));
		nine.setFont(new Font("Tahoma", Font.BOLD, 18));
		nine.setBounds(611, 563, 152, 48);
		frame.getContentPane().add(nine);
		
		ten = new JButton("");
		ten.setBackground(new Color(255, 204, 204));
		ten.setFont(new Font("Tahoma", Font.BOLD, 18));
		ten.setBounds(783, 563, 152, 48);
		frame.getContentPane().add(ten);
		
		five = new JButton("");
		five.setBackground(new Color(255, 204, 204));
		five.setFont(new Font("Tahoma", Font.BOLD, 18));
		five.setBounds(783, 483, 152, 48);
		frame.getContentPane().add(five);
		
		four = new JButton("");
		four.setBackground(new Color(255, 204, 204));
		four.setFont(new Font("Tahoma", Font.BOLD, 18));
		four.setBounds(611, 483, 152, 48);
		frame.getContentPane().add(four);
		
		three = new JButton("");
		three.setBackground(new Color(255, 204, 204));
		three.setFont(new Font("Tahoma", Font.BOLD, 18));
		three.setBounds(412, 483, 159, 48);
		frame.getContentPane().add(three);
		
		two = new JButton("");
		two.setBackground(new Color(255, 204, 204));
		two.setFont(new Font("Tahoma", Font.BOLD, 18));
		two.setBounds(231, 483, 158, 48);
		frame.getContentPane().add(two);
		
		one = new JButton("");
		one.setBackground(new Color(255, 204, 204));
		one.setFont(new Font("Tahoma", Font.BOLD, 18));
		one.setBounds(49, 483, 156, 48);
		frame.getContentPane().add(one);
		
		JLabel lblAvailableTests = new JLabel("All Exams for you");
		lblAvailableTests.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvailableTests.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblAvailableTests.setBounds(295, 26, 431, 78);
		frame.getContentPane().add(lblAvailableTests);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 114, 917, 306);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(204, 204, 255));
		scrollPane.setViewportView(table);
		
		JLabel lblName = new JLabel("Name - "+db.getName(loginApp.getEnroll()));
		lblName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblName.setBounds(10, 0, 431, 38);
		frame.getContentPane().add(lblName);
		
		JLabel lblEnrollid = new JLabel("EnrollID - "+loginApp.getEnroll());
		lblEnrollid.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEnrollid.setBounds(10, 37, 281, 38);
		frame.getContentPane().add(lblEnrollid);
		

		JButton btnLogOut = new JButton("log out");
		btnLogOut.setBackground(new Color(255, 204, 204));
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				loginApp.main(null);
			}
		});
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnLogOut.setBounds(807, 12, 175, 38);
		frame.getContentPane().add(btnLogOut);
		
		JLabel lblAvailableExamsAre = new JLabel("Available Exams are given below");
		lblAvailableExamsAre.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvailableExamsAre.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblAvailableExamsAre.setBounds(203, 423, 570, 38);
		frame.getContentPane().add(lblAvailableExamsAre);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		panel.setBounds(22, 467, 949, 161);
		frame.getContentPane().add(panel);
	}
	public void printExams()
	{
		try {
			String query="Select department,year,division from studentdb where enrollmentid=?";
			db.stmt = db.con.prepareStatement(query);
			db.stmt.setString(1, loginApp.getEnroll());
			db.rs = db.stmt.executeQuery();
			while(db.rs.next())
			{
				dept=db.rs.getString(1);
				year=db.rs.getString(2);
				div=db.rs.getString(3);
			}
			
			
			query="Select id as EXAMID,subject as TEST_SUBJECT,teacherdb.name as TEACHER,Questions from mcqdb join teacherdb on mcqdb.teacherid=teacherdb.teacherid where department=? and year=? and division=?";
			db.stmt = db.con.prepareStatement(query);
			db.stmt.setString(1, dept);
			db.stmt.setString(2, year);
			db.stmt.setString(3, div);
			db.rs = db.stmt.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(db.rs));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	//public static String examID,sub,teacherid,questions;
	public ArrayList<String> createList(String eID,String s,String tid,String qns)
	{
		ArrayList<String>arr = new ArrayList<String>();
		arr.add(eID);
		arr.add(s);
		arr.add(tid);
		arr.add(qns);
		return arr;
	}
	HashMap<String,ArrayList<String>>map = new HashMap<String,ArrayList<String>>();
	public static String eID,s,tid,qns;
	public void printButtons()
	{
		try {
			list.clear();
			makeInvisible();
			examidsAll.clear();
			examidsNotAttempted.clear();
			map.clear();
			
			String query="Select department,year,division from studentdb where enrollmentid=?";
			db.stmt = db.con.prepareStatement(query);
			db.stmt.setString(1, loginApp.getEnroll());
			db.rs = db.stmt.executeQuery();
			while(db.rs.next())
			{
				dept=db.rs.getString(1);
				year=db.rs.getString(2);
				div=db.rs.getString(3);
			}
			examidsAll = getexamids();
			examidsNotAttempted = getnotattemptedexamids();
			System.out.println(examidsAll);
			System.out.println(examidsNotAttempted);
			
			query="Select id,subject,teacherid,Questions from mcqdb where department=? and year=? and division=?";
			db.stmt = db.con.prepareStatement(query);
			db.stmt.setString(1, dept);
			db.stmt.setString(2, year);
			db.stmt.setString(3, div);
			db.rs = db.stmt.executeQuery();
			int i=0;
			while(db.rs.next())
			{
				eID = db.rs.getString(1);
				s = db.rs.getString(2);
				tid = db.rs.getString(3);
				qns = db.rs.getString(4);
				if(examidsNotAttempted.contains(eID))
				{
					map.put(s, createList(eID,s,tid,qns));
					final JButton b = list.get(i);
					b.setVisible(true);
					b.setText(s);
					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String sub=b.getText();
							ArrayList<String>arr = map.get(sub);
							frame.setVisible(false);
							appearExam.main(arr.get(0),arr.get(1),arr.get(2),arr.get(3));
						}
					});
					i+=1;
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> getexamids()
	{
		ArrayList<String>arr = new ArrayList<String>();
		try {
			String query="Select id from mcqdb where department=? and year=? and division=?";
			db.stmt = db.con.prepareStatement(query);
			db.stmt.setString(1, dept);
			db.stmt.setString(2, year);
			db.stmt.setString(3, div);
			db.rs = db.stmt.executeQuery();
			while(db.rs.next())
			{
				arr.add(db.rs.getString(1));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return arr;
	}
	public ArrayList<String> getnotattemptedexamids()
	{
		ArrayList<String>arr = new ArrayList<String>();
		try {
			String query="Select id from mcqdb where id not in (select id from attempted where enroll=?) and department=? and year=? and division=?";
			db.stmt = db.con.prepareStatement(query);
			db.stmt.setString(1, loginApp.getEnroll());
			db.stmt.setString(2, dept);
			db.stmt.setString(3, year);
			db.stmt.setString(4, div);
			db.rs = db.stmt.executeQuery();
			while(db.rs.next())
			{
				arr.add(db.rs.getString(1));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return arr;
	}
	public void makeInvisible()
	{
		one.setVisible(false);
		two.setVisible(false);
		three.setVisible(false);
		four.setVisible(false);
		five.setVisible(false);
		six.setVisible(false);
		seven.setVisible(false);
		eight.setVisible(false);
		nine.setVisible(false);
		ten.setVisible(false);
		
		
		list.add(one);
		list.add(two);
		list.add(three);
		list.add(four);
		list.add(five);
		list.add(six);
		list.add(seven);
		list.add(eight);
		list.add(nine);
		list.add(ten);
	}
}
