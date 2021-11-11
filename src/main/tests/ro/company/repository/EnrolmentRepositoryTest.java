package ro.company.repository;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ro.company.model.Enrolment;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class EnrolmentRepositoryTest {
    @Test
    public void testGetEnrolmentTrue(){
        EnrolmentRepository enrolmentRepository = new EnrolmentRepository();
        enrolmentRepository.add(new Enrolment(55,55,LocalDateTime.now()));
        int initial = enrolmentRepository.lastID();
        assertEquals(true, enrolmentRepository.getEnrolment(initial).getId()== enrolmentRepository.lastID());
        enrolmentRepository.delete(initial);
    }
    @Test
    public void testGetEnrolmentFalse(){
        EnrolmentRepository enrolmentRepository = new EnrolmentRepository();
        enrolmentRepository.add(new Enrolment(55,55,LocalDateTime.now()));
        int initial = enrolmentRepository.lastID();
        assertEquals(false, enrolmentRepository.getEnrolment(initial).getId()!= enrolmentRepository.lastID());
        enrolmentRepository.delete(initial);
    }
    @Test
    public void  testAddTrue(){
        EnrolmentRepository enrolmentRepository = new EnrolmentRepository();
        assertEquals(true, enrolmentRepository.add(new Enrolment(5,5,LocalDateTime.now())));
        enrolmentRepository.delete(enrolmentRepository.lastID());
    }
    @Test
    public void testAllEnrolmentTrue(){
        EnrolmentRepository enrolmentRepository = new EnrolmentRepository();
        enrolmentRepository.add(new Enrolment(55,55,LocalDateTime.now()));
        int initial = enrolmentRepository.lastID();
        assertEquals(true, enrolmentRepository.allEnrolment()!=null);
        enrolmentRepository.delete(initial);
    }
    @Test
    public void testAllEnrolmentFalse(){
        EnrolmentRepository enrolmentRepository = new EnrolmentRepository();
        enrolmentRepository.add(new Enrolment(55,55,LocalDateTime.now()));
        int initial = enrolmentRepository.lastID();
        assertEquals(false, enrolmentRepository.allEnrolment()==null);
        enrolmentRepository.delete(initial);
    }

    @Test
    public void testAllEnrolmentListTrue(){
        EnrolmentRepository enrolmentRepository = new EnrolmentRepository();
        enrolmentRepository.add(new Enrolment(55,55,LocalDateTime.now()));
        int initial = enrolmentRepository.lastID();
        assertEquals(true, enrolmentRepository.allEnrolmentList()!=null);
        enrolmentRepository.delete(initial);
    }
    @Test
    public void testLastIDTrue(){
        EnrolmentRepository enrolmentRepository = new EnrolmentRepository();
        enrolmentRepository.add(new Enrolment(55,55,LocalDateTime.now()));
        int initial = enrolmentRepository.lastID();
        assertEquals(true, enrolmentRepository.lastID()==initial);
        enrolmentRepository.delete(initial);
    }
    @Test
    public void testLastIDFalse(){
        EnrolmentRepository enrolmentRepository = new EnrolmentRepository();
        LocalDateTime t = LocalDateTime.now();
        int initial = enrolmentRepository.lastID();
        enrolmentRepository.add(new Enrolment(1,1, t));
        assertEquals(false, enrolmentRepository.lastID()==initial);
    }
    @Test
    public void testUpdateCourseIDTrue(){
        EnrolmentRepository enrolmentRepository = new EnrolmentRepository();
        int initial = enrolmentRepository.lastID();
        int courseID = enrolmentRepository.getEnrolment(initial).getCourseID();
        enrolmentRepository.updateCourseID(initial, courseID+1);
        assertEquals(true, enrolmentRepository.getEnrolment(initial).getCourseID()!=courseID);
    }
    @Test
    public void testUpdateCourseIDFalse(){
        EnrolmentRepository enrolmentRepository = new EnrolmentRepository();
        int initial = enrolmentRepository.lastID();
        int courseID = enrolmentRepository.getEnrolment(initial).getCourseID();
        enrolmentRepository.updateCourseID(initial, courseID+1);
        assertEquals(false, enrolmentRepository.getEnrolment(initial).getCourseID()==courseID);
    }
    @Test
    public void testUpdateStudentIDTrue(){
        EnrolmentRepository enrolmentRepository = new EnrolmentRepository();

        int initial = enrolmentRepository.lastID();
        int studentID = enrolmentRepository.getEnrolment(initial).getStudentID();
        enrolmentRepository.updateStudentID(initial, studentID +1);
        assertEquals(true, enrolmentRepository.getEnrolment(initial).getStudentID()!= studentID);
    }
    @Test
    public void testUpdateStudentIDFalse(){
        EnrolmentRepository enrolmentRepository = new EnrolmentRepository();
        int initial = enrolmentRepository.lastID();
        int studentID = enrolmentRepository.getEnrolment(initial).getStudentID();
        enrolmentRepository.updateStudentID(initial, studentID +1);
        assertEquals(false, enrolmentRepository.getEnrolment(initial).getStudentID()== studentID);
    }
    @Test
    public void testUpdateCreatedAtTrue(){
        EnrolmentRepository enrolmentRepository = new EnrolmentRepository();
        int initial = enrolmentRepository.lastID();
        LocalDateTime t = enrolmentRepository.getEnrolment(initial).getCreatedAt();
        enrolmentRepository.updateCreatedAt(initial, LocalDateTime.now());
        assertEquals(true, enrolmentRepository.getEnrolment(initial).getCreatedAt()!=t);
    }
    @Test
    public void testUpdateCreatedAtFalse(){
        EnrolmentRepository enrolmentRepository = new EnrolmentRepository();
        int initial = enrolmentRepository.lastID();
        enrolmentRepository.updateCreatedAt(initial, LocalDateTime.now());
        assertEquals(false, enrolmentRepository.getEnrolment(initial).getCreatedAt().equals(LocalDateTime.now()));
    }
    @Test
    public void testDeleteTrue(){
        EnrolmentRepository enrolmentRepository = new EnrolmentRepository();
        assertEquals(true, enrolmentRepository.delete(enrolmentRepository.lastID()));
    }






}