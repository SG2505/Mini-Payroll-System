/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.mini.payroll;


/**
 *
 * @author oem
 */
public class Engineer extends Employee {
    private int workinghours;
    private Grade grade;
    private String Position ;

    
    Admin admin=new Admin();


    public Engineer(int workinghours, Grade x, int ID, String name, int age) {
        super(ID, name, age);
        this.workinghours = workinghours;
        this.grade = x;
        this.salary=(admin.calculateSalary(this));
        Position = grade.getPosition();
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getWorkinghours() {
        return workinghours;
    }

    public void setWorkinghours(int workinghours) {
        this.workinghours = workinghours;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

     public String toString(){
        
        return ("name: "+ getName() +"\t\t"+"ID: "+getID()+"\t\t"+"Age: "
                +getAge()+"\t\t"+"Working hours: "+workinghours+"\t\t"+"Grade: "
                +grade.getPosition()+"\t\t"+"Pay rate: "+grade.getPayRate()+"\t\t"+"Tax rate: "+
                grade.getTaxRate()+"\t\t"+"Salary: "+getSalary()+"\t     " + "How Paid: " + howPaid());
        
    }

    public String getPosition() {
        return grade.getPosition();
    }

    public void setPosition(String position) {
        Position = position;
    }

    public String howPaid() {
        return "Paid Semi Monthly through Bank Account";
    }
}
            
    
    

