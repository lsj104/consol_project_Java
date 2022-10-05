package com.project.school.teacher;

import java.util.ArrayList;
import java.util.Scanner;

import com.project.school.data.Data;
import com.project.school.score.Score;
import com.project.school.score.StudentScore;
import com.project.school.student.Student;

public class ShowList {

    public static void showList() {


        boolean loop = true;

        Scanner scan = new Scanner(System.in);
        String sel = "";

        while (loop) {

            System.out.println();
            System.out.println("              [정보 조회]");
            System.out.println("======================================");
            System.out.println("[1] 학생 정보 조희");
            System.out.println("[2] 교사 정보 조회");
            System.out.println("[3] 상위 메뉴");
            System.out.println("======================================");
            System.out.print("선택: ");

            sel = scan.nextLine();


            if (sel.equals("1")) {

                //1. 학생 정보 조회
                showStudentList();

            } else if (sel.equals("2")) {

                //2.교사 정보 조회
                showTeacherList();

            } else if (sel.equals("3")) {

                //3.상위 메뉴
                loop = false;

            } else {
                System.out.println("올바르지 않은 번호입니다. 다시 입력해주세요");
            }

        }//while

    }

    private static void showStudentList() {

        //1. 학생 정보 조회

        boolean loop = true;
        Scanner scan = new Scanner(System.in);


        while (loop) {
            System.out.println();
            System.out.println("=================================================================================================================");
            System.out.println("                                                 [학생 정보 조회]");
            System.out.println("=================================================================================================================");
            System.out.println();

            System.out.print("이름: ");

            String name = scan.nextLine();

            ArrayList<Student> slist = Data.searchStudent(name);

            if (slist.size() != 0 && !name.equals("")) {

                System.out.println();
                System.out.println("[학년]    [반]     [번호]     [이름]    [고유번호]    [성별]      [생년월일]            [연락처]                 [주소]");

                slist.stream().forEach(s -> System.out.printf("%3d     %3d       %3d      %3s      %2s      %2s       %4s      %3s      %3s\n"
                        , s.getGrade()
                        , s.getClassNo()
                        , s.getNumber()
                        , s.getName()
                        , s.getId()
                        , s.getGender()
                        , s.getBirth()
                        , s.getTel()
                        , s.getAddress()));

            } else {
                System.out.println("검색한 이름의 학생이 없습니다.");
            }

            for (; ; ) {

                System.out.println();
                System.out.println("=================================================================================================================");

                System.out.print("학생 정보를 추가 검색하시겠습니까?(y/n): ");
                String sel = scan.nextLine().toLowerCase();
                if (sel.equals("y") || sel.equals("Y")) {
                    loop = true;
                    break;
                } else if (sel.equals("n") || sel.equals("N")) {
                    loop = false;
                    System.out.println("정보조회를 종료합니다.");
                    Data.pause();
                    break;
                } else {
                    System.out.println();
                    System.out.println("올바르지 않은 입력입니다. Y 또는 N을 입력해주세요.");
                }

            }


        }

    }

    private static void showTeacherList() {

        //2.교사 정보 조회

        boolean loop = true;
        Scanner scan = new Scanner(System.in);


        while (loop) {
            System.out.println();
            System.out.println("==========================================================================");
            System.out.println("                             [교사 정보 조회]");
            System.out.println("==========================================================================");
            System.out.println();

            System.out.print("이름 입력: ");

            String name = scan.nextLine();

            ArrayList<Teacher> tlist = Data.searchTecher(name);

            if (tlist.size() != 0 && !name.equals("")) {

                System.out.println();
                System.out.println("[직급]    [이름]    [학년]    [반]    [담당과목]       [연락처]        [생년월일]");

                tlist.stream().forEach(s -> System.out.printf("%3s     %s    %3s     %3s      %4s      %4s    %3s\n"
                        , s.getPosition()
                        , s.getName()
                        , String.format("%s", s.getGrade()).equals("0") ? "-" : String.format("%s", s.getGrade())
                        , String.format("%s", s.getClassNo()).equals("0") ? "-" : String.format("%s", s.getClassNo())
                        , s.getSubject()
                        , s.getTel()
                        , s.getBirth()));

            } else {
                System.out.println("검색한 이름의 선생님이 없습니다.");
            }


            for (; ; ) {

                System.out.println();
                System.out.println("==========================================================================");
                System.out.print("교사 정보를 추가 검색하시겠습니까?(y/n): ");
                String sel = scan.nextLine().toLowerCase();
                if (sel.equals("y") || sel.equals("Y")) {
                    loop = true;
                    break;
                } else if (sel.equals("n") || sel.equals("N")) {
                    loop = false;
                    System.out.println("정보조회를 종료합니다.");
                    Data.pause();
                    break;
                } else {
                    System.out.println();
                    System.out.println("올바르지 않은 입력입니다. Y 또는 N을 입력해주세요.");
                }

            }
        }

    }
}








