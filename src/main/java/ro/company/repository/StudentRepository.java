package ro.company.repository;
import ro.company.helpers.Helpers;
import ro.company.model.Book;
import ro.company.model.Student;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class StudentRepository {
    private String jdbcURL="jdbc:mysql://localhost:3306/online_school_db";
    private String username="root";
    private String password="root";

    private Connection connection=null;
    private Statement statement=null;

    public StudentRepository(){
        try {
            connection=DriverManager.getConnection(jdbcURL,username,password);
            statement=connection.createStatement();
        }catch (SQLException e){
            System.out.println("Eroare conectare la baza de date. StudentRepository");
        }
    }

    private boolean execute(String execute){
        try {
            statement.execute(execute);
            return true;
        }catch (SQLException e){
            System.out.println("Nu a mers executat \n"+execute);
            return false;
        }
    }

    //Utility
    public ResultSet allStudent(){
        execute("select*from student");
        try {
            return statement.getResultSet();
        }catch (Exception e){
            System.out.println("ResultSet failed to return.Returned NULL instead.");
            return null;
        }
    }
    public List<Student> allStudentList(){
        ResultSet set=allStudent();
        List<Student> students = new ArrayList<>();
        try {
            while (set.next()){
                Student s = new Student(
                        set.getInt(1),
                        set.getString(2),
                        set.getString(3),
                        set.getString(4),
                        set.getInt(5)
                );
                students.add(s);
            }
        }catch (Exception e){
            System.out.println("Error on allStudentList");
        }
        return students;
    }
    public Student getStudent(int id){
        if(allStudentList().size()<id){
            return null;
        }
        int i=0;
        Iterator<Student> it = allStudentList().iterator();
        while (it.hasNext() && it.next().getId()!=id){
            i++;
        }
        return allStudentList().get(i);
    }

    //CRUD
    public boolean add(Student s){
        if(s.getId()>(allStudentList().size()+1)){
            System.out.println("Student ID too high. Next free value is "+(allStudentList().size()+1));
            return false;
        }
        String insertTO="insert into student (first_name, last_name, email, age) VALUES";
        insertTO+=String.format("('%s','%s','%s',%d);",s.getFirstName(),s.getLastName(),s.getEmail(),s.getAge());
        return execute(insertTO);
    }
    public boolean updateFirstName(int id, String newFName){
        if(getStudent(id)==null){
            return false;
        }
        String update = "update student set first_name='"+newFName+"' where id="+id;
        return execute(update);
    }
    public boolean updateLastName(int id,String newLName){
        if(getStudent(id)==null){
            return false;
        }
        String update="update student set last_name='"+newLName+"' where id="+id;
        return execute(update);
    }
    public boolean updateEmail(int id,String newEmail){
        if(getStudent(id)==null){
            return false;
        }
        String update="update student set email='"+newEmail+"' where id="+id;
        return execute(update);
    }
    public boolean updateAge(int id, int newAge){
        if(getStudent(id)==null){
            return false;
        }
        String update="update student set age="+newAge+" where id="+id;
        return execute(update);
    }
}
