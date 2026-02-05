package dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionTest {
    public static void main(String[] args) {
        // 1. 데이터베이스 연결을 위한 Connection 객체 선언
        Connection conn = null;

        // 2. 데이터베이스 접속 테스트
        try {
            // 드라이버 로드
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이버 로드 성공");

            // 데이터 베이스 접속 정보를 담은 Connection 객체 생성
            // jdbc:mysql://    -> jdbc로 mysql 접속
            // localhost -> 서버 주소.
            // :3306 -> 포트 번호
            // /jdbc -> DB 이름
            // jdbc:mysql://localhost:3306/jdbc
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "jdbcuser", "jdbcuser");
            System.out.println(conn);
            System.out.println("데이터베이스 접속 성공");
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 로드 실패");
        } catch (SQLException sqle) {
            System.out.println("SQL 에러 발생(데이터베이스 접속 실패)");
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (Exception e) {
            }
        }
    }
}
