package entity;

public class Student implements Comparable<Student> {

    private String id;
    private String studentName;
    private String semester;
    private String courseName;

    public Student() {
    }

    public Student(String id, String studentName, String semester, String courseName) {
        setId(id);
        setStudentName(studentName);
        setSemester(semester);
        setCourseName(courseName);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID cannot be empty");
        }
        this.id = id.trim();
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        if (studentName == null || studentName.trim().isEmpty()) {
            throw new IllegalArgumentException("Student name cannot be empty");
        }
        this.studentName = studentName.trim();
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        if (semester == null || semester.trim().isEmpty()) {
            throw new IllegalArgumentException("Semester cannot be empty");
        }
        this.semester = semester.trim();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        if (courseName == null) {
            throw new IllegalArgumentException("Course cannot be empty");
        }
        String c = courseName.trim();
        if (!c.equalsIgnoreCase("Java") && !c.equalsIgnoreCase(".Net")
                && !c.equalsIgnoreCase("C/C++")) {
            throw new IllegalArgumentException("Course must be Java, .Net or C/C++");
        }
        // normalize display
        if (c.equalsIgnoreCase("java")) {
            this.courseName = "Java";
        } else if (c.equalsIgnoreCase(".net")) {
            this.courseName = ".Net";
        } else {
            this.courseName = "C/C++";
        }
    }

    @Override
    public int compareTo(Student o) {
        return this.studentName.compareToIgnoreCase(o.studentName);
    }

    @Override
    public String toString() {
        return String.format("%-15s%-20s%-12s%-10s", id, studentName, semester, courseName);
    }
}
