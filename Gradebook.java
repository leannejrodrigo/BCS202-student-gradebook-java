import java.io.File;
import java.io.FileWriter;   // Importing file manipulating.
import java.io.IOException;  // Importing to detect input/output Exceptions.
import java.util.ArrayList;  // Importing allowing the usage of marking and manipulating array lists.
import java.util.List;
import java.util.Scanner;    // Importing scanner to allow the reading of user input.

public class Gradebook {

    private List<Student> students;
    private static final String FILENAME = "gradebook.txt";

    public Gradebook() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void deleteStudent(String name) {
        // Iterates through the student list until it finds the student to delete,
        // then removes them and their respective information.
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (student.getName().equalsIgnoreCase(name)) {
                students.remove(i);
                return; // Exit the method after removing the student
            }
        }
    }

    public void assignGrade(Student student, String subject, double grade) {
        student.addGrade(subject, grade);
    }

    public void generateReport() {
        for (Student student : students) {
            System.out.println("Student: " + student.getName());
            System.out.println("Grades: " + student.getGradesAsString());
            System.out.println("Average: " + student.getcalculateAverage());
        }
    }

    public void writeData() throws IOException {
        try (FileWriter writer = new FileWriter(FILENAME)) {
            for (Student student : students) {
                writer.write(student.getName() + "," + student.getGradesAsString() + " Average: "
                        + student.getcalculateAverage() + "\n");
            }
        } catch (IOException e) {
            throw new IOException("An error occurred while writing data to the file: " + e.getMessage());
        }
    }

    public void loadData() throws IOException {
        File file = new File(FILENAME);

        if (!file.exists()) {
            System.out.println("FILE IS EMPTY"); // No data to load
            return;
        }

        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();

                // Split into name and grades (the first comma separates them)
                String[] parts = line.split(",", 2);

                if (parts.length == 2) {
                    String studentName = parts[0];
                    String gradesStr = parts[1];

                    Student student = new Student(studentName);
                    String[] gradeEntries = gradesStr.split(",");

                    for (String gradeEntry : gradeEntries) {
                        String[] gradeParts = gradeEntry.trim().split(":");
                        if (gradeParts.length == 2) {
                            String subject = gradeParts[0].trim();
                            double grade = Double.parseDouble(gradeParts[1].trim());
                            student.addGrade(subject, grade);
                        }
                    }

                    students.add(student);
                }
            }
        } catch (IOException e) {
            throw new IOException("An error occurred while loading data from the file: " + e.getMessage());
        }
    }

    public Student findStudentByName(String name) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                return student;
            }
        }
        return null;
    }
}
