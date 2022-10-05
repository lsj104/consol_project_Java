package com.project.school.score;

import com.project.school.MainInterface;
import com.project.school.data.Data;
import com.project.school.student.Student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ScoreService {

    public static void view(String id) {

        Student student1 = Data.getStudent(id);

        boolean loop = true;

        while (loop) {

            int semester = 0;
            Scanner scan = new Scanner(System.in);
            System.out.println();
            System.out.println("                                [성적 조회]");
            System.out.println("============================================================================");
            System.out.print("학기:");
            String sel = scan.nextLine();
            System.out.println("============================================================================");
            System.out.println();
            if (!sel.equals("1") && !sel.equals("2")) {
                System.out.println("잘못된 학기 정보입니다 1,2 중 하나의 숫자를 입력하여 주십시오.");
                view(id);
            } else if (sel.equals("1")) {
                semester = 1;
                System.out.println("                                [1학기]");
            } else if (sel.equals("2")) {
                semester = 2;
                System.out.println("                                [2학기]");
            }


            Score s = Data.getScore(id, semester);


            if (!id.equals("") && (semester == 1 || semester == 2)) {

                System.out.printf("                                                                 이름 : %s\n", student1.getName());
                System.out.println();
                System.out.println("============================================================================");
                System.out.println();
                System.out.println("[국어]    [영어]    [수학]    [사회]    [과학]    [평균]     [반석차]      [전교석차]");

                //전교 석차
                int rank = 0;


                ArrayList<StudentScore> sslist = new ArrayList<StudentScore>();

                for (Student student : Data.slist) {

                    if (student.getGrade() == Data.getStudent(id).getGrade()) {

                        StudentScore ss = new StudentScore();

                        ss.setStudent(student);

                        for (Score score : Data.score) {
                            if (score.getId().equals(student.getId())
                                    && score.getSemester() == semester) {
                                ss.setScore(score);

                            }
                        }

                        sslist.add(ss);
                    }

                }

                //반석차
                int classRank = 0;

                ArrayList<StudentScore> crlist = new ArrayList<StudentScore>();

                for (Student student : Data.slist) {

                    if (student.getGrade() == Data.getStudent(id).getGrade() && student.getClassNo() == Data.getStudent(id).getClassNo()) {

                        StudentScore cr = new StudentScore();

                        cr.setStudent(student);

                        for (Score score : Data.score) {
                            if (score.getId().equals(student.getId())
                                    && score.getSemester() == semester) {
                                cr.setScore(score);

                            }
                        }

                        crlist.add(cr);
                    }

                }

                //전교석차
                sslist.sort((a, b) -> (b.getScore().getKor() + b.getScore().getEng() + b.getScore().getMath() + b.getScore().getSocial() + b.getScore().getScience()) - (a.getScore().getKor() + a.getScore().getEng() + a.getScore().getMath() + a.getScore().getSocial() + a.getScore().getScience()));

                //반석차
                crlist.sort((a, b) -> (b.getScore().getKor() + b.getScore().getEng() + b.getScore().getMath() + b.getScore().getSocial() + b.getScore().getScience()) - (a.getScore().getKor() + a.getScore().getEng() + a.getScore().getMath() + a.getScore().getSocial() + a.getScore().getScience()));


                //전교석차
                for (StudentScore ss : sslist) {
                    rank++;

                    if (ss.getScore().getId().equals(s.getId())) {
                        break;
                    }
                }

                //반석차
                for (StudentScore cr : crlist) {
                    classRank++;

                    if (cr.getScore().getId().equals(s.getId())) {
                        break;
                    }
                }

                int totalStudent = 0;
                totalStudent = sslist.size();

                int classStudent = 0;
                classStudent = crlist.size();


                System.out.printf("%3d   %6d   %6d    %5d   %5d    %6.1f      (%d/%d)      (%d/%d)\n"
                        , s.getKor()
                        , s.getEng()
                        , s.getMath()
                        , s.getSocial()
                        , s.getScience()
                        , s.getAvg()
                        , classRank
                        , classStudent
                        , rank, totalStudent);

                System.out.println();
                System.out.println("============================================================================");


                System.out.println("성적표 조회를 완료하였습니다.");

                Data.pause();


            }

            loop = false;


        }//while
    }

    public static void edit() {


        //3. 학생 성적 처리
        Scanner scan = new Scanner(System.in);
        System.out.println("======================================================================================");
        System.out.println("                                   [학생 성적 수정]");
        System.out.println("======================================================================================");
        System.out.print("학생ID:");
        String id = scan.nextLine();

        System.out.print("학기:");
        int semester = scan.nextInt();
        scan.nextLine();

        System.out.println();
        System.out.println("[학년]    [반]    [번호]    [이름]    [학생ID]    [국어]    [영어]    [수학]    [사회]    [과학]\n");

        Student s = Data.getStudent(id);
        Score sc = Data.getScore(id, semester);

        if (!id.equals("")) {

            System.out.printf("%3d     %3d     %3d     %4s     %4s     %4d    %4d     %4d     %4d     %4d\n"
                    , s.getGrade()
                    , s.getClassNo()
                    , s.getNumber()
                    , s.getName()
                    , s.getId()
                    , sc.getKor()
                    , sc.getEng()
                    , sc.getMath()
                    , sc.getSocial()
                    , sc.getScience()

            );
        }

        System.out.println();
        System.out.println("======================================================================================");
        System.out.println();

        System.out.println("                            [수정할 데이터 입력(Enter: 값 유지)]");
        System.out.print("국어:");
        String kor = scan.nextLine();
        System.out.print("영어:");
        String eng = scan.nextLine();
        System.out.print("수학:");
        String math = scan.nextLine();
        System.out.print("사회:");
        String social = scan.nextLine();
        System.out.print("과학:");
        String science = scan.nextLine();

        if (!kor.equals("")) {
            sc.setKor(Integer.parseInt(kor));
        }

        if (!eng.equals("")) {
            sc.setEng(Integer.parseInt(eng));
        }

        if (!math.equals("")) {
            sc.setMath(Integer.parseInt(math));
        }

        if (!social.equals("")) {
            sc.setSocial(Integer.parseInt(social));
        }

        if (!science.equals("")) {
            sc.setScience(Integer.parseInt(science));
        }


        System.out.println();
        System.out.println("[학년]    [반]    [번호]    [이름]    [학생ID]    [국어]    [영어]    [수학]    [사회]    [과학]\n");
        System.out.printf("%3d     %3d     %3d     %4s     %4s     %4d    %4d     %4d     %4d     %4d\n"
                , s.getGrade()
                , s.getClassNo()
                , s.getNumber()
                , s.getName()
                , s.getId()
                , sc.getKor()
                , sc.getEng()
                , sc.getMath()
                , sc.getSocial()
                , sc.getScience());

        System.out.println();
        System.out.println("======================================================================================");
        System.out.println("                                 성적 수정이 완료됐습니다.");

        Data.pause();

    }


}