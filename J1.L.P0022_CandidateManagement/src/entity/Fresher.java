package entity;

public class Fresher extends Candidate {

    private String graduationDate;
    private String graduationRank;
    private String education;

    public Fresher() {
        setCandidateType(1);
    }

    public Fresher(String candidateId, String firstName, String lastName, int birthDate,
            String address, String phone, String email,
            String graduationDate, String graduationRank, String education) {
        super(candidateId, firstName, lastName, birthDate, address, phone, email, 1);
        setGraduationDate(graduationDate);
        setGraduationRank(graduationRank);
        setEducation(education);
    }

    public String getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(String graduationDate) {
        if (graduationDate == null || graduationDate.trim().isEmpty()) {
            throw new IllegalArgumentException("Graduation date cannot be empty");
        }
        this.graduationDate = graduationDate.trim();
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        if (graduationRank == null) {
            throw new IllegalArgumentException("Graduation rank invalid");
        }
        String r = graduationRank.trim();
        if (!r.equalsIgnoreCase("Excellence") && !r.equalsIgnoreCase("Good")
                && !r.equalsIgnoreCase("Fair") && !r.equalsIgnoreCase("Poor")) {
            throw new IllegalArgumentException("Rank must be Excellence, Good, Fair or Poor");
        }
        this.graduationRank = r;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        if (education == null || education.trim().isEmpty()) {
            throw new IllegalArgumentException("Education cannot be empty");
        }
        this.education = education.trim();
    }
}
