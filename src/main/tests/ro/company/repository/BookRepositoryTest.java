package ro.company.repository;

import org.junit.jupiter.api.Test;
import ro.company.model.Book;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookRepositoryTest {
    @Test
    public void testGetBookTrue(){
        BookRepository bookRepository = new BookRepository();
        Book book = new Book(1,"Repo add book", LocalDateTime.now());
        bookRepository.add(book);
        int i= bookRepository.lastID();
        assertEquals(true, bookRepository.getBook(i).getId()==i);
        bookRepository.delete(i);
    }
    @Test
    public void testAllBooksTrue(){
        BookRepository bookRepository = new BookRepository();
        assertEquals(true, bookRepository.allBooks()!=null);
    }
    @Test
    public void testAllBooksListTrue(){
        BookRepository bookRepository= new BookRepository();
        assertEquals(true, bookRepository.allBooksList()!=null);
    }

    @Test
    public void testAddTrue(){
        BookRepository bookRepository = new BookRepository();
        bookRepository.add(new Book(1,"Book Test True", LocalDateTime.of(1990,10,10,10,10,10)));

        assertEquals(true, bookRepository.getBook(bookRepository.lastID()).getBookName().equals("Book Test True"));

    }

    @Test
    public void testAddFalse(){
        BookRepository bookRepository = new BookRepository();
        assertEquals(false, bookRepository.add(new Book(2444,244,"Book Test False", LocalDateTime.of(1990,10,10,10,10,10))));
    }

    @Test
    public void testUpdateStudentIDTrue(){
        BookRepository bookRepository = new BookRepository();
        Book book = new Book(1,"Repo add book", LocalDateTime.now());
        bookRepository.add(book);
        int i= bookRepository.lastID();
        bookRepository.updateStudentID(i,50);
        assertEquals(true, bookRepository.getBook(i).getStudentID()==50);
        bookRepository.delete(i);
    }
    @Test
    public void testUpdateBookNameTrue(){
        BookRepository bookRepository = new BookRepository();
        assertEquals(true, bookRepository.updateBookName(1, "New Name Book"));
    }

    @Test
    public void testUpdateBookNameFalse(){
        BookRepository bookRepository = new BookRepository();
        assertEquals(false, bookRepository.updateBookName(11244,"New' ' name book'"));
    }

    @Test
    public void testUpdateCreatedAtTrue(){
        BookRepository bookRepository = new BookRepository();
        assertEquals(true, bookRepository.updateCreatedAt(1, LocalDateTime.of(1991,10,10,10,10,10)));
    }

    @Test
    public void testUpdateCreatedAtFalse(){
        BookRepository bookRepository = new BookRepository();
        LocalDateTime t = LocalDateTime.now();
        bookRepository.add(new Book(1,"BookTest",t));
        int id = bookRepository.lastID();
        bookRepository.updateCreatedAt(id,  LocalDateTime.of(1991,10,10,10,10,10));
        assertEquals(false, bookRepository.getBook(id).getCreatedAT().equals(t));
    }

    @Test
    public void testDeleteTrue(){
        BookRepository bookRepository = new BookRepository();
        int i=bookRepository.lastID();
        bookRepository.add(new Book(i,1,"Book Test True", LocalDateTime.of(1990,10,10,10,10,10)));
        bookRepository.delete(i);
        assertEquals(false, bookRepository.lastID()==i);
    }



}