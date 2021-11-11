package ro.company.repository;

import org.junit.jupiter.api.Test;
import ro.company.model.Book;
import ro.company.model.Student;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class StudentRepositoryTest {
    @Test
    public void testGetStudentTrue(){
        StudentRepository studentRepository = new StudentRepository();
        assertEquals(true, studentRepository.getStudent(1).getId()==1);
    }
    @Test
    public void testGetStudentFalse(){
        StudentRepository studentRepository = new StudentRepository();
        assertEquals(false, studentRepository.getStudent(1).getId()==0);
    }


    @Test
    public void testAllStudentTrue(){
        StudentRepository studentRepository = new StudentRepository();
        assertEquals(true, studentRepository.allStudent()!=null);
    }
    @Test
    public void testAllStudentFalse(){
        StudentRepository studentRepository = new StudentRepository();
        assertEquals(false,studentRepository.allStudent()==null);
    }
    @Test
    public void testAllStudentListTrue(){
        StudentRepository studentRepository= new StudentRepository();
        assertEquals(true, studentRepository.allStudentList()!=null);
    }
    @Test
    public void testAllStudentsListFalse(){
        StudentRepository studentRepository = new StudentRepository();
        assertEquals(false, studentRepository.allStudentList()==null);
    }

    @Test
    public void testAddTrue(){
        StudentRepository studentRepository = new StudentRepository();
        studentRepository.add(new Student(99,"First Name test", "Last name test", "Email test", 99));
        assertEquals(true, studentRepository.getStudent(94).getId()==94);
    }

    @Test
    public void testAddFalse(){
        StudentRepository studentRepository = new StudentRepository();
        assertEquals(false, studentRepository.add(new Student(99,"First Name test", "Last name test", "Email test", 99)));
    }

    @Test
    public void testUpdateFNameTrue(){
        StudentRepository studentRepository = new StudentRepository();
        studentRepository.updateFirstName(1,"Name Test");
        assertEquals(true, studentRepository.getStudent(1).getFirstName().equals("Name Test"));
    }

    @Test
    public void testUpdateFNameFalse(){
        StudentRepository studentRepository = new StudentRepository();
        studentRepository.updateFirstName(1,"Name Test");
        assertEquals(false, studentRepository.getStudent(1).getFirstName().equals("Name Ttest"));
    }

    @Test
    public void testUpdateLNameTrue(){
        StudentRepository studentRepository = new StudentRepository();
        studentRepository.updateLastName(1,"Name Test");
        assertEquals(true, studentRepository.getStudent(1).getLastName().equals("Name Test"));
    }

    @Test
    public void testUpdateLNameFalse(){
        StudentRepository studentRepository = new StudentRepository();
        studentRepository.updateLastName(1,"Name Test");
        assertEquals(false, studentRepository.getStudent(1).getLastName().equals("Name Tetst"));
    }

    @Test
    public void testUpdateEmailTrue(){
        StudentRepository studentRepository = new StudentRepository();
        studentRepository.updateEmail(1, "Emailtest@gov.com");
        assertEquals(true, studentRepository.getStudent(1).getEmail().equals("Emailtest@gov.com"));
    }

    @Test
    public void testUpdateEmailFalse(){
        StudentRepository studentRepository = new StudentRepository();
        studentRepository.updateEmail(1, "Email test");
        assertEquals(false, studentRepository.getStudent(1).getEmail().equals("Email ttest"));
    }

    @Test
    public void testUpdateAgeTrue(){
        StudentRepository studentRepository = new StudentRepository();
        studentRepository.updateAge(1, 1);
        assertEquals(true, studentRepository.getStudent(1).getAge()==1);
    }

    @Test
    public void testUpdateAgeFalse(){
        StudentRepository studentRepository = new StudentRepository();
        studentRepository.updateAge(1, 1);
        assertEquals(false, studentRepository.getStudent(1).getAge()==11);
    }
}