package com.project.school.teacher;

import com.project.school.data.Data;

import java.util.Scanner;

public class NoticeBoard {


    public void TeacherLineBoard(int grade, int classNo, String name) {

        boolean loop = true;

        Scanner scan = new Scanner(System.in);


        System.out.println();
        System.out.println("===========================================");
        System.out.println("                [한줄 게시판]");
        System.out.println("===========================================");
        NoticeBoardData.lineBoardRead(grade, classNo, name);
        System.out.println("===========================================");

        Data.pause();

    }

    public void TeacherNoticeBoard(int grade, int classNo) {

        boolean loop = true;

        Scanner scan = new Scanner(System.in);

        while (loop) {

            System.out.println();
            System.out.println("===========================================");
            System.out.println("                [공지 사항]");
            System.out.println("===========================================");
            NoticeBoardData.noticeRead(grade, classNo);
            System.out.println("===========================================");
            System.out.println("(뒤로 가길 원하시면 엔터를 입력하세요.)");
            System.out.print("입력: ");
            String con = scan.nextLine();


            if (con.equals("")) {
                loop = false;
            } else {
                NoticeBoardData.noticeWrite(grade, classNo, con);
            }

        }
    }
}
