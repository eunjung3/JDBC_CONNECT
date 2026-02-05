package dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBInsertTest {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String user= "jdbcuser";
        String password = "jdbcuser";

        try (Connection conn = DriverManager.getConnection(url, user, password);) {
            String sql = "insert into person (userId, userPw, userName, userEmail) values ('testuser1', 'testuser1', 'testuser1', 'testuser1@test.com')";
        
            Statement stmt = conn.createStatement();

            int result = stmt.executeUpdate(sql);
            if (result != 0) {
                System.out.println("레코드 추가 성공");
            } else {
                System.out.println("레코드 추가 실패");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
