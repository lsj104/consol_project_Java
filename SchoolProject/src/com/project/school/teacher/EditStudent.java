package com.project.school.teacher;

import java.util.Scanner;

import com.project.school.data.Data;
import com.project.school.score.Score;
import com.project.school.score.ScoreService;
import com.project.school.score.StudentScore;
import com.project.school.student.Student;

public class EditStudent {

    public static void editStudent() {

        boolean loop = true;

        Scanner scan = new Scanner(System.in);
        String sel = "";


        while (loop) {

            System.out.println();
            System.out.println("             [학생 정보 관리]");
            System.out.println("======================================");
            System.out.println("[1] 학생 정보 추가");
            System.out.println("[2] 학생 정보 수정");
            System.out.println("[3] 학생 성적 수정");
            System.out.println("[4] 학생 정보 삭제");
            System.out.println("[5] 상위 메뉴");
            System.out.println("======================================");
            System.out.print("선택: ");

            sel = scan.nextLine();


            if (sel.equals("1")) {

                //1. 학생 정보 추가
                add();

            } else if (sel.equals("2")) {

                //2. 학생 정보 수정
                edit();

            } else if (sel.equals("3")) {

                //3. 학생 성적 처리
                Score();

            } else if (sel.equals("4")) {

                //4. 학생 정보 삭제
                delete();

            } else {

                //5.상위 메뉴
                loop = false;


            }//if

        }//while

    }


    private static void delete() {


        //4. 학생 정보 삭제
        System.out.println();
        Scanner scan = new Scanner(System.in);
        System.out.println("==============================================");
        System.out.println("                [학생 삭제하기]");
        System.out.println("==============================================");

        System.out.print("삭제할 학생 고유 번호: ");
        String id = scan.nextLine();

        Student s = new Student();
        s = Data.getStudent(id);

        if (Data.searchStudentId(id)) {

            System.out.printf("%d학년 %d반 %s학생의 정보를 삭제하시겠습니까?(Y/N): "
                    , s.getGrade()
                    , s.getClassNo()
                    , s.getName());

            String answer = scan.nextLine();

            System.out.println("==============================================");

            if (answer.equals("Y") || answer.equals("y")) {

                boolean result = Data.deleteStudent(id);

                if (result) {
                    System.out.println("학생 정보 삭제를 완료했습니다.");
                    Data.save();
                } else {
                    System.out.println("문제가 발생하여 정보가 삭제되지 않았습니다.");
                }

            } else if (answer.equals("N") || answer.equals("n")) {

                System.out.println();
                System.out.println("정보를 삭제하지 않고 초기 메뉴로 돌아갑니다");
            }

        } else {
            System.out.println("올바르지 않은 학생 ID입니다. 초기 메뉴로 돌아갑니다.");
        }

        Data.pause();
    }

    private static void Score() {

        //3. 학생 성적 처리

        ScoreService.edit();

    }

    private static void edit() {

        //- 학생ID, 학년, 반, 번호, 학생명, 성별, 생년월일, 연락처, 주소
        //2. 학생 정보 수정
        System.out.println();
        Scanner scan = new Scanner(System.in);

        System.out.println("==============================================================================================================");
        System.out.println("                                                 [학생 수정하기]");
        System.out.println("==============================================================================================================");

        System.out.print("수정 할 학생 고유번호: ");
        String id = scan.nextLine();
        System.out.println();

        Student s = Data.getStudent(id);


        if (Data.searchStudentId(id)) {

            //1	1	32	980220	s0902	null	2	1	1
            System.out.println("[학년]    [반]    [번호]    [이름]    [고유번호]    [성별]      [생년월일]          [연락처]             [주소]");
            System.out.printf("%3d	    %3d     %3d	   %5s      %5s     %3s      %5s     %5s   %5s\n"
                    , s.getGrade()
                    , s.getClassNo()
                    , s.getNumber()
                    , s.getName()
                    , s.getId()
                    , s.getGender()
                    , s.getBirth()
                    , s.getTel()
                    , s.getAddress());

            System.out.println();
            System.out.println("==============================================================================================================");

            System.out.println();
            System.out.println("                                        [수정할 데이터 입력(Enter: 값 유지)]");

            System.out.print("학년: ");
            String grade = scan.nextLine();

            System.out.print("반: ");
            String classNo = scan.nextLine();

            System.out.print("번호: ");
            String number = scan.nextLine();

            System.out.print("이름: ");
            String name = scan.nextLine();

            System.out.print("생년월일: ");
            String birth = scan.nextLine();

            System.out.print("연락처: ");
            String tel = scan.nextLine();

            System.out.print("주소: ");
            String address = scan.nextLine();


            boolean flag = true;

            for (Student s1 : Data.slist) {

                if (s1.getGrade() == (Integer.parseInt(grade.equals("") ? String.format("%s", s.getGrade()) : grade))
                        && s1.getClassNo() == (Integer.parseInt(classNo.equals("") ? String.format("%s", s.getClassNo()) : classNo))
                        && s1.getNumber() == (Integer.parseInt(number.equals("") ? String.format("%s", s.getNumber()) : number))
                        &&
                        !(s1.getGrade() == Integer.parseInt(grade.equals("") ? String.format("%s", s.getGrade()) : grade)
                                && s1.getClassNo() == Integer.parseInt(classNo.equals("") ? String.format("%s", s.getClassNo()) : classNo)
                                && s1.getNumber() == Integer.parseInt(number.equals("") ? String.format("%s", s.getNumber()) : number))) {

                    System.out.println("해당 학급에 같은 번호를 가진 학생이 존재합니다.");
                    flag = false;
                    break;
                }
            }

            if (flag) {

                if (!grade.equals("")) {
                    s.setGrade(Integer.parseInt(grade));
                }
                if (!classNo.equals("")) {
                    s.setClassNo(Integer.parseInt(classNo));
                }
                if (!number.equals("")) {
                    s.setNumber(Integer.parseInt(number));
                }
                if (!name.equals("")) {
                    s.setName(name);
                }
                if (!birth.equals("")) {
                    s.setBirth(birth);
                }
                if (!tel.equals("")) {
                    s.setTel(tel);
                }
                if (!address.equals("")) {
                    s.setAddress(address);
                }

                System.out.println();
                System.out.println("[학년]    [반]    [번호]    [이름]    [고유번호]    [성별]      [생년월일]          [연락처]             [주소]");
                System.out.printf("%3d	    %3d     %3d	   %5s      %5s     %3s      %5s     %5s   %5s\n"
                        , s.getGrade()
                        , s.getClassNo()
                        , s.getNumber()
                        , s.getName()
                        , s.getId()
                        , s.getGender()
                        , s.getBirth()
                        , s.getTel()
                        , s.getAddress());
                System.out.println();
                System.out.println("==============================================================================================================");

                System.out.println("수정이 완료되었습니다.");

                Data.save();

                Data.pause();
            } else {
                System.out.println("학생 정보 수정에 문제가 발생하였습니다.");
            }

        } else {
            System.out.println();
            System.out.println("존재하지 않는 고유번호 입니다.");

            Data.pause();
        }
    }


    private static void add() {

        //- 학생ID, 학년, 반, 번호, 학생명, 성별, 생년월일, 연락처, 주소
        //1. 학생 정보 추가
        Scanner scan = new Scanner(System.in);
        System.out.println("======================================");
        System.out.println("             [학생 정보 추가]");
        System.out.println("======================================");

        String id = Data.createStudentID(); //학생번호

        System.out.print("학년: ");
        int grade = scan.nextInt();

        System.out.print("반: ");
        int classNo = scan.nextInt();

        int number = Data.createNumber(grade, classNo);

        scan.nextLine();

        System.out.print("이름: ");
        String name = scan.nextLine();

        System.out.print("성별: ");
        String gender = scan.nextLine();

        System.out.print("생년월일: ");
        String birth = scan.nextLine();

        System.out.print("연락처: ");
        String tel = scan.nextLine();

        System.out.print("주소: ");
        String address = scan.nextLine();

        //입력받은정보 > ArrayList<Student>
        Student s = new Student();
        Score firstScore = new Score();
        Score secondScore = new Score();

        s.setId(id);
        s.setName(name);
        s.setGrade(grade);
        s.setClassNo(classNo);
        s.setGender(gender);
        s.setNumber(number);
        s.setBirth(birth);
        s.setTel(tel);
        s.setAddress(address);
        firstScore.setId(id);
        firstScore.setKor(0);
        firstScore.setEng(0);
        firstScore.setMath(0);
        firstScore.setSocial(0);
        firstScore.setScience(0);
        firstScore.setSemester(1);
        secondScore.setId(id);
        secondScore.setKor(0);
        secondScore.setEng(0);
        secondScore.setMath(0);
        secondScore.setSocial(0);
        secondScore.setScience(0);
        secondScore.setSemester(2);

        Data.score.add(firstScore);
        Data.score.add(secondScore);

        Data.slist.add(s);

        System.out.println("======================================");
        System.out.println("학생 추가가 완료되었습니다.");
        Data.save();

        Data.pause();


    }//add
}

















