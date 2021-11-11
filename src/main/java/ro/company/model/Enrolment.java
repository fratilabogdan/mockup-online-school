package ro.company.model;

import java.time.LocalDateTime;

public class Enrolment implements Comparable<Enrolment>{
    private int id;
    private int studentID;
    private int courseID;
    private LocalDateTime createdAt;

    public Enrolment(int id, int studentID, int courseID, LocalDateTime createdAt) {
        this.id=id;
        this.studentID = studentID;
        this.courseID = courseID;
        this.createdAt = createdAt;
    }

    public Enrolment(int studentID, int courseID, LocalDateTime createdAt) {
        this.studentID = studentID;
        this.courseID = courseID;
        this.createdAt = createdAt;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object obj){
        Enrolment enrolment = (Enrolment) obj;
        return enrolment.id==this.id;
    }
    @Override
    public int compareTo(Enrolment enrolment){
        if(enrolment.id==this.id){
            return 0;
        }else if(enrolment.id<this.id){
            return 1;
        } return -1;
    }
    @Override
    public String toString(){
        return id+","+studentID+","+courseID+","+createdAt;
    }

}
