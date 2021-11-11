package ro.company.model;

public class Course implements Comparable<Course>{
    private int id;
    private String name;
    private String department;

    public Course(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }
    public Course( String name, String department) {this.id = id;
        this.name = name;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object obj){
        Course course = (Course) obj;
        return course.id==this.id;
    }
    @Override
    public int compareTo(Course course){
        if(course.id==this.id){
            return 0;
        }else if(course.id<this.id){
            return 1;
        }return -1;
    }
    @Override
    public String toString(){
        return id+","+name+","+department;
    }
}
