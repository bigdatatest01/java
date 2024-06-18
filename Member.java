package ch06.board;

import java.util.Scanner;

public class Member { // 회원에 대한 CRUD
	// 필드 ->멤버변수
	String id;
	String pw;
	String nickName;
	String email;

	// 생성자 -> new로 객체 생성시 사용(생략시 기본 생성자가 자동으로 만들어짐)
	// Member member = new Member();

	// 메서드 -> 동작(CRUD)
	public Member register(Scanner input) {
		// 새로운 Member 객체를 생성하여 키보드로 넣은 필드값을 삽입하고 객체로 리턴
		Member newMember = new Member();
		System.out.println("아이디를 입력하세요.");
		newMember.id = input.next();
		System.out.println("암호를 입력하세요.");
		newMember.pw = input.next();
		System.out.println("닉네임을 입력하세요.");
		newMember.nickName = input.next();
		System.out.println("이메일을 입력하세요.");
		newMember.email = input.next();

		return newMember;
	} // register() 종료

	public Member login(Scanner input, Member[] members) {// 매개값 : 키보드입력, 회원배열
		Member loginMember = new Member(); // 키보드로 입력한 객체 생성
		System.out.println("아이디를 입력하세요.");
		System.out.print(">>>");
		loginMember.id = input.next(); // 키보드로 입력받은 id를 새로 만든 객체에 넣음
		System.out.println("암호를 입력하세요.");
		System.out.print(">>>");
		loginMember.pw = input.next();// 키보드로 입력받은 pw를 새로 만든 객체에 넣음

		// 배열에 있는 객체와 새로만든 객체 비교 시작
		for (int i = 0; i < members.length; i++) {
			if (members[i] != null) {// 배열의 빈칸이 아니면
				if (members[i].id.equals(loginMember.id) && members[i].pw.equals(loginMember.pw)) {
					// 배열의 id와 키보드로 입력한 id가 같고 배열의 pw와 입력한 pw가 같다
					// loginMember는 2개의 값, members[i]는 4개의 값을 가지고 있다.
					loginMember = members[i];//교체					
				}//if문 종료(id,pw비교->객체 치환)
			} else {
				System.out.println("회원정보가 없습니다.");
				System.out.println("ID/PW를 확인하세요.");
				break;
			}// if문 종료
		} // for문 종료
		return loginMember;
	}

	public void modify() {
		System.out.println("회원정보 수정을 시작합니다.");
	}

	public void delete() {
		System.out.println("회원탈퇴를 시작합니다.");
	}

	public void menu(Scanner input, Member[] members) {// main()의 Scanner 받아오기
		System.out.println("------회원전용 메뉴입니다.-----");
		boolean run = true;
		while (run) {
			System.out.println("1. 회원가입 | 2. 로그인 | 3. 회원정보 수정 | 4. 회원탈퇴 | 5. 종료");
			System.out.print(">>>");
			int select = input.nextInt();

			switch (select) {
			case 1:
				System.out.println("회원가입을 진행합니다.");
				// 키보드로 입력받을 필드 완성 후 객체로 받음
				Member newMember = register(input); // main()의 scanner 전달
				// 멤버배열 null을 찾아 삽입
				for (int i = 0; i < members.length; i++) {
					if (members[i] == null) {
						members[i] = newMember;
						System.out.println(newMember.nickName + "객체가 배열에 저장됨");
						break; // for문이 끝나야 함
					}
				} // for문 종료(null 찾아 객체 삽입)
				break;
			case 2:
				System.out.println("로그인을 진행합니다.");
				Member loginMember = login(input, members); // 호출시 스캐너와 배열객체 전달
				System.out.println(loginMember.nickName+"님 환영합니다.");
				break;
			case 3:
				System.out.println("회원정보 수정을 진행합니다.");
				modify();
				break;
			case 4:
				System.out.println("회원탈퇴를 진행합니다.");
				delete();
				break;
			case 5:
				System.out.println("회원전용 메뉴를 종료합니다.");
				run = false;
				break;
			default:
				System.out.println("잘못된 입력입니다. 1~5값만 입력해 주세요.");
			}// switch문 종료
		} // while 종료
	}// 메뉴 메서드 종료

}
