package project.mini.payroll;

public class NameException extends Exception{
    public NameException(String Name) {
        super("Input is incorrect or missing");
    }
}
