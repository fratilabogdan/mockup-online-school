package ro.company.controller;

import org.junit.jupiter.api.Test;
import ro.company.model.Book;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class BookControllerTest {
    @Test
    public void testLastID(){
        BookController bookController = new BookController();
        assertEquals(bookController.bookList.size(), bookController.lastID());
    }
    @Test
    public void testGetBookTrue(){
        BookController bookController = new BookController();

        assertEquals(true, bookController.getBook(1).getBookName()!=null);
    }
    @Test
    public void testGetBookFalse(){
        BookController bookController = new BookController();
        assertEquals(false, bookController.getBook(9999)!=null);
    }
    @Test
    public void testAddFalse(){
        BookController bookController = new BookController();
        assertEquals(false, bookController.add(new Book(88,1,"BookTest", LocalDateTime.now())));
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
        bookController.updateBookName(1,"Test");
        assertEquals(true, bookController.getBook(1).getBookName().equals("Test"));
    }
    @Test
    public void testUpdateCreatedAtTrue(){
        BookController bookController = new BookController();
        LocalDateTime test = LocalDateTime.now();
        bookController.updateCreatedAt(1,test);
        assertEquals(true, bookController.getBook(1).getCreatedAT().equals(test));
    }
    @Test
    public void testDeleteTrue(){
        BookController bookController = new BookController();
        int id = bookController.lastID()+1;
        bookController.add(new Book(id,1,"TestName",LocalDateTime.now()));
        assertEquals(bookController.lastID(), bookController.getBook(85).getId());
//        assertEquals(true,bookController.getBook(id).getBookName().equals("TestName"));
    }
}