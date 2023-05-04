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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Frame;
import javax.swing.LayoutStyle.ComponentPlacement;

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
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(153, 204, 255));
		frame.setBounds(100, 100, 998, 676);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblDeleteExamination = new JLabel("Delete Examination");
		lblDeleteExamination.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeleteExamination.setFont(new Font("Tahoma", Font.BOLD, 32));
		
		JScrollPane scrollPane = new JScrollPane();
		
		table = new JTable();
		table.setBackground(new Color(204, 204, 255));
		scrollPane.setViewportView(table);
		
		JLabel lblEnterExamId = new JLabel("Enter Exam ID -");
		lblEnterExamId.setFont(new Font("Tahoma", Font.BOLD, 22));
		
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
				clear();
				JOptionPane.showMessageDialog(null, "Please enter ExamID to proceed!");
			}
			}
		});
		textid.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textid.setColumns(10);
		
		JLabel lblDepartment = new JLabel("Department -");
		lblDepartment.setFont(new Font("Tahoma", Font.BOLD, 22));
		
		textdept = new JTextField();
		textdept.setEditable(false);
		textdept.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textdept.setColumns(10);
		
		JLabel lblYear = new JLabel("Year -");
		lblYear.setFont(new Font("Tahoma", Font.BOLD, 22));
		
		textyear = new JTextField();
		textyear.setEditable(false);
		textyear.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textyear.setColumns(10);
		
		JLabel lblDivision = new JLabel("Division -");
		lblDivision.setFont(new Font("Tahoma", Font.BOLD, 22));
		
		textdiv = new JTextField();
		textdiv.setEditable(false);
		textdiv.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textdiv.setColumns(10);
		
		JLabel lblTeacherid = new JLabel("Teacher ID -");
		lblTeacherid.setFont(new Font("Tahoma", Font.BOLD, 22));
		
		texttid = new JTextField();
		texttid.setEditable(false);
		texttid.setFont(new Font("Tahoma", Font.PLAIN, 22));
		texttid.setColumns(10);
		
		JLabel lblExam = new JLabel("Exam -");
		lblExam.setFont(new Font("Tahoma", Font.BOLD, 22));
		
		textsub = new JTextField();
		textsub.setEditable(false);
		textsub.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textsub.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 204, 255));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(106)
							.addComponent(lblEnterExamId, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(textid, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
							.addGap(42)
							.addComponent(lblDepartment, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
							.addComponent(textdept, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
							.addGap(166))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(106)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 778, Short.MAX_VALUE)
							.addGap(41))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(106)
							.addComponent(lblYear, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(textyear, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
							.addGap(28)
							.addComponent(lblDivision, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
							.addComponent(textdiv, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
							.addGap(10)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(148)
									.addComponent(texttid, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblTeacherid, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 49, Short.MAX_VALUE)))
							.addGap(10)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblExam, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 166, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(85)
									.addComponent(textsub, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGap(358)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
							.addGap(317)))
					.addGap(59))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(263)
					.addComponent(lblDeleteExamination, GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
					.addGap(251))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addComponent(lblDeleteExamination)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEnterExamId, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(textid, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDepartment, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(textdept, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblYear, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(textyear, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDivision, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(textdiv, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(texttid, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTeacherid, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblExam, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(textsub, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addGap(23)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
		);
		
		JButton btnReturn = new JButton("return");
		btnReturn.setBackground(new Color(255, 204, 204));
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				teacherhome.main(null);
			}
		});
		btnReturn.setFont(new Font("Tahoma", Font.BOLD, 20));
		
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
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addGap(17)
					.addComponent(btnReturn, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
					.addGap(22)
					.addComponent(btnDelete, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(17))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnReturn)
						.addComponent(btnDelete))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
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
