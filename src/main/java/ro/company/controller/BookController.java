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
        return bookRepository.add(b);
    }
    public boolean updateStudentID(int id, int newStudentID){
        return bookRepository.updateStudentID(id,newStudentID);
    }
    public boolean updateBookName(int id, String newBookName){
        return bookRepository.updateBookName(id,newBookName);
    }
    public boolean updateCreatedAt(int id, LocalDateTime newDate){
        return bookRepository.updateCreatedAt(id, newDate);
    }
    public boolean delete(int id){



        bookList.remove(id);
        return bookList.get(id)==null;
    }

    //Utility
    public Book getBook(int id){
        return bookRepository.getBook(id);
    }

    //Probleme
    public int lastID(){

        return bookRepository.lastID();
    }

}
