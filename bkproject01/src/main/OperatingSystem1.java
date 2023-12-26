package main;

import java.sql.Connection; // DB 연결
import java.sql.PreparedStatement; // DB 쿼리문 사용
import java.sql.ResultSet; // DB 쿼리문 수행결과
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.AreaVO;
import util.DBManager;
import util.DBManager1;

public class OperatingSystem1 {
	
	
	
	// DB 조회 (select) 함수
	static List selectArea(int code) {						
//		String sql = "SELECT * FROM USERS where code=?";
		String sql = "SELECT * FFOM USERS";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;

		int code1 = 0;
		String name = null;
		String is_around = null;
		int country_code = 0;

		List list = new ArrayList(); // [1]. ArrayList 객체 생성

		AreaVO aVo = new AreaVO(); // 디비에서 데이터를 담아 오는 객체
//	     AreaVO aVo = null;            // 디비에서 데이터를 담아 오는 객체

		try {
			conn = DBManager.getConnection(); // 디비 열결

			// 데이터 조회
			// (3단계) preparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql); // 쿼리문 실행
			pstmt.setInt(1, code); // 1 : 물음표 순서, code : 물음표 값

			// (4단계) SQL문 실행 결과 처리
			rs = pstmt.executeQuery();

//	         rs.next() : 다음행(row)를 확인(반환값 타입 : 블리언)
			while (rs.next()) {
//	            aVo = new AreaVO();

				code1 = rs.getInt("code");
				name = rs.getString("name");
				is_around = rs.getString("is_around");
				country_code = rs.getInt("country_code");

				aVo.setCode(code1); // aVo 객체의 필드에 데이터 저장
				aVo.setName(name);
				aVo.setIs_around(is_around);
				aVo.setCode(country_code);

				list.add(aVo);
			}

			// 쿼리문 결과 처리
		} catch (Exception e) {
			System.out.println("예외 발생시 처리할 코드: 쿼리문 조회");
		}
		DBManager.close(conn, pstmt, rs); // 디비 닫기
		// return aVo; // 저장한 필드 데이터를 포함한 객체를 반환
		return list; // [3]. 저장한 List 컬렉션 객체 반환

	}
}