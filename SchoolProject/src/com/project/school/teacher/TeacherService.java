package com.project.school.teacher;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

import com.project.school.data.Data;

public class TeacherService {

    //시작 메소드
    public void begin(String teacherId) {

        Teacher t = new Teacher();

        t = Data.getTeacher(teacherId);

        Scanner scan = new Scanner(System.in);

        boolean loop = true;

        while (loop) {

            System.out.println();
            System.out.println(" \r\n"
                    + "■■■■■■■■ ■■■■■■■■    ■■■     ■■■■■■  ■■     ■■ ■■■■■■■■ ■■■■■■■■  \r\n"
                    + "   ■■    ■■         ■■ ■■   ■■    ■■ ■■     ■■ ■■       ■■     ■■ \r\n"
                    + "   ■■    ■■        ■■   ■■  ■■       ■■     ■■ ■■       ■■     ■■ \r\n"
                    + "   ■■    ■■■■■■   ■■     ■■ ■■       ■■■■■■■■■ ■■■■■■   ■■■■■■■■  \r\n"
                    + "   ■■    ■■       ■■■■■■■■■ ■■       ■■     ■■ ■■       ■■   ■■   \r\n"
                    + "   ■■    ■■       ■■     ■■ ■■    ■■ ■■     ■■ ■■       ■■    ■■  \r\n"
                    + "   ■■    ■■■■■■■■ ■■     ■■  ■■■■■■  ■■     ■■ ■■■■■■■■ ■■     ■■ \r\n");
            System.out.println("==================================================================");
            if (t.getGrade() != 0 && t.getClassNo() != 0) {
                System.out.printf("                                 [%d학년 %d반 담임 %s 선생님 안녕하세요!]\n", t.getGrade(), t.getClassNo(), t.getName());
            } else {
                System.out.printf("                                          [%s %s선생님 안녕하세요!]\n", t.getName(), t.getPosition());
            }
            System.out.println("[1] 정보 조회");
            System.out.println("[2] 학생 정보 관리");
            System.out.println("[3] 시간표 열람");
            System.out.println("[4] 학급 관리");
            System.out.println("[5] 코로나 병결 신청 확인");
            System.out.println("[6] 조직 구성도");
            System.out.println("[7] 상위 메뉴");
            System.out.println("==================================================================");
            System.out.print("선택: ");

            String sel = scan.nextLine();


            if (sel.equals("1")) {

                //1. 정보 조회
                showList();

            } else if (sel.equals("2")) {

                //2. 학생 정보 관리
                editStudent();

            } else if (sel.equals("3")) {

                //3. 시간표 열람
                timeTable(t.getGrade(), t.getClassNo());

            } else if (sel.equals("4")) {

                //4. 학급 관리
                editClass(t.getGrade(), t.getClassNo(), t.getName());

            } else if (sel.equals("5")) {

                //5. 코로나 병결 신청 확인
                covidCheck(t.getGrade(), t.getClassNo());

            } else if (sel.equals("6")) {

                //6. 조직 구성도
                organization();

            } else if (sel.equals("7")) {

                //7. 상위메뉴
                loop = false;


            } else {

                System.out.println("잘못된 입력입니다.");

            }//if

        }//while


    }//begin

    private static void organization() {

        // 6.조직 구성도
        System.out.println();
        System.out.println("=========================================================");
        System.out.println("                       [조직 구성도]");
        System.out.println("=========================================================");


        System.out.println("[직급]    [이름]    [담당과목]    [담당 반]       [연락처]");

        Data.tlist.stream()
                .forEach(t -> System.out.printf("%3s   %5s   %6s    %6s      %6s\n"
                        , t.getPosition()
                        , t.getName()
                        , (t.getSubject().equals("-") ? "없음" : t.getSubject())
                        , (t.getClassNo() == 0 ? "없음" : t.getClassNo())
                        , t.getTel()));
        System.out.println("=========================================================");
        System.out.println();

        Data.pause();

    }//organization

    private static void covidCheck(int grade, int classNo) {
        //5.코로나 병결 신청 확인
        if (grade == 0 || classNo == 0) {
            System.out.println();
            System.out.println("담당 학급이 없습니다.");
            Data.pause();
        } else {
            CovidCheck.covidCheck(grade, classNo);
        }

    }//covidCheck

    private static void editClass(int grade, int classNo, String name) {

        if (grade == 0 || classNo == 0) {
            System.out.println();
            System.out.println("담당 학급이 없습니다.");
            Data.pause();
        } else {
            //4. 학급 게시판
            EditClass.editClass(grade, classNo, name);
        }

    }//editClass

    private static void timeTable(int grade, int classNo) {

        try {
            if (grade == 0 || classNo == 0) {
                System.out.println();
                System.out.println("담당 학급이 없습니다.");
                Data.pause();
            } else {

                System.out.println();
                String path = String.format("./dat/%d[학년]/%d-%d[반]/%d-%d[반] 학급시간표.txt", grade, grade, classNo, grade, classNo);

                BufferedReader reader = new BufferedReader(new FileReader(path));

                String line = null;

                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }

                reader.close();

            }

        } catch (Exception e) {
            System.out.println("StudentTimetable.main");
            e.printStackTrace();
        }

    }//timeTable

    private static void editStudent() {
        //2.학생 정보 수정
        EditStudent.editStudent();

    }//editStudent

    private static void showList() {
        //1. 학생 정보 조회
        ShowList.showList();

    }//showList


}//class

