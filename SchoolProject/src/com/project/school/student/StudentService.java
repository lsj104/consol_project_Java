package com.project.school.student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import com.project.school.data.Data;
import com.project.school.score.ScoreService;
import com.project.school.teacher.Teacher;

public class StudentService {

    // 시작 메소드
    public void begin(String studentID) {

        Student s = new Student();

        s = Data.getStudent(studentID);

        boolean loop = true;

        Scanner scan = new Scanner(System.in);

        while (loop) {


            System.out.println();
            System.out.println(" ■■■■■■  ■■■■■■■■ ■■     ■■ ■■■■■■■■  ■■■■■■■■ ■■    ■■ ■■■■■■■■ \r\n"
                    + "■■    ■■    ■■    ■■     ■■ ■■     ■■ ■■       ■■■   ■■    ■■    \r\n"
                    + "■■          ■■    ■■     ■■ ■■     ■■ ■■       ■■■■  ■■    ■■    \r\n"
                    + " ■■■■■■     ■■    ■■     ■■ ■■     ■■ ■■■■■■   ■■ ■■ ■■    ■■    \r\n"
                    + "      ■■    ■■    ■■     ■■ ■■     ■■ ■■       ■■  ■■■■    ■■    \r\n"
                    + "■■    ■■    ■■    ■■     ■■ ■■     ■■ ■■       ■■   ■■■    ■■    \r\n"
                    + " ■■■■■■     ■■     ■■■■■■■  ■■■■■■■■  ■■■■■■■■ ■■    ■■    ■■");
            System.out.println("=================================================================");
            System.out.printf("                                    [%d학년 %d반 %d번 %s님 안녕하세요!]\n", s.getGrade(), s.getClassNo(), s.getNumber(), s.getName());
            System.out.println("[1] 정보 조회");
            System.out.println("[2] 개인 성적 조회");
            System.out.println("[3] 교사 수업 평가");
            System.out.println("[4] 학급 게시판");
            System.out.println("[5] 코로나 병결 신청");
            System.out.println("[6] 상위 메뉴");
            System.out.println("=================================================================");
            System.out.print("선택: ");

            String sel = scan.nextLine();

            if (sel.equals("1")) {

                //1. 정보 조회
                info();

            } else if (sel.equals("2")) {

                //2. 개인 성적 조회

                scoreCheck(s.getId());

            } else if (sel.equals("3")) {

                //3. 교사 수업 평가
                try {
                    evaluation();
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            } else if (sel.equals("4")) {

                //4. 학급 게시판
                board(s.getGrade(), s.getClassNo(), s.getName());

            } else if (sel.equals("5")) {

                //5. 코로나 병결 신청
                try {
                    covidCheck(studentID);
                } catch (Exception e) {

                    e.printStackTrace();
                }

            } else if (sel.equals("6")) {

                //6. 상위 메뉴
                loop = false;

            } else {

                System.out.println("잘못된 입력입니다.");

            }//if
        }//while

    }//begin

    private void board(int grade, int classNo, String name) {

        System.out.println();

        StudentNoticeBoard notice = new StudentNoticeBoard();

        boolean loop = true;

        Scanner scan = new Scanner(System.in);
        String sel = "";


        while (loop) {

            System.out.println("           [학급 게시판]");
            System.out.println("===============================");
            System.out.println("[1] 공지사항 조회");
            System.out.println("[2] 한줄게시판 작성");
            System.out.println("[3] 학급 시간표 열람");
            System.out.println("[4] 상위 메뉴");
            System.out.println("===============================");
            System.out.print("선택: ");

            sel = scan.nextLine();

            if (sel.equals("1")) {

                // 1. 학급 게시판 관리
                notice.teacherNotice(grade, classNo);

            } else if (sel.equals("2")) {

                // 2.학급 구성원 조회
                notice.lineBoard(grade, classNo, name);

            } else if (sel.equals("3")) {

                // 3. 학급 시간표 열람
                try {

                    String path = String.format(
                            "./dat/%d[학년]/%d-%d[반]/%d-%d[반] 학급시간표.txt",
                            grade, grade, classNo, grade, classNo);

                    BufferedReader reader = new BufferedReader(new FileReader(path));

                    String line = null;

                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }

                    reader.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {

                // 3.상위 메뉴
                loop = false;

            } // if

        } // while

    }

    private static void evaluation() throws Exception {

        int answer1 = 0;
        int answer2 = 0;
        int answer3 = 0;
        int answer4 = 0;
        int answer5 = 0;
        boolean loop = true;

        while (loop) {
            Scanner scan = new Scanner(System.in);
            System.out.println();
            System.out.println("                              [수업 평가]");
            System.out.println("======================================================================");
            System.out.println();

            for (; ; ) {
                System.out.println("1. 선생님은 학습내용을 이해할 수 있도록 여러 가지 학습 자료를 사용하십니다.");
                System.out.println("(5) 매우 그렇다, (4) 그렇다, (3) 보통이다, (2) 그렇지 않다, (1) 매우 그렇지 않다");
                System.out.print("입력: ");
                answer1 = scan.nextInt();
                scan.nextLine();
                if (answer1 <= 5 && answer1 >= 1) {
                    break;
                } else {
                    System.out.println("1~5사이의 숫자를 입력하십시오.");
                    System.out.println();
                }
            }

            for (; ; ) {
                System.out.println("2. 선생님은 수업에 우리가 자유롭게 의견을 말할 수 있는 분위기를 만들어 주십니다.");
                System.out.println("(5) 매우 그렇다, (4) 그렇다, (3) 보통이다, (2) 그렇지 않다, (1) 매우 그렇지 않다");
                System.out.print("입력: ");
                answer2 = scan.nextInt();
                scan.nextLine();
                if (answer2 <= 5 && answer2 >= 1) {
                    break;
                } else {
                    System.out.println("1~5사이의 숫자를 입력하십시오.");
                    System.out.println();
                }
            }

            for (; ; ) {
                System.out.println("3. 선생님은 우리 수준에 맞는 문제를 출제하십니다.");
                System.out.println("(5) 매우 그렇다, (4) 그렇다, (3) 보통이다, (2) 그렇지 않다, (1) 매우 그렇지 않다");
                System.out.print("입력: ");
                answer3 = scan.nextInt();
                scan.nextLine();
                if (answer3 <= 5 && answer3 >= 1) {
                    break;
                } else {
                    System.out.println("1~5사이의 숫자를 입력하십시오.");
                    System.out.println();
                }
            }

            for (; ; ) {
                System.out.println("4. 선생님은 우리에게 관심을 갖고 바르게 생활할 수 있도록 도와주십니다.");
                System.out.println("(5) 매우 그렇다, (4) 그렇다, (3) 보통이다, (2) 그렇지 않다, (1) 매우 그렇지 않다");
                System.out.print("입력: ");
                answer4 = scan.nextInt();
                scan.nextLine();
                if (answer4 <= 5 && answer4 >= 1) {
                    break;
                } else {
                    System.out.println("1~5사이의 숫자를 입력하십시오.");
                    System.out.println();
                }
            }

            for (; ; ) {
                System.out.println("5. 선생님은 우리가 친구들과 잘 어울리며 즐겁게 학교생활을 할 수 있도록 도와주십니다.");
                System.out.println("(5) 매우 그렇다, (4) 그렇다, (3) 보통이다, (2) 그렇지 않다, (1) 매우 그렇지 않다");
                System.out.print("입력: ");
                answer5 = scan.nextInt();
                scan.nextLine();
                if (answer5 <= 5 && answer5 >= 1) {
                    break;
                } else {
                    System.out.println("1~5사이의 숫자를 입력하십시오.");
                    System.out.println();
                }
            }

            loop = false;

        }

        int sum = answer1 + answer2 + answer3 + answer4 + answer5;
        System.out.println();

        System.out.println("총점:" + sum * 4);
        System.out.println();
        System.out.println("======================================================================");

        System.out.println("                           [평가가 완료되었습니다.]");

        FileWriter fileWriter = new FileWriter("./dat/evaluation.txt", true);
        fileWriter.write(sum + "\r\n");
        fileWriter.close();
        Data.pause();


    }//evaluation


    private static void covidCheck(String studentId) throws Exception {

        boolean loop = true;

        Scanner scan = new Scanner(System.in);


        while (loop) {

            System.out.println("          [코로나 병결 신청]");
            System.out.println("==================================");
            System.out.println("[1] 코로나 확진 ");
            System.out.println("[2] 코로나 의심 ");
            System.out.println("[3] 상위 메뉴");
            System.out.println("==================================");
            System.out.print("선택: ");

            String sel = scan.nextLine();

            for (; ; ) {

                if (sel.equals("1")) {

                    confirm(studentId);
                    break;

                } else if (sel.equals("2")) {

                    doubt(studentId);
                    break;

                } else if (sel.equals("3")) {

                    loop = false;
                    break;

                } else {
                    System.out.println("잘못된 입력입니다. 1~3까지의 값을 입력하십시오.");
                    break;

                }
            }
        }

    }

    private void scoreCheck(String id) {

        ScoreService.view(id);

    }

    private void info() {

        boolean loop = true;

        Scanner scan = new Scanner(System.in);

        while (loop) {

            System.out.println();
            System.out.println("              [정보 조회]");
            System.out.println("======================================");
            System.out.println("[1] 학생 정보 조회");
            System.out.println("[2] 교사 정보 조회");
            System.out.println("[3] 상위 메뉴");
            System.out.println("======================================");
            System.out.print("선택: ");

            String sel = scan.nextLine();

            if (sel.equals("1")) {
                //1. 학생 정보 조회
                studentInfo();
            } else if (sel.equals("2")) {
                //2. 교사 정보 조회
                teacherInfo();
            } else if (sel.equals("3")) {
                //3. 상위 메뉴
                loop = false;
            } else {

                System.out.println("잘못된 입력입니다.");
                info();

            }

        }//while


    }//info

    private void teacherInfo() {

        Scanner scan = new Scanner(System.in);


        System.out.println();
        System.out.println("       [교사 정보 조회]");
        System.out.println("==========================");
        System.out.print("이름 입력: ");
        String word = scan.nextLine();
        System.out.println();

        ArrayList<Teacher> tlist = Data.searchTecher(word);


        if (tlist.size() != 0) {

            System.out.println("[이름]    [담당과목]    [직급]");

            tlist.stream().forEach(t -> System.out.printf("%3s    %5s      %3s\n"
                    , t.getName()
                    , t.getSubject()
                    , t.getPosition()));

            System.out.println();
            System.out.println("==========================");

        } else {
            System.out.println("검색한 이름의 선생님이 없습니다.");
        }

        Data.pause();


    }

    private void studentInfo() {

        System.out.println();

        Scanner scan = new Scanner(System.in);


        System.out.println("          [학생 정보 조회]");
        System.out.println("================================");
        System.out.print("이름 입력: ");

        String word = scan.nextLine();
        System.out.println();

        ArrayList<Student> slist = Data.searchStudent(word);

        if (slist.size() != 0) {

            System.out.println("[학년]    [반]    [번호]    [이름]");

            slist.stream().forEach(s -> System.out.printf("%3d     %3d     %3d      %3s\n"
                    , s.getGrade()
                    , s.getClassNo()
                    , s.getNumber()
                    , s.getName()));

            System.out.println();
            System.out.println("================================");

        } else {
            System.out.println("검색한 이름의 학생이 없습니다.");
        }
        Data.pause();

    }

    private static void doubt(String studentId) throws Exception {

        Student s = new Student();
        s = Data.getStudent(studentId);

        Boolean loop = true;
        System.out.println();
        while (loop) {

            Scanner scan = new Scanner(System.in);

            String sel = null;
            double heat = 0.0;

            System.out.println("========================================");
            System.out.println("           [코로나 의심 병결 신청]");
            System.out.println("========================================");
            System.out.print("1.증상 : ");
            String symptom = scan.nextLine();

            for (; ; ) {

                System.out.print("2.체온(35.0~42.0사이를 입력하시오.) : ");
                heat = scan.nextDouble();
                if (heat < 35.0 || heat > 42.0) {
                    System.out.println("올바른 체온을 입력하십시오.");
                    Data.restart();
                } else {
                    break;
                }
            }

            for (; ; ) {
                System.out.print("3.수업 참여 방식(1.실시간, 2:대면): ");
                int select = scan.nextInt();
                scan.nextLine();

                if (select == 1) {
                    sel = "실시간 강의";
                    loop = false;
                    break;
                } else if (select == 2) {
                    sel = "대면 강의";
                    loop = false;
                    break;
                } else {
                    System.out.println("실시간 강의, 영상 강의에 맞는 숫자(1 or 2)를 입력하십시오.");
                    Data.restart();
                }
            }

            System.out.println("========================================");
            System.out.println("입력이 완료됐습니다.");
            Data.pause();


            String path = String.format("./dat/%d[학년]/%d-%d[반]/%d학년_%d반_의심자명단.txt",
                    s.getGrade(), s.getGrade(), s.getClassNo(), s.getGrade(), s.getClassNo());
            FileWriter fileWriter = new FileWriter(path, true);
            fileWriter.write(s.getNumber() + "," + s.getName() + "," + symptom + "," + heat + "," + sel + "\r\n");
            fileWriter.close();


            loop = false;
        }

    }

    private static void confirm(String studentId) throws Exception {

        Student s = new Student();
        s = Data.getStudent(studentId);

        Boolean loop = true;
        Calendar con = Calendar.getInstance();
        String sel = null;
        Calendar isol = Calendar.getInstance();


        while (loop) {


            Scanner scan = new Scanner(System.in);

            int month = 0;
            int date = 0;

            System.out.println("========================================");
            System.out.println("           [코로나 확진 병결 신청]");
            System.out.println("========================================");

            for (; ; ) {

                System.out.print("1.확진 월(mm): ");
                month = scan.nextInt();

                if (month < 1 || month > 12) {
                    System.out.println("1~12 사이의 값을 입력하십시오.");
                    Data.restart();
                } else {
                    break;
                }
            }

            for (; ; ) {

                System.out.print("2.확진 일(dd): ");
                date = scan.nextInt();

                if (date < 1 || date > 31) {
                    System.out.println("1~31 사이의 값을 입력하십시오.");
                    Data.restart();
                } else {
                    break;
                }
            }


            for (; ; ) {

                System.out.print("3.수업 참여 방식(1.실시간, 2:영상): ");
                int select = scan.nextInt();
                scan.nextLine();

                if (select == 1) {
                    sel = "실시간 강의";
                    con.set(Calendar.MONTH, month - 1);
                    con.set(Calendar.DATE, date);
                    isol.set(Calendar.DATE, date + 7);
                    loop = false;
                    break;
                } else if (select == 2) {
                    sel = "영상 강의";
                    con.set(Calendar.MONTH, month - 1);
                    con.set(Calendar.DATE, date);
                    isol.set(Calendar.DATE, date + 7);
                    loop = false;
                    break;
                } else {
                    System.out.println("실시간 강의, 영상 강의에 맞는 숫자(1 or 2)를 입력하십시오.");
                    Data.restart();
                }
            }

        }

        System.out.println("========================================");
        System.out.println("입력이 완료됐습니다.");
        Data.pause();

        String path = String.format("./dat/%d[학년]/%d-%d[반]/%d학년_%d반_확진자명단.txt",
                s.getGrade(), s.getGrade(), s.getClassNo(), s.getGrade(), s.getClassNo());
        FileWriter fileWriter = new FileWriter(path, true);
        fileWriter.write(s.getNumber() + "," + s.getName() + "," +
                con.get(Calendar.YEAR) + "-" + (con.get(Calendar.MONTH) + 1) + "-" + con.get(Calendar.DATE) + "," +
                isol.get(Calendar.YEAR) + "-" + (isol.get(Calendar.MONTH) + 1) + "-" + isol.get(Calendar.DATE) +
                "," + sel + "\r\n");
        fileWriter.close();


    }


}