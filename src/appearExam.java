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
		frame.getContentPane().setBackground(new Color(153, 204, 255));
		frame.setBounds(100, 100, 1054, 684);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSubjectexam = new JLabel("Subject/Exam - "+sub);
		lblSubjectexam.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubjectexam.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblSubjectexam.setBounds(234, 0, 612, 78);
		frame.getContentPane().add(lblSubjectexam);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		panel.setLayout(null);
		panel.setBounds(10, 88, 1019, 466);
		frame.getContentPane().add(panel);
		
		JLabel lblQuestion = new JLabel("Question - ");
		lblQuestion.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblQuestion.setBounds(10, 10, 142, 43);
		panel.add(lblQuestion);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(162, 10, 828, 116);
		panel.add(scrollPane);
		
		final JTextArea textQ = new JTextArea();
		scrollPane.setViewportView(textQ);
		textQ.setRows(4);
		textQ.setLineWrap(true);
		textQ.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textQ.setEditable(false);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(186, 136, 802, 43);
		panel.add(scrollPane_1);
		
		final JTextArea textOp1 = new JTextArea();
		scrollPane_1.setViewportView(textOp1);
		textOp1.setRows(1);
		textOp1.setLineWrap(true);
		textOp1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textOp1.setEditable(false);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(186, 203, 800, 41);
		panel.add(scrollPane_2);
		
		final JTextArea textOp2 = new JTextArea();
		scrollPane_2.setViewportView(textOp2);
		textOp2.setRows(1);
		textOp2.setLineWrap(true);
		textOp2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textOp2.setEditable(false);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(186, 274, 798, 39);
		panel.add(scrollPane_3);
		
		final JTextArea textOp3 = new JTextArea();
		scrollPane_3.setViewportView(textOp3);
		textOp3.setRows(1);
		textOp3.setLineWrap(true);
		textOp3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textOp3.setEditable(false);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(188, 342, 796, 39);
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
		opA.setBounds(10, 132, 172, 43);
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
		opB.setBounds(10, 201, 170, 43);
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
		opC.setBounds(10, 270, 168, 43);
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
		opD.setBounds(10, 338, 168, 43);
		panel.add(opD);
		
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
		btnSaveAndNext.setBounds(413, 408, 195, 33);
		panel.add(btnSaveAndNext);
		
		JLabel lblMarks = new JLabel("Marks -");
		lblMarks.setBounds(878, 44, 103, 43);
		frame.getContentPane().add(lblMarks);
		lblMarks.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		textM = new JTextField();
		textM.setBounds(976, 47, 54, 39);
		frame.getContentPane().add(textM);
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
		btnClear.setBounds(457, 584, 120, 33);
		frame.getContentPane().add(btnClear);
		
		JLabel lblExamId = new JLabel("Exam ID - "+examID);
		lblExamId.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblExamId.setBounds(10, 0, 164, 33);
		frame.getContentPane().add(lblExamId);
		
		JLabel lblTotalQuestions = new JLabel("Total Questions - "+questions);
		lblTotalQuestions.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTotalQuestions.setBounds(10, 28, 232, 33);
		frame.getContentPane().add(lblTotalQuestions);
		
		textM.setText(marks);
		textQ.setText(q);
		textOp1.setText(op1);
		textOp2.setText(op2);
		textOp3.setText(op3);
		textOp4.setText(op4);
	}
}
