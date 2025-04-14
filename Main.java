// Name: Mahi Jadeja
// PRN: 23070126068
// Batch: A-3

package studentdata;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentService service = new StudentService();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Student Data Entry Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search by PRN");
            System.out.println("4. Search by Name");
            System.out.println("5. Update Student");
            System.out.println("6. Delete Student");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> service.addStudent();
                case 2 -> service.viewStudents();
                case 3 -> service.searchStudentByPRN();
                case 4 -> service.searchStudentByName();
                case 5 -> service.updateStudent();
                case 6 -> service.deleteStudent();
                case 7 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 7);
    }
}
