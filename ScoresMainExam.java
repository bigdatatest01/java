package ch06.ScoresCard;

import java.util.Scanner;

public class ScoresMainExam {
	// 필드 ->멤버변수로 main에서 사용할 배열이나 객체 등을 생성
	private static Scanner input = new Scanner(System.in); // 현 class 내의 메서드에서 호출되어 사용함
	private static Student[] st = new Student[5]; // 학생객체용으로 5칸 배열 생성
	// String[] string = new String[5];

	// 생성자 -> main일 경우 new 사용하지 않음(정적 static으로 사용하지 않음)

	// 메서드
	public static void main(String[] args) {
		// 주실행 클래스로 메뉴와 클래스.메서드 호출용으로 작업
		// 객체 : 학생, 성적, 통계...
		boolean run = true; // 반복실행 시작

		while (run) {// 종료 run=false;
			System.out.println("=============학생관리 프로그램v2(객체)==============");
			System.out.println("1. 학생관리 | 2. 성적입력 | 3. 통계 | 4. 종료");
			System.out.println("=============================================");
			System.out.print(">>>");
			int select = input.nextInt(); // 객체사용 전에 private static 확인

			switch (select) {
			case 1:
				System.out.println("학생관리 클래스로 진입합니다.");
				boolean strun = true;
				while (strun) {
					System.out.println("1. 학생등록 | 2. 학생보기 | 3. 학생수정 | 4. 학생삭제 | 5. 메인메뉴 ");
					System.out.print(">>>");
					int stSelect = input.nextInt();

					switch (stSelect) {
					case 1:
						System.out.println("학생등록 메뉴입니다.");
						Student regStudent = new Student(); // 객체생성
						System.out.println("이름 : ");
						regStudent.name = input.next(); // 키보드로 받은 이름
						System.out.println("학번 : ");
						regStudent.num = input.nextInt(); // 키보드로 받은 학번
						System.out.println("성별 : ");
						regStudent.sex = input.next(); // 키보드로 받은 성별
						System.out.println("학년 : ");
						regStudent.grade = input.nextInt(); // 키보드로 받은 학년
						System.out.println("반 : ");
						regStudent.classroom = input.nextInt(); // 키보드로 받은 반
						System.out.println("---객체생성->입력완료---");
						System.out.println("--배열 빈칸을 찾아 저장--");

						for (int i = 0; i < st.length; i++) {
							if (st[i] == null) { // st 배열에 빈칸인지 찾음
								st[i] = regStudent; // 위에서 만든 객체를 넣음
								System.out.println("저장성공!!!");
								break; // 저장후 종료
							} // end of if()
						} // end of for(null을 찾음)
						break; // 학생등록용 정지
					case 2:
						System.out.println("전체학생보기");

						for (int i = 0; i < st.length; i++) {
							if (st[i] != null) { // st배열 칸이 null이 아니면
								System.out.println("-------------------------");
								System.out.println("이름 : " + st[i].name);
								System.out.println("학번 : " + st[i].num);
								System.out.println("성별 : " + st[i].sex);
								System.out.println("학년 : " + st[i].grade);
								System.out.println("반 : " + st[i].classroom);
							} // if문 종료
						} // end of for(st배열 전체 반복종료)
						break; // 학생보기 정지
					case 3:
						System.out.println("수정할 학생명을 입력하세요.");
						System.out.print(">>>");
						String searchName = input.next();
						Student findStudent = find(searchName); // 아래 만든 메서드로 찾아옴
						if (findStudent == null) {
							System.out.println("해당하는 학생이 존재하지 않습니다.");
						} else {// 찾은학생이 있으면
							System.out.println("수정할 학생 번호를 입력하세요.");
							findStudent.num = input.nextInt();
							System.out.println("학생정보 수정완료");
						}
						break;
					case 4:
						System.out.println("삭제할 학생명을 입력하세요.");
						System.out.print(">>>");
						String deleteName = input.next();
						Student deleteStudent = find(deleteName); // 아래 만든 메서드가 객체를 찾아옴
						if (deleteStudent == null) {
							System.out.println("삭제할 학생이 존재하지 않습니다.");
						} else {// 삭제할 학생이 있으면
							for (int i = 0; i < st.length; i++) {
								//System.out.println(st[i].name);
								//System.out.println(deleteStudent.name);
								if (st[i].name.equals(deleteStudent.name)) { // 배열과 찾은이름 비교
									st[i] = null; // 삭제
									System.out.println("삭제완료!!");
									break;
								}
							} // for문 종료

						} // if문 종료
						break;
					case 5:
						System.out.println("메인메뉴로 복귀합니다.");
						strun = false;
					default:
						System.out.println("1~4번까지 입력해 주세요.");
					}// end of switch
				} // end of while
				break;
			case 2:
				System.out.println("성적입력 클래스로 진입합니다.");
				break;
			case 3:
				System.out.println("통계 클래스로 진입합니다.");
				break;
			case 4:
				System.out.println("학생관리 프로그램을 종료합니다.");
				run = false;
				break;
			default:
				System.out.println("1~4번 값만 입력하세요.");
				// break문을 작성하면 꺼짐
			}// end of switch(주메뉴용)
		} // end of while

	} // end of main()

	private static Student find(String name) {
		// 이름으로 객체를 찾아오는 메서드 ->리턴은 Student 객체
		Student student = null;// 빈객체 생성
		for (int i = 0; i < st.length; i++) {
			if (st[i] != null) {
				String arrayName = st[i].name; // 배열에 있는 이름을 가져옴
				if (arrayName.equals(name)) { // 배열 name과 키보드 name 비교
					student = st[i]; // 찾은 객체를 빈 객체에 넣음
					break;
				}
			} // if문 종료
		} // for문 종료

		return student; // 리턴 객체
	}// find 메서드 종료

} // end of class
