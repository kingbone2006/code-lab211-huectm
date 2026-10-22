package ui;

import entity.Candidate;
import entity.Experience;
import entity.Fresher;
import entity.Intern;
import java.util.Calendar;
import java.util.List;
import management.CandidateManager;
import utils.Validator;

public class Main {

    public static void main(String[] args) {
        CandidateManager manager = new CandidateManager();
        while (true) {
            System.out.println("CANDIDATE MANAGEMENT SYSTEM");
            System.out.println("1. Experience");
            System.out.println("2. Fresher");
            System.out.println("3. Internship");
            System.out.println("4. Searching");
            System.out.println("5. Exit");
            int choice = Validator.getInt(
                    "(Please choose 1 to Create Experience Candidate, 2 to Create Fresher Candidate, 3 to Internship Candidate, 4 to Searching and 5 to Exit program): ",
                    "Must be 1-5", "Invalid!", 1, 5);
            switch (choice) {
                case 1:
                    createLoop(manager, 0);
                    break;
                case 2:
                    createLoop(manager, 1);
                    break;
                case 3:
                    createLoop(manager, 2);
                    break;
                case 4:
                    search(manager);
                    break;
                case 5:
                    return;
            }
        }
    }

    private static void createLoop(CandidateManager manager, int type) {
        do {
            try {
                manager.add(inputCandidate(type));
                System.out.println("Create successful!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (Validator.getYesNo("Do you want to continue (Y/N)? "));
        manager.displayAllNames();
    }

    private static Candidate inputCandidate(int type) {
        String id = Validator.getString("Enter Candidate Id: ", "Invalid!", "^.+$");
        String first = Validator.getString("Enter First Name: ", "Invalid!", "^.+$");
        String last = Validator.getString("Enter Last Name: ", "Invalid!", "^.+$");
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int birth = Validator.getInt("Enter Birth Date (year): ",
                "Birth Date: 1900.." + year, "Invalid!", 1900, year);
        String address = Validator.getString("Enter Address: ", "Invalid!", "^.+$");
        String phone = Validator.getString("Enter Phone: ", "Phone min 10 digits", "\\d{10,}");
        String email = Validator.getString("Enter Email: ", "Invalid email",
                "^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,}$");
        if (type == 0) {
            int exp = Validator.getInt("Enter Year of Experience: ", "0-100", "Invalid!", 0, 100);
            String skill = Validator.getString("Enter Pro Skill: ", "Invalid!", "^.+$");
            return new Experience(id, first, last, birth, address, phone, email, exp, skill);
        } else if (type == 1) {
            String gDate = Validator.getString("Enter Graduation date: ", "Invalid!", "^.+$");
            String rank = Validator.getString("Enter Graduation rank (Excellence/Good/Fair/Poor): ",
                    "Invalid rank", "^(?i)(Excellence|Good|Fair|Poor)$");
            String edu = Validator.getString("Enter Education: ", "Invalid!", "^.+$");
            return new Fresher(id, first, last, birth, address, phone, email, gDate, rank, edu);
        } else {
            String majors = Validator.getString("Enter Majors: ", "Invalid!", "^.+$");
            String semester = Validator.getString("Enter Semester: ", "Invalid!", "^.+$");
            String uni = Validator.getString("Enter University name: ", "Invalid!", "^.+$");
            return new Intern(id, first, last, birth, address, phone, email, majors, semester, uni);
        }
    }

    private static void search(CandidateManager manager) {
        manager.displayAllNames();
        String name = Validator.getStringAllowEmpty("Input Candidate name (First name or Last name): ");
        int type = Validator.getInt("Input type of candidate: ", "Type 0-2", "Invalid!", 0, 2);
        List<Candidate> result = manager.search(name, type);
        System.out.println("The candidates found:");
        for (Candidate c : result) {
            System.out.println(c);
        }
    }
}
