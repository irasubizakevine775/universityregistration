
import java.io.*;
import java.util.*;

public class RegistryManager {

    private List<Student> students = new ArrayList<>();

    public void loadStudentsFromFile(String fileName) {

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));

            String line = br.readLine();

            while (line != null) {

                int a = line.indexOf(",");

                if (a != -1) {

                    int b = line.indexOf(",", a + 1);
                    int c = line.indexOf(",", b + 1);

                    int id = Integer.parseInt(line.substring(0, a));
                    String name = line.substring(a + 1, b);
                    double gpa = Double.parseDouble(line.substring(b + 1, c));
                    String major = line.substring(c + 1);

                    Student s = new Student(id, name, gpa, major);
                    students.add(s);
                }

                line = br.readLine();
            }

            br.close();
            System.out.println("Students loaded successfully!");

        } catch (IOException e) {
            System.out.println("Error reading file: " + e);
        }
    }

    public void displayAllStudents() {

        for (Student s : students) {
            System.out.println(s);
        }
    }

    public void groupStudentsByMajor() {

        ArrayList<String> majors = new ArrayList<>();

        for (Student s : students) {
            if (!majors.contains(s.getMajor())) {
                majors.add(s.getMajor());
            }
        }

        for (String major : majors) {

            System.out.println(  major + ":");

            for (Student s : students) {
                if (s.getMajor().equals(major)) {
                    System.out.println(s.getName());
                }
            }
        }
    }
}
