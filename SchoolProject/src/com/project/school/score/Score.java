package com.project.school.score;

/**
 * 점수 데이터 관리 클래스
 */
public class Score {
    //s0001,1,1,60,86,73,54,55
    //학생번호, 학기(1,2),  국어, 영어, 수학, 사회, 과학

    private String id;
    private int semester;
    private int kor;
    private int eng;
    private int math;
    private int social;
    private int science;
    private double avg;

    public double getAvg() {

        this.avg = (this.kor + this.eng + this.math + this.social + this.science) / 5.0;

        return this.avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getSocial() {
        return social;
    }

    public void setSocial(int social) {
        this.social = social;
    }

    public int getScience() {
        return science;
    }

    public void setScience(int science) {
        this.science = science;
    }
}
