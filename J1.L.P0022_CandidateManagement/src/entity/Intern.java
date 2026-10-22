package entity;

public class Intern extends Candidate {

    private String majors;
    private String semester;
    private String universityName;

    public Intern() {
        setCandidateType(2);
    }

    public Intern(String candidateId, String firstName, String lastName, int birthDate,
            String address, String phone, String email,
            String majors, String semester, String universityName) {
        super(candidateId, firstName, lastName, birthDate, address, phone, email, 2);
        setMajors(majors);
        setSemester(semester);
        setUniversityName(universityName);
    }

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        if (majors == null || majors.trim().isEmpty()) {
            throw new IllegalArgumentException("Majors cannot be empty");
        }
        this.majors = majors.trim();
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

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        if (universityName == null || universityName.trim().isEmpty()) {
            throw new IllegalArgumentException("University name cannot be empty");
        }
        this.universityName = universityName.trim();
    }
}
