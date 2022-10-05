package com.project.school.teacher;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

public class NoticeBoardData {

    public static void lineBoardRead(int grade, int classNo, String name) {

        int c = 1;
        ArrayList<String> list = new ArrayList<String>();
        String path = String.format("./dat/%d[학년]/%d-%d[반]/%d학년_%d반_한줄게시판.txt",
                grade, grade, classNo, grade, classNo);
        System.out.printf("             %d학년 %d반 한줄 게시판\n", grade, classNo);
        System.out.println();
        try {

            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line = null;
            while ((line = reader.readLine()) != null) {

                list.add(line);
            } // while

            Collections.reverse(list);
            reader.close();
        } catch (Exception e) {
            System.out.println("Dat.load");
            e.printStackTrace();
        }
        for (int i = 0; i < 5; i++) {

            System.out.printf("%d. ", c);

            try {

                System.out.println(list.get(i));

            } catch (Exception e) {

                System.out.println("");
            }

            c++;
        }
        System.out.println();
    }// load

    public static void lineBoardWrite(int grade, int classNo, String name, String sel) {

        Date now = Calendar.getInstance().getTime(); // 현재 날짜/시간 출력

        // 포맷팅 정의
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd HH:mm");

        // 포맷팅 적용
        String formatedNow = formatter.format(now);

        // 포맷팅 현재 날짜/시간 출력
        System.out.println(formatedNow);

        String path = String.format("./dat/%d[학년]/%d-%d[반]/%d학년_%d반_한줄게시판.txt",
                grade, grade, classNo, grade, classNo);

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));

            writer.write("(" + formatedNow + ") " + name + ": " + sel + "\t\t" + "\r\n");
            writer.close();

        } catch (Exception e) {
            System.out.println("Dat.save");
            e.printStackTrace();
        }
        System.out.println("입력이 완료 되었습니다.");

    }// save

    public static void noticeRead(int grade, int classNo) {

        int c = 1;
        ArrayList<String> list = new ArrayList<String>();
        String path = String.format("./dat/%d[학년]/%d-%d[반]/%d학년_%d반_공지사항.txt",
                grade, grade, classNo, grade, classNo);
        System.out.printf("              %d학년 %d반 공지사항\n", grade, classNo);
        System.out.println();
        try {

            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line = null;
            while ((line = reader.readLine()) != null) {

                list.add(line);
            } // while

            Collections.reverse(list);
            reader.close();
        } catch (Exception e) {
            System.out.println("Dat.load");
            e.printStackTrace();
        }
        for (int i = 0; i < 5; i++) {

            System.out.printf("%d. ", c);

            try {

                System.out.println(list.get(i));

            } catch (Exception e) {

                System.out.println("");
            }

            c++;
        }

        System.out.println();
    }// load2

    public static void noticeWrite(int grade, int classNo, String con) {

        Date now = Calendar.getInstance().getTime(); // 현재 날짜/시간 출력

        // 포맷팅 정의
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd HH:mm");

        // 포맷팅 적용
        String formatedNow = formatter.format(now);

        // 포맷팅 현재 날짜/시간 출력
        System.out.println(formatedNow);

        String path = String.format("./dat/%d[학년]/%d-%d[반]/%d학년_%d반_공지사항.txt",
                grade, grade, classNo, grade, classNo);

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));

            writer.write("(" + formatedNow + ")" + " " + con + "\r\n");
            writer.close();

        } catch (Exception e) {
            System.out.println("Dat.save");
            e.printStackTrace();
        }
        System.out.println("입력이 완료 되었습니다.");
    }// save2

}
