package dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import domain.PersonVO;

public class DBInsertTest2 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String user= "jdbcuser";
        String password = "jdbcuser";

        PersonVO vo = new PersonVO((byte)24, "testuser2", "testuser2pw", "testuser2",
                "testuser@test.com", "02", "998-8832", "서울", "어딘가");
        
        try (Connection conn = DriverManager.getConnection(url, user, password);) {
            String sql = "insert into person (userId, userPw, userName, userEmail, phone1, phone2, age, address1, address2)" + 
                    "values ('" + vo.getUserId() + "', '" + vo.getUserPw() + "', '" + vo.getUserName() +
                            "', '" + vo.getUserEmail() + "', '" + vo.getPhone1() + "', '" + vo.getPhone2() +
                            "', '" + vo.getAge() + "', '" + vo.getAddress1() + "', '" + vo.getAddress2() + "')";
        
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
