import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String firstName;
    private String lastName;

    // Constructor
    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters and Setters
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

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}

public class Students {
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static Scanner antony = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Enter Student List");
            System.out.println("2. Find Students by Last Name");
            System.out.println("3. Find and Edit Students by Full Name");
            System.out.println("4. End");
            System.out.print("Enter your choice: ");
            int choice = antony.nextInt();
            antony.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    enterStudentList();
                    break;
                case 2:
                    findStudentsByLastName();
                    break;
                case 3:
                    findAndEditStudentByName();
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // 1. Enter student list
    private static void enterStudentList() {
        System.out.print("Enter the number of students: ");
        int numStudents = antony.nextInt();
        antony.nextLine(); // Consume the newline character

        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter first name for student " + (i + 1) + ": ");
            String firstName = antony.nextLine();
            System.out.print("Enter last name for student " + (i + 1) + ": ");
            String lastName = antony.nextLine();

            Student student = new Student(firstName, lastName);
            studentList.add(student);
        }
        System.out.println("Students have been added successfully.");
    }

    // 2. Find students by last name
    private static void findStudentsByLastName() {
        System.out.print("Enter the last name to search: ");
        String lastName = antony.nextLine();

        System.out.println("Students with last name '" + lastName + "':");
        boolean found = false;
        for (Student student : studentList) {
            // Use equals() for exact match, including case sensitivity
            if (student.getLastName().equals(lastName)) {
                System.out.println(student);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No students found with the last name: " + lastName);
        }
    }

    // 3. Find and edit students by full name (first name and last name)
    private static void findAndEditStudentByName() {
        System.out.print("Enter the full name (first name and last name) to edit: ");
        String fullName = antony.nextLine();
        String[] parts = fullName.split(" ");
        if (parts.length < 2) {
            System.out.println("Invalid input. Please enter in 'FirstName LastName' format.");
            return;
        }
        String firstName = parts[0];
        String lastName = parts[1];

        for (Student student : studentList) {
            // Use equals() for exact match, including case sensitivity
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                System.out.println("Student found: " + student);
                System.out.print("Enter new first name: ");
                String newFirstName = antony.nextLine();
                System.out.print("Enter new last name: ");
                String newLastName = antony.nextLine();

                student.setFirstName(newFirstName);
                student.setLastName(newLastName);
                System.out.println("Student details have been updated successfully.");
                return;
            }
        }
        System.out.println("No student found with the name: " + fullName);
    }
}
