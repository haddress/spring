package co.micol.prj.comm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataSource { //싱글톤 클래스
	private static DataSource dataSource = new DataSource();
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url ="jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "test";
	private String password = "test";
	private Connection conn;
	
	private DataSource() {
	}
	
	public Connection getConnection() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,password);
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static DataSource getInstance() {
		return dataSource;
	}
}
