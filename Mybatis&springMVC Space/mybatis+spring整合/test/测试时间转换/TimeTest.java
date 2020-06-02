
package 测试时间转换;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;


/** 
  *
  * @Author  gz
  * @CreateDate  2017年10月20日 上午9:29:49 
  * @Description  
  */
public class TimeTest {
	public static void main(String[] args) {
		query();
		queryParameter();
	}
	
	
	    //两种连接方式的比较(注意：要分别导入jdbc和jtds的jar包)
	    //jdbc方式
		/*private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";// 数据库驱动字符串
		private static String url = "jdbc:sqlserver://localhost:1433;database=CEJ"*/;// 连接URL字符串
		
		//jtds方式 
		/*private static String driver = "com.mysql.jdbc.Driver";
		private static String url = "jdbc:jtds:sqlserver://127.0.0.1:1433/CEJ";
		private static String user = "sa"; // 数据库用户名
		private static String password = "123456"; // 用户密码
*/		
		private static String driver = "com.mysql.jdbc.Driver";// 数据库驱动字符串
		private static String url = "jdbc:mysql://localhost:3306/mybatis";// 连接URL字符串
		private static String user = "root"; // 数据库用户名
		private static String password = "123456"; // 用户密码

		
		static Connection conn = null;
		static PreparedStatement pStatement = null;
		static ResultSet rSet = null;
		
		/**
		 * 关闭的方法
		 * 
		 * @throws SQLException
		 */
		static void close() throws SQLException {
			// 7.关闭
			if (rSet != null) {
				rSet.close();
			}
			if (pStatement != null) {
				pStatement.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		
		
		/**
		 * 无参查询方法
		 */
		static void query() {
			try {
				// 1.加载驱动
				Class.forName(driver);
				// 2.创建连接对象
				conn = DriverManager.getConnection(url, user, password);
				// 3.编写SQL语句
				String sql = "SELECT * FROM items";
				// 4.创建执行对象
				pStatement = conn.prepareStatement(sql);
				// 5.执行操作
				rSet = pStatement.executeQuery();
				// 6.输出结果
				System.out.println("数据信息如下：");
				while (rSet.next()) {
					System.out.println(rSet.getString(1) + "\t"+ rSet.getString(2) + "\t" + rSet.getString(3)+"\t"+rSet.getDate(5));
				}
				

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				//7.关闭连接
				try {
					close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		/**
		 * 无参查询方法
		 */
		static void queryParameter() {
			try {
				// 1.加载驱动
				Class.forName(driver);
				// 2.创建连接对象
				conn = DriverManager.getConnection(url, user, password);
				// 3.编写SQL语句
				String sql = "SELECT * FROM items where items.createTime like ?";
				// 4.创建执行对象
				pStatement = conn.prepareStatement(sql);
				pStatement.setString(1, "%2018-08-08%");
				// 5.执行操作
				rSet = pStatement.executeQuery();
				// 6.输出结果
				System.out.println("数据信息如下：");
				while (rSet.next()) {
					System.out.println(rSet.getString(1) + "\t"+ rSet.getString(2) + "\t" + rSet.getString(3)+"\t"+rSet.getDate(5));
				}
				

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				//7.关闭连接
				try {
					close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		

}
