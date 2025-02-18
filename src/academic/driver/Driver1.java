package academic.driver;

import academic.model.*;
import java.util.*;

/**
 * @author 12S23023 Lenni Febriyani Hutape
 * @author 12S23045 Chintya Reginauli Rajagukguk
 */


public class Driver1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Course> courses = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        List<Enrollment> enrollments = new ArrayList<>();
        Set<String> errorMessages = new LinkedHashSet<>();
        
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("---")) break;
            
            String[] parts = line.split("#");
            
            if (line.startsWith("course-add")) {
                courses.add(new Course(parts[1], parts[2], Integer.parseInt(parts[3]), parts[4]));
            } else if (line.startsWith("student-add")) {
                students.add(new Student(parts[1], parts[2], Integer.parseInt(parts[3]), parts[4]));
            } else if (line.startsWith("enrollment-add")) {
                boolean courseExists = courses.stream().anyMatch(c -> c.getCode().equals(parts[1]));
                boolean studentExists = students.stream().anyMatch(s -> s.getId().equals(parts[2]));
                
                if (!studentExists) {
                    errorMessages.add("invalid student|" + parts[2]);
                } 
                if (!courseExists) {
                    errorMessages.add("invalid course|" + parts[1]);
                } 
                if (courseExists && studentExists) {
                    enrollments.add(new Enrollment(parts[1], parts[2], parts[3], parts[4]));
                }
            }
        }
        
        for (String error : errorMessages) System.out.println(error);
        for (Course course : courses) System.out.println(course);
        for (Student student : students) System.out.println(student);
        for (Enrollment enrollment : enrollments) System.out.println(enrollment);
        
        scanner.close();
    }
}
