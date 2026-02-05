package dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.PersonVO;

public class DBSelectTest2 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String user= "jdbcuser";
        String password = "jdbcuser";

        try (Connection conn = DriverManager.getConnection(url, user, password);) {
            String sql = "select * from person";
        
            Statement stmt = conn.createStatement();
            ResultSet rs = null;

            rs = stmt.executeQuery(sql);

            List<PersonVO> list = new ArrayList<>();
            while (rs.next()) {    // rs.next() 반환값은 boolean
                PersonVO vo = new PersonVO(rs.getByte("age"), rs.getString("userId"), rs.getString("userPw"),
                                rs.getString("userName"), rs.getString("userEmail"), rs.getString("phone1"),
                                rs.getString("phone2"), rs.getString("address1"), rs.getString("address2"));
                vo.setId(rs.getLong("id"));
                vo.setRegDate(rs.getTimestamp("regDate"));
                vo.setModifyDate(rs.getTimestamp("modifyDate"));
                list.add(vo);
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
