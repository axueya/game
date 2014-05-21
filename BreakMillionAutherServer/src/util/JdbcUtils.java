package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * JDBC������
 * @author asus
 *
 */
public final class JdbcUtils {
	Connection conn=null;
	Statement stmt=null;
	ResultSet rs=null;
	private static String driver="com.mysql.jdbc.Driver";
	private static String url="jdbc:mysql://localhost:3306/stu";
	private static String user="root";
	private static String password="";
	
	//���췽���ĳ�˽��
	private JdbcUtils(){
	}
	
	//��̬����飬�����ʱִֻ��һ�Σ���֤����ֻ����һ��
	static{
		try{
			Class.forName(driver);
			}catch(ClassNotFoundException  e){
			throw new ExceptionInInitializerError();
		}
	}
	
	//��ȡ����
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url,user,password);
	}
	
	public static void free(ResultSet rs,Statement stmt,Connection conn){
		try{
			if(rs!=null){
				rs.close();
				rs=null;
				
			}
			if(stmt!=null){
				stmt.close();
				stmt=null;
				
			}
			if(conn!=null){
				conn.close();
				conn=null;
			}
		}catch(SQLException e){
			e.printStackTrace();
	}
	}
}
	