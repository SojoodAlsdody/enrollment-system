package models;

public class Enrollment {

    private int id;
    private int studentId;
    private int courseId;
    private String enrollmentDate;

    public Enrollment() {}

    public Enrollment(int studentId, int courseId, String enrollmentDate) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.enrollmentDate = enrollmentDate;
    }

    public Enrollment(int id, int studentId, int courseId, String enrollmentDate) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.enrollmentDate = enrollmentDate;
    }

    public int getId() { return id; }
    public int getStudentId() { return studentId; }
    public int getCourseId() { return courseId; }
    public String getEnrollmentDate() { return enrollmentDate; }

    public void setId(int id) { this.id = id; }
}