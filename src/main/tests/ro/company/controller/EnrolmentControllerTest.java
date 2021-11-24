package ro.company.controller;

import org.junit.jupiter.api.Test;
import ro.company.model.Course;
import ro.company.model.Enrolment;
import ro.company.model.Student;
import java.util.List;

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
    @Test
    public void testAddEnrolment(){
        CourseController courseController = new CourseController();
        courseController.add(new Course("Course test","Department test"));
        int iC=courseController.lastID();
        StudentController studentController = new StudentController();
        studentController.add(new Student("F name test", "L name test", "email@test.com", 22));
        int iS=studentController.lastID();

        EnrolmentController enrolmentController = new EnrolmentController();
        Enrolment enrolment = new Enrolment(iS,iC, LocalDateTime.now());

        assertEquals(true,enrolmentController.add(enrolment));

        int i=enrolmentController.lastID();
        enrolmentController.delete(i);
        courseController.delete(iC);
        studentController.delete(iS);
    }
    @Test
    public void testShowStudentEnrolments(){
        CourseController courseController = new CourseController();
        courseController.add(new Course("Course test","Department test"));
        int iC=courseController.lastID();
        StudentController studentController = new StudentController();
        studentController.add(new Student("F name test", "L name test", "email@test.com", 22));
        int iS=studentController.lastID();

        EnrolmentController enrolmentController = new EnrolmentController();
        Enrolment enrolment = new Enrolment(iS,iC, LocalDateTime.now());
        enrolmentController.add(enrolment);

        List<Enrolment> list = enrolmentController.showAllEnrolmentsForStudent(iS);

        assertEquals(true, list.get(0).getStudentID()==iS && list.get(0).getCourseID()==iC);

        int i=enrolmentController.lastID();
        enrolmentController.delete(i);
        courseController.delete(iC);
        studentController.delete(iS);

    }
    @Test
    public void deleteEnrolmentTrue(){
        CourseController courseController = new CourseController();
        courseController.add(new Course("Course test","Department test"));
        int iC=courseController.lastID();
        StudentController studentController = new StudentController();
        studentController.add(new Student("F name test", "L name test", "email@test.com", 22));
        int iS=studentController.lastID();

        EnrolmentController enrolmentController = new EnrolmentController();
        Enrolment enrolment = new Enrolment(iS,iC, LocalDateTime.now());
        enrolmentController.add(enrolment);
        int id= enrolmentController.lastID();

        assertEquals(true,enrolmentController.delete(id));
        assertEquals(true, enrolmentController.getEnrolment(enrolmentController.lastID()).getStudentID()!=iS);

        enrolmentController.delete(id);
        courseController.delete(iC);
        studentController.delete(iS);
    }
    @Test
    public void deleteEnrolmentTrue2(){
        EnrolmentController enrolmentController = new EnrolmentController();
        int id=enrolmentController.lastID();
        Enrolment enrolment = enrolmentController.getEnrolment(id);
        System.out.println(enrolment.toString());
        enrolmentController.delete(id);

        id=enrolmentController.lastID();
        Enrolment enrolment2 = enrolmentController.getEnrolment(id);
        System.out.println(enrolment2.toString());
    }

}