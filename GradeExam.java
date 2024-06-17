package ch05;

import java.util.Scanner;

public class GradeExam {
	// 학생이름 테이블 -> String[]
	// 점수 테이블 -> byte[]
	// 총점 테이블 -> int[]
	// 평균 테이블 -> double[]

	public static void main(String[] args) {
		// 주메뉴 구현용

		Scanner mainSC = new Scanner(System.in);
		System.out.println("초기작업 : 학생수를 입력하세요.");
		int count = mainSC.nextInt(); // 학생수 등록
		String[] name = new String[count];
		byte[] engScores = new byte[count];
		byte[] korScores = new byte[count];
		int[] totalScores = new int[count];
		double[] avgScores = new double[count];
		boolean run = true;

		while (run) {
			System.out.println("========= MBC 교육센터 성적관리 프로그램 ======");
			System.out.println("1. 학생관리 | 2. 성적관리 | 3. 통계관리 | 4. 종료");
			System.out.println("=======================================");
			System.out.print(">>>");
			int select = mainSC.nextInt(); // 1~4까지 정수 입력 후 분기

			switch (select) {
			case 1:
				System.out.println("학생관리 메서드로 진입합니다.");
				student(name);
				break;
			case 2:
				System.out.println("성적관리 메서드로 진입합니다.");
				scores(engScores, korScores, name);
				break;
			case 3:
				System.out.println("통계관리 메서드로 진입합니다.");
				analysis(engScores, korScores, name, count);
				break;
			case 4:
				System.out.println("종료합니다.");
				run = false;
				break;
			default:
				System.out.println("잘못된 입력입니다.");
				break;
			} // // main() 스위치문 종료
		} // main()while 종료

		mainSC.close();
	} // main()종료

	/* 1. 학생관리 */
	public static String[] student(String[] name) {
		// 학생관리용 CRUD
		Scanner studentSC = new Scanner(System.in);
		boolean run = true;
		while (run) {
			System.out.println("=============== 학생관리 =============");
			System.out.println("1. 입력 | 2. 보기 | 3. 수정 | 4. 삭제 | 5. 종료");
			System.out.println("===================================");
			System.out.print(">>>");
			int select = studentSC.nextInt(); // 1~4까지 정수 입력 후 분기

			switch (select) {
			case 1:
				System.out.println("학생명 입력을 시작합니다.");
				for (int i = 0; i < name.length; i++) {
					System.out.println((i + 1) + " 번째 학생명을 입력하세요.");
					System.out.print(">>>");
					name[i] = studentSC.next();
				}
				break;
			case 2:
				System.out.println("입력된 학생명은 아래와 같습니다.");
				for (int i = 0; i < name.length; i++) {
					System.out.println((i + 1) + " 번 : " + name[i]);
				}
				break;
			case 3:
				System.out.println("수정할 학생번호를 입력하세요.");
				System.out.print(">>>");
				int numMOD = studentSC.nextInt(); // 수정번호 받기
				System.out.println("수정할 이름을 입력하세요.");
				System.out.print(">>>");
				String nameMOD = studentSC.next(); // 수정이름 받기
				name[numMOD - 1] = nameMOD;
				System.out.println(numMOD + " 번 학생의 이름이 " + nameMOD + "로 변경되었습니다.");
				break;
			case 4:
				System.out.println("수정할 학생번호를 입력하세요.");
				System.out.print(">>>");
				int deleteNum = studentSC.nextInt(); // 삭제번호 받기
				name[deleteNum - 1] = null;
				System.out.println(deleteNum + "번 학생의 이름이 삭제되었습니다.");
				break;
			case 5:
				run = false;
				break;
			default:
				System.out.println("잘못된 입력입니다. 1~5번만 입력하세요.");
				break;
			} // student() switch문 종료

		} // student() while문 종료

		studentSC.close();
		return name;
	} // student() 종료

	/* 2. 성적관리 */
	public static void scores(byte[] engScores, byte[] korScores, String[] name) {
		// 성적관리 CRUD - 국어, 영어(과목선택) 성적 입력/보기/수정/삭제
		// 1. 선택된 과목별 배열받기
		// 2. 점수입력
		// 3. 입력점수 보기
		// 4. 수정 5. 삭제
		Scanner scoresSC = new Scanner(System.in);

		boolean run = true;
		while (run) { // 보조메뉴 반복돌리기
			System.out.println("============= 성적관리 메뉴 ============");
			System.out.println("1. 입력 | 2. 보기 | 3. 수정 ");
			System.out.println("====================================");
			System.out.print(">>>");
			int select = scoresSC.nextInt(); // 선택 번호 받기(int)

			switch (select) {
			case 1: // 과목선택 후 성적입력 완료
				getScores(engScores, korScores, name);
				break;
			case 2: // (과목별)성적보기
				viewScores(engScores, korScores, name);
				break;
			case 3: // 수정하기
				modifyScores(engScores, korScores, name);
				break;
			default:
				System.out.println("잘못된 입력입니다. 1~3번 중 입력해 주세요.");
				break;

			} // scores()switch문 종료
			System.out.println("상위메뉴 돌아가기:1 / 다른 과목 확인 :2");
			int selectNum = scoresSC.nextInt(); // 선택번호 받기
			switch (selectNum) {
			case 1:
				run = false;
				break;
			case 2:
				continue;
			default:
				System.out.println("잘못된 입력입니다. 1~2번 중 입력해 주세요.");
				break;
			} // 입력확인 switch문 종료

			scoresSC.close();

		} // scores() while문 종료

	} // scores() 종료

	/* 2-3. 성적수정 */
	public static void modifyScores(byte[] engScores, byte[] korScores, String[] name) {
		// 입력한 성적의 수정
		Scanner modifyScoresSC = new Scanner(System.in);
		boolean run = true;
		while (run) {
			System.out.println("수정할 과목의 번호를 입력하세요.");
			System.out.println("국어 : 1 / 영어 : 2");
			System.out.print(">>>");
			int subjectNum = modifyScoresSC.nextInt(); // 과목선택번호 받기
			int studentNum = 0; // 수정용 학생번호
			byte scoreMOD = 0; // 수정용 점수
			switch (subjectNum) {
			case 1:
				System.out.println("국어과목의 성적을 수정합니다.");
				System.out.println("수정할 학생의 번호를 입력하세요.");
				System.out.print(">>>");
				studentNum = modifyScoresSC.nextInt(); // 학생번호 받기
				System.out.println(studentNum + "." + name[studentNum - 1] + ": " + korScores[studentNum - 1]);
				System.out.println("수정할 점수를 입력하세요.");
				System.out.print(">>>");
				scoreMOD = modifyScoresSC.nextByte(); // 수정점수 받기
				korScores[studentNum - 1] = modifyScoresSC.nextByte(); // byte로 점수받아 배열에 넣기
				System.out.println(name[studentNum - 1] + "의 국어 점수를 " + scoreMOD + "점으로 수정했습니다.");
				break;
			case 2:
				System.out.println("영어과목의 성적을 수정합니다.");
				System.out.println("수정할 학생의 번호를 입력하세요.");
				System.out.print(">>>");
				studentNum = modifyScoresSC.nextInt(); // 학생번호 받기
				System.out.println(studentNum + "." + name[studentNum - 1] + ": " + engScores[studentNum - 1]);
				System.out.println("수정할 점수를 입력하세요.");
				System.out.print(">>>");
				scoreMOD = modifyScoresSC.nextByte(); // 수정점수 받기
				engScores[studentNum - 1] = modifyScoresSC.nextByte(); // byte로 점수받아 배열에 넣기
				System.out.println(name[studentNum - 1] + "의 영어 점수를 " + scoreMOD + "점으로 수정했습니다.");
				break;
			default:
				System.out.println("잘못된 입력입니다. 1~2번 중 입력해 주세요.");
				break;
			}// subjectNum 선택 switch문 종료
			System.out.println("상위메뉴 돌아가기:1 / 다른 과목 확인 :2");
			int selectNum = modifyScoresSC.nextInt(); // 선택번호 받기
			switch (selectNum) {
			case 1:
				run = false;
				break;
			case 2:
				continue;
			default:
				System.out.println("잘못된 입력입니다. 1~2번 중 입력해 주세요.");
				break;
			} // 입력확인 switch문 종료
			modifyScoresSC.close();
		} // while문 종료

	}

	/* 2-2. 성적보기 */
	public static void viewScores(byte[] engScores, byte[] korScores, String[] name) {
		// 과목별 성적 확인
		Scanner viewScoresSC = new Scanner(System.in);
		boolean run = true;
		while (run) {
			System.out.println("확인할 과목의 번호를 입력하세요.");
			System.out.println("국어 : 1 / 영어 : 2");
			System.out.print(">>>");
			int subjectNum = viewScoresSC.nextInt(); // 과목선택번호 받기

			switch (subjectNum) {
			case 1:
				System.out.println("국어과목의 성적입니다.");
				for (int i = 0; i < korScores.length; i++) {
					System.out.println((i + 1) + "." + name[i] + ": " + korScores[i]);
				}
				break;
			case 2:
				System.out.println("영어과목의 성적입니다.");
				for (int i = 0; i < engScores.length; i++) {
					System.out.println((i + 1) + "." + name[i] + ": " + engScores[i]);
				}
				break;
			default:
				System.out.println("잘못된 입력입니다. 1~2번 중 입력해 주세요.");
				break;
			}// subjectNum 선택 switch문 종료
			System.out.println("상위메뉴 돌아가기:1 / 다른 과목 확인 :2");
			int selectNum = viewScoresSC.nextInt(); // 선택번호 받기
			switch (selectNum) {
			case 1:
				run = false;
				break;
			case 2:
				continue;
			default:
				System.out.println("잘못된 입력입니다. 1~2번 중 입력해 주세요.");
				break;
			} // 입력확인 switch문 종료

		} // viewScores() while문 종료

		viewScoresSC.close();

	}

	/* 2-1. 성적입력 */
	public static void getScores(byte[] engScores, byte[] korScores, String[] name) {
		// 과목선택 후 입력, 입력한 성적표 리턴
		Scanner getScoresSC = new Scanner(System.in);
		boolean run = true;
		while (run) {
			System.out.println("과목의 번호를 입력하세요.");
			System.out.println("국어 : 1 / 영어 : 2");
			System.out.print(">>>");
			int subjectNum = getScoresSC.nextInt(); // 과목선택번호 받기

			switch (subjectNum) {
			case 1:
				System.out.println("국어과목의 성적을 입력합니다.");
				for (int i = 0; i < name.length; i++) {
					System.out.println((i + 1) + "번째 학생의 점수 : ");
					korScores[i] = getScoresSC.nextByte(); // byte로 점수받아 배열에 넣기
				}
				break;
			case 2:
				System.out.println("영어과목의 성적을 입력합니다.");
				for (int i = 0; i < name.length; i++) {
					System.out.println((i + 1) + "번째 학생의 점수 : ");
					engScores[i] = getScoresSC.nextByte(); // byte로 점수받아 배열에 넣기
				}
				break;
			default:
				System.out.println("잘못된 입력입니다. 1~2번 중 입력해 주세요.");
				break;
			}// subjectNum 선택 switch문 종료
			System.out.println("입력을 종료하시겠습니까?");
			System.out.println("입력종료:1 / 다른 과목 입력 :2");
			int selectNum = getScoresSC.nextInt(); // 선택번호 받기
			switch (selectNum) {
			case 1:
				run = false;
				break;
			case 2:
				continue;
			default:
				System.out.println("잘못된 입력입니다. 1~2번 중 입력해 주세요.");
				break;
			} // 입력확인 switch문 종료

		} // getScores() switch문 종료
		getScoresSC.close();
	} // getScores() while문 종료

	/* 3. 통계관리 */
	public static void analysis(byte[] engScores, byte[] korScores, String[] name, int count) {
		// 통계관리 menu
		Scanner analysisSC = new Scanner(System.in);
		boolean run = true;
		int perfectScore = 0; // 만점(학생수*과목수*100)
		int subjectCount = 2; // 과목수(**추후 과목 입력 시 변경될 수 있도록 수정)
		int korTotal = 0;
		int engTotal = 0;

		while (run) {
			System.out.println("============= 통계관리 메뉴 ============");
			System.out.println("1. 전체 성적 보기 | 2. 개인별 성적 보기");
			System.out.println("====================================");
			System.out.print(">>>");
			int select = analysisSC.nextInt(); // 선택 번호 받기(int)

			switch (select) {
			case 1:
				perfectScore = count * subjectCount * 100; // 만점(학생수*과목수*100)
				for (int i = 0; i <= korScores.length; i++) {
					korTotal += korScores[i];
				} // 국어총점 for문 종료
				for (int i = 0; i <= engScores.length; i++) {
					engTotal += engScores[i];
				} // 영어총점 for문 종료
				System.out.println("1. 과목전체 결과-------");
				System.out.println("전과목 총점 : " + (korTotal + engTotal) + "/" + perfectScore);
				System.out.println("전과목 평균 : " + (double) (korTotal + engTotal) / (count * subjectCount));
				System.out.println("2. 국어과목 결과-------");
				System.out.println("국어 총점 : " + korTotal + "/" + (perfectScore / subjectCount));
				System.out.println("국어 평균 : " + (double) korTotal / count);
				System.out.println("국어 최고점수 : " + korTotal / count);// -->수정
				System.out.println("국어 최저점수 : " + korTotal / count);// -->수정
				System.out.println("3. 영어과목 결과-------");
				System.out.println("영어 총점 : " + engTotal + "/" + (perfectScore / subjectCount));
				System.out.println("영어 평균 : " + (double) engTotal / count);
				System.out.println("영어 최고점수 : " + korTotal / count);// -->수정
				System.out.println("영어 최저점수 : " + korTotal / count);// -->수정
				break;
			case 2:
				System.out.println("학생의 이름을 입력하세요.>>>");
					String selname = analysisSC.next(); //입력된 학생이름 검색(키보드 입력)
					
					
					
				
			default:
				System.out.println("잘못된 입력입니다. 1~2번 중 입력해 주세요.");
				break;
			}

			analysisSC.close();
		} // while문 종료

	}

	

} // class 종료
