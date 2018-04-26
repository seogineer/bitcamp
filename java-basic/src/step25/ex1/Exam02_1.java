package step25.ex1;

import java.sql.DriverManager;

public class Exam02_1 {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("JDBC 드라이버 로딩 및 등록 완료!");
        
        java.sql.Connection con = 
                DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useExam01_5.javaSSL=false", "java106", "1111");
        System.out.println("DBMS와 연결됨!");
        
        con.close();
    }
}
