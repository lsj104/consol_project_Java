package com.project.school.teacher;

import com.project.school.data.Data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class CovidCheck {

    public static void covidCheck(int Grade, int ClassNo) {

        boolean loop = true;

        Scanner scan = new Scanner(System.in);


        while (loop) {

            System.out.println("      [코로나 병결 신청 확인]");
            System.out.println("==============================");
            System.out.println("[1] 코로나 확진 학생 확인");
            System.out.println("[2] 코로나 의심 학생 확인");
            System.out.println("[3] 상위 메뉴");
            System.out.println("==============================");
            System.out.print("선택: ");

            String sel = scan.nextLine();

            if (sel.equals("1")) {

                // 1. 코로나 확진 학생 확인
                getCovid(Grade, ClassNo);

            } else if (sel.equals("2")) {

                // 2.의심 학생 확인
                doubtCovid(Grade, ClassNo);

            } else {

                // 3.상위 메뉴
                loop = false;

            } // if


        } // while
    }

    private static void getCovid(int Grade, int ClassNo) {
        // 1. 코로나 확진 학생 확인


        Scanner scan = new Scanner(System.in);


        System.out.println();
        System.out.println("========================================");
        System.out.println("            [코로나 확진 학생 명단]");
        System.out.println("========================================");
        getCovidLoad(Grade, ClassNo);
        System.out.println("========================================");

        Data.pause();

    }

    private static void getCovidLoad(int Grade, int ClassNo) {

        int c = 1;
        ArrayList<String> list = new ArrayList<String>();
        String path = String.format("./dat/%d[학년]/%d-%d[반]/%d학년_%d반_확진자명단.txt", Grade, Grade, ClassNo, Grade, ClassNo);

        System.out.printf("             %d학년 %d반 확진자명단\n", Grade, ClassNo);
        System.out.println("  [번호][이름][확진날짜][격리기간][수업참여방식]");
        try {

            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line = null;
            while ((line = reader.readLine()) != null) {

                list.add(line);
                Collections.reverse(list);
            } // while

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

    }

    private static void doubtCovid(int Grade, int ClassNo) {
        // 2.의심 학생 확인

        boolean loop = true;

        Scanner scan = new Scanner(System.in);


        System.out.println();
        System.out.println("========================================");
        System.out.println("            [코로나 의심 학생 명단]");
        System.out.println("========================================");
        doubtCovidLoad(Grade, ClassNo);
        System.out.println("========================================");

        Data.pause();


    }


    private static void doubtCovidLoad(int Grade, int ClassNo) {

        int c = 1;
        ArrayList<String> list = new ArrayList<String>();
        String path = String.format("./dat/%d[학년]/%d-%d[반]/%d학년_%d반_의심자명단.txt", Grade, Grade, ClassNo, Grade, ClassNo);

        System.out.printf("             %d학년 %d반 의심자명단\n", Grade, ClassNo);
        System.out.println("     [번호][이름][증상][체온][수업참여방식]");
        try {

            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line = null;
            while ((line = reader.readLine()) != null) {

                list.add(line);
                Collections.reverse(list);
            } // while

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
    }
}
