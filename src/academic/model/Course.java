package academic.model;

/**
 * 
 * @autor 12S23023 Lenni Febriyani
 * @autor 12S23045 Chintya Reginauli Rajagukguk
 */

public class Course {
    private String code;
    private String name;
    private int credits;
    private char grade;

    public Course(String code, String name, int credits, char grade) {
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.grade = grade;
    }

    // Getters
    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public char getGrade() {
        return grade;
    }

    // Setters (if needed)
    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }
}