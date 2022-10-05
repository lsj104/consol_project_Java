package com.project.school;

import java.util.Scanner;

import com.project.school.data.Data;
import com.project.school.student.StudentService;
import com.project.school.teacher.TeacherService;

public class MainInterface {


    public static void main(String[] args) {
        //1. 데이터 로드
        //2. 주메뉴 > 선택
        //3. 선택 > 기능 호출
        //4. 데이터 저장
        //5. 종료

        Data.load();


        boolean loop = true;

        Scanner scan = new Scanner(System.in);

        while (loop) {
            System.out.println("  ■■■■■■   ■■■■■■  ■■     ■■  ■■■■■■■   ■■■■■■■  ■■      \r\n"
                    + " ■■    ■■ ■■    ■■ ■■     ■■ ■■     ■■ ■■     ■■ ■■      \r\n"
                    + " ■■       ■■       ■■     ■■ ■■     ■■ ■■     ■■ ■■      \r\n"
                    + "  ■■■■■■  ■■       ■■■■■■■■■ ■■     ■■ ■■     ■■ ■■      \r\n"
                    + "       ■■ ■■       ■■     ■■ ■■     ■■ ■■     ■■ ■■      \r\n"
                    + " ■■    ■■ ■■    ■■ ■■     ■■ ■■     ■■ ■■     ■■ ■■      \r\n"
                    + "  ■■■■■■   ■■■■■■  ■■     ■■  ■■■■■■■   ■■■■■■■  ■■■■■■■ ");
            System.out.println();
            System.out.println(" ------------------------------------------------------- ");
            System.out.println("| WELCOME !!                                            |");
            System.out.println(": ----------------------------------------------------- :");
            System.out.println("|                                                     \t|");
            System.out.println("|      안녕하세요! OO학교입니다.                            \t|");
            System.out.println("|      로그인을 위해 본인의 ID(고유번호)를 입력해주세요.         \t|");
            System.out.println("|      종료를 원하시면 enter키를 입력해주세요.                \t|");
            System.out.println("|                                                      \t|");
            System.out.println(" ------------------------------------------------------- ");
            System.out.print(" ID(고유번호) : ");
            String id = scan.nextLine();


            if (id.equals("")) {
                loop = false;
            } else {
                String loginSite = String.format("%s", id.substring(0, 1));

                if (loginSite.equals("s")) {
                    if (Data.searchStudentId(id)) {
                        //학생 관리
                        StudentService studentService = new StudentService();
                        studentService.begin(id);
                    } else {
                        System.out.println("존재하지 않는 학생 아이디입니다.");
                        loop = false;
                    }
                } else if (loginSite.equals("t")) {
                    if (Data.searchTeacherId(id)) {
                        //교사관리
                        TeacherService teacherService = new TeacherService();
                        teacherService.begin(id);
                    } else {
                        System.out.println("존재하지 않는 교사 아이디입니다.");
                        loop = false;
                    }
                } else {
                    System.out.println("잘못된 아이디 형식입니다. 다시 입력하여 주십시오.");
                    System.out.println();
                }


            }//else

        }//while

        System.out.println("프로그램을 종료합니다.");

        Data.save();

    }

}








