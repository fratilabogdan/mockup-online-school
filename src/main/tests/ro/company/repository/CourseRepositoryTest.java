package ro.company.repository;

import org.junit.jupiter.api.Test;
import ro.company.model.Course;

import static org.junit.jupiter.api.Assertions.*;

class CourseRepositoryTest {
    @Test
    public void testGetCourseTrue(){
        CourseRepository courseRepository = new CourseRepository();
        assertEquals(true, courseRepository.getCourse(1).getId()==1);
    }

    public void testGetCourseFalse(){
        CourseRepository courseRepository = new CourseRepository();
        assertEquals(false, courseRepository.getCourse(1000).getId()==1);
    }
    @Test
    public void testAllCourseTrue(){
        CourseRepository courseRepository = new CourseRepository();
        assertEquals(true, courseRepository.allCourse()!=null);
    }
    @Test
    public void testAllCourseFalse(){
        CourseRepository courseRepository = new CourseRepository();
        assertEquals(false, courseRepository.allCourse()==null);
    }
    @Test
    public void testAllCourseListTrue(){
        CourseRepository courseRepository = new CourseRepository();
        assertEquals(true, courseRepository.allCourseList()!=null);
    }
    @Test
    public void testAllCourseListFalse(){
        CourseRepository courseRepository = new CourseRepository();
        assertEquals(false,courseRepository.allCourseList()==null);
    }
    @Test
    public void testAdd(){
        CourseRepository courseRepository = new CourseRepository();
        courseRepository.add(new Course(206,"Course Test", "Department Test"));
        int i= courseRepository.lastID();
        assertEquals(true, courseRepository.getCourse(i).getId()==i);
        courseRepository.delete(i);
    }
    @Test
    public void testUpdateCourseNameTrue(){
        CourseRepository courseRepository = new CourseRepository();
        courseRepository.add(new Course("Course Test", "Department Test"));
        int id = courseRepository.lastID();
        courseRepository.updateCourseName(id,"Course Name Test2");
        assertEquals(true,courseRepository.getCourse(id).getName().equals("Course Name Test2"));
    }
    @Test
    public void testUpdateCourseNameFalse(){
        CourseRepository courseRepository = new CourseRepository();
        courseRepository.add(new Course("Course Test", "Department Test"));
        int id = courseRepository.lastID();
        courseRepository.updateCourseName(id,"Course Name Test2");
        assertEquals(false,courseRepository.getCourse(id).getName().equals("Course Test"));
    }
    @Test
    public void testUpdateDepartmentNameTrue(){
        CourseRepository courseRepository = new CourseRepository();
        courseRepository.add(new Course("Course Test", "Department Test"));
        int id = courseRepository.lastID();
        courseRepository.updateDepartmentName(id,"Department Name Test2");
        assertEquals(true,courseRepository.getCourse(id).getDepartment().equals("Department Name Test2"));
    }
    @Test
    public void testUpdateDepartmentNameFalse(){
        CourseRepository courseRepository = new CourseRepository();
        courseRepository.add(new Course("Course Test", "Department Test"));
        int id = courseRepository.lastID();
        courseRepository.updateDepartmentName(id,"Department Name Test2");
        assertEquals(false,courseRepository.getCourse(id).getDepartment().equals("Department Name Test"));
    }
    @Test
    public void testDeleteTrue(){
        CourseRepository courseRepository = new CourseRepository();
        courseRepository.add(new Course("Course Test Del", "Department Test Del"));
        int id=courseRepository.lastID();
        courseRepository.delete(id);
        assertEquals(true, courseRepository.getCourse(courseRepository.lastID()).getId()!=id);
    }
    @Test
    public void testDeleteFalse(){
        CourseRepository courseRepository = new CourseRepository();
        courseRepository.add(new Course("Course Test Del", "Department Test Del"));
        int id=courseRepository.lastID();
        courseRepository.delete(id);
        assertEquals(false, courseRepository.getCourse(courseRepository.lastID()).getId()==id);
    }

}