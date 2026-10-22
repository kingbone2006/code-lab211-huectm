package management;

import entity.Student;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentManager {

    private final List<Student> list = new ArrayList<>();

    public void create(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
        list.add(student);
    }

    public int size() {
        return list.size();
    }

    public List<Student> findAndSort(String namePart) {
        if (namePart == null) {
            namePart = "";
        }
        List<Student> result = new ArrayList<>();
        String key = namePart.trim().toLowerCase();
        for (Student s : list) {
            if (s.getStudentName().toLowerCase().contains(key)) {
                result.add(s);
            }
        }
        Collections.sort(result);
        return result;
    }

    public List<Student> findById(String id) {
        List<Student> result = new ArrayList<>();
        for (Student s : list) {
            if (s.getId().equalsIgnoreCase(id)) {
                result.add(s);
            }
        }
        return result;
    }

    public boolean delete(Student student) {
        return list.remove(student);
    }

    public void update(Student oldStudent, Student newStudent) {
        int index = list.indexOf(oldStudent);
        if (index >= 0) {
            list.set(index, newStudent);
        }
    }

    public void report() {
        // count by name + course
        Map<String, Integer> map = new HashMap<>();
        for (Student s : list) {
            String key = s.getStudentName() + " | " + s.getCourseName();
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            System.out.println(e.getKey() + " | " + e.getValue());
        }
    }

    public List<Student> getList() {
        return list;
    }
}
