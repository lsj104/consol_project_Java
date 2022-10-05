package com.project.school.data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import com.project.school.score.Score;
import com.project.school.student.Student;
import com.project.school.teacher.Teacher;


public class Data {

    private final static String STUDENT;
    private final static String SCORE;
    private final static String TEACHER;

    public static ArrayList<Student> slist; //= student.txt
    public static ArrayList<Score> score; //= score.txt
    public static ArrayList<Teacher> tlist; //= teacher.txt

    //객체 생성자 > 객체 멤버 초기화

    //정적 생성자 > 정적 멤버 초기화

    static {

        STUDENT = "./dat/student.txt";
        SCORE = "./dat/score.txt";
        TEACHER = "./dat/teacher.txt";

        slist = new ArrayList<Student>();
        score = new ArrayList<Score>();
        tlist = new ArrayList<Teacher>();

    }

    public static void load() {

        try {

            BufferedReader reader = new BufferedReader(new FileReader(STUDENT));

            String line = null;

            while ((line = reader.readLine()) != null) {

                String[] temp = line.split(",");

                Student s = new Student();

                //s0001,1,1,1,홍준윤,남,2006-12-28,010-2802-4914,서울시 강남구 삼성동 6번지
                s.setId(temp[0]);
                s.setGrade(Integer.parseInt(temp[1]));
                s.setClassNo(Integer.parseInt(temp[2]));
                s.setNumber(Integer.parseInt(temp[3]));
                s.setName(temp[4]);
                s.setGender(temp[5]);
                s.setBirth(temp[6]);
                s.setTel(temp[7]);
                s.setAddress(temp[8]);

                slist.add(s);

            }//while

            reader = new BufferedReader(new FileReader(SCORE));

            line = null;

            while ((line = reader.readLine()) != null) {

                //System.out.println(line);

                //s0001,1,82,77,91,93,97

                String[] temp = line.split(",");

                Score sc = new Score();

                sc.setId(temp[0]);
                sc.setSemester(Integer.parseInt(temp[1]));
                sc.setKor(Integer.parseInt(temp[2]));
                sc.setEng(Integer.parseInt(temp[3]));
                sc.setMath(Integer.parseInt(temp[4]));
                sc.setSocial(Integer.parseInt(temp[5]));
                sc.setScience(Integer.parseInt(temp[6]));

                score.add(sc);


            }

            reader = new BufferedReader(new FileReader(TEACHER));

            line = null;

            while ((line = reader.readLine()) != null) {


                //교사,박근석,1,1,1987-11-25,t06,남,국어,010-3742-8905,서울시 강남구 청담동 14번지

                String[] temp = line.split(",");


                Teacher t = new Teacher();

                t.setPosition(temp[0]);
                t.setName(temp[1]);
                t.setGrade(Integer.parseInt(temp[2]));
                t.setClassNo(Integer.parseInt(temp[3]));
                t.setBirth((temp[4]));
                t.settId(temp[5]);
                t.setGender(temp[6]);
                t.setSubject(temp[7]);
                t.setTel(temp[8]);
                t.setAddress(temp[9]);

                tlist.add(t);

            }//while
            reader.close();


        } catch (Exception e) {

            System.out.println("Data.load");
            e.printStackTrace();

        }

    }//load

    public static void save() {

        //컬렉션 > 텍스트 파일

        try {

            //덮어쓰기 모드
            //- student.txt의 내용 > 과거 데이터
            //- list의 내용 > 최신 데이터
            BufferedWriter writer = new BufferedWriter(new FileWriter(STUDENT));

            for (Student s : slist) {
                //- 학생ID, 학년, 반, 번호, 학생명, 성별, 생년월일, 연락처, 주소
                //s0001,1,1,1,홍준윤,남,2006-12-28,010-2802-4914,서울시 강남구 삼성동 6번지
                String data = String.format("%s,%d,%d,%d,%s,%s,%s,%s,%s"
                        , s.getId()
                        , s.getGrade()
                        , s.getClassNo()
                        , s.getNumber()
                        , s.getName()
                        , s.getGender()
                        , s.getBirth()
                        , s.getTel()
                        , s.getAddress());
                writer.write(data + "\r\n");
            }

            writer.close();
            //score
            ////학생번호, 학기(1,2), 국어, 영어, 수학, 사회, 과학
            //s0001,1,82,77,91,93,97

            writer = new BufferedWriter(new FileWriter(SCORE));

            for (Score sc : score) {

                String data = String.format("%s,%d,%d,%d,%d,%d,%d"
                        , sc.getId()
                        , sc.getSemester()
                        , sc.getKor()
                        , sc.getEng()
                        , sc.getMath()
                        , sc.getSocial()
                        , sc.getScience());

                writer.write(data + "\r\n");

            }


            writer.close();


        } catch (Exception e) {

            System.out.println("Data.save");
            e.printStackTrace();

        }


    }//save

    //일시정지
    public static void pause() {

        System.out.println();
        System.out.println("계속하시려면 엔터를 입력하세요.");

        Scanner scan = new Scanner(System.in);
        scan.nextLine();

        System.out.println();

    }//pause

    public static void main(String[] args) {

//      load();

//
//      Student s = getStudent("s0001");
//      Score sc = getScore("s0001");
//      Teacher t = getTeacher("t24");
//      //Data.load(); //데이터 로딩
//
//      //1. 학생 1명 가져오기
//
//      //1. 학생 1명 가져오기
//      System.out.println(s.getName());
//      System.out.println(s.getBirth());
//      System.out.println(s.getGrade() + "반 " + s.getClassNo()+ "반");
//      System.out.println(sc.getKor());
//      System.out.println(sc.getEng());
//      System.out.println(sc.getMath());
//      System.out.println(sc.getSocial());
//      System.out.println(sc.getScience());
//
//      System.out.printf("%d학년 %d반 선생님 %s", t.getGrade(),t.getClassNo(), t.getName());


    }


    public static Teacher getTeacher(String id) {
        for (Teacher t : tlist) {
            if (t.getId().equals(id)) {
                return t;
            }
        }
        return null;
    }

    public static Score getScore(String id, int semester) {

        for (Score sc : score) {
            if (sc.getId().equals(id) && sc.getSemester() == semester) {
                return sc;
            }
        }
        return null;

    }


    public static Student getStudent(String id) {

        for (Student student : slist) {
            if (student.getId().equals(id)) {
                return student;
            }
        }

        return null;
    }

    public static String createStudentID() {


        String temp = slist.get(slist.size() - 1).getId().substring(1);

        return "s0" + (Integer.parseInt(temp) + 1);

    }

    public static int createNumber(int grade, int classNo) {

        return slist.stream().filter(s -> s.getGrade() == grade)
                .filter(s -> s.getClassNo() == classNo)
                .map(s -> s.getNumber())
                .max((a, b) -> a - b)
                .get() + 1;
    }


    public static String getStudentId(int grade, int classNo, int number) {

        for (Student s : slist) {

            if (s.getGrade() == grade && s.getClassNo() == classNo && s.getNumber() == number) {
                return s.getId();
            }
        }

        return null;
    }

    public static boolean searchStudentId(String id) {

        int count = 0;

        for (Student s : slist) {
            if (s.getId().equals(id)) {
                count++;
            }
        }

        if (count == 0) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean searchTeacherId(String id) {

        int count = 0;

        for (Teacher t : tlist) {
            if (t.getId().equals(id)) {
                count++;
            }
        }

        if (count == 0) {
            return false;
        } else {
            return true;
        }
    }

    public static ArrayList<Student> searchStudent(String word) {

        ArrayList<Student> studentlist = new ArrayList<Student>();

        for (Student s : slist) {


            if (s.getName().contains(word)) {

                studentlist.add(s);
            }

        }

        return studentlist;


    }

    public static ArrayList<Teacher> searchTecher(String word) {

        ArrayList<Teacher> teacherlist = new ArrayList<Teacher>();

        for (Teacher t : tlist) {


            if (t.getName().contains(word)) {

                teacherlist.add(t);

            }

        }

        return teacherlist;

    }

    public static boolean deleteStudent(String id) {


        //성적 삭제후 학생삭제
        // 향상된 for문은 읽기전용 for문이다
        // 향상된 for문에서는 절대로 추가, 수정, 삭제작업을 할 수 없다
        // 루프를 돌면서 요소 추가 삭제를 하고싶으면 일반 for문을 사용해야한다.

//	for(int i =0; i<score.size(); i++) {
//		score.remove(i);
//	}
//
//	for(Student s : slist) {
//
//		if(s.getId().equals(id)) {
//			return slist.remove(s);
//		}
//	}

        Student s = new Student();
        Score studentScore = new Score();

        s = Data.getStudent(id);

        studentScore = Data.getScore(id, 1);
        for (int i = 0; i < score.size(); i++) {
            if (studentScore.getId().equals(id)) {
                score.remove(studentScore);
            }
        }

        studentScore = Data.getScore(id, 2);
        for (int i = 0; i < score.size(); i++) {
            if (studentScore.getId().equals(id)) {
                score.remove(studentScore);
            }
        }

        for (int i = 0; i < slist.size(); i++) {
            if (s.getId().equals(id)) {
                return slist.remove(s);
            }
        }

        return false;
    }

    public static void restart() {

        System.out.println();
        System.out.println("다시 진행하려면 엔터를 입력하세요.");

        Scanner scan = new Scanner(System.in);
        scan.nextLine();

        System.out.println();

    }//restart

}