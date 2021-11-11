package ro.company.repository;
import ro.company.helpers.Helpers;
import ro.company.model.Enrolment;
import java.sql.Connection;
import java.sql.Statement;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EnrolmentRepository {
    private String jdbcURL="jdbc:mysql://localhost:3306/online_school_db";
    private String username="root";
    private String password="root";

    private Connection connection=null;
    private Statement statement=null;

    public EnrolmentRepository(){
        try {
            connection=DriverManager.getConnection(jdbcURL,username,password);
            statement=connection.createStatement();
        }catch (SQLException e){
            System.out.println("Eroare conectare la baza de date. EnrolmentRepistory");
        }
    }
    private boolean execute(String execute){
        try {
            statement.execute(execute);
            return true;
        } catch (SQLException e){
            System.out.println("Nu a mers executat \n"+execute);
            return false;
        }
    }

    //Utility
    public ResultSet allEnrolment(){
        execute("select*from enrolment");
        try {
            return statement.getResultSet();
        }catch (Exception e){
            System.out.println("ResultSet failed to return. Returned NULL instead");
            return null;
        }
    }


    public List<Enrolment> allEnrolmentList(){
        ResultSet set = allEnrolment();

        List<Enrolment> enrolments = new ArrayList<>();
        try {
            while (set.next()){
                Enrolment en = new Enrolment(
                        set.getInt(1),
                        set.getInt(2),
                        set.getInt(3),
                        set.getTimestamp(4).toLocalDateTime()
                );
                enrolments.add(en);
            }
        }catch (Exception e){
            System.out.println("Error on allEnrolmentList");
        }
        return enrolments;
    }
    public Enrolment getEnrolment(int id){
        ResultSet set=byID(id);
        List<Enrolment> enrolments = new ArrayList<>();
        try {
            while (set.next()){
                Enrolment en = new Enrolment(
                        set.getInt(1),
                        set.getInt(2),
                        set.getInt(3),
                        set.getTimestamp(4).toLocalDateTime()
                );
                enrolments.add(en);

            }
            return enrolments.get(0);
        }catch (Exception e){
         e.printStackTrace();

            return null;
        }

    }

    public ResultSet byID(int id){
        String toID="select*from enrolment where id="+id;
        execute(toID);
        try {
            return statement.getResultSet();
        }catch (Exception e){
            System.out.println("byID failed to return.Returned NULL instead");
            return null;
        }
    }
    public ResultSet byLastID(){
        String toID="select * from enrolment where id=(select max(id) from enrolment)";
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
        List<Enrolment> enrolments = new ArrayList<>();
        try {
            while (set.next()){
                Enrolment c = new Enrolment(
                        set.getInt(1),
                        set.getInt(2),
                        set.getInt(3),
                        set.getTimestamp(4).toLocalDateTime()
                );
                enrolments.add(c);
            }
        }catch (Exception e){
            System.out.println("Error on lastID");
        }
        return enrolments.get(0).getId();
    }

    //CRUD
    public boolean add(Enrolment e){
        String instertTO="insert into enrolment (student_id, course_id, created_at) values";
        instertTO+=String.format("(%d,%d,'%s');",e.getStudentID(),e.getCourseID(),Helpers.localDateSQLconvert(e.getCreatedAt()));
        return execute(instertTO);
    }
    public boolean updateCourseID(int id, int newCourseID){
        String update="update enrolment set course_id="+newCourseID+" where id="+id;
        return execute(update);
    }
    public boolean updateStudentID(int id, int newStudentID){
        String update="update enrolment set student_id="+newStudentID+" where id="+id;
        return execute(update);
    }
    public boolean updateCreatedAt(int ID, LocalDateTime newDate){
        String update="update enrolment set created_at='"+Helpers.localDateSQLconvert(newDate)+"' where id="+ ID;
        return execute(update);
    }
    public boolean delete(int id){
            String del ="delete enrolment from enrolment where id="+id;
            return execute(del);
    }

}
