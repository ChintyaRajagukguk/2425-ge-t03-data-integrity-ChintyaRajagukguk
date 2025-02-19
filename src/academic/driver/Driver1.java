package academic.driver;

import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author 12S23023 Lenni Febriyani
 * @author 12S23045 Chintya Reginauli Rajagukguk
 */

public class Driver1 {
    private static Map<String, Course> courses = new LinkedHashMap<>();
    private static Map<String, Student> students = new LinkedHashMap<>();
    private static Map<String, Enrollment> enrollments = new LinkedHashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) break; // Jika input kosong, keluar dari loop
            processInput(input);
        }
        
        scanner.close();
        printData(); // Cetak hasil akhir setelah semua input diproses
    }

    private static void processInput(String input) {
        String[] parts = input.split("#");
        switch (parts[0]) {
            case "course-add":
                addCourse(parts[1], parts[2], Integer.parseInt(parts[3]), parts[4].charAt(0));
                break;
            case "student-add":
                addStudent(parts[1], parts[2], Integer.parseInt(parts[3]), parts[4]);
                break;
            case "enrollment-add":
                addEnrollment(parts[1], parts[2], parts[3], parts[4]);
                break;
        }
    }

    private static void addCourse(String code, String name, int credits, char grade) {
        Course course = new Course(code, name, credits, grade);
        courses.put(code, course);
    }

    private static void addStudent(String id, String name, int year, String major) {
        Student student = new Student(id, name, year, major);
        students.put(id, student);
    }

    private static void addEnrollment(String courseCode, String studentId, String academicYear, String semester) {
        Course course = courses.get(courseCode);
        Student student = students.get(studentId);
        if (course == null) {
            System.out.println("invalid course|" + courseCode);
        } else if (student == null) {
            System.out.println("invalid student|" + studentId);
        } else {
            Enrollment enrollment = new Enrollment(course, student, academicYear, semester);
            enrollments.put(courseCode + "-" + studentId, enrollment);
        }
    }

    private static void printData() {
        // Cetak Courses
        for (Course course : courses.values()) {
            System.out.println(course.getCode() + "|" + course.getName() + "|" + course.getCredits() + "|" + course.getGrade());
        }
        // Cetak Students
        for (Student student : students.values()) {
            System.out.println(student.getId() + "|" + student.getName() + "|" + student.getYear() + "|" + student.getMajor());
        }
        // Cetak Enrollments sesuai urutan input
        for (Enrollment enrollment : enrollments.values()) {
            System.out.println(enrollment.getCourse().getCode() + "|" + enrollment.getStudent().getId() + "|" + enrollment.getAcademicYear() + "|" + enrollment.getSemester() + "|None");
        }
    }
}
