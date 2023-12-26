package main;

// 회원 가입, 결제 삽입 + 연령대별 book 추천 조회 함수
import java.sql.Connection;
import java.sql.PreparedStatement;   // 3. DB 쿼리문 사용
import java.sql.ResultSet;         // 4. DB 쿼리문 수행 결과
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import dto.BookVo;
import dto.PayVo;
import dto.UserVo;
import util.DBManager;

public class Insert {
	
	 
	
	// 회원가입 DB 삽입(insert) 함수
	static void insertUsers(String user_id, int user_age, int order_count, int order_record) {
    String sql = "INSERT INTO USERS VALUES( ?, ?, ?, ?)";
    
    PreparedStatement pstmt = null;
    Connection conn = null;
    
    try {
        conn = DBManager.getConnection();      // DB 연결
       
//      (3단계) PreparedStatement 객체 생성
         pstmt = conn.prepareStatement(sql);      // 쿼리문 실행
         pstmt.setString(1, user_id);
         pstmt.setInt(2, user_age);
         pstmt.setInt(3, order_count );
         pstmt.setInt(4, order_record);
       
//       (4단계) SQL문 실행 결과 처리
//       pstmt.executeQuery();         // 쿼리문 결과 처리
         pstmt.executeUpdate();         // insert/update/delete 쿼리문 결과 처리
       
       } catch(Exception e) {
         System.out.println("예외 발생시 처리할 코드: 쿼리문 삽입");
       }
         DBManager.close(conn, pstmt);      // DB 닫기
    }	

	
   // 도서 결제 DB 조회함수 (pay) insert 함수
   public static PayVo insertBkPay() {
	   		 PayVo pay = new PayVo();
	         Scanner sc = new Scanner(System.in);
			 
	         System.out.printf("\n *** 도서 결제를 등록을 시작합니다. ***");
	         System.out.println(" \n ===============================================");
	         System.out.println(" 결제할 사람의 아이디를 입력해주세요 ");
	         System.out.print(" ▶ ");
	         pay.setId(sc.nextLine());
	         
	         System.out.println(" ===============================================");
	         System.out.println(" 주문 번호를 입력해주세요 ");
	         System.out.print(" ▶ ");
	         pay.setOrderNumer(sc.nextInt());
	         
	         
	         
	         System.out.println(" ===============================================");
	         System.out.println(" 지불할 금액을 입력해 주세요");
	         System.out.print(" ▶ ");
	         pay.setPrice(sc.nextInt());
	         
	    
	         System.out.println(" ===============================================");
	         System.out.println(" 아이디 확인 : " + pay.getId());
	         System.out.println(" \n 주문 번호 확인 : " + pay.getOrderNumer());
	         System.out.println(" \n 지불 금액 확인 : " + pay.getPrice());
	         System.out.println("");
	         System.out.printf( "\n 결제 날짜 : " );
	         pay.setDate(getDate());
	         System.out.println(" ===============================================");
	         System.out.println("\n 결제 하시겠습니까? \n \n 1.확인 | 2.취소");
	         System.out.println(" ===============================================");
	         System.out.print(" ▶ ");
	         int yesOrNO = sc.nextInt();
	         

	         Connection conn = null;
	         PreparedStatement pstmt = null;

	         if(yesOrNO==1) {
	            try {
	               String sql = "INSERT INTO BOOK_SALES VALUES( ?, ?, ? )";
	              
	               conn = DBManager.getConnection();
	               pstmt = conn.prepareStatement(sql);
	               pstmt.setInt(1, pay.getOrderNumer());
	               pstmt.setInt(2, pay.getPrice());
	               pstmt.setString(3, pay.getId());
	               pstmt.executeUpdate();
	               
	               
	               System.out.println(" ===============================================");
	               System.out.println(" 결제가 등록되었습니다..");
	               System.out.println(" ===============================================");
	               
	            } catch (Exception e) {
	               System.out.println(" 예외 발생시 처라할 코드: ");
	            }
	         } else {
	            System.out.println(" ===============================================");
	            System.out.println(" 등록을 취소하였습니다.");
	            System.out.println(" ===============================================");
	         }
	         DBManager.close(conn, pstmt);
	         return pay;
	      }
  
   
   // 현재 날짜 함수
	public static String getDate() {
		// 현재 날짜/시간        
		LocalDateTime now = LocalDateTime.now();         
		// 현재 날짜/시간 출력        
//		System.out.println(now); // 2021-06-17T06:43:21.419878100   
		
		// 포맷팅        
		String formatedNow = now.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초"));  
//		String formatedNow = now.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
		
		// 포맷팅 현재 날짜/시간 출력        
		System.out.println(formatedNow);  // 2021년 06월 17일 06시 43분 21초
		return formatedNow;
	}
	
	
}
