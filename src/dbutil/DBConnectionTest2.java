package dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionTest2 {
    public static void main(String[] args) {
        // DB Connection 작업
        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이버 로드 성공");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "jdbcuser", "jdbcuser");
            System.out.println(conn);
            System.out.println("데이터베이스 접속 성공");
        } catch (ClassNotFoundException e) {
            System.out.println("실패");
        } catch (SQLException sqle) {
            System.out.println("실패");
        } finally {
            try {
            if (conn != null) conn.close();                
            } catch (Exception e) {
            }
        }
    }
}
