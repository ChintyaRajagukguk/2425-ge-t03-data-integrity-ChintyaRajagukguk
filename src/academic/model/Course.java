package academic.model;

/**
 * @author 12S23023 Lenni Febriyani Hutape
 * @author 12S23045 Chintya Reginauli Rajagukguk
 */

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String code;
    private String name;
    private int credit;
    private String grade;
    private List<Enrollment> enrollments;
    
    public Course(String code, String name, int credit, String grade) {
        this.code = code;
        this.name = name;
        this.credit = credit;
        this.grade = grade;
        this.enrollments = new ArrayList<>();
    }

    public String getCode() { return code; }
    public String getName() { return name; }
    public int getCredit() { return credit; }
    public String getGrade() { return grade; }
    public List<Enrollment> getEnrollments() { return enrollments; }
    
    public void addEnrollment(Enrollment enrollment) {
        enrollments.add(enrollment);
    }
    
    @Override
    public String toString() {
        return code + "|" + name + "|" + credit + "|" + grade;
    }
}
