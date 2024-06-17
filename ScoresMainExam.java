package ch06.ScoresBoard;

import java.util.Scanner;

public class ScoresMainExam {
	// 필드 ->멤버변수로 main에서 사용할 배열이나 객체 등을 생성
	private static Scanner input = new Scanner(System.in); // 공용스캐너
	private static Student[] st = new Student[5]; // Student 클래스 이용할 객체
	private static Teacher[] tc = new Teacher[3]; //Teacher 클래스 이용할 객체

	// 생성자-> main일 경우 new 사용하지 않음(정적 static으로 사용하지 않음)

	// 메서드
	public static void main(String[] args) {
		// 주실행 클래스 : 다른 클래스, 메서드 호출용

		boolean run = true;

		while (run) {
			System.out.println("============ 학생관리 프로그램 v2 =========");
			System.out.println("1. 학생관리 | 2. 성적입력 | 3. 통계 \n4. 종료 | 5. 교사등록 | 6. 교사검색");
			System.out.println("======================================");
			System.out.print(">>>");
			int selectNum = input.nextInt(); // 주메뉴 선택번호 받기

			switch (selectNum) {
			case 1:
				System.out.println("학생관리 클래스를 실행합니다.");
				boolean strun = true;
				while (strun) {
					System.out.println("=============== 1.학생관리 =============");
					System.out.println("1. 학생등록 | 2. 학생보기 | 3. 수정하기 \n4. 삭제하기 | 5. 종료");
					System.out.println("======================================");
					System.out.print(">>>");
					int selectNum2 = input.nextInt(); // 부메뉴 선택번호 받기
					switch (selectNum2) {
					case 1:
						System.out.println("학생등록을 시작합니다.");
						Student regStudent = new Student();// 객체생성
						System.out.println("이름 : ");
						regStudent.name = input.next();
						System.out.println("학번 : ");
						regStudent.studentNum = input.nextInt();
						System.out.println("학년 : ");
						regStudent.grade = input.nextInt();
						System.out.println("반 : ");
						regStudent.classRoom = input.nextInt();
						System.out.println("성별 : ");
						regStudent.sex = input.next(); // 입력받은 값을 객체의 멤버변수에 넣음

						for (int i = 0; i < st.length; i++) {// Student 배열 돌면서
							if (st[i] == null) {
								st[i] = regStudent; // 배열 빈칸이면 입력값 저장
								System.out.println(regStudent.name + " 학생이 등록되었습니다.");
								break; // 저장 후 for 반복 종료
							} // 1-1. if문 종료
						} // 1-1.for문 종료
						break;
					case 2:
						System.out.println("**전체학생 보기**");
						for (int i = 0; i < st.length; i++) { // 배열돌면서 출력
							if (st[i] != null) {
								System.out.println("----------------------------");
								System.out.printf("이름 : %s \t학번 : %d\n%d학년 %d반 \t성별 : %s\n", st[i].name,
										st[i].studentNum, st[i].grade, st[i].classRoom, st[i].sex);
							} // 1-2.if문 종료
						} // 1-2.for문 종료
							// Student findStudent = find(name);
						break;
					case 3:
						System.out.println("수정할 학생명을 입력하세요.");
						System.out.print(">>>");
						String searchName = input.next();
						Student findStudent = find(searchName);
						if (findStudent == null) {
							System.out.println("해당하는 학생이 존재하지 않습니다.");
						} else {
							System.out.println("수정할 정보를 선택하세요.-------");
							System.out.println("1. 학번 | 2. 학년 | 3. 반 | 4. 성별");
							System.out.print(">>>");
							int modifyData = input.nextInt();
							switch (modifyData) {
							case 1:
								System.out.println("수정할 학번을 입력하세요.");
								findStudent.studentNum = input.nextInt();
								System.out.println(
										findStudent.name + " 학생의 학번이 " + findStudent.studentNum + "으로 수정되었습니다.");
								break;
							case 2:
								System.out.println("수정할 학년을 입력하세요.");
								findStudent.grade = input.nextInt();
								System.out.println(findStudent.name + " 학생이 " + findStudent.grade + "학년으로 수정되었습니다.");
								break;
							case 3:
								System.out.println("수정할 반을 입력하세요.");
								findStudent.classRoom = input.nextInt();
								System.out.println(findStudent.name + " 학생이 " + findStudent.classRoom + "반으로 수정되었습니다.");
								break;
							case 4:
								System.out.println(findStudent.name + "의 성별은" + findStudent.sex + " 입니다. 수정하시겠습니까?");
								System.out.println("예:1 / 아니오:2 >>>");
								int yesNo = input.nextInt();
								if (yesNo == 1) {// 예를 선택시
									if (findStudent.sex.equals("남")) { // 남자면
										findStudent.sex = "여"; // 여자로 바꾸고
									} else {
										findStudent.sex = "남"; // 여자면 남자로 바꾸고
									}
								}
								System.out.println(findStudent.name + " 학생이 " + findStudent.sex + "으로 수정되었습니다.");
								break;
							default:
								System.out.println("잘못된 입력입니다. 1~4번까지만 입력해 주세요.");
							}// 1-3.switch문 종료
						} // if문 종료

						break;
					case 4:
						System.out.println("삭제할 학생명을 입력하세요.");
						System.out.print(">>>");
						String deleteName = input.next();
						Student deleteStudent = find(deleteName); // find()메서드로 학생 찾아옴
						if(deleteStudent==null) {
							System.out.println("해당하는 학생이 존재하지 않습니다.");
						}else {
							for(int i=0;i<st.length;i++) {
								if(st[i].name.equals(deleteStudent.name)) {//원래 배열과 찾은이름이 같다면
									st[i]=null;
									System.out.println("삭제완료!!");
									break;
								}
								
							}//for문 종료
						}//1-4.if문 종료

						break;
					case 5:
						System.out.println("학생관리 클래스를 종료합니다.");
						strun = false;
						break;
					default:
						System.out.println("잘못된 입력입니다. 1~5번까지만 입력해 주세요.");
					}// 1. 학생관리-부메뉴switch 종료

				} // 1. 학생관리메뉴 while문 종료

				break;
			case 2:
				System.out.println("성적입력 클래스를 실행합니다.");
				break;
			case 3:
				System.out.println("통계 클래스를 실행합니다.");
				break;
			case 4:
				System.out.println("학생관리 프로그램을 종료합니다. 안녕히 가세요.");
				run = false;
				break;
			case 5:
				System.out.println("교사등록을 시작합니다.");
				Teacher regTeacher = new Teacher(); //교수용 객체생성
				System.out.println("교사명 : ");
				regTeacher.teacherName = input.next(); //교수명 입력받기
				System.out.println("메일주소 : ");
				regTeacher.mailAddress = input.next(); 
				System.out.println("담당학년 : ");
				regTeacher.resGrade = input.nextInt();
				System.out.println("담당 반 : ");
				regTeacher.resClass = input.nextInt();
				System.out.println("담당과목 : ");
				regTeacher.resSubject=input.next();
				System.out.println("ID : ");
				regTeacher.teacherid=input.next();
				System.out.println("PW : ");
				regTeacher.teacherpw=input.next();
				
				for(int i=0;i<tc.length;i++) {//Teacher 배열 돌면서
					if(tc[i]==null) {
						tc[i]=regTeacher; //Teacher 빈 곳에 regTeacher(입력값) 넣기
						System.out.println(regTeacher.teacherName +"선생님이 등록되었습니다.");
						break;
					}else {
						System.out.println("등록할 공간이 없습니다. 담당자에게 문의하세요.");
					}
				}//for문 종료
				
				
				break;
			default:
				System.out.println("잘못된 입력입니다. 1~4번까지만 입력해 주세요.");
			}// 주메뉴-switch문 종료

		} // 1. 주메뉴 -while문 종료
		input.close();

		/* 메서드-이름검색 ->return은 Student 객체로 */

	} // main()종료

	private static Student find(String name) {
		Student student = null; // 빈객체 생성
		for (int i = 0; i < st.length; i++) {
			if (st[i] != null) {// 비어있지 않으면
				String arrayName = st[i].name; // 배열의 이름을 가져옴
				if (arrayName.equals(name)) {
					student = st[i];// 빈 객체에 검색한 객체 넣음
					break;
				} // if문 종료2
			} // if문 종료1
		} // for문 종료
		return student; // 리턴객체
	}// find()종료
}
