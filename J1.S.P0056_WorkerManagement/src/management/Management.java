package management;

import entity.SalaryHistory;
import entity.SalaryStatus;
import entity.Worker;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Management {

    private final List<Worker> workers = new ArrayList<>();
    private final List<SalaryHistory> histories = new ArrayList<>();

    public boolean addWorker(Worker worker) throws Exception {
        if (worker == null) {
            throw new Exception("Worker cannot be null");
        }
        for (Worker w : workers) {
            if (w.getId().equalsIgnoreCase(worker.getId())) {
                throw new Exception("Code is duplicated");
            }
        }
        workers.add(worker);
        return true;
    }

    public boolean changeSalary(SalaryStatus status, String code, double amount) throws Exception {
        if (status == null) {
            throw new Exception("Status cannot be null");
        }
        if (code == null || code.trim().isEmpty()) {
            throw new Exception("Code cannot be empty");
        }
        if (amount <= 0) {
            throw new Exception("Amount must be > 0");
        }
        Worker worker = null;
        for (Worker w : workers) {
            if (w.getId().equalsIgnoreCase(code)) {
                worker = w;
                break;
            }
        }
        if (worker == null) {
            throw new Exception("Code does not exist");
        }
        if (status == SalaryStatus.UP) {
            worker.setSalary(worker.getSalary() + amount);
        } else {
            if (worker.getSalary() - amount <= 0) {
                throw new Exception("Salary after decrease must be > 0");
            }
            worker.setSalary(worker.getSalary() - amount);
        }
        histories.add(new SalaryHistory(worker, worker.getSalary(), status, new Date()));
        return true;
    }

    public List<SalaryHistory> getInfomationSalary() {
        List<SalaryHistory> sorted = new ArrayList<>(histories);
        Collections.sort(sorted, Comparator.comparing(h -> h.getWorker().getId()));
        return sorted;
    }
}
