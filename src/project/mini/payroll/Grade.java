/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.mini.payroll;

/**
 *
 * @author oem
 */
public enum Grade {
    Manager ("Manager",0.17,50),
    TeamLeader("TeamLeader",0.14,40),
    TeamMember("TeamMember",0.12,32);
    
    private final String Position;
    private final double taxRate;
    private final double payRate;

    private Grade(String Position, double taxRate, double payRate) {
        this.Position = Position;
        this.taxRate = taxRate;
        this.payRate = payRate;
    }

    public String getPosition() {
        return Position;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public double getPayRate() {
        return payRate;
    }
    

    
}
