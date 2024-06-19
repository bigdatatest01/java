package ch06.board;

import java.util.Scanner;

public class BoardExam {
	public static Scanner input = new Scanner(System.in);
	public static Member[] members = new Member[100];
	public static Board[] boards = new Board[1000];
	//public static LoginMember nowMember = new LoginMember;
	//public static Common[] controller = new Commom[1000];

	public static void main(String[] args) {
		// 게시판을 구현해보자.
		// 객체는 2개(Member, Board)
		// 회원제용 게시판 구현용
mainMenu();
		
	}// main()메서드 종료
public static void mainMenu(){ //main메뉴(intro)
}
	System.out.println("========= 회원제 게시판 ========");
		boolean run = true;
		while (run) {
			System.out.println("1.회원가입 | 2.로그인 | 3.게시판 | 4.마이페이지 | 5.종료 ");
			System.out.print(">>>");
			int select = input.nextInt();

			switch (select) {
			case 1:
				System.out.println("회원관리 클래스로 진입합니다.");
				Member member = new Member(); //빈 객체 생성
				member.register(input, members);		
				break;
			case 2:
				System.out.println("로그인 클래스로 진입합니다.");
				break;
				case 3:
				System.out.println("게시판 관리 클래스로 진입합니다.");
				break;
					case 4:
				System.out.println("게시판 관리 클래스로 진입합니다.");
				break;
			case 5:
				System.out.println("종료합니다.");
				run = false;
				break;
			default:
				System.out.println("잘못된 입력입니다. 1~3값만 입력해 주세요.");
			}// switch문 종료
		} // while 종료
		input.close();
	public static void memberMenu(){ //회원관련 메뉴
}
public static void boardMenu(){ //게시판관련 메뉴
}
} // class 종료
