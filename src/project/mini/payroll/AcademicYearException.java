package project.mini.payroll;

public class AcademicYearException extends Exception {
    public AcademicYearException(int academicYear) {
        super("Academic Year entered: "+academicYear+"\nis wrong Please enter\na correct academic year.");
    }
}
