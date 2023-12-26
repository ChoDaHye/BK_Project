package main;

// 실행 클래스 (사용자 로그인 아웃)
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dto.BasketVo;
import dto.UserVo;
import main.UserJoin.OperatingSytene2;
import main.bookSeach.BookMenu;
import util.DBManager;

public class LoginOperation {
//	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		// 로그인 아웃 시작
		LogInOut log = new LogInOut();

		log.openWeb();

		Scanner sc = new Scanner(System.in);

		System.out.println("문제집은 여기 - 도서주다");
		System.out.println("=======================");

		System.out.println("오늘도 한 문제 더 풀어볼까?");
		System.out.println("=======================");

		System.out.println("1.로그인");
		System.out.println("2.회원가입");

		int Click = sc.nextInt();

		switch (Click) {
		case 1:
			System.out.println("아이디를 입력해주세요");
			break;
		case 2:
			System.out.println("회원가입을 해주세요");
			OperatingSytene2.join(sc);
			
			break;
		}

		System.out.println("=======================");

		sc.nextLine();
		String id = sc.nextLine();

		String dbid = selectUser(id);
		log.input(dbid, id);

		// 메인메뉴 카테고리 시작
		int Click2 = sc.nextInt();

		System.out.println("=======================");

		switch (Click2) {
			case 1:
				System.out.println("메인메뉴로 이동합니다");
				System.out.println("1.검색창  2.카테고리 ");
				break;
			case 2:
				System.out.println("로그아웃 성공!");
				break;
		}

		int num = sc.nextInt();
		log.menu(num, sc);

		// 장바구니담기 시작
		BasketVo wish = new BasketVo();

		System.out.println(id + "님 원하시는 도서를 결제하시겠습니까?");
		System.out.println("1.결제  2.장바구니  3.나가기");
		
		int num2 = sc.nextInt();
		System.out.println(num2);

		if (num2 == 1) {
			System.out.println("도서 결제페이지로 이동합니다");
			Insert.insertBkPay();
		} else if (num2 == 2) {
			System.out.println("위시리스트로 이동합니다");
			wish = wishList(sc);
			insertBasket(wish.getId(), wish.getTitle(), wish.getDate());
		} else {
			System.out.println("메인메뉴로 이동합니다");
		}

		sc.close();

	}

	public static BasketVo wishList(Scanner sc) {

		BasketVo wish = new BasketVo();

		System.out.println(">>>>>>>>>>이동중>>>>>>>>>>");

		System.out.println("회원님의 아이디를 입력해주세요");

		String id = sc.next();
		System.out.println(" ");
		wish.setId(id);
		System.out.println(wish.getId());

		System.out.println("(띄어쓰기없이) 원하시는 도서명을 입력해주세요");

		String title = sc.next();
		System.out.println(" ");
		wish.setTitle(title);
		System.out.println(wish.getTitle());

		System.out.println("오늘의 날짜를 입력해주세요");
		System.out.println("예시: 23년 12월 23일 > 231223 ");

		sc.nextLine();
		int date = sc.nextInt();
		System.out.println(" ");
		wish.setDate(date);
		System.out.println(wish.getDate());

		System.out.println(title + " 도서가 위시리스트로 저장되었습니다");
		return wish;
	}

	// 디비 아이디 조회(select) 함수
	static String selectUser(String userId) { // [4] 반환 타입 변경
		String sql = "SELECT USER_ID FROM USERS WHERE USER_ID = ?";

//		List list = new ArrayList(); // [1] ArrayList 객체생성

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;

		String user_id = null;

		UserVo uVo = new UserVo();

		try {
			conn = DBManager.getConnection(); // DB 연결

			// (3단계) PreparedStatement 객체 생성 라이브러리
			pstmt = conn.prepareStatement(sql); // 쿼리문 진행
			pstmt.setString(1, userId);
			// (4단계) SQL문 실행 결과 처리
			rs = pstmt.executeQuery();

			while (rs.next()) {
				uVo = new UserVo(); // [5]. Vo객체를 반목 생성
				user_id = rs.getString("user_id");

				uVo.setId(user_id);
//				System.out.println(uVo);
//				list.add(uVo);
			}
		} catch (Exception e) {
			System.out.println("예외 발생시 처리 할 코드: 쿼리문 조회");
		}
//		System.out.println(conn);
//		System.out.println(pstmt);
//		System.out.println(rs);
		DBManager.close(conn, pstmt, rs);
		return user_id;
	}

	// 장바구니 디비 삽입(insert) 함수
	static void insertBasket(String USER_ID, String BOOK_TITLE, int MY_DATE) {
		String sql = "INSERT INTO BASKET VALUES(?, ?, ?)";

		PreparedStatement pstmt = null;
		Connection conn = null;

		try {
			conn = DBManager.getConnection(); // DB 연결

			// (3단계) PreparedStatement 객체 생성 라이브러리
			pstmt = conn.prepareStatement(sql); // 쿼리문 진행
			pstmt.setString(1, USER_ID);
			pstmt.setString(2, BOOK_TITLE);
			pstmt.setInt(3, MY_DATE);

			// (4단계) SQL문 실행 결과 처리
//				pstmt.executeQuery();		//select 쿼리문 결과 처리
			pstmt.executeUpdate(); // insert, update, delete 쿼리문 결과 처리

		} catch (Exception e) {
			System.out.println("예외 발생시 처리 할 코드: 쿼리문 삽입");
		}
		DBManager.close(conn, pstmt); // DB 닫기
	}

}