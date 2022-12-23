/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.mini.payroll;

/**
 *
 * @author oem
 */
public abstract class Employee {
    private int id;
    private String name;
    private int age;
    protected double salary;

    public Employee(int ID, String name, int age) {
        this.id = ID;
        this.name = name;
        this.age = age;
    }

    
    public Employee() {
    }

    public int getID() {
        return id;
    }

    public void setID(int ID) {
        this.id = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
   public abstract String howPaid();
    
}
