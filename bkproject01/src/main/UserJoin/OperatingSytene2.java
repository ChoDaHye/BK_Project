package main.UserJoin;
// 회원 가입 창
import java.util.Scanner;

import dto.BookVo;
import dto.UserVo;
import main.BookChoose.BkSeleck;
import java.util.Random;

public class OperatingSytene2 {
	private static UserVo user[] = new UserVo[10];	//객체 배열 선언 및 생성
	private static Scanner scanner = new Scanner(System.in);
	private static String id;
	private String order;
	private String orderRecord;
	private static int age;

//	public static void main(String[] args) {
		public static void join(Scanner sc) {	
		// NullpointerException방지 배열 초기화
		// 무엇을 선택해도 첫번째 배열부터 나오는 코드
		for(int i=0;i<10;i++) {
			user[i] = new UserVo(); 
		}
		
		UserVo users = new UserVo();
		BookVo age1 = new BookVo();
		
		boolean run = true;

		do {
			 System.out.printf("\n *** 회원가입창 *** \n");
		 	 System.out.println(" =================================================");
			 System.out.printf(" \n 1. 회원가입 	 2. 연령대별 책 추천     3. 종료 ");
			 System.out.println(" \n =================================================");
			 System.out.print(" ▶");
			 
			 int select = scanner.nextInt();			
//			 //회원가입 선택 
			 if(select == 1) {
				 users = createAccount();
				 Insert.insertUsers(users.getId(), users.getAge(), 0, 0);
			 }else if(select ==2) {
					System.out.println(" ");
					System.out.print(" 나이를 입력해 주세요");
					System.out.println(" ");
					System.out.print(" ▶ ");
					int memAge = scanner.nextInt();
					int bookAge = memAge/10 ;
					System.out.println(" ");
					System.out.println(" *회원에게 맞는 책을 추천합니다. *");
					System.out.println(" =================================================");
				 if (bookAge == 0) {
					 BkSeleck.selectBook(0);
				 }else if(bookAge == 1) {
					 BkSeleck.selectBook(1);
				 }else { 
					 BkSeleck.selectBook(2);
				 }
			 }else {
				 run = false;
			 }
			 }while (run);
				System.out.print("");
				System.out.println(" 프로그램 종료");
	}

	//  회원가입 선택
	    private static UserVo createAccount() {
		UserVo users = new UserVo();
		
		System.out.print(" 아이디를 입력하세요 : ");
		String id = scanner.next();
		System.out.println(" ");
		users.setId(id);
		System.out.println(users.getId());
		
		System.out.print(" \n나이를 입력하세요 : ");
		int age = scanner.nextInt();
		System.out.println(" ");
		users.setAge(age);
		System.out.println(users.getAge());
		
	
		System.out.println("");
		System.out.println(" >> 회원가입이 완료되었습니다.");
		System.out.print("");
		return users;
	}

	
}


		