package entity;

public class Contact {

    private int id;
    private String fullName;
    private String firstName;
    private String lastName;
    private String group;
    private String address;
    private String phone;

    public static final String PHONE_REGEX =
            "^(\\d{10}|\\d{3}-\\d{3}-\\d{4}|\\d{3}-\\d{3}-\\d{4}\\sx\\d{1,4}"
            + "|\\d{3}-\\d{3}-\\d{4}\\sext\\d{1,4}|\\(\\d{3}\\)-\\d{3}-\\d{4}"
            + "|\\d{3}\\.\\d{3}\\.\\d{4}|\\d{3}\\s\\d{3}\\s\\d{4})$";

    public Contact() {
    }

    public Contact(int id, String fullName, String group, String address, String phone) {
        setId(id);
        setFullName(fullName);
        setGroup(group);
        setAddress(address);
        setPhone(phone);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be > 0");
        }
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        if (fullName == null || fullName.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.fullName = fullName.trim();
        splitName();
    }

    private void splitName() {
        String[] parts = fullName.split("\\s+", 2);
        this.firstName = parts[0];
        this.lastName = parts.length > 1 ? parts[1] : "";
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        if (group == null || group.trim().isEmpty()) {
            throw new IllegalArgumentException("Group cannot be empty");
        }
        this.group = group.trim();
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
        if (phone == null || !phone.matches(PHONE_REGEX)) {
            throw new IllegalArgumentException("Invalid phone format");
        }
        this.phone = phone;
    }
}
