package ro.company.repository;
import ro.company.helpers.Helpers;
import ro.company.model.Book;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class BookRepository {
    private String jdbcURL="jdbc:mysql://localhost:3306/online_school_db";
    private String username="root";
    private String password="root";

    private Connection connection=null;
    private Statement statement=null;

    public BookRepository(){
        try {
            connection=DriverManager.getConnection(jdbcURL,username,password);
            statement=connection.createStatement();
        }catch (SQLException e){
            System.out.println("Eroare conectare la baza de date. BookRepository");
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
    public ResultSet allBooks(){
        execute("select*from book");
        try {
            return statement.getResultSet();
        }catch (Exception e){
            System.out.println("ResultSet failed to return. Returned NULL instead");
            return null;
        }
    }
    public List<Book> allBooksList(){
        ResultSet set = allBooks();
        List<Book> books = new ArrayList<>();
        try {
            while (set.next()){
                Book b = new Book(
                        set.getInt(1),
                        set.getInt(2),
                        set.getString(3),
                        set.getTimestamp(4).toLocalDateTime()
                );
                books.add(b);
            }
        }catch (Exception e){
            System.out.println("Error on allBooksList");
        }
        return books;
    }


    public ResultSet byId(int id){
        String toID="select*from book where id="+id;
        execute(toID);
        try {
            return statement.getResultSet();
        }catch (Exception e){
            System.out.println("byID failed to return. Returned NULL instead");
            return null;
        }
    }


    public Book getBook(int id){
        ResultSet set = byId(id);
        List<Book> booksList = new ArrayList<>();
        try {
            while (set.next()){
                Book b = new Book(
                        set.getInt(1),
                        set.getInt(2),
                        set.getString(3),
                        set.getTimestamp(4).toLocalDateTime()
                );
                booksList.add(b);
            }
        }catch (Exception e){
            System.out.println("Error on allBooksList");
        }
        return booksList.get(0);
    }
    public ResultSet bookResultSet(int id){
        execute("select*from book where id="+id);
        try {
            return statement.getResultSet();
        }catch (Exception e){
            System.out.println("ResultSet failed to return. Returned NULL instead");
            return null;
        }
    }
    public ResultSet resultSetLastID(){
        execute("select * from book where id=(select max(id) from book)");
        try {
            return statement.getResultSet();
        }catch (Exception e){
            System.out.println("ResultSet failed to return. Returned NULL instead");
            return null;
        }
    }


    public int lastID(){
        ResultSet set = resultSetLastID();
        List<Book> booksList = new ArrayList<>();
        try {
            while (set.next()){
                Book b = new Book(
                        set.getInt(1),
                        set.getInt(2),
                        set.getString(3),
                        set.getTimestamp(4).toLocalDateTime()
                );
                booksList.add(b);
            }
        }catch (Exception e){
            System.out.println("Error on allBooksList");
        }
        return booksList.get(0).getId();
    }

    //CRUD
    public boolean add(Book b){
//        if(b.getId()>(allBooksList().size()+1)){
//            System.out.println("Book ID too high. Next free value is "+(allBooksList().size()+1));
//            return false;
//        }
        String insertTO="insert into book (student_id, book_name, created_at) values";
        insertTO+=String.format("(%d,'%s','%s');",b.getStudentID(),b.getBookName(), Helpers.localDateSQLconvert(b.getCreatedAT()));
        return execute(insertTO);
    }
    public boolean updateStudentID(int id,int newStudentID){

        String update="update book set student_id="+newStudentID+" where id="+id;

        return execute(update);
    }
    public boolean updateBookName(int id, String newBook){

        String update="update book set book_name='"+newBook+"' where id="+id;
        return execute(update);
    }
    public boolean updateCreatedAt(int id, LocalDateTime newDate){

        String update="update book set created_at='"+Helpers.localDateSQLconvert(newDate)+"' where id="+id;
        return execute(update);
    }

    //doesn't work
    public boolean delete(int id){
        String del="delete book from book where id="+id;
        return execute(del);
    }



}
