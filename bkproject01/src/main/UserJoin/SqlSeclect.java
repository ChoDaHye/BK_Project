//package main.UserJoin;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import dto.UserVo;
//import util.DBManager;
//import util.DBManager1;
//
//public class SqlSeclect {
//
////	DB 조회(select) 함수
////	회원 정보 조회 : select
//
////  DB 조회(select) 함수
//	 
//	
//	static void usersInfo(String user_id) {
//		String sql = "SELECT * FROM USERS ";
//
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		Connection conn = null;
//
//		try {
//			conn = DBManager.getConnection(); // DB 연결
//
////     (3단계) PreparedStatement 객체 생성
//			pstmt = conn.prepareStatement(sql); // 쿼리문 실행
//			pstmt.setString(1, user_id); // 1: 물음표 순서, code: 물음표 값
//
////       (4단계) SQL문 실행 결과 처리
//			rs = pstmt.executeQuery(); // 쿼리문 결과 처리
//
////       rs.next(): 다음 행(row)을 확인(반환값타입: boolean)
////       if(rs.next()) {      // if는 한번만 실행하므로 반복실행은 while
//			while (rs.next()) {
////          컬럼을 일일이 가져오기엔 번거로우므로, 배열 or 리스트 라이브러리 사용하여 가져옴
////          rs.getInt(0);
//
//			String id1 = rs.getString("id");
////          String ex_date = rs.getString("ex_date");
////          String currency_name = rs.getString("currency_name");
//
//			}
//
//		} catch (Exception e) {
//			System.out.println("예외 발생시 처리할 코드: 쿼리문 조회");
//		}
//		DBManager.close(conn, pstmt, rs); // DB 닫기
//	}
//
//}
