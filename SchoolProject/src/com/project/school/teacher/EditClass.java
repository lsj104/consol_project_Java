package com.project.school.teacher;

import java.util.Scanner;

import com.project.school.data.Data;

public class EditClass {

    public static void editClass(int grade, int classNo, String name) {

        boolean loop = true;

        Scanner scan = new Scanner(System.in);


        while (loop) {

            System.out.println("               [학급 관리]");
            System.out.println("======================================");
            System.out.println("[1] 학급 게시판 관리");
            System.out.println("[2] 학급 구성원 조회");
            System.out.println("[3] 상위 메뉴");
            System.out.println("======================================");
            System.out.print("선택: ");

            String sel = scan.nextLine();


            if (sel.equals("1")) {

                //1. 학급 게시판 관리
                showBoard(grade, classNo, name);

            } else if (sel.equals("2")) {

                //2.학급 구성원 조회
                showClassMember(grade, classNo);

            } else {

                //3.상위 메뉴
                loop = false;


            }//if

        }//while

    }

    private static void showClassMember(int grade, int classNo) {
        System.out.println("=============================================================================================");
        // 2.학급 구성원 조회
        System.out.printf("                                     [%d학년 %d반의 학급 구성원]\n", grade, classNo);
        System.out.println();
        System.out.println("[번호]    [이름]     [성별]        [생년월일]           [연락처]                  [주소]");
        Data.slist.stream().filter(g -> g.getGrade() == grade)
                .filter(g -> g.getClassNo() == classNo)
                .forEach(g -> System.out.printf("%2d       %s       %s        %s       %s       %s\n"
                        , g.getNumber()
                        , g.getName()
                        , g.getGender()
                        , g.getBirth()
                        , g.getTel()
                        , g.getAddress()));

        System.out.println("=============================================================================================");

    }

    private static void showBoard(int grade, int classNo, String name) {

        // 1. 학급 게시판 관리

        boolean loop = true;

        Scanner scan = new Scanner(System.in);

        while (loop) {

            System.out.println("======================================");
            System.out.println("[1] 공지사항");
            System.out.println("[2] 한줄 게시판");
            System.out.println("[3] 뒤로가기");
            System.out.println("======================================");
            System.out.print("선택: ");
            String sel = scan.nextLine();

            if (sel.equals("1")) {

                try {
                    System.out.println();
                    System.out.println("잠시후 화면이 이동됩니다.");
                    System.out.println();
                    Thread.sleep(500);
                } catch (Exception e) {
                    System.out.println("EditClass.java");
                    e.printStackTrace();

                }

                NoticeBoard notice = new NoticeBoard();
                notice.TeacherNoticeBoard(grade, classNo);

            } else if (sel.equals("2")) {

                if (classNo != 0) {
                    try {
                        System.out.println();
                        System.out.println("잠시후 화면이 이동됩니다.");
                        System.out.println();
                        Thread.sleep(500);
                    } catch (Exception e) {
                        System.out.println("EditClass.java");
                        e.printStackTrace();

                    }

                    NoticeBoard notice = new NoticeBoard();
                    notice.TeacherLineBoard(grade, classNo, name);

                } else {

                    System.out.println("담당하고 있는 반이 없습니다.");
                }
            } else {
                // 프로그램 종료
                loop = false;
            }

        }

    }

}







