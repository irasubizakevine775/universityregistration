import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class RegistryManager {

    private List<Student> students = new ArrayList<>();

    // READ the file and fill the list
    public void loadStudentsFromFile(String fileName) {
        students.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length < 4) {
                    continue;   // blank line or wrong format, skip it
                }

                try {
                    int id = Integer.parseInt(data[0].trim());
                    String name = data[1].trim();
                    double gpa = Double.parseDouble(data[2].trim());
                    String major = data[3].trim();

                    students.add(new Student(id, name, gpa, major));
                } catch (NumberFormatException e) {
                    // the header line (ID,Names,GPA,Majors) is skipped here
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // WRITE one student at the end of the file
    public void saveStudentToFile(String fileName, Student s) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, true))) {
            writer.println();   // start on a new line
            writer.print(s.getId() + "," + s.getName() + "," + s.getGpa() + "," + s.getMajor());
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    public void displayAllStudents() {
        for (Student s : students) {
            System.out.println(s);
        }
    }

    public void groupStudentsByMajor() {
        List<String> majors = new ArrayList<>();

        for (Student s : students) {
            boolean found = false;
            for (String m : majors) {
                if (m.equalsIgnoreCase(s.getMajor())) {
                    found = true;
                }
            }
            if (!found) {
                majors.add(s.getMajor());
            }
        }

        for (String major : majors) {
            System.out.println(major + ":");
            for (Student s : students) {
                if (s.getMajor().equalsIgnoreCase(major)) {
                    System.out.println("  - " + s.getName());
                }
            }
        }
    }
}