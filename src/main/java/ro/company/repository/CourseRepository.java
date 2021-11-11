package ro.company.repository;

import ro.company.model.Course;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CourseRepository {
    private String jdbcURL="jdbc:mysql://localhost:3306/online_school_db";
    private String username="root";
    private String password="root";

    private Connection connection = null;
    private Statement statement = null;

    public CourseRepository(){
        try {
            connection = DriverManager.getConnection(jdbcURL,username,password);
            statement=connection.createStatement();
        }catch (SQLException e){
            System.out.println("Eroare conectare la baza de date. CourseRepository");
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
    public ResultSet allCourse(){
        execute("select*from course");
        try {
            return statement.getResultSet();
        }catch (Exception e){
            System.out.println("ResultSet failed to return.Returned NULL instead");
            return null;
        }
    }

    public ResultSet byID(int id){
        String toID="select*from course where id="+id;
        execute(toID);
        try {
            return statement.getResultSet();
        }catch (Exception e){
            System.out.println("byID failed to return.Returned NULL instead");
            return null;
        }
    }
    public ResultSet byLastID(){
        String toID="select * from course where id=(select max(id) from course)";
        execute(toID);
        try {
            return statement.getResultSet();
        }catch (Exception e){
            System.out.println("byID failed to return.Returned NULL instead");
            return null;
        }
    }
    public int lastID(){
        ResultSet set=byLastID();
        List<Course> courses = new ArrayList<>();
        try {
            while (set.next()){
                Course c = new Course(
                        set.getInt(1),
                        set.getString(2),
                        set.getString(3)
                );
                courses.add(c);
            }
        }catch (Exception e){
            System.out.println("Error on allCourseList");
        }
        return courses.get(0).getId();
    }

    public List<Course> allCourseList(){
        ResultSet set=allCourse();
        List<Course> courses = new ArrayList<>();
        try {
            while (set.next()){
                Course c = new Course(
                        set.getInt(1),
                        set.getString(2),
                        set.getString(3)
                );
                courses.add(c);
            }
        }catch (Exception e){
            System.out.println("Error on allCourseList");
        }
        return courses;
    }
    public Course getCourse(int id){
        ResultSet set=byID(id);
        List<Course> courses = new ArrayList<>();
        try {
            while (set.next()){
                Course c = new Course(
                        set.getInt(1),
                        set.getString(2),
                        set.getString(3)
                );
                courses.add(c);
            }
        }catch (Exception e){
            System.out.println("Error on allCourseList");
        }
        return courses.get(0);
    }

    //CRUD
    public boolean add(Course c){
        String insertTO="insert into course (name, department) VALUES ";
        insertTO+=String.format("('%s','%s');",c.getName(),c.getDepartment());
        return execute(insertTO);
    }
    public boolean updateCourseName(int id, String newCourseName){
        String update = "update course set name='"+newCourseName+"' where id="+id;
        return execute(update);
    }
    public boolean updateDepartmentName(int id, String newDepartmentName){
        String update="update course set department='"+newDepartmentName+"' where id="+id;
        return execute(update);
    }
    public boolean delete(int id){
        String del ="delete course from course where id="+id;
        return execute(del);
    }
}
