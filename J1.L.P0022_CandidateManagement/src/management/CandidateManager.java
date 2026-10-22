package management;

import entity.Candidate;
import java.util.ArrayList;
import java.util.List;

public class CandidateManager {

    private final List<Candidate> list = new ArrayList<>();

    public void add(Candidate c) {
        if (c == null) {
            throw new IllegalArgumentException("Candidate cannot be null");
        }
        for (Candidate x : list) {
            if (x.getCandidateId().equalsIgnoreCase(c.getCandidateId())) {
                throw new IllegalArgumentException("Candidate Id already exists");
            }
        }
        list.add(c);
    }

    public void displayAllNames() {
        System.out.println("List of candidate:");
        System.out.println("===========EXPERIENCE CANDIDATE============");
        for (Candidate c : list) {
            if (c.getCandidateType() == 0) {
                System.out.println(c.getFullName());
            }
        }
        System.out.println("==========FRESHER CANDIDATE==============");
        for (Candidate c : list) {
            if (c.getCandidateType() == 1) {
                System.out.println(c.getFullName());
            }
        }
        System.out.println("===========INTERN CANDIDATE==============");
        for (Candidate c : list) {
            if (c.getCandidateType() == 2) {
                System.out.println(c.getFullName());
            }
        }
    }

    public List<Candidate> search(String name, int type) {
        List<Candidate> result = new ArrayList<>();
        String key = name == null ? "" : name.trim().toLowerCase();
        for (Candidate c : list) {
            if (c.getCandidateType() == type
                    && (c.getFirstName().toLowerCase().contains(key)
                    || c.getLastName().toLowerCase().contains(key))) {
                result.add(c);
            }
        }
        return result;
    }

    public List<Candidate> getList() {
        return list;
    }
}
