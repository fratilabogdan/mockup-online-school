package ro.company.repository;

import org.junit.jupiter.api.Test;
import ro.company.model.Enrolment;

import static org.junit.jupiter.api.Assertions.*;

class EnrolmentRepositoryTest {
    @Test
    public void testGetEnrolmentTrue(){
        EnrolmentRepository enrolmentRepository = new EnrolmentRepository();
        assertEquals(true, enrolmentRepository.getEnrolment(1).getCourseID()==1);
    }
    @Test
    public void testAllEnrolmentTrue(){
        EnrolmentRepository enrolmentRepository = new EnrolmentRepository();
        assertEquals(true, enrolmentRepository.allEnrolment()!=null);
    }
    @Test
    public void testAllEnrolmentFalse(){
        EnrolmentRepository enrolmentRepository = new EnrolmentRepository();
        assertEquals(false, enrolmentRepository.allEnrolment()==null);
    }

    @Test
    public void testAllEnrolmentListTrue(){
        EnrolmentRepository enrolmentRepository = new EnrolmentRepository();
        assertEquals(true, enrolmentRepository.allEnrolmentList()!=null);
    }

    @Test
    public void test



}