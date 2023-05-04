import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.plaf.metal.MetalCheckBoxIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Frame;
import javax.swing.LayoutStyle.ComponentPlacement;

public class appearExam {

	private JFrame frame;
	private JTextField textM;

	/**
	 * Launch the application.
	 */
	public static String examID,sub,teacherid,questions;
	public static void main(String exam,String s,String tid,String qns) {
		examID = exam;
		sub = s;
		teacherid = tid;
		questions=qns;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					appearExam window = new appearExam();
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
	public static String q,op1,op2,op3,op4,ans,marks;
	public static int qno=0,marksScored=0,totalMarks=0;
	public static ArrayList<String>list;
	public appearExam() {
		db.connect();
		list = db.getQuestions();
		q = list.get(0);
		op1 = list.get(1);
		op2 = list.get(2);
		op3 = list.get(3);
		op4 = list.get(4);
		ans = list.get(5);
		marks = list.get(6);
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public static JCheckBox opA,opB,opC,opD;
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.getContentPane().setBackground(new Color(153, 204, 255));
		frame.setBounds(100, 100, 1054, 684);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblSubjectexam = new JLabel("Subject/Exam - "+sub);
		lblSubjectexam.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubjectexam.setFont(new Font("Tahoma", Font.BOLD, 32));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		panel.setLayout(null);
		
		JLabel lblQuestion = new JLabel("Question - ");
		lblQuestion.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblQuestion.setBounds(10, 29, 148, 43);
		panel.add(lblQuestion);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(160, 29, 828, 116);
		panel.add(scrollPane);
		
		final JTextArea textQ = new JTextArea();
		scrollPane.setViewportView(textQ);
		textQ.setRows(4);
		textQ.setLineWrap(true);
		textQ.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textQ.setEditable(false);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(186, 155, 802, 43);
		panel.add(scrollPane_1);
		
		final JTextArea textOp1 = new JTextArea();
		scrollPane_1.setViewportView(textOp1);
		textOp1.setRows(1);
		textOp1.setLineWrap(true);
		textOp1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textOp1.setEditable(false);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(186, 233, 800, 41);
		panel.add(scrollPane_2);
		
		final JTextArea textOp2 = new JTextArea();
		scrollPane_2.setViewportView(textOp2);
		textOp2.setRows(1);
		textOp2.setLineWrap(true);
		textOp2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textOp2.setEditable(false);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(186, 316, 798, 39);
		panel.add(scrollPane_3);
		
		final JTextArea textOp3 = new JTextArea();
		scrollPane_3.setViewportView(textOp3);
		textOp3.setRows(1);
		textOp3.setLineWrap(true);
		textOp3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textOp3.setEditable(false);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(186, 394, 796, 39);
		panel.add(scrollPane_4);
		
		final JTextArea textOp4 = new JTextArea();
		scrollPane_4.setViewportView(textOp4);
		textOp4.setRows(1);
		textOp4.setLineWrap(true);
		textOp4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textOp4.setEditable(false);
		
		opA = new JCheckBox("Option A -");
		opA.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				opB.setSelected(false);
				opC.setSelected(false);
				opD.setSelected(false);
			}
		});
		opA.setIcon(new MetalCheckBoxIcon()
		{
			protected int getControlSize() {
				return 30;
			}
		});
		opA.setFont(new Font("Tahoma", Font.BOLD, 23));
		opA.setBounds(10, 155, 170, 43);
		panel.add(opA);
		
		opB = new JCheckBox("Option B -");
		opB.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				opA.setSelected(false);
				opC.setSelected(false);
				opD.setSelected(false);
			}
		});
		opB.setIcon(new MetalCheckBoxIcon()
		{
			protected int getControlSize() {
				return 30;
			}
		});
		opB.setFont(new Font("Tahoma", Font.BOLD, 23));
		opB.setBounds(10, 233, 170, 43);
		panel.add(opB);
		
		opC = new JCheckBox("Option C -");
		opC.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				opA.setSelected(false);
				opB.setSelected(false);
				opD.setSelected(false);
			}
		});
		opC.setIcon(new MetalCheckBoxIcon()
		{
			protected int getControlSize() {
				return 30;
			}
		});
		opC.setFont(new Font("Tahoma", Font.BOLD, 23));
		opC.setBounds(10, 316, 168, 43);
		panel.add(opC);
		
		opD = new JCheckBox("Option D -");
		opD.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				opA.setSelected(false);
				opB.setSelected(false);
				opC.setSelected(false);
			}
		});
		opD.setIcon(new MetalCheckBoxIcon()
		{
			protected int getControlSize() {
				return 30;
			}
		});
		opD.setFont(new Font("Tahoma", Font.BOLD, 23));
		opD.setBounds(10, 394, 168, 43);
		panel.add(opD);
		
		JLabel lblMarks = new JLabel("Marks -");
		lblMarks.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		textM = new JTextField();
		textM.setEditable(false);
		textM.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textM.setColumns(10);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBackground(new Color(255, 204, 204));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opA.setSelected(false);
				opB.setSelected(false);
				opC.setSelected(false);
				opD.setSelected(false);
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblExamId = new JLabel("Exam ID - "+examID);
		lblExamId.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblTotalQuestions = new JLabel("Total Questions - "+questions);
		lblTotalQuestions.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		textM.setText(marks);
		textQ.setText(q);
		textOp1.setText(op1);
		textOp2.setText(op2);
		textOp3.setText(op3);
		textOp4.setText(op4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 204, 255));
		
		JButton btnSaveAndNext = new JButton("Save and Next");
		btnSaveAndNext.setBackground(new Color(255, 204, 204));
		btnSaveAndNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String stans="";
				totalMarks+=Integer.parseInt(marks);
				if(opA.isSelected())
				{
					stans=textOp1.getText();
				}
				else if(opB.isSelected())
				{
					stans=textOp2.getText();
				}
				else if(opC.isSelected())
				{
					stans=textOp3.getText();
				}
				else if(opD.isSelected())
				{
					stans=textOp4.getText();
				}
				else {
					JOptionPane.showMessageDialog(null, "Please select an Option!");
					return;
				}
				
				opA.setSelected(false);
				opB.setSelected(false);
				opC.setSelected(false);
				opD.setSelected(false);
				
				if(ans.equals(stans))
					marksScored+=Integer.parseInt(marks);
				
				if(qno+7<list.size())
				{
					qno+=7;
					textQ.setText(list.get(qno));
					textOp1.setText(list.get(qno+1));
					textOp2.setText(list.get(qno+2));
					textOp3.setText(list.get(qno+3));
					textOp4.setText(list.get(qno+4));
					ans = list.get(qno+5);
					textM.setText(list.get(qno+6));
					marks = list.get(qno+6);
				}
				else
				{
					boolean result = db.submitExam(marksScored,totalMarks,sub);
					if(result)
					{
						JOptionPane.showMessageDialog(null, "Exam is submitted successfully!\nYou have scored "+marksScored+" Marks Out of "+totalMarks+" Marks");
						qno=0;
						marksScored=0;
						totalMarks=0;
						frame.setVisible(false);
						studenthome.main(null);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Exam can't be submitted due to technical issue!");
					}
				}
			}
		});
		btnSaveAndNext.setFont(new Font("Tahoma", Font.BOLD, 20));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnSaveAndNext, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
					.addGap(12))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnSaveAndNext)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(224)
							.addComponent(lblSubjectexam, GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE))
						.addComponent(lblTotalQuestions, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblExamId, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE))
					.addGap(23)
					.addComponent(lblMarks, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textM, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(409)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(414, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(449)
					.addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(457, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(11)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1019, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSubjectexam, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(28)
									.addComponent(lblTotalQuestions, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblExamId, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
							.addGap(2))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMarks, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
								.addComponent(textM, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
							.addGap(18)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 455, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnClear)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
