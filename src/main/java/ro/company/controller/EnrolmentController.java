package ro.company.controller;

import ro.company.model.Enrolment;
import ro.company.repository.EnrolmentRepository;
import ro.company.repository.StudentRepository;

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
        return enrolmentRepository.add(e);
    }
    public boolean delete(int id){
        return enrolmentRepository.delete(id);
    }

    //Utility
    public Enrolment getEnrolment(int id){
        return enrolmentRepository.getEnrolment(id);
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
}
