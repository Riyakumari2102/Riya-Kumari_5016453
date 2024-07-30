// Student.java (Model)

/**
 * A class representing a student with attributes like name, id, and grade.
 */
public class Student {
    private String name;
    private int id;
    private double grade;

    public Student(String name, int id, double grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}

// StudentView.java (View)

/**
 * A class representing a student view with a method displayStudentDetails().
 */
public class StudentView {
    public void displayStudentDetails(Student student) {
        System.out.println("Student Name: " + student.getName());
        System.out.println("Student ID: " + student.getId());
        System.out.println("Student Grade: " + student.getGrade());
    }
}

// StudentController.java (Controller)

/**
 * A class representing a student controller that handles the communication
 * between the model and the view.
 */
public class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public void updateStudentName(String name) {
        model.setName(name);
    }

    public void updateStudentGrade(double grade) {
        model.setGrade(grade);
    }

    public void displayStudentDetails() {
        view.displayStudentDetails(model);
    }
}

// MVCPatternExample.java (Main Class)

/**
 * A main class to demonstrate creating a Student, updating its details using
 * StudentController, and displaying them using StudentView.
 */
public class MVCPatternExample {
    public static void main(String[] args) {
        // Create a Student
        Student student = new Student("John Doe", 123, 85.5);

        // Create a StudentView
        StudentView studentView = new StudentView();

        // Create a StudentController
        StudentController studentController = new StudentController(student, studentView);

        // Display initial student details
        System.out.println("Initial Student Details:");
        studentController.displayStudentDetails();

        // Update student name and grade using StudentController
        studentController.updateStudentName("Jane Doe");
        studentController.updateStudentGrade(90.0);

        // Display updated student details
        System.out.println("\nUpdated Student Details:");
        studentController.displayStudentDetails();
    }
}