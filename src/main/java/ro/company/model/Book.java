package ro.company.model;

import java.time.LocalDateTime;
import java.time.Period;

public class Book implements Comparable<Book>{
    private int id;
    private int studentID;
    private String bookName;
    private LocalDateTime createdAT;

    public Book(int id, int studentID, String bookName, LocalDateTime createdAT) {
        this.id = id;
        this.studentID = studentID;
        this.bookName = bookName;
        this.createdAT = createdAT;
    }
    public Book(int studentID, String bookName, LocalDateTime createdAT) {
        this.studentID = studentID;
        this.bookName = bookName;
        this.createdAT = createdAT;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public LocalDateTime getCreatedAT() {
        return createdAT;
    }

    public void setCreatedAT(LocalDateTime createdAT) {
        this.createdAT = createdAT;
    }

    @Override
    public int compareTo(Book book){
        if(book.id==this.id){
            return 0;
        }else if(book.id<this.id){
            return 1;
        }
        return -1;
    }

    @Override
    public boolean equals(Object obj){
        Book book = (Book)obj;
        return book.id==this.id;
    }

    @Override
    public String toString(){
        return id+","+studentID+","+bookName+","+createdAT;
    }

}
