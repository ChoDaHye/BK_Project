package main.bookSeach;

// 도서 조회 창
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import dto.BookVo;
import dto.UserVo;
import main.BookChoose.BkSeleck;
import main.UserJoin.Insert;

public class BookMenu {
	public static void bkMenu(Scanner sc) {	
		
		 loop:
		 while(true){
			 	System.out.printf("\n *** 도서 조회를 시작합니다. ***");
			 	System.out.println(" \n ===============================================");
			 	System.out.printf(" \n  1.도서 조회 	2.전체 책 목록      3. 종료 ");
			 	System.out.println(" \n ===============================================");
			 	System.out.print(" ▶");
		        int selec=sc.nextInt();
		        
		        switch(selec){
		        case 1: 
		     
		        	System.out.printf("\n  ** 도서를 입력하세요 ** : ");
		        	String str =sc.next();
		        	System.out.println(" ");
		        
		        	if(str.equals("초등")) {
		        	 BkSeleck.selectname(); 
		        	}else if(str.equals("중등")) {
		        	 BkSeleck.selectname1();
		        	}else if(str.equals("고등")) {
		        	 BkSeleck.selectname2();
		        	}else if(str.equals("수능")) {
		        	 BkSeleck.selectname3();
		        	}else if(str.equals("올킬")) {
		        	 BkSeleck.selectname4();
		        	}else if(str.equals("너도")) {
		        	 BkSeleck.selectname5();
		        	}
		       
		        	break;       
		   
		        case 2: 
		        	System.out.println(" \n ===============================================");
		        	System.out.println(" 전체 도서를 불러옵니다.");  
		        	System.out.println(" \n ===============================================");
		        	BkSeleck.selectBook1(); 
		        	System.out.println(" \n ===============================================");
		        
		        	break;
				
		        case 3: System.out.println(" \n종료 되었습니다.");
		        	break loop;

		
		        }
		 }
	 }
	
}

