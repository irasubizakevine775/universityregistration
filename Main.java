import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        RegistryManager manager = new RegistryManager();
        String fileName = "src/students.txt";   // the file inside your src folder

        // 1. ask the user for students and save them in the file
        System.out.print("How many students do you want to add? ");
        int count = Integer.parseInt(scanner.nextLine().trim());

        for (int i = 1; i <= count; i++) {
            System.out.println("--- Student " + i + " ---");

            System.out.print("ID: ");
            int id = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Name: ");
            String name = scanner.nextLine().trim();
            System.out.print("GPA: ");
            double gpa = Double.parseDouble(scanner.nextLine().trim());
            System.out.print("Major: ");
            String major = scanner.nextLine().trim();

            manager.saveStudentToFile(fileName, new Student(id, name, gpa, major));
        }

        // 2. read the file
        manager.loadStudentsFromFile(fileName);

        // 3. display and group
        System.out.println("All Students ");
        manager.displayAllStudents();

        System.out.println(" Grouped by Major");
        manager.groupStudentsByMajor();
    }
}