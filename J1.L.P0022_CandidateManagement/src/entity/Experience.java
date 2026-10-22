package entity;

public class Experience extends Candidate {

    private int expInYear;
    private String proSkill;

    public Experience() {
        setCandidateType(0);
    }

    public Experience(String candidateId, String firstName, String lastName, int birthDate,
            String address, String phone, String email, int expInYear, String proSkill) {
        super(candidateId, firstName, lastName, birthDate, address, phone, email, 0);
        setExpInYear(expInYear);
        setProSkill(proSkill);
    }

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        if (expInYear < 0 || expInYear > 100) {
            throw new IllegalArgumentException("Year of Experience must be from 0 to 100");
        }
        this.expInYear = expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        if (proSkill == null || proSkill.trim().isEmpty()) {
            throw new IllegalArgumentException("ProSkill cannot be empty");
        }
        this.proSkill = proSkill.trim();
    }
}
