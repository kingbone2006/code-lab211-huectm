package ui;

import entity.Student;
import java.util.List;
import management.StudentManager;
import utils.Validator;

public class Main {

    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        while (true) {
            System.out.println("WELCOME TO STUDENT MANAGEMENT");
            System.out.println("1. Create");
            System.out.println("2. Find and Sort");
            System.out.println("3. Update/Delete");
            System.out.println("4. Report");
            System.out.println("5. Exit");
            int choice = Validator.getInt(
                    "(Please choose 1 to Create, 2 to Find and Sort, 3 to Update/Delete, 4 to Report and 5 to Exit program): ",
                    "Must be 1-5", "Invalid!", 1, 5);
            switch (choice) {
                case 1:
                    createStudents(manager);
                    break;
                case 2:
                    findSort(manager);
                    break;
                case 3:
                    updateDelete(manager);
                    break;
                case 4:
                    System.out.println("----- Report -----");
                    manager.report();
                    break;
                case 5:
                    return;
            }
        }
    }

    private static void createStudents(StudentManager manager) {
        while (true) {
            try {
                String id = Validator.getString("Enter ID: ", "Invalid!", "^.+$");
                String name = Validator.getString("Enter Student Name: ", "Invalid!", "^.+$");
                String semester = Validator.getString("Enter Semester: ", "Invalid!", "^.+$");
                String course = Validator.getString("Enter Course (Java/.Net/C/C++): ",
                        "Course must be Java, .Net or C/C++", "^(?i)(Java|\\.Net|C/C\\+\\+)$");
                manager.create(new Student(id, name, semester, course));
                System.out.println("Create successful! Total: " + manager.size());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            if (manager.size() >= 10) {
                if (!Validator.getYesNo("Do you want to continue (Y/N)? ")) {
                    break;
                }
            }
        }
    }

    private static void findSort(StudentManager manager) {
        String name = Validator.getStringAllowEmpty("Enter student name (or part): ");
        List<Student> result = manager.findAndSort(name);
        System.out.printf("%-15s%-20s%-12s%-10s%n", "ID", "Student name", "Semester", "Course");
        for (Student s : result) {
            System.out.println(s);
        }
    }

    private static void updateDelete(StudentManager manager) {
        String id = Validator.getString("Enter ID: ", "Invalid!", "^.+$");
        List<Student> found = manager.findById(id);
        if (found.isEmpty()) {
            System.out.println("Student not found!");
            return;
        }
        for (int i = 0; i < found.size(); i++) {
            System.out.println((i + 1) + ". " + found.get(i));
        }
        int idx = Validator.getInt("Choose student: ", "Invalid!", "Invalid!", 1, found.size());
        Student selected = found.get(idx - 1);
        String ud = Validator.getString("Do you want to update (U) or delete (D) student: ",
                "Enter U or D", "^(?i)[UD]$");
        if (ud.equalsIgnoreCase("D")) {
            manager.delete(selected);
            System.out.println("Delete successful!");
        } else {
            try {
                String name = Validator.getString("Enter Student Name: ", "Invalid!", "^.+$");
                String semester = Validator.getString("Enter Semester: ", "Invalid!", "^.+$");
                String course = Validator.getString("Enter Course (Java/.Net/C/C++): ",
                        "Invalid course", "^(?i)(Java|\\.Net|C/C\\+\\+)$");
                Student updated = new Student(selected.getId(), name, semester, course);
                manager.update(selected, updated);
                System.out.println("Update successful!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
