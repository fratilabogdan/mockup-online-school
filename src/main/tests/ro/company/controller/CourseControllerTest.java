package ro.company.controller;

import org.junit.jupiter.api.Test;
import ro.company.model.Course;

import static org.junit.jupiter.api.Assertions.*;

class CourseControllerTest {
    @Test
    public void testNbDuplicates(){
        CourseController courseController = new CourseController();
        Course course = new Course("C1","C2");
        int i= courseController.lastID();
        courseController.add(course);
        assertEquals(2,courseController.nbOfDuplicates(course));
        courseController.delete(i);
    }
    @Test
    public void testDuplicateTrue(){
        CourseController courseController = new CourseController();
        Course course = new Course("C1","C2");
        int i= courseController.lastID();
        courseController.add(course);
        assertEquals(true,courseController.duplicate(course));
        courseController.delete(i);
    }
    @Test
    public void testDuplicateFalse(){
        CourseController courseController = new CourseController();
        Course course = new Course("C12","C2");
        int i= courseController.lastID();
        courseController.add(course);
        courseController.delete(i);
        System.out.println(courseController.nbOfDuplicates(course));
        assertEquals(false,courseController.duplicate(course));
    }

}