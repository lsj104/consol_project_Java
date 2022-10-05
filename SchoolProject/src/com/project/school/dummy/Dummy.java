package com.project.school.dummy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Random;

public class Dummy {

    public static void main(String[] args) {

        try {

            covidDummy();
            createClassboard();
            createFolder(); // 시간표와 게시판을 저장할 더미파일 생성
            timeTableDummy(); // 시간표 더미데이터 생성
            scoreDummy(); // 성적 더미데이터 생성
            studentDummy(); // 학생 더미데이터 생성
            teacherDummy(); // 교사 더미데이터 생성

        } catch (Exception e) {
            System.out.println("Dummy.main");
            e.printStackTrace();
        }


    }

    private static void covidDummy() throws IOException {

        for (int i = 1; i <= 3; i++) {

            for (int j = 1; j <= 10; j++) {

                String path = String.format("./dat/%d[학년]/%d-%d[반]/%d학년_%d반_확진자명단.txt", i, i, j, i, j);

                BufferedWriter writer = new BufferedWriter(new FileWriter(path));


                writer.write("");
                writer.close();


            }
        }

        for (int i = 1; i <= 3; i++) {

            for (int j = 1; j <= 10; j++) {

                String path = String.format("./dat/%d[학년]/%d-%d[반]/%d학년_%d반_의심자명단.txt", i, i, j, i, j);

                BufferedWriter writer = new BufferedWriter(new FileWriter(path));


                writer.write("");
                writer.close();


            }
        }


    }

    private static void createClassboard() throws IOException {

        for (int i = 1; i <= 3; i++) {

            for (int j = 1; j <= 10; j++) {

                String path = String.format("./dat/%d[학년]/%d-%d[반]/%d학년_%d반_공지사항.txt", i, i, j, i, j);
                String classNotice = "";

                BufferedWriter writer = new BufferedWriter(new FileWriter(path));


                writer.write(classNotice);
                writer.close();

            }
        }

        for (int i = 1; i <= 3; i++) {

            for (int j = 1; j <= 10; j++) {

                String path = String.format("./dat/%d[학년]/%d-%d[반]/%d학년_%d반_한줄게시판.txt", i, i, j, i, j);
                String classNotice = "";

                BufferedWriter writer = new BufferedWriter(new FileWriter(path));


                writer.write(classNotice);
                writer.close();

            }
        }


    }

    private static void createFolder() {

        //폴더(O-O반)에 해당 학급 (공지사항, 시간표, 한줄게시판?).txt가 들어감
        for (int j = 1; j <= 3; j++) {

            String path1 = String.format("./dat/%d[학년]", j);
            File dir1 = new File(path1);

            if (!dir1.exists()) {

                try {

                    System.out.println(dir1.mkdirs());

                } catch (Exception e) {

                    System.out.println("TimeTable.m2");
                    e.printStackTrace();

                }

            } else {

                System.out.println("폴더가 이미 존재합니다.");
            }

            for (int i = 1; i <= 10; i++) {

                String path2 = String.format("./dat/%d[학년]/%d-%d[반]", j, j, i);
                File dir2 = new File(path2);

                if (!dir2.exists()) {

                    try {

                        System.out.println(dir2.mkdirs());

                    } catch (Exception e) {

                        System.out.println("TimeTable.m2");
                        e.printStackTrace();

                    }

                } else {

                    System.out.println("폴더가 이미 존재합니다.");
                }

            }
        }


    }

    private static void timeTableDummy() throws IOException {

        String[][] timeTable = new String[5][7];
        int[] nums = new int[7];

        String[] subject = {"국어", "수학", "영어", "사회", "과학", "체육", "음악"};

        Random r = new Random();

        for (int k = 1; k <= 3; k++) {
            for (int k2 = 1; k2 <= 10; k2++) {

                boolean check = false;

                for (int i = 0; i < timeTable.length; i++) {

                    for (int j = 0; j < nums.length; j++) {

                        check = false;

                        int n = r.nextInt(7) + 1;
                        for (int k3 = 0; k3 < nums.length; k3++) {
                            if (nums[k3] == n) {
                                check = true;
                                break;
                            }
                        }

                        if (!check) {
                            nums[j] = n;
                        } else {
                            j--;
                        }
                    }

                    for (int l = 0; l < timeTable[0].length; l++) {
                        timeTable[i][l] = subject[nums[l] - 1];
                        nums[l] = 0; // 배열 초기화 해주기
                    }
                }

                String classTimeTable = "";
                String path = String.format("./dat/%d[학년]/%d-%d[반]/%d-%d[반] 학급시간표.txt", k, k, k2, k, k2);

                BufferedWriter writer = new BufferedWriter(new FileWriter(path));

//	    		  System.out.println("============================================");
//	    		  System.out.printf("               %d학년 %d반 시간표                     \n", k, k2);
//	    		  System.out.println("============================================");
//	    		  System.out.println("\t  [월]\t[화]\t[수]\t[목]\t[금]");
//	    		  System.out.println("--------------------------------------------");
//	    		  System.out.printf("[1교시]\t  %s\t%s\t%s\t%s\t%s\n", timeTable[0][0], timeTable[1][0], timeTable[2][0], timeTable[3][0], timeTable[4][0]);
//	    		  System.out.printf("[2교시]\t  %s\t%s\t%s\t%s\t%s\n", timeTable[0][1], timeTable[1][1], timeTable[2][1], timeTable[3][1], timeTable[4][1]);
//	    		  System.out.printf("[3교시]\t  %s\t%s\t%s\t%s\t%s\n", timeTable[0][2], timeTable[1][2], timeTable[2][2], timeTable[3][2], timeTable[4][2]);
//	    		  System.out.printf("[4교시]\t  %s\t%s\t%s\t%s\t%s\n", timeTable[0][3], timeTable[1][3], timeTable[2][3], timeTable[3][3], timeTable[4][3]);
//	    		  System.out.printf("[5교시]\t  %s\t%s\t%s\t%s\t%s\n", timeTable[0][4], timeTable[1][4], timeTable[2][4], timeTable[3][4], timeTable[4][4]);
//	    		  System.out.printf("[6교시]\t  %s\t%s\t%s\t%s\t%s\n", timeTable[0][5], timeTable[1][5], timeTable[2][5], timeTable[3][5], timeTable[4][5]);
//	    		  System.out.printf("[7교시]\t  %s\t%s\t%s\t%s\t%s\n", timeTable[0][6], timeTable[1][6], timeTable[2][6], timeTable[3][6], timeTable[4][6]);


//	    		  classTimeTable += String.format("============================================\n");
//	    		  classTimeTable += String.format("               %d학년 %d반 시간표                     \n", k, k2);
//	    		  classTimeTable += String.format("============================================\n");
//	    		  classTimeTable += String.format("\t  [월]\t[화]\t[수]\t[목]\t[금]\n");
//	    		  classTimeTable += String.format("[1교시]\t  %s\t%s\t%s\t%s\t%s\n", timeTable[0][0], timeTable[1][0], timeTable[2][0], timeTable[3][0], timeTable[4][0]);
//	    		  classTimeTable += String.format("[2교시]\t  %s\t%s\t%s\t%s\t%s\n", timeTable[0][1], timeTable[1][1], timeTable[2][1], timeTable[3][1], timeTable[4][1]);
//	    		  classTimeTable += String.format("[3교시]\t  %s\t%s\t%s\t%s\t%s\n", timeTable[0][2], timeTable[1][2], timeTable[2][2], timeTable[3][2], timeTable[4][2]);
//	    		  classTimeTable += String.format("[4교시]\t  %s\t%s\t%s\t%s\t%s\n", timeTable[0][3], timeTable[1][3], timeTable[2][3], timeTable[3][3], timeTable[4][3]);
//	    		  classTimeTable += String.format("[5교시]\t  %s\t%s\t%s\t%s\t%s\n", timeTable[0][4], timeTable[1][4], timeTable[2][4], timeTable[3][4], timeTable[4][4]);
//	    		  classTimeTable += String.format("[6교시]\t  %s\t%s\t%s\t%s\t%s\n", timeTable[0][5], timeTable[1][5], timeTable[2][5], timeTable[3][5], timeTable[4][5]);
//	    		  classTimeTable += String.format("[7교시]\t  %s\t%s\t%s\t%s\t%s\n", timeTable[0][6], timeTable[1][6], timeTable[2][6], timeTable[3][6], timeTable[4][6]);

                classTimeTable += String.format("================================================\n");
                classTimeTable += String.format("               %d학년 %d반 시간표                     \n", k, k2);
                classTimeTable += String.format("================================================\n");
                classTimeTable += String.format(" 교시\\요일|  [월]     [화]    [수]    [목]    [금]    \n");
                classTimeTable += String.format("------------------------------------------------\n");
                classTimeTable += String.format(" [1교시] |  %s  |  %s  |  %s  |  %s  |  %s  |  \n", timeTable[0][0], timeTable[1][0], timeTable[2][0], timeTable[3][0], timeTable[4][0]);
                classTimeTable += String.format("------------------------------------------------\n");
                classTimeTable += String.format(" [2교시] |  %s  |  %s  |  %s  |  %s  |  %s  |  \n", timeTable[0][1], timeTable[1][1], timeTable[2][1], timeTable[3][1], timeTable[4][1]);
                classTimeTable += String.format("------------------------------------------------\n");
                classTimeTable += String.format(" [3교시] |  %s  |  %s  |  %s  |  %s  |  %s  |  \n", timeTable[0][2], timeTable[1][2], timeTable[2][2], timeTable[3][2], timeTable[4][2]);
                classTimeTable += String.format("------------------------------------------------\n");
                classTimeTable += String.format(" [4교시] |  %s  |  %s  |  %s  |  %s  |  %s  |  \n", timeTable[0][3], timeTable[1][3], timeTable[2][3], timeTable[3][3], timeTable[4][3]);
                classTimeTable += String.format("------------------------------------------------\n");
                classTimeTable += String.format(" [5교시] |  %s  |  %s  |  %s  |  %s  |  %s  |  \n", timeTable[0][4], timeTable[1][4], timeTable[2][4], timeTable[3][4], timeTable[4][4]);
                classTimeTable += String.format("------------------------------------------------\n");
                classTimeTable += String.format(" [6교시] |  %s  |  %s  |  %s  |  %s  |  %s  |  \n", timeTable[0][5], timeTable[1][5], timeTable[2][5], timeTable[3][5], timeTable[4][5]);
                classTimeTable += String.format("------------------------------------------------\n");
                classTimeTable += String.format(" [7교시] |  %s  |  %s  |  %s  |  %s  |  %s  |  \n", timeTable[0][6], timeTable[1][6], timeTable[2][6], timeTable[3][6], timeTable[4][6]);
                classTimeTable += String.format("------------------------------------------------\n");

                System.out.println(classTimeTable);
                writer.write(classTimeTable);
                writer.close();

            }

        }


    }

    private static void scoreDummy() throws Exception {
        //학생번호, 학기(1,2), 국어, 영어, 수학, 사회, 과학
        //s0001, 1, 90, 80, 70, 70, 85

        Random random = new Random();

        FileWriter writer = new FileWriter("./dat/score.txt");

        //1학기
        //학생 900명
        for (int i = 1; i <= 900; i++) {

            String studentNo = String.format("s%04d", i);

            String data = String.format("%s,%d,%d,%d,%d,%d,%d"
                    , studentNo
                    , 1
                    , random.nextInt(51) + 50
                    , random.nextInt(51) + 50
                    , random.nextInt(51) + 50
                    , random.nextInt(51) + 50
                    , random.nextInt(51) + 50);
            System.out.println(data);
            writer.write(data + "\r\n");
        }

        //2학기
        for (int i = 1; i <= 900; i++) {

            String studentNo = String.format("s%04d", i);

            String data = String.format("%s,%d,%d,%d,%d,%d,%d"
                    , studentNo
                    , 2
                    , random.nextInt(51) + 50
                    , random.nextInt(51) + 50
                    , random.nextInt(51) + 50
                    , random.nextInt(51) + 50
                    , random.nextInt(51) + 50);
            System.out.println(data);
            writer.write(data + "\r\n");
        }

        writer.close();
    }


    private static void teacherDummy() throws Exception {
        //교사 정보 만들기
        //직급,이름, 학년, 반, 생년월일,교사ID,성별, 담당과목, 연락처, 주소

        //1~3학년, 10학급, 50명


        Random rnd = new Random();

        String[] name1 = {"김", "이", "박", "최", "정", "신", "유", "윤", "권", "황"};
        String[] name2 = {"경", "석", "효", "근", "진", "현", "재", "형", "민", "덕",
                "영", "수", "나", "연", "찬", "훈", "용", "동", "욱", "배"};

        //서울시 강남구
        String[] address = {"신사동", "논현동", "압구정동", "청담동", "삼성동", "대치동",
                "역삼동", "도곡동", "개포동", "세곡동", "일원동", "수서동"};


        //고유번호
        int no = 6; // 5명 생성 이후 부여할 고유번호

        //성별
        String[] gender = {"남", "여"};


        //담당과목
        //국어,수학,영어,사회,과학
        String[] subject = {"국어", "수학", "영어", "사회", "과학"};


        //직급
        String position = "교사";


        //파일 기록
        FileWriter writer = new FileWriter("./dat/teacher.txt");

        //교장,교감,학년주임은 직접 입력(예외처리)
        //직급,이름, 학년, 반, 생년월일,교사ID,성별, 담당과목, 연락처, 주소
        writer.write("교장,곽경갑,0,0,1958-08-27,t01,남,-,010-1645-4561,서울시 강남구 대치동 1번지\n");
        writer.write("교감,김덕배,0,0,1959-05-05,t02,남,-,010-0269-4652,서울시 강남구 개포동 50번지\n");
        writer.write("주임,박득춘,1,0,1960-01-23,t03,남,-,010-9802-4303,서울시 강남구 압구정동 25번지\n");
        writer.write("주임,황정희,2,0,1960-08-20,t04,남,-,010-7821-6594,서울시 강남구 세곡동 15번지\n");
        writer.write("주임,최호근,3,0,1960-11-26,t05,남,-,010-2864-3565,서울시 강남구 신사동 35번지\n");


        //1학년
        for (int i = 1; i <= 1; i++) {

            //담임 10명
            for (int j = 1; j <= 10; j++) {


                //교사 ID
                String id = String.format("t%02d", no);

                //생년월일
//	            Calendar today = Calendar.getInstance();
                Calendar birth = Calendar.getInstance();
                birth.add(Calendar.YEAR, -rnd.nextInt(38) - 24);
                birth.set(Calendar.MONTH, rnd.nextInt(12));
                birth.set(Calendar.DATE, rnd.nextInt(31));

                //- 직급,이름, 학년, 반, 생년월일,교사ID,성별, 담당과목, 연락처, 주소
                //6,교사,이민재,1,1,1967-06-04,t06,여,수학,010-7960-7406,서울시 강남구 역삼동 20번지

                String data = String.format("%s,%s,%d,%s,%d-%02d-%02d,%s,%s,%s,%s,%s"


                        , position
                        , name1[rnd.nextInt(name1.length)]
                                + name2[rnd.nextInt(name2.length)]
                                + name2[rnd.nextInt(name2.length)]
                        , 1
                        , j
                        , birth.get(Calendar.YEAR), birth.get(Calendar.MONTH) + 1, birth.get(Calendar.DATE)
                        , id
                        , gender[rnd.nextInt(gender.length)]
                        , subject[rnd.nextInt(subject.length)]

                        //전화번호
                        , String.format("010-%d-%d", rnd.nextInt(9000) + 1000
                                , rnd.nextInt(9000) + 1000)
                        //주소
                        , String.format("서울시 강남구 %s %d번지"
                                , address[rnd.nextInt(address.length)]
                                , rnd.nextInt(50) + 1));


                System.out.println(data);

                //파일 기록


                writer.write(data + "\r\n");

                no++;


            }//j


        }//i


        //2학년
        for (int i = 1; i <= 1; i++) {

            //담임 10명
            for (int j = 1; j <= 10; j++) {


                //교사 ID
                String id = String.format("t%02d", no);

                //생년월일
//	            Calendar today = Calendar.getInstance();
                Calendar birth = Calendar.getInstance();
                birth.add(Calendar.YEAR, -rnd.nextInt(38) - 24);
                birth.set(Calendar.MONTH, rnd.nextInt(12));
                birth.set(Calendar.DATE, rnd.nextInt(31));

                //- 고유번호,직급,이름, 학년, 반, 생년월일,교사ID,성별, 담당과목, 연락처, 주소
                //- 5,교사,김경석,1,1,700919,0005,남자,국어,010-1234-5678,서울시 강남구 역삼동 20-1번지

                String data = String.format("%s,%s,%d,%s,%d-%02d-%02d,%s,%s,%s,%s,%s"

                        , position
                        , name1[rnd.nextInt(name1.length)]
                                + name2[rnd.nextInt(name2.length)]
                                + name2[rnd.nextInt(name2.length)]
                        , 2
                        , j
                        , birth.get(Calendar.YEAR), birth.get(Calendar.MONTH) + 1, birth.get(Calendar.DATE)
                        , id
                        , gender[rnd.nextInt(gender.length)]
                        , subject[rnd.nextInt(subject.length)]

                        //전화번호
                        , String.format("010-%d-%d", rnd.nextInt(9000) + 1000
                                , rnd.nextInt(9000) + 1000)
                        //주소
                        , String.format("서울시 강남구 %s %d번지"
                                , address[rnd.nextInt(address.length)]
                                , rnd.nextInt(50) + 1));


                System.out.println(data);

                //파일 기록


                writer.write(data + "\r\n");

                no++;


            }//j


        }//i


        //3학년
        for (int i = 1; i <= 1; i++) {

            //담임 10명
            for (int j = 1; j <= 10; j++) {


                //교사 ID
                String id = String.format("t%02d", no);

                //생년월일
//	            Calendar today = Calendar.getInstance();
                Calendar birth = Calendar.getInstance();
                birth.add(Calendar.YEAR, -rnd.nextInt(38) - 24);
                birth.set(Calendar.MONTH, rnd.nextInt(12));
                birth.set(Calendar.DATE, rnd.nextInt(31));

                //- 고유번호,직급,이름, 학년, 반, 생년월일,교사ID,성별, 담당과목, 연락처, 주소
                //- 5,교사,김경석,1,1,700919,0005,남자,국어,010-1234-5678,서울시 강남구 역삼동 20-1번지

                String data = String.format("%s,%s,%d,%s,%d-%02d-%02d,%s,%s,%s,%s,%s"

                        , position
                        , name1[rnd.nextInt(name1.length)]
                                + name2[rnd.nextInt(name2.length)]
                                + name2[rnd.nextInt(name2.length)]
                        , 3
                        , j
                        , birth.get(Calendar.YEAR), birth.get(Calendar.MONTH) + 1, birth.get(Calendar.DATE)
                        , id
                        , gender[rnd.nextInt(gender.length)]
                        , subject[rnd.nextInt(subject.length)]

                        //전화번호
                        , String.format("010-%d-%d", rnd.nextInt(9000) + 1000
                                , rnd.nextInt(9000) + 1000)
                        //주소
                        , String.format("서울시 강남구 %s %d번지"
                                , address[rnd.nextInt(address.length)]
                                , rnd.nextInt(50) + 1));


                System.out.println(data);

                //파일 기록


                writer.write(data + "\r\n");

                no++;


            }//j


        }//i

        //나머지 선생님 15명
        for (int i = 1; i <= 15; i++) {
            //교사 ID
            String id = String.format("t%02d", no);

            //생년월일
//	         Calendar today = Calendar.getInstance();
            Calendar birth = Calendar.getInstance();
            birth.add(Calendar.YEAR, -rnd.nextInt(38) - 24);
            birth.set(Calendar.MONTH, rnd.nextInt(12));
            birth.set(Calendar.DATE, rnd.nextInt(31));

            //- 고유번호,직급,이름, 학년, 반, 생년월일,교사ID,성별, 담당과목, 연락처, 주소
            //- 5,교사,김경석,1,1,700919,0005,남자,국어,010-1234-5678,서울시 강남구 역삼동 20-1번지

            String data = String.format("%s,%s,%d,%d,%d-%02d-%02d,%s,%s,%s,%s,%s"

                    , position
                    , name1[rnd.nextInt(name1.length)]
                            + name2[rnd.nextInt(name2.length)]
                            + name2[rnd.nextInt(name2.length)]
                    , 0
                    , 0
                    , birth.get(Calendar.YEAR), birth.get(Calendar.MONTH) + 1, birth.get(Calendar.DATE)
                    , id
                    , gender[rnd.nextInt(gender.length)]
                    , subject[rnd.nextInt(subject.length)]

                    //전화번호
                    , String.format("010-%d-%d", rnd.nextInt(9000) + 1000
                            , rnd.nextInt(9000) + 1000)
                    //주소
                    , String.format("서울시 강남구 %s %d번지"
                            , address[rnd.nextInt(address.length)]
                            , rnd.nextInt(50) + 1));


            System.out.println(data);

            //파일 기록


            writer.write(data + "\r\n");

            no++;

        }//i

        writer.close();


    }


    private static void studentDummy() throws Exception {
        //- 학생ID, 학년, 반, 번호, 학생명, 성별, 생년월일, 연락처, 주소
        //- s0895,3,10,25,박경나,895,여,2006-11-05,010-5154-7568,서울시 강남구 논현동 12번지

        //1~3학년, 10학급, 30명

        Random rnd = new Random();

        String[] lastname = {"김", "이", "박", "정", "최", "손", "유", "강", "조", "윤", "장", "임", "한", "오", "서", "신", "안", "권", "황", "송", "홍"};
        String[] firstname = {"훈", "우", "영", "형", "준", "현", "중", "재", "진", "민", "경", "수", "나", "린", "예", "지", "유", "정", "서", "윤", "연", "승", "아", "다", "빈"};

        //서울시 강남구
        String[] address = {"신사동", "논현동", "압구정동", "청담동", "삼성동", "대치동", "역삼동", "도곡동", "개포동", "세곡동", "일원동", "수서동"};

        //학생 번호
        int no = 1;


        //성별
        String[] gender = {"남", "여"};

        //파일 기록
        FileWriter writer = new FileWriter("./dat/student.txt");


        //학년
        for (int i = 1; i <= 3; i++) {

            //반
            for (int j = 1; j <= 10; j++) {

                //인원
                for (int k = 1; k <= 30; k++) {

                    //학생 ID
                    String id = String.format("s%04d", no);

                    //생년월일
                    Calendar birth = Calendar.getInstance();
                    birth.add(Calendar.YEAR, -15 - i);
                    birth.set(Calendar.MONTH, rnd.nextInt(12));
                    birth.set(Calendar.DATE, rnd.nextInt(31));
                    //- 학생ID, 학년, 반, 번호, 학생명, 성별, 생년월일, 연락처, 주소, 다음 학년 반
                    //- s0895,3,10,25,박경나,895,여,2006-11-05,010-5154-7568,서울시 강남구 논현동 12번지, 3

                    String data = String.format("%s,%d,%d,%d,%s,%s,%d-%02d-%02d,%s,%s,%s"
                            , id
                            , i
                            , j
                            , k
                            , lastname[rnd.nextInt(lastname.length)]
                                    + firstname[rnd.nextInt(firstname.length)]
                                    + firstname[rnd.nextInt(firstname.length)]
                            , gender[rnd.nextInt(gender.length)]
                            , birth.get(Calendar.YEAR), birth.get(Calendar.MONTH) + 1, birth.get(Calendar.DATE)
                            , String.format("010-%d-%d", rnd.nextInt(9000) + 1000, rnd.nextInt(9000) + 1000)
                            , String.format("서울시 강남구 %s %d번지"
                                    , address[rnd.nextInt(address.length)]
                                    , rnd.nextInt(50) + 1)
                            , "");


                    System.out.println(data);

                    //파일 기록
                    writer.write(data + "\r\n");

                    no++;

                }//k
            }//j
        }//i

        writer.close();


    }

}
