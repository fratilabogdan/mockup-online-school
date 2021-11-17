package ro.company.controller;

import com.mysql.cj.util.StringUtils;
import ro.company.model.Course;
import ro.company.model.Enrolment;
import ro.company.model.Student;
import ro.company.repository.StudentRepository;

import java.util.Iterator;
import java.util.List;

//Problem at end

public class StudentController {
    StudentRepository studentRepository;
    List<Student> studentList;

    public StudentController(){
        StudentRepository studentRepository = new StudentRepository();
        this.studentRepository=studentRepository;
        this.studentList=studentRepository.allStudentList();

    }

    //CRUD
    public boolean add(Student student){
        return studentRepository.add(student);
    }
    public boolean delete(int id){
        return studentRepository.delete(id);
    }
    public boolean updateFirstName(int id, String newName){
        if(getStudent(id).getFirstName().equals(newName)==false){
            return studentRepository.updateFirstName(id,newName);
        }
        return false;
    }
    public boolean updateLastName(int id, String newName){
        if(getStudent(id).getLastName().equals(newName)==false){
            return studentRepository.updateFirstName(id,newName);
        }
        return false;
    }
    public boolean updateEmail(int id, String newMail){
        if(getStudent(id).getEmail().equals(newMail)==false){
            return studentRepository.updateFirstName(id,newMail);
        }
        return false;
    }


    //UTILITY
    public Student getStudent(int id){
        if(containsID(id)){
            return studentRepository.getStudent(id);
        }
        return null;
    }
    public int lastID(){
        return studentRepository.lastID();
    }
    public int nbOfDuplicates(Student student){
        int count=1;
        Iterator<Student> it = studentRepository.allStudentList().iterator();
        while (it.hasNext()){
            Student st = it.next();
            if(student.getId()==st.getId()){
                count++;
            }
        }
        return count;
    }
    public boolean duplicate(Student student){
        if(nbOfDuplicates(student)>=2){
            return true;
        }
        return false;
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
    public boolean validMail(String mail){
        if(mail.contains(" ")){
            return false;
        }
//        StringUtils.endsWith(".com");
        for(int i=0;i<mail.length();i++){
            if(mail.charAt(i)=='@'){

            }
        }
        return false;
    }
}
