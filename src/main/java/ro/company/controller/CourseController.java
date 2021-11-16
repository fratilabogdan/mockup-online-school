package ro.company.controller;

import ro.company.model.Book;
import ro.company.model.Course;
import ro.company.repository.CourseRepository;

import java.util.Iterator;
import java.util.List;

public class CourseController {
    CourseRepository courseRepository;
    List<Course> courseList;

    public CourseController(){
        CourseRepository courseRepository = new CourseRepository();
        this.courseRepository=courseRepository;
        this.courseList=courseRepository.allCourseList();
    }

    //CRUD
    public boolean add(Course c){
        if(duplicate(c)){
            return false;
        }
        return courseRepository.add(c);
    }
    public boolean updateCourseName(int id, String newName){
        Course course = new Course(newName,"Dep1");
        if(duplicate(course)){
            return false;
        }
        return courseRepository.updateCourseName(id,newName);
    }
    public boolean updateDepartmentName(int id, String newName){
        Course courseD = new Course("C name",newName);
        if(duplicate(courseD)){
            return false;
        } else if(courseRepository.getCourse(id).getDepartment().equals(newName)){
            return false;
        }
        return courseRepository.updateDepartmentName(id,newName);
    }
    public boolean delete(int id){
        if(containsID(id)==false){
            return false;
        }
        return courseRepository.delete(id);
    }

    //Utility
    public Course getCourse(int id){
        return courseRepository.getCourse(id);
    }
    public boolean duplicate(Course course){
        if(nbOfDuplicates(course)>=2){
            return true;
        }
        return false;
    }
    public int nbOfDuplicates(Course c){
        int count=1;
        Iterator<Course> it = courseRepository.allCourseList().iterator();
        while (it.hasNext()){
            Course course = it.next();
            if(course.getName().equals(c.getName())){
                count++;
            }
        }
        return count;
    }
    public int lastID(){
        return courseRepository.lastID();
    }
    public boolean removeDuplicates(){
        int count=0;
        Iterator<Course> it = courseRepository.allCourseList().iterator();
        while (it.hasNext()){
            Course c = it.next();
            if(nbOfDuplicates(c)>=3){
                count++;
                courseRepository.delete(c.getId());
            }
        }
        if(count>=1){
            System.out.println("Total duplicates removed: "+count);
            return true;
        }
        System.out.println("Total duplicates removed: "+count);
        return false;
    }
    public boolean containsID(int id){
        Iterator<Course> it = courseRepository.allCourseList().iterator();
        while (it.hasNext()){
            Course bk = it.next();
            if(bk.getId()==id){
                return true;
            }
        }
        return false;
    }
}
