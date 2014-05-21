package util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class JdbcHelper {

	public static Connection conn = null;
	public static PreparedStatement ps = null;
	public static ResultSet rs = null;
	static String driver = "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/game";
	static String user = "root";
	static String password = "";

	public static void openDB() {
		try {

			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC driver not loaded:\n" + e);
		} catch (SQLException e) {
			System.out.println("Connection failed:\n" + e);
		}

	}

	static ArrayList<ArrayList<Object>> read(String sql) throws SQLException {

		ArrayList<ArrayList<Object>> arr = new ArrayList<>();
		ArrayList<Object> obj = new ArrayList<Object>();
		try {
			conn = JdbcUtils.getConnection();
			ps = conn.prepareStatement(sql);
			// 4.执行语句
			rs = ps.executeQuery();
			// 5.处理结果
			while (rs.next()) {
				obj.add(rs.getObject(1));
				obj.add(rs.getObject(2));
				obj.add(rs.getObject(3));
				arr.add(obj);

			}

		} catch (SQLException ex) {

			ex.printStackTrace();

		}
		// 6.释放资源
		finally {

			JdbcUtils.free(rs, ps, conn);
			return arr;
		}
	}

	public static void closeDB() {
		try {
			if (rs != null) {
				rs.close();
				rs = null;

			}
			if (ps != null) {
				ps.close();
				ps = null;

			}
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
