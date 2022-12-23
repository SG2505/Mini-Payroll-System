package project.mini.payroll;

public class GPAException extends Exception {
    public GPAException(double GPA) {
        super("GPA entered: "+GPA+"\nis wrong Please enter\na correct GPA.");
    }
}
