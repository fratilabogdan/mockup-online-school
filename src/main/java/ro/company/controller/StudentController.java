package ro.company.controller;

import ro.company.model.Course;
import ro.company.model.Student;
import ro.company.repository.StudentRepository;

import java.util.Iterator;
import java.util.List;

public class StudentController {
    StudentRepository studentRepository;
    List<Student> studentList;

    public StudentController(){
        StudentRepository studentRepository = new StudentRepository();
        this.studentRepository=studentRepository;
        this.studentList=studentRepository.allStudentList();

    }



    public boolean containsID(int id){
        Iterator<Student> it = studentRepository.allStudentList().iterator();
        while (it.hasNext()){
            Student bk = it.next();
            if(bk.getId()==id){
                return true;
            }
        }
        return false;
    }
}
