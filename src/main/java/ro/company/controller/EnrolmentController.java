package ro.company.controller;

import ro.company.model.Course;
import ro.company.model.Enrolment;
import ro.company.repository.EnrolmentRepository;
import ro.company.repository.StudentRepository;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
public class EnrolmentController {
    EnrolmentRepository enrolmentRepository;
    List<Enrolment> enrolmentList;

    public EnrolmentController(){
        EnrolmentRepository enrolmentRepository = new EnrolmentRepository();
        this.enrolmentRepository=enrolmentRepository;
        this.enrolmentList= enrolmentRepository.allEnrolmentList();
    }

    //CRUD
    public boolean add(Enrolment e){
        if(validIDs(e)==true && duplicate(e)==false){
            return enrolmentRepository.add(e);
        }
        return false;
    }
    public boolean delete(int id){
        if(containsID(id)){
            return enrolmentRepository.delete(id);
        }
        return false;
    }
    public boolean updateStudentID(int id, int newStudentID){
        Enrolment enrolment = new Enrolment(1,1, LocalDateTime.now());
        enrolment=getEnrolment(id);
        enrolment.setStudentID(newStudentID);
        if(validIDs(getEnrolment(id))){
            return enrolmentRepository.updateStudentID(id,newStudentID);
        }
        return false;
    }
    public boolean updateCourseID(int id, int newCourseID){
        Enrolment enrolment = new Enrolment(1,1, LocalDateTime.now());
        enrolment=getEnrolment(id);
        enrolment.setCourseID(newCourseID);
        if(validIDs(getEnrolment(id))==true && duplicate(enrolment)==false){
            return enrolmentRepository.updateCourseID(id,newCourseID);
        }
        return false;
    }
    public boolean updateCreatedAt(int id, LocalDateTime newDate){
        Enrolment enrolment = new Enrolment(1,1, LocalDateTime.now());
        enrolment=getEnrolment(id);
        enrolment.setCreatedAt(newDate);
        if(validIDs(getEnrolment(id))==true && getEnrolment(id).getCreatedAt().equals(newDate)==false){
            return enrolmentRepository.updateCreatedAt(id,newDate);
        }
        return false;
    }

    //Utility
    public Enrolment getEnrolment(int id){
        if(containsID(id)){
            return enrolmentRepository.getEnrolment(id);
        }
        return null;
    }
    public int lastID(){
        return enrolmentRepository.lastID();
    }
    public int nbOfDuplicates(Enrolment e){
        int count=1;
        Iterator<Enrolment> it = enrolmentRepository.allEnrolmentList().iterator();
        while (it.hasNext()){
            Enrolment enrolment = it.next();
            if(enrolment.getStudentID()==e.getStudentID() && enrolment.getCourseID()==e.getCourseID()){
                count++;
            }
        }
        return count;
    }
    public boolean duplicate(Enrolment enrolment){
        if(nbOfDuplicates(enrolment)>=2){
            return true;
        }
        return false;
    }
    public boolean validIDs(Enrolment e){
        StudentController studentController = new StudentController();
        CourseController courseController = new CourseController();
        if(courseController.containsID(e.getCourseID()) &&
                studentController.containsID(e.getStudentID())){
            return true;
        }
        return false;
    }
    public boolean containsID(int id){
        Iterator<Enrolment> it = enrolmentRepository.allEnrolmentList().iterator();
        while (it.hasNext()){
            Enrolment bk = it.next();
            if(bk.getId()==id){
                return true;
            }
        }
        return false;
    }
}
