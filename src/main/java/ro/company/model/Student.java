package ro.company.model;

public class Student implements Comparable<Student>{
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private int age;

    public Student(int id, String firstName, String lastName, String email, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }
    public Student(String firstName, String lastName, String email, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object obj){
        Student student = (Student) obj;
        return student.id==this.id;
    }
    @Override
    public int compareTo(Student student){
        if(student.id==this.id){
            return 0;
        }else if(student.id<this.id){
            return 1;
        }return -1;
    }
    @Override
    public String toString(){
        return id+","+firstName+","+lastName+","+email+","+age;
    }

}
