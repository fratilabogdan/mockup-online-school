package ro.company.controller;

import ro.company.repository.BookRepository;
import ro.company.model.Book;
import ro.company.repository.StudentRepository;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

public class BookController {
    BookRepository bookRepository;
    List<Book> bookList;


    public BookController() {
        BookRepository bookRepository = new BookRepository();
        this.bookRepository = bookRepository;
        this.bookList = bookRepository.allBooksList();
    }

    //CRUD
    public boolean add(Book b){
        if(b.getId()!=(lastID()+1)){
            System.out.println("ID incorrect. Available is "+(lastID()+1));
            return false;
        }
        return bookList.add(b);
    }
    public boolean updateStudentID(int id, int newStudentID){
        bookList.get(id).setStudentID(newStudentID);
        return bookList.get(id).getStudentID()==newStudentID;
    }
    public boolean updateBookName(int id, String newBookName){
        bookList.get(id).setBookName(newBookName);
        return bookList.get(id).getBookName().equals(newBookName);
    }
    public boolean updateCreatedAt(int id, LocalDateTime newDate){
        bookList.get(id).setCreatedAT(newDate);
        return bookList.get(id).getCreatedAT().equals(newDate);
    }
    public boolean delete(int id){
        bookList.remove(id);
        return bookList.get(id)==null;
    }

    //Utility
    public Book getBook(int id){
        if(id>lastID()){
            return null;
        }

        Iterator<Book> it = bookList.iterator();
        Book b = it.next();

        while (it.hasNext()&&b.getId()!=id){
            b=it.next();
        }
        if(b.getId()==id){
            return b;
        }
        return null;
    }

    //Probleme
    public int lastID(){
        int last = 0;
        Iterator<Book> it = bookList.iterator();
        while (it.hasNext()){
            last=it.next().getId();
        }
        return last;
    }

}
