import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GradebookApp {

    public static void main(String[] args) {

        Gradebook g1 = new Gradebook();
        Scanner scan = new Scanner(System.in);
        int choice = 0;

        // Load data from the file at the beginning
        try {
            g1.loadData();
        } catch (Exception e) {
            System.out.println("An error occurred while loading data: " + e.getMessage());
        }

        while (choice != 5) {

            System.out.println("Enter choice:");
            System.out.println("1. Add student");
            System.out.println("2. Assign Grade");
            System.out.println("3. Generate Report");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");

            try {
                choice = scan.nextInt();
                scan.nextLine(); // Consumes newline
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                scan.nextLine(); // Clear the invalid input
                continue;
            }

            try {
                switch (choice) {

                    case 1:
                        try {
                            System.out.println("Enter student name:");
                            String studentName = scan.nextLine();

                            if (studentName.isEmpty()) {
                                throw new IllegalArgumentException("Student name cannot be empty.");
                            }

                            Student student = new Student(studentName);
                            g1.addStudent(student);
                            g1.writeData();
                            System.out.println("Student Added Successfully");

                        } catch (IOException e) {
                            System.out.println("An error occurred while writing data: " + e.getMessage());
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        } catch (Exception e) {
                            System.out.println("An unexpected error occurred: " + e.getMessage());
                        }
                        break;

                    case 2:
                        try {
                            System.out.println("Enter Student's Name:");
                            String name = scan.nextLine();

                            if (name.isEmpty()) {
                                throw new IllegalArgumentException(
                                        "Student name cannot be empty, please enter the student's name.");
                            }

                            System.out.println("Enter Subject:");
                            String subject = scan.nextLine();

                            if (subject.isEmpty()) {
                                throw new IllegalArgumentException("Subject cannot be empty, please enter a subject.");
                            }

                            System.out.println("Enter Grade:");
                            if (!scan.hasNextDouble()) {
                                throw new IllegalArgumentException(
                                        "Grade cannot be empty, please enter a value for the grade.");
                            }

                            double grade = scan.nextDouble();
                            scan.nextLine(); // Consume newline

                            if (grade < 0 || grade > 100) {
                                throw new IllegalArgumentException("Grade must be between 0 and 100.");
                            }

                            Student s = g1.findStudentByName(name);
                            if (s != null) {
                                g1.assignGrade(s, subject, grade);
                                g1.writeData();
                            } else {
                                System.out.println("Student not found.");
                            }

                        } catch (IOException e) {
                            System.out.println("An error occurred while writing data: " + e.getMessage());
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        } catch (Exception e) {
                            System.out.println("An error occurred: " + e.getMessage());
                        }
                        break;

                    case 3:
                        try {
                            g1.generateReport();
                        } catch (Exception e) {
                            System.out.println("An error occurred while generating the report: " + e.getMessage());
                        }
                        break;

                    case 4:
                        try {
                            System.out.println("Enter Student's Name to delete:");
                            String nameToDelete = scan.nextLine();
                            g1.deleteStudent(nameToDelete);
                            g1.writeData();
                            System.out.print("Student deleted successfully.");
                        } catch (IOException e) {
                            System.out.print("An error occurred while writing data: " + e.getMessage());
                        } catch (Exception e) {
                            System.out.print("An error occurred: " + e.getMessage());
                        }
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice. Please choose between 1-5.");
                }

            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }

        scan.close();
    }
}
