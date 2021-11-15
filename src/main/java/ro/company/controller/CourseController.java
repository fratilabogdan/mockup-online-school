package ro.company.controller;

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
        return courseRepository.add(c);

    }
    public boolean delete(int id){
        return courseRepository.delete(id);
    }

    //Utility
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
}
