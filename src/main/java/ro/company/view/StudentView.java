package ro.company.view;

import ro.company.controller.CourseController;
import ro.company.controller.EnrolmentController;
import ro.company.controller.StudentController;
import ro.company.model.Course;
import ro.company.model.Enrolment;
import ro.company.model.Student;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class StudentView {

    private Student student;
    private CourseController courses;
    private EnrolmentController enrolments;
    private Scanner scanner;

    public StudentView(){
        this.student= new Student(1,"Bogdan","Java","love@java.com",23);//studentul logat
        this.courses= new CourseController();
        this.enrolments= new EnrolmentController();
        this.scanner=new Scanner(System.in);
    }


    public void menuCourses(){
        System.out.println("Apasa 1 pentru a vedea cursurile disponibile");
        System.out.println("Apasa 2 pentru a vedea toate cursurile in care esti inscris");
        System.out.println("Apasa 3 pentru a te inscrie la un curs");
        System.out.println("Apasa 4 pentru a te scoate de la un curs");
    }

    public void play(){
        boolean run=true;
        while (run==true){
            menuCourses();
            int choice=Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:courses.showAllCourses();
                break;
                case 2:showEnrolledCourses();
                break;
                case 3:enroll();
                break;
                case 4:unEnroll();
                break;
            }
        }
    }

    public void showEnrolledCourses(){
        List<Enrolment> enrolmentList= enrolments.showAllEnrolmentsForStudent(this.student.getId());
        System.out.println("Your enrolled courses are:");
        for(Enrolment e :enrolmentList){
            System.out.println(courses.getCourse(e.getCourseID()));
        }
    }
    public void enroll() {
        System.out.println("Select a course name to enroll");
        String cName = scanner.nextLine();
        int courseID = courses.getCourseIDfromName(cName);
        Enrolment enrolment = new Enrolment(this.student.getId(), courseID, LocalDateTime.now());
        if (enrolments.validIDs(enrolment)) {
            System.out.println("Enrolled successfully in course " + cName);
            enrolments.add(enrolment);
        } else {
            System.out.println("Course name invalid. Retry? y/n");
            {
                String answer = scanner.nextLine();
                if (answer.equals("y") || answer.equals("Y")) {
                    while (!enrolments.validIDs(enrolment)) {
                        System.out.println("Course ID invalid. Please input correct ID");
                        enrolment.setCourseID(courses.getCourseIDfromName(scanner.nextLine()));
                    }
                    enrolments.add(enrolment);
                }
            }
        }
    }

    public void unEnroll() {
        System.out.println("Select a course name to delist from");
        String cName = scanner.nextLine();
        int courseID = courses.getCourseIDfromName(cName);
        Enrolment enrolment = new Enrolment(this.student.getId(), courseID, LocalDateTime.now());
        if (enrolments.validIDs(enrolment)) {
            System.out.println("Successfully delisted from " + cName);
            enrolments.delete(courseID);
        } else {
            System.out.println("Course name invalid. Retry? y/n");
            String answer = scanner.nextLine();
            if (answer.equals("y") || answer.equals("Y")) {

                while (!enrolments.validIDs(enrolment)) {
                    System.out.println("Course ID invalid. Please input correct ID");
                    enrolment.setCourseID(courses.getCourseIDfromName(scanner.nextLine()));
                }
                enrolments.delete(enrolment.getId());
            }
        }
    }
}
