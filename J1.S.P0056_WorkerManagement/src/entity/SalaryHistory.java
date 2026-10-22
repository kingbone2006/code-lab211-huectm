package entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SalaryHistory {

    private Worker worker;
    private double salary;
    private SalaryStatus status;
    private Date date;

    public SalaryHistory() {
    }

    public SalaryHistory(Worker worker, double salary, SalaryStatus status, Date date) {
        setWorker(worker);
        setSalary(salary);
        setStatus(status);
        setDate(date);
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        if (worker == null) {
            throw new IllegalArgumentException("Worker cannot be null");
        }
        this.worker = worker;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary <= 0) {
            throw new IllegalArgumentException("Salary must be > 0");
        }
        this.salary = salary;
    }

    public SalaryStatus getStatus() {
        return status;
    }

    public void setStatus(SalaryStatus status) {
        if (status == null) {
            throw new IllegalArgumentException("Status cannot be null");
        }
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
        this.date = date;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return String.format("%-8s%-15s%-6d%-12.0f%-8s%s",
                worker.getId(), worker.getName(), worker.getAge(),
                salary, status, sdf.format(date));
    }
}
