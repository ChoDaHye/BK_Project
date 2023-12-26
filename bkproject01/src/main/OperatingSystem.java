package main;

import java.sql.Connection;
import java.sql.PreparedStatement;   // 3. DB 쿼리문 사용
import java.sql.ResultSet;         // 4. DB 쿼리문 수행 결과
import java.util.ArrayList;
import java.util.List;

import dto.AreaVO;
import util.DBManager;

public class OperatingSystem {
   public static void main(String[] args) {
//      AreaVo aVo = selectArea(3);
//      System.out.println("aVo.getCode()");
//      areaInfo(3);      // code가 3번인 area
      
      int code = 0;
      String name = null;
      String is_around = null;
      int country_code = 0;
      
      // <저장할 객체의 데이터타입>
//      List<저장할 개체의 데이터타입> 변수명 = new ArrayList<>();
      List<AreaVO> areaList = selectArea(3);         // [4]. 반환 타입 변경
      
      for(AreaVO aVo : areaList) {   // 향상된 for문으로 출력
         System.out.println(aVo);
         code = aVo.getCode();
         name = aVo.getName();
         is_around = aVo.getIs_around();
         country_code = aVo.getCountry_code();
         
         System.out.println(aVo);
         System.out.println(aVo.getCode() + "\t");
         System.out.println(aVo.getName() + "\t");
         System.out.println(aVo.getIs_around() + "\t");
         System.out.println(aVo.getCountry_code());
      }
      
//      // 이동한 지역은?
//      System.out.println("이동한 지역은?" + name);
//      System.out.println("==============");
//      insertArea(10, "청도", "1", 3);
//      insertArea(11, "하얼빈", "3", 4);
   }
   
//   ============================================================
   // 컬렉션(3): List컬렉션 => 배열처럼 인덱스번호로 데이터를 저장, 로드 가능
   // 관련함수:
//   1. list.add(객체값);         => 데이터 객체 추가
//   2. list.remove(인덱스번호);      => 데이터 객체 추가
//   3. list.get(인덱스번호);      => 데이터 객체 로드
//   4. list.size();               => 데이터 객체 크기 조회
   // List 컬렉션 실습 예시 ①
//   listArea();    //main 함수에서 실행하는 코드
   static void listArea() {
//      인터페이스 변수 = 구현객체;
      List list = new ArrayList();      // ArrayList 객체 생성
      
      AreaVO aVo = null;
      for(int i=0; i<3;i++) {
         aVo = new AreaVO();
         aVo.setCode(i);            //code에 데이터 저장
         aVo.setName("영국" + i);   //name에 데이터 저장
         
         list.add(aVo);      // 1. 데이터 객체 추가
      }
//      list.remove(0);         // 2. 데이터 객체 삭제(인덱스)
//      list.remove(1);         
      
      int size = list.size();   // 4. 데이터 크기 조회
//      System.out.println(size);
      
      AreaVO aVo1 = null;
      for(int i=0; i<size;i++) {
         aVo1 = new AreaVO();
         aVo1 = (AreaVO) list.get(i);   // 3. 데이터 객체 로드
         System.out.println(aVo1.getCode());
         System.out.println(aVo1.getName());
      }
   }

//   ============================================================
   // DB 삽입(insert) 함수
   // Insert 함수는 rs 사용하지 않음.
   static void insertArea(int code, String name, String is_around, int country_code) {
      String sql = "INSERT INTO area VALUES(?, ?, ?, ?)";
      
      PreparedStatement pstmt = null;
      Connection conn = null;
      
      try {
         conn = DBManager.getConnection();      // DB 연결
         
//         (3단계) PreparedStatement 객체 생성
         pstmt = conn.prepareStatement(sql);      // 쿼리문 실행
         pstmt.setInt(1, code);
         pstmt.setString(2, name);
         pstmt.setString(3, is_around);
         pstmt.setInt(4, country_code);
         
//         (4단계) SQL문 실행 결과 처리
//         pstmt.executeQuery();         // 쿼리문 결과 처리
         pstmt.executeUpdate();         // insert/update/delete 쿼리문 결과 처리
         
      } catch(Exception e) {
         System.out.println("예외 발생시 처리할 코드: 쿼리문 삽입");
      }
      DBManager.close(conn, pstmt);      // DB 닫기
   }
   
//   ============================================================
   // DB 조회(select) 함수
   static List selectArea(int code) {
//      String sql = "SELECT * FROM exchanges where code=?";
      String sql = "SELECT * FROM exchanges";
      
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      Connection conn = null;
      
      int code1 = 0;
      String name = null;
      String is_around = null;
      int country_code = 0;
      
      List list = new ArrayList();         // [1]. ArrayList 객체 생성
      
//      AreaVo aVo = new AreaVo();            // 디비에서 데이터를 담아오는 객체
      AreaVO aVo = null;                  
      
      try {
         conn = DBManager.getConnection();   // DB 연결
         
         
//         (3단계) PreparedStatement 객체 생성
         pstmt = conn.prepareStatement(sql);      // 쿼리문 실행
//         pstmt.setInt(1, code);      // 1: 물음표 순서, code: 물음표 값
         
//         (4단계) SQL문 실행 결과 처리
         rs = pstmt.executeQuery();         // 쿼리문 결과 처리
         
//         rs.next(): 다음 행(row)을 확인(반환값 타입: boolean)
//         if(rs.next()) {      // if는 한번만 실행하므로 반복실행은 while
         while(rs.next()) {
//            컬럼을 일일이 가져오기엔 번거로우므로, 배열 or 리스트 라이브러리 사용하여 가져옴
//            rs.getInt(0);
//            rs.getBoolean(0);
            
            aVo = new AreaVO();         // [5]. Vo 객체를 반복 생성
            
            code1 = rs.getInt("code");
//            String ex_date = rs.getString("ex_date");
//            String currency_name = rs.getString("currency_name");
//            double base_rate = rs.getDouble("base_rate");
//            double purchase_krw = rs.getDouble("purchase_krw");
            
               aVo.setCode(code1);         // aVo 객체의 필드에 데이터 저장
               aVo.setName(name);
               aVo.setIs_around(is_around);
               aVo.setCode(country_code);
               
//               System.out.println(aVo);   // 디버깅 체크
            
               list.add(aVo);            // [2]. 데이터 객체 추가
         }
         
      } catch(Exception e) {
         System.out.println("예외 발생시 처리할 코드: 쿼리문 조회");
      }
      DBManager.close(conn, pstmt, rs);      // DB 닫기
      // return aVo;      // 저장한 필드 데이터를 포함한 객체를 반환
      return list;      // [3]. 저장한 List 컬렉션 객체 반환
   }
}