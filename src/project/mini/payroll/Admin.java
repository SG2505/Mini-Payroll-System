/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package project.mini.payroll;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class Admin {
    static ArrayList <Engineer> engineersList= new ArrayList<>();
    static ArrayList <Trainee> traineesList= new ArrayList<>();
    final static private String username = "Admin";
    final static private String password = "Admin";

    public Admin() {
    }
    
    
    
 public static String getUsername(){
 return username;
 }
 public static String getPassword(){
     return password;
 }
    
 
    public void addEngineer(int workinghours, Grade x, int ID, String name, int age)
            throws NumberFormatException, AgeException,IDException, WorkingHoursException, emptystringexception,intstringexception {
       if(age<18 || age>70)
            throw new AgeException(age);
        else if (searchEngineer(ID)!=null || ID<0)
            throw new IDException(ID);
        else if(workinghours<0)
            throw new WorkingHoursException(workinghours);

        try{
            check(name);
            engineersList.add(new Engineer(workinghours,x,ID,name,age));}
        catch(NullPointerException npe){
            throw npe;
        }
        catch(emptystringexception e){
            throw e;
        }
        catch(intstringexception e){
            throw e;
        }
        catch (NumberFormatException e){
            throw e;
        }
    }

    public String deleteEngineer (int ID){
        if (searchEngineer(ID)!=null){
            
            engineersList.remove(searchEngineer(ID));
            return "engineer deleted";
   
        }
        else return"engineer not found";
        
    }
    public void editEngineer(int ID,char x, String edit) throws NumberFormatException, emptystringexception,
            intstringexception,IDException, AgeException, WorkingHoursException{
         if (searchEngineer(ID)!=null){
         try {
             checkEdit(edit);
             Engineer eng = searchEngineer(ID);
             if ((eng.getID()) == ID) {
                 if (x == 'N' || x == 'n') {
                     check(edit);
                     eng.setName(edit);
                 } else if (x == 'I' || x == 'i') {
                     if(searchEngineer(Integer.parseInt(edit)) == null )
                     eng.setID(Integer.parseInt(edit));
                     else throw new IDException(Integer.parseInt(edit));
                 } else if (x == 'A' || x == 'a') {
                     if(Integer.parseInt(edit)<18 || Integer.parseInt(edit)>70)
                         throw new AgeException(Integer.parseInt(edit));
                     else eng.setAge(Integer.parseInt(edit));
                 } else if (x == 'H' || x == 'h') {
                     if(Integer.parseInt(edit)<0)
                         throw new WorkingHoursException(Integer.parseInt(edit));
                     else{
                     eng.setWorkinghours(Integer.parseInt(edit));
                     eng.setSalary(calculateSalary(eng));}
                 } else if (x == 'G' || x == 'g') {
                     if (edit.equalsIgnoreCase("Manager")) {
                         eng.setGrade(Grade.Manager);
                         eng.setSalary(calculateSalary(searchEngineer(ID)));
                     } else if (edit.equalsIgnoreCase("Team Leader")) {
                         eng.setGrade(Grade.TeamLeader);
                         eng.setSalary(calculateSalary(searchEngineer(ID)));
                     } else if (edit.equalsIgnoreCase("Team Member")) {
                         eng.setGrade(Grade.TeamMember);
                         eng.setSalary(calculateSalary(searchEngineer(ID)));
                     }

                 }
             }


         }catch (emptystringexception ese){
             throw ese;
         }
         catch (intstringexception e){
             throw e;
         }
         catch (AgeException e){
             throw e;
         }
         catch(WorkingHoursException e){
             throw e;
         }
         catch (NullPointerException e){
             throw e;
         }
         }
         else{throw new IDException(ID);
              }
       
                    
    }
   

    public static ArrayList viewEngineer (){
        return engineersList;
        
    }
    public void addTrainee(String name,int ID, int age,String uniName,double GPA, int academicYear)
            throws NumberFormatException,IDException, AgeException,GPAException,AcademicYearException,intstringexception,emptystringexception{
        if(age<18 || age>30)
            throw new AgeException(age);
        else if (searchTrainee(ID)!=null || ID<0 )
            throw new IDException(ID);
        else if(GPA<0 || GPA>4)
            throw new GPAException(GPA);
        else if (academicYear<1 || academicYear>5)
            throw new AcademicYearException(academicYear);
        try{
            check(name);
            check(uniName);
            traineesList.add(new Trainee(uniName,GPA,academicYear,ID,name,age));
        }
        catch(intstringexception e){
            throw e;
        }
        catch(emptystringexception e){
            throw  e;
        }
        catch (NumberFormatException e){
            throw e;
        }

    }
    public String deleteTrainee (int ID){
        if (searchTrainee(ID)!=null){
            Trainee trn = searchTrainee(ID);
            traineesList.remove(trn);
            return "Trainee deleted";
   
        }
        else return"Trainee not found";
        
        
              
        }
    
    public void editTrainee (int ID,char x,String edit) throws NumberFormatException, emptystringexception,
             IDException, intstringexception, GPAException, AgeException, AcademicYearException{
        if (searchTrainee(ID)!=null) {
            try {
                checkEdit(edit);
                Trainee trn = searchTrainee(ID);
                if ((trn.getID()) == ID) {
                    if (x == 'N' || x == 'n') {
                        check(edit);
                        trn.setName(edit);
                    } else if (x == 'I' || x == 'i') {
                        if(searchTrainee(Integer.parseInt(edit)) == null )
                        trn.setID(Integer.parseInt(edit));
                        else throw new IDException(Integer.parseInt(edit));
                    } else if (x == 'A' || x == 'a') {
                        if(Integer.parseInt(edit)<18 || Integer.parseInt(edit)>30)
                            throw new AgeException(Integer.parseInt(edit));
                        trn.setAge(Integer.parseInt(edit));
                    } else if (x == 'G' || x == 'g') {
                        if(Float.parseFloat(edit)<0 || Float.parseFloat(edit)>4)
                            throw new GPAException(Float.parseFloat(edit));
                        else trn.setGPA(Float.parseFloat(edit));
                    } else if (x == 'U' || x == 'u') {
                        check(edit);
                        trn.setUniName(edit);
                    } else if (x == 'Y' || x == 'y') {
                        if (Integer.parseInt(edit)<1 || Integer.parseInt(edit)>5)
                            throw new AcademicYearException(Integer.parseInt(edit));
                        else trn.setAcademicYear(Integer.parseInt(edit));
                    }

                }

            } catch(emptystringexception e){
                throw e;
            }
            catch (intstringexception e){
                throw e;
            }
            catch (GPAException e){
                throw e;
            }
            catch (AgeException e){
                throw e;
            }
            catch (AcademicYearException e){
                throw e;
            }

        }

    }

    public ArrayList viewTrainee (){
        return traineesList;
        
    }

    public Engineer searchEngineer(int id){
    for(int i=0;i<engineersList.size();i++){
        if((engineersList.get(i).getID())== id) {
            return (engineersList.get(i));
        }

    }
     return null;
    }

    public Trainee searchTrainee(int id){
        for(int i=0;i<traineesList.size();i++){
            if((traineesList.get(i).getID())== id) {
                return (traineesList.get(i)) ;
            }
         
        }
        return null;
    }
    public double calculateSalary(char x,int ID){
            
            if ((x=='T'||x=='t')&&searchTrainee(ID)!=null){
                return (searchTrainee(ID).getSalary());
            }
            else if ((x=='E'||x=='e')&&searchEngineer(ID)!=null){
               return (calculateSalary(searchEngineer(ID)));
            }
            return -1;
    
}
    public double calculateSalary(Engineer eng){
  
            if(eng.getGrade().getPosition().equals("Manager")){
                return (eng.getGrade().getPayRate()*(1-(eng.getGrade().getTaxRate()))*(eng.getWorkinghours()));
                
            }
            else if(eng.getGrade().getPosition().equals("TeamLeader")){
                return (eng.getGrade().getPayRate()*(1-(eng.getGrade().getTaxRate()))*(eng.getWorkinghours()));
                
            }
            else if(eng.getGrade().getPosition().equals("TeamMember")){
                 return (eng.getGrade().getPayRate()*(1-(eng.getGrade().getTaxRate()))*(eng.getWorkinghours()));
                 
            }
             else
                return -1;
    }
   public void check(String x) throws intstringexception,emptystringexception{
        char [] arr= x.toCharArray();
        boolean y;
        for(int i=0;i<arr.length;i++){
            if(Character.isDigit(arr[i])){
                throw new intstringexception();
            }
        }
        if(arr.length==0){
            throw new emptystringexception();
        }
   }
    public void checkEdit(String x) throws emptystringexception{
        char [] arr= x.toCharArray();


        if(arr.length==0){
            throw new emptystringexception();
        }
    }

}
 

