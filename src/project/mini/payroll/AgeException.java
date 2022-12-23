package project.mini.payroll;

public class AgeException extends Exception{

   public AgeException(int age){
       super("Age entered: "+ age +"\nis wrong, please enter\na reliable age");
   }
}
