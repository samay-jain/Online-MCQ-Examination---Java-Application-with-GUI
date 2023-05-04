import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Frame;

public class addQuestions {

	private JFrame frame;
	private JTextField mark;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addQuestions window = new addQuestions();
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
	public JLabel lblQuestionNumber;
	public static int qnum=1;
	DBCONNECT db = new DBCONNECT();
	public addQuestions() {
		db.connect();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.getContentPane().setBackground(new Color(153, 204, 255));
		frame.setBounds(100, 100, 1074, 688);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lblQuestionNumber = new JLabel("Question Number - "+qnum);
		lblQuestionNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuestionNumber.setFont(new Font("Tahoma", Font.BOLD, 32));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		panel.setLayout(null);
		
		JLabel lblQuestion = new JLabel("Question - ");
		lblQuestion.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblQuestion.setBounds(10, 10, 142, 43);
		panel.add(lblQuestion);
		
		JLabel lblOptionA = new JLabel("Option A -");
		lblOptionA.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblOptionA.setBounds(10, 136, 142, 43);
		panel.add(lblOptionA);
		
		JLabel lblOptionB = new JLabel("Option B -");
		lblOptionB.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblOptionB.setBounds(10, 203, 142, 43);
		panel.add(lblOptionB);
		
		JLabel lblOptionC = new JLabel("Option C -");
		lblOptionC.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblOptionC.setBounds(10, 274, 142, 43);
		panel.add(lblOptionC);
		
		JLabel lblOptionD = new JLabel("Option D -");
		lblOptionD.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblOptionD.setBounds(10, 342, 142, 43);
		panel.add(lblOptionD);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(163, 10, 829, 110);
		panel.add(scrollPane);
		
		final JTextArea que = new JTextArea();
		scrollPane.setViewportView(que);
		que.setLineWrap(true);
		que.setRows(4);
		que.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(163, 136, 827, 43);
		panel.add(scrollPane_1);
		
		final JTextArea op1 = new JTextArea();
		scrollPane_1.setViewportView(op1);
		op1.setRows(1);
		op1.setLineWrap(true);
		op1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(163, 203, 827, 43);
		panel.add(scrollPane_2);
		
		final JTextArea op2 = new JTextArea();
		scrollPane_2.setViewportView(op2);
		op2.setRows(1);
		op2.setLineWrap(true);
		op2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(164, 274, 825, 41);
		panel.add(scrollPane_3);
		
		final JTextArea op3 = new JTextArea();
		scrollPane_3.setViewportView(op3);
		op3.setRows(1);
		op3.setLineWrap(true);
		op3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(162, 342, 825, 41);
		panel.add(scrollPane_4);
		
		final JTextArea op4 = new JTextArea();
		scrollPane_4.setViewportView(op4);
		op4.setRows(1);
		op4.setLineWrap(true);
		op4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblMarks = new JLabel("Marks -");
		lblMarks.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblMarks.setBounds(790, 413, 103, 43);
		panel.add(lblMarks);
		
		mark = new JTextField();
		mark.setFont(new Font("Tahoma", Font.PLAIN, 22));
		mark.setColumns(10);
		mark.setBounds(893, 416, 92, 39);
		panel.add(mark);
		
		JLabel lblAnswer = new JLabel("Answer -");
		lblAnswer.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblAnswer.setBounds(10, 412, 142, 43);
		panel.add(lblAnswer);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(163, 413, 609, 39);
		panel.add(scrollPane_5);
		
		final JTextArea textans = new JTextArea();
		scrollPane_5.setViewportView(textans);
		textans.setRows(1);
		textans.setLineWrap(true);
		textans.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnAddQuestion = new JButton("Add Question");
		btnAddQuestion.setBackground(new Color(255, 204, 204));
		btnAddQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String question = que.getText();
				String optionA = op1.getText();
				String optionB = op2.getText();
				String optionC = op3.getText();
				String optionD = op4.getText();
				String ans = textans.getText();
				String marks = mark.getText();
				int m=-1;
				try {
					m = Integer.parseInt(marks);
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, "Please enter valid marks!");
					return;
				}
				if(question.isEmpty() || optionA.isEmpty() || optionB.isEmpty() || optionC.isEmpty() || optionD.isEmpty() || ans.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Please fill all required data.");
				}
				else
				{
					boolean result = db.enterQuestions(question,optionA,optionB,optionC,optionD,ans,m);
					if(result)
					{
						qnum+=1;
						que.setText("");
						op1.setText("");
						op2.setText("");
						op3.setText("");
						op4.setText("");
						textans.setText("");
						mark.setText("");
						if(qnum>addExam.nq)
						{
							JOptionPane.showMessageDialog(null, "Examination is successfully created and ready for students!");
							qnum=1;
							frame.setVisible(false);
							teacherhome.main(null);
						}
						else
						{
							lblQuestionNumber.setText("Question Number - "+qnum);
							JOptionPane.showMessageDialog(null, "Question is Added Successfully!");
						}
					}
					else
						JOptionPane.showMessageDialog(null, "Question can't be added due to technical issue!");
				}
			}
		});
		btnAddQuestion.setFont(new Font("Tahoma", Font.BOLD, 20));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(283)
					.addComponent(lblQuestionNumber, GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
					.addGap(307))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1019, Short.MAX_VALUE)
					.addGap(21))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(425)
					.addComponent(btnAddQuestion, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(450, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(lblQuestionNumber, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addGap(13)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 497, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(btnAddQuestion)
					.addContainerGap(10, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
