package DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	static String driver = "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/test";
	static String user = "root";
	static String password = "123456";
	
//测试使用的代码
//	public static void main(String[] args) throws Exception {
//		Connection connection = getConnection();
//		if(!connection.isClosed()) {
//			System.out.println("succeeded get connection to mysql!");
//		}
//	}
	
	public static Connection getConnection() throws Exception {
		Class.forName(driver);
		Connection connection = DriverManager.getConnection(url, user, password);
		return connection;
	}

}
