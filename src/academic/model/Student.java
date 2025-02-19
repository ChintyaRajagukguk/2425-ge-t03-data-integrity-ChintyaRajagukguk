package academic.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 12S23023 Lenni Febriyani Hutape
 * @author 12S23045 Chintya Reginauli Rajagukguk
 */
public class Student {
    private String id;
    private String name;
    private int year;
    private String program;
    private List<Enrollment> enrollments;

    public Student(String id, String name, int year, String program) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.program = program;
        this.enrollments = new ArrayList<>();
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getYear() { return year; }
    public String getProgram() { return program; }

    public void addEnrollment(Enrollment enrollment) {
        enrollments.add(enrollment);
    }

    @Override
    public String toString() {
        return id + "|" + name + "|" + year + "|" + program;
    }
}
