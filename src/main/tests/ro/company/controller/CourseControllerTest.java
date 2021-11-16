package ro.company.controller;

import org.junit.jupiter.api.Test;
import ro.company.model.Course;

import static org.junit.jupiter.api.Assertions.*;

//Problema la remove all Duplicates

class CourseControllerTest {
    @Test
    public void testNbDuplicates(){
        CourseController courseController = new CourseController();
        Course course = new Course("Test nb dupes","C2");
        courseController.add(course);
        int i= courseController.lastID();
        assertEquals(2,courseController.nbOfDuplicates(course));
        courseController.delete(i);
    }
    @Test
    public void testDuplicateTrue(){
        CourseController courseController = new CourseController();
        Course course = new Course("Test Dupe True","C2");
        courseController.add(course);
        int i= courseController.lastID();
        assertEquals(true,courseController.duplicate(course));
        courseController.delete(i);
    }
    @Test
    public void testDuplicateFalse(){
        CourseController courseController = new CourseController();
        Course course = new Course("Test Dupe False","C2");
        courseController.add(course);
        int i= courseController.lastID();
        courseController.delete(i);
        System.out.println(courseController.nbOfDuplicates(course));
        assertEquals(false,courseController.duplicate(course));
    }
    @Test
    public void testAddTrue(){
        CourseController courseController = new CourseController();
        Course course = new Course("Test Add True","C2");
        assertEquals(true,courseController.add(course));
        courseController.delete(courseController.lastID());
    }
    @Test
    public void testAddFalse(){
        CourseController courseController = new CourseController();
        Course course = new Course("Test Add False","C2");
        courseController.add(course);
        assertEquals(false,courseController.add(course));
        courseController.delete(courseController.lastID());
    }
    @Test
    public void testUpdateCourseNameTrue(){
        CourseController courseController = new CourseController();
        String newName = "Test Update Name True";
        Course course = new Course(newName,"Dep1");
        courseController.add(course);
        int id= courseController.lastID();
        newName+=1;
        assertEquals(true, courseController.updateCourseName(id, newName));
        courseController.delete(id);
    }
    @Test
    public void testUpdateCourseNameFalse(){
        CourseController courseController = new CourseController();
        String newName = "Test Update Name False";
        Course course = new Course(newName,"Dep1");
        courseController.add(course);
        int id= courseController.lastID();
        assertEquals(false, courseController.updateCourseName(id, newName));
        courseController.delete(id);
    }
    @Test
    public void testUpdateDepartmentNameTrue(){
        CourseController courseController = new CourseController();
        String newName = "Test Update DepName True";
        Course course = new Course("Course Dep",newName);
        courseController.add(course);
        int id= courseController.lastID();
        newName+=1;
        assertEquals(true, courseController.updateDepartmentName(id, newName));
        courseController.delete(id);
    }
    @Test
    public void testUpdateDepartmentNameFalse(){
        CourseController courseController = new CourseController();
        String newName = "Test Update DepName True";
        Course course = new Course("Course Dep",newName);
        courseController.add(course);
        int id= courseController.lastID();
        assertEquals(false, courseController.updateDepartmentName(id, newName));
        courseController.delete(id);
    }
    @Test
    public void testDuplicateRemoves(){
        CourseController courseController = new CourseController();
        assertEquals(false, courseController.removeDuplicates());
    }
    @Test
    public void testDeleteTrue(){
        CourseController courseController = new CourseController();
        String newName = "Test Delete True";
        Course course = new Course("Course Dep",newName);
        courseController.add(course);
        int id= courseController.lastID();
        assertEquals(true, courseController.delete(id));
    }
    @Test
    public void testDeleteFalse(){
        CourseController courseController = new CourseController();
        String newName = "Test Delete True";
        Course course = new Course("Course Dep",newName);
        courseController.add(course);
        int id= courseController.lastID();
        courseController.delete(id);
        assertEquals(false, courseController.delete(id));
    }

}