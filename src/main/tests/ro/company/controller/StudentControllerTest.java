package ro.company.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentControllerTest {
    @Test
    public void testValidMail(){
        StudentController studentController = new StudentController();
        String text = "asdsd@mail.com";
        assertEquals(true, studentController.validMail(text));
    }

}