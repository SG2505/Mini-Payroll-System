package project.mini.payroll;

public class IDException extends Exception{
    public IDException(int ID) {
        super("The ID entered: " +ID+ "\nis wrong or already existing\nplease enter another ID");
    }
}
