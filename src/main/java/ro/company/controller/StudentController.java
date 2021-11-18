package ro.company.controller;

import com.mysql.cj.util.StringUtils;
import ro.company.model.Course;
import ro.company.model.Enrolment;
import ro.company.model.Student;
import ro.company.repository.StudentRepository;

import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        if(validMail(student.getEmail())&& 18<student.getAge() && student.getAge()<99){
            return studentRepository.add(student);
        }
        return false;
    }
    public boolean delete(int id){
        if(!containsID(id)){
            return false;
        }
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
        if(!getStudent(id).getEmail().equals(newMail) && validMail(newMail)){
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
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(mail);
        if(matcher.matches()){
            return true;
        }
        return false;
    }

    public StudentRepository getStudentRepository() {
        return studentRepository;
    }

    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
