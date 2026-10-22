package management;

import entity.Doctor;
import java.util.HashMap;
import java.util.Map;

public class DoctorHash {

    private HashMap<String, Doctor> database = new HashMap<>();

    public boolean addDoctor(Doctor doctor) throws Exception {
        if (database == null) {
            throw new Exception("Database does not exist");
        }
        if (doctor == null) {
            throw new Exception("Data does not exist");
        }
        if (database.containsKey(doctor.getCode())) {
            throw new Exception("Doctor code [" + doctor.getCode() + "] is duplicate");
        }
        database.put(doctor.getCode(), doctor);
        return true;
    }

    public boolean updateDoctor(Doctor doctor) throws Exception {
        if (database == null) {
            throw new Exception("Database does not exist");
        }
        if (doctor == null) {
            throw new Exception("Data doesn't exist");
        }
        if (!database.containsKey(doctor.getCode())) {
            throw new Exception("Doctor code doesn't exist");
        }
        Doctor old = database.get(doctor.getCode());
        if (doctor.getName() != null && !doctor.getName().isEmpty()) {
            old.setName(doctor.getName());
        }
        if (doctor.getSpecialization() != null && !doctor.getSpecialization().isEmpty()) {
            old.setSpecialization(doctor.getSpecialization());
        }
        if (doctor.getAvailability() >= 0) {
            old.setAvailability(doctor.getAvailability());
        }
        database.put(old.getCode(), old);
        return true;
    }

    public boolean deleteDoctor(Doctor doctor) throws Exception {
        if (database == null) {
            throw new Exception("Database does not exist");
        }
        if (doctor == null) {
            throw new Exception("Data doesn't exist");
        }
        if (!database.containsKey(doctor.getCode())) {
            throw new Exception("Doctor code doesn't exist");
        }
        database.remove(doctor.getCode());
        return true;
    }

    public HashMap<String, Doctor> searchDoctor(String input) throws Exception {
        if (database == null) {
            throw new Exception("Database does not exist");
        }
        HashMap<String, Doctor> result = new HashMap<>();
        String key = input == null ? "" : input.toLowerCase();
        for (Map.Entry<String, Doctor> e : database.entrySet()) {
            Doctor d = e.getValue();
            if (d.getCode().toLowerCase().contains(key)
                    || d.getName().toLowerCase().contains(key)
                    || d.getSpecialization().toLowerCase().contains(key)
                    || String.valueOf(d.getAvailability()).contains(key)) {
                result.put(e.getKey(), d);
            }
        }
        return result;
    }

    public boolean exists(String code) {
        return database.containsKey(code);
    }

    public Doctor get(String code) {
        return database.get(code);
    }
}
