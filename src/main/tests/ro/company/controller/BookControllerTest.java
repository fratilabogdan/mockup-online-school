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
        bookController.add(new Book(1,"tt",LocalDateTime.now()));
        int i= bookController.lastID();
        bookController.add(new Book(1,"ttt",LocalDateTime.now()));
        int i2=bookController.lastID();
        assertEquals(i2, bookController.lastID());
        bookController.delete(i);
        bookController.delete(i2);
    }
    @Test
    public void testGetBookTrue(){
        BookController bookController = new BookController();
        bookController.add(new Book(1,"t",LocalDateTime.now()));
        int i= bookController.lastID();
        assertEquals(true, bookController.getBook(i).getBookName()!=null);
        bookController.delete(i);
    }
    @Test
    public void testAddTrue(){
        BookController bookController = new BookController();
        assertEquals(true, bookController.add(new Book(1,"BookTest999", LocalDateTime.now())));
        bookController.delete(bookController.lastID());
    }
    @Test
    public void testAddFalse(){
        BookController bookController = new BookController();
        Book book = new Book(1,"Testing False",LocalDateTime.now());
        bookController.add(book);
        int i=bookController.lastID();
        System.out.println(i);
        System.out.println(book.getId());
        assertEquals(false, bookController.add(book));
        bookController.delete(i);
    }
    @Test
    public void testUpdateStudentIDTrue(){
        BookController bookController = new BookController();
        bookController.add(new Book(1,"tt",LocalDateTime.now()));
        int i= bookController.lastID();
        bookController.updateStudentID(i, 2);
        assertEquals(true, bookController.getBook(i).getStudentID()==2);
        bookController.delete(i);
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
        bookController.add(new Book(1,"Test Del True",LocalDateTime.now()));
        int id = bookController.lastID();
        assertEquals(true, bookController.delete(id));
    }
    @Test
    public void testDeleteFalse(){
        BookController bookController = new BookController();
        bookController.add(new Book(1,"Test Del False",LocalDateTime.now()));
        int id = bookController.lastID();
        bookController.delete(id);
        assertEquals(false, bookController.delete(id));
    }
    @Test
    public void testduplicateFalse(){
        BookController bookController = new BookController();
        bookController.add(new Book(1,"TestName",LocalDateTime.now()));
        Book b = new Book(1,"Test Name",LocalDateTime.now());
        assertEquals(false, bookController.duplicate(b));
        bookController.delete(bookController.lastID());
    }
    @Test
    public void testDuplicateRemoves(){
        BookController bookController = new BookController();
        assertEquals(false, bookController.removeDuplicates());
    }
    @Test
    public void testNbDuplicates(){
        BookController bookController = new BookController();
        Book book = new Book(1,"Killing2",LocalDateTime.now());
        bookController.add(book);
        int i=bookController.lastID();
        Book book2 = new Book(1,"Killing2",LocalDateTime.now());
        bookController.add(book2);
        int i2=bookController.lastID();
        assertEquals(2,bookController.nbOfDuplicates(book));
        assertEquals(2,bookController.nbOfDuplicates(book2));
        bookController.delete(i);
        bookController.delete(i2);
    }
}