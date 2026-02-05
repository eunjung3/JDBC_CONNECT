package dbutil;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class DBUpdateTest {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String user= "jdbcuser";
        String password = "jdbcuser";

        try (Connection conn = DriverManager.getConnection(url, user, password);) {
            // java에서는 시간 now 대신 아래 방법으로 사용.
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String sql = "update person set phone1 = '02', phone2 = '588-9991', age = 20, modifyDate = '" + sf.format(new Date()) + "' where id = 1";
        
            Statement stmt = conn.createStatement();

            int result = stmt.executeUpdate(sql);
            if (result != 0) {
                System.out.println("레코드 수정 성공");
            } else {
                System.out.println("레코드 수정 실패");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
