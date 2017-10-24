package DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import studentData.Student;

public class MysqlData {
	public int insert(Student student)throws Exception{
		int i = 0;
		String sql = "insert into student(sid,name,age,grade) values(?,?,?,?)";
		Connection connection = DBUtil.getConnection();
		PreparedStatement pre = connection.prepareStatement(sql);
		pre.setInt(1, student.getsid());
		pre.setString(2, student.getname());
		pre.setInt(3, student.getage());
		pre.setString(4, student.getgrade());
		i = pre.executeUpdate();
		pre.close();
		connection.close();
		return i;
	}
	
	public int update(Student student)throws Exception{
		int i = 0;
		String sql = "update student set Age='" + student.getage() + "' where Name='" + student.getname() + "'";
		Connection connection = DBUtil.getConnection();
		PreparedStatement pre = connection.prepareStatement(sql);
		i = pre.executeUpdate();
		System.out.println("result: " +i);
		pre.close();
		connection.close();
		return i;
	}
	
	public int delete(String name) throws Exception{
		int i = 0;
		String sql = "delete from student where Name = '"+name+"'";
		Connection connection = DBUtil.getConnection();
		PreparedStatement pre = connection.prepareStatement(sql);
		i = pre.executeUpdate();
		pre.close();
		connection.close();
		return i;
	}
	
	public List<Student> selectAll() throws Exception{
		List<Student> list = new ArrayList<Student>();
		String sql = "select * from student";
		Connection connection = DBUtil.getConnection();
		PreparedStatement pre = connection.prepareStatement(sql);
		ResultSet res = pre.executeQuery();
		while(res.next()) {
			Student student = new Student();
			student.setsid(res.getInt("sid"));
			student.setname(res.getString("name"));
			student.setage(res.getInt("age"));
			student.setgrade(res.getString("grade"));
			list.add(student);
		}
		return list;
	}
	
	
	
	
}
