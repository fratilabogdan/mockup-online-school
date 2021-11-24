package ro.company.controller;

import org.junit.jupiter.api.Test;
import ro.company.model.Student;

import static org.junit.jupiter.api.Assertions.*;

class StudentControllerTest {
    @Test
    public void testValidMailTrue(){
        StudentController studentController = new StudentController();
        String text = "true@mail.com";
        assertEquals(true, studentController.validMail(text));
    }
    @Test
    public void testValidMailFalse(){
        StudentController studentController = new StudentController();
        String text = "false#mail.com";
        assertEquals(false, studentController.validMail(text));
    }

    @Test
    public void testAddStudentTrue(){
        StudentController studentController = new StudentController();
        Student student = new Student("Add F Test", " Add L test", "mail@test.com", 55);
        assertEquals(true, studentController.add(student));
        studentController.delete(studentController.lastID());
    }
    @Test
    public void testAddStudentFalse(){
        StudentController studentController = new StudentController();
        Student student = new Student("Add F Test", " Add L test", "mailFalse#test.com", 55);
        assertEquals(false, studentController.add(student));
    }
    @Test
    public void testUpdateFNameTrue(){
        StudentController studentController = new StudentController();
        Student student = new Student("Add F Test", " Add L test", "mailFalse#test.com", 55);
        int i= studentController.lastID();
    }

}