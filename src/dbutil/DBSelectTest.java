package dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBSelectTest {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String user= "jdbcuser";
        String password = "jdbcuser";

        try (Connection conn = DriverManager.getConnection(url, user, password);) {
            String sql = "select * from person";
        
            Statement stmt = conn.createStatement();
            ResultSet rs = null;

            rs = stmt.executeQuery(sql);
            while (rs.next()) {    // rs.next() 반환값은 boolean
                System.out.println("id: " + rs.getLong("id"));
                System.out.println("userId: " + rs.getString("userId"));
                System.out.println("userPw: " + rs.getString("userPw"));
                System.out.println("userEmail: " + rs.getString("userEmail"));
                System.out.println("Phone: " + rs.getString("phone1") + 
                                            "-" + rs.getString("phone2"));
                System.out.println("age: " + rs.getByte("age"));
                System.out.println("address1: " + rs.getString("address1"));
                System.out.println("address2: " + rs.getString("address2"));
                System.out.println("regDate: " + rs.getTimestamp("regDate"));
                System.out.println("modifyDate: " + rs.getTimestamp("modifyDate"));

            } 
            // else {
            //     System.out.println("저장된 레코드가 없어요.");
            // }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}