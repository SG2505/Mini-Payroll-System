package project.mini.payroll;
import java.util.*;

public class ProjectMiniPayroll {
// Username: Admin
// Password: Admin
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Admin admin1 = new Admin();
        Scanner input = new Scanner(System.in);
        System.out.println("please enter username & password");
        String username = input.nextLine();
        String password = input.nextLine();

        admin1.addEngineer(160, Grade.TeamLeader, 20031, "Etsh", 25);
        admin1.addEngineer(160, Grade.TeamLeader, 2002, "Sala", 29);
        admin1.addEngineer(150, Grade.TeamMember, 2003, "Ziecho", 30);
        admin1.addEngineer(150, Grade.Manager, 2086, "Seif", 27);
        admin1.addEngineer(150, Grade.Manager, 2112, "Nagy", 28);
        admin1.addTrainee("Morgan", 12345, 18, "AUC", 3.2, 3);
        admin1.addTrainee("Hadras", 54321, 19, "ASU", 3.4, 4);

        if (username.equals(Admin.getUsername()) && password.equals(Admin.getPassword())) {

            String name, universityName, option, position, option1, position1 , edit;
            char type;
            int id, age, academicYear, workingHours;
            float gpa;
            Grade grade;
            String z;
            Scanner x = new Scanner(System.in);

            do {

                System.out.println("Enter ae to add engineer");
                System.out.println("Enter at to add trainee");
                System.out.println("Enter ee to edit engineer");
                System.out.println("Enter et to edit trainee");
                System.out.println("Enter re to remove engineer");
                System.out.println("Enter rt to remove trainee");
                System.out.println("Enter de to display all engineers");
                System.out.println("Enter dt to display all trainees");
                System.out.println("Enter cs to calculate salary for an employee");

                option = x.next();

                option1 = option.toLowerCase();


                switch (option1) {

                    case "ae":
                        System.out.println("enter engineer name");
                        name = x.next();

                        System.out.println("enter engineer id");
                        id = x.nextInt();

                        System.out.println("enter engineer age");
                        age = x.nextInt();
                        //x.nextLine();
                        System.out.println("enter engineer position");
                        position = x.nextLine();
                        position += x.nextLine();
                        position1 = position.toLowerCase();

                        if (position1.equals("manager")) {
                            grade = Grade.Manager;
                        } else if (position1.equals("team leader")) {
                            grade = Grade.TeamLeader;
                        } else if(position1.equals("team member"))
                            grade = Grade.TeamMember;
                        else
                            grade = null;

                        System.out.println("enter engineer work hours");
                        workingHours = x.nextInt();

                        admin1.addEngineer(workingHours, grade, id, name, age);
                        System.out.println("Engineer added");
                        break;

                    case "at":
                        System.out.println("enter trainee name");
                        name = x.next();

                        System.out.println("enter trainee id");
                        id = x.nextInt();

                        System.out.println("enter trainee age");
                        age = x.nextInt();

                        System.out.println("enter trainee university name");
                        universityName = x.next();

                        System.out.println("enter trainee gpa");
                        gpa = x.nextFloat();

                        System.out.println("enter trainee academic year");
                        academicYear = x.nextInt();


                        admin1.addTrainee(name, id, age, universityName, gpa, academicYear);
                        System.out.println("Trainee added");
                        break;

                    case "re" :
                        System.out.println("enter id of engineer you want to remove");
                        id = x.nextInt();
                        System.out.println(admin1.deleteEngineer(id));
                        break;

                    case "rt" :
                        System.out.println("enter id of Trainee you want to remove");
                        id = x.nextInt();
                        System.out.println(admin1.deleteTrainee(id));
                        break;
                    case "de":
                        for (int i =0 ; i< (admin1.viewEngineer().size()) ; i++)
                        {
                            System.out.println(admin1.viewEngineer().get(i));
                        }
                        break;
                    case "dt" :
                        for (int i =0 ; i< admin1.viewTrainee().size() ; i++)
                        {
                            System.out.println(admin1.viewTrainee().get(i));
                        }
                        break;
                    case "ee" :
                        System.out.println("enter current id of engineer");
                        id=x.nextInt();
                        System.out.println("enter i to change id \n enter n to change name \n enter a to change age \n enter h to change working hours \n enter g to change grade");
                        type = x.next().charAt(0);
                        System.out.println("enter new data");
                        edit = x.next();
                        //System.out.println(admin1.editEngineer(id,type,edit));
                        break;
                    case"et":
                        System.out.println("enter current id of trainee");
                        id=x.nextInt();
                        System.out.println("enter i to change id \n enter n to change name \n enter a to change age \n enter u to change university name  \n enter g to change GPA \n enter y to change academic year");
                        type = x.next().charAt(0);
                        System.out.println("enter new data");
                        edit = x.next();
                        admin1.editTrainee(id,type,edit);
                        System.out.println("Trainee edited");
                        break;
                    case "cs":
                        System.out.println("enter T if you want to calculate trainee salary \nenter enter E if you want to calculate engineer salary\n");
                        type = x.next().charAt(0);
                        System.out.println("enter the id to calculate salary for this employee" );
                        id=x.nextInt();
                        System.out.println(admin1.calculateSalary(type,id));
                        break;
                    default: System.out.println("entered wrong characters");

                }


                System.out.println("enter 'c' to go to menu or enter 'end' to close program");
                z = x.next();
                z=z.toLowerCase();
            }
            while (!(z.equals("end"))) ;

        }
        else
            System.out.println("wrong username & password");
        }

    }

    


