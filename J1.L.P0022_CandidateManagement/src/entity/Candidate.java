package entity;

import java.util.Calendar;

public class Candidate {

    protected String candidateId;
    protected String firstName;
    protected String lastName;
    protected int birthDate;
    protected String address;
    protected String phone;
    protected String email;
    protected int candidateType;

    public Candidate() {
    }

    public Candidate(String candidateId, String firstName, String lastName, int birthDate,
            String address, String phone, String email, int candidateType) {
        setCandidateId(candidateId);
        setFirstName(firstName);
        setLastName(lastName);
        setBirthDate(birthDate);
        setAddress(address);
        setPhone(phone);
        setEmail(email);
        setCandidateType(candidateType);
    }

    public String getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(String candidateId) {
        if (candidateId == null || candidateId.trim().isEmpty()) {
            throw new IllegalArgumentException("Candidate Id cannot be empty");
        }
        this.candidateId = candidateId.trim();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("First name cannot be empty");
        }
        this.firstName = firstName.trim();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be empty");
        }
        this.lastName = lastName.trim();
    }

    public int getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(int birthDate) {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        if (birthDate < 1900 || birthDate > year) {
            throw new IllegalArgumentException("Birth Date must be from 1900 to " + year);
        }
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address == null || address.trim().isEmpty()) {
            throw new IllegalArgumentException("Address cannot be empty");
        }
        this.address = address.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (phone == null || !phone.matches("\\d{10,}")) {
            throw new IllegalArgumentException("Phone must be number with at least 10 digits");
        }
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || !email.matches("^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,}$")) {
            throw new IllegalArgumentException("Email invalid format");
        }
        this.email = email;
    }

    public int getCandidateType() {
        return candidateType;
    }

    public void setCandidateType(int candidateType) {
        if (candidateType < 0 || candidateType > 2) {
            throw new IllegalArgumentException("Candidate type must be 0, 1 or 2");
        }
        this.candidateType = candidateType;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return getFullName() + " | " + birthDate + " | " + address + " | "
                + phone + " | " + email + " | " + candidateType;
    }
}
