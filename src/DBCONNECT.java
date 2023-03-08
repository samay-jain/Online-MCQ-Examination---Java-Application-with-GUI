import java.sql.*;
import java.util.ArrayList;
public class DBCONNECT 
{
	Connection con;
	PreparedStatement stmt;
	ResultSet rs;
	public void connect()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3307/project";
            String username = "root";
            String password = "";
            con = DriverManager.getConnection(url,username,password);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public boolean checkCredentials(String enroll,String password,int num)
	{
		try {
			String query="";
			if(num==1)
			{
				query = "SELECT password FROM STUDENTDB WHERE enrollmentid=?";
				stmt = con.prepareStatement(query);
				stmt.setString(1, enroll);
			}
			else
			{
				query = "SELECT password FROM TEACHERDB WHERE email=?";
				stmt = con.prepareStatement(query);
				stmt.setString(1, enroll);
			}
			rs = stmt.executeQuery();
			String pass="";
			while(rs.next())
				pass = rs.getString(1);
			if(password.equals(pass))
				return true;
			else
				return false;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	public boolean StudentRegistration(String enroll,String name,String dept,String year,String div,String roll,String email,String password){
		try
		{
			String query = "INSERT INTO STUDENTDB(enrollmentid,name,department,year,division,rollno,email,password) values(?,?,?,?,?,?,?,?)";
			stmt = con.prepareStatement(query);
			stmt.setString(1,enroll);
			stmt.setString(2,name);
			stmt.setString(3,dept);
			stmt.setString(4,year);
			stmt.setString(5,div);
			stmt.setString(6,roll);
			stmt.setString(7,email);
			stmt.setString(8,password);
			stmt.executeUpdate();			
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	public boolean TeacherRegistration(String name,String email,String password){
		try
		{
			String query = "INSERT INTO TEACHERDB(name,email,password) values(?,?,?)";
			stmt = con.prepareStatement(query);
			stmt.setString(1,name);
			stmt.setString(2,email);
			stmt.setString(3,password);
			stmt.executeUpdate();			
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	public String getName(String enroll)
	{
		String name="";
		try {
			String query = "Select name from studentdb where enrollmentid=?";
			stmt = con.prepareStatement(query);
			stmt.setString(1, enroll);
			rs = stmt.executeQuery();
			while(rs.next())
			{
				name = rs.getString(1);
			}
			return name;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "false";
		}
	}
	public String[] getTeacherDetails(String email,String password)
	{
		String arr[] = new String[2];
		try {
			String query = "Select teacherid,name from teacherdb where email=? and password=?";
			stmt = con.prepareStatement(query);
			stmt.setString(1, email);
			stmt.setString(2, password);
			rs = stmt.executeQuery();
			while(rs.next())
			{
				arr[0]=rs.getString(1);
				arr[1]=rs.getString(2);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return arr;
	}
	public boolean deleteMcqdb(String examID)
	{
		try {
			String query="delete from attempted where id=?";
			stmt = con.prepareStatement(query);
			stmt.setString(1, examID);
			stmt.executeUpdate();
			
			query="delete from mcqquestions where id=?";
			stmt = con.prepareStatement(query);
			stmt.setString(1, examID);
			stmt.executeUpdate();
			
			query="delete from mcqdb where id=? and teacherid=?";
			stmt = con.prepareStatement(query);
			stmt.setString(1, examID);
			stmt.setString(2, teacherlogin.tid);
			stmt.executeUpdate();
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	public String createExam(String sub,String dept,String year,String div,String ques)
	{
		try {
			String id="";
			String query = "Insert into mcqdb(teacherID,subject,department,year,division,questions) values(?,?,?,?,?,?)";
			stmt = con.prepareStatement(query);
			stmt.setString(1, teacherlogin.tid);
			stmt.setString(2, sub);
			stmt.setString(3, dept);
			stmt.setString(4, year);
			stmt.setString(5, div);
			stmt.setString(6, ques);
			stmt.executeUpdate();
			
			query="select id from mcqdb where teacherid=? and subject=? and department=? and year=? and division=? and questions=?";
			stmt = con.prepareStatement(query);
			stmt.setString(1, teacherlogin.tid);
			stmt.setString(2, sub);
			stmt.setString(3, dept);
			stmt.setString(4, year);
			stmt.setString(5, div);
			stmt.setInt(6, Integer.parseInt(ques));
			rs = stmt.executeQuery();
			if(rs.next())
				id = rs.getString(1);
			return id;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "fail";
		}
	}
	public boolean enterQuestions(String q,String op1,String op2,String op3,String op4,String ans,int marks)
	{
		try {
			String query="insert into mcqquestions(id,question,op1,op2,op3,op4,ans,marks) values(?,?,?,?,?,?,?,?)";
			stmt = con.prepareStatement(query);
			stmt.setString(1, addExam.exID);
			stmt.setString(2, q);
			stmt.setString(3, op1);
			stmt.setString(4, op2);
			stmt.setString(5, op3);
			stmt.setString(6, op4);
			stmt.setString(7, ans);
			stmt.setString(8, marks+"");
			stmt.executeUpdate();
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	public ArrayList<String> getQuestions()
	{
		ArrayList<String>list = new ArrayList<String>();
		try {
			String query="select question,op1,op2,op3,op4,ans,marks from mcqquestions where id = ?";
			stmt = con.prepareStatement(query);
			stmt.setString(1, appearExam.examID);
			rs = stmt.executeQuery();
			while(rs.next())
			{
				list.add(rs.getString(1));
				list.add(rs.getString(2));
				list.add(rs.getString(3));
				list.add(rs.getString(4));
				list.add(rs.getString(5));
				list.add(rs.getString(6));
				list.add(rs.getString(7));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	public String getRoll(String enroll)
	{
		String roll="";
		try {
			String query = "Select rollno from studentdb where enrollmentid=?";
			stmt = con.prepareStatement(query);
			stmt.setString(1, enroll);
			rs = stmt.executeQuery();
			while(rs.next())
			{
				roll = rs.getString(1);
			}
			return roll;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "-1";
		}
	}
	public boolean submitExam(int marksScored,int totalMarks,String subject)
	{
		try {
			int roll=Integer.parseInt(getRoll(loginApp.getEnroll()));
			String query = "insert into attempted(id,enroll,roll,subject,marks,out_of) values(?,?,?,?,?,?)";
			stmt = con.prepareStatement(query);
			stmt.setInt(1, Integer.parseInt(appearExam.examID));
			stmt.setString(2, loginApp.getEnroll());
			stmt.setInt(3, roll);
			stmt.setString(4, subject);
			stmt.setInt(5, marksScored);
			stmt.setInt(6, totalMarks);
			stmt.executeUpdate();
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
}
