package academic.model;

/**
 * @author 12S23023 Lenni Febriyani
 * @author 12S23045 Chintya Reginauli Rajagukguk
 */

public class Enrollment {
    private Course course;
    private Student student;
    private String academicYear;
    private String semester;

    public Enrollment(Course course, Student student, String academicYear, String semester) {
        this.course = course;
        this.student = student;
        this.academicYear = academicYear;
        this.semester = semester;
    }

    // Getters and setters
    public Course getCourse() {
        return course;
    }

    public Student getStudent() {
        return student;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public String getSemester() {
        return semester;
    }
}