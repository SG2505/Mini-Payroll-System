/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.mini.payroll;

import java.text.DecimalFormat;

/**
 *
 * @author oem
 */
public class Trainee extends Employee{
    private static final DecimalFormat df = new DecimalFormat("0.00");
    private String uniName;
    private double GPA;
    private int academicYear;
    private static final int salary =2000;

    public Trainee(String uniName, double GPA, int academicYear, int ID, String name, int age) {
        super(ID, name, age);
        this.uniName = uniName;
        this.GPA = GPA;
        this.academicYear = academicYear;
        setSalary(salary);
        
    }

    public Trainee() {
    }
    

    
    public String getUniName() {
        return uniName;
    }

    public void setUniName(String uniName) {
        this.uniName = uniName;
    }

    public double getGPA() {
        return Double.parseDouble(df.format(GPA));
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public int getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(int academicYear) {
        this.academicYear = academicYear;
    }

    @Override
    public String toString(){

        return ("name: "+ getName() +"\t\t"+"ID: "+getID()+"\t\t"+"Age: "
                +getAge()+"\t\t"+"University: "+ getUniName()+"\t\tAcademic Year: "
                + getAcademicYear()+"\t\tGPA: "+getGPA()+"\t\tSalary: "+getSalary()+ "\t    " + "How Paid: "+ howPaid());

    }
    public  String howPaid(){
        return "Paid monthly by Cash";
    }
}
