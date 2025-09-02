import java.util.*;

public class StudentGradeManager {
    static class Student {
        String name;
        int rollNo;
        double marks;

        Student(String name, int rollNo, double marks) {
            this.name = name;
            this.rollNo = rollNo;
            this.marks = marks;
        }

        String getGrade() {
            if (marks >= 90) return "A+";
            else if (marks >= 80) return "A";
            else if (marks >= 70) return "B";
            else if (marks >= 60) return "C";
            else if (marks >= 50) return "D";
            else return "Fail";
        }

        @Override
        public String toString() {
            return "Name: " + name +
                   ", Roll No: " + rollNo +
                   ", Marks: " + marks +
                   ", Grade: " + getGrade();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> studentList = new ArrayList<>();

        int choice;
        do {
            System.out.println("\n=== Student Grade Management ===");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter roll number: ");
                    int rollNo = scanner.nextInt();
                    System.out.print("Enter marks (0 - 100): ");
                    double marks = scanner.nextDouble();
                    studentList.add(new Student(name, rollNo, marks));
                    System.out.println("Student added successfully!");
                }
                case 2 -> {
                    if (studentList.isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        System.out.println("\n--- Student List ---");
                        studentList.forEach(System.out::println);
                    }
                }
                case 3 -> System.out.println("Exiting program. Goodbye!");
                default -> System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 3);

        scanner.close();
    }
}
