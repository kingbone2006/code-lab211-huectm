package entity;

public class Person {

    private String name;
    private String address;
    private double salary;

    public Person() {
    }

    public Person(String name, String address, double salary) {
        setName(name);
        setAddress(address);
        setSalary(salary);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name.trim();
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary <= 0) {
            throw new IllegalArgumentException("Salary is greater than zero");
        }
        this.salary = salary;
    }

    public static Person inputPersonInfo(String name, String address, String sSalary) throws Exception {
        if (name == null || name.trim().isEmpty()) {
            throw new Exception("You must input name.");
        }
        if (address == null || address.trim().isEmpty()) {
            throw new Exception("You must input address.");
        }
        if (sSalary == null || sSalary.trim().isEmpty()) {
            throw new Exception("You must input Salary.");
        }
        double salary;
        try {
            salary = Double.parseDouble(sSalary.trim());
        } catch (NumberFormatException e) {
            throw new Exception("You must input digit.");
        }
        if (salary <= 0) {
            throw new Exception("Salary is greater than zero");
        }
        return new Person(name, address, salary);
    }

    public static void displayPersonInfo(Person person) {
        if (person == null) {
            throw new IllegalArgumentException("Person cannot be null");
        }
        System.out.println("Information of Person you have entered:");
        System.out.println("Name:" + person.getName());
        System.out.println("Address:" + person.getAddress());
        System.out.println("Salary:" + person.getSalary());
    }

    public static Person[] sortBySalary(Person[] person) throws Exception {
        if (person == null) {
            throw new Exception("Can't Sort Person");
        }
        try {
            for (int i = 0; i < person.length - 1; i++) {
                for (int j = 0; j < person.length - i - 1; j++) {
                    if (person[j].getSalary() > person[j + 1].getSalary()) {
                        Person temp = person[j];
                        person[j] = person[j + 1];
                        person[j + 1] = temp;
                    }
                }
            }
            return person;
        } catch (Exception e) {
            throw new Exception("Can't Sort Person");
        }
    }
}
