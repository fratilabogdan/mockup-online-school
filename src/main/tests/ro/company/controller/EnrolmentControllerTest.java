package ro.company.controller;

import org.junit.jupiter.api.Test;
import ro.company.model.Enrolment;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

//can't add Enrolments

class EnrolmentControllerTest {
    @Test
    public void testNbDuplicates(){
        EnrolmentController enrolmentController = new EnrolmentController();
        Enrolment enrolment = new Enrolment(66,66, LocalDateTime.now());
        enrolmentController.add(enrolment);
        int i=enrolmentController.lastID();
        assertEquals(2,enrolmentController.nbOfDuplicates(enrolment));
        enrolmentController.delete(i);
    }

}