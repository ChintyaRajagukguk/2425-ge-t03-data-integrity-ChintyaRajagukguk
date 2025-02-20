package academic.model;

/**
 * @author 12S23023 Lenni Febriyani Hutape
 * @author 12S23045 Chintya Reginauli Rajagukguk
 */

 public class Enrollment {
     private String courseCode; 
     private String studentId;
     private String year;
     private String semester;
     private String grade = "None";
 
     public Enrollment(String courseCode, String studentId, String year, String semester) {
         this.courseCode = courseCode;
         this.studentId = studentId;
         this.year = year;
         this.semester = semester;
     }
 
     public String getCourseCode() { return courseCode; }
     public String getStudentId() { return studentId; }
     public String getYear() { return year; }
     public String getSemester() { return semester; }
     public String getGrade() { return grade; }
     
     @Override
     public String toString() {
         return courseCode + "|" + studentId + "|" + year + "|" + semester + "|" + grade;
     }
 }