import java.util.ArrayList;
import java.util.List;

public class Student extends Gradebook {

    private String name;
    private List<Grade> grades; // List of grades of type Grade

    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public void addGrade(String subject, double grade) {
        if (subject == null || subject.isEmpty()) {
            throw new IllegalArgumentException("Subject cannot be empty.");
        }
        if (grade < 0 || grade > 100) {
            throw new IllegalArgumentException("Grade must be between 0 and 100.");
        }
        grades.add(new Grade(subject, grade));
    }

    public String getName() {
        return name;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    // Converts the grades list to a formatted string (similar to toString but specific to grades)
    public String getGradesAsString() {
        StringBuilder sb = new StringBuilder();
        for (Grade grade : grades) {
            sb.append(grade.getSubject()).append(":").append(grade.getGrade()).append(",");
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1); // Remove trailing comma
        }
        return sb.toString();
    }

    public double getcalculateAverage() {
        if (grades.isEmpty()) {
            return 0;
        }
        double sum = 0;
        for (Grade grade : grades) {
            sum += grade.getGrade();
        }
        return sum / grades.size();
    }

    // Inner class to represent a single subject-grade pair
    private static class Grade {

        private String subject;
        private double grade;

        public Grade(String subject, double grade) {
            this.subject = subject;
            this.grade = grade;
        }

        public String getSubject() {
            return subject;
        }

        public double getGrade() {
            return grade;
        }

        @Override
        public String toString() {
            return subject + ": " + grade;
        }
    }
}
