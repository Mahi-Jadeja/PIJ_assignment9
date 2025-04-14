package studentdata;

import java.util.List;
import java.util.Scanner;

public class StudentService {
    private final StudentDAO dao = new StudentDAO();
    private final Scanner sc = new Scanner(System.in);

    public void addStudent() {
        System.out.print("Enter PRN: ");
        String prn = sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter DOB (YYYY-MM-DD): ");
        String dob = sc.nextLine();
        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();
        sc.nextLine(); // consume newline

        dao.addStudent(new Student(prn, name, dob, marks));
        System.out.println("Student added successfully.");
    }

    public void viewStudents() {
        List<Student> students = dao.getAllStudents();
        for (Student s : students) {
            System.out.printf("PRN: %s, Name: %s, DOB: %s, Marks: %.2f%n",
                    s.getPrn(), s.getName(), s.getDob(), s.getMarks());
        }
    }

    public void searchStudentByPRN() {
        System.out.print("Enter PRN: ");
        String prn = sc.nextLine();
        Student student = dao.getStudentByPRN(prn);
        if (student != null) {
            System.out.printf("PRN: %s, Name: %s, DOB: %s, Marks: %.2f%n",
                    student.getPrn(), student.getName(), student.getDob(), student.getMarks());
        } else {
            System.out.println("Student not found.");
        }
    }

    public void searchStudentByName() {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        List<Student> students = dao.searchStudentByName(name);
        if (!students.isEmpty()) {
            for (Student s : students) {
                System.out.printf("PRN: %s, Name: %s, DOB: %s, Marks: %.2f%n",
                        s.getPrn(), s.getName(), s.getDob(), s.getMarks());
            }
        } else {
            System.out.println("No students found with that name.");
        }
    }

    public void updateStudent() {
        System.out.print("Enter PRN of student to update: ");
        String prn = sc.nextLine();
        Student existing = dao.getStudentByPRN(prn);
        if (existing == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter New Name: ");
        String name = sc.nextLine();
        System.out.print("Enter New DOB: ");
        String dob = sc.nextLine();
        System.out.print("Enter New Marks: ");
        double marks = sc.nextDouble();
        sc.nextLine();

        existing.setName(name);
        existing.setDob(dob);
        existing.setMarks(marks);
        dao.updateStudent(existing);
        System.out.println("Student updated successfully.");
    }

    public void deleteStudent() {
        System.out.print("Enter PRN of student to delete: ");
        String prn = sc.nextLine();
        dao.deleteStudent(prn);
        System.out.println("Student deleted successfully.");
    }
}
