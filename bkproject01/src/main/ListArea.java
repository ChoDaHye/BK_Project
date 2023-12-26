package main;

import java.util.ArrayList;
import java.util.List;

import dto.AreaVO;

public class ListArea {
	  
	   static void listArea() {
		   List list = new ArrayList();
		   
		   for(int i = 0; i < 3; i++) {
			   AreaVO aVo = new AreaVO();
			   
			   aVo.setCode(1);
			   aVo.setName("영국");
			   aVo.setIs_around("1");
			   
			   list.add(aVo);					// 1. 데이터 객체 추가
		   }
		   
//		   list.remove(0);						// 2. 데이터 객체 삭제(인덱스)
		   
		   AreaVO aVo1 = null;
		   
		   for(int i = 0; i < 3; i++) {
			   aVo1 = new AreaVO();
			   aVo1 = (AreaVO) list.get(i);		// 3. 데이터 객체 로드
			   
			   System.out.println(aVo1.getCode());
			   System.out.println(aVo1.getName());
			   
		
		   }
	  
		   int size = list.size();		// 데이터 크기 조회
		   System.out.println(size);
		   
		  
	   }

}
