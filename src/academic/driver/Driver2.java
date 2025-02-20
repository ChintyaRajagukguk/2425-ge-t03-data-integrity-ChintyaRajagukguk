package academic.driver;

import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;
import java.util.*;

public class Driver2 {
    public static void main(String[] _args) {
        Scanner sc = new Scanner(System.in);

        Set<Course> courses = new TreeSet<>(Comparator.comparing(Course::getId));
        Set<Student> students = new TreeSet<>(Comparator.comparing(Student::getId));
        Set<Enrollment> enrollments = new LinkedHashSet<>();

        Set<String> invalidStudents = new LinkedHashSet<>();
        Set<String> invalidCourses = new LinkedHashSet<>();

        List<String> inputs = new ArrayList<>();
        while (true) {
            String input = sc.nextLine();
            if (input.equals("---")) break;
            inputs.add(input);
        }

        for (String input : inputs) {
            String[] data = input.split("#");

            switch (data[0]) {
                case "course-add":
                    if (!isCourseExists(courses, data[1])) {
                        courses.add(new Course(data[1], data[2], Integer.parseInt(data[3]), data[4]));
                    }
                    break;

                case "student-add":
                    if (!isStudentExists(students, data[1])) {
                        students.add(new Student(data[1], data[2], Integer.parseInt(data[3]), data[4]));
                    }
                    break;

                case "enrollment-add":
                    Course course = getCourseById(courses, data[1]);
                    Student student = getStudentById(students, data[2]);

                    if (course == null) {
                        invalidCourses.add("invalid course|" + data[1]);
                    } else if (student == null) {
                        invalidStudents.add("invalid student|" + data[2]);
                    } else if (!isEnrollmentExist(enrollments, data[1], data[2], data[3], data[4])) {
                        enrollments.add(new Enrollment(data[1], data[2], data[3], data[4]));
                    }
                    break;

                default:
                    break;
            }
        }

        for (String error : invalidStudents) {
            System.out.println(error);
        }
        for (String error : invalidCourses) {
            System.out.println(error);
        }

        for (Course course : courses) {
            System.out.println(course);
        }

        for (Student student : students) {
            System.out.println(student);
        }

        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment);
        }

        sc.close();
    }

    private static boolean isCourseExists(Set<Course> courses, String id) {
        return courses.stream().anyMatch(c -> c.getId().equals(id));
    }

    private static boolean isStudentExists(Set<Student> students, String id) {
        return students.stream().anyMatch(s -> s.getId().equals(id));
    }

    private static boolean isEnrollmentExist(Set<Enrollment> enrollments, String courseId, String studentId, String year, String semester) {
        return enrollments.stream().anyMatch(e ->
            e.getCourseCode().equals(courseId) &&
            e.getStudentId().equals(studentId) &&
            e.getYear().equals(year) &&
            e.getSemester().equals(semester)
        );
    }

    private static Course getCourseById(Set<Course> courses, String id) {
        return courses.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
    }

    private static Student getStudentById(Set<Student> students, String id) {
        return students.stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
    }
}
