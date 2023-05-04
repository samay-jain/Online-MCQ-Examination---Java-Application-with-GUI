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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Frame;
import javax.swing.LayoutStyle.ComponentPlacement;

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
		
		six = new JButton("");
		six.setBounds(49, 563, 156, 48);
		six.setBackground(new Color(255, 204, 204));
		six.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		seven = new JButton("");
		seven.setBounds(231, 563, 158, 48);
		seven.setBackground(new Color(255, 204, 204));
		seven.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		eight = new JButton("");
		eight.setBounds(412, 563, 159, 48);
		eight.setBackground(new Color(255, 204, 204));
		eight.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		nine = new JButton("");
		nine.setBounds(611, 563, 152, 48);
		nine.setBackground(new Color(255, 204, 204));
		nine.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		ten = new JButton("");
		ten.setBounds(783, 563, 152, 48);
		ten.setBackground(new Color(255, 204, 204));
		ten.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		five = new JButton("");
		five.setBounds(783, 483, 152, 48);
		five.setBackground(new Color(255, 204, 204));
		five.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		four = new JButton("");
		four.setBounds(611, 483, 152, 48);
		four.setBackground(new Color(255, 204, 204));
		four.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		three = new JButton("");
		three.setBounds(412, 483, 159, 48);
		three.setBackground(new Color(255, 204, 204));
		three.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		two = new JButton("");
		two.setBounds(231, 483, 158, 48);
		two.setBackground(new Color(255, 204, 204));
		two.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		one = new JButton("");
		one.setBounds(49, 483, 156, 48);
		one.setBackground(new Color(255, 204, 204));
		one.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblAvailableTests = new JLabel("All Exams for you");
		lblAvailableTests.setBounds(295, 26, 431, 78);
		lblAvailableTests.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvailableTests.setFont(new Font("Tahoma", Font.BOLD, 32));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 114, 917, 306);
		
		table = new JTable();
		table.setBackground(new Color(204, 204, 255));
		scrollPane.setViewportView(table);
		
		JLabel lblName = new JLabel("Name - "+db.getName(loginApp.getEnroll()));
		lblName.setBounds(10, 0, 431, 38);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblEnrollid = new JLabel("EnrollID - "+loginApp.getEnroll());
		lblEnrollid.setBounds(10, 37, 281, 38);
		lblEnrollid.setFont(new Font("Tahoma", Font.BOLD, 18));
		

		JButton btnLogOut = new JButton("log out");
		btnLogOut.setBounds(807, 12, 175, 38);
		btnLogOut.setBackground(new Color(255, 204, 204));
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				loginApp.main(null);
			}
		});
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblAvailableExamsAre = new JLabel("Available Exams are given below");
		lblAvailableExamsAre.setBounds(203, 423, 570, 38);
		lblAvailableExamsAre.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvailableExamsAre.setFont(new Font("Tahoma", Font.BOLD, 28));
		
		JPanel panel = new JPanel();
		panel.setBounds(22, 467, 949, 161);
		panel.setBackground(new Color(204, 204, 255));
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(six);
		frame.getContentPane().add(seven);
		frame.getContentPane().add(eight);
		frame.getContentPane().add(nine);
		frame.getContentPane().add(ten);
		frame.getContentPane().add(five);
		frame.getContentPane().add(four);
		frame.getContentPane().add(three);
		frame.getContentPane().add(two);
		frame.getContentPane().add(one);
		frame.getContentPane().add(lblAvailableTests);
		frame.getContentPane().add(scrollPane);
		frame.getContentPane().add(lblName);
		frame.getContentPane().add(lblEnrollid);
		frame.getContentPane().add(btnLogOut);
		frame.getContentPane().add(lblAvailableExamsAre);
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
