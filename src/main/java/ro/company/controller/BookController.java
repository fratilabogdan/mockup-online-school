package ro.company.controller;

import ro.company.repository.BookRepository;
import ro.company.model.Book;
import ro.company.repository.StudentRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
        if(duplicate(b)){
            return false;
        } else if(b.getCreatedAT().getYear()<2000){
            System.out.println("Year cannot be earlier than 2000");
            return false;
        }
        return bookRepository.add(b);
    }
    public boolean updateStudentID(int id, int newStudentID){
        if(bookRepository.getBook(id).getStudentID()==newStudentID){
            System.out.println("Student ID already assigned to book");
            return false;
        }
        return bookRepository.updateStudentID(id,newStudentID);
    }
    public boolean updateBookName(int id, String newBookName){
        Book b = new Book(1,newBookName,LocalDateTime.now());
        if(duplicate(b)){
            return false;
        }
        return bookRepository.updateBookName(id,newBookName);
    }
    public boolean updateCreatedAt(int id, LocalDateTime newDate){
        if(newDate.getYear()<2000){
            System.out.println("Year cannot be earlier than 2000");
            return false;
        }
        return bookRepository.updateCreatedAt(id, newDate);
    }
    public boolean delete(int id){
        return bookRepository.delete(id);
    }

    //Utility
    public Book getBook(int id){
        return bookRepository.getBook(id);
    }
    public int lastID(){
        return bookRepository.lastID();
    }
    public boolean duplicate(Book book){
        if(nbOfDuplicates(book)>=1){
            return true;
        }
        return false;
    }
    public int nbOfDuplicates(Book b){
        int count=0;
        Iterator<Book> it = bookList.listIterator();
        while (it.hasNext()){
            Book bk = it.next();
            if(bk.getBookName().equals(b.getBookName())){
                count++;
            }
        }
        return count;
    }
    public void removeDuplicates(){
        int count=0;
        Iterator<Book> it = bookRepository.allBooksList().iterator();
        while (it.hasNext()){
            Book b = it.next();
            if(nbOfDuplicates(b)>=2){
                count++;
                bookRepository.delete(b.getId());
            }
        }
        System.out.println("Total duplicates removed: "+count);
    }

    //Control


}
