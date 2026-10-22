package ui;

import entity.Doctor;
import java.util.HashMap;
import java.util.Map;
import management.DoctorHash;
import utils.Validator;

public class Main {

    public static void main(String[] args) {
        DoctorHash manager = new DoctorHash();
        while (true) {
            System.out.println("========= Doctor Management ==========");
            System.out.println("1. Add Doctor");
            System.out.println("2. Update Doctor");
            System.out.println("3. Delete Doctor");
            System.out.println("4. Search Doctor");
            System.out.println("5. Exit");
            int choice = Validator.getInt("Enter your choice: ", "Must be 1-5", "Invalid!", 1, 5);
            try {
                switch (choice) {
                    case 1:
                        System.out.println("--------- Add Doctor ----------");
                        String code = Validator.getString("Enter Code: ", "Invalid!", "^.+$");
                        String name = Validator.getString("Enter Name: ", "Invalid!", "^.+$");
                        String spec = Validator.getString("Enter Specialization: ", "Invalid!", "^.+$");
                        int avai = Validator.getInt("Enter Availability: ", "Availability >= 0", "Invalid!", 0, Integer.MAX_VALUE);
                        manager.addDoctor(new Doctor(code, name, spec, avai));
                        System.out.println("Add successful!");
                        break;
                    case 2:
                        System.out.println("--------- Update Doctor -------");
                        code = Validator.getString("Enter Code: ", "Invalid!", "^.+$");
                        if (!manager.exists(code)) {
                            System.out.println("Doctor code does not exist");
                            break;
                        }
                        Doctor old = manager.get(code);
                        String n = Validator.getStringAllowEmpty("Enter Name: ");
                        String s = Validator.getStringAllowEmpty("Enter Specialization: ");
                        String a = Validator.getStringAllowEmpty("Enter Availability: ");
                        if (!n.isEmpty()) {
                            old.setName(n);
                        }
                        if (!s.isEmpty()) {
                            old.setSpecialization(s);
                        }
                        if (!a.isEmpty()) {
                            old.setAvailability(Integer.parseInt(a));
                        }
                        manager.updateDoctor(old);
                        System.out.println("Update successful!");
                        break;
                    case 3:
                        System.out.println("--------- Delete Doctor -------");
                        code = Validator.getString("Enter Code: ", "Invalid!", "^.+$");
                        if (!manager.exists(code)) {
                            System.out.println("Doctor code does not exist");
                            break;
                        }
                        manager.deleteDoctor(manager.get(code));
                        System.out.println("Delete successful!");
                        break;
                    case 4:
                        System.out.println("---------- Search Doctor --------");
                        String text = Validator.getStringAllowEmpty("Enter text: ");
                        HashMap<String, Doctor> result = manager.searchDoctor(text);
                        System.out.println("--------- Result ------------");
                        System.out.printf("%-8s%-15s%-20s%-12s%n", "Code", "Name", "Specialization", "Availability");
                        for (Map.Entry<String, Doctor> e : result.entrySet()) {
                            System.out.println(e.getValue());
                        }
                        break;
                    case 5:
                        return;
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
