package ro.company.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ro.company.model.Book;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class BookControllerTest {
    @Test
    public void testLastID(){
        BookController bookController = new BookController();
        bookController.add(new Book(1,"t",LocalDateTime.now()));
        int i= bookController.lastID();
        bookController.add(new Book(1,"t",LocalDateTime.now()));
        int i2=bookController.lastID();
        assertEquals(i2, bookController.lastID());
    }
    @Test
    public void testGetBookTrue(){
        BookController bookController = new BookController();
        assertEquals(true, bookController.getBook(1).getBookName()!=null);
    }
    @Test
    public void testAddTrue(){
        BookController bookController = new BookController();
        assertEquals(true, bookController.add(new Book(bookController.lastID()+1, 1,"BookTest", LocalDateTime.now())));
    }
    @Test
    public void testUpdateStudentIDTrue(){
        BookController bookController = new BookController();
        bookController.updateStudentID(1, 2);
        assertEquals(true, bookController.getBook(1).getStudentID()==2);
    }
    @Test
    public void testUpdateBookNameTrue(){
        BookController bookController = new BookController();
        bookController.add(new Book(1,"Update",LocalDateTime.now()));
        bookController.updateBookName(bookController.lastID(), "Test");
        System.out.println(bookController.getBook(bookController.lastID()).getBookName());
        assertEquals(true, bookController.getBook(bookController.lastID()).getBookName().equals("Test"));
        bookController.delete(bookController.lastID());
    }
    @Test
    public void testUpdateCreatedAtTrue(){
        BookController bookController = new BookController();
        LocalDateTime test = LocalDateTime.now();
        bookController.add(new Book(1,"Test Book Name",test));
        int initial = bookController.lastID();
        LocalDateTime updatedT = LocalDateTime.of(2012,12,12,12,12,12);
        bookController.updateCreatedAt(initial,updatedT);
        assertEquals(true, bookController.getBook(initial).getCreatedAT().equals(updatedT));
    }
    @Test
    public void testUpdateCreatedAtFalse(){
        BookController bookController = new BookController();
        LocalDateTime test = LocalDateTime.now();
        bookController.add(new Book(1,"Test Book Name",test));
        int initial = bookController.lastID();
        LocalDateTime updatedT = LocalDateTime.of(12,12,12,12,12,12);
        bookController.updateCreatedAt(initial,updatedT);
        assertEquals(false, bookController.getBook(initial).getCreatedAT().equals(updatedT));
    }
    @Test
    public void testDeleteTrue(){
        BookController bookController = new BookController();
        bookController.add(new Book(1,"TestName",LocalDateTime.now()));
        int id = bookController.lastID();
        assertEquals(bookController.lastID(), bookController.getBook(id).getId());
        bookController.delete(id);
    }
    @Test
    public void duplicateTrue(){
        BookController bookController = new BookController();
        bookController.add(new Book(1,"TestName",LocalDateTime.now()));
        Book b = new Book(1,"TestName",LocalDateTime.now());
        assertEquals(true, bookController.duplicate(b));
        bookController.delete(bookController.lastID());
    }
    @Test
    public void duplicateFalse(){
        BookController bookController = new BookController();
        bookController.add(new Book(1,"TestName",LocalDateTime.now()));
        Book b = new Book(1,"Test Name",LocalDateTime.now());
        assertEquals(false, bookController.duplicate(b));
        bookController.delete(bookController.lastID());
    }
    @Test
    public void testDuplicateRemoves(){
        BookController bookController = new BookController();
        bookController.removeDuplicates();
    }
    @Test
    public void testNbDuplicates(){
        BookController bookController = new BookController();
        bookController.add(new Book(1,"Killing",LocalDateTime.now()));
        Book book = new Book(1,"Killing2",LocalDateTime.now());
        System.out.println(bookController.nbOfDuplicates(book));
    }
}