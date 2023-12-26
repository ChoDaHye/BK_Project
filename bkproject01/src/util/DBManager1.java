package util;

import java.sql.DriverManager;		// 1. DB 관리
import java.sql.Connection;			// 2. DB 연결
import java.sql.PreparedStatement;	// 3. DB 쿼리문 사용
import java.sql.ResultSet;			// 4. 쿼리문 수행 결과
import java.sql.SQLException;


//DB 관리(연결, 닫기)
public class DBManager1 {

	public static Connection getConnection() {
		Connection conn = null;
		  // 1. JDBC 드라이버(클래스) 로드
	      // OracleDriver 클래스를 가져와 사용하겠다.
	      // 예외 처리 필요한 코드
	      // try {} : 예외가 발생할 거 같은 블록을 시도할 때
		
		try {			
			Class.forName("oracle.jdbc.OracleDriver");
			
			
		     // 2. 데이터 베이스 연결 객체 생성
		     // SQL Developer에서 유저 접속 시 나오는 세부 정보
		      String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		      String userid = "user_bk";
		      String password = "1234";
		      
		      conn = DriverManager.getConnection(url, userid, password);
		
		// catch(){}: 예외가 발생했을 때 처리 과정
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	 // DB 닫기
	   public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
	         try {
	            if(rs != null) {
	               rs.close();
	            }
	            if(pstmt != null) {
	               pstmt.close();
	            }
	            if(conn != null) {
	               conn.close();
	            }
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	         
	   }
	
	
	
}
