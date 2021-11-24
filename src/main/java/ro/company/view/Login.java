package ro.company.view;

import ro.company.controller.StudentController;
import ro.company.model.Book;
import ro.company.model.Student;

import java.util.Scanner;

public class Login {
    private StudentController studentController;
    private Scanner scanner;

    public void menuLogin(){
        System.out.println("Press 1 to login");
        System.out.println("Press 2 to register");
        System.out.println("Press 0 to return to the previous screen");
    }
    public Login(){
        this.studentController = new StudentController();
        this.scanner=new Scanner(System.in);
    }

    public void play(){
        boolean run=true;
        menuLogin();

        while (run==true){
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 0:run=false;
                    System.out.println("Returning to previous menu");
                    break;
                case 1:login();
                break;
                case 2:register();
                break;

            }
        }
    }

    public void login(){
        System.out.println("Input your email/username");
        String mail= scanner.nextLine();
        System.out.println("Input your password");
        int pass=Integer.parseInt(scanner.nextLine());
        if(studentController.checkUser(mail,pass)!=null){
             StudentView studentView= new StudentView(studentController.checkUser(mail,pass));
             studentView.play();
        } else {
            System.out.println("Wrong email or password");
        }
    }

    public void register(){


            System.out.println("Input your First name");
            String fName= scanner.nextLine();
            System.out.println("Input your Last name");
            String lName = scanner.nextLine();
            System.out.println("Input your e-mail");
            String mail = scanner.nextLine();

            if(studentController.validMail(mail)==false){
                System.out.println("Wrong email or already in use. Do you want to retry another email? y/n");
                String answer = scanner.nextLine();
                if(answer.equals("y")||answer.equals("Y")){
                    while (studentController.validMail(mail)==false){
                        System.out.println("Input your e-mail again");
                        mail=scanner.nextLine();
                    }
                } else {
                  return;
                }
            }

            System.out.println("Input your age");
            int age = Integer.parseInt(scanner.nextLine());
            if(age<18){
                System.out.println("Age under 18. If incorrect, do you want to retry? y/n");
                String answer = scanner.nextLine();
                if(answer.equals("y")||answer.equals("Y")){
                    while (age<18){
                        System.out.println("Input your age again");
                        age=Integer.parseInt(scanner.nextLine());
                    }
                } else {
                    return;
                }
            }

            Student student = new Student(fName,lName,mail,age);
            if(studentController.add(student)){
                System.out.println("Successfully registered. Your password is: "+studentController.lastID());
            } else {
                System.out.println("Something went wrong. Please retry");
                return;
            }
        }

}
