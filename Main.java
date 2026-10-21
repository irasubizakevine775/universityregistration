
import java.io.File;

public class Main {

    public static void main(String[] args) {

        RegistryManager manager = new RegistryManager();

        File file = new File("students.txt");

        manager.loadStudentsFromFile(file.getAbsolutePath());

        System.out.println("All Students:");
        manager.displayAllStudents();

        System.out.println("Students Grouped by Major:");
        manager.groupStudentsByMajor();
    }
}
