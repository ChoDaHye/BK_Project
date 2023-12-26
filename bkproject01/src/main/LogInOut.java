package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dto.BookVo;
import main.bookSeach.BookMenu;
import util.DBManager;

//로그인, 로그아웃 - 아이디, 전화번호
public class LogInOut {

		// 필드
		// 생성자
		// 메서드
		
		void openWeb() {
			System.out.println("도서주다 앱을 시작합니다");
		}

		//로그인 로그아웃
		void input(String dbid, String id) {
			
			if (id.equals(dbid)) {
				System.out.println("로그인 성공! " + id + "님 반가워요^^");
				System.out.println("**공지** 이번달 이벤트: 10문제 맞히면 포인트가 팡팡!!");
				System.out.println("1.메인메뉴");
				System.out.println("2.로그아웃");
			} else{
				System.out.println("로그인 실패!");
			  }
		}
		
		//메인메뉴 - 카테고리 검색
		void menu(int num, Scanner sc) {
			if(num == 1) {
				System.out.println("원하는 도서를 검색해주세요");
				BookMenu.bkMenu(sc);
			}else if(num == 2) {
				System.out.println("카테고리로 도서를 검색합니다");
				System.out.println("예시) 국어");
				sc.nextLine();
				String category = sc.nextLine();
					List<BookVo> clist = selectCategory(category); 
						
					String book_title;
					int bkseq;
					String Category;
						
					for (BookVo bVo : clist) {
						
						book_title = bVo.getTitle();
						bkseq = bVo.getBkSeq();
						category = bVo.getBkCategory();
							
							
						System.out.print(book_title + "\t");
						System.out.print(bkseq + "\t");
						System.out.print(category + "\t");
						System.out.println();
					
					}
			}
			
		}
			
		
		
		// 카테고리 조회 디비 함수
		//List 테이블의 1개이상의 값을 반환하는 함수
		static List selectCategory(String category) { //[4] 반환 타입 변경
			String sql = "SELECT * FROM BOOK WHERE book_category = ?";
			
			List list = new ArrayList(); // [1] ArrayList 객체생성

			PreparedStatement pstmt = null;
			ResultSet rs = null;
			Connection conn = null;
			
			String BOOK_TITLE = null;
			int BOOK_SEQ = 0;
			String BOOK_CATEGORY = null;
		
			BookVo bVo = new BookVo();

			try {
				conn = DBManager.getConnection(); // DB 연결

				// (3단계) PreparedStatement 객체 생성 라이브러리
				pstmt = conn.prepareStatement(sql); // 쿼리문 진행
				pstmt.setString(1, category);
				// (4단계) SQL문 실행 결과 처리
				rs = pstmt.executeQuery(); 

//				System.out.println(rs.next());
				while (rs.next()) {
					bVo = new BookVo(); //[5]. Vo객체를 반목 생성
					BOOK_TITLE = rs.getString("BOOK_TITLE");
					BOOK_SEQ = rs.getInt("BOOK_SEQ");
					BOOK_CATEGORY = rs.getString("BOOK_CATEGORY");
					
					bVo.setTitle(BOOK_TITLE);
					bVo.setBkSeq(BOOK_SEQ);
					bVo.setBkCategory(BOOK_CATEGORY);
//					System.out.println(bVo);
					list.add(bVo);
				}
			} catch (Exception e) {
				System.out.println("예외 발생시 처리 할 코드: 쿼리문 조회");
			  }

			DBManager.close(conn, pstmt, rs);
			return list; 
		}

		
}