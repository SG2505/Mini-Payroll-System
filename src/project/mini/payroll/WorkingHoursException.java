package project.mini.payroll;

public class WorkingHoursException extends Exception {
    public WorkingHoursException(int workinghours) {
        super("Working hours entered: "+ workinghours +"\nis wrong Please enter correct Working hours.");
    }
}
