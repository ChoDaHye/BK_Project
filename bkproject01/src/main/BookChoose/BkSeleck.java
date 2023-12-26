package main.BookChoose;

// 초등, 중등, 고등, 수능, 올킬, 너도로 책 검색 하는 함수, 연령대 별 책 조회 함수
import java.sql.Connection;
import java.sql.PreparedStatement;   // 3. DB 쿼리문 사용
import java.sql.ResultSet;         // 4. DB 쿼리문 수행 결과
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import dto.BookVo;
import util.DBManager;
public class BkSeleck {
	 


    	   // 연령대별 책 조회 DB 조회(select) 함수
	   		public static BookVo selectBook(int book_age) {

		   	  BookVo selectBook = new BookVo();
		      String sql = "SELECT rownum, book_title  FROM BOOK WHERE  book_age = ? ";
		
		      PreparedStatement pstmt = null;
		      ResultSet rs = null;
		      Connection conn = null;
		            
		      try {
		         conn = DBManager.getConnection();   // DB 연결
		
//		         (3단계) PreparedStatement 객체 생성
		          pstmt = conn.prepareStatement(sql);      // 쿼리문 실행
		          pstmt.setInt(1, book_age);
		         
//		         (4단계) SQL문 실행 결과 처리
		         rs = pstmt.executeQuery();         // 쿼리문 결과 처리
		        
		         while(rs.next()) {
		        	System.out.println(rs.getString("rownum") + "  "+rs.getString("book_title"));
		         }
    		      } catch(Exception e) {
	 	         System.out.println("예외 발생시 처리할 코드: 쿼리문 조회");
	 	      }
		      	 DBManager.close(conn, pstmt, rs);      // DB 닫기
		         return selectBook;
	   			}
	   
	   
	       // DB 조회(select) 함수
	   		public static BookVo selectBook1() {
	   			BookVo selectBook1 = new BookVo();
	   			String sql = "SELECT book_title  FROM BOOK order by book_title";
			
	   			PreparedStatement pstmt = null;
	   			ResultSet rs = null;
	   			Connection conn = null;
			            
	   			try {
	   				conn = DBManager.getConnection();   // DB 연결
//			  		(3단계) PreparedStatement 객체 생성
	   				pstmt = conn.prepareStatement(sql);      // 쿼리문 실행
			         
//	         		 (4단계) SQL문 실행 결과 처리
	   				 rs = pstmt.executeQuery();         // 쿼리문 결과 처리
	   				 while(rs.next()) {
	   				  System.out.println(rs.getString("book_title"));
	   				}
	   				 } catch(Exception e) {
	   			     System.out.println("예외 발생시 처리할 코드: 쿼리문 조회");
	   			  }
	   				DBManager.close(conn, pstmt, rs);      // DB 닫기
	   				return selectBook1;
	   				}

		   
	   	   // 초등으로 이름을 검색 했을때 나오는 책 DB 조회(select) 함수(초등 이름)
		   public static BookVo selectname() {
			  BookVo selectname = new BookVo();
			  String sql = "select book_title from book where book_title like '%초등%'";
		
			  PreparedStatement pstmt = null;
			  ResultSet rs = null;
			  Connection conn = null;
			            
			 try {
			  conn = DBManager.getConnection();   // DB 연결
//			  (3단계) PreparedStatement 객체 생성
			  pstmt = conn.prepareStatement(sql);      // 쿼리문 실행
			         
//	          (4단계) SQL문 실행 결과 처리
	          rs = pstmt.executeQuery();         // 쿼리문 결과 처리
	          while(rs.next()) {
	          System.out.println(rs.getString("book_title"));
	          }
		 	         
		      } catch(Exception e) {
		        System.out.println("예외 발생시 처리할 코드: 쿼리문 조회");
		      }
		      DBManager.close(conn, pstmt, rs);      // DB 닫기
		      return selectname;
		   }
		   
		   
		   // 중등으로 검색했을 때 나오는 책 DB 조회(select) 함수(중등 이름)
		   public static BookVo selectname1() {
				  BookVo selectname1 = new BookVo();
				  String sql = "select book_title from book where book_title like '%중등%'";
			
				  PreparedStatement pstmt = null;
				  ResultSet rs = null;
				  Connection conn = null;
				            
				 try {
				  conn = DBManager.getConnection();   // DB 연결
//				  (3단계) PreparedStatement 객체 생성
				  pstmt = conn.prepareStatement(sql);      // 쿼리문 실행
				         
//		          (4단계) SQL문 실행 결과 처리
		          rs = pstmt.executeQuery();         // 쿼리문 결과 처리
		          while(rs.next()) {
		          System.out.println(rs.getString("book_title"));
		          }
			 	         
			      } catch(Exception e) {
			        System.out.println("예외 발생시 처리할 코드: 쿼리문 조회");
			      }
			      DBManager.close(conn, pstmt, rs);      // DB 닫기
			      return selectname1;
			   }

		  
		   // 고등으로 검색했을 때 나오는 책, DB 조회(select) 함수(고등 이름)
		   public static BookVo selectname2() {
				  BookVo selectname2 = new BookVo();
				  String sql = "select book_title from book where book_title like '%고등%'";
			
				  PreparedStatement pstmt = null;
				  ResultSet rs = null;
				  Connection conn = null;
				            
				 try {
				  conn = DBManager.getConnection();   // DB 연결
//				  (3단계) PreparedStatement 객체 생성
				  pstmt = conn.prepareStatement(sql);      // 쿼리문 실행
				         
//		          (4단계) SQL문 실행 결과 처리
		          rs = pstmt.executeQuery();         // 쿼리문 결과 처리
		          while(rs.next()) {
		          System.out.println(rs.getString("book_title"));
		          }
			 	         
			      } catch(Exception e) {
			        System.out.println("예외 발생시 처리할 코드: 쿼리문 조회");
			      }
			      DBManager.close(conn, pstmt, rs);      // DB 닫기
			      return selectname2;
			   }

		   
		   // 수능으로 검색했을 때 나오는 책, DB 조회(select) 함수(수능 이름)
		   public static BookVo selectname3() {
				  BookVo selectname3 = new BookVo();
				  String sql = "select book_title from book where book_title like '%수능%'";
			
				  PreparedStatement pstmt = null;
				  ResultSet rs = null;
				  Connection conn = null;
				            
				 try {
				  conn = DBManager.getConnection();   // DB 연결
//				  (3단계) PreparedStatement 객체 생성
				  pstmt = conn.prepareStatement(sql);      // 쿼리문 실행
				         
//		          (4단계) SQL문 실행 결과 처리
		          rs = pstmt.executeQuery();         // 쿼리문 결과 처리
		          while(rs.next()) {
		          System.out.println(rs.getString("book_title"));
		          }
			 	         
			      } catch(Exception e) {
			        System.out.println("예외 발생시 처리할 코드: 쿼리문 조회");
			      }
			      DBManager.close(conn, pstmt, rs);      // DB 닫기
			      return selectname3;
			   }

		   
		   // 올킬로 검색했을 때 나오는 책 DB 조회(select) 함수(올킬 이름)
		   public static BookVo selectname4() {
				  BookVo selectname4 = new BookVo();
				  String sql = "select book_title from book where book_title like '%올킬%'";
			
				  PreparedStatement pstmt = null;
				  ResultSet rs = null;
				  Connection conn = null;
				            
				 try {
				  conn = DBManager.getConnection();   // DB 연결
//				  (3단계) PreparedStatement 객체 생성
				  pstmt = conn.prepareStatement(sql);      // 쿼리문 실행
				         
//		          (4단계) SQL문 실행 결과 처리
		          rs = pstmt.executeQuery();         // 쿼리문 결과 처리
		          while(rs.next()) {
		          System.out.println(rs.getString("book_title"));
		          }
			 	         
			      } catch(Exception e) {
			        System.out.println("예외 발생시 처리할 코드: 쿼리문 조회");
			      }
			      DBManager.close(conn, pstmt, rs);      // DB 닫기
			      return selectname4;
			   }
		
		   
		   // 너도로 검색했을 때 나오는 책 DB 조회(select) 함수(너도 이름)
		   public static BookVo selectname5() {
				  BookVo selectname5 = new BookVo();
				  String sql = "select book_title from book where book_title like '%너도%'";
			
				  PreparedStatement pstmt = null;
				  ResultSet rs = null;
				  Connection conn = null;
				            
				 try {
				  conn = DBManager.getConnection();   // DB 연결
//				  (3단계) PreparedStatement 객체 생성
				  pstmt = conn.prepareStatement(sql);      // 쿼리문 실행
				         
//		          (4단계) SQL문 실행 결과 처리
		          rs = pstmt.executeQuery();         // 쿼리문 결과 처리
		          while(rs.next()) {
		          System.out.println(rs.getString("book_title"));
		          }
			 	         
			      } catch(Exception e) {
			        System.out.println("예외 발생시 처리할 코드: 쿼리문 조회");
			      }
			      DBManager.close(conn, pstmt, rs);      // DB 닫기
			      return selectname5;
			   }
}








